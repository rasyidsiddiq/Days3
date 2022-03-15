package com.example.days3;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBross extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String [] listAct = new String[] {
                "Call Center", "SMS Center", "Driver Direction", "Website", "Info google", "Exit"
        };
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAct));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanPilihan(pilihan);
    }

    private void tampilkanPilihan (String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center")) {
                String nomortel = "tel:0761-73646347";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));

            }else if (pilihan.equals("SMS Center")){
                String smsText = "Rasyid";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("082370579065"));
                a.putExtra("sms_body", smsText);

            } else if (pilihan.equals("Driving Direction")){
                String lokasirs = "google.navigation:q=0.463823,101.390353";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));

            } else if (pilihan.equals("Website")){
                String website = "http://www.awal-bros.net";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
            } else if (pilihan.equals("Info google")){
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Awal Bross");
            }
            startActivity(a);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
