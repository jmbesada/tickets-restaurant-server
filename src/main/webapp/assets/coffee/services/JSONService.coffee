app.service 'JSONService', ($http)->
  console.log 'Started the JSONService'
  @getUserAccess= ->
    $http.get '/statisticsController/getUserAccess'
  
  this.getUserInfo= (username)->
    $http.get '/statisticsController/getUserInfo',
      params:
        'username':username
    
