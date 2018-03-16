		<form method="post" action="register" class="center col" style="width: 100%; margin: auto;">
			<h3>Inscription</h3>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="email" class="mdl-textfield__input" type="text" required id="in2" value="${form['email']}">
				<label class="mdl-textfield__label" for="in2">Adresse mail</label>
			</div>
			<div>
				<span class="erreur">${erreurs['email']}</span>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="nom" class="mdl-textfield__input" type="text" required id="in1" value="${form['nom']}">
				<label class="mdl-textfield__label" for="in1">Nom</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="prenom" class="mdl-textfield__input" type="text" required id="in5" value="${form['prenom']}">
				<label class="mdl-textfield__label" for="in5">Prénom</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input name="address" class="mdl-textfield__input" type="text" required id="autocomplete" value="${form['address']}">
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
				<input name="pwd2" class="mdl-textfield__input" type="password" required id="in4" value="${form['pwd2']}">
				<label class="mdl-textfield__label" for="in1">Confirmation mot de passe</label>
			</div>
			<div>
				<span class="erreur">${erreurs['pwd2']}</span>
			</div>
			<div>
				<input value="Enregistrement" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
				<a class="mdl-button mdl-js-button" href="login">
				  J'ai un compte
				</a>
			</div>
			<p class="info">${actionMessage}</p>
			<p class="erreur">${errorMessage}</p>
		</form>