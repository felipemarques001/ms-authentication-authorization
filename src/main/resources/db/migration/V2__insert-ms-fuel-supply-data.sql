INSERT INTO tb_application(id, access_key, name) VALUES ('cfe2ffa5-f13a-40e7-b742-4c1a2adb5426', 'secretAccessKey', 'ms-fuel-supply');

INSERT INTO tb_group(id, name, application_id) VALUES
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', 'admin', 'cfe2ffa5-f13a-40e7-b742-4c1a2adb5426'),
('f00815db-6475-4100-a9e5-d3d3490b8bff', 'user', 'cfe2ffa5-f13a-40e7-b742-4c1a2adb5426');

INSERT INTO tb_permission(id, active, name) VALUES
('1e6333fb-e656-4cb1-a7bb-ead8ee5664bb', true, 'read-supply'),
('1e87cc8f-d7f2-466b-86ef-24cf8d5183db', true, 'create-gas-station'),
('23091531-bb35-4df8-9742-52796e879ea9', true, 'delete-supply'),
('2a493683-f7cb-442d-af74-6120ca62e529', true, 'create-vehicle'),
('5a6eaff3-21ba-4e0f-833c-60a6ed59cc96', true, 'read-vehicle'),
('665c0c99-69bd-4a7e-bffe-1e09d7de254a', true, 'delete-vehicle'),
('708a7262-2486-4f42-b249-33626c42db64', true, 'create-user'),
('9fdeb715-41ce-4bc3-95d5-5e28ee25b2c7', true, 'read-gas-station'),
('a38001a0-f9f2-4ffd-b0a2-ec0f88401d98', true, 'create-supply'),
('b689a64c-32b4-4892-afe1-00e68d72ca33', true, 'delete-gas-station'),
('c8499707-5fd9-4065-95e1-52ca6e924a48', true, 'update-vehicle'),
('dffa9242-66eb-42ab-af6a-f6f677acf0da', true, 'update-gas-station'),
('eb20c18c-68c4-4389-933e-d24f65438f5b', true, 'update-supply');

INSERT INTO tb_group_permission(group_id, permission_id) VALUES
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', '9fdeb715-41ce-4bc3-95d5-5e28ee25b2c7'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', '1e87cc8f-d7f2-466b-86ef-24cf8d5183db'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', 'b689a64c-32b4-4892-afe1-00e68d72ca33'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', 'dffa9242-66eb-42ab-af6a-f6f677acf0da'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', '5a6eaff3-21ba-4e0f-833c-60a6ed59cc96'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', '2a493683-f7cb-442d-af74-6120ca62e529'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', '665c0c99-69bd-4a7e-bffe-1e09d7de254a'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', 'c8499707-5fd9-4065-95e1-52ca6e924a48'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', '1e6333fb-e656-4cb1-a7bb-ead8ee5664bb'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', 'a38001a0-f9f2-4ffd-b0a2-ec0f88401d98'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', '23091531-bb35-4df8-9742-52796e879ea9'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', 'eb20c18c-68c4-4389-933e-d24f65438f5b'),
('7aa1d7f3-3aea-4d95-8685-6893c22f7b2b', '708a7262-2486-4f42-b249-33626c42db64'),
('f00815db-6475-4100-a9e5-d3d3490b8bff', '9fdeb715-41ce-4bc3-95d5-5e28ee25b2c7'),
('f00815db-6475-4100-a9e5-d3d3490b8bff', '5a6eaff3-21ba-4e0f-833c-60a6ed59cc96'),
('f00815db-6475-4100-a9e5-d3d3490b8bff', '1e6333fb-e656-4cb1-a7bb-ead8ee5664bb'),
('f00815db-6475-4100-a9e5-d3d3490b8bff', 'a38001a0-f9f2-4ffd-b0a2-ec0f88401d98');

INSERT INTO tb_user(id, name, password, username, application_id) VALUES
('429b8ea0-d1d3-4260-898a-384245d28f18', 'Héldon José', '$2y$10$b.AhgppR7I/SIVfHh385sewW2BsLziZBFPOw53XHR4hezvQzLZtLC', 'heldonadmin', 'cfe2ffa5-f13a-40e7-b742-4c1a2adb5426'),
('60531b39-f8ee-4cb8-b0ca-1832f318987d', 'Felipe Marques', '$2a$10$fBptHkj9K2OLvwGUGiSVk.2z2DSuZoUX6nnrsF7D63PC3Wzs1tS9i', 'felipegg1234', 'cfe2ffa5-f13a-40e7-b742-4c1a2adb5426');

INSERT INTO tb_user_group(user_id, group_id) VALUES
('429b8ea0-d1d3-4260-898a-384245d28f18', '7aa1d7f3-3aea-4d95-8685-6893c22f7b2b'),
('60531b39-f8ee-4cb8-b0ca-1832f318987d', 'f00815db-6475-4100-a9e5-d3d3490b8bff');
