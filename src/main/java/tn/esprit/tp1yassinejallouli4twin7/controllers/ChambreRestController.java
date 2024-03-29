package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.DTO.ChambreDTO;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;
import tn.esprit.tp1yassinejallouli4twin7.entities.TypeChambre;
import tn.esprit.tp1yassinejallouli4twin7.services.IBlocService;
import tn.esprit.tp1yassinejallouli4twin7.services.IChambreService;

import java.util.List;

@RequiredArgsConstructor //2eme lezem el final mawjouda
@RequestMapping("chambre")
@RestController
@CrossOrigin(origins = "*")
public class ChambreRestController {
    private final IChambreService chambreService;

    @GetMapping("/all")
    public List<Chambre> getAleChambre(){
        return chambreService.getAllChambres();
    }

    @PostMapping("/add")
    public Chambre adeChambre(@RequestBody Chambre ch){
        return chambreService.ajouterChambre(ch);
    }

    @PostMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre ch){
        return chambreService.updateChambre(ch);
    }

    @DeleteMapping ("/delete/{idChambre}")
    public void deleteChambre(@PathVariable Long idChambre){
        chambreService.supprimerChambre(idChambre);
    }
    @GetMapping ("/getChambresParNomBloc/{nomBloc}")
    public List<Chambre> getChambresParNomBlocApi(@PathVariable String nomBloc){
        return chambreService.getChambresParNomBloc(nomBloc);
    }
    @GetMapping ("/getChambresParNomBloc/{type}/{idBloc}")
    public long nbChambreParTypeEtBloc(@PathVariable TypeChambre type,@PathVariable long idBloc){
        return chambreService.nbChambreParTypeEtBloc(type,idBloc);
    }
    @GetMapping ("/getChambresNonReserveParNomFoyerEtTypeChambre/{nomFoyer}/{type}")
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambreApi(@PathVariable String nomFoyer,@PathVariable TypeChambre type){
        return chambreService.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer,type);
    }
    @GetMapping ("/getChambresParBlocEtType/{idBloc}/{type}")
    public List<Chambre> getChambresParBlocEtTypeApi(@PathVariable long idBloc,@PathVariable TypeChambre type){
        return chambreService.getChambresParBlocEtType(idBloc,type);
    }


/*yosr*/
    @GetMapping("getChambresNonAffecter")
    public List<Chambre> getChambresNonAffecter(){
        return chambreService.getChambresNonAffecter();
    }

    /*nejd*/

    @GetMapping("GetChambreFilter")
    public Page<ChambreDTO> getChambreFilter(@RequestParam(value = "nom",required = false) String nom,
                                             @RequestParam(value = "nomBloc",required = false) String NomBloc,
                                             @RequestParam(value = "idFoyer",required = false) Long idFoyer,
                                             Pageable pageable
    ){
        return chambreService.GetChambreFilterBy(nom,NomBloc,idFoyer,pageable);
    }
    @GetMapping("GetChambreById/{id}")
    public Chambre GetChambreById(@PathVariable long id){
        return chambreService.getChambreById(id);
    }
}
