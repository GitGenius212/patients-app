   If you use Spring Boot, add spring.mvc.hiddenmethod.filter.enabled=true to your application.properties to avoid the manual bean configuration. If you use Thymeleaf for the templates, you can use th:method="DELETE" to have Thymelaf add the hidden field automatically. – Wim Deblauwe

spring.mvc.hiddenmethod.filter.enabled=true



Commandes :
Start xampp with a bd
Run the project patients-app


Difficulté rencontré 1: Afficher les images avec thymeleaf
   Solution : mettre les images à l'intérieur de src/main/ressources/static/images
   dans la balise <img src="images/photo.jpg"


Difficulté rencontré 2: Masquer un boutton à l'aide du hasRole
   Solution : 
   1. Ajouter la dépendance :implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
   2. Ajouter dans le fichier html dans la balise html -> xmlns:sec="http://www.thymeleaf.org/extras/spring-security"
   3. Ajouter sec:authorize="hasRole('ROLE_ADMIN')" dans n'importe quel balise à l'intérieur 
      duquel contient l'information à cacher 


