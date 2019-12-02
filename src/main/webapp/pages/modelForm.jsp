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
                            <h1>${action} model <small>using ${title}</small></h1>
                        </div>
                    </div>
                    <div class="panel-body">
                        <form:form method="POST" modelAttribute="carModel" class="form-horizontal">
                            <form:hidden path="idModel"/>
                            <div class="form-group">
                                <label for="idBrand" class="col-sm-3 control-label">Brand:</label>
                                <div class="col-sm-9">
                                    <form:select path="idBrand" multiple="false" class="form-control">
                                        <c:forEach var="brand" items="${listCarBrand}" varStatus="status">
                                            <c:choose>
                                                <c:when test="${brand.idBrand == carModel.idBrand}">
                                                    <option selected value="${brand.idBrand}">${brand.name}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${brand.idBrand}">${brand.name}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="modelName" class="col-sm-3 control-label">Model:</label>
                                <div class="col-sm-9">
                                    <form:input path="modelName" class="form-control" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="generation" class="col-sm-3 control-label">Generation:</label>
                                <div class="col-sm-9">
                                    <form:input path="generation" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="productionYear" class="col-sm-3 control-label">Production year:</label>
                                <div class="col-sm-9">
                                    <form:input path="productionYear" class="form-control" type="number" min="1800"
                                                max="2050"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="doors" class="col-sm-3 control-label">Doors:</label>
                                <div class="col-sm-9">
                                    <form:input path="doors" class="form-control" type="number" min="0" max="10"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="seats" class="col-sm-3 control-label">Seats:</label>
                                <div class="col-sm-9">
                                    <form:input path="seats" class="form-control" type="number" min="0" max="50"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="maximumSpeed" class="col-sm-3 control-label">Max speed:</label>
                                <div class="col-sm-9">
                                    <form:input path="maximumSpeed" class="form-control" type="number" min="0" max="550"/>
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