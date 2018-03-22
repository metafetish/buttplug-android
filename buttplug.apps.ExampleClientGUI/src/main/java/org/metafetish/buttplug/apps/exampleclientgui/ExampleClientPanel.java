package org.metafetish.buttplug.apps.exampleclientgui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.metafetish.buttplug.components.controls.ButtplugTabControl;
import org.metafetish.buttplug.core.ButtplugLogManager;
import org.metafetish.buttplug.core.IButtplugLog;
import org.metafetish.buttplug.server.IButtplugServerFactory;


public class ExampleClientPanel extends Fragment {
    private ButtplugLogManager bpLogManager = new ButtplugLogManager();
    private IButtplugLog bpLogger = this.bpLogManager.getLogger(this.getClass());

    private AppCompatActivity activity;
    private IButtplugServerFactory bpFactory;

    private SharedPreferences sharedPreferences;

    public ExampleClientPanel() {
        // Required empty public constructor
    }

    //TODO: Switch to getParentFragment()
    @SuppressLint("ValidFragment")
    public ExampleClientPanel(ButtplugTabControl bpTabControl) {
        this.bpFactory = bpTabControl;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.activity != null) {
            this.sharedPreferences = this.activity.getPreferences(Context.MODE_PRIVATE);

            //TODO: Why doesn't this work?
            //this.bpFactory = (ButtplugTabControl) getParentFragment();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example_client_panel, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AppCompatActivity) {
            this.activity = (AppCompatActivity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }
}
