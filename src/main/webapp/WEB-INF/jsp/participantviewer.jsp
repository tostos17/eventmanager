<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.time.LocalDate" %>
<%@ page import="com.fowobi.pioneers.model.Participant" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/partviewer.css">
    <title>Document</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.5/xlsx.full.min.js"></script>
    <script>src="js/downloader.js"</script>
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
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Contact</th>
                </tr>
            </thead>
            <c:forEach var="m" items="${participants}">
                <tr>
                    <td>${m.childFirstname}</td>
                    <td>${m.childLastname}</td>

                    <% int year = LocalDate.now().getYear(); %>
                    <c:set var="currentValue" value="${m}" />
                    <%
                        Participant p = (Participant) pageContext.getAttribute("currentValue");

                        int age = year - p.getDob().getYear();

                    %>

                    <td><%= age %></td>
                    <td>${m.gender}</td>
                    <td>${m.phone}</td>
                </tr>
            </c:forEach>
        </table>

        <form action="/event/download">
            <button >Download</button>
        </form>


        <span id="result"></span>
    </div>

    <script>
        function loadData() {
              const xhr = new XMLHttpRequest();
              xhr.open("GET", "http://localhost:8080/event/download", true);

              xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                  //const data = JSON.parse(xhr.responseText);
                  document.getElementById("result").innerHTML = "Download Succesful";
                }
              };

              xhr.send();
            }
    </script>

</body>

</html>


