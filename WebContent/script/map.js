var destPos = {lat: 43.586938, lng: 1.493185};
var marker = null;
var markerDest = null;
var _pos = null;
var Gkey = 'AIzaSyBH0tjh8m9W5tnOAE1IogA6fTrXXTAzRAc';

function initMap() {
	var map = new google.maps.Map(document.getElementById('map'), {
	  center: {lat: 43.624992299999995, lng: 1.4319450999999999},
	  zoom: 12
	});
	
	marker = new google.maps.Marker({
		position: {lat: 43.624992299999995, lng: 1.4319450999999999},
		map: map,
		title: 'Ma position'
	});
	
	markerDest = new google.maps.Marker({
		position: destPos,
		map: map,
		title: 'Lieu de travail'
	});
	
	var canceled = false;
	$('#autoSearch').on('change', () => {
		canceled = true;
		$('#positionning').fadeOut(400);
	});
	
	if (navigator.geolocation) {
	  navigator.geolocation.getCurrentPosition(function(position) {
		if(canceled) return;
	    $('#positionning').fadeOut(400);
		var pos = {
		  lat: position.coords.latitude,
		  lng: position.coords.longitude
		};
		_pos = pos;
		marker.setPosition(pos);
		$('#next_step').prop('disabled', false);
		getGoogleRide();
	    map.setCenter(pos);
	  }, function() {
		  if(canceled) return;
		  handleLocationError(true, infoWindow, map.getCenter());
	  });
	} else {
		if(canceled) return;
		handleLocationError(false, infoWindow, map.getCenter());
    }
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(
		browserHasGeolocation ? 'Error: The Geolocation service failed.' : 'Error: Your browser doesn\'t support geolocation.'
	);
}

function updatePos(pos) {
	if(marker && pos.geometry) {
		marker.setPosition(pos.geometry.location);
		_pos = pos.geometry.location;
		$('#next_step').prop('disabled', false);
		getGoogleRide();
	}
}

function getGoogleRide() {
	var directionsService = new google.maps.DirectionsService;
	directionsService.route({
		origin: _pos,
		destination: destPos,
		travelMode: 'DRIVING'
  	}, function(response, status) {
	    if (status === 'OK') {
		  var light = {
			request: response.request,
			routes: response.routes.map(r => { return {
				legs: r.legs.map(l => {
					return {steps: l.steps.map(s => { return {lat_lngs: s.lat_lngs} })}
				})
			} })
		  }
		  var jsonRoute = JSON.stringify(light);
		  console.log(jsonRoute)
		  $('#json_route').val(jsonRoute);
		} else {
			window.alert('Directions request failed due to ' + status);
		}
    });
}