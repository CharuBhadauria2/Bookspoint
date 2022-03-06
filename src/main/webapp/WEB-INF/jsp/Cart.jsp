<%@include file="common/header.jspf" %>
<%@include file="common/footer.jspf" %>

<table class="table table-striped">
<caption><h3>Books</h3></caption>
<thead>
<tr>

<th>Title</th>
<th>Author</th>
<th>Action</th>
<th>Price</th>
</tr>
</thead>
<tbody>

<c:forEach items="${books}" var="book">
<tr>
<td>${book.title}</td>
<td>${book.author}</td>
<td>${book.action}</td>
<td>${book.price}</td>
</tr>
</c:forEach>

</tbody>
</table>