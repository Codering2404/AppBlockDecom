package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbqx {
    private final Context zza;
    private final OnH5AdsEventListener zzb;
    private zzbqt zzc;

    public zzbqx(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        Preconditions.m(context);
        Preconditions.m(onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
        zzbiq.zza(context);
    }

    public static final boolean zzc(String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlq)).booleanValue()) {
            return false;
        }
        Preconditions.m(str);
        if (str.length() > ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzls)).intValue()) {
            com.google.android.gms.ads.internal.util.client.zzo.a("H5 GMSG exceeds max length");
            return false;
        }
        Uri uri = Uri.parse(str);
        return "gmsg".equals(uri.getScheme()) && "mobileads.google.com".equals(uri.getHost()) && "/h5ads".equals(uri.getPath());
    }

    private final void zzd() {
        if (this.zzc != null) {
            return;
        }
        this.zzc = com.google.android.gms.ads.internal.client.zzay.b().k(this.zza, new zzbuy(), this.zzb);
    }

    public final boolean zza(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzbqt zzbqtVar = this.zzc;
        if (zzbqtVar == null) {
            return false;
        }
        try {
            zzbqtVar.zze(str);
            return true;
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            return true;
        }
    }

    public final void zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlq)).booleanValue()) {
            zzd();
            zzbqt zzbqtVar = this.zzc;
            if (zzbqtVar != null) {
                try {
                    zzbqtVar.zzf();
                } catch (RemoteException e3) {
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                }
            }
        }
    }
}
