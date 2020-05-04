INSERT INTO departments (name, adress) VALUES
	('Сбербанк Сходненская', 'г. Москва, ул. Свободы, 55'),
	('Московский банк. Сбербанк', 'г. Москва, ул. Вавилова, 19'),
	('Среднерусский банк. Сбербанк', 'г. Москва, ул. Большая Андроньевская, д. 8'),
	('Сбербанк. Дополнительный офис', 'г. Москва, ул. Просторная, 8'),
	('Сбербанк Алтуфьево', 'г. Москва, ул. Череповецкая, 20');

INSERT INTO types_of_account (name, yield, interval, max_credit, max_debit) VALUES
	('LIGHT', 4.1, 360, 10000, 10000),
	('LIGHT', 4.5, 720, 20000, 20000),
	('COMMON', 5.8, 360, 50000, 0),
	('COMMON', 6.1, 720, 100000, 0),
	('STRICT', 7.6, 360, 0, 0),
	('STRICT', 7.9, 1080, 0, 0),
	('RELIABLE', 6.5, 1080, 40000, 0),
	('RELIABLE', 6.7, 1800, 80000, 0),
	('CORPORATE', 3, 360, 1000000, 1000000);

INSERT INTO customers (type, name, date_of_registration) VALUES
	('INDIVIDUAL', 'Шевцов Анатолий Спенанович', '2018-11-05 13:08:45'),
	('INDIVIDUAL', 'Борисова Ольга Андреевна', '2017-02-24 09:56:54'),
	('INDIVIDUAL', 'Акимов Никита Александрович', '2019-07-11 13:00:18'),
	('ORGANIZATION', 'ООО "Каршеринг Орбита"', '2013-12-04 08:11:01'),
	('ORGANIZATION', 'Магазин одежды "Семья"', '2018-06-12 11:47:21');

INSERT INTO contacts (customer_id, name, surname, adress, phone_number, "email") VALUES
	(1, 'Анатолий', 'Шевцов', 'Стандартная ул д. 21, корп.1, Москва', '89032344421', 'anatol_shev@gmail.com'),
	(2, 'Ольга', 'Борисова', 'г. Москва, ул. Вавилова, 3', '+79005678901', 'borisova1@mail.ru'),
	(3, 'Никита', 'Акимов', 'г. Москва,  Цветной бульвар д. 13, корп.3', '8(965)112-37-72', 'akimoww@gmail.com'),
	(4, 'Сергей', 'Резцов', 'г. Москва, ул. Лихачева, 32/11', '+7 909 565 35 35', 'orbita_info@gmail.com'),
	(4, 'Илья', 'Бекетов', 'г. Москва, ул. Первого мая, 1', '+7 999 100 11 12', 'orbita_info@gmail.com'),
	(5, 'Станислав', 'Титов', 'г. Москва, Минское шоссе, д.18, к. 4', '89031217887', 'family_shop@yandex.ru');

INSERT INTO accounts ("number", customer_id, balance, type_id, interest_account, department_id, date_of_start) VALUES
	('9008007001', 1, 11050, 2, 1, 1, '2018-11-05 13:09:20'),
	('9008007002', 1, 20450, 3, 2, 1, '2018-11-05 13:20:44'),
	('9008007003', 1, 87967, 6, 3, 1, '2018-11-05 13:22:18'),
	('9008007004', 2, 13000, 1, 4, 2, '2017-02-25 22:08:45'),
	('9008007005', 3, 2745, 1, 5, 3, '2020-02-05 16:43:01'),
	('9008007006', 3, 18000, 3, 5, 3, '2020-02-05 16:58:45'),
	('9008007007', 4, 1000000, 9, 8, 4, '2015-09-03 10:30:00'),
	('9008007008', 4, 450000, 4, 8, 4, '2014-01-30 17:10:22'),
	('9008007009', 5, 120000, 8, 9, 5, '2018-06-12 11:47:22');

INSERT INTO operations (account_id, operation, amount, "date") VALUES
	(1, 'CREDIT', 10000, '2019-11-05 13:09:29'),
	(1, 'CREDIT', 2000, '2019-11-05 13:09:50'),
	(4, 'DEBIT', 500, '2019-03-05 18:29:44'),
	(5, 'DEBIT', 180, '2020-02-07 23:35:56'),
	(6, 'CREDIT', 21000, '2020-02-06 01:23:34'),
	(9, 'CREDIT', 10000, '2020-02-21 06:32:03');