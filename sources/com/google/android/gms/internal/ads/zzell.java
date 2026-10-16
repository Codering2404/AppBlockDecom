package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzell {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzfkf zzc;
    private final zzcku zzd;
    private final zzdzl zze;
    private zzfuw zzf;

    zzell(Context context, VersionInfoParcel versionInfoParcel, zzfkf zzfkfVar, zzcku zzckuVar, zzdzl zzdzlVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfkfVar;
        this.zzd = zzckuVar;
        this.zze = zzdzlVar;
    }

    public final synchronized boolean zza(boolean z2) {
        zzcku zzckuVar;
        zzfkf zzfkfVar = this.zzc;
        if (zzfkfVar.zzT) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgk)).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgn)).booleanValue() && (zzckuVar = this.zzd) != null) {
                    if (this.zzf != null) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Omid javascript session service already started for ad.");
                        return false;
                    }
                    if (!com.google.android.gms.ads.internal.zzt.y().zza(this.zza)) {
                        int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Unable to initialize omid.");
                        return false;
                    }
                    if (zzfkfVar.zzV.zzb()) {
                        zzfuw zzfuwVarZzi = com.google.android.gms.ads.internal.zzt.y().zzi(this.zzb, zzckuVar.zzD(), true);
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgo)).booleanValue()) {
                            zzdzl zzdzlVar = this.zze;
                            String str = zzfuwVarZzi != null ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            zzdzk zzdzkVarZza = zzdzlVar.zza();
                            zzdzkVarZza.zzc("omid_js_session_success", str);
                            zzdzkVarZza.zzd();
                        }
                        if (zzfuwVarZzi == null) {
                            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
                            com.google.android.gms.ads.internal.util.client.zzo.f("Unable to create javascript session service.");
                            return false;
                        }
                        int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
                        com.google.android.gms.ads.internal.util.client.zzo.e("Created omid javascript session service.");
                        this.zzf = zzfuwVarZzi;
                        zzckuVar.zzal(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final synchronized boolean zzb() {
        return this.zzf != null;
    }

    public final synchronized void zzc() {
        zzcku zzckuVar;
        try {
            zzfuw zzfuwVar = this.zzf;
            if (zzfuwVar == null || (zzckuVar = this.zzd) == null) {
                return;
            }
            Iterator it = zzckuVar.zzF().iterator();
            while (it.hasNext()) {
                com.google.android.gms.ads.internal.zzt.y().zzk(zzfuwVar, (View) it.next());
            }
            zzckuVar.zze("onSdkLoaded", zzgwp.zza());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzd() {
        zzcku zzckuVar;
        if (this.zzf == null || (zzckuVar = this.zzd) == null) {
            return;
        }
        zzckuVar.zze("onSdkImpression", zzgwp.zza());
    }

    public final synchronized void zze(zzfuv zzfuvVar) {
        zzcku zzckuVar;
        zzfuw zzfuwVar = this.zzf;
        if (zzfuwVar == null || (zzckuVar = this.zzd) == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.y().zzj(zzfuwVar, zzfuvVar);
        this.zzf = null;
        zzckuVar.zzal(null);
    }

    public final synchronized void zzf(View view) {
        zzfuw zzfuwVar = this.zzf;
        if (zzfuwVar != null) {
            com.google.android.gms.ads.internal.zzt.y().zzk(zzfuwVar, view);
        }
    }
}
