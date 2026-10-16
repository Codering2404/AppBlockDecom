package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgpt implements zzgpe {
    private final List zza = new ArrayList();

    zzgpt() {
    }

    public final synchronized void zza(List list) {
        List list2 = this.zza;
        list2.clear();
        list2.addAll(list);
    }

    @Override // com.google.android.gms.internal.ads.zzgpe
    public final synchronized void zzc(Map map, Context context, View view) {
        List list = this.zza;
        map.put("vst", new ArrayList(list));
        list.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzgpe
    public final void zzb(Map map) {
    }

    @Override // com.google.android.gms.internal.ads.zzgpe
    public final void zzd(Map map) {
    }
}
