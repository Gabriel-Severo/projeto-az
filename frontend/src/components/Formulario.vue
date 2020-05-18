<template>
    <div class="formulario">
        <h3>Atualizar/Cadastrar automóvel</h3>
        <form @submit.prevent="handleSubmit">
            <label for="marca">Marca</label><input v-model="marca" id="marca" name="marca" type="text" required>
            <label for="modelo">Modelo</label><input v-model="modelo" id="modelo" name="modelo" type="text" required>
            <label for="valorvenda">Valor</label><input v-model="valorVenda" id="valorvenda" name="valorvenda" type="number" step="0.01" min="1" required>
            <div class="formulario-btn">
                <button type="submit">Salvar</button>
                <button @click="handleReset" type="reset">Cancelar</button>
            </div>
        </form>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'formulario',
    data: () => ({marca: null, modelo: null, valorVenda: null, id: null}),
    props: {
        getDados: Function
    },
    methods: {
        handleReset(){
            this.marca = null
            this.modelo = null
            this.valorVenda = null
            this.id = null
        },
        async handleSubmit() {
            if(!this.id){
                const automovel = {marca: this.marca, modelo: this.modelo, valorVenda: this.valorVenda}
                await axios.post(`http://localhost:8080/automoveis`, automovel)
            }else{
                const automovel = {marca: this.marca, modelo: this.modelo, valorVenda: this.valorVenda}
                await axios.put(`http://localhost:8080/automoveis/${this.id}`, automovel)
            }
            this.handleReset()
            await this.getDados()
        },
    },
    mounted(){
        this.$root.$on('atualizar', (automovel) => {
            this.marca = automovel.marca
            this.modelo = automovel.modelo
            this.valorVenda = automovel.valorVenda
            this.id = automovel.id
        })
        this.$root.$on('reset', this.handleReset)
    }
}
</script>

<style scoped>
.formulario {
    width: 48vw;
    height: 300px;
    border: 1px solid black;
    grid-area: b;
    padding: 10px;
}
.formulario form {
    display: flex;
    flex-direction: column;
}
.formulario input {
    border: 1px solid #0008;
    height: 24px;
    border-radius: 3px;
}
.formulario-btn {
    width: 170px;
    height: 30px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
.formulario-btn button {
    width: 80px;
    height: 100%;
    border-radius: 40px;
    margin-top: 10px;
    cursor: pointer;
}
.formulario-btn button:nth-child(1) {
    background-color: #0908;
}
.formulario-btn button:nth-child(2) {
    background-color: #9008;
}
@media (max-width: 960px) {
    .formulario {
        width: 100%;
        margin-top: 10px;
    }
}
</style>