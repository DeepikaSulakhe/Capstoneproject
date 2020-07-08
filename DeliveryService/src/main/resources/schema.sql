create table DELIVERY_DATA(
    id number primary key auto_increment,
    CUSTOMER_ID INT,
    ORDER_ID INT,
    RECORD VARCHAR(255),
    RESTAURANT_ID INT,
    UPD_TIME timestamp not null
) ;

