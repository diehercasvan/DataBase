package Class;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diegoh.database.R;

import java.util.ArrayList;

import DTO.DtoPerson;
import VO.PersonBusiness;
import ViewFragments.SearchPerson;

/**
 * Created by DIEGO  CASALLAS  on 23/11/2015.
 */
public class MyAdapter extends ArrayAdapter<DtoPerson>{

    private int iLayout;
    private  ViewHolder viewHolder;
    private PersonBusiness objPersonBusiness;
    private DtoPerson objPerson;
    public  int idPerson;
    public MyAdapter(Context context, int resource, ArrayList<DtoPerson> objects) {
        super(context, resource, objects);
        iLayout=resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder mainviewHolder = null;


        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(iLayout,parent,false);

            ViewHolder viewHolder=new ViewHolder();
            viewHolder.imageView=(ImageView)convertView.findViewById(R.id.imageView);
            viewHolder.title=(TextView)convertView.findViewById(R.id.Title);

            viewHolder.subTitle=(TextView)convertView.findViewById(R.id.subTitle);
            viewHolder.btnDelete=(ImageButton)convertView.findViewById(R.id.btnDelete);
            viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialogSelection(v.getId());
                    Snackbar.make(v, "Button was clicked for list item Delete in the position " + v.getId(), Snackbar.LENGTH_SHORT).show();

                }
            });
            viewHolder.btnUdate=(ImageButton)convertView.findViewById(R.id.btnUpdate);
            viewHolder.btnUdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Snackbar.make(v, "Button was clicked for list item Update in  position : " + v.getId(), Snackbar.LENGTH_SHORT).show();
                }
            });
            convertView.setTag(viewHolder);
        }else {

            mainviewHolder = (ViewHolder) convertView.getTag();
            mainviewHolder.title.setText(getItem(position).getsName()+" " +getItem(position).getsSurname());
            mainviewHolder.subTitle.setText(getItem(position).getsDocument());
            mainviewHolder.btnDelete.setId(getItem(position).getiID());
            mainviewHolder.btnUdate.setId(getItem(position).getiID());


        }


        return convertView;
    }
    public  class ViewHolder{
        ImageView imageView;
        TextView title;
        TextView subTitle;
        ImageButton btnUdate;
        ImageButton btnDelete;


    }
    public void dialogSelection(final int id){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setMessage("Are you sure,You wanted to make decision");

        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                deletePerson(id);
            }
        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public  void deletePerson(int idPerson){
        this.objPerson=new DtoPerson();
        this.objPersonBusiness=new PersonBusiness(getContext());

        objPerson.setiID(idPerson);
        if(objPersonBusiness.deletePerson(objPerson)!=-1)
        {
            Toast.makeText(getContext(), R.string.men4, Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getContext(),R.string.men5,Toast.LENGTH_LONG).show();
        }

    }
}
