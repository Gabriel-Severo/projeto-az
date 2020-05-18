<template>
    <div class="automovel">
        <div class="automovel-box">
            <span> {{ automovel.id }} </span>
            <span> {{ automovel.marca }} </span>
            <span> {{ automovel.modelo}} </span>
            <span> {{ automovel.valorVenda.toFixed(2) }} </span>
            <button @click="handleVender(automovel)">Vender</button>
            <button>Atualizar</button>
            <button @click="handleExcluir(automovel)">Excluir</button>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'Automovel',
    props: {
        automovel: Object,
        getDados: Function
    },
    methods: {
        async handleVender(automovel){
            if(confirm(`Você tem certeza que deseja vender o automóvel\nMarca: ${automovel.marca}\nModelo: ${automovel.modelo}?`))
                await axios.get(`http://localhost:8080/venda/${automovel.id}`)
                await this.getDados()
        },
        async handleExcluir(automovel){
            if(confirm(`Você tem certeza que deseja excluir o automóvel\nMarca: ${automovel.marca}\nModelo: ${automovel.modelo}?`))
            await axios.delete(`http://localhost:8080/automoveis/${automovel.id}`)
            await this.getDados()
        }
    },
    async mounted(){
        await this.getDados()
    }
}
</script>

<style scoped>
.automovel-box, .automovel-classificao {
  display: grid;
  grid-template-columns: repeat(7, 1fr);
}

.automovel-box {
  border: 1px solid rgba(0, 0, 0, 0.2)
}
</style>