<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Spring Boot Example</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <script
            src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular.min.js"></script>
    <script src="/js/angular.js"></script>
    <link rel="stylesheet"
          href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"/>
</head>
<body>
<div class="container" ng-app="app">
    <h1>${msg}</h1>

    <div class="row">
        <div>
            <form name="customerForm" action="http://localhost:8050/insertdata?&id=12&name=daniel&height=175&weight=70" method="get">
                <label>PatientId</label>
                <input type="text" name="id"/><br>
                <label>PatientName</label>
                <input type="text" name="name"/><br>
                <label>PatientHeight</label>
                <input type="text" name="height" /><br>
                <label>PatientWeight</label>
                <input type="text" name="weight" /><br>

                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>