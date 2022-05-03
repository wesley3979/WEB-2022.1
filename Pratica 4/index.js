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
  const personalizado = req.body.personalizado.split(",")
  bdcategories.addCategory(name, personalizado)

  res.redirect('/category')
});

app.get('/product/add', (req, res) => {
  let categories = bdcategories.getCategories()
  res.render('addProductPage', { categories });
});

app.post('/product/add', (req, res) => {
  const name = req.body.name
  const category = bdcategories.getCategoryById(req.body.category)
  const description = req.body.description
  const price = req.body.price
  const personalizado = req.body.personalizado

  bdproducts.addProduct({ "name": name, "category": category, "description": description, "price": price, "personalizado": personalizado })

  res.redirect('/product')
});


app.get('/category/category-delete/:id', (req, res) => {
  const id = req.params.id;
  bdcategories.deleteCategories(id)

  res.redirect('/category')
});

app.get('/product/product-edit/:id', (req, res) => {
  const product = bdproducts.getProductById(req.params.id)
  let categories = bdcategories.getCategories()
  res.render('editProductPage', { product, categories });
});

app.get('/product', (req, res) => {
  let products = bdproducts.getProducts()
  res.render('productPage', { products, });
});

app.get('/', (req, res) => {
  res.render('homePage', { title: 'Home', message: 'Bem vindo as categorias e produtos' });
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})

