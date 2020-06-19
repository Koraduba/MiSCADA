<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<h1>SensorID: ${item.sensorId}</h1>

<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">Time Stamp</th>
      <th scope="col">Value</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="value" items="${values}">
    <tr>
      <td>${value.timeStamp}</td>
      <td>${value.sensorValue}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>


<jsp:include page="footer.jsp"/>