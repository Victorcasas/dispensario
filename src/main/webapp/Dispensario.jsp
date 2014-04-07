<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<body bgcolor="#389428">
<div align="center">
<s:form action="altaSocio">
<s:textfield name="nombre" label="Nombre" value=""/>
<s:textfield name="numero" label="numero" value=""/>
<s:submit value="Alta de Socio" name="submit" /> 
</s:form>
<hr>
<s:form action="listarVariedad">
<s:submit value="Listar Variedades" name="submit" /> 
</s:form>
<hr>
<s:form action="crearVariedad">
<s:textfield name="codigo" label="Variedad" value=""/>
<s:textfield name="aporte" label="Cantidad" value=""/>
<s:submit value="Crear Variedad" name="submit" /> 
</s:form>
<hr>
<s:form action="aportarVariedad">
<s:select label="Variedad"
		name="codigo"
        list="variedadDAO.variedades"
        
        listValue="variedadNombre"
        value="%{variedadDAO.variedades.{variedadNombre}}"
                
        listKey="variedadNombre">
</s:select>
<s:textfield name="aporte" label="Cantidad" value=""/>
<s:submit value="Aportar" name="submit" /> 
</s:form>
<hr>
<s:form action="retirarVariedad">
<s:select label="Variedad"
		name="codigo"
        list="variedadDAO.variedades"
        
        listValue="variedadNombre"
        value="%{variedadDAO.variedades.{variedadNombre}}"
                
        listKey="variedadNombre">
</s:select>
<s:textfield name="retirada" label="Cantidad" value=""/>
<s:submit value="Retirar" name="submit" /> 
</s:form>
<hr>

<s:if test='%{nombre!=null && nombre!=""}'>
Resultado OK!!!
<br>
Nombre:<s:property value="nombre"/>
<br>
Numero:<s:property value="numero"/>
<hr>
</s:if>
<s:else>
	<s:if test='%{retirada!=null && retirada!=""}'>
	Resultado OK!!
	Variedad:<s:property value="codigo"/>
	<br>
	Retirada:<s:property value="retirada"/>
	<br>
	Stock final:<s:property value="stock"/>
	</s:if>
	<s:else >
		<s:if test='%{aporte!=null && aporte!=""}'>
		Resultado OK!! --- 
		Variedad:<s:property value="codigo"/>
		<br>
		Aporte:<s:property value="aporte"/>
			<s:if test="%{stock == 0}">
			<br>
			Stock final:<s:property value="aporte"/>
			</s:if>
			<s:else>
			<br>
			Stock final:<s:property value="stock"/>
			</s:else>			
		</s:if>
	</s:else>
</s:else>

<s:iterator value='%{variedades}' id='variedad'>
<s:property value="#variedad.variedadNombre" />
 ---> 
<s:property value="#variedad.variedadCantidad" />
<br>
</s:iterator>

</div>
</body>