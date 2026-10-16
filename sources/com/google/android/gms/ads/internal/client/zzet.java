package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzbrv;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzet extends zzbrv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzeu f69911a;

    /* synthetic */ zzet(zzeu zzeuVar, byte[] bArr) {
        Objects.requireNonNull(zzeuVar);
        this.f69911a = zzeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final void zzb(List list) {
        int i3;
        ArrayList arrayList;
        zzeu zzeuVar = this.f69911a;
        synchronized (zzeuVar.t()) {
            zzeuVar.v(false);
            zzeuVar.w(true);
            arrayList = new ArrayList(zzeuVar.u());
            zzeuVar.u().clear();
        }
        InitializationStatus initializationStatusB = zzeu.b(list);
        int size = arrayList.size();
        for (i3 = 0; i3 < size; i3++) {
            ((OnInitializationCompleteListener) arrayList.get(i3)).a(initializationStatusB);
        }
    }
}
