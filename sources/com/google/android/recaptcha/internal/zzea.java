package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzea extends SuspendLambda implements Function1 {
    Object zza;
    int zzb;
    final /* synthetic */ zzec zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ CompletableDeferred zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzea(zzec zzecVar, long j3, CompletableDeferred completableDeferred, Continuation continuation) {
        super(1, continuation);
        this.zzc = zzecVar;
        this.zzd = j3;
        this.zze = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new zzea(this.zzc, this.zzd, this.zze, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return ((zzea) create((Continuation) obj)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzen zzenVar;
        zzbd e3;
        zzen zzenVar2;
        Object objF = IntrinsicsKt.f();
        int i3 = this.zzb;
        if (i3 == 0) {
            ResultKt.b(obj);
            zzen zzenVarZzf = this.zzc.zzb.zzf(41);
            try {
                zzdt zzdtVar = this.zzc.zza;
                long j3 = this.zzd;
                this.zza = zzenVarZzf;
                this.zzb = 1;
                Object objZzo = zzdtVar.zzo(j3, this);
                if (objZzo != objF) {
                    zzenVar2 = zzenVarZzf;
                    obj = objZzo;
                }
                return objF;
            } catch (zzbd e4) {
                zzenVar = zzenVarZzf;
                e3 = e4;
                this.zzc.zzd = e3;
                zzenVar.zzb(e3);
                throw e3;
            }
        }
        if (i3 != 1) {
            zzenVar = (zzen) this.zza;
            try {
                ResultKt.b(obj);
                zzenVar.zza();
                this.zzc.zzf = zzcm.zzb;
                return Boxing.a(this.zze.J(Unit.f139807a));
            } catch (zzbd e5) {
                e3 = e5;
                this.zzc.zzd = e3;
                zzenVar.zzb(e3);
                throw e3;
            }
        }
        zzenVar2 = (zzen) this.zza;
        try {
            ResultKt.b(obj);
        } catch (zzbd e6) {
            e3 = e6;
            zzenVar = zzenVar2;
            this.zzc.zzd = e3;
            zzenVar.zzb(e3);
            throw e3;
        }
        zzsc zzscVar = (zzsc) obj;
        this.zzc.zze = zzscVar;
        zzdt zzdtVar2 = this.zzc.zza;
        long j4 = this.zzd;
        this.zza = zzenVar2;
        this.zzb = 2;
        if (zzdtVar2.zzn(zzscVar, j4, this) != objF) {
            zzenVar = zzenVar2;
            zzenVar.zza();
            this.zzc.zzf = zzcm.zzb;
            return Boxing.a(this.zze.J(Unit.f139807a));
        }
        return objF;
    }
}
