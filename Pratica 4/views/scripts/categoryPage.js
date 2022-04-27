var customFields = ["Diego", "Gabriel", "Lucas"];

for (var i = 0; i < customFields.length; i++) {
  var lis = document.createElement('li');
  lis.innerHTML = customFields[i];
  lista.appendChild(lis);
}

//função para adicionar mais um nome à lista
function adicionar() {
  var coleta = document.getElementById("nome").value;
  var nomeDig = document.createElement('li');

  customFields.push(coleta);
  nomeDig.innerHTML = coleta;
  lista.appendChild(nomeDig);
}