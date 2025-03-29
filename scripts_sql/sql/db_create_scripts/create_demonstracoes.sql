CREATE TABLE demonstracoes_contabeis (   
    reg_ans SERIAL PRIMARY KEY,            
    cd_conta_contabil VARCHAR(255) NOT NULL, 
    descricao VARCHAR(255),                  
    vl_saldo_inicial DECIMAL(15, 2),         
    vl_saldo_final DECIMAL(15, 2),           
    data DATE                      
);