app.controller 'UserAccessController', ($scope, $rootScope, $browser, $location, JSONService)->
  console.log 'Started the UserAccessController'
  JSONService.getUserAccess().success (data)->
    $scope.userAccessList=data
    
 
  

  $scope.viewUserDetail= (username)->
    JSONService.getUserInfo(username).success (data)->
      $rootScope.userDetail=data
      $location.path '/userDetail'
      