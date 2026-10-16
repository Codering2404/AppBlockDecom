package com.google.android.libraries.places.internal;

import com.google.common.util.concurrent.FutureCallback;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzjm implements FutureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzjp f78024a;

    zzjm(zzjp zzjpVar) {
        Objects.requireNonNull(zzjpVar);
        this.f78024a = zzjpVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        zzjp zzjpVar = this.f78024a;
        zzjpVar.f78032f = null;
        zzjpVar.f78033g = null;
        zzjpVar.f78034h = null;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        zzbha zzbhaVar = (zzbha) obj;
        long jG = ((long) zzbhaVar.G()) & 4294967295L;
        final zzjp zzjpVar = this.f78024a;
        zzjpVar.f78032f = Long.valueOf(jG);
        zzjpVar.f78033g = zzbhaVar.H();
        Long l3 = zzjpVar.f78032f;
        if (l3 != null) {
            zzjpVar.f78034h = zzjpVar.c(l3.longValue());
        }
        if (zzjpVar.f78033g != null) {
            long jG2 = (r6.G() - 3600) - Instant.now().getEpochSecond();
            if (jG2 <= 0) {
                return;
            }
            zzjpVar.f78030d.schedule(new Callable() { // from class: com.google.android.libraries.places.internal.zzjn
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return zzjpVar.b();
                }
            }, jG2, TimeUnit.SECONDS);
        }
    }
}
