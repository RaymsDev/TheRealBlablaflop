<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
  <header class="mdl-layout__header">
    <div class="mdl-layout__header-row">
      <!-- Title -->
      <span class="mdl-layout-title">Blablaflop</span>
      <!-- Add spacer, to align navigation to the right -->
      <div class="mdl-layout-spacer"></div>
      <!-- Navigation. We hide it in small screens. -->
      <nav class="mdl-navigation mdl-layout--large-screen-only">
        <a class="mdl-navigation__link" href="<c:url value="/"/>">Accueil</a>
        <c:if test="${ empty UserSession }">
	       <a class="mdl-navigation__link" href="<c:url value="/login"/>">Se connecter</a>
	    </c:if>
	    <c:if test="${ not empty UserSession }">
	       <a class="mdl-navigation__link" href="<c:url value="/mySpace"/>">${UserSession.getMail()}</a>
	    </c:if>
        <a class="mdl-navigation__link" href="<c:url value="/register"/>">S'enregistrer</a>
      </nav>
    </div>
  </header>
  <div class="mdl-layout__drawer mdl-layout mdl-js-layout mdl-layout--fixed-drawer">
    <span class="mdl-layout-title">Blablaflop</span>
    <nav class="mdl-navigation">
   	  <a class="mdl-navigation__link" href="<c:url value="/"/>">Accueil</a>
      <c:if test="${ empty UserSession }">
		<a class="mdl-navigation__link" href="<c:url value="/login"/>">Se connecter</a>
	  </c:if>
	  <c:if test="${ not empty UserSession }">
        <a class="mdl-navigation__link" href="<c:url value="/mySpace"/>">${UserSession.getMail()}</a>
      </c:if>
      <a class="mdl-navigation__link" href="<c:url value="/register"/>">S'enregistrer</a>
    </nav>
  </div>
</div>