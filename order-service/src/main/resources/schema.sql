-- Drop the tables if they exist
DROP TABLE IF EXISTS `order_detail`;
DROP TABLE IF EXISTS `order`;

-- Drop the sequence if it exists (MySQL does not support sequences like other databases, so this is not applicable)
-- In MySQL, `AUTO_INCREMENT` is used to manage sequential numbers for a column, so no need to create a sequence

-- Create the `order` table with an auto-increment primary key
CREATE TABLE `order` (
    `order_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `order_date` DATE
);

-- Create the `order_detail` table with a foreign key reference to the `order` table
CREATE TABLE `order_detail` (
    `order_id` BIGINT NOT NULL,
    `prod_id` INT NOT NULL,
    `quantity` INT,

    PRIMARY KEY (`order_id`, `prod_id`),
    CONSTRAINT `order_fkey` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
);
