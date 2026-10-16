package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzduk implements zzbpq {
    private final zzbnf zza;
    private final zzdux zzb;
    private final zzimo zzc;

    public zzduk(zzdqd zzdqdVar, zzdpt zzdptVar, zzdux zzduxVar, zzimo zzimoVar) {
        this.zza = zzdqdVar.zzg(zzdptVar.zzS());
        this.zzb = zzduxVar;
        this.zzc = zzimoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbmv) this.zzc.zzb(), str);
        } catch (RemoteException e3) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            String string = sb.toString();
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g(string, e3);
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zzd("/nativeAdCustomClick", this);
    }
}
