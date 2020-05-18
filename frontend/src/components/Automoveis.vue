<template>
  <div class="automoveis">
    <div class="automovel-classificao">
      <h3>Marca</h3>
      <h3>Modelo</h3>
      <h3>Valor</h3>
    </div>
    <div v-for="(automovel, x) in automoveis" :key=x class="automovel-box">
      <span> {{ automovel.marca }} </span>
      <span> {{ automovel.modelo}} </span>
      <span> {{ automovel.valorVenda.toFixed(2) }} </span>
      <button>Vender</button>
      <button>Atualizar</button>
      <button>Excluir</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Automoveis',
  props: {
    automoveis: Array,
    getDados: Function
  },
  mounted(){
    this.getDados()
  }
}
</script>

<style scoped>
.automoveis {
  border: 1px solid black;
  width: 500px;
  height: 300px;
  overflow: auto;
}

.automovel-box, .automovel-classificao {
  display: grid;
  grid-template-columns: repeat(6, 1fr);
}

.automovel-box {
  border: 1px solid rgba(0, 0, 0, 0.2)
}
</style>
