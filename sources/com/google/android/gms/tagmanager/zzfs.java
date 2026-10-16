package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzfs extends zzbt {
    public zzfs(String str, String... strArr) {
        super(str, strArr);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        zzc(map);
        return zzfu.zza();
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public boolean zzb() {
        return false;
    }

    public abstract void zzc(Map map);
}
