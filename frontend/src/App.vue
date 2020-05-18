<template>
  <div id="app">
    <Automoveis :automoveis="nvendidos" :getDados="getDados.bind(this)"/>
    <Formulario :getDados="getDados.bind(this)"/>
    <Vendidos :automoveis="vendidos"/>
  </div>
</template>

<script>
import Automoveis from './components/Automoveis.vue'
import Formulario from './components/Formulario.vue'
import Vendidos from './components/Vendidos.vue'
import axios from 'axios'

export default {
  name: 'App',
  data: () => ({automoveis: [], nvendidos: [], atualizarVeiculo: null, vendidos: []}),
  methods: {
    async getDados(){
      this.automoveis = await axios.get("http://localhost:8080/automoveis").then(value => value.data)
      this.vendidos = this.automoveis.filter(automovel => {
        return automovel.vendido
      })
      this.nvendidos = this.automoveis.filter(automovel => {
        return !automovel.vendido
      })
      this.nvendidos.sort((a, b) => {
        if(a.id < b.id){
          return -1
        }
        if(a.id > b.id){
          return 1
        }
        return 0
      })
    }
  },
  components: {
    Automoveis,
    Formulario,
    Vendidos
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
  display: grid;
  grid-template-areas: 
  "a b"
  "c c";
  margin: 10px;
}
</style>
