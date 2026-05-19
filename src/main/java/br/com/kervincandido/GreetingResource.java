package br.com.kervincandido;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "app.segredo-teste", defaultValue = "padrao-local")
    private String valorTeste;

    @ConfigProperty(name = "app.jwt-private-key", defaultValue = "padrao-local")
    private String jwtPrivateKey;

    @ConfigProperty(name = "app.jwt-public-key", defaultValue = "padrao-local")
    private String jwtPublicKey;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello " + valorTeste + "\nprivate key: "
                + jwtPrivateKey.substring(0, 30) + "...\npublic key: "
                + jwtPublicKey.substring(0, 30) + "...";
    }

}
