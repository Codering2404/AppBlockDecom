package com.google.android.recaptcha.internal;

import java.util.concurrent.Executors;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbi {
    private final CoroutineScope zza = CoroutineScopeKt.b();
    private final CoroutineScope zzb;
    private final CoroutineScope zzc;
    private final CoroutineScope zzd;

    public zzbi() {
        CoroutineScope coroutineScopeA = CoroutineScopeKt.a(ExecutorsKt.c(Executors.newSingleThreadExecutor()));
        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new zzbh(null), 3, null);
        this.zzb = coroutineScopeA;
        this.zzc = CoroutineScopeKt.a(Dispatchers.b());
        CoroutineScope coroutineScopeA2 = CoroutineScopeKt.a(ExecutorsKt.c(Executors.newSingleThreadExecutor()));
        BuildersKt__Builders_commonKt.d(coroutineScopeA2, null, null, new zzbg(null), 3, null);
        this.zzd = coroutineScopeA2;
    }

    public final CoroutineScope zza() {
        return this.zzc;
    }

    public final CoroutineScope zzb() {
        return this.zza;
    }

    public final CoroutineScope zzc() {
        return this.zzd;
    }

    public final CoroutineScope zzd() {
        return this.zzb;
    }
}
