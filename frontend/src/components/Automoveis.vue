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
  grid-area: a;
}
.automovel-classificao {
  display: grid;
  grid-template-columns: 0.5fr 2fr 2fr 2fr 1fr 1fr 1fr;
}
</style>
