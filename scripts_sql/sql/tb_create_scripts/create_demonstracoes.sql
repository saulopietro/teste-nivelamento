CREATE TABLE demonstracoes_contabeis (
  	id SERIAL PRIMARY KEY,
    reg_ans BIGINT,            
    cd_conta_contabil VARCHAR(255) NOT NULL, 
    descricao VARCHAR(255),                  
    vl_saldo_inicial VARCHAR(17),         
    vl_saldo_final VARCHAR(17),           
    data DATE
)
