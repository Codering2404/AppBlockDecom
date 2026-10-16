package com.google.android.recaptcha.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzah extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzan zzb;
    int zzc;
    String zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzah(zzan zzanVar, Continuation continuation) {
        super(continuation);
        this.zzb = zzanVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzj(null, this);
    }
}
