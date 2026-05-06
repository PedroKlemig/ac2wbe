let projetos = [];

window.onload = function () {
    const dados = localStorage.getItem("projetos");
    if (dados) {
        projetos = JSON.parse(dados);
    }
    listarProjetos();
};

function salvarProjeto() {

    const projeto = {
        descricao: document.getElementById("descricao").value,
        dataInicio: document.getElementById("dataInicio").value,
        dataFim: document.getElementById("dataFim").value
    };

    projetos.push(projeto);

 
    localStorage.setItem("projetos", JSON.stringify(projetos));

    limparCampos();
    listarProjetos();
}


function listarProjetos() {

    const lista = document.getElementById("listaProjetos");
    lista.innerHTML = "";

    projetos.forEach(p => {
        const li = document.createElement("li");
        li.innerHTML = `
            <strong>${p.descricao}</strong><br>
            Início: ${p.dataInicio}<br>
            Fim: ${p.dataFim}
        `;
        lista.appendChild(li);
    });
}


function limparCampos() {
    document.getElementById("descricao").value = "";
    document.getElementById("dataInicio").value = "";
    document.getElementById("dataFim").value = "";
}