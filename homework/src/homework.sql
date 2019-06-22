CREATE TABLE `upload_files` (
   `id` int(11) NOT NULL auto_increment,
   `file_name` varchar(50) NOT NULL,  
   `file_path` varchar(200) default NULL,     
   `file_desc` varchar(100) default NULL,     
   PRIMARY KEY  (`id`) ) 
   DEFAULT CHARSET=utf8;

alter table login add PRIMARY KEY(id);

alter table login add UNIQUE KEY(name);

ALTER TABLE login CHANGE id id int(11) AUTO_INCREMENT;

CREATE TABLE `db_homework`.`person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `office` VARCHAR(45) NULL,
  `age` VARCHAR(45) NULL,
  `start_date` VARCHAR(45) NULL,
  `salary` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));