package com.google.android.gms.internal.ads;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgbr extends SuspendLambda implements Function2 {
    /* synthetic */ Object zza;
    final /* synthetic */ zzgat zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgbr(zzgat zzgatVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzgatVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzgbr zzgbrVar = new zzgbr(this.zzb, continuation);
        zzgbrVar.zza = obj;
        return zzgbrVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzgbr) create((zzgax) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        ResultKt.b(obj);
        zzgaz zzgazVarZza = zzgay.zza((zzgav) ((zzgax) this.zza).zzcc());
        zzihj zzihjVarZzb = zzgazVarZza.zzb();
        zzgat zzgatVar = this.zzb;
        String strZza = zzgatVar.zza();
        Intrinsics.checkNotNullExpressionValue(strZza, "getGwsQueryId(...)");
        zzgazVarZza.zzc(zzihjVarZzb, strZza, zzgatVar);
        return zzgazVarZza.zza();
    }
}
