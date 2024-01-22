/*
package com.example.springbootlibrary.config;
import com.example.springbootlibrary.entity.Book;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    /*
    private String theAllowedOrigin= "http://localhost:3000";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
       //stöder inte post,patch put request
        HttpMethod[] theUnsupportedActions = {HttpMethod.POST,HttpMethod.PATCH, HttpMethod.PUT};
        //göra get förfrågan av id
        config.exposeIdsFor(Book.class);

        //inaktiv Post,Patch och put förfrågan
        disableHttpMethod(Book.class,config, theUnsupportedActions);

        //Configure Cors tillåter klienten med http://localhost:3000 göra begäran
        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigin);
    }

    private void disableHttpMethod(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        // Hämta konfigurationen för hur entitetstypen ska vara utsatt för HTTP-åtgärder
        config.getExposureConfiguration()
                // Specificera vilken typ av objekt (entitetstyp) konfigurationen gäller
                .forDomainType(theClass)
                // Bestäm vilka HTTP-åtgärder som inte är tillåtna för enskilda objekt
                .withItemExposure((metadata, httpMethods) ->
                        httpMethods.disable(theUnsupportedActions))
                // Bestäm vilka HTTP-åtgärder som inte är tillåtna för samlingar av objekt
                .withCollectionExposure((metadata, httpMethods) ->
                        httpMethods.disable(theUnsupportedActions));
    }




}

 */
