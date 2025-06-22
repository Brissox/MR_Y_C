package NSP_TECH.RESENAS_Y_CALIFICACIONES.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import NSP_TECH.RESENAS_Y_CALIFICACIONES.Assembler.resenasModelAssembler;
import NSP_TECH.RESENAS_Y_CALIFICACIONES.model.resenas;
import NSP_TECH.RESENAS_Y_CALIFICACIONES.services.resenasServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/Resenas")

/*id_resena */
public class resenasController {

    @Autowired
    private resenasServices resenasservice;

    @Autowired
    private resenasModelAssembler assembler;
    
       // ENDPOINT PARA BUSCAR TODAS LAS RESENAS
    @GetMapping

    @Operation(summary = "RESENAS Y COMENTARIOS", description = "Operacion que lista todas las resenas")
    @ApiResponses (value = {
        @ApiResponse(responseCode = "200", description = "Se listaron correctamente las ventas", content = @Content(mediaType = "application/json", schema = @Schema(implementation = resenas.class))),
        @ApiResponse(responseCode = "404", description = "No se encontro ninguna venta", content = @Content(mediaType = "application/json", schema = @Schema(type = "string", example = "No se encuentran Datos")))


    })

    public ResponseEntity<?> ListarTodo(){
        List<resenas> resenas = resenasservice.BuscarTodoResenas();
        if (resenas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentran dato");
        } else {
            return ResponseEntity.ok(assembler.toCollectionModel(resenas));
        }
    }

    // ENDPOINT PARA BUSCAR UNA RESENA Y COMENTARIO
    @GetMapping("/{ID_RESENA}")

    @Operation(summary = "RESENA Y COMENTARIO", description = "Operacion que lista una resena y/o comentario")
    @Parameters (value = {
        @Parameter (name="id_resena", description= "ID del producto que se buscara", in = ParameterIn.PATH, required= true)

    })

    @ApiResponses (value = {
        @ApiResponse(responseCode = "200", description = "Se lista correctamente la resena y/o comentario ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = resenas.class))),
        @ApiResponse(responseCode = "404", description = "No se encontro ninguna resena y/o comentario", content = @Content(mediaType = "application/json", schema = @Schema(type = "string", example = "No se encuentran Datos")))
    })

    public ResponseEntity<?> BuscarResena(@PathVariable Long ID_RESENA){

        try {
            resenas resenaBuscado = resenasservice.BuscarUnaResena(ID_RESENA);
            return ResponseEntity.ok(assembler.toModel(resenaBuscado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentran la resena y comentario");
        }
    }

// ENDPOINT PARA REGISTRAR UNA RESENA Y/O COMENTARIO
    @PostMapping
    @Operation(summary = "ENDPOINT QUE REGISTRA UNA RESENA Y/O COMENTARIO", description = "ENDPOINT QUE REGISTRA UNA RESENA Y/O COMENTARIO",requestBody= @io.swagger.v3.oas.annotations.parameters.RequestBody(description="ENVIO QUE SE VA A REGISTRAR", required = true, content = @Content(schema = @Schema(implementation = resenas.class))))
    @ApiResponses (value = {
        @ApiResponse(responseCode = "200", description = "Se registro correctamente la reserva y/o comentario", content = @Content(mediaType = "application/json", schema = @Schema(implementation = resenas.class))),
        @ApiResponse(responseCode = "500", description = "Indica que no se logro registrar la reserva y/o comentario", content = @Content(mediaType = "application/json", schema = @Schema(type = "string", example = "No se puede registrar la reserva y/o comentario")))
    })

    public ResponseEntity<?> GuardarResena(@RequestBody resenas resenasGuardar){
    try {
            resenas resenasRegistrar = resenasservice.GuardarResenas(resenasGuardar);
            return ResponseEntity.ok(assembler.toModel(resenasGuardar));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("No se puede registrar la reserva y/o comentario");
    }
    }

    
}
