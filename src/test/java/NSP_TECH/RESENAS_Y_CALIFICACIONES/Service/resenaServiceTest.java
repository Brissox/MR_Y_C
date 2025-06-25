package NSP_TECH.RESENAS_Y_CALIFICACIONES.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import NSP_TECH.RESENAS_Y_CALIFICACIONES.model.resenas;
import NSP_TECH.RESENAS_Y_CALIFICACIONES.repository.resenaRepository;
import NSP_TECH.RESENAS_Y_CALIFICACIONES.services.resenasServices;

public class resenaServiceTest {

    
    @Mock
    private resenaRepository resenarepository;
    
    @InjectMocks
    private resenasServices resenaservices;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }



    
    @Test
    public void testBuscarTodo(){
    java.util.List<resenas> lista = new  ArrayList<>();

    resenas resena1 = new resenas();
    resenas resena2 = new resenas();

    resena1.setId_resena(11L);
    resena1.setId_usuario(11L);
    resena1.setId_producto(11L);
    resena1.setCalificacion(5);
    resena1.setComentario("buen producto");
    resena1.setFecha_resena(LocalDateTime.now());

    resena2.setId_resena(12L);
    resena2.setId_usuario(12L);
    resena2.setId_producto(12L);
    resena2.setCalificacion(5);
    resena2.setComentario("Mal producto");
    resena2.setFecha_resena(LocalDateTime.now().minusDays(2));
    

    lista.add(resena1);
    lista.add(resena2);

    when(resenarepository.findAll()).thenReturn(lista);

    java.util.List<resenas> resultadoBusqueda = resenaservices.BuscarTodoResenas();

    assertEquals(2,resultadoBusqueda.size());
    verify(resenarepository, times(1)).findAll();

}

    @Test
    public void testBuscarUnaResena(){
    resenas resena = new resenas();

    resena.setId_resena(11L);
    resena.setId_usuario(11L);
    resena.setId_producto(11L);
    resena.setCalificacion(5);
    resena.setComentario("buen producto");
    resena.setFecha_resena(LocalDateTime.now());

    when(resenarepository.findById(11L)).thenReturn(Optional.of(resena));

    resenas resenaBuscado = resenaservices.BuscarUnaResena(11L);
    assertEquals(11L,resenaBuscado.getId_resena());
    verify(resenarepository, times(1)).findById(11L);

    }



    @Test
    public void testGuardarResena(){
        resenas r = new resenas();
        r.setId_resena(11L);
        r.setId_usuario(11L);
        r.setId_producto(11L);
        r.setCalificacion(5);
        r.setComentario("buen producto");
        r.setFecha_resena(LocalDateTime.now());

        
        when(resenarepository.save(any())).thenReturn(r);

        resenas resenasGuardados = resenaservices.GuardarResenas(r);
        assertEquals(11L, resenasGuardados.getId_producto());
        verify(resenarepository, times(1)).save(r);
    }


/*

    @Test
    public void testEliminarEnvio(){
        Long id = 11L;
        doNothing().when(enviorepository).deleteById(id);

        enviosservices.Eliminar***(id);

        verify(enviosrepository.times(1)).deleteById(id);

    }
*/
}


