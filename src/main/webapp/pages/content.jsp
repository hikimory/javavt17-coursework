<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="page_components/imports.jsp"></c:import>
    <title>CRUD - ${title}</title>
</head>
<c:import url="page_components/header.jsp"></c:import>
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-lg-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="text-center">
                            <h1>${title}<small> crud operations</small></h1>
                        </div>
                    </div>
                    <div class="alert alert-info" role="alert">
                        <a class="btn btn-primary" role="button"
                           href="${pageContext.request.contextPath}/${instrument}/pdfReport?view=pdfView" target="_blank">Download
                            PDF report</a>
                        <a class="btn btn-primary" role="button"
                           href="${pageContext.request.contextPath}/${instrument}/xlsxReport.xlsx?view=excelView"
                           target="_blank">Download Excel report</a>
                    </div>
                    <div class="panel-body">
                        <div class="panel panel-info">
                            <!-- Default panel contents -->
                            <div class="panel-heading">
                                <div class="text-center"><h3>Brands</h3></div>
                            </div>
                            <table class="table table-striped table-condensed" id="car-brands">
                                <thead>
                                <th>
                                    <button class="sort" data-sort="brand-name">brand</button>
                                </th>
                                <th>
                                    <button class="sort" data-sort="founded-year">founded</button>
                                </th>
                                <th>
                                    <button class="sort" data-sort="headquarter">headquarter</button>
                                </th>
                                <th>action</th>
                                </thead>
                                <tbody align="center" class="list">
                                <c:forEach var="brand" items="${listCarBrand}" varStatus="status">
                                    <tr>
                                        <td class="brand-name">${brand.name}</td>
                                        <td class="founded-year">${brand.foundedYear}</td>
                                        <td class="headquarter">${brand.headquarter}</td>
                                        <td class="action">
                                            <a href="${pageContext.request.contextPath}/${instrument}/edit-brand/${brand.idBrand}">Edit</a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a href="${pageContext.request.contextPath}/${instrument}/delete-brand/${brand.idBrand}">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <div class="panel-footer"><a class="btn btn-info" role="button"
                                                         href="${pageContext.request.contextPath}/${instrument}/newBrand">Add
                                new brand &raquo</a></div>
                        </div>

                        <div class="panel panel-info">
                            <!-- Default panel contents -->
                            <div class="panel-heading">
                                <div class="text-center"><h3>Models</h3></div>
                            </div>
                            <table class="table table-striped table-condensed" id="car-models">
                                <thead>
                                <th>
                                    <button class="sort" data-sort="brand-name">brand</button>
                                </th>
                                <th>
                                    <button class="sort" data-sort="model-name">model</button>
                                </th>
                                <th>
                                    <button class="sort" data-sort="generation">generation</button>
                                </th>
                                <th>
                                    <button class="sort" data-sort="production-year">produced</button>
                                </th>
                                <th>
                                    <button class="sort" data-sort="doors">doors</button>
                                </th>
                                <th>
                                    <button class="sort" data-sort="seats">seats</button>
                                </th>
                                <th>
                                    <button class="sort" data-sort="maximum-speed">max speed</button>
                                </th>
                                <th>action</th>
                                </thead>
                                <tbody align="center" class="list">
                                <c:forEach var="model" items="${listCarModel}" varStatus="status">
                                    <tr>
                                        <td class="brand-name">${model.carBrand.name}</td>
                                        <td class="model-name">${model.modelName}</td>
                                        <td class="generation">${model.generation}</td>
                                        <td class="production-year">${model.productionYear}</td>
                                        <td class="doors">${model.doors}</td>
                                        <td class="seats">${model.seats}</td>
                                        <td class="maximum-speed">${model.maximumSpeed}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/${instrument}/edit-model/${model.idModel}">Edit</a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a href="${pageContext.request.contextPath}/${instrument}/delete-model/${model.idModel}">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <div class="panel-footer"><a class="btn btn-info" role="button"
                                                         href="${pageContext.request.contextPath}/${instrument}/newModel">Add
                                new model &raquo</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/resources/js/list.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/content-list.js"></script>
    </body>
</html>