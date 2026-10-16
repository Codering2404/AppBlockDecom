package com.google.android.recaptcha.internal;

import java.util.Iterator;
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
final class zzu extends SuspendLambda implements Function2 {
    Object zza;
    Object zzb;
    int zzc;
    final /* synthetic */ zzsc zzd;
    final /* synthetic */ zzv zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzu(zzsc zzscVar, zzv zzvVar, Continuation continuation) {
        super(2, continuation);
        this.zzd = zzscVar;
        this.zze = zzvVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzu(this.zzd, this.zze, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzu) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzse zzseVarZzj;
        Iterator it;
        Object objF = IntrinsicsKt.f();
        if (this.zzc != 0) {
            it = (Iterator) this.zzb;
            zzseVarZzj = (zzse) this.zza;
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            if (!this.zzd.zzS()) {
                Result.Companion companion = Result.f139772b;
                return Result.a(Result.b(ResultKt.a(new zzbd(zzbb.zzb, zzba.zzab, null))));
            }
            zzseVarZzj = this.zzd.zzj();
            if (zzseVarZzj.zzi().zzd() == 0) {
                Result.Companion companion2 = Result.f139772b;
                return Result.a(Result.b(ResultKt.a(new zzbd(zzbb.zzb, zzba.zzab, null))));
            }
            this.zze.zzc = zzseVarZzj.zzi();
            it = this.zze.zzb.iterator();
        }
        while (it.hasNext()) {
            zzy zzyVar = (zzy) it.next();
            this.zza = zzseVarZzj;
            this.zzb = it;
            this.zzc = 1;
            if (zzyVar.zzd(zzseVarZzj, this) == objF) {
                return objF;
            }
        }
        Result.Companion companion3 = Result.f139772b;
        return Result.a(Result.b(Unit.f139807a));
    }
}
