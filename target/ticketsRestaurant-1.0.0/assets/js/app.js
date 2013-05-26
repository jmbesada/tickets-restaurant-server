function getUserAccess(){
    $.ajax({
        url:'/statisticsController/getUserAccess',
        dataType:'json',
        success: function(resp){
            console.log(typeof resp);
            var markup="<tr><td align='center'>${username}</td><td align='center'>${accessNumber}</td></tr>";
            $.tmpl(markup, resp).appendTo('#userAccess .content tbody');
        }
    })
}
