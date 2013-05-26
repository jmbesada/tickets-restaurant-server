<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <link href="/app.css" rel="stylesheet"/>
    <script src="/jquery-1.9.1.js"></script>
    <script src="/jquery.tmpl.js"></script>
    <script src="/app.js"></script>
</head>
<body>
    <div id="container">
        <div id="userAccess">
             <div class="header">Access user list</div>
             <div class="content">
                <table>
                    <thead>
                        <tr>
                            <th>Usuario</th>
                            <th>Número de accesos</th>
                        </tr>
                    </thead>
                    <tbody>
                       
                       
                    </tbody>
                </table>
             </div>
        </div>
       
    </div>
    <script>
    getUserAccess();
    </script>
</body>
</html>