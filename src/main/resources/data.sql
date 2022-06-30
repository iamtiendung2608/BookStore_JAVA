-- Insert Book Tag
INSERT INTO Tag (name,topic) VALUES ('Sách tâm lý','Sách dành cho những người đam mê tâm lý học')
INSERT INTO Tag (name,topic) VALUES ('Sách kinh dị','Sách dành cho những người thích tìm hiểu kinh dị và khám phá')
INSERT INTO Tag (name,topic) VALUES ('Sách trinh thám','Sách dành cho những người đam mê tìm hiểu và trinh thám')
INSERT INTO Tag (name,topic) VALUES ('Truyện tranh','Sách dành cho thiếu nhi')
INSERT INTO Tag (name,topic) VALUES ('Sách về sức khỏe','Sách dành cho những người có nhu cầu quan tâm về sức khỏe')


-- Insert Book

INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Bí Mật Dinh Dưỡng Cho Sức Khỏe Toàn Diện',263000,'Thomas M. Campbell II, T. Colin Campbell','https://salt.tikicdn.com/cache/200x200/ts/product/7b/ec/9c/984e27c29c929b6f4996eaa3e529b703.jpg',1,'VALUE')
INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Chọn Sức Khỏe, Chọn Organic!',224000,'Maria Rodale','https://salt.tikicdn.com/cache/200x200/ts/product/95/ea/85/67c7f79672e98aa92f978783b90122a3.jpg',2,'')
INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Dinh Dưỡng - Chìa Khóa Vàng Cho Sức Khỏe',58000,'Dr Darwin Deen','https://salt.tikicdn.com/cache/200x200/ts/product/77/80/6a/8fbaa3fa91c3cc7a7f42dc3b609fb5f7.jpg',4,'')

INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Hoàng Tử Bé (Tái Bản 2019)',45000,'Antoine De Saint-Exupéry','https://salt.tikicdn.com/cache/400x400/ts/product/5c/e7/68/26838e18d7f96d562d828980520019d2.jpg',2,'')
INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Chú Bé Mang Pyjama Sọc',40000,'John Boyne','https://salt.tikicdn.com/cache/400x400/ts/product/19/4f/27/99b31589a12ac561e769081c4eb32d1f.jpg.webp',3,'')
INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Gấu Pooh Xinh Xắn',58500,'Ernest H.Shepard, A.A.Milne','https://salt.tikicdn.com/cache/400x400/ts/product/10/81/03/df0f446352a84745559c241589b282e4.jpg.webp',2,'')

INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Cuộc Diễu Hành Thầm Lặng',128700,'Higashino Keigo','https://salt.tikicdn.com/cache/400x400/ts/product/28/81/a2/3814b33a6cd24f60c4ccb441b4919ec8.jpg.webp',3,'')
INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Vén Màn Bí Mật - Here To Stay',83850,'Mark Edwards','https://salt.tikicdn.com/cache/400x400/ts/product/a2/88/bb/0ae3653eca3d6d2aa848cd1202503f75.jpg.webp',1,'')

INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Tạo Dựng Thương Hiệu Cá Nhân',54050,'Yamamoto Hideyuki','https://salt.tikicdn.com/cache/400x400/ts/product/89/92/9e/65e9018513f88d337fc4ad6feac86475.jpg.webp',2,'')
INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Đọc Vị Bất Kỳ Ai (Tái Bản)',59000,'TS. David J. Lieberman','https://salt.tikicdn.com/cache/400x400/ts/product/a5/d8/34/841d0260cc305115f6753c25caadd5b0.jpg.webp',1,'')
INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Người Nam Châm (Tái Bản 2019)',43550,'Jack Canfield & DD.Watkins','https://salt.tikicdn.com/cache/400x400/ts/product/0f/2b/f4/6ada8869a4ea8cfd557729253324c3fb.jpg.webp',4,'')
INSERT INTO Book(name, price, author, image, tag_id,DESCRIBE) VALUES('Khéo Ăn Nói Sẽ Có Được Thiên Hạ',75000,'Trác Nhã','https://salt.tikicdn.com/cache/400x400/ts/product/22/a9/48/c55f8c043e5ff5842aa15dc1f3b6c20f.jpg.webp',4,'')

--Insert to Order
INSERT INTO book_order(account_id, book_id, quantity ) VALUES (2,3,1)
INSERT INTO book_order(account_id, book_id, quantity ) VALUES (2,2,1)
INSERT INTO book_order(account_id, book_id, quantity ) VALUES (2,1,2)
INSERT INTO book_order(account_id, book_id, quantity ) VALUES (2,5,3)


