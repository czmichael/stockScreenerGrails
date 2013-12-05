SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `finance` ;
CREATE SCHEMA IF NOT EXISTS `finance` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `finance` ;

-- -----------------------------------------------------
-- Table `finance`.`sector`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`sector` ;

CREATE  TABLE IF NOT EXISTS `finance`.`sector` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finance`.`industry`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`industry` ;

CREATE  TABLE IF NOT EXISTS `finance`.`industry` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finance`.`stock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`stock` ;

CREATE  TABLE IF NOT EXISTS `finance`.`stock` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `company` VARCHAR(45) NULL ,
  `symbol` VARCHAR(45) NOT NULL ,
  `price` DOUBLE NULL DEFAULT 0.00 ,
  `market_cap` MEDIUMTEXT  NULL DEFAULT NULL ,
  `price_per_book` DOUBLE NULL DEFAULT NULL ,
  `price_per_earning` DOUBLE NULL DEFAULT NULL ,
  `yield` DOUBLE NULL DEFAULT NULL ,
  `pay_out_ratio` DOUBLE NULL DEFAULT NULL ,
  `sector_id` INT NULL ,
  `industry_id` INT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `symbol_UNIQUE` (`symbol` ASC) ,
  INDEX `fk_stock_sector1` (`sector_id` ASC) ,
  INDEX `fk_stock_industry1` (`industry_id` ASC) ,
  CONSTRAINT `fk_stock_sector1`
    FOREIGN KEY (`sector_id` )
    REFERENCES `finance`.`sector` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stock_industry1`
    FOREIGN KEY (`industry_id` )
    REFERENCES `finance`.`industry` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finance`.`asset`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`asset` ;

CREATE  TABLE IF NOT EXISTS `finance`.`asset` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `stock_id` INT NOT NULL ,
  `total_current_asset` MEDIUMTEXT  NOT NULL ,
  `year` YEAR NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_asset_stock_idx` (`stock_id` ASC) ,
  CONSTRAINT `fk_asset_stock`
    FOREIGN KEY (`stock_id` )
    REFERENCES `finance`.`stock` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finance`.`liability`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`liability` ;

CREATE  TABLE IF NOT EXISTS `finance`.`liability` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `stock_id` INT NOT NULL ,
  `total_current_liability` MEDIUMTEXT  NULL ,
  `year` YEAR NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_liability_stock1_idx` (`stock_id` ASC) ,
  CONSTRAINT `fk_liability_stock1`
    FOREIGN KEY (`stock_id` )
    REFERENCES `finance`.`stock` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finance`.`income`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`income` ;

CREATE  TABLE IF NOT EXISTS `finance`.`income` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `stock_id` INT NOT NULL ,
  `net_income` MEDIUMTEXT  NOT NULL ,
  `year` YEAR NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_income_stock1_idx` (`stock_id` ASC) ,
  CONSTRAINT `fk_income_stock1`
    FOREIGN KEY (`stock_id` )
    REFERENCES `finance`.`stock` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
