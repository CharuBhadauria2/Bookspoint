<%@include file="common/header.jspf" %>
    <%@include file="common/footer.jspf" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <div class="container">
                <form:form class="form-horizontal" role="form" method="post" modelAttribute="book">
                <form:hidden path="bookid"/>
                    <div class="panel panel-info ">
                        <div class="panel-heading">
                            <h2>Sell or Lend a Book</h2>
                        </div>
                    </div>

                    <div class="form-group">

                        <form:label for="title" class="col-sm-3 control-form:label" path="title">Title</form:label>
                        <div class="col-sm-9">
                            <form:input type="text" path="title" name="title" placeholder="Title" class="form-control"/>
                                <span class="help-block">Title printed on Book</span>

                        </div>

                    </div>
                    <div class="form-group">
                        <form:label for="author" class="col-sm-3 control-form:label" path="author">Author</form:label>
                        <div class="col-sm-9">
                            <form:input type="text" name="author" placeholder="Author" class="form-control"
                                path="author"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <form:label for="category" class="col-sm-3 control-form:label" path="category">Category
                        </form:label>
                        <div class="col-sm-9">
                            <form:select name="category" class="form-control" path="category">
                                <option value="Crime">Crime</option>
                                <option value="Horror">Horror</option>
                                <option value="Thriller">Thriller</option>
                                <option value="Self help">Self Help</option>
                                <option value="Romance">Romance</option>
                                <option value="Comedy">Comedy</option>
                                </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label for="price" class="col-sm-3 control-form:label" path="price">Price</form:label>
                        <div class="col-sm-9">
                            <form:input type="number" name="price" placeholder="Price" class="form-control"
                                path="price"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label for="action" path="action" class="col-sm-3 control-form:label">What do you wish to
                            do</form:label>
                        <div class="col-sm-9">
                            <form:select name="action" class="form-control" path="action">
                                <option value="Sell">Sell</option>
                                <option value="Lend">Lend</option>
                                </form:select>
                        </div>
                    </div>

                    <c:if test="${message!=null}">

                        <div class="error">
                            <p style="color:red ">${message}</p>
                        </div>
                        &nbsp;
                    </c:if>
                    <div class="form-group">
                        <div class="col-sm-9 col-sm-offset-3">
                            <button type="submit" class="btn btn-success btn-block">Add Book</button>
                        </div>
                    </div>


                </form:form> <!-- /form -->
            </div> <!-- ./container -->