<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link media="all" rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/theme/basique/style.css" />
<title>Liste des plats</title>
</head>
<body>

	<div id="page">
		<div id="entete">
			<h1>Liste des plats</h1>
		</div>

		<div id="contenu">

			<%@ include file="listePlats.jspf"%>

		</div>

	</div>

</body>
</html>