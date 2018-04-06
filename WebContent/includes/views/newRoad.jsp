<div class="mdl-card mdl-shadow--2dp" style="width: 100%; height: 96%">
	<div class="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
	  <div class="mdl-tabs__tab-bar" style="justify-content:  flex-start">
	      <a href="#conducteur" class="mdl-tabs__tab is-active expand">
	      	<i class="material-icons">directions_car</i> Conducteur
	      </a>
	      <a href="#passager" class="mdl-tabs__tab expand">
	      	<i class="material-icons">person</i> Passager
	      </a>
	  </div>
	
	  <div class="mdl-tabs__panel is-active" id="conducteur">
	  	<form method="post" action="Ride" class="col" style="width: 100%; margin: auto;">
	  		<input type="hidden" id="json_route" name="google_ride" value="" />
	  		<label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="isSmokerAllowed">
			  <input type="checkbox" id="isSmokerAllowed" name="isSmokerAllowed" class="mdl-checkbox__input" checked>
			  <span class="mdl-checkbox__label">Fumeur</span>
			</label>
			<label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="isMusicAllowed">
			  <input type="checkbox" id="isMusicAllowed" name="isMusicAllowed" class="mdl-checkbox__input" checked>
			  <span class="mdl-checkbox__label">Musique</span>
			</label>
			<label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="isChildsAllowed">
			  <input type="checkbox" id="isChildsAllowed" name="isChildsAllowed" class="mdl-checkbox__input" checked>
			  <span class="mdl-checkbox__label">Enfants</span>
			</label>
			<div class="col marged" style="max-width: 300px">
				<div class="row" style="justify-content: space-between">
					<span>Je ne parle pas</span>
					<span>J'aime discuter</span>
				</div>
				<input class="mdl-slider mdl-js-slider" type="range" id="conversationLevel" name="conversationLevel" min="1" max="3" value="2" tabindex="0">
			</div>
			<div class="marged row" style="align-items: center">
				<span style="margin: 8px">Le</span>
				<div class="mdl-textfield mdl-js-textfield" style="max-width: 150px">
					<input class="mdl-textfield__input" type="date" id="dateRide" name="dateRide" required>
				</div>
				<span style="margin: 8px">à</span>
				<div class="mdl-textfield mdl-js-textfield" style="max-width: 75px">
					<input class="mdl-textfield__input" type="time" id="timeRide" name="timeRide" required>
				</div>
			</div>
			<div class="marged">
				<input type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" value="Enregistrer le trajet" />
			</div>
	  	
	  	</form>
	    
	  </div>
	  
	  <div class="mdl-tabs__panel" id="passager">
	    Je suis passager
	  </div>
	  
	</div>
</div>