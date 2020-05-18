<template>
    <div class="automovel">
        <div class="automovel-box">
            <span> {{ automovel.id }} </span>
            <span> {{ automovel.marca }} </span>
            <span> {{ automovel.modelo}} </span>
            <span> R$ {{ automovel.valorVenda.toFixed(2) }} </span>
            <button class="vender-btn" @click="handleVender(automovel)">Vender</button>
            <button class="atualizar-btn" @click="handleAtualizar(automovel)">Atualizar</button>
            <button class="excluir-btn" @click="handleExcluir(automovel)">Excluir</button>
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
        async handleAtualizar(automovel){
            this.$root.$emit('atualizar', automovel)
        },
        async handleVender(automovel){
            if(confirm(`Você tem certeza que deseja vender o automóvel\nMarca: ${automovel.marca}\nModelo: ${automovel.modelo}?`)){
                await axios.get(`http://localhost:8080/venda/${automovel.id}`)
                await this.getDados()
                this.$root.$emit('reset')
            }
        },
        async handleExcluir(automovel){
            if(confirm(`Você tem certeza que deseja excluir o automóvel\nMarca: ${automovel.marca}\nModelo: ${automovel.modelo}?`)){
                await axios.delete(`http://localhost:8080/automoveis/${automovel.id}`)
                await this.getDados()
                this.$root.$emit('reset')
            }
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
  grid-template-columns: 0.5fr 2fr 2fr 2fr 1fr 1fr 1fr;
}

.automovel-box {
  border: 1px solid rgba(0, 0, 0, 0.2)
}
.automovel-box button {
    cursor: pointer;
}
.excluir-btn {
    background-color: #9009;
}
.vender-btn {
    background-color: #0909;
}
.atualizar-btn {
    background-color: #0058; 
}
.excluir-btn:hover {
    background-color: #f009;
}
.vender-btn:hover {
    background-color: #0f09;
}
.atualizar-btn:hover {
    background-color: #00f8; 
}
</style>