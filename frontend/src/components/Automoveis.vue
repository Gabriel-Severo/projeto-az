<template>
  <div class="automoveis">
    <div class="automovel-classificao">
      <h3>Id</h3>
      <h3>Marca</h3>
      <h3>Modelo</h3>
      <h3>Valor</h3>
    </div>
    <Automovel v-for="(automovel, x) in nvendidos" :key=x :automovel=automovel :getNVendidos=getNVendidos.bind(this) />
  </div>
</template>

<script>
import Automovel from './Automovel.vue'
export default {
  name: 'Automoveis',
  data: () => ({nvendidos: []}),
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
    await this.getNVendidos()
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
