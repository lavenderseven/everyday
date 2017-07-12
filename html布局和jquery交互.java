/**当有下拉框时*/
<select id="l_appName" name="l_appName" onchange="changeByAppName();">
				<option value="-1">--请选择</option>
				<c:forEach items="${appList}" var="an">
					<option value="${an.id}">${an.appLabel}</option>
				</c:forEach>
</select>
var options=$("#l_appName option:selected"); //js获取值
