<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="header.jsp"/>

<h1>Add new sensor</h1>


<form action="${pageContext.request.contextPath}/add/sensor" method="POST" enctype="multipart/form-data">
  <div class="form-group">
    <label for="exampleInputEmail1">Input Sensor ID</label>
    <input type="text" name="sensorId" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Sensor ID">
  </div>

  <div class="form-group">
      <input type="hidden" name="deviceId" class="form-control" value="${deviceId}">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<c:forEach var="error" items="${errors}">
<h2 color="red">${error.defaultMessage}</h2>
</c:forEach>

<jsp:include page="footer.jsp"/>