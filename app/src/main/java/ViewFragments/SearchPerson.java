package ViewFragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.diegoh.database.R;
import java.util.ArrayList;
import Class.*;
import DTO.DtoPerson;
import VO.PersonBusiness;

/**
 * Created by DIEGO CASALLAS on 13/12/2015.
 */
public class SearchPerson extends Fragment implements View.OnClickListener,SearchView.OnQueryTextListener  {
    private View view;
    private ListView listView;
    private SearchView searchView;
    private Context context;
    private PersonBusiness objPersonBusiness;
    private DtoPerson objPerson;
    private ImageButton btnSearch;

    public SearchPerson() {
        this.view = null;
        this.searchView = null;
        this.listView = null;
        this.context= General.CONTEXT;
        this.objPerson=new DtoPerson();
        this.objPersonBusiness=new PersonBusiness(context);
        this.btnSearch=null;


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_person, container, false);
        loadView();
        return view;
    }

    private void loadView() {
        listView = (ListView) view.findViewById(R.id.listViewPerson);
        searchView = (SearchView) view.findViewById(R.id.searchView);
        btnSearch=(ImageButton)view.findViewById(R.id.BtnSearch);
        btnSearch.setOnClickListener(this);
        loadList(0);


    }

    @Override
    public void onClick(View v) {
        loadList(0);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        if (TextUtils.isEmpty(newText)) {
            listView.clearTextFilter();
        } else {
            listView.setFilterText(newText.toString());
            objPerson.setsName(newText.toString());
            loadList(1);

        }
        return true;
    }
    public void  loadList(int typeSelect){



        ArrayList<DtoPerson> lis=objPersonBusiness.searchPerson(objPerson,typeSelect);

        listView.setAdapter(new MyAdapter(context,R.layout.list_item,lis));
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String datas = listView.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), "List item was clicked at : " + datas, Toast.LENGTH_LONG).show();
            }
        });

    }

}
