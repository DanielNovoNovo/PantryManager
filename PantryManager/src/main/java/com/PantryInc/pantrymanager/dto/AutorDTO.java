package com.PantryInc.pantrymanager.dto;

import com.PantryInc.pantrymanager.model.Autor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String pais;

    public Autor toModel() {
        Autor autor = new Autor();

        autor.setId(this.id);
        autor.setNombre(this.nombre);
        autor.setApellido(this.apellido);
        autor.setFechaNacimiento(this.fechaNacimiento);
        autor.setPais(this.pais);

        return autor;
    }

    public AutorDTO toDTO(Autor autor) {
        this.setId(autor.getId());
        this.setNombre(autor.getNombre());
        this.setApellido(autor.getApellido());
        this.setFechaNacimiento(autor.getFechaNacimiento());
        this.setPais(autor.getPais());

        return this;
    }
}
