package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzeb extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzec zzb;
    final /* synthetic */ CompletableDeferred zzc;
    final /* synthetic */ long zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzeb(zzec zzecVar, CompletableDeferred completableDeferred, long j3, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzecVar;
        this.zzc = completableDeferred;
        this.zzd = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzeb(this.zzb, this.zzc, this.zzd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzeb) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        zzbd zzbdVar;
        zzeb zzebVar;
        zzbd e3;
        Object objF = IntrinsicsKt.f();
        if (this.zza != 0) {
            try {
                ResultKt.b(obj);
                zzebVar = this;
            } catch (zzbd e4) {
                zzbdVar = e4;
                zzebVar = this;
                zzebVar.zzb.zzf = zzcm.zzd;
                zzebVar.zzc.a(zzbdVar);
            }
        } else {
            ResultKt.b(obj);
            try {
                zzbq zzbqVar = zzbq.zza;
                zzdz zzdzVar = new zzdz(this.zzb);
                zzea zzeaVar = new zzea(this.zzb, this.zzd, this.zzc, null);
                this.zza = 1;
                zzebVar = this;
                try {
                    obj = zzbqVar.zza(zzdzVar, 100L, 1000L, 2.0d, zzeaVar, zzebVar);
                    if (obj == objF) {
                        return objF;
                    }
                } catch (zzbd e5) {
                    e3 = e5;
                    zzbdVar = e3;
                    zzebVar.zzb.zzf = zzcm.zzd;
                    zzebVar.zzc.a(zzbdVar);
                }
            } catch (zzbd e6) {
                e3 = e6;
                zzebVar = this;
                zzbdVar = e3;
                zzebVar.zzb.zzf = zzcm.zzd;
                zzebVar.zzc.a(zzbdVar);
            }
        }
        ((Boolean) obj).getClass();
        return Unit.f139807a;
    }
}
