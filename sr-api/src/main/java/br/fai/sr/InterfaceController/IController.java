/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.sr.InterfaceController;

import br.fai.sr.Entity.Anuncio;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IController<Entity extends IBaseEntity> {
    
   
    public List<Entity>getAll();
    
    
    public Entity getById(@PathVariable ("id") Long id);
    
    
    public Entity save(@RequestBody Entity entity);
    
    
    public void delete(@RequestBody Entity entity);
    
    
    public Entity update(@RequestBody Entity entity);
    
}
