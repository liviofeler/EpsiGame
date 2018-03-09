<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Inscription</title>
		<link type="text/css" rel="stylesheet" href="form.css"/>
	</head>
	<body>
		<form method="post" action="inscription">
			<fieldset>
				<legend>Inscription</legend>
				<label for="email">Adresse email<span class="requis">*</span></label>
				<input type="text" id="email" name="email" value="<c:out value="${utilisateur.email }"/>" size="20" maxlength="60" />
				<span class="erreur">${form.erreurs['email']}</span>
				<br/>
				
				<label for="motDePasse">Mot De Passe<span class="requis">*</span></label>
				<input type="password" id="motDePasse" name="motDePasse" value="" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['motDePasse']}</span>
				<br/>
				
				<label for="confirmation">Confirmation du Mot De Passe<span class="requis">*</span></label>
				<input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['confirmation']}</span>
				<br/>
				
				<label for="nom">Nom<span class="requis">*</span></label>
				<input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom }"/>" size="20" maxlength="60" />
				<span class="erreur">${form.erreurs['nom']}</span>
				<br/>
				
				<label for="prenom">Prénom<span class="requis">*</span></label>
				<input type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom }"/>" size="20" maxlength="60" />
				<span class="erreur">${form.erreurs['prenom']}</span>
				<br/>
				
				<label for="adresse">Adresse<span class="requis">*</span></label>
				<input type="text" id="adresse" name="adresse" value="<c:out value="${utilisateur.adresse }"/>" size="60" maxlength="255" />
				<span class="erreur">${form.erreurs['adresse']}</span>
				<br/>
				
				<p> Vous jouez sur quelle plateforme : <br/>
				<label for="pc"> PC </label>
				<input type="checkbox" id="pc" name="pc"/>
				<label for="console"> Console</label>
				<input type="checkbox" id="console" name="console"/>
				<br/>
				
				<input type="submit" value="Inscription" class="sansLabel"/>
				<br/>
				
				<p class="${empty form.erreurs ? 'succes':'erreur'}">${form.resultat }</p>		
			</fieldset>
		</form>
	</body>
</html>