var products = [
  {
    "id": 0,
    "name": "wesley",
    "description": "Alguma descrição",
    "price": '12.25'
  },
  {
    "id": 1,
    "name": "wesley",
    "description": "Alguma descrição",
    "price": '12.25'
  },
]

function addProduct(product) {
  products.push({ id: setNextId(), name: product.name, description: product.description, price: product.price });
}

function getProducts() {
  return products;
}

function deleteProduct(id) {
  products = products.filter((product) => product.id !== parseInt(id))
  return products;
}

function setNextId() {
  if (products.length <= 0)
    return 0;

  return products[products.length - 1].id + 1;
}

exports.addProduct = addProduct;
exports.getProducts = getProducts;
exports.deleteProduct = deleteProduct;

