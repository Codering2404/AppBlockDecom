package com.google.android.gms.internal.ads;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgsp {
    public static final Deferred zza(CoroutineScope coroutineScope, zzgsm coroutineSequence, Function2 block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(coroutineSequence, "coroutineSequence");
        Intrinsics.checkNotNullParameter(block, "block");
        return BuildersKt__Builders_commonKt.b(coroutineScope, null, CoroutineStart.f140919d, new zzgso(coroutineSequence, block, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object zzd(Mutex mutex, Continuation continuation) {
        Object objF = mutex.f(null, continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object zze(Mutex mutex, Continuation continuation) {
        if (IntrinsicsKt.d(zzgsn.zza, mutex, continuation) != IntrinsicsKt.f()) {
            IntrinsicsKt.c(continuation).resumeWith(Result.b(Unit.f139807a));
        }
        Object objF = IntrinsicsKt.f();
        if (objF == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }
}
