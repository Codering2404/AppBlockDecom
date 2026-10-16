package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzduf implements zzblr {
    final /* synthetic */ String zza = "_videoMediaView";
    final /* synthetic */ zzdug zzb;

    zzduf(zzdug zzdugVar, String str) {
        Objects.requireNonNull(zzdugVar);
        this.zzb = zzdugVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final void zza() {
        zzdug zzdugVar = this.zzb;
        if (zzdugVar.zzc() != null) {
            zzdugVar.zzc().zza(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final JSONObject zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final JSONObject zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzblr
    public final void zzb(MotionEvent motionEvent) {
    }
}
