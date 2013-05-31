app=angular.module 'ticketsRestaurant', []
app.config ($routeProvider)->
  $routeProvider.when '/',
    controller:'UserAccessController'
    templateUrl:'/views/userAccessView.html'

