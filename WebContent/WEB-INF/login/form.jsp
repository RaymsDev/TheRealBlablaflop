<form method="post" action="login" class="center col" style="width: 500px; margin: auto;">
	<h3>Connexion</h3>
	<p>Vous pouvez vous connecter via ce formulaire</p>
      
	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
		<input name="email" class="mdl-textfield__input" type="text" required id="in2" maxlength="60" value="${form.email}">
		<label class="mdl-textfield__label" for="in2">Adresse mail</label>
	</div>
	<div>
		<span class="erreur">${error['email']}</span>
	</div>
	
	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
		<input name="password" class="mdl-textfield__input" type="password" maxlength="20" required id="in3">
		<label class="mdl-textfield__label" for="in3">Mot de passe</label>
	</div>
	<div>
		<span class="erreur">${error['motdepasse']}</span>
	</div>

    <div>
		<input value="Connexion" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
		<a class="mdl-button mdl-js-button" href="register">
		  S'enregistrer
		</a>
	</div>
       
	<p class="${statusOK ? 'info' : 'erreur'}">${statusMessage}</p>
</form>