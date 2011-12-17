<%@ include file="/init.jsp" %>



<liferay-ui:search-container
      emptyResultsMessage="there-are-no-player-clubs"
      delta="8">

    <liferay-ui:search-container-results>
    <%
    List<ESPlayerClub> tempResults = ActionUtil.getPlayerClubs(renderRequest);

    results = ListUtil.subList(
        tempResults, searchContainer.getStart(), searchContainer.getEnd());
    total = tempResults.size();

    pageContext.setAttribute("results", results);
    pageContext.setAttribute("total", total);
    %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
        className="com.eswinggolf.portal.data.layer.club.model.ESPlayerClub"
        keyProperty="playerClubId"
        modelVar="playerclub">

	  <liferay-ui:search-container-column-text
          name="club"
          value="<%= ActionUtil.getClub(playerclub.getClubId()).getClubName() %>" />
      <liferay-ui:search-container-column-text
          name="club-desc"
          property="clubDesc" />
      <liferay-ui:search-container-column-text
          name="loft"
          property="loft" />
      <liferay-ui:search-container-column-text 
      	  name="weight"
      	  property="weight"/>
      <liferay-ui:search-container-column-text 
      	  name="model"
      	  property="model"/>
      <%
            String active = playerclub.isActive() ? "active" : "inactive";
        %> 
      <liferay-ui:search-container-column-text name="Active" >
       		<aui:input type="checkbox" name="<%= active %>" checked="<%= playerclub.isActive() %>" disabled="true" />
      </liferay-ui:search-container-column-text>
       
      <liferay-ui:search-container-column-jsp
          path="/jsp/clubtable/admin_actions.jsp"
          align="right" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

  </liferay-ui:search-container>