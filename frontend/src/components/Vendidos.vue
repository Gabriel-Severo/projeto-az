<template>
    <div class="vendidos">
        <h3>Automóveis vendidos</h3>
        <div class="vendidos-box">
            <div v-for="(automovel, x) in automoveis" :key=x class="venda">
                <span>ID: {{ automovel.id }}</span>
                <span>Marca: {{ automovel.marca }}</span>
                <span>Modelo: {{ automovel.modelo }}</span>
                <span>Valor: R$ {{ automovel.valorVenda }}</span>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'vendidos',
    props: {
        automoveis: Array
    }
}
</script>

<style scoped>
.vendidos {
    grid-area: c;
}
.vendidos-box {
    width: 97.3vw;
    height: 300px;
    border: 1px solid black;
    margin-top: 10px;
    overflow: auto;
    display: grid;
    grid-template-columns: repeat(5, 1fr);
}
.venda {
    height: 80px;
    border-right: 1px solid black;
    border-bottom: 1px solid black;
    display: flex;
    flex-direction: column;
}
@media (max-width: 960px) {
    .vendidos-box {
        width: 100%;
        grid-template-columns: repeat(3, 1fr);
    }
}
</style>