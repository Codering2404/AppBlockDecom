package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzevs implements zzfci {
    final ArrayList zza;

    public zzevs(ArrayList arrayList) {
        this.zza = arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzfln.zzg((Bundle) obj, "android_permissions", this.zza);
    }
}
