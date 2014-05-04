SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `dbkm` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `dbkm` ;

-- -----------------------------------------------------
-- Table `dbkm`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbkm`.`usuario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `coordenador` TINYINT(1) NOT NULL,
  `carroparticular` TINYINT(1) NULL,
  `cpf` VARCHAR(14) NULL,
  `nome_banco` VARCHAR(45) NULL,
  `conta` INT NULL,
  `agencia` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbkm`.`atendimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbkm`.`atendimento` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `usuario_id` BIGINT NOT NULL,
  `data` DATE NOT NULL,
  `chamado` INT NULL,
  `origem` VARCHAR(50) NOT NULL,
  `destino` VARCHAR(50) NOT NULL,
  `kminicial` INT NOT NULL,
  `kmfinal` INT NOT NULL,
  `obs_atendimento` VARCHAR(255) NULL,
  `motivo_alteracao` VARCHAR(255) NULL,
  `aprovado` TINYINT(1) NULL,
  `pago` TINYINT(1) NULL,
  `qtd_hospedagem` INT NULL,
  `valor_hospedagem` DOUBLE NULL,
  `qtd_pedagio` INT NULL,
  `valor_pedagio` DOUBLE NULL,
  `qtd_estacionamento` INT NULL,
  `valor_estacionamento` DOUBLE NULL,
  `qtd_alimentacao` INT NULL,
  `valor_alimentacao` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_atendimento_usuario1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_atendimento_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `dbkm`.`usuario` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbkm`.`tabela_preco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbkm`.`tabela_preco` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `km` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `dbkm`.`usuario`
-- -----------------------------------------------------
START TRANSACTION;
USE `dbkm`;
INSERT INTO `dbkm`.`usuario` (`id`, `nome`, `login`, `senha`, `coordenador`, `carroparticular`, `cpf`, `nome_banco`, `conta`, `agencia`) VALUES (1, 'Admin', 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 1, 0, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dbkm`.`tabela_preco`
-- -----------------------------------------------------
START TRANSACTION;
USE `dbkm`;
INSERT INTO `dbkm`.`tabela_preco` (`id`, `km`) VALUES (1, 0.55);

COMMIT;
