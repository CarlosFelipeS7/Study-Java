<%@page contentType = "text/html" pageEncoding="iso-8859-1" %>
<!DOCTYPE html>
<html>

    <head>
      
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>JSP Page</title>
  
        
        <!-- Importa a biblioteca principal do jQuery (facilita manipulação do DOM, eventos e AJAX) -->
        <script src ="${pageContext.request.contextPath}/js/query-3.3.1.min.js"></script>
        
        <!-- jQuery Mask: biblioteca que permite aplicar máscaras em inputs (ex: CPF, telefone, CEP) -->
        <script src ="${pageContext.request.contextPath}/js/query.mask.min.js"></script>
        
        <!-- jQuery MaskMoney: biblioteca usada para formatar campos monetários (R$, US$, etc.) -->
        <script src ="${pageContext.request.contextPath}/js/query.maskMoney.min.js"></script>
        
      
        
        <!--       SCRIPT PRINCIPAL        -->
        <script src="${pageContext.request.contextPath}/js/app.js" type="text/javascript"></script>
        
    
   
        <!-- Importa o CSS do Bootstrap (estilização pronta para botões, tabelas, grid, etc.) -->
        <link rel ="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        
        <!-- Popper.js: dependência do Bootstrap para posicionar tooltips, dropdowns e popovers -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        
        <!-- Bootstrap JS: funcionalidades dinâmicas do Bootstrap (menus, modal, collapse, etc.) -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
      
        <!-- CSS do DataTables (plugin jQuery para tabelas dinâmicas: ordenação, pesquisa, paginação) -->
        <link rel ="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
        
        <!--DataTables (faz a tabela HTML se transformar em tabela interativa) -->
        <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js" type="text/javascript"></script>
        
      
        <!-- Biblioteca para exibir alertas -->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.3.1/dist/sweetalert2.all.min.js" type="text/javascript"></script>
        
    </head>
    
    <body>
       
    </body>
</html>
