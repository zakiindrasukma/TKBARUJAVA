<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <title>Toko Baru</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Toko, Baru, Wangon">
    <meta name="author" content="GitzJoey">
	
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/theme-yeti/css/bootstrap.min.css">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css">
	<link rel="stylesheet" type="text.css" href="${pageContext.request.contextPath}/resources/parsleyjs/src/parsley.css">
	<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap-fileinput/css/fileinput.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/datetimepicker/jquery.datetimepicker.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/datatables/media/css/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/datatables/extensions/Responsive/css/dataTables.responsive.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/metisMenu/dist/metisMenu.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/custom.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jQuery/jquery-2.x.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/datetimepicker/jquery.datetimepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JSON/json2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/flot/excanvas.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/flot/jquery.flot.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/flot/jquery.flot.pie.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/flot/jquery.flot.resize.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/flot/jquery.flot.time.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/datatables/media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/datatables/extensions/Responsive/js/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-fileinput/js/fileinput.min.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/parsley-config.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/parsleyjs/src/i18n/id.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/parsleyjs/src/i18n/en.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/parsleyjs/dist/parsley.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/parsley-locale.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/navgoco/src/jquery.cookie.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/metisMenu/dist/metisMenu.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
	
	<script type="text/javascript">
    	$(document).ready(function() {
			$(function () {
    			$('#menu').metisMenu();
    		});
    		
			$('.navgoco').navgoco({
        		accordion: true,
        		openClass: 'active',
        		save: true,
                cookie: {
                    name: 'navgoco',
                    expires: 1,
                    path: '/'
                },
                slide: {
                    duration: 400,
                    easing: 'swing'
                }
        	});
    	});
	</script>