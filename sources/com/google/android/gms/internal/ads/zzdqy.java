package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdqy implements View.OnClickListener {
    String zza;
    Long zzb;
    WeakReference zzc;
    private final zzdux zzd;
    private final Clock zze;
    private zzbns zzf;
    private zzbpq zzg;

    public zzdqy(zzdux zzduxVar, Clock clock) {
        this.zzd = zzduxVar;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference weakReference = this.zzc;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.zzc = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference weakReference = this.zzc;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.zza != null && this.zzb != null) {
            HashMap map = new HashMap();
            map.put("id", this.zza);
            map.put(SDKConstants.PARAM_A2U_TIME_INTERVAL, String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
            map.put("messageType", "onePointFiveClick");
            this.zzd.zzf("sendMessageToNativeJs", map);
        }
        zzd();
    }

    public final void zza(final zzbns zzbnsVar) {
        this.zzf = zzbnsVar;
        zzbpq zzbpqVar = this.zzg;
        if (zzbpqVar != null) {
            this.zzd.zze("/unconfirmedClick", zzbpqVar);
        }
        zzbpq zzbpqVar2 = new zzbpq() { // from class: com.google.android.gms.internal.ads.zzdqx
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, Map map) {
                zzdqy zzdqyVar = this.zza;
                try {
                    zzdqyVar.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.c("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzbns zzbnsVar2 = zzbnsVar;
                zzdqyVar.zza = (String) map.get("id");
                String str = (String) map.get("asset_id");
                if (zzbnsVar2 == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.a("Received unconfirmed click but UnconfirmedClickListener is null.");
                } else {
                    try {
                        zzbnsVar2.zze(str);
                    } catch (RemoteException e3) {
                        com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                    }
                }
            }
        };
        this.zzg = zzbpqVar2;
        this.zzd.zzd("/unconfirmedClick", zzbpqVar2);
    }

    public final zzbns zzb() {
        return this.zzf;
    }

    public final void zzc() {
        if (this.zzf == null || this.zzb == null) {
            return;
        }
        zzd();
        try {
            this.zzf.zzf();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }
}
