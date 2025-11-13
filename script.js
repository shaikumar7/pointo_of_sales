fetch('ProductServlet')
  .then(response => response.json())
  .then(data => {
    let table = `<table class="table table-bordered table-hover">
                  <thead class="table-primary">
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Price (?)</th>
                      <th>Quantity</th>
                    </tr>
                  </thead><tbody>`;
    data.forEach(p => {
      table += <tr><td>${p.id}</td><td>${p.name}</td><td>${p.price}</td><td>${p.quantity}</td></tr>;
    });
    table += </tbody></table>;
    document.getElementById('productList').innerHTML = table;
  })
  .catch(err => console.error('Error loading products:', err));