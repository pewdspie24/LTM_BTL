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
(1, '1 + 1', '1', '2', '3', '4', '2'),
(2, '1 + 2', '1', '2', '3', '4', '3'),
(3, '1 + 4', '5', '2', '3', '4', '5'),
(4, '2 + 7', '9', '2', '3', '52', '9'),
(5, '1 - 8', '1', '-7', '-1', '4', '-7'),
(6, '9 - 6', '1', '2', '3', '4', '3'),
(7, '6 + 10', '11', '2', '3', '16', '16'),
(8, '3 / 3', '2', '9', '4', '1', '1'),
(9, '3 / 3 * 3 -3', '2', '9', '4', '0', '0'),
(10, '3 * 3', '2', '9', '4', '1', '9'),
(11, '7 * 2', '14', '9', '1', '3', '14'),
(12, '9 * 9 - 1 + 2', '52', '9', '82', '242', '82'),
(13, '26 + 2 + 3 - 5', '25', '9', '5', '26', '26'),
(14, '10 + 1 / 1 +3 - 5', '2', '10', '4', '9', '9'),
(15, '8 - 2 + 6 * 2', '18', '19', '24', '3', '18'),
(16, '20 / 2 * 3 * 2', '8', '10', '60', '20', '60'),
(17, '9 * 3 + 1 -2', '26', '9', '24', '25', '26'),
(18, '5 * 2 + 1 + 9', '20', '9', '21', '19', '20'),
(19, '13 + 2 + 10 /  2', '31', '20', '32', '12', '20'),
(20, '2 * 2 / 4 * ( 10 - 9 - 1 )', '0', '1', '70', '1', '0'),
(21, '(7 - 2) * 10', '2', '50', '45', '41', '50'),
(22, '(5*9) + 2', '47', '43', '4', '16', '47'),
(23, '7 - 2', '5', '9', '4', '6', '5'),
(24, '9 * 9', '1', '18', '81', '5', '81');

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

INSERT INTO `users` (`id`, `username`, `password`, `nickname`, `scores`, `matches`, `win`, `time`) VALUES
(2, 'nguyenxuanbac', 'c4ca4238a0b923820dcc509a6f75849b', 'Xbawcs', 1, 4, 1, 0),
(3, 'bac', 'c4ca4238a0b923820dcc509a6f75849b', 'Sphynx', 2, 15, 3, 17),
(4, 'bac1', 'c4ca4238a0b923820dcc509a6f75849b', 'Depzzzz', 3, 10, 3, 30),
(5, 'bac2', 'c4ca4238a0b923820dcc509a6f75849b', 'bac2', 1, 3, 1, 0),
(17, 'bac13', 'c4ca4238a0b923820dcc509a6f75849b', 'bac13', 0, 0, 0, 0),
(18, 'bac3', 'c4ca4238a0b923820dcc509a6f75849b', 'bac3', 1, 2, 1, 0),
(19, 'bac4', 'c4ca4238a0b923820dcc509a6f75849b', 'bac4', 0, 0, 0, 0),
(20, 'bac5', 'c4ca4238a0b923820dcc509a6f75849b', 'bac5', 0, 0, 0, 0),
(21, 'bac6', 'c4ca4238a0b923820dcc509a6f75849b', 'bac6', 0, 0, 0, 0),
(22, 'bac7', 'c4ca4238a0b923820dcc509a6f75849b', 'bac7', 0, 0, 0, 0),
(23, 'bac8', 'c4ca4238a0b923820dcc509a6f75849b', 'bac8', 0, 0, 0, 0),
(24, 'bac9', 'c4ca4238a0b923820dcc509a6f75849b', 'bac9', 0, 0, 0, 0),
(25, 'bac10', 'c4ca4238a0b923820dcc509a6f75849b', 'bac10', 0, 0, 0, 20),
(26, 'bac11', 'c4ca4238a0b923820dcc509a6f75849b', 'bac11', 0, 0, 0, 0),
(27, 'bac12', 'c4ca4238a0b923820dcc509a6f75849b', 'bac12', 0, 0, 0, 0),
(28, 'hung', 'c4ca4238a0b923820dcc509a6f75849b', 'hungol', 0, 0, 0, 0),
(29, 'XuanBac', 'c4ca4238a0b923820dcc509a6f75849b', 'XuanBac', 0, 0, 0, 0),
(30, 'Dattt', 'c4ca4238a0b923820dcc509a6f75849b', 'Dattt', 0.5, 1, 0, 0),
(31, 'BACC', 'c4ca4238a0b923820dcc509a6f75849b', 'baccc', 0, 0, 0, 0);

ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
