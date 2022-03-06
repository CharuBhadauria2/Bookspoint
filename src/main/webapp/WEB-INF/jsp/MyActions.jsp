<%@include file="common/header.jspf" %>
<%@include file="common/footer.jspf" %>

<table class="table table-striped">
<caption><h3>My books listed for selling or lending</h3></caption>
<thead>
<tr>

<th>Title</th>
<th>Author</th>
<th>Action</th>
<th>Price (INR)</th>
</tr>
</thead>
<tbody>

<c:forEach items="${books}" var="book">
<tr>
<td>${book.title}</td>
<td>${book.author}</td>
<td>${book.action}</td>
<td>${book.price}</td>
<td><a type="button" class="btn btn-danger" href="/deleteBook?id=${book.bookid}">Delete</a></td>
<td><a type="button" class="btn btn-info" href="/updateBook?id=${book.bookid}">Update</a></td>
</tr>
</c:forEach>

</tbody>
</table>
