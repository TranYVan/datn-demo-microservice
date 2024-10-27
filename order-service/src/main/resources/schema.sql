DROP TABLE IF EXISTS "order_detail";
DROP TABLE IF EXISTS "order";

DROP SEQUENCE IF EXISTS orders_id_seq;
CREATE SEQUENCE orders_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 1238901723081234 CACHE 1;

CREATE TABLE "order" (
    "order_id" BIGINT DEFAULT nextval('orders_id_seq') NOT NULL,
    "order_date" DATE,
    CONSTRAINT "order_pkey" PRIMARY KEY ("order_id")
);

CREATE TABLE "order_detail" (
    "order_id" BIGINT NOT NULL,
    "prod_id" INTEGER NOT NULL,
    "quantity" INTEGER,

    CONSTRAINT "order_detail_pkey" PRIMARY KEY ("order_id", "prod_id"),
    CONSTRAINT "order_fkey" FOREIGN KEY ("order_id") REFERENCES "order"
);