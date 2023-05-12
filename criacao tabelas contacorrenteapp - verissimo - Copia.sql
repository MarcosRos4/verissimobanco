-- MySQL Script generated by MySQL Workbench
-- Thu May  4 10:00:33 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema contacorrentedb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema contacorrentedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `contacorrentedb` ;
USE `contacorrentedb` ;

-- -----------------------------------------------------
-- Table `contacorrentedb`.`agencias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contacorrentedb`.`agencias` (
  `numero_da_agencia` INT NOT NULL AUTO_INCREMENT,
  `nome_gerente` VARCHAR(45) NULL,
  PRIMARY KEY (`numero_da_agencia`),
  UNIQUE INDEX `numero_da_agencia_UNIQUE` (`numero_da_agencia` ASC) VISIBLE)
ENGINE = InnoDB;

-- ADICIONANDO AGENCIAS NA CRIAÇÃO DA DATABASE
INSERT INTO `contacorrentedb`.`agencias` (`numero_da_agencia`,`nome_gerente`)
VALUES (default, "Marcos");

INSERT INTO `contacorrentedb`.`agencias` (`numero_da_agencia`,`nome_gerente`)
VALUES (default, "Ivo");

INSERT INTO `contacorrentedb`.`agencias` (`numero_da_agencia`,`nome_gerente`)
VALUES (default, "Thomas");

INSERT INTO `contacorrentedb`.`agencias` (`numero_da_agencia`,`nome_gerente`)
VALUES (default, "Matulis");


-- -----------------------------------------------------
-- Table `contacorrentedb`.`contas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contacorrentedb`.`contas` (
  `numero_da_conta` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `saldo` FLOAT NULL DEFAULT 0,
  `agencias_numero_da_agencia` INT NOT NULL,
  PRIMARY KEY (`numero_da_conta`, `agencias_numero_da_agencia`),
  UNIQUE INDEX `numero_da_conta_UNIQUE` (`numero_da_conta` ASC) VISIBLE,
  INDEX `fk_contas_agencias1_idx` (`agencias_numero_da_agencia` ASC) VISIBLE,
  CONSTRAINT `fk_contas_agencias1`
    FOREIGN KEY (`agencias_numero_da_agencia`)
    REFERENCES `contacorrentedb`.`agencias` (`numero_da_agencia`))
ENGINE = InnoDB;

-- ADICIONANDO CONTAS NA CRIAÇÃO DA DATABASE
INSERT INTO `contacorrentedb`.`contas` (`numero_da_conta`, `nome`, `saldo`, `agencias_numero_da_agencia`)
VALUES (default, "Marcos Rosa", default, "1");

INSERT INTO `contacorrentedb`.`contas` (`numero_da_conta`, `nome`, `saldo`, `agencias_numero_da_agencia`)
VALUES (default, "Ivo Bueno", default, "2");

INSERT INTO `contacorrentedb`.`contas` (`numero_da_conta`, `nome`, `saldo`, `agencias_numero_da_agencia`)
VALUES (default, "Thomas Ferreira", default, "3");

INSERT INTO `contacorrentedb`.`contas` (`numero_da_conta`, `nome`, `saldo`, `agencias_numero_da_agencia`)
VALUES (default, "Lucas Matulis", default, "4");



-- -----------------------------------------------------
-- Table `contacorrentedb`.`transferencias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contacorrentedb`.`transferencias` (
  `numero_da_transferencia` INT NOT NULL AUTO_INCREMENT,
  `valor` FLOAT NULL DEFAULT 0,
  `contas_numero_da_conta` INT NOT NULL,
  `conta_destino` INT NOT NULL,
  `horario_transferencia` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`numero_da_transferencia`, `contas_numero_da_conta`),
  UNIQUE INDEX `numero_do_extrato_UNIQUE` (`numero_da_transferencia` ASC) VISIBLE,
  INDEX `fk_transferencia_contas_idx` (`contas_numero_da_conta` ASC) VISIBLE,
  CONSTRAINT `fk_transferencia_contas`
    FOREIGN KEY (`contas_numero_da_conta`)
    REFERENCES `contacorrentedb`.`contas` (`numero_da_conta`))
ENGINE = InnoDB;

CREATE USER 'user1';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
