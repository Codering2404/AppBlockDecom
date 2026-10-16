package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfl implements zzau {
    final /* synthetic */ TagManager zza;

    zzfl(TagManager tagManager) {
        this.zza = tagManager;
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public final void zza(Map map) {
        Object obj = map.get("event");
        if (obj != null) {
            TagManager.zzb(this.zza, obj.toString());
        }
    }
}
