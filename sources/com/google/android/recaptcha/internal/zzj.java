package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzj extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zze zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzsc zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzj(zze zzeVar, long j3, zzsc zzscVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzeVar;
        this.zzc = j3;
        this.zzd = zzscVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzj(this.zzb, this.zzc, this.zzd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzj) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZze;
        Object objF = IntrinsicsKt.f();
        int i3 = this.zza;
        ResultKt.b(obj);
        if (i3 != 0) {
            objZze = ((Result) obj).j();
        } else {
            zze zzeVar = this.zzb;
            long j3 = this.zzc;
            zzsc zzscVar = this.zzd;
            this.zza = 1;
            objZze = zzeVar.zze(j3, zzscVar, this);
            if (objZze == objF) {
                return objF;
            }
        }
        return Result.a(objZze);
    }
}
