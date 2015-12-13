package ViewFragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import Class.General;
import com.example.diegoh.database.R;

/**
 * Created by DIEGO CASALLAS on 03/12/2015.
 */
public class ContainerFragment {

    private Fragment fragment;
    private int iSelectionFragment;
    private Activity activity;
    //Object fragment
    private InsertPerson insertPerson;
    private SearchPerson searchPerson;


    public ContainerFragment(int iSelection){
        this.iSelectionFragment=iSelection;
        this.insertPerson=null;
        this.searchPerson=null;

        activity= General.ACTIVITY;

    }
    public  Fragment selectionFragment(){

        switch(iSelectionFragment)
        {
            case 0:
                fragment=insertPerson=new InsertPerson();
                break;
            case 1:
                fragment=searchPerson=new SearchPerson();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }

        FragmentManager fragmentManager=activity.getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.FrameContainer,fragment).commit();


        return fragment;

    }
}

