--Importar las enfermedades en HSQL
DELETE FROM DB29179_CIE10;
SET TABLE DB29179_CIE10 SOURCE "CSV_CIE10.csv;ignore_first=true;all_quoted=true"
