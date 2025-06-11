<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.time.LocalDate" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/partviewer.css">
    <title>Document</title>
</head>

<body>
    <header>
        <img src="/img/pio_logo.jpeg" alt="pioneers football academy">
        <h1>PFA Summer Football Clinic</h1>
    </header>
    <div class="participants">
        <h3>Participants</h3>
        <table>
            <thead>
                <tr>
                    <th>firstname</th>
                    <th>lastname</th>
                    <th>Date of Birth</th>
                    <th>Gender</th>
                    <th>Contact</th>
                </tr>
            </thead>
            <c:forEach var="m" items="${participants}">
                <tr>
                    <td>${m.childFirstname}</td>
                    <td>${m.childLastname}</td>


                    <td>${m.dob}</td>
                    <td>${m.gender}</td>
                    <td>${m.phone}</td>
                </tr>
            </c:forEach>
        </table>
    </div>


</body>

</html>


