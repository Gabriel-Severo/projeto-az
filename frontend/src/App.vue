<template>
  <div id="app">
    <Automoveis :automoveis="nvendidos" :getDados="getDados.bind(this)"/>
    <Formulario :getDados="getDados.bind(this)"/>
  </div>
</template>

<script>
import Automoveis from './components/Automoveis.vue'
import Formulario from './components/Formulario.vue'
import axios from 'axios'

export default {
  name: 'App',
  data: () => ({automoveis: [], nvendidos: [], atualizarVeiculo: null}),
  methods: {
    async getDados(){
      this.automoveis = await axios.get("http://localhost:8080/automoveis").then(value => value.data)
      this.nvendidos = this.automoveis.filter(automovel => {
        return !automovel.vendido
      })
    }
  },
  components: {
    Automoveis,
    Formulario
  },
  async mounted() {
    await this.getDados()
  }
}
</script>

<style>
*{
  margin: 0;
  border: 0;
  box-sizing: border-box;
}
#app {
  display: flex;
  justify-content: space-between;
  margin: 10px;
}
</style>
