const selectBodegaLista = document.querySelector('#selectBodegaLista');
const datatableBody = document.querySelector('#datatableBody');
let table = $('#datatable').DataTable();
let endpoint = getEndpoint(selectBodegaLista);
fillTable(endpoint);

selectBodegaLista.addEventListener('change', (x) => {
    let endpoint = getEndpoint(selectBodegaLista);
    fillTable(endpoint);
});

function getEndpoint(e) {
    let index = e.selectedIndex;
    let idBodega = e.options[index].value;
    let endpoint = window.location.href.split('producto')[0] + `api/producto/${idBodega}`;
    return endpoint;
}



function fillTable(endpoint) {
    getMethodToAPI(endpoint).done((res) => {
        let dataRes = [];
        for (let i = 0; i < res.length; i++) {
            let tmp = [];
            tmp.push(res[i].nombre);
            tmp.push(res[i].grado);
            tmp.push(res[i].cantidad_total);
            tmp.push(res[i].cantidad_cajas);
            tmp.push(res[i].ingreso);
            tmp.push(res[i].idBodega);
            dataRes.push(tmp);
        }
        table.clear();
        table.rows.add(dataRes).draw();
    });
}