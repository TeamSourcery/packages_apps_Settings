/*
 * Copyright (C) 2011 Sourcery Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.ServiceManager;
import android.os.StatFs;
import android.os.SystemProperties;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceClickListener;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.text.format.Formatter;
import android.util.Log;
import android.view.IWindowManager;
import android.widget.Toast;


import java.io.File;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.NumberFormat;

import java.io.FileNotFoundException;

import android.net.Uri;
import android.util.Xml;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class CreditSettings extends SettingsPreferenceFragment {

private static final String TAG = "CreditSettings";
  
@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

if (getPreferenceManager() != null) {
        addPreferencesFromResource(R.xml.credit_settings);

 ContentResolver resolver = getActivity().getApplicationContext().getContentResolver();

            PreferenceScreen prefSet = getPreferenceScreen();
 
        Preference donateLink = (Preference) findPreference("donatePref");
        donateLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://bit.ly/w7XllD";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

        Preference changelogLink = (Preference) findPreference("changelogPref");
        changelogLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://www.teamsourcery.com/ICSourcery/changelog/icsourcery-credits.html";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

            Preference androiddoesLink = (Preference) findPreference("androiddoesPref");
        androiddoesLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://blog.anddoes.com/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

            Preference buckmarbleLink = (Preference) findPreference("buckmarblePref");
        buckmarbleLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://maverickrom.us.to/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

              Preference thepysntystLink = (Preference) findPreference("thepysntystPref");
        thepysntystLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://rootzwiki.com/user/4743-thepsyntyst/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

       
              Preference cjmLink = (Preference) findPreference("cjmPref");
        cjmLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://www.galaxynexusforum.com/forum/members/392.html";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

           Preference kernelsLink = (Preference) findPreference("kernelsPref");
       kernelsLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://forum.xda-developers.com/forumdisplay.php?f=1455";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

           
           Preference droidforumLink = (Preference) findPreference("droidforumPref");
       droidforumLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://www.droidforums.net/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

           Preference rootwikiLink = (Preference) findPreference("rootwikiPref");
       rootwikiLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://rootzwiki.com/news";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

         Preference xdaLink = (Preference) findPreference("xdaPref");
       xdaLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://www.xda-developers.com/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

          Preference teaminitLink = (Preference) findPreference("teaminitPref");
       teaminitLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://init2winitapps.com/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});


           Preference forumLink = (Preference) findPreference("forumPref");
        forumLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://teamsourcery.com/phpBB3/index.php";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

 Preference githubLink = (Preference) findPreference("githubPref");
       githubLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "https://github.com/TeamSourcery";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

 Preference tdevLink = (Preference) findPreference("tdevPref");
       tdevLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "https://teamsourcery.com/ICSourcery/bios/T-dev.html";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});

  Preference websiteLink = (Preference) findPreference("websitePref");
        websiteLink.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				String url = "http://www.teamsourcery.com";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);				
				return true;
			}
		});
        
    }
}
}
  
