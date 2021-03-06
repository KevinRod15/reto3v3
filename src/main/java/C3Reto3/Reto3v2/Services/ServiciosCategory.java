
package C3Reto3.Reto3v2.Services;

import C3Reto3.Reto3v2.Models.Category;
import C3Reto3.Reto3v2.Repositories.RepositorioCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCategory {
     @Autowired
    private RepositorioCategory metodosCrud;

    public List<Category> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Category> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }

    public Category save(Category categoria) {
        if (categoria.getId()== null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Category> categoria1 = metodosCrud.getCategoria(categoria.getId());
            if (categoria1.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Category update(Category categoria){
        if(categoria.getId()!=null){
            Optional<Category>g=metodosCrud.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
    
}
