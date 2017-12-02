CREATE TABLE `develop`.`exchanges` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `DisplayName` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));

CREATE TABLE `develop`.`marketsummaries` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ExchangeID` INT NOT NULL,
  `MarketName` VARCHAR(45) NULL,
  `Hight` FLOAT NULL,
  `Low` FLOAT NULL,
  `Volume` FLOAT NULL,
  `Last` FLOAT NULL,
  `BaseVolume` FLOAT NULL,
  `Timestamp` DATETIME NULL,
  `Bid` FLOAT NULL,
  `Ask` FLOAT NULL,
  `OpenBuyOrders` FLOAT NULL,
  `OpenSellOrders` FLOAT NULL,
  `PrevDay` FLOAT NULL,
  `Created` DATETIME NULL,
  `DisplayMarketName` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));
