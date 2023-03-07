package com.PantryInc.pantrymanager.dto;

import com.PantryInc.pantrymanager.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;
    private String Nombre;
    private String Email;
    private String Contraseña;

    public Usuario convertirModel(Integer id,String nombre, String email, String contraseña){
        Usuario usuario = new Usuario();
        usuario.setId(this.getId());
        usuario.setNombre(this.getNombre());
        usuario.setEmail(this.getEmail());
        usuario.setContraseña(this.getContraseña());
        return usuario;
    }

    public UsuarioDTO crearDTO(Usuario usuario){
        this.setId(usuario.getId());
        this.setNombre(usuario.getNombre());
        this.setEmail(usuario.getEmail());
        this.setContraseña(usuario.getContraseña());
        return this;
    }
}
