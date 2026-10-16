package com.google.android.gms.tagmanager;

import android.os.Build;
import android.util.Log;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbu {
    static boolean zza(String str) {
        try {
            if (Integer.parseInt(Build.VERSION.SDK) >= 9) {
                File file = new File(str);
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
                return true;
            }
        } catch (NumberFormatException unused) {
            Log.e("GoogleTagManager", "Invalid version number: ".concat(String.valueOf(Build.VERSION.SDK)));
        }
        return false;
    }
}
