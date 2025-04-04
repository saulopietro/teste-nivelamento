select registro_ans, cnpj, razao_social, 
SUM(CAST(demonstracoes_contabeis.vl_saldo_final AS DECIMAL)) AS total_despesas
from operadoras_plano_saude
INNER JOIN demonstracoes_contabeis ON demonstracoes_contabeis.reg_ans = operadoras_plano_saude.registro_ans
WHERE descricao = 'EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS  DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR '
GROUP BY
    operadoras_plano_saude.razao_social, operadoras_plano_saude.cnpj, operadoras_plano_saude.registro_ans
ORDER BY
    total_despesas DESC
LIMIT 10