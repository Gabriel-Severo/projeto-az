<template>
  <div id="app">
    <Automoveis :automoveis="automoveis" :getDados="getDados.bind(this)"/>
  </div>
</template>

<script>
import Automoveis from './components/Automoveis.vue'
import axios from 'axios'

export default {
  name: 'App',
  data: () => ({automoveis: []}),
  methods: {
    async getDados(){
      this.automoveis = await axios.get("http://localhost:8080/automoveis").then(value => value.data)
    }
  },
  components: {
    Automoveis
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
</style>
