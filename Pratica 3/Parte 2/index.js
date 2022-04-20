const express = require('express')
const app = express()
const port = 8081

app.use(
  express.urlencoded({
    extended: true,
  }),
)
app.set('view engine', 'ejs');
app.set('views', './views');

const bdcategories = require('./repositories/BDCategorias');
const bdproducts = require('./repositories/BDProdutos');


app.get('/category', (req, res) => {

  let categories = bdcategories.getCategories()

  res.render('categoryPage', { categories });
});

app.post('/category/add', (req, res) => {
  const name = req.body.name
  bdcategories.addCategory(name)

  res.redirect('/category')
});

app.post('/product/add', (req, res) => {
  const name = req.body.name
  const description = req.body.description
  const price = req.body.price

  bdproducts.addProduct({ "name": name, "description": description, "price": price })

  res.redirect('/product')
});

app.get('/category/category-delete/:id', (req, res) => {
  const id = req.params.id;
  bdcategories.deleteCategories(id)

  res.redirect('/category')
});

app.get('/product/product-delete/:id', (req, res) => {
  const id = req.params.id;
  bdproducts.deleteProduct(id)

  res.redirect('/product')
});

app.get('/product', (req, res) => {
  let products = bdproducts.getProducts()
  res.render('productPage', { products });
});

//redirect user to another page
// app.post('/produto/produto-novo', (req, res) => {
//   let produto = req.body;
//   bdProduto.addProduto(produto); 
//   res.redirect('/produto/produto-listar');
// });

app.get('/', (req, res) => {
  res.render('homePage', { title: 'Home', message: 'Bem vindo as categorias e produtos' });
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})

