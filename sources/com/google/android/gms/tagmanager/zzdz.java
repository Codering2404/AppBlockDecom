package com.google.android.gms.tagmanager;

import android.net.Uri;
import android.util.Log;
import com.facebook.stetho.common.Utf8Charset;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdz {
    private static zzdz zza;
    private volatile int zze = 1;
    private volatile String zzc = null;
    private volatile String zzb = null;
    private volatile String zzd = null;

    zzdz() {
    }

    static zzdz zza() {
        zzdz zzdzVar;
        synchronized (zzdz.class) {
            try {
                if (zza == null) {
                    zza = new zzdz();
                }
                zzdzVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzdzVar;
    }

    private static final String zzf(String str) {
        return str.split("&")[0].split("=")[1];
    }

    final String zzb() {
        return this.zzc;
    }

    final String zzc() {
        return this.zzb;
    }

    final synchronized boolean zzd(Uri uri) {
        try {
            try {
                String strDecode = URLDecoder.decode(uri.toString(), Utf8Charset.NAME);
                if (strDecode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    zzdg.zzb.zzd("Container preview url: ".concat(strDecode));
                    if (strDecode.matches(".*?&gtm_debug=x$")) {
                        this.zze = 3;
                    } else {
                        this.zze = 2;
                    }
                    this.zzd = uri.getQuery().replace("&gtm_debug=x", "");
                    if (this.zze == 2 || this.zze == 3) {
                        this.zzc = "/r?".concat(String.valueOf(this.zzd));
                    }
                    this.zzb = zzf(this.zzd);
                    return true;
                }
                if (!strDecode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    Log.w("GoogleTagManager", "Invalid preview uri: ".concat(strDecode));
                    return false;
                }
                if (!zzf(uri.getQuery()).equals(this.zzb)) {
                    return false;
                }
                zzdg.zzb.zzd("Exit preview mode for container: ".concat(String.valueOf(this.zzb)));
                this.zze = 1;
                this.zzc = null;
                return true;
            } catch (UnsupportedEncodingException unused) {
                return false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    final int zze() {
        return this.zze;
    }
}
