CREATE DATABASE IF NOT EXISTS foodTravelTechie;
CREATE USER IF NOT EXISTS foodTravelTechie_user@localhost IDENTIFIED BY "foodTravelTechie_pwd";
GRANT ALL PRIVILEGES ON foodTravelTechie.* TO foodTravelTechie_user@localhost;
GRANT SELECT ON performance_schema.* TO foodTravelTechie_user@localhost;


