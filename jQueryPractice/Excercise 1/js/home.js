$(document).ready(function () {
    $('h1').addClass('text-center');
    $('h2').addClass('text-center');
    $('.myBannerHeading').addClass('page-header');
    $('.page-header').removeClass('myBannerHeading');
    $('#yellowHeading').text('Yellow Team');
    $('.orange').css('background', 'orange');
    $('.blue').css('background', 'blue');
    $('.red').css('background', 'red');
    $('.yellow').css('background', 'yellow');
    $('#yellowTeamList').append('<li>Joseph Banks</li>');
    $('#yellowTeamList').append('<li>William Simons</li>');
    $('#oops').hide();
    $('#footerPlaceholder').remove();
    $('#footer').append('<p id="footerNameEmail"> Bruce Breslin brucebreslin22@gmail.com </p> ')
    $('#footerNameEmail').css({'font-family':'Courier', 'font-size':'24px'});

});
