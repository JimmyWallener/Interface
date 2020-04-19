package se.gritacademy.schoolproject;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;




public class ContactFragment extends ListFragment {
    private String[] contacts;
    private String[] addresses;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_fragment, container,false);

        contacts = getResources().getStringArray(R.array.contactNames);
        addresses = getResources().getStringArray(R.array.contactAddress);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                R.layout.listrow, R.id.textView2, contacts);
        setListAdapter(adapter);
        return view;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){

        AddressFragment text = (AddressFragment)getFragmentManager().findFragmentById(R.id.detailsFragment);
        text.changeText("Name: " + contacts[position], "Adress: " + addresses[position]);
        getListView().setSelector(android.R.color.holo_orange_light);


    }
}