package setting;

import java.sql.DriverManager;

/**
 * DB 연결, 테이블 생성 및 초기화하는 클래스
 */

public class Setting {
	static void initDB() throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		
		stmt.execute("SET GLOBAL local_infile = 1");
		stmt.execute("DROP SCHEMA IF EXISTS `miriead`");
		stmt.execute("CREATE SCHEMA `miriead` DEFAULT CHARACTER SET utf8 ;");
		
		stmt.execute("CREATE TABLE `miriead`.`user` (\r\n"
				+ "  `user_id` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `user_identi` VARCHAR(30) NULL,\r\n"
				+ "  `user_pw` VARCHAR(50) NULL,\r\n"
				+ "  `user_book` VARCHAR(50) NULL,\r\n"
				+ "  PRIMARY KEY (`user_id`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `miriead`.`novel` (\r\n"
				+ "  `novel_id` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `novel_title` VARCHAR(50) NULL,\r\n"
				+ "  `novel_author` VARCHAR(20) NULL,\r\n"
				+ "  `novel_school` TINYINT NULL,\r\n"
				+ "  `novel_page` INT NULL,\r\n"
				+ "  `novel_type` VARCHAR(10) NULL,\r\n"
				+ "  `novel_story` VARCHAR(1000) NULL,\r\n"
				+ "  PRIMARY KEY (`novel_id`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `miriead`.`major` (\r\n"
				+ "  `major_id` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `major_title` VARCHAR(50) NULL,\r\n"
				+ "  `major_author` VARCHAR(20) NULL,\r\n"
				+ "  `major_school` TINYINT NULL,\r\n"
				+ "  `major_page` INT NULL,\r\n"
				+ "  `major_type` VARCHAR(10) NULL,\r\n"
				+ "  `major_story` VARCHAR(1000) NULL,\r\n"
				+ "  PRIMARY KEY (`major_id`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `miriead`.`improve` (\r\n"
				+ "  `improve_id` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `improve_title` VARCHAR(50) NULL,\r\n"
				+ "  `improve_author` VARCHAR(20) NULL,\r\n"
				+ "  `improve_school` TINYINT NULL,\r\n"
				+ "  `improve_page` INT NULL,\r\n"
				+ "  `improve_type` VARCHAR(10) NULL,\r\n"
				+ "  `improve_story` VARCHAR(1000) NULL,\r\n"
				+ "  PRIMARY KEY (`improve_id`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `miriead`.`essay` (\r\n"
				+ "  `essay_id` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `essay_title` VARCHAR(50) NULL,\r\n"
				+ "  `essay_author` VARCHAR(20) NULL,\r\n"
				+ "  `essay_school` TINYINT NULL,\r\n"
				+ "  `essay_page` INT NULL,\r\n"
				+ "  `essay_type` VARCHAR(10) NULL,\r\n"
				+ "  `essay_story` VARCHAR(1000) NULL,\r\n"
				+ "  PRIMARY KEY (`essay_id`));\r\n"
				+ "");
		
		stmt.execute("USE `miriead`");
		
		stmt.execute("LOAD DATA LOCAL INFILE 'datafiles/novel.txt'"
				+ " INTO TABLE miriead.novel"
				+ " IGNORE 1 LINES");
		
	}
		
		public static void main(String[] args) {
			try {
				initDB();
				System.out.println("세팅 성공!");
			} catch (Exception e) {
				e.printStackTrace();
			}

		
	}
}
