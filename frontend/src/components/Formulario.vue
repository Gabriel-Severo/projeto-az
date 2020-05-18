<template>
    <div class="formulario">
        <form @submit.prevent="handleSubmit">
            <label for="marca">Marca</label><input v-model="marca" id="marca" name="marca" type="text" required>
            <label for="modelo">Modelo</label><input v-model="modelo" id="modelo" name="modelo" type="text" required>
            <label for="valorvenda">Valor</label><input v-model="valorVenda" id="valorvenda" name="valorvenda" type="number" step="0.01" required>
            <button type="submit">Salvar</button>
            <button type="reset">Cancelar</button>
        </form>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'formulario',
    data: () => ({marca: null, modelo: null, valorVenda: null}),
    props: {
        atualizarVeiculo: Number,
        getDados: Function
    },
    methods: {
        async handleSubmit(event) {
            const automovel = {marca: this.marca, modelo: this.modelo, valorVenda: this.valorVenda}
            await axios.post(`http://localhost:8080/automoveis`, automovel)
            await this.getDados()
            event.target.reset()
        }
    }
}
</script>

<style scoped>
.formulario {
    width: 48vw;
    height: 300px;
    border: 1px solid black;
}
.formulario form {
    display: flex;
    flex-direction: column;
}
.formulario input {
    border: 1px solid #dfdfdf;
}
</style>