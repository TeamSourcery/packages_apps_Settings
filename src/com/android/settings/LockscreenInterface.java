/*
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
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.preference.PreferenceCategory;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.Display;
import android.view.Window;
import android.widget.Toast;


import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;

import java.io.File;
import java.io.IOException;

public class LockscreenInterface extends SettingsPreferenceFragment {
    private static final String TAG = "LockscreenInterface";

   

    private int mUnsecureUnlockMethod;

    private Activity mActivity;
    private ContentResolver mResolver;

    public boolean hasButtons() {
        return !getResources().getBoolean(com.android.internal.R.bool.config_showNavigationBar);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = getActivity();
        mResolver = mActivity.getContentResolver();

        createCustomLockscreenView();
     }

     private PreferenceScreen createCustomLockscreenView() {
       PreferenceScreen prefs = getPreferenceScreen();
        if (prefs != null) {
             prefs.removeAll();
        }
 	
        addPreferencesFromResource(R.xml.lockscreen_interface_settings);
        prefs = getPreferenceScreen();
    
   
     mUnsecureUnlockMethod = Settings.System.getInt(getActivity().getContentResolver(),
                Settings.System.LOCKSCREEN_UNSECURE_USED, 1);
     final int lockBeforeUnlock = Settings.System.getInt(getActivity().getContentResolver(),
                Settings.System.LOCK_BEFORE_UNLOCK, 0);
 
     //setup custom lockscreen customize view
        if ((mUnsecureUnlockMethod != 1 && lockBeforeUnlock == 0)
                 || mUnsecureUnlockMethod == -1) {
            
        }
 
        
        return prefs;
	
     }

    @Override
    public void onResume() {
        super.onResume();
        createCustomLockscreenView();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
}
