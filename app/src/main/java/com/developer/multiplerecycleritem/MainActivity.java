package com.developer.multiplerecycleritem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NotificationAdapter bildirimAdapter;
    List<NotificationModel> bildirimModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        recyclerView = findViewById(R.id.recyclerNotification);
        bildirimModelList = new ArrayList<>();


        bildirimModelList.add(new NotificationModel("Fırat Gürgür","firatgurgur","https://cdn.armut.com/UserPics/tr:w-325,h-325/75404c28-b0ea-45e6-b6df-ab740ecba806.jpeg","Seni takip etti","Btakip","true",""));
        bildirimModelList.add(new NotificationModel("Hasan Gürgür","hasangurgur","https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fcdn-img.instyle.com%2Fsites%2Fdefault%2Ffiles%2Fstyles%2F684xflex%2Fpublic%2F1476133215%2F101016-male-feminists-5.jpg%3Fitok%3DH6ZWU8Ds&w=200&c=sc&poi=face&q=85","Seni takip etti","Btakip","false",""));
        bildirimModelList.add(new NotificationModel("Ayşe Gürgür","aysegurgur","http://icongal.com/gallery/image/451523/browser_network_woman_female_girl_internet_user_customer_person_explorer_face_microsoft.png","Gönderini beğendi","Bbegeni","","https://gezirehberin.net/wp-content/uploads/2019/02/izmir-manzara-1-768x512.jpg"));
        bildirimModelList.add(new NotificationModel("Ferdi Gürgür","firatgurgur","https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fcdn-img.instyle.com%2Fsites%2Fdefault%2Ffiles%2Fstyles%2F684xflex%2Fpublic%2F1476133215%2F101016-male-feminists-3.jpg%3Fitok%3DsrI68UYo&w=200&c=sc&poi=face&q=85","Seni takip etti","Btakip","true",""));



        bildirimAdapter =new NotificationAdapter(bildirimModelList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(bildirimAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());




    }
}
