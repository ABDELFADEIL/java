<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Produits</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
  <%@include file="header.jsp"%>
  
  <div class="container col-md-8 col-md-offset-2 col-xs-12">
   <div class="card">
    <div class="card-header bg-primary">Recherche des produits</div>
     <div class="card-body">
        <form action="chercher.php" method="get" class="form-inline">
          <label class="mr-sm-2">Mot Clé</label>
          <input type="text" name="motCle" value="${model.motCle }" class="form-control mr-sm-2"/>
          <button type="submit" class="btn btn-outline-primary my-2 my-sm-0">Chercher</button>
        </form>
        <table class="table table-striped">
          <tr>
            <th>ID</th> <th>Désignation</th> <th>Prix</th> <th>Quantité</th><th>Supprimer</th><th>Editer</th>
          </tr>
          <c:forEach items="${model.produits}" var="p">
          <tr>
            <td>${p.id}</td>
            <td>${p.designation}</td>
            <td>${p.prix}</td>
            <td>${p.quantite}</td>
            <td><a onclick="return confirm(' vous etes sûr?')" href="Supprime.php?id=${p.id}">Supprimer</a></td>
            <td><a href="Edit.php?id=${p.id}">Edit</a></td>
          </tr>
          </c:forEach>
          
        
        </table>
     </div>
    </div>
  </div>
 
</body>
</html>