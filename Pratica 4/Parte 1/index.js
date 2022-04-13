const express = require('express')
const app = express()
app.use(express.static('public'));
const port = 8080

app.set('view engine', 'ejs');
app.set('views', './views');

app.get('/home', (req, res) => {
  res.render('home', { title: 'Lab MPA', message: 'Bem vindo ao Lab MPA' });
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})

