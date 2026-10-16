package com.google.android.libraries.places.internal;

import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzhv implements zzcej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List f77941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SettableFuture f77942b;

    zzhv(zzhw zzhwVar, SettableFuture settableFuture) {
        this.f77942b = settableFuture;
        Objects.requireNonNull(zzhwVar);
        this.f77941a = new ArrayList();
    }

    @Override // com.google.android.libraries.places.internal.zzcej
    public final void zza(Throwable th) {
        this.f77942b.C(th);
    }

    @Override // com.google.android.libraries.places.internal.zzcej
    public final void zzb() {
        List<zzavt> list = this.f77941a;
        for (zzavt zzavtVar : list) {
            if (zzavtVar.H().contains("point_of_interest")) {
                this.f77942b.B(zzavtVar.G());
                return;
            }
        }
        this.f77942b.B(list.isEmpty() ? "" : ((zzavt) list.get(0)).G());
    }

    @Override // com.google.android.libraries.places.internal.zzcej
    public final /* bridge */ /* synthetic */ void zzc(Object obj) {
        this.f77941a.addAll(((zzavp) obj).G());
    }
}
