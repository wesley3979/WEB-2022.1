var produtos = []

function addProduto(produto) {
  produtos.push(produto);
}

function getProdutos() {
  return produtos;
}

exports.addProduto = addProduto;
exports.getProdutos = getProdutos;