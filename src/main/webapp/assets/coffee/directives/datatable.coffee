app.directive 'ticketsDatatable', ($browser)->
  {
    link: ($scope, element, iAttrs)->
      toWatch=element.attr 'tickets-datatable'
      $scope.$watch toWatch, (newValue, oldValue)->
        if newValue
          $(element).dataTable
            bFilter:false
       
        
  }
  