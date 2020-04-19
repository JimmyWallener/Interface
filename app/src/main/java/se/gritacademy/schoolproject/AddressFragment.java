package se.gritacademy.schoolproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AddressFragment extends Fragment {
    TextView name,address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.address_fragment, container,false);
        name = view.findViewById(R.id.Name);
        address = view.findViewById(R.id.Address);
        return view;

    }

    public void changeText(String contactName, String contactAddress) {
        name.setText(contactName);
        address.setText(contactAddress);
    }
}
