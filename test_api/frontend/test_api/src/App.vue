<template>
  <div id="app">
    <div class="search-container">
      <h1 class="title">Busca de Operadoras</h1>
      <input
        v-model="query"
        @keyup="debounceSearch"
        placeholder="Digite o nome ou CNPJ..."
        class="search-input"
        type="text"
      />
      <div v-if="loading" class="loading">Carregando...</div>
      <div v-if="error" class="error">Erro ao carregar os dados.</div>
    </div>
    <ul v-if="results.length" class="results-list">
      <li v-for="(item, index) in results" :key="index" class="result-item">
        <div class="result-header">
          <strong>{{ item.Razao_Social }}</strong>
          <span class="city">{{ item.Cidade }} - {{ item.UF }}</span>
        </div>
        <div class="result-details">
          <p><strong>CNPJ:</strong> {{ item.CNPJ }}</p>
          <p><strong>Representante:</strong> {{ item.Representante }}</p>
          <p><strong>Email:</strong> <a :href="'mailto:' + item.Endereco_eletronico">{{ item.Endereco_eletronico }}</a></p>
          <p><strong>Telefone:</strong> {{ item.Telefone || 'N/A' }}</p>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      query: '',
      results: [],
      loading: false,
      error: false,
      timeout: null,  // Variável para controlar o tempo de debounce
    };
  },
  methods: {
    debounceSearch() {
      // Cancela a execução anterior se ainda não foi concluída
      clearTimeout(this.timeout);

      // Atraso de 500ms antes de realizar a busca
      this.timeout = setTimeout(() => {
        this.search();
      }, 500);  // O atraso é configurado aqui
    },

    async search() {
      if (this.query.length < 3) {
        this.results = [];
        return;
      }

      this.loading = true;
      this.error = false;

      try {
        const response = await axios.get(`http://localhost:5000/search?query=${this.query}`);
        this.results = response.data;
      } catch (e) {
        this.error = true;
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
  },
};
</script>

<style scoped>
/* Estilos gerais */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: 'Arial', sans-serif;
  background-color: #f4f7fa;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  padding: 20px;
}

/* Centralização da div com o campo de pesquisa */
#app {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 100%;
  height: 100vh;
  text-align: center;
}

.search-container {
  width: 100%;
  max-width: 600px;
  background: white;
  padding: 30px;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  margin-top: 20px;
}

/* Estilo do campo de input */
.search-input {
  width: 100%;
  padding: 12px 15px;
  border-radius: 8px;
  border: 1px solid #ddd;
  font-size: 16px;
  margin-bottom: 20px;
  transition: border-color 0.3s ease;
}

.search-input:focus {
  border-color: #4a90e2;
  outline: none;
}

/* Estilo de carregamento e erro */
.loading,
.error {
  text-align: center;
  font-size: 16px;
  color: #888;
}

.loading {
  color: #f39c12;
}

.error {
  color: #e74c3c;
}

/* Estilos da lista de resultados */
.results-list {
  list-style-type: none;
  padding: 0;
  max-height: 400px; /* Define a altura máxima da lista */
  overflow-y: auto;  /* Permite rolar se a lista for muito grande */
  margin-top: 20px;
}

/* Estilos para os itens da lista de resultados */
.result-item {
  background: white;
  padding: 20px;
  margin-bottom: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.05);
  transition: transform 0.3s ease;
}

.result-item:hover {
  transform: translateY(-5px);
}

.result-header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
  font-size: 18px;
  color: #333;
}

.city {
  color: #7f8c8d;
  font-size: 14px;
}

.result-details {
  font-size: 14px;
  color: #666;
}

.result-details p {
  margin-bottom: 10px;
}

.result-details a {
  color: #4a90e2;
  text-decoration: none;
}

.result-details a:hover {
  text-decoration: underline;
}
</style>
