package com.PantryInc.pantrymanager.dto;

import com.PantryInc.pantrymanager.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Integer id;
    private String nombre;
    private String email;
    private String contraseña;
    private String rol;

    public Usuario toModel() {
        Usuario usuario = new Usuario();

        usuario.setId(this.id);
        usuario.setNombre(this.nombre);
        usuario.setContraseña(this.contraseña);
        usuario.setEmail(this.email);
        usuario.setRol(this.rol);

        return usuario;
    }

    public UsuarioDTO toDTO(Usuario usuario) {
        this.setId(usuario.getId());
        this.setNombre(usuario.getNombre());
        this.setEmail(usuario.getEmail());
        this.setContraseña(usuario.getContraseña());
        this.setRol(usuario.getRol());

        return this;
    }
}
