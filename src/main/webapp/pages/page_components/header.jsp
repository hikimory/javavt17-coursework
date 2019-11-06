<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.11.2019
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">SCRUDproject</a>
            </div>
            <!--/.navbar-header -->
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">Operations <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/jdbc">JDBC</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/hibernate">Hibernate</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/jpa">JPA</a></li>
                        </ul>
                    </li>
                    <li><a href="/about">About</a></li>
                    <li><a href="/contact">Contact</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container -->
    </nav>
    <!--/.navbar -->
</header>
