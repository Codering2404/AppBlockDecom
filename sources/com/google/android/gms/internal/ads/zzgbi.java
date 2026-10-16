package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgbi {
    public static final zzgbg zza(final ExecutorService executorService) {
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        return new zzgbg() { // from class: com.google.android.gms.internal.ads.zzgbh
            @Override // com.google.android.gms.internal.ads.zzgbg
            public final /* synthetic */ CoroutineScope zza() {
                return CoroutineScopeKt.a(ExecutorsKt.c(executorService));
            }
        };
    }
}
