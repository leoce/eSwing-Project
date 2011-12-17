<%@ include file="/init.jsp" %>

<liferay-ui:success key="clubSaved" message="club-saved-successfully" />
<liferay-ui:success key="clubDeleted" message="clubDeleted" />
<liferay-ui:success key="clubUpdated" message="clubUpdated" />
<liferay-ui:error key="fields-required" message="fields-required" />
<liferay-ui:error key="error-deleting" message="error-deleting" />
<liferay-ui:error key="error-updating" message="error-updating" />

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/jsp/club/view.jsp" />
</portlet:renderURL>

 <portlet:actionURL name="addClub" var="addClubURL"/>

 <aui:form name="fm" action="<%= addClubURL.toString() %>" method="post">

	<aui:fieldset>
	
		<aui:input name="clubName" size="30" />
		<aui:input name="clubDesc" size="30" />
		<aui:input name="model" size="30" />
		<aui:layout>
		  <aui:column columnWidth="50" first="true">
			<aui:input name="loft" size="10" />
			<aui:input name="nomSr" size="10" />
			<aui:input name="nomSpeed" size="10" />
		  </aui:column>
		  <aui:column columnWidth="50" last="true">
		  	<aui:input name="launchAngle" size="10" />
			<aui:input name="coR" size="10" />
			<aui:input name="weight" size="10" />
		  </aui:column>
		</aui:layout>
		<aui:field-wrapper name="active">
			<aui:input checked="<%= true %>" inlineLabel="right" name="active" type="radio" value="true" label="Yes" />
			<aui:input inlineLabel="right" name="active" type="radio" value="false" label="No"  />
		</aui:field-wrapper>
		
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="button" name="reset" value="reset" onClick="<%= cancelURL.toString() %>" />
		</aui:button-row>
		
	</aui:fieldset>
	
</aui:form>

<liferay-ui:search-container
      emptyResultsMessage="there-are-no-clubs"
      delta="9">

    <liferay-ui:search-container-results>
    <%
    List<ESClub> tempResults = ActionUtil.getClubs(renderRequest);

    results = ListUtil.subList(
        tempResults, searchContainer.getStart(), searchContainer.getEnd());
    total = tempResults.size();

    pageContext.setAttribute("results", results);
    pageContext.setAttribute("total", total);
    %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
        className="com.eswinggolf.portal.data.layer.club.model.ESClub"
        keyProperty="clubId"
        modelVar="club">

      <liferay-ui:search-container-column-text
          name="club-name"
          property="clubName" 
          orderable="<%= true %>"/>
      <liferay-ui:search-container-column-text
          name="loft"
          property="loft" />
      <liferay-ui:search-container-column-text
          name="nom-sr"
          property="nomSr" 
          orderable="<%= true %>"/>
      <liferay-ui:search-container-column-text
          name="nom-speed"
          property="nomSpeed" 
          orderable="<%= true %>"/>
      <liferay-ui:search-container-column-text
          name="co-r"
          property="coR" />
      <liferay-ui:search-container-column-text
          name="weight"
          property="weight" />
      <liferay-ui:search-container-column-text
          name="model"
          property="model" 
          orderable="<%= true %>"/>
        <%
            String active = club.isActive() ? "active" : "inactive";
        %>  
       <liferay-ui:search-container-column-text name="Active">
       		<aui:input type="checkbox" name="<%= active %>" checked="<%= club.isActive()%>" disabled="true" />
      </liferay-ui:search-container-column-text>
      
      <liferay-ui:search-container-column-jsp
          path="/jsp/club/admin_actions.jsp"
          align="right" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

  </liferay-ui:search-container>