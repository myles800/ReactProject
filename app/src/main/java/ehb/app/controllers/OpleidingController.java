package ehb.app.controllers;


import ehb.app.dao.OpleidingDAO;
import ehb.app.entities.Opleiding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/opleidingen")
public class OpleidingController {
    private OpleidingDAO opleidingDAO;
    @Autowired
    public OpleidingController(OpleidingDAO opleidingDAO){
        this.opleidingDAO=opleidingDAO;
    }

   @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    @ResponseBody
    public List<Opleiding> findAllOpleidingen(){
        return (List<Opleiding>) opleidingDAO.findAll();
    }

   @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(value ={"{id}","/id/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public Optional<Opleiding> findOpleidingById(@PathVariable(value="id") int id){
        return opleidingDAO.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable(value = "id") int id){
        opleidingDAO.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    @ResponseBody
    public HttpStatus insertCourse(@RequestBody Opleiding opleiding){
        Opleiding temp =new Opleiding();
        temp.setId(0); // aanduiden dat er nieuwe mag gegenereerd worden
        temp.setNaam(opleiding.getNaam());
        temp.setOmschrijving(opleiding.getOmschrijving());
        temp.setPrijs(opleiding.getPrijs());
        opleidingDAO.save(temp);
        return HttpStatus.OK;
    }
}
