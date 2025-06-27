<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: green; text-align: center">Doctor Registration
	Page</h1>

<frm:form modelAttribute="docVO">
	<table align="center" bgcolor="yellow">
		<tr>
			<td>Doctor Name::</td>
			<td><frm:input type="text" path="dname" /></td>
		</tr>
		<tr>
			<td>Doctor Specialization::</td>
			<td><frm:input type="text" path="specialization" /></td>
		</tr>
		<tr>
			<td>Fee::</td>
			<td><frm:input type="text" path="fee" /></td>
		</tr>
		<tr>
			<td>Qualification::</td>
			<td><frm:input type="text" path="qlfy" /></td>
		</tr>

		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="Register" /> 
			<input type="reset" value="Cancel" /></td>
		</tr>
	</table>
</frm:form>
