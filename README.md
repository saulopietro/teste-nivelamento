Web-Scraping 1(Feito no Intelij):\
-Substituir os caminhos dos arquivos finais no arquivo WebScrapingController\
-Rodar o arquivo WebScrapingApplication

Data transformation test 2:\
-Substituir os caminhos dos arquivos iniciais e finais no 'configs.py'\
-rodar o 'app.py'

Database test 3(PostgreSQL):\
 1°: Executar os scripts de criação de tabela em ordem:\
	-create_operadoras.sql\
	-create_demontracoes.sql\
 2°: Executar os scripts de import em ordem:\
	-import_operadoras.sql\
	Caso você queira os ultimos 3 meses:\
		-import_last_3_months_demonstracoes -> nesse arquivo você primeiro deve executar o comando de importação, depois os de transformação\
	Caso queira o ultimo ano:\
		-import_last_1_year_demonstracoes ->  nesse arquivo você primeiro deve executar os comandos de importação, depois o de transformação\
 3°: Executar a query\
	-query.sql

api test 4:\
 1°: Habilitar o backend\
	-Habilitar a venv -> .venv/Scripts/activate\
	-rodar o app -> python app.py\
 2°: Habilitar o frontend\
	-Rodar o serve -> npm run serve\
	-Entrat na URL -> http://localhost:8080/		
