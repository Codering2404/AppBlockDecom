package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdxc {
    private final zzflu zza;
    private final zzdwz zzb;

    zzdxc(zzflu zzfluVar, zzdwz zzdwzVar) {
        this.zza = zzfluVar;
        this.zzb = zzdwzVar;
    }

    public final zzflw zza(String str, JSONObject jSONObject) throws zzflf {
        zzbvf zzbvfVarZzb;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzbvfVarZzb = new zzbwd(new AdMobAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzbvfVarZzb = new zzbwd(new zzbxu());
            } else {
                zzbvc zzbvcVarZzd = zzd();
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                    try {
                        String string = jSONObject.getString("class_name");
                        zzbvfVarZzb = zzbvcVarZzd.zzc(string) ? zzbvcVarZzd.zzb("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") : zzbvcVarZzd.zzd(string) ? zzbvcVarZzd.zzb(string) : zzbvcVarZzd.zzb("com.google.ads.mediation.customevent.CustomEventAdapter");
                    } catch (JSONException e3) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                        com.google.android.gms.ads.internal.util.client.zzo.d("Invalid custom event.", e3);
                        zzbvfVarZzb = zzbvcVarZzd.zzb(str);
                    }
                } else {
                    zzbvfVarZzb = zzbvcVarZzd.zzb(str);
                }
            }
            zzflw zzflwVar = new zzflw(zzbvfVarZzb);
            this.zzb.zza(str, zzflwVar);
            return zzflwVar;
        } catch (Throwable th) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkL)).booleanValue()) {
                this.zzb.zza(str, null);
            }
            throw new zzflf(th);
        }
    }

    public final zzbxb zzb(String str) throws RemoteException {
        zzbxb zzbxbVarZze = zzd().zze(str);
        this.zzb.zzb(str, zzbxbVarZze);
        return zzbxbVarZze;
    }

    public final boolean zzc() {
        return this.zza.zzd() != null;
    }

    final zzbvc zzd() throws RemoteException {
        zzbvc zzbvcVarZzd = this.zza.zzd();
        if (zzbvcVarZzd != null) {
            return zzbvcVarZzd;
        }
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Unexpected call to adapter creator.");
        throw new RemoteException();
    }
}
