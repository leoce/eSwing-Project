<%@ include file="/init.jsp" %>

<portlet:renderURL var="backRenderURL">
</portlet:renderURL>

<br />
<a href="<%= backRenderURL %>">Back</a>
<br />


<div>
	<h1>Alloy - Node Basics Demo</h1>

	<div id="demo">
	    <p><em>Whose child am I?</em></p>
	</div>

</div>


<aui:script>
AUI().use('node', function(A) {
    var node = A.one('#demo p');

    var onClick = function(e) {
        var tag = e.target.get('parentNode.tagName'); /* e.target === node || #demo p em */
        e.currentTarget.one('em').setContent('I am a child of ' + tag + '.'); /* e.currentTarget === node */
    };

    node.on('click', onClick);
});
</aui:script>
