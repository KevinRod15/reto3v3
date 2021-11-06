
package C3Reto3.Reto3v2.Repositories;

import C3Reto3.Reto3v2.Interface.InterfaceGames;
import C3Reto3.Reto3v2.Models.Game;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioGames {
    @Autowired
    private InterfaceGames crud;
    
    public List<Game> getAll(){
        return (List<Game>) crud.findAll();
    }
    public Optional <Game> getGames(int id){
        return crud.findById(id);
    }
    
    public Game save(Game games){
        return crud.save(games);
    }
    
    public void delete(Game games){
        crud.delete(games);
    }
}
