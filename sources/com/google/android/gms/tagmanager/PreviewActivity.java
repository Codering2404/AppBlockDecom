package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class PreviewActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            zzbf zzbfVar = zzdg.zzb;
            zzbfVar.zzb("Preview activity");
            Uri data = getIntent().getData();
            if (data == null) {
                Log.e("GoogleTagManager", "data is null in PreviewActivity.onCreate");
                return;
            }
            if (!TagManager.getInstance(this).zzd(data)) {
                String str = "Cannot preview the app with the uri: " + data.toString() + ". Launching current version instead.";
                Log.w("GoogleTagManager", str);
                AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
                alertDialogCreate.setTitle("Preview failure");
                alertDialogCreate.setMessage(str);
                alertDialogCreate.setButton(-1, "Continue", new zzdy(this));
                alertDialogCreate.show();
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage == null) {
                zzbfVar.zzb("No launch activity found for package name: " + getPackageName());
                return;
            }
            zzbfVar.zzb("Invoke the launch activity for package name: " + getPackageName());
            startActivity(launchIntentForPackage);
        } catch (Exception e3) {
            Log.e("GoogleTagManager", "Calling preview threw an exception: ".concat(String.valueOf(e3.getMessage())));
        }
    }
}
