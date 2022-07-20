/* Inserta categorías por defecto */
--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Principal', 'INGRESO', null, '', now()); --1

--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 1', 'INGRESO', 1, '', now()); --2
--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 1.1', 'INGRESO', 2, '', now()); --3
--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 1.2', 'INGRESO', 2, '', now()); --4

--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 2', 'INGRESO', 1, '', now()); --5
--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 3', 'INGRESO', 1, '', now()); --6
--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 3.1', 'INGRESO', 6, '', now()); --7
--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 3.2', 'INGRESO', 6, '', now()); --8

--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 1.4', 'INGRESO', 2, '', now()); --9
--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 2.1', 'INGRESO', 5, '', now()); --10
--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 3.3', 'INGRESO', 6, '', now()); --11
--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 4', 'INGRESO', 1, '', now()); --12
--insert into categorias (nombre, tipo, categoria_id, descripcion, fecha_guardado) values ('Categoría 3.3.1', 'INGRESO', 11, '', now());

/* Insertar divisas por defecto*/
insert into divisas (nombre, codigo, por_defecto, fecha_guardado) values('Peso Mexicano', 'MXN', true, now());

insert into divisas (nombre, codigo, por_defecto, fecha_guardado) values('Dólar Estadounidense', 'USD', false,  now());

insert into divisas (nombre, codigo, por_defecto, fecha_guardado) values('Euro', 'EUR', false, now());

/* Entidades financieras de BANCA_MULTIPLE por defecto */
/* https://www.abm.org.mx/bancos-integrantes/index.htm# */
insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('BC Capital', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('American Express Bank (México)', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banca Afirme', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banca Mifel', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Actinver', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Autofin México', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Azteca', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Bancrea', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Base', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Covalto', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Compartamos', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Credit Suisse (México)', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco de Inversión Afirme', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco del Bajío', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Forjadores', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Inbursa', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Inmobiliario Mexicano', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Invex', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco JP Morgan', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco KEB Hana México', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Monex', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Multiva', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco PagaTodo', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Regional de Monterrey', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco S3 Caceis México', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Sabadell', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Santander', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Shinhan de México', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banco Ve por Más', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('BanCoppel', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Bank of America Mexico', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Bank of China Mexico', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Bankaool', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Banorte', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Bansí', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Barclays Bank México', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('BBVA México', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('BNP Paribas', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Citibanamex', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('CIBanco', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Consubanco', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Deutsche Bank México', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Fundación Dondé Banco', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('HSBC México', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Industrial and Commercial Bank of China', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Intercam Banco', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Mizuho Bank', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('MUFG Bank Mexico', 'INSTITUCION_BANCA_MULTIPLE', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Scotiabank', 'INSTITUCION_BANCA_MULTIPLE', now());

/*Entidades financieras Administradoras de Fondos de Retiro*/
/*https://www.consar.gob.mx/gobmx/aplicativo/siset/CuadroInicial.aspx?md=5*/
insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Azteca', 'ADMINISTRADORA_FONDOS_RETIRO', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Citibanamex', 'ADMINISTRADORA_FONDOS_RETIRO', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Coppel', 'ADMINISTRADORA_FONDOS_RETIRO', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Inbursa', 'ADMINISTRADORA_FONDOS_RETIRO', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Invercap', 'ADMINISTRADORA_FONDOS_RETIRO', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('PensionISSSTE', 'ADMINISTRADORA_FONDOS_RETIRO', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Principal', 'ADMINISTRADORA_FONDOS_RETIRO', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Profuturo', 'ADMINISTRADORA_FONDOS_RETIRO', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('SURA', 'ADMINISTRADORA_FONDOS_RETIRO', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('XXI Banorte', 'ADMINISTRADORA_FONDOS_RETIRO', now());

/* Entidades financieras Casas de Bolsa */
/* https://portafolioinfo.cnbv.gob.mx/PUBLICACIONES/Boletines/Paginas/CB.aspx */

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Actinver', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Altor Casa de Bolsa', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Barclays Capital', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('BBVA Bancomer', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('BTG Pactual CB', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Bursamétrica Casa de Bolsa', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Casa de Bolsa Banorte', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Casa de Bolsa Base', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('CB Ve por Más', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('CI Casa de Bolsa', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Citibanamex Casa de Bolsa', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Credit Suisse', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Deutsche Securities', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Finamex', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('GBM', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Goldman Sachs CB', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('HSBC', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Intercam', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Inversora Bursátil', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Invex', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('JP Morgan', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Kuspit', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Masari', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Merrill Lynch', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Monex', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Morgan Stanley', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Multiva', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Punto Casa de Bolsa', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Santander', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Scotia Casa de Bolsa', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Tactiv Casa de Bolsa 4/', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('UBS', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Valmex', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Value', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Vector', 'CASA_BOLSA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Vifaru Casa de Bolsa', 'CASA_BOLSA', now());

/* Entidades financieras Sociedades Financieras Populares */
/* https://www.cnbv.gob.mx/Entidades-Autorizadas/Paginas/Sofipos.aspx */

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('FINANCIERA DEL SECTOR SOCIAL, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('FINANCIERA BROXEL, S.A. DE C.V.,S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('ACCION Y EVOLUCION, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('IMPULSO PARA EL DESARROLLO DE MÉXICO, S.A. DE C.V.,S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('CAJA DE LA SIERRA GORDA, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('UNAGRA, S.A. DE C.V. S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('CAPITAL ACTIVO, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('NU MEXICO FINANCIERA, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('SOLUCION ASEA, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('SERVICIOS FINANCIEROS ALTERNATIVOS, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('KU-BO FINANCIERO, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('J.P. SOFIEXPRESS, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('TE CREEMOS, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('FINANCIERA MONTE DE PIEDAD, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('FINANCIERA MEXICANA PARA EL DESARROLLO RURAL, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('ADMINISTRADORA DE CAJA BIENESTAR, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('APOYO MULTIPLE, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('CAJA PROGRESSA, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Consejo de Asistencia al Microemprendedor, S.A. de C.V. Sociedad Financiera Popular', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('FINANCIERA AUXI, S.A. DE C.V., S.F.P,', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('FINANCIERA PLANFIA, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('FINANCIERA TAMAZULA, S.A. DE C.V. S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('FINCOMUN, SERVICIOS FINANCIEROS COMUNITARIOS, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('MULTIPLICA MEXICO, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('UNETE FINANCIERA DE ALLENDE, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('ICTINEO PLATAFORMA, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('SOCIEDAD DE ALTERNATIVAS ECONOMICAS, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('MASCAJA, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('LIBERTAD SERVICIOS FINANCIEROS, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('OPERACIONES DE TU LADO, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('OPCIONES EMPRESARIALES DEL NORESTE, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('FINANCIERA SUSTENTABLE DE MEXICO, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('CREDICLUB, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('FINANCIERA MÁS, S.A. DE C.V., S.F.P.', 'SOCIEDAD_FINANCIERA_POPULAR', now());

/* Instituciones financieras Tecnología Financiera */
/* https://webapps.condusef.gob.mx/SIPRES/jsp/pub/index.jsp#15918 */
insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Angeles en ARK, S.A.P.I DE C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Communitas Aurum, S.A.P.I. de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Fundary, S.A.P.I. de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Grupo Finansiell, S.A.P.I. de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('M2crowd, S.A. de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Plataforma Inmobiliaria Cien Ladrillos, S.A.P.I. de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Play Business, S.A.P.I. de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Red Girasol, S.A.P.I de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('BXL FINTECH, S.A. de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Comunidad de Préstamos, S.A.P.I. de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Crowd Up Mex, S.A.P.I. de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('Likideo MX, S.A.P.I. de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

insert into entidades_financieras (nombre, tipo, fecha_guardado) values ('PorCuanto, S.A. de C.V.', 'INSTITUCION_TECNOLOGIA_FINANCIERA', now());

