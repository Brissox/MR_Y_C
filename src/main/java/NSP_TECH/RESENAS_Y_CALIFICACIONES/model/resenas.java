package NSP_TECH.RESENAS_Y_CALIFICACIONES.model;

import java.util.Date;

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
    @Schema(description="aa")
    private Long id_resena;

    @Column(name="ID_USUARIO",nullable = false, precision = 10)
    @Schema(description="aa")
    private Long id_usuario;

    @Column(name="ID_PRODUCTO",nullable = false, precision = 10)
    @Schema(description="aa")
    private Long id_producto;

    @Column(name="CALIFICACION",nullable = true, precision = 1)
    @Schema(description="aa")
    private int calificacion;

    @Column(name="COMENTARIO",nullable = true,length = 500)
    @Schema(description="aa")
    private String comentario;

    @Column(name="FECHA_RESENA",nullable = true)
    @Schema(description="aa")
    private Date fecha_resena;

}