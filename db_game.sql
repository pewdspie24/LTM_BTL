CREATE DATABASE db_game;
USE db_game;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `content` varchar(256) NOT NULL,
  `answer1` varchar(50) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `answer4` varchar(50) NOT NULL,
  `key` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `questions` (`id`, `content`, `answer1`, `answer2`, `answer3`, `answer4`, `key`) VALUES
(1,'x>0 => |x|=?','x','-x','0','2x','x'),
(2,'|-5|=?','-5','0','5','25','5'),
(3,'5^2','5','2','25','2.5','25'),
(4,'3+5','2','15','3','8','8'),
(5,'7+8*(6-4-2)','0','7','56','15','0'),
(6,'5 * (9 - 6 - 3) ... 6 / 3 - 2','=','>','<','#','='),
(7,'x + 5 = 6 * 7 => x = ?','47','42','37','0','37'),
(8,'4, 6, 8, ..., 12','10','2','14','0','10'),
(9,'2 / 2 * 2 + 2 - 2','2','4','1','8','2'),
(10,'|-7| / |7|','-7','-1','7','1','1'),
(11,'20 * 2 / 10','40','50','4','30','4'),
(12,'36 / 2 + 5 * 4','18','92','38','20','38'),
(13,'3 + 3 + 3 + 3 = 3 * ...','3','4','5','1','4'),
(14,'(5 + 7 - 8 * 2) * (9 / 9 - 1)','-4','-5','0','8','0'),
(15,'2 ^ 2 * 2','8','16','4','6','8'),
(16,'9x = 81 => 4x = ?','9','72','36','20','36'),
(17,'7 + 7 + 7','7 ^ 3','7 * 3','7','7 + 3','7 * 3'),
(18,'2, 3, 5, 7, 11,...,17','15','14','13','12','13'),
(19,'2 + 6 ... 9','<','>','=','>=','<'),
(20,'0 * ( 9 / 7 + 6 + 5 - 2) - 1','0','-1','11','1','-1'),
(21,'2 ^ 3 ... 3 ^ 2','>','<','=','>=','<'),
(22,'(3 + 7) / (5 * 2)','10','20','1','0','1'),
(23,'6 / 3 + 5 * 4','22','28','2','20','22'),
(24,'10 ^ 2','10','100','12','20','100');

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `scores` double NOT NULL,
  `matches` int(10) NOT NULL,
  `win` int(11) NOT NULL,
  `time` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `history` (
  `id` int(11) NOT NULL,
  `username1` varchar(50) NOT NULL,
  `username2` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `timestamp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `history`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

ALTER TABLE `history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
