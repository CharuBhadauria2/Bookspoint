<%@include file="common/header.jspf" %>
<%@include file="common/footer.jspf" %>

<table class="table table-striped">
<caption><h3>Books</h3></caption>
<thead>
<tr>

<th>Title</th>
<th>Author</th>
<th>Category</th>
<th>Price</th>
</tr>
</thead>
<tbody>

<c:forEach items="${books}" var="book">
<tr>
<td>${book.title}</td>
<td>${book.author}</td>
<td>${book.category}</td>
<td>${book.price}</td>
<td><a type="button" class="btn btn-info" href="/viewDetails?id=${book.bookid}">View Details</a></td>
<td><a type="button" class="btn btn-success" href="/addToCart?id=${book.bookid}">Add to cart</a></td>
</tr>
</c:forEach>

</tbody>
</table>