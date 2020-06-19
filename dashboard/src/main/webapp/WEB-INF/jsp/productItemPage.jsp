<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<h1>DeviceID: ${item.deviceId}</h1>
<h1>DeviceIP: ${item.deviceIp}</h1>
<h1>Feeder: ${item.feederName}</h1>


<%--
<div class="card" style="width: 18rem;">
 <img src="${pageContext.request.contextPath}/product/item/${item.id}/image" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">DeviceIP+${item.deviceIp}</h5>
    <p class="card-text">${item.deviceId} </p>
  </div>
</div>

--%>

<p>Sensors connected:<p>
<c:forEach var="sensor" items="${sensors}">
   <p><a href="${pageContext.request.contextPath}/sensor/item/${sensor.sensorId}">SensorId: ${sensor.sensorId}</a></p>
</c:forEach>
<sec:authorize access="hasRole('ADMIN')">
<a class="btn btn-primary" href="${pageContext.request.contextPath}/add/sensor?deviceId=${item.deviceId}" role="button">Add new sensor</a>
</sec:authorize>

<jsp:include page="footer.jsp"/>