package NSP_TECH.RESENAS_Y_CALIFICACIONES.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import NSP_TECH.RESENAS_Y_CALIFICACIONES.model.resenas;
import NSP_TECH.RESENAS_Y_CALIFICACIONES.repository.resenaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class resenasServices {

    @Autowired
    private resenaRepository resenarepository;

    public List<resenas> BuscarTodoResenas(){
        return resenarepository.findAll();
    }
        public resenas BuscarUnaResena(Long id_resena){
        return resenarepository.findById(id_resena).get();
    }

    public resenas GuardarResenas(resenas resenas){
        return resenarepository.save(resenas);

    }

    public void EliminarResena(Long id_resena){
        resenarepository.deleteById(id_resena);
    }

}
