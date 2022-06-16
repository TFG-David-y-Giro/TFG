document.getElementById("button_postItem").addEventListener("click", postItem);


function postItem() {
    var xhttp;
    xhttp = new XMLHttpRequest();
    var item_name = document.querySelector('#postItem_name').value;
    var item_price = document.querySelector('#postItem_price').value;
    var item_category = document.querySelector('#postItem_category').value;
    var item_supplier = document.querySelector('#postItem_supplier').value;
    var item_quantity = document.querySelector('#postItem_quantity').value;
    const Url = 'http://localhost:9090/item';
    const item = {
        name:item_name,
        price:item_price,
        category:item_category,
        supplier:item_supplier,
        quantity:item_quantity
    }
    console.log(item);
    $.ajax({
        type : "POST",
        contentType : "application/json",
        dataType : 'json',
        url : Url,
        data : JSON.stringify(item),
        timeout : 100000,
        headers : {
          'Accept' : 'application/json',
          'Content-Type' : 'application/json'
        },
        success : function(data) {
          console.log("SUCCESS: ", data);
        },
        error : function(e) {
          console.log("ERROR: ", e);
        },
        done : function(e) {
        }
    });
    alert("Producto añadido satisfactoriamente.");
}