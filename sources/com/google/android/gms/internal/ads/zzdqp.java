package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdqp implements zzblr {
    final /* synthetic */ zzdrq zza;
    final /* synthetic */ ViewGroup zzb;

    zzdqp(zzdrq zzdrqVar, ViewGroup viewGroup) {
        this.zza = zzdrqVar;
        this.zzb = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final void zza() {
        zzgwm zzgwmVar = zzdqo.zza;
        zzdrq zzdrqVar = this.zza;
        Map mapZzj = zzdrqVar.zzj();
        if (mapZzj == null) {
            return;
        }
        int size = zzgwmVar.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = mapZzj.get((String) zzgwmVar.get(i3));
            i3++;
            if (obj != null) {
                zzdrqVar.onClick(this.zzb);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final void zzb(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final JSONObject zzc() {
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final JSONObject zzd() {
        return this.zza.zzp();
    }
}
