CREATE TABLE IF NOT EXISTS `backing_warning`(
    `device_id` VARCHAR(256) NOT NULL COMMENT '设备id',
    `warning_1` INT DEFAULT 0 COMMENT '',
    `warning_2` INT DEFAULT 0   COMMENT '',
    `warning_3` INT DEFAULT 0  COMMENT '',
    `warning_4` INT DEFAULT 0  COMMENT '',
    `warning_5` INT DEFAULT 0  COMMENT '',
    `warning_6` INT DEFAULT 0  COMMENT '',
    `warning_7` INT DEFAULT 0  COMMENT '',
    `warning_time` datetime  COMMENT '警告时间',
    index info(device_id,warning_time))ENGINE=InnoDB DEFAULT CHARSET=utf8;









