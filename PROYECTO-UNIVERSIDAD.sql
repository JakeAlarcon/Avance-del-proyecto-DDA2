CREATE SCHEMA IF NOT EXISTS `universidad` DEFAULT CHARACTER SET utf8 ;
USE `universidad` ;

CREATE TABLE IF NOT EXISTS `universidad`.`alumno` (
  `idAlumno` INT NOT NULL auto_increment,
  `nombreAlumno` VARCHAR(100) NOT NULL,
  `edadAlumno` VARCHAR(3) NOT NULL,
  `direccionAlumno` VARCHAR(100) NOT NULL,
  `correoAlumno` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idAlumno`))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `universidad`.`sede` (
  `idSede` INT NOT NULL auto_increment,
  `nombreSede` VARCHAR(100) NOT NULL,
  `direccionSede` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`idSede`))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `universidad`.`carrera` (
  `idCarrera` INT NOT NULL auto_increment,
  `nombreCarrera` VARCHAR(100) NOT NULL,
  `totalCreditos` VARCHAR(5) NOT NULL,
  `sede` INT NOT NULL,
  PRIMARY KEY (`idCarrera`),
  KEY `fk_Carrera_Sede` USING HASH (`sede`),
  CONSTRAINT `fk_Carrera_Sede`
    FOREIGN KEY (`sede`)
    REFERENCES `universidad`.`sede` (`idSede`)
    ON UPDATE CASCADE)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `universidad`.`profesion` (
  `idProfesion` INT NOT NULL auto_increment,
  `nombreProfesion` VARCHAR(100) NOT NULL,
  `centroEstudio` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idProfesion`))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `universidad`.`docente` (
  `idDocente` INT NOT NULL auto_increment,
  `nombreDocente` VARCHAR(100) NOT NULL,
  `edadDocente` VARCHAR(5) NOT NULL,
  `correoDocente` VARCHAR(100) NOT NULL,
  `profesion` INT NOT NULL,
  PRIMARY KEY (`idDocente`),
  KEY `fk_Docente_Profesion` USING HASH (`profesion`),
  CONSTRAINT `fk_Docente_Profesion`
    FOREIGN KEY (`profesion`)
    REFERENCES `universidad`.`profesion` (`idProfesion`)
    ON UPDATE CASCADE)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `universidad`.`curso` (
  `idCurso` INT NOT NULL auto_increment,
  `nombreCurso` VARCHAR(100) NOT NULL,
  `creditoCurso` varchar(4) NOT NULL,
  `alumno` INT NOT NULL,
  `carrera` INT NOT NULL,
  `docente` INT NOT NULL,
  PRIMARY KEY (`idCurso`),
  KEY `fk_Curso_Alumno` USING HASH (`alumno`),
  KEY `fk_Curso_Carrera` USING HASH (`carrera`),
  KEY `fk_Curso_Docente` USING HASH (`docente`),
  CONSTRAINT `fk_Curso_Alumno`
    FOREIGN KEY (`alumno`)
    REFERENCES `universidad`.`alumno` (`idAlumno`)
    ON UPDATE CASCADE,
CONSTRAINT `fk_Curso_Carrera`
    FOREIGN KEY (`carrera`)
    REFERENCES `universidad`.`carrera` (`idCarrera`)
    ON UPDATE CASCADE,
CONSTRAINT `fk_Curso_Docente`
    FOREIGN KEY (`docente`)
    REFERENCES `universidad`.`docente` (`idDocente`)
    ON UPDATE CASCADE)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `universidad`.`alumno`
(`idAlumno`,`nombreAlumno`,`edadAlumno`,`direccionalumno`,`correoAlumno`)
VALUES
(1,"Jose Alvarez","25","SJM","SM12345@idat.edu.pe");

INSERT INTO `universidad`.`sede`
(`idSede`,`nombreSede`,`direccionSede`)
VALUES
(1,"Sede SJM","SJM");

INSERT INTO `universidad`.`carrera`
(`idCarrera`,`nombreCarrera`,`totalCreditos`,`sede`)
VALUES
(1,"Desarrollo de Sistemas","125",1);

INSERT INTO `universidad`.`profesion`
(`idProfesion`,`nombreProfesion`,`centroEstudio`)
VALUES
(1,"Ingeniero Sistemas","UNI");

INSERT INTO `universidad`.`docente`
(`idDocente`,`nombreDocente`,`edadDocente`,`correoDocente`,`profesion`)
VALUES
(1,"Luis Rivera","42","A1234@idat.edu.pe",1);

INSERT INTO `universidad`.`curso`
(`idCurso`,`nombreCurso`,`creditoCurso`,`alumno`,`carrera`,`docente`)
VALUES
(1,"Desarrollo Web","25",1,1,1);





select * from curso;
select * from docente;
select * from carrera;
select * from sede;
select * from profesion;
select * from alumno;
