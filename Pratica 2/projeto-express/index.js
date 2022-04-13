const express = require('express')
const app = express()
app.use(express.static('public'));
const port = 8080

var animals = [
    {animal:"DOG", name:"Pluto"},
    {animal:"CAT", name:"Hercules"},
    {animal:"BIRD", name:"Tweety"},
    {animal:"DOG", name:"Spiff"},
    {animal:"CAT", name:"Tom"},
    {animal:"BIRD", name:"Road Runner"}
]

app.use(express.json())
app.use(express.urlencoded({ extended: true }))

app.post('/mirror', function (req, res, next) {
    res.send(req.body)
})

app.get('/querytojson', (req, res) => {
    res.send(req.query);
})

app.get('/paramtojson/name/:name/role/:role', (req, res) => {
    res.send(req.params);
})

app.get('/animal', (req, res) => {
    var list = new Array();
    var contador=0;
    
    if(req.query.name){
        for (let index = 0; index < animals.length; index++) {
            if (animals[index].name.indexOf(req.query.name) != -1){
                
                list[contador] = animals[index];
                contador++;
            }
        }
    }
    
    if(req.query.animal){
        for (let index = 0; index < animals.length; index++) {
            if (animals[index].animal.indexOf(req.query.animal) != -1){
                
                list[contador] = animals[index];
                contador++;
            }
        }
    }
    
    res.send(list);
    
    for (let i = 0; i < list.length; i++) {
        list[i] = "";
    }
    
    
    
});


app.get('/animals', (req, res) => {
    var list = new Array();
    var contador=0;
    for (let index = 0; index < animals.length; index++) {
        
        if (animals[index].animal.indexOf(req.query.animal) != -1){
            
            list[contador] = animals[index];
            contador++;
        }
    }
    res.send(list);
    for (let i = 0; i < list.length; i++) {
        list[i] = "";
    }
});

app.get('/', (req, res) => {
 res.send('Hello World!')
})

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
    })