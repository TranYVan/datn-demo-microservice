DROP TABLE IF EXISTS `order_detail`;
DROP TABLE IF EXISTS `order`;

DROP SEQUENCE IF EXISTS orders_id_seq;
CREATE SEQUENCE orders_id_seq START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 1238901723081234 CACHE 1;

CREATE TABLE `order` (
                         `order_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                         `order_date` DATE
);

CREATE TABLE `order_detail` (
                                `order_id` BIGINT NOT NULL,
                                `prod_id` INT NOT NULL,
                                `quantity` INT,

                                PRIMARY KEY (`order_id`, `prod_id`),
    CONSTRAINT `order_fkey` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
    );
