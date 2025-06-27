<%@ page isELIgnored="false" isErrorPage="true" %>
<h1 style="color:red; text-align:center">error.jsp (global Error Page)</h1>

<h3 style="color:red; text-align:center">Internal Problem--Try Again</h3>

<table align:"center" border="1" bgcolor:"yellow">
<tr>
<td>Status</td>
<td>${status}</td>
</tr>
<tr>
<td>Message</td>
<td>${message}</td>
</tr>
<tr>
<td>Path</td>
<td>${path}</td>
</tr>
<tr>
<td>timeStamp</td>
<td>${timestamp}</td>
</tr>
</table>