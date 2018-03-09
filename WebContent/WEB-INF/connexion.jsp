<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Connexion</title>
		<link type="text/css" rel="stylesheet" media="screen" href="<c:url value="/inc/form.css"/>" />
	</head>
	<body>
		<form method="post" action="connexion">
			<fieldset>
				<legend>Connexion</legend>
				<p> Vous pouvez vous connecter via ce formulaire </p>
				<c:if test="${empty sessionScope.sessionUtilisateur && !empty requestScope.intervalleConnexions }">
					<p class="info">(Vous ne vous êtes pas connecté(e) depuis ce navigateur depuis ${requestScope.intervalleConnexions })</p>
				</c:if>
				
				<label for="nom">Adresse email <span class="requis">*</span></label>
				<input type="text" id="email" name="email" value="<c:out value="${utilisateur.email }"/>" size="20" maxlength="60"/>
				<span class="errreur">${form.erreurs['email']}</span>
				<br/>
				
				<label for="motDePasse">Mot De Passe<span class="requis">*</span></label>
				<input type="password" id="motDePasse" name="motDePasse" value="" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['motDePasse']}</span>
				<br/>
				
				<br/>
				<label for="memoire">Se souvenir de moi</label>
				<input type="checkbox" id="memoire" name="memoire"/>
				<br/>
				
				<input type="submit" value="Connexion" class="sansLabel"/>
				<br/>
				
				<p class="${empty form.erreurs ? 'succes':'erreur'}">${form.resultat }</p>	
					<%-- Vérification de la présence d'un objet utilisateur en session --%>
						<c:if test="${!empty sessionScope.sessionUtilisateur }">
							<%-- Si l'utilisateur existe en session, alors on affiche son adresse mail --%>
							<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email }</p>
							</c:if>
			</fieldset>
		</form>


	</body>
</html>