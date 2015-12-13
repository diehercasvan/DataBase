package Interfaces;
import java.util.ArrayList;

import DTO.DtoPerson;

/**
 * Created by DIEGO CASALLAS on 26/11/2015.
 */
public interface IntPerson {
    public int insertPerson(DtoPerson person);
    public int deletePerson(DtoPerson person);
    public int updatePerson(DtoPerson person);
    public ArrayList<DtoPerson> searchPerson(DtoPerson person, int type);
}
