package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcw extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzdc zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcw(zzdc zzdcVar, Continuation continuation) {
        super(continuation);
        this.zzb = zzdcVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objMo376execute0E7RQCE = this.zzb.mo376execute0E7RQCE(null, 0L, this);
        return objMo376execute0E7RQCE == IntrinsicsKt.f() ? objMo376execute0E7RQCE : Result.a(objMo376execute0E7RQCE);
    }
}
