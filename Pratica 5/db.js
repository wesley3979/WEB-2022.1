const { MongoClient } = require('mongodb');

// Connection URL
const url = 'mongodb://localhost:27017';
const client = new MongoClient(url);

// Database Name
const dbName = 'teste';

var user_collection;
var product_collection;
async function main() {
  // Use connect method to connect to the server
  await client.connect();
  console.log('Connected successfully to server');
  const db = client.db(dbName);

  user_collection = db.collection('user');
  product_collection = db.collection('product');

  return 'done.';
}

main()
  .then(console.log)
  .catch(console.error);
//   .finally(() => client.close());

async function getUsers(username, password) {
  const findResult = await user_collection.find({ username: username, password: password }).toArray();
  return findResult;
}

async function getAllProducts() {
  const findResult = await product_collection.find({}).toArray();
  return findResult;
}

async function getProductsByUser(username) {
  const findResult = await product_collection.find({ author: username }).toArray();
  return findResult;
}

async function insertProduct(product) {
  const findResult = await product_collection.insertOne({
    "category": product.category,
    "name": product.name,
    "description": product.description,
    "price": product.price,
    "author": product.author
  });
  return findResult;
}

exports.getUsers = getUsers;
exports.getAllProducts = getAllProducts;
exports.insertProduct = insertProduct;
exports.getProductsByUser = getProductsByUser;

