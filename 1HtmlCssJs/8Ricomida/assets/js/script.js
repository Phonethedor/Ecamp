var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl)
})

$(document).ready(function(){

    $('#enviarCorreo').click(function(){
        alert("El correo fue enviado correctamente...");
    });

    $('h2').on('dblclick', function(){
        $(this).css('color', 'red');
    });

    $('.card-title').click(function(){
        $('.card-text').toggle();
    });
});

