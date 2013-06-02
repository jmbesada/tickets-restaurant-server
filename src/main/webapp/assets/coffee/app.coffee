app=angular.module 'ticketsRestaurant', []
app.config ($routeProvider)->
  $routeProvider.when '/',
    controller:'UserAccessController'
    templateUrl:'/views/userAccessView.html'
  $routeProvider.when '/userDetail',
    controller:'UserDetailController'
    templateUrl:'/views/userDetail.html'

