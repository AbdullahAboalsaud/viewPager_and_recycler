package com.example.viewpager_and_recycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.viewpager_and_recycler.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

// Todo:  here we implement ViewPager and tabLayout
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    ArrayList<ModelFragment> list = new ArrayList<>();

    ChatFragment chatFragment;
    StatusFragment statusFragment;

    FragmentMyPagerAdapter fragmentMyPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // defined the fragments
        statusFragment = new StatusFragment();
        chatFragment = new ChatFragment();

        //add fragments with its title to the list
        list.add(new ModelFragment(chatFragment, "chat"));
        list.add(new ModelFragment(statusFragment, "status"));


        fragmentMyPagerAdapter = new FragmentMyPagerAdapter(this, list);
        //set Adapter
        binding.viewPagerContainer.setAdapter(fragmentMyPagerAdapter);

        // put the tab container. and View pager container after we set the adapter to it
        new TabLayoutMediator(binding.tabs, binding.viewPagerContainer, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(list.get(position).getTitle());
            }
        }).attach();

    }


    // here we set binding = null to avoid causing memory league;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;  // remove binding   (important step)
    }

}
