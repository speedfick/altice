package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@ApplicationScoped
@Path("/labseq") // Define o caminho base para o recurso LabSeqResource
public class LabSeqCalculator {

    private Map<Integer, Integer> cache;

    // Construtor da classe
    public LabSeqCalculator() {
        this.cache = new HashMap<>();
        // Inicializa o cache com os valores iniciais conhecidos da sequência
        cache.put(0, 0);  // l(0) = 0
        cache.put(1, 1);  // l(1) = 1
        cache.put(2, 0);  // l(2) = 0
        cache.put(3, 1);  // l(3) = 1
    }

    @GET // Indica que este método responde a solicitações HTTP GET
    @Path("/{n}") // Define um caminho relativo para este método, com um parâmetro de caminho {n}
    @Produces(MediaType.TEXT_PLAIN) // Indica que este método produz uma resposta no formato de texto simples
    @Operation(summary = "Calcula o valor da sequência LabSeq para um determinado índice",
            description = "Calcula o valor da sequência LabSeq para um determinado índice especificado.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Valor da sequência LabSeq calculado com sucesso"),
            @APIResponse(responseCode = "404", description = "Índice especificado não encontrado na sequência")
    })
    public int calculateLabSeq(@Parameter(description = "O índice da sequência LabSeq a ser calculado", required = true)
                                   @PathParam("n") int n) {
        // Verifica se o resultado para o índice n já está presente na cache
        if (cache.containsKey(n)) {
            // Retorna o resultado armazenado em cache
            return cache.get(n);
        }

        // Se o resultado não estiver na cache, calcula-o recursivamente
        int result = calculateLabSeq(n - 4) + calculateLabSeq(n - 3);

        // Armazena o resultado na cache para uso futuro
        cache.put(n, result);

        // Retorna o resultado do cálculo
        return result;
    }
}
