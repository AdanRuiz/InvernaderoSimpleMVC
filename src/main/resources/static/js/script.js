document.getElementById('invernaderoForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const id = document.getElementById('id').value;
    const actuadorRiego = document.querySelector('input[name="actuadorRiego"]:checked').value;

    fetch('/api/invernadero/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ invernaderoId: id, actuadorRiego: actuadorRiego })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Invernadero agregado:', data);
        fetchInvernaderos();
    })
    .catch(error => console.error('Error:', error));
});

function mostrarDetalleInvernadero(id) {
    const form = document.createElement('form');
    form.method = 'POST';
    form.action = '/detalleInvernadero';
    const input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'id';
    input.value = id;
    form.appendChild(input);
    document.body.appendChild(form);
    form.submit(); 
}

function fetchInvernaderos() {
    fetch('/api/invernaderos')
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById('invernaderos-list');
            list.innerHTML = '';
            data.forEach(invernadero => {
                const listItem = document.createElement('li');
                listItem.textContent = `ID: ${invernadero.invernaderoId} - Tipo: ${invernadero.actuadorRiego}`;
                listItem.addEventListener('click', function() { mostrarDetalleInvernadero(invernadero.invernaderoId); }); 
                list.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error:', error));
}

// Fetch invernaderos on page load
fetchInvernaderos();
