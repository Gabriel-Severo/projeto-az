<template>
  <div class="automoveis">
    <div class="automovel-classificao">
      <h3>Id</h3>
      <h3>Marca</h3>
      <h3>Modelo</h3>
      <h3>Valor</h3>
    </div>
    <Automovel v-for="(automovel, x) in automoveis" :key=x :automovel=automovel :getDados=getDados.bind(this) />
  </div>
</template>

<script>
import Automovel from './Automovel.vue'
export default {
  name: 'Automoveis',
  props: {
    automoveis: Array,
    getDados: Function
  },
  components: {
    Automovel
  },
  methods: {
    async getNVendidos(){
      await this.getDados()
      this.nvendidos = this.automoveis.filter(automovel => {
        return !automovel.vendido
      })
    }
  },
  async mounted(){
    await this.getDados()
  }
}
</script>

<style scoped>
.automoveis {
  border: 1px solid black;
  width: 48vw;
  height: 300px;
  overflow: auto;
}
.automovel-classificao {
  display: grid;
  grid-template-columns: repeat(7, 1fr);
}
</style>
