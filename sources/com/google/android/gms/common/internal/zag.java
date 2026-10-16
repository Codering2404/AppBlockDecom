package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zag implements DialogInterface.OnClickListener {
    public static zag b(Activity activity, Intent intent, int i3) {
        return new zad(intent, activity, i3);
    }

    public static zag c(LifecycleFragment lifecycleFragment, Intent intent, int i3) {
        return new zaf(intent, lifecycleFragment, 2);
    }

    protected abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e3) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e3);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
