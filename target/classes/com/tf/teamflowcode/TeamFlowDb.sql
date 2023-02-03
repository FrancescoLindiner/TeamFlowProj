CREATE DATABASE progetto;

USE progetto;

CREATE TABLE dipendente (
  matricola INT PRIMARY KEY auto_increment,
  nome VARCHAR(255),
  cognome VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255),
  tipologia VARCHAR(255)
);

CREATE TABLE turno (
  id_turno INT auto_increment,
  data DATE,
  descrizione VARCHAR(255),
  t_matricola INT,
  ora_inizio TIME,
  ora_fine TIME,
  presenza boolean,
  firma_ingresso boolean,
  firma_uscita boolean,
  PRIMARY KEY (id_turno, t_matricola),
  FOREIGN KEY (t_matricola) REFERENCES dipendente(matricola) on delete cascade
);

CREATE TABLE stipendio (
  anno_s int,
  mese_s int,
  s_matricola INT,
  ore_straordinario_1 INT,
  ore_straordinario_2 INT,
  ore_straordinario_3 INT,
  ore_straordinario_4 INT,
  importo double,
  PRIMARY KEY (anno_s, mese_s, s_matricola),
  FOREIGN KEY (s_matricola) REFERENCES dipendente(matricola) on delete cascade
);

CREATE TABLE permesso (
  id_permesso INT auto_increment,
  p_matricola INT,
  data_p DATE,
  ora_inizio_turno VARCHAR(255),
  ora_fine_turno VARCHAR(255),
  motivazione VARCHAR(255),
  PRIMARY KEY (id_permesso, p_matricola, data_p),
  FOREIGN KEY (p_matricola) REFERENCES dipendente(matricola) on delete cascade
);

CREATE TABLE ferie (
  id_ferie INT auto_increment,
  data_inizio_ferie DATE,
  data_fine_ferie DATE,
  f_matricola INT,
  data_inizio_periodo_rosso DATE,
  data_fine_periodo_rosso DATE,
  PRIMARY KEY (id_ferie),
  FOREIGN KEY (f_matricola) REFERENCES dipendente(matricola) on delete cascade
);

delete from stipendio where anno_s='2023';

delete from turno where t_matricola=58;
delete from turno where t_matricola=56;
delete from turno where t_matricola=86;
delete from turno where t_matricola=45;
delete from turno where t_matricola=58;

select * from dipendente;
select * from turno;
select * from stipendio;
select * from ferie;

select * from dipendente where tipologia='Impiegato A' and matricola in (select t_matricola from turno where data='2023-06-01' and descrizione!='libero')
delete from ferie where id_ferie=90;

select * from turno where t_matricola=44;

INSERT INTO turno (data, descrizione, t_matricola, ora_inizio, ora_fine) VALUES
  ('2022-01-01', 'mattina', 1, '08:00:00', '16:00:00'),
  ('2022-01-02','pomeriggio', 1, '16:00:00', '00:00:00'),
  ('2022-01-03','notte', 1, '00:00:00', '8:00:00'),
  ('2022-01-01', 'mattina', 2, '08:00:00', '16:00:00'),
  ('2022-01-02','pomeriggio', 2, '16:00:00', '00:00:00'),
  ('2022-01-03','notte', 2, '00:00:00', '8:00:00'),
  ('2022-01-01', 'mattina', 3, '08:00:00', '16:00:00'),
  ('2022-01-02','pomeriggio', 3, '16:00:00', '00:00:00'),
  ('2022-01-03','notte', 3, '00:00:00', '8:00:00');

INSERT INTO stipendio (anno_s, mese_s, s_matricola, ore_straordinario_1, ore_straordinario_2, ore_straordinario_3, ore_straordinario_4, importo) VALUES
  ('2023','01', 40, 2, 2, 2, 2, 2250.00),
  (2023, 01, 2, 10, 200.00),
  (2023, 02, 1, 3, 75.00);