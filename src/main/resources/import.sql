-- Тестовые данные для проверки API
INSERT INTO universities (id, name, city, thumbnail, university, created_at) VALUES 
(1, 'МГУ им. М.В. Ломоносова', 'Москва', 'mgu.jpg', 'MSU', CURRENT_TIMESTAMP),
(2, 'МФТИ', 'Долгопрудный', 'mipt.jpg', 'MIPT', CURRENT_TIMESTAMP);

INSERT INTO departments (id, name, university_id, created_at) VALUES 
(1, 'Факультет ВМК', 1, CURRENT_TIMESTAMP),
(2, 'Механико-математический факультет', 1, CURRENT_TIMESTAMP),
(3, 'Факультет общей и прикладной физики', 2, CURRENT_TIMESTAMP);

INSERT INTO tags (id, name, created_at) VALUES 
(1, 'Математика', CURRENT_TIMESTAMP),
(2, 'Программирование', CURRENT_TIMESTAMP),
(3, 'Физика', CURRENT_TIMESTAMP);

INSERT INTO teachers (id, full_name, thumbnail, full_photo_path, created_at) VALUES 
(1, 'Иванов Иван Иванович', 'ivanov_thumb.jpg', 'ivanov_full.jpg', CURRENT_TIMESTAMP),
(2, 'Петрова Анна Сергеевна', 'petrova_thumb.jpg', 'petrova_full.jpg', CURRENT_TIMESTAMP),
(3, 'Сидоров Петр Александрович', 'sidorov_thumb.jpg', 'sidorov_full.jpg', CURRENT_TIMESTAMP);

INSERT INTO teacher_department (teacher_id, department_id) VALUES 
(1, 1), (1, 2),
(2, 1),
(3, 3);

INSERT INTO teacher_tag (teacher_id, tag_id) VALUES 
(1, 1), (1, 2),
(2, 2),
(3, 3);

INSERT INTO users (id, name, university, created_at) VALUES 
(1, 'Студент Иван', 'МГУ', CURRENT_TIMESTAMP),
(2, 'Студентка Мария', 'МГУ', CURRENT_TIMESTAMP),
(3, 'Студент Алексей', 'МФТИ', CURRENT_TIMESTAMP);

INSERT INTO reviews (id, text, rate, author_id, teacher_id, total_likes, total_dislikes, created_at) VALUES 
(1, 'Отличный преподаватель! Объясняет очень понятно.', 5, 1, 1, 10, 1, CURRENT_TIMESTAMP),
(2, 'Хороший лектор, но строгий на экзаменах.', 4, 2, 1, 5, 2, CURRENT_TIMESTAMP),
(3, 'Интересные лекции по программированию.', 5, 1, 2, 8, 0, CURRENT_TIMESTAMP),
(4, 'Сложно понять материал, нужно больше примеров.', 3, 3, 3, 2, 5, CURRENT_TIMESTAMP);