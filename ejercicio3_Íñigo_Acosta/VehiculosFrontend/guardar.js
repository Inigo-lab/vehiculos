let form = document.getElementById('guardar')
let form2 = document.getElementById('buscar')
let form3 = document.getElementById('calcular')


form.addEventListener('submit', function(e){
    e.preventDefault()

    let marca = document.getElementById('marca').value
    let modelo = document.getElementById('modelo').value
    let precioAlquiler = document.getElementById('precioAlquiler').value

    saveCar(marca, modelo, precioAlquiler)

    form.reset()

})

function saveCar(marca, modelo, precioAlquiler){

    const data = {
        marca : marca,
        modelo : modelo,
        precioAlquiler : precioAlquiler
    }

    fetch('http://localhost:8080/api/vehiculo' ,{ 
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(function(res){
        if(res.ok) console.log(res)
    })
    .catch(function(error){
        console.log(error)
    })


}

form2.addEventListener('submit',function(e){
    e.preventDefault()

    let marca = document.getElementById('busMarca').value
    let modelo = document.getElementById('busModelo').value
    let contenedor = document.getElementById('busqueda')

    if(modelo==''){
        fetch(`http://localhost:8080/api/vehiculo/by-marca/${marca}`)
        .then( function(res){
            return res.json()
        }).then(data => {
             console.log(data)


            for(let i of data){
                contenedor.innerHTML += 'ID ' + i.id + '<br>' + 'MARCA ' + i.marca + '<br>' + 'MODELO ' + i.modelo + '<br>' + 'PRECIO ' + i.precioAlquiler + '<br>'
            }
        }) 
    }

    if(marca==''){
        fetch(`http://localhost:8080/api/vehiculo/by-modelo/${modelo}`)
            .then( function(res){
                return res.json()
            }).then(data => {
                 console.log(data)


                for(let i of data){
                    contenedor.innerHTML += 'ID ' + i.id + '<br>' + 'MARCA ' + i.marca + '<br>' + 'MODELO ' + i.modelo + '<br>' + 'PRECIO ' + i.precioAlquiler + '<br>'
                }
            })
    }

    fetch(`http://localhost:8080/api/vehiculo/${marca}/${modelo}`)
            .then( function(res){
                return res.json()
            }).then(data => {
                 console.log(data)


                for(let i of data){
                    contenedor.innerHTML += 'ID ' + i.id + '<br>' + 'MARCA ' + i.marca + '<br>' + 'MODELO ' + i.modelo + '<br>' + 'PRECIO ' + i.precioAlquiler + '<br>'
                }
            })

    form2.reset()

})

form3.addEventListener('submit',function(e){

    e.preventDefault()

    let vehiculo = document.getElementById('vehiculo').value
    let dias = parseFloat(document.getElementById('dias').value)
    let contenedor = document.getElementById('calculo')
    let valor = ''

    fetch(`http://localhost:8080/api/vehiculo/by-modelo/${vehiculo}`)
        .then( function(res){
            return res.json()
        }).then(data => {
            console.log(data)

            for(let i of data){
                valor = parseFloat(i.precioAlquiler)
            }
    
            fetch(`http://localhost:8080/api/vehiculo/importe-total/${valor}/${dias}`)
                .then(function(res){
                    return res.json()
                }).then(data =>{
                    console.log(data)

                    contenedor.innerHTML = 'Importe total: ' + data + "€"
                })
        })

    form3.reset()
})
