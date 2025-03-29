COPY operadoras_plano_saude(registro_ans, cnpj, razao_social, nome_fantasia, modalidade, logradouro, numero, complemento, bairro, cidade, uf, cep, ddd, telefone, fax, endereco_eletronico, representante, cargo_representante, regiao_de_comercializacao, data_registro_ans)
FROM 'C:\projetos\teste_nivelamento\scripts_sql\data\operadoras_ativas_ans\Relatorio_cadop.csv'
DELIMITER ';'   
CSV HEADER
ENCODING 'UTF8';      