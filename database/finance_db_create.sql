SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `finance` ;
CREATE SCHEMA IF NOT EXISTS `finance` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `finance` ;

-- -----------------------------------------------------
-- Table `finance`.`sector`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`sector` ;

CREATE TABLE IF NOT EXISTS `finance`.`sector` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finance`.`industry`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`industry` ;

CREATE TABLE IF NOT EXISTS `finance`.`industry` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finance`.`stock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`stock` ;

CREATE TABLE IF NOT EXISTS `finance`.`stock` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company` VARCHAR(45) NULL,
  `symbol` VARCHAR(45) NOT NULL,
  `sector_id` INT NULL,
  `industry_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `symbol_UNIQUE` (`symbol` ASC),
  INDEX `fk_stock_sector1_idx` (`sector_id` ASC),
  INDEX `fk_stock_industry1_idx` (`industry_id` ASC),
  CONSTRAINT `fk_stock_sector1`
    FOREIGN KEY (`sector_id`)
    REFERENCES `finance`.`sector` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stock_industry1`
    FOREIGN KEY (`industry_id`)
    REFERENCES `finance`.`industry` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finance`.`balance_sheet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`balance_sheet` ;

CREATE TABLE IF NOT EXISTS `finance`.`balance_sheet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stock_id` INT NULL,
  `total_current_assets` MEDIUMTEXT NULL,
  `total_assets` MEDIUMTEXT NULL,
  `total_current_liabilities` MEDIUMTEXT NULL,
  `total_liabilities` MEDIUMTEXT NULL,
  `total_shareholder_equity` MEDIUMTEXT NULL,
  `year` YEAR NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_liability_stock1_idx` (`stock_id` ASC),
  CONSTRAINT `fk_liability_stock1`
    FOREIGN KEY (`stock_id`)
    REFERENCES `finance`.`stock` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finance`.`income_statement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`income_statement` ;

CREATE TABLE IF NOT EXISTS `finance`.`income_statement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stock_id` INT NOT NULL,
  `net_income` MEDIUMTEXT NULL,
  `year` YEAR NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_income_stock1_idx` (`stock_id` ASC),
  CONSTRAINT `fk_income_stock1`
    FOREIGN KEY (`stock_id`)
    REFERENCES `finance`.`stock` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finance`.`key_statistics`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`key_statistics` ;

CREATE TABLE IF NOT EXISTS `finance`.`key_statistics` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stock_id` INT NOT NULL,
  `price` DOUBLE NULL,
  `market_cap` MEDIUMTEXT NULL,
  `pb` DOUBLE NULL,
  `pe` DOUBLE NULL,
  `peg` DOUBLE NULL,
  `eps` DOUBLE NULL,
  `earning_yield` DOUBLE NULL,
  `yield` DOUBLE NULL,
  `profit_margin` DOUBLE NULL,
  `operating_margin` DOUBLE NULL,
  `return_on_assets` DOUBLE NULL,
  `return_on_equity` DOUBLE NULL,
  `year` YEAR NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_key_statistics_stock1_idx` (`stock_id` ASC),
  CONSTRAINT `fk_key_statistics_stock1`
    FOREIGN KEY (`stock_id`)
    REFERENCES `finance`.`stock` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finance`.`cash_flow`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finance`.`cash_flow` ;

CREATE TABLE IF NOT EXISTS `finance`.`cash_flow` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stock_id` INT NOT NULL,
  `cash_from_operating` MEDIUMTEXT NULL,
  `cash_from_investing` MEDIUMTEXT NULL,
  `cash_from_financing` MEDIUMTEXT NULL,
  `changes_in_cash` MEDIUMTEXT NULL,
  `year` YEAR NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cash_flow_stock1_idx` (`stock_id` ASC),
  CONSTRAINT `fk_cash_flow_stock1`
    FOREIGN KEY (`stock_id`)
    REFERENCES `finance`.`stock` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
