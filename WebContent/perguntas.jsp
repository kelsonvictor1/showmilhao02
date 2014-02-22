<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX based CRUD operations using jTable in Servlet and JSP</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#PerguntasTableContainer').jtable({
            title: 'Gerenciamento das Perguntas',
            actions: {
                listAction: 'CRUDControllerPerguntas?action=list',
                createAction:'CRUDControllerPerguntas?action=create',
                updateAction: 'CRUDControllerPerguntas?action=update',
                deleteAction: 'CRUDControllerPerguntas?action=delete'
            },
            fields: {
            	titulo: {
                 title:'Título',
                 width: '50%',
				 edit:true	                 	
                },
                alternativa1: {
                    title: 'Alternativa 1',
                    width: '30%',
                    edit:true
                },
                alternativa2: {
                    title: 'Alternativa 2',
                    width: '30%',
                    edit:true
                },
                alternativa3: {
                    title: 'Alternativa 3',
                    width: '30%',
                    edit:true
                },
                alternativa4: {
                    title: 'Alternativa 4',
                    width: '30%',
                    edit:true
                },
                alternativa5: {
                    title: 'Alternativa 5',
                    width: '30%',
                    edit:true
                },
                alternativa_correta: {
                    title: 'Alternativa Correta',
                    width: '30%',
                    edit:true
                },
                
                pontuacao: {
                    title: 'Pontuação',
                    width: '30%',
                    edit:true
                }
                            
            }
        });
        $('#PerguntasTableContainer').jtable('load');
    });
</script>
</head>
<body>
<div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
<h1>AJAX based CRUD operations in Java Web Application using jquery jTable plugin</h1>
<h4>Demo by Priya Darshini, Tutorial at <a href="http://www.programming-free.com/2013/07/setup-load-data-jtable-jsp-servlet.html">www.programming-free.com</a></h4>
<div id="PerguntasTableContainer"></div>
</div>
</body>
</html>