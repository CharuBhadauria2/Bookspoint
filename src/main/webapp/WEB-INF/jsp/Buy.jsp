<%@include file="common/header.jspf" %>
<%@include file="common/footer.jspf" %>

<table class="table table-striped">
<caption>Books</caption>
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
<td><a type="button" class="btn btn-warning" href="/addToCart?id=${book.bookid}">Add to cart</a></td>
<td><a type="button" class="btn btn-success" href="/buyNow?id=${book.bookid}">Buy now</a></td>

</tr>
</c:forEach>

</tbody>
</table>