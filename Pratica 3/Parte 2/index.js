const express = require('express')
const app = express()
app.use(express.static('public'));
const port = 8081

app.set('view engine', 'ejs');
app.set('views', './views');

const bdcategories = require('./repositories/BDCategorias');

app.get('/category', (req, res) => {

  let categories = bdcategories.getCategories()

  res.render('categoryPage', { categories });
});

app.post('/category/add', (req, res) => {
  const { body } = req
  const name = body
  console.log(body)
  console.log(name)
  bdcategories.addCategory(name)

  res.redirect('/category')
});

app.get('/category/category-delete/:id', (req, res) => {
  const id = req.params.id;
  bdcategories.deleteCategories(id)

  res.redirect('/category')
});

app.get('/product', (req, res) => {
  res.render('productPage', { title: 'Produtos', message: 'Bem vindo aos produtos' });
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

