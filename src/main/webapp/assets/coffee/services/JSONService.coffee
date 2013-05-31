app.service 'JSONService', ($http)->
  console.log 'Started the JSONService'
  this.getUserAccess= ->
    $http.get '/statisticsController/getUserAccess'
    
