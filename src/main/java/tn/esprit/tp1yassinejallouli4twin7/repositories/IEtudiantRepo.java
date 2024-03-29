package tn.esprit.tp1yassinejallouli4twin7.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1yassinejallouli4twin7.entities.Etudiant;

public interface IEtudiantRepo extends CrudRepository<Etudiant,Long> {
    Etudiant findEtudiantByCin(long cin);

    Etudiant findEtudiantByEmailAndPassoword(String email,String passoword);

    Etudiant findEtudiantByEmail(String email);
}
