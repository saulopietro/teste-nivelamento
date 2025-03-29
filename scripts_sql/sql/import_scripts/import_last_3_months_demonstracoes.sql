COPY demonstracoes_contabeis(data, reg_ans, cd_conta_contabil, descricao, vl_saldo_inicial, vl_saldo_final)
FROM 'C:\projetos\teste_nivelamento\scripts_sql\data\demonstracoes_contabeis_2024\4T2024.csv'
DELIMITER ';'          
CSV HEADER
ENCODING 'UTF8';     

-- Alterar a coluna vl_saldo_inicial para DECIMAL(17, 2)
ALTER TABLE demonstracoes_contabeis
    ALTER COLUMN vl_saldo_inicial TYPE DECIMAL(17, 2)
    USING REPLACE(vl_saldo_inicial, ',', '.')::DECIMAL(17, 2);

-- Alterar a coluna vl_saldo_final para DECIMAL(17, 2)
ALTER TABLE demonstracoes_contabeis
    ALTER COLUMN vl_saldo_final TYPE DECIMAL(17, 2)
    USING REPLACE(vl_saldo_final, ',', '.')::DECIMAL(17, 2);