const selectProductoLista = document.querySelector('#selectProductoLista');
const list = document.querySelector('#list');
let endpoint = getEndpoint(selectProductoLista);
fillList(endpoint); 

selectProductoLista.addEventListener('change', (x) => {
    let endpoint = getEndpoint(selectProductoLista);
    fillList(endpoint); 
});

function getEndpoint(e) {
    let index = e.selectedIndex;
    let idBodega = e.options[index].value;
    let endpoint = window.location.href.split('producto')[0] + `api/producto/${idBodega}`;
    return endpoint;
}

function fillList(endpoint) {
    // GET method to endpoint
    getMethodToAPI(endpoint).done((res) => {
        // Fill List
        list.innerHTML = '';
        for (let i = 0; i < res.length; i++) {
            let div = document.createElement('div');
            let li = document.createElement('li');
            li.innerText = JSON.stringify(res[i]);
            div.appendChild(li);
            list.appendChild(div);
        }
    });
}
