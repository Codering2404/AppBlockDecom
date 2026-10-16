package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfi implements zzbj {
    private final String zza;
    private final Context zzb;
    private final zzfh zzc;
    private final zzfg zzd = new zzfg();

    zzfi(Context context, zzfh zzfhVar) {
        this.zzb = context.getApplicationContext();
        this.zzc = zzfhVar;
        String str = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        String string = null;
        if (locale != null && locale.getLanguage() != null && locale.getLanguage().length() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (locale.getCountry() != null && locale.getCountry().length() != 0) {
                sb.append("-");
                sb.append(locale.getCountry().toLowerCase());
            }
            string = sb.toString();
        }
        this.zza = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleTagManager", "4.00", str, string, Build.MODEL, Build.ID);
    }

    static final URL zzc(zzbz zzbzVar) {
        try {
            return new URL(zzbzVar.zzc());
        } catch (MalformedURLException unused) {
            Log.e("GoogleTagManager", "Error trying to parse the GTM url.");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0085 A[Catch: all -> 0x009f, TryCatch #4 {all -> 0x009f, blocks: (B:14:0x0072, B:16:0x0085, B:19:0x00a1), top: B:47:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1 A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #4 {all -> 0x009f, blocks: (B:14:0x0072, B:16:0x0085, B:19:0x00a1), top: B:47:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.tagmanager.zzbj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.util.List r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzfi.zza(java.util.List):void");
    }

    @Override // com.google.android.gms.tagmanager.zzbj
    public final boolean zzb() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzb.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzdg.zzb.zzd("...no network connectivity");
        return false;
    }
}
