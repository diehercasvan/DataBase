package ViewFragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.diegoh.database.R;

import Class.General;
import DTO.DtoPerson;
import VO.PersonBusiness;

/**
 * Created by DIEGO CASALLAS  on 12/12/2015.
 */
public class InsertPerson extends Fragment implements View.OnClickListener{
    private View view;
    private EditText[] editTexts;
    private DtoPerson objPerson;
    private Spinner spinnerCity;
    private Activity activity;
    private Button btnIsert;
    private PersonBusiness  objPersonBusiness;
    private Context context;


    public  InsertPerson() {

        this.objPerson = null;
        this.view = null;
        this.editTexts = new EditText[4];
        this.spinnerCity = null;
        this.activity= General.ACTIVITY;
        this.btnIsert=null;
        this.objPersonBusiness=null;
        this.context=General.CONTEXT;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_insert_person, container, false);
        loadView();
        return view;
    }

    private void loadView() {

        editTexts[0] = (EditText) view.findViewById(R.id.editTextName);
        editTexts[1] = (EditText) view.findViewById(R.id.editTextSurname);
        editTexts[2] = (EditText) view.findViewById(R.id.editTextDocumente);
        editTexts[3] = (EditText) view.findViewById(R.id.editTextPhone);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(activity, R.array.city, android.R.layout.simple_spinner_dropdown_item);

        spinnerCity = (Spinner) view.findViewById(R.id.spinnerCity);
        spinnerCity.setAdapter(arrayAdapter);

        btnIsert=(Button)view.findViewById(R.id.btnInsert);
        btnIsert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        objPerson=new DtoPerson();
        objPersonBusiness= new PersonBusiness(context);
        String[]stringsData=new String[5];
        stringsData[0]=editTexts[0].getText().toString();
        stringsData[1]=editTexts[1].getText().toString();
        stringsData[2]=editTexts[2].getText().toString();
        stringsData[3]=editTexts[3].getText().toString();
        stringsData[4]=spinnerCity.getSelectedItem().toString();




        if(validateData(stringsData)){
            objPerson.setsDocument(stringsData[2]);
            objPerson.setsName(stringsData[0]);
            objPerson.setsSurname(stringsData[1]);
            objPerson.setsCity(stringsData[4]);
            objPerson.setsPhone(stringsData[3]);

            if(objPersonBusiness.insertPerson(objPerson)!=-1){
                Toast.makeText(getActivity(),R.string.men2,Toast.LENGTH_LONG).show();
                cleanBox();
            }
            else{
                Toast.makeText(getActivity(),R.string.men3,Toast.LENGTH_LONG).show();
            }

        }
        else{

            Toast.makeText(getActivity(),R.string.men1,Toast.LENGTH_LONG).show();
        }
    }
   private void cleanBox(){

       editTexts[0].setText("");
       editTexts[1].setText("");
       editTexts[2].setText("");
       editTexts[3].setText("");
   }
    private boolean validateData(String [] data){
        boolean bValidateData=true;
        for(int i=0;i<data.length;i++){


            if(data[i].equals("") || data[i].length()==0 ){

                bValidateData=false;
            }
        }
        return bValidateData;

    }
}
