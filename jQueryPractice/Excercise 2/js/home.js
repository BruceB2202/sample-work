$(document).ready(function () {

  $('tr').not(':first-child').hover(
    //in callback
    function(){
      $(this).css('background-color', 'WhiteSmoke');
    },
    //in callback
    function(){
      $(this).css('background-color', 'white');
    }
  );

  $('#akronInfoDiv').hide();
  $('#minneapolisInfoDiv').hide();
  $('#louisvilleInfoDiv').hide();

  $('#mainButton').on('click', function(){
    $('#mainInfoDiv').show();
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
  })

  $('#akronButton').on('click', function(){
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').show();
    $('#akronWeather').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
  })

  $('#minneapolisButton').on('click', function(){
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').hide();
    $('#minneapolisWeather').hide();
    $('#minneapolisInfoDiv').show();
    $('#louisvilleInfoDiv').hide();
  })

  $('#louisvilleButton').on('click', function(){
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').show();
    $('#louisvilleWeather').hide();
  })

  $('#akronWeatherButton').on('click', function(){
    $('#akronWeather').toggle();
  })

  $('#minneapolisWeatherButton').on('click', function(){
    $('#minneapolisWeather').toggle();
  })

  $('#louisvilleWeatherButton').on('click', function(){
    $('#louisvilleWeather').toggle();
  })




});
