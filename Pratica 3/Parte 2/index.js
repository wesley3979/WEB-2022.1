const express = require('express')
const app = express()
app.use(express.static('public'));
const port = 8080

app.set('view engine', 'ejs');
app.set('views', './views');

const bdProdutos = require('./repositories/BDCategorias');

app.get('/category', (req, res) => {
  const categories = [
    {
      id: 1,
      value: 'value',
    }
  ]
  res.render('categoryPage', { title: 'Categorias', categories });
});

app.post('/category/category-delete', (req, res) => {
  const name = req.params.cname;

  console.log(name)
  res.redirect('/')
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

