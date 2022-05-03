var products = [
  {
    "id": 0,
    "category": {
      "id": 0,
      "value": "wesley teste",
    },
    "name": "wesley",
    "description": "Alguma descrição",
    "price": '12.25'
  },
  {
    "id": 1,
    "category": {
      "id": 0,
      "value": "wesley cetegoria",
    },
    "name": "wesley",
    "description": "Alguma descrição",
    "price": '12.25'
  },
]

function addProduct(product) {
  products.push({ id: setNextId(), category: product.category, name: product.name, description: product.description, price: product.price, personalizado: product.personalizado });
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

function getProductById(id) {
  const product = products.find(x => x.id == id)

  if (product)
    return product;
  else
    return { "id": 0, "value": "sem produto" }
}

exports.addProduct = addProduct;
exports.getProducts = getProducts;
exports.getProductById = getProductById;
exports.deleteProduct = deleteProduct;

