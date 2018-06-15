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
		<form method="post" action="AjouterJeux">
			<fieldset>
				<legend>Ajouter Jeux</legend>
				<label for="titre">Titre<span class="requis">*</span></label>
				<input type="text" id="titre" name="titre" value="<c:out value="${jeux.titre }"/>" size="20" maxlength="60" />
				<span class="erreur">${form.erreurs['titre']}</span>
				<br/>
				
				<label for="sousTitre">Sous-Titre<span class="requis">*</span></label>
				<input type="text" id="sousTitre" name="sousTitre" value="<c:out value="${jeux.sousTitre }"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['sousTitre']}</span>
				<br/>
				
				<label for="societeDeProduction">Societe de Production<span class="requis">*</span></label>
				<input type="text" id="societeDeProducion" name="societeDeProduction" value="<c:out value="${jeux.societeDeProduction }"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['societeDeProdution']}</span>
				<br/>
				
				<label for="description">Description<span class="requis">*</span></label>
				<input type="text" id="description" name="description" value="<c:out value="${jeux.description }"/>"  />
				<span class="erreur">${form.erreurs['description']}</span>
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