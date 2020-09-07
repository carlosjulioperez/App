<%@ taglib prefix="mp" tagdir="/WEB-INF/tags/common" %>
<% request.setAttribute("ctx", request.getContextPath()); %>
<div class='portlet' style='margin: 4px'>

	<div id="menuheader">
		<span id="menutitle">App menu 
			<a href="/App/xava/homeMenu.jsp" ><img src="/App/xava/images/home.gif"></a>
		</span>
		<span id="menuPowerByMP">
			<span id="logout"><a href="../j_spring_security_logout">Logoff</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="http://minuteproject.wikispaces.com" >powered by minuteProject</a>
		</span>		
	</div>

	<table id="menuTable" border="0" width="100%" cellspacing="0" cellpadding="0" style="margin-top: 2px;">
		<tr>
			<td>
				<div id="searchbar">
					<div class="menustyle" id="menu">
						<ul class="menubar" id="dmenu">

							<mp:isUserInRole role="admin">
								<li class="topitem"><a href="#" onclick="return false;"> Administración</a>
									<ul class="submenu">
										<mp:isUserInRole role="admin">
											<li><a href="/App/MenuModules/User" >Usuario</a></li>
										</mp:isUserInRole>
										<mp:isUserInRole role="admin">
											<li><a href="/App/MenuModules/Role" >Rol</a></li>
										</mp:isUserInRole>
										<mp:isUserInRole role="admin">
											<li><a href="/App/MenuModules/GeneralTable">Tabla General</a></li>
										</mp:isUserInRole>
										<mp:isUserInRole role="admin">
											<li><a href="/App/MenuModules/Province">Provincia</a></li>
										</mp:isUserInRole>
										<mp:isUserInRole role="admin">
											<li><a href="/App/MenuModules/Canton">Cantón</a></li>
										</mp:isUserInRole>
									</ul>
								</li>
							</mp:isUserInRole>
							
							<mp:isUserInRole role="admin,cmc">
								<li class="topitem"><a href="#" onclick="return false;">Centro Médico</a>
									<ul class="submenu">
										<mp:isUserInRole role="admin,cmc">
											<li><a href="/App/MenuModules/CmcMedicalCenter">Centro Médico</a></li>
										</mp:isUserInRole>
										<mp:isUserInRole role="cmc">
											<li><a href="/App/MenuModules/Person">Persona</a></li>
										</mp:isUserInRole>
										<mp:isUserInRole role="cmc">
											<li><a href="/App/MenuModules/Prescription">Prescripción</a></li>
										</mp:isUserInRole>
									</ul>
								</li>
							</mp:isUserInRole>

						</ul>
					</div>

				</div>
			</td>

		</tr>
	</table>

</div>

</div>

