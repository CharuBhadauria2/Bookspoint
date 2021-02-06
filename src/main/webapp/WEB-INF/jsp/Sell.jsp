<%@include file="common/header.jspf" %>
<%@include file="common/footer.jspf" %>

<div class="container">
            <form class="form-horizontal" role="form" method="post">
               <div class="panel panel-info ">
               <div class="panel-heading"><h2>Sell or Lend a Book</h2></div>
               </div>
                <div class="form-group">
                    <label for="title" class="col-sm-3 control-label">Title</label>
                    <div class="col-sm-9">
                        <input type="text" name="title" placeholder="Title" class="form-control" autofocus>
                        <span class="help-block">Title printed on Book</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="author" class="col-sm-3 control-label">Author</label>
                    <div class="col-sm-9">
                        <input type="text" name="author" placeholder="Author" class="form-control" autofocus>
                        
                    </div>
                </div>
               <div class="form-group">
              <label for="price" class="col-sm-3 control-label">Category</label>
<div class="col-sm-9">
<select name="category" class="form-control">
  <option value="Crime">Crime</option>
  <option value="Horror">Horror</option>
  <option value="Thriller">Thriller</option>
  <option value="Self help">Self Help</option>
  <option value="Romance">Romance</option>
  <option value="Comedy">Comedy</option>
</select>
</div>
</div>
                <div class="form-group">
                    <label for="price" class="col-sm-3 control-label">Price</label>
                    <div class="col-sm-9">
                        <input type="number" name="price" placeholder="Price" class="form-control">
                    </div>
                </div>
                 
                <div class="form-group">
              <label for="price" class="col-sm-3 control-label">What do you wish to do</label>
<div class="col-sm-9">
<select name="action" class="form-control">
  <option value="Sell">Sell</option>
  <option value="Lend">Lend</option>
</select>
</div>
</div>
                
                <c:if test="${message!=null}">
                
                <div class="error"><p style="color:red ">${message}</p></div>
                &nbsp;
                </c:if>
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-success btn-block">Add Book</button>
                    </div>
                </div>
                
                
            </form> <!-- /form -->
        </div> <!-- ./container -->