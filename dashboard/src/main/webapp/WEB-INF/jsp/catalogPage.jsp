<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="header.jsp"/>

<h1>Intellectual electronic devices</h1>
<sec:authorize access="hasRole('ADMIN')">
<a class="btn btn-primary" href="${pageContext.request.contextPath}/add" role="button">Add new device</a>
</sec:authorize>
<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">Device ID</th>
      <th scope="col">Device Ip</th>
      <th scope="col">Feeder name</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="item" items="${items}">
    <tr>
      <th scope="row">${item.deviceId}</th>
      <td>${item.deviceIp}</td>
      <td><a href="${pageContext.request.contextPath}/product/item/${item.deviceId}">${item.feederName}</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>

<jsp:include page="footer.jsp"/>