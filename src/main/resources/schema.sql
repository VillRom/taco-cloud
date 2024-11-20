create table if not exists Taco_cloud (
    id identiti,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(100) not null,
    delivery_City varchar(50) not null,
    delivery_State varchar(2) not null,
    delivery_Zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_experation varchar(5) not null,
    cc_cvv varchar (3) not null,
    placetd_at timestamp not null
);
