# Prepovedia - Система рейтинга преподавателей

## Описание проекта

Prepovedia - это REST API для системы рейтинга и отзывов о преподавателях университетов. Пользователи могут просматривать информацию о преподавателях, их отзывы и оценки.

## Архитектура проекта

### Технологический стек

- **Kotlin** - основной язык разработки
- **Spring Boot 4.0.1** - фреймворк для создания REST API
- **Spring Data JPA** - для работы с базой данных
- **PostgreSQL** - основная база данных
- **Docker Compose** - для контейнеризации БД
- **Gradle** - система сборки

### Архитектурные решения

#### 1. Многослойная архитектура (Layered Architecture)

```
Controller → Service → DAO → Database
     ↓         ↓       ↓
   DTO ←   Mapper ← Entity
```

**Обоснование выбора:**
- **Разделение ответственности** - каждый слой решает свою задачу
- **Тестируемость** - легко мокать зависимости между слоями
- **Масштабируемость** - можно независимо изменять каждый слой

#### 2. Entity как Data Classes

```kotlin
@Entity
@Table(name = "teachers")
data class Teacher(
    val fullName: String = "",
    val thumbnail: String? = null,
    val fullPhotoPath: String? = null
) : AbstractEntity()
```

**Обоснование:**
- **Immutability** - data классы неизменяемы по умолчанию
- **Автогенерация методов** - equals(), hashCode(), toString()
- **Читаемость кода** - компактный и понятный синтаксис

#### 3. Разделение DTO на типы

- **TeacherDto** - полная информация о преподавателе
- **LightTeacherDto** - облегченная версия для списков
- **ReviewDto** - информация об отзывах

**Обоснование:**
- **Производительность** - не загружаем лишние данные в списках
- **Гибкость API** - разные эндпоинты возвращают нужный объем данных
- **Безопасность** - скрываем внутренние поля Entity

#### 4. Система хранения изображений

```kotlin
val thumbnail: String? = null,        // Легковесные превью
val fullPhotoPath: String? = null     // Полноразмерные фото
```

**Обоснование:**
- **Производительность** - thumbnail для быстрой загрузки списков
- **Качество** - fullPhotoPath для детального просмотра
- **Масштабируемость** - пути к файлам, а не BLOB в БД

## Структура базы данных

### Основные сущности

1. **Teachers** - преподаватели
2. **Universities** - университеты  
3. **Departments** - кафедры/факультеты
4. **Reviews** - отзывы о преподавателях
5. **Users** - пользователи системы
6. **Tags** - теги/категории преподавателей
7. **Reactions** - реакции на отзывы (лайки/дизлайки)

### Ключевые связи

- **Many-to-Many**: Teacher ↔ Department (преподаватель может работать на нескольких кафедрах)
- **Many-to-Many**: Teacher ↔ Tag (преподаватель может иметь несколько специализаций)
- **One-to-Many**: Teacher → Review (у преподавателя много отзывов)
- **One-to-Many**: University → Department (в университете много кафедр)

## Текущая функциональность

### API Endpoints

#### Преподаватели
- `GET /teachers` - список всех преподавателей (LightTeacherDto)
- `GET /teachers/{id}` - детальная информация о преподавателе
- `GET /teachers/{id}/reviews` - отзывы о преподавателе

### Реализованные компоненты

#### 1. Data Access Layer (DAO)
```kotlin
interface TeacherDao : AbstractDao<Teacher> {
    fun findByUniversityId(universityId: Long): List<Teacher>
    fun findByDepartmentId(departmentId: Long): List<Teacher>
}
```

#### 2. Service Layer
```kotlin
@Service
class TeacherServiceImpl : TeacherService {
    fun getAllTeachers(): List<LightTeacherDto>
    fun getTeacherById(id: Long): TeacherDto?
    fun getTeacherReviews(teacherId: Long): List<ReviewDto>
}
```

#### 3. Mappers
- **TeacherMapper** - преобразование Teacher → DTO
- **ReviewMapper** - преобразование Review → ReviewDto
- **DepartmentMapper** - преобразование Department → DepartmentDto

## Запуск проекта

### Предварительные требования
- Java 21
- Docker и Docker Compose

### Шаги запуска

1. **Запуск базы данных:**
```bash
docker-compose up -d
```

2. **Запуск приложения:**
```bash
./gradlew bootRun
```

3. **Тестирование API:**
```bash
curl http://localhost:8080/teachers
curl http://localhost:8080/teachers/1
curl http://localhost:8080/teachers/1/reviews
```

### Доступ к pgAdmin
- URL: http://localhost:5050
- Email: user@user.com
- Password: 123

## Конфигурация

### База данных
- **Host:** localhost:5432
- **Database:** bot
- **User:** user
- **Password:** 123

### Особенности конфигурации

#### UTF-8 поддержка
```yaml
datasource:
  url: jdbc:postgresql://localhost:5432/bot?useUnicode=true&characterEncoding=UTF-8
```

#### Инициализация данных
```yaml
jpa:
  defer-datasource-initialization: true
sql:
  init:
    mode: always
```

**Обоснование:** `defer-datasource-initialization` гарантирует, что тестовые данные загружаются после создания таблиц Hibernate.

## Тестовые данные

Проект включает тестовые данные в `import.sql`:
- 2 университета (МГУ, МФТИ)
- 3 кафедры
- 3 преподавателя с тегами и привязками к кафедрам
- 3 пользователя
- 4 отзыва с оценками

## Планы развития

### Ближайшие задачи
1. Добавление эндпоинтов для поиска по университету/кафедре
2. Реализация системы аутентификации
3. CRUD операции для отзывов
4. Система загрузки изображений

### Архитектурные улучшения
1. Добавление кэширования (Redis)
2. Пагинация для больших списков
3. Валидация входных данных
4. Обработка ошибок и логирование

## Принципы разработки

1. **SOLID принципы** - каждый класс имеет единственную ответственность
2. **DRY** - переиспользование кода через наследование AbstractEntity
3. **Separation of Concerns** - четкое разделение слоев приложения
4. **Convention over Configuration** - использование Spring Boot автоконфигурации