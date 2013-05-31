app.controller 'UserAccessController', ($scope, $browser, JSONService)->
  console.log 'Started the UserAccessController'
  JSONService.getUserAccess().success (data)->
    $scope.userAccessList=data
    $browser.defer ->
      $('#datatable').dataTable
        bFilter:false
        aaSorting:[[1, 'desc']]
 
