const express = require('express')
const basicAuth = require('express-basic-auth')
const app = express()
const port = 8081
const database = require('./db')

app.use(
  express.urlencoded({
    extended: true,
  }),
)

app.set('view engine', 'ejs');
app.set('views', './views');

app.use('/produto/meus-produtos', basicAuth({ authorizer: myAuthorizerMongo, authorizeAsync: true, challenge: true }));
app.get('/produto/meus-produtos', async (req, res) => {
  basic = Buffer.from(req.headers.authorization.split(' ')[1], 'base64').toString().split(':');
  username = basic[0];
  password = basic[1];

  const products = await database.getProductsByUser(username)

  res.render('myProductsPage', { user: username, products });
});


app.use('/produto/produto-novo', basicAuth({ authorizer: myAuthorizerMongo, authorizeAsync: true, challenge: true }));
app.get('/produto/produto-novo', (req, res) => {

  basic = Buffer.from(req.headers.authorization.split(' ')[1], 'base64').toString().split(':');
  username = basic[0];

  const categories = ["Comida", "Livro", "Computador", "Celular", "outro"]
  res.render('addProductPage', { user: username, categories });
});

app.post('/produto/produto-novopost', async (req, res) => {

  const product = {
    name: req.body.name,
    category: req.body.category,
    description: req.body.description,
    price: req.body.price,
    author: req.body.author
  }

  await database.insertProduct(product)

  const products = await database.getProductsByUser(username)

  res.render('myProductsPage', { user: username, products });
});

app.get('/', async (req, res) => {
  var products = await database.getAllProducts()
  res.render('productPage', { products });
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})

function myAuthorizerMongo(username, password, cb) {
  console.log(database.getUsers(username, password).then(users => {
    return cb(null, users.length > 0);
  }));
}

