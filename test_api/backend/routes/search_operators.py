from flask import Blueprint, request, jsonify
import pandas as pd
import csv


operator_bp = Blueprint('operator_bp', __name__)

# Carregar o arquivo CSV
def load_data():
    data = []
    with open('Relatorio_cadop.csv', newline='', encoding='utf-8') as csvfile:
        reader = csv.DictReader(csvfile, delimiter=';')  # Lê o CSV como um dicionário
        for row in reader:
            # Converte cada linha para um dicionário (que é o formato JSON)
            data.append(row)
    return data


@operator_bp.route('/search', methods=['GET'])
def search():
    query = request.args.get('query', '', type=str).lower()  # Obtém o termo de pesquisa
    data = load_data()  # Carrega os dados do CSV
    results = []

    # Realiza a busca textual nos campos dos registros
    for record in data:
        # Verifica se o termo de busca aparece em qualquer valor do registro
        if any(query in str(value).lower() for key, value in record.items()):
            results.append(record)

    return jsonify(results)  # Retorna os resultados encontrados em formato JSON


@operator_bp.route('/')
def homepage():
    return 'Olá, mundo'
