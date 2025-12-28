-- Тестовые данные для проверки API
INSERT INTO universities (id, name, city, thumbnail, university) VALUES 
(1, 'МГУ им. М.В. Ломоносова', 'Москва', 'mgu.jpg', 'MSU'),
(2, 'МФТИ', 'Долгопрудный', 'mipt.jpg', 'MIPT');

INSERT INTO departments (id, name, university_id) VALUES 
(1, 'Факультет ВМК', 1),
(2, 'Механико-математический факультет', 1),
(3, 'Факультет общей и прикладной физики', 2);

INSERT INTO tags (id, name) VALUES 
(1, 'Математика'),
(2, 'Программирование'),
(3, 'Физика');

INSERT INTO teachers (id, full_name, thumbnail, full_photo_path) VALUES 
(1, 'Иванов Иван Иванович', 'ivanov_thumb.jpg', 'ivanov_full.jpg'),
(2, 'Петрова Анна Сергеевна', 'petrova_thumb.jpg', 'petrova_full.jpg'),
(3, 'Сидоров Петр Александрович', 'sidorov_thumb.jpg', 'sidorov_full.jpg');

INSERT INTO teacher_department (teacher_id, department_id) VALUES 
(1, 1), (1, 2),
(2, 1),
(3, 3);

INSERT INTO teacher_tag (teacher_id, tag_id) VALUES 
(1, 1), (1, 2),
(2, 2),
(3, 3);

INSERT INTO users (id, name, university) VALUES 
(1, 'Студент Иван', 'МГУ'),
(2, 'Студентка Мария', 'МГУ'),
(3, 'Студент Алексей', 'МФТИ');

INSERT INTO reviews (id, text, rate, author_id, teacher_id, total_likes, total_dislikes) VALUES 
(1, 'Отличный преподаватель! Объясняет очень понятно.', 5, 1, 1, 10, 1),
(2, 'Хороший лектор, но строгий на экзаменах.', 4, 2, 1, 5, 2),
(3, 'Интересные лекции по программированию.', 5, 1, 2, 8, 0),
(4, 'Сложно понять материал, нужно больше примеров.', 3, 3, 3, 2, 5);