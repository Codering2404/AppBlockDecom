package com.google.android.libraries.places.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxh extends zzbln {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f77148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbxi f77149b;

    /* synthetic */ zzbxh(zzbxi zzbxiVar, byte[] bArr) {
        Objects.requireNonNull(zzbxiVar);
        this.f77149b = zzbxiVar;
        this.f77148a = new AtomicBoolean(false);
    }

    @Override // com.google.android.libraries.places.internal.zzbln
    public final zzbli a(zzblj zzbljVar) {
        if (this.f77148a.compareAndSet(false, true)) {
            final zzbxi zzbxiVar = this.f77149b;
            zzbnx zzbnxVarD = zzbxiVar.f().d();
            zzbnxVarD.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzbxg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzbxiVar.d();
                }
            });
            zzbnxVarD.zza();
        }
        return zzbli.d();
    }
}
