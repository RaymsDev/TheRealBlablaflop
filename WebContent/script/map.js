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
		marker.setPosition(pos.geometry.location)
		$('#next_step').prop('disabled', false);
		getGoogleRide();
	}
}

function getGoogleRide() {
	var url = 'http://maps.googleapis.com/maps/api/distancematrix/json?origins=' +
		_pos.lat + ',' + _pos.lng + '&destinations=' + destPos.lat + ',' + destPos.lng;
	
	$.ajax({
        url: url, 
        type: "GET",   
        dataType: 'json',
        cache: false,
        success: function(response){
        	console.log(response);
        }           
    });
}