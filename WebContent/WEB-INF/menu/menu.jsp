<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
  <header class="mdl-layout__header">
    <div class="mdl-layout__header-row">
      <!-- Title -->
      <span class="mdl-layout-title">Title</span>
      <!-- Add spacer, to align navigation to the right -->
      <div class="mdl-layout-spacer"></div>
      <!-- Navigation. We hide it in small screens. -->
      <nav class="mdl-navigation mdl-layout--large-screen-only">
        <a class="mdl-navigation__link" href="<c:url value="/login"/>">Mon espace</a>
        <a class="mdl-navigation__link" href="<c:url value="/register"/>">S'enregistrer</a>
        <a class="mdl-navigation__link" href="<c:url value="/users"/>">Utilisateurs</a>
        <a class="mdl-navigation__link" href="<c:url value="/"/>">Accueil</a>
      </nav>
    </div>
  </header>
  <div class="mdl-layout__drawer">
    <span class="mdl-layout-title">Title</span>
    <nav class="mdl-navigation">
      <a class="mdl-navigation__link" href="<c:url value="/login"/>">Mon espace</a>
      <a class="mdl-navigation__link" href="<c:url value="/register"/>">S'enregistrer</a>
      <a class="mdl-navigation__link" href="<c:url value="/users"/>">Utilisateurs</a>
      <a class="mdl-navigation__link" href="<c:url value="/"/>">Accueil</a>
    </nav>
  </div>
</div>
<div style="width: 1px; height: 50px;">
</div>