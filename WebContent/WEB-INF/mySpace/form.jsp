		<form method="post" action="mySpace" class="center col" style="width: 100%; margin: auto;">
			<h3>Mon Compte</h3>
			<div>
				<span class="erreur">${erreurs['email']}</span>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="nom" class="mdl-textfield__input" type="text" required id="in1" value="${form['nom']}">
				<label class="mdl-textfield__label" for="in1">Nom</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="prenom" class="mdl-textfield__input" type="text" required id="in5" value="${form['prenom']}">
				<label class="mdl-textfield__label" for="in5">Prenom</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="address" class="mdl-textfield__input" type="text" required id="autocomplete" value="${form['address']}">
				<label class="mdl-textfield__label" for="autocomplete">Adresse</label>
			</div>

				<input value="Modifier" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
			</div>
			<p class="info">${actionMessage}</p>
		</form>