<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.time.LocalDate" %>
<%@ page import="com.fowobi.pioneers.model.Participant" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>

    <%@ include file="header.jsp" %>
    <div class="participants">
        <h3>Participants</h3>
        <c:choose>
        <c:when test="${not empty participants}">
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>firstname</th>
                    <th>lastname</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Contact</th>
                </tr>
            </thead>
            <c:forEach var="m" items="${participants}">
                <tr>
                    <td>${m.id}</td>
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

        <form class="btn-download" action="/event/download">
            <button >Download</button>
        </form>
        </c:when>

        <c:otherwise>
         <p>There are no registered participants</p>
         </c:otherwise>
        </c:choose>


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


