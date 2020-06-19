<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="header.jsp"/>

<h1>Add new device</h1>
<%--
<script type="text/javascript" src="./lib/jquery-3.3.1.min.js"></script>
    <script>
    $(document).ready(function() {
    	var max_fields      = 10; //maximum input boxes allowed
    	var wrapper   		= $(".input_fields_wrap"); //Fields wrapper
    	var add_button      = $(".add_field_button"); //Add button ID

    	var x = 1; //initial text box count
 $(wrapper).append(  '<c:set var="count" value="-2" scope="application" />')
    	$(add_button).click(function(e){ //on add input button click
    		e.preventDefault();
    		if(x < max_fields){ //max input box allowed
    			x++; //text box increment
    			$(wrapper).append('<div><c:set var="count" value="${count+2}" scope="application"/></div>'); //add input box
    			$(wrapper).append('<div><input type="number" name="currentSensorSet[${count}].sensorId" placeholder="${count}"/><a href="#" class="remove_field">Remove</a></div>'); //add input box
    			$(wrapper).append('<div><c:set var="count" value="${count+2}" scope="application"/></div>'); //add input box
    		}
    	});

    	$(wrapper).on("click",".remove_field", function(e){ //user click on remove text
    		e.preventDefault(); $(this).parent('div').remove(); x--;
    	})
    });
</script>
--%>

<form action="${pageContext.request.contextPath}/add/ied" method="POST" enctype="multipart/form-data">
  <div class="form-group">
    <label for="exampleInputEmail1">Feeder</label>
    <input type="text" name="feederName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">ID</label>
    <input type="number" name="deviceId" class="form-control" id="exampleInputPassword1" placeholder="Enter ID">
  </div>
  <div class="form-group">
      <label for="exampleInputPassword2">IP</label>
      <input type="number" name="deviceIp" class="form-control" id="exampleInputPassword1" placeholder="Enter IP">
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<c:forEach var="error" items="${errors}">
<h2 color="red">${error.defaultMessage}</h2>
</c:forEach>

<jsp:include page="footer.jsp"/>