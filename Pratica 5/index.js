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
app.get('/produto/meus-produtos', (req, res) => {
  //faltar fazer um get no user, arrumar o html e mostrar o nome do usuário no topo da pagina
  basic = Buffer.from(req.headers.authorization.split(' ')[1], 'base64').toString().split(':');
  username = basic[0];
  password = basic[1];
  console.log('Username: ' + username);
  console.log('Password: ' + password);

  res.render('homePage', { title: 'Home', message: 'Bem vindo as categorias e produtos' });
});


app.use('/produto/produto-novo', basicAuth({ authorizer: myAuthorizerMongo, authorizeAsync: true, challenge: true }));
app.get('/produto/produto-novo', (req, res) => {
  //falta fazer um get no user e mostra-lo na tela
  const categories = ["Comida", "Livro", "Computador", "Celular", "outro"]
  res.render('addProductPage', { user: 'Andre Meireles', categories });
});

app.post('/produto/produto-novopost', async (req, res) => {
  //falta fazer um get no user e salva-lo como "author"
  const product = {
    name: req.body.name,
    category: req.body.category,
    description: req.body.description,
    price: req.body.price
  }

  await database.insertProduct(product)

  //falta mandar redirecionar para meus-produtos
  res.render('homePage', { title: 'Home', message: '/produto/produto-novopost' });
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

