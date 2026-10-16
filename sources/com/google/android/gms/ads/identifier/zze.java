package com.google.android.gms.ads.identifier;

import android.util.Log;
import com.google.android.gms.internal.ads_identifier.zzh;
import com.google.android.gms.internal.ads_identifier.zzk;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zze {
    public static final void zza(String str) {
        try {
            try {
                zzk.zzb(263);
                URL url = new URL(str);
                int i3 = zzh.zzb;
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 200 || responseCode >= 300) {
                        Log.w("HttpUrlPinger", "Received non-success response code " + responseCode + " from pinging URL: " + str);
                    }
                    zzk.zza();
                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                zzk.zza();
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            Log.w("HttpUrlPinger", "Error while pinging URL: " + str + ". " + e.getMessage(), e);
            zzk.zza();
        } catch (IndexOutOfBoundsException e4) {
            Log.w("HttpUrlPinger", "Error while parsing ping URL: " + str + ". " + e4.getMessage(), e4);
            zzk.zza();
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("HttpUrlPinger", "Error while pinging URL: " + str + ". " + e.getMessage(), e);
            zzk.zza();
        }
    }
}
