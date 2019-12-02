<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="page_components/imports.jsp"></c:import>
    <title>${title}</title>
</head>
<body>
    <c:import url="page_components/header.jsp"></c:import>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="text-center">
                            <h1>${action} brand <small>using ${title}</small></h1>
                        </div>
                    </div>
                    <div class="panel-body">
                        <form:form method="POST" modelAttribute="carBrand" class="form-horizontal">
                            <form:hidden path="idBrand"/>
                            <div class="form-group">
                                <label for="name" class="col-sm-3 control-label">Brand name:</label>
                                <div class="col-sm-9">
                                    <form:input path="name" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="foundedYear" class="col-sm-3 control-label">Founded year:</label>
                                <div class="col-sm-9">
                                    <form:input path="foundedYear" class="form-control" type="number" min="1800"
                                                max="2050"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="headquarter" class="col-sm-3 control-label">Headquarter:</label>
                                <div class="col-sm-9">
                                    <form:input path="headquarter" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-9">
                                    <button type="submit" class="btn btn-primary">Save</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>