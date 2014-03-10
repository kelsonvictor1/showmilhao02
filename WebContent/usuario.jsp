<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHOW-DO-MILHÃO</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#UsuariosTableContainer').jtable({
            title: 'Gerenciamento dos Usuários',
            actions: {
                listAction: 'CRUDControllerUsuario?action=list',
                createAction:'CRUDControllerUsuario?action=create',
                updateAction: 'CRUDControllerUsuario?action=update',
                deleteAction: 'CRUDControllerUsuario?action=delete'
            },
            fields: {
            	name: {
                 title:'Nome',
                 width: '50%',
				 edit:true	                 	
                },
                login: {
                    title: 'login',
                    width: '30%',
                    edit:true
                },
                senha: {
                    title: 'senha',
                    width: '30%',
                    edit:true
                }
             
            }
        });
        $('#UsuariosTableContainer').jtable('load');
    });
</script>
</head>
<body>
<div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
<h1>Usuário</h1>
<div id="UsuariosTableContainer"></div>
</div>
</body>
</html>