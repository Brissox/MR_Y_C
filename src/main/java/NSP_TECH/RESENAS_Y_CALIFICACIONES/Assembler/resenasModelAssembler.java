package NSP_TECH.RESENAS_Y_CALIFICACIONES.Assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

import NSP_TECH.RESENAS_Y_CALIFICACIONES.controller.resenasController;
import NSP_TECH.RESENAS_Y_CALIFICACIONES.model.resenas;

@Component
public class resenasModelAssembler implements RepresentationModelAssembler<resenas, EntityModel<resenas>>{

    @Override
    public EntityModel<resenas> toModel(resenas r) {
        return EntityModel.of(
            r,
            linkTo(methodOn(resenasController.class).BuscarResena(r.getId_resena())).withRel("LINKS"),
            linkTo(methodOn(resenasController.class).ListarTodo()).withRel("todas-las-resenas")
        );
    }

}
