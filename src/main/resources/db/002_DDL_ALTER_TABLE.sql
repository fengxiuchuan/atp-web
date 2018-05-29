ALTER TABLE `atp`.`atp_gym` CHANGE `m_phone` `phone` VARCHAR(20) CHARSET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '联系方式';


ALTER TABLE `atp`.`atp_member` CHANGE `m_name` `name` VARCHAR(50) CHARSET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '姓名';
