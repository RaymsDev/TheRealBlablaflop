		<form method="post" action="mySpace" class="center col" style="width: 100%; margin: auto;">
			<h3>Mon Compte</h3>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="nom" class="mdl-textfield__input" type="text" id="in1" value="${form['nom']}">
				<label class="mdl-textfield__label" for="in1">Nom</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="prenom" class="mdl-textfield__input" type="text" id="in5" value="${form['prenom']}">
				<label class="mdl-textfield__label" for="in5">Prenom</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="address" class="mdl-textfield__input" type="text" id="autocomplete" value="${form['address']}">
				<label class="mdl-textfield__label" for="autocomplete">Adresse</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="pwd1" class="mdl-textfield__input" type="password" required id="in3" value="${form['pwd1']}">
				<label class="mdl-textfield__label" for="in3">Mot de passe</label>
			</div>
			<div>
				<span class="erreur">${erreurs['pwd1']}</span>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="pwd2" class="mdl-textfield__input" type="password" id="in4" value="${form['pwd2']}">
				<label class="mdl-textfield__label" for="in1">Nouveau mot de passe</label>
			</div>
			<div>
				<span class="erreur">${erreurs['pwd2']}</span>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="pwd3" class="mdl-textfield__input" type="password" id="in6" value="${form['pwd3']}">
				<label class="mdl-textfield__label" for="in3">Confirmation nouveau mot de passe</label>
			</div>
			<div>
				<span class="erreur">${erreurs['pwd3']}</span>
			</div>
			<div>
				<input value="Modifier" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
				<a href="deleteUser" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--red">Supprimer mon compte</a>
			</div>
			<p class="info">${actionMessage}</p>
		</form>