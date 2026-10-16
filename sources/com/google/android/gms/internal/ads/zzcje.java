package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcje extends zzcja {
    public zzcje(zzchn zzchnVar) {
        super(zzchnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final boolean zze(String str) {
        String strR = com.google.android.gms.ads.internal.util.client.zzf.r(str);
        zzchn zzchnVar = (zzchn) this.zzc.get();
        if (zzchnVar != null && strR != null) {
            zzchnVar.zzt(strR, this);
        }
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("VideoStreamNoopCache is doing nothing.");
        zzq(str, strR, "noop", "Noop cache is a noop.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzl() {
    }
}
