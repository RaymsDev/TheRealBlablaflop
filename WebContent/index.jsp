<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/includes/mdl.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">
	<title>Accueil | BlablaFlop</title>
</head>
<body style="height: 200%">
   	<c:import url="/WEB-INF/menu/menu.jsp" />
	<div style="height: 100%; margin-top: 64px;">
		<div id="map"></div>
		<div id="positionning">
			<span>Calcul de la position en cours</span>
			<div class="mdl-progress mdl-js-progress mdl-progress__indeterminate"></div>
		</div>
		<div class="row center">
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" id="searchbox">
				<input name="address" class="mdl-textfield__input" type="text" id="autoSearch" value="" spellcheck="false">
				<label class="mdl-textfield__label" for="autoSearch">Adresse</label>
			</div>
		</div>
		<div class="col center" style="margin: 15px">
			<button id="next_step" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" disabled>
			  &Eacute;tape suivante <i class="material-icons">arrow_downward</i>
			</button>
		</div>
	    <script src="script/map.js"></script>
	    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBH0tjh8m9W5tnOAE1IogA6fTrXXTAzRAc&libraries=places&callback=initMap"></script>
	    <script>
	    	var auto = new google.maps.places.Autocomplete(
    			document.getElementById('autoSearch'), 
    			{types: ['geocode']}
   			);
	    	auto.addListener('place_changed', function() {
	    		updatePos(auto.getPlace());
	    	});
	    	
	    	$('#next_step').on('click', function () {
	    	    $('html, body').animate({
	    	        scrollTop: $('#new_ride').offset().top
	    	    }, 500);
	    	});
	    </script>
	</div>
	<div id="new_ride" class="section" style="height: 100%; margin-top: 84px;">
		<%@ include file="/includes/views/newRoad.jsp" %>
	</div>
</body>
</html>
