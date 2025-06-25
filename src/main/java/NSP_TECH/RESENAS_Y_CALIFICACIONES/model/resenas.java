package NSP_TECH.RESENAS_Y_CALIFICACIONES.model;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="resenas")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description="Todas las resenas y/o comentarios registradas")

public class resenas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_RESENA")
    @Schema(description="identificador de la resena",example="1")
    private Long id_resena;

    @Column(name="ID_USUARIO",nullable = false, precision = 10)
    @Schema(description="identificador del usuario que hace la resena", example="1")
    private Long id_usuario;

    @Column(name="ID_PRODUCTO",nullable = false, precision = 10)
    @Schema(description="identificador del producto el cual se hace resena", example="1")
    private Long id_producto;

    @Column(name="CALIFICACION",nullable = true, precision = 1)
    @Schema(description="calificacion que se le da a un producto segun la experiencia usuaria", example="1-5")
    private int calificacion;

    @Column(name="COMENTARIO",nullable = true,length = 500)
    @Schema(description="comentario sobre las experiencias usuarias con el producto ", example="muy buen producto")
    private String comentario;

    @Column(name="FECHA_RESENA",nullable = true)
    @Schema(description="fecha en la que se realizo la reseña", example="2025-06-24T15:30:00")
    private LocalDateTime fecha_resena;

}