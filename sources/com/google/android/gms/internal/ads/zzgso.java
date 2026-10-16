package com.google.android.gms.internal.ads;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgso extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzgsm zzc;
    final /* synthetic */ Function2 zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgso(zzgsm zzgsmVar, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzgsmVar;
        this.zzd = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzgso zzgsoVar = new zzgso(this.zzc, this.zzd, continuation);
        zzgsoVar.zze = obj;
        return zzgsoVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzgso) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Function2 function2;
        Mutex mutexZza;
        Mutex mutex;
        Throwable th;
        Object objF = IntrinsicsKt.f();
        int i3 = this.zzb;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScopeKt.g((CoroutineScope) this.zze);
                zzgsm zzgsmVar = this.zzc;
                function2 = this.zzd;
                mutexZza = zzgsmVar.zza();
                this.zze = mutexZza;
                this.zza = function2;
                this.zzb = 1;
                if (zzgsp.zze(mutexZza, this) != objF) {
                }
                return objF;
            }
            if (i3 != 1) {
                mutex = (Mutex) this.zze;
                try {
                    ResultKt.b(obj);
                    Mutex.DefaultImpls.c(mutex, null, 1, null);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    Mutex.DefaultImpls.c(mutex, null, 1, null);
                    throw th;
                }
            }
            function2 = (Function2) this.zza;
            Mutex mutex2 = (Mutex) this.zze;
            ResultKt.b(obj);
            mutexZza = mutex2;
            this.zze = mutexZza;
            this.zza = null;
            this.zzb = 2;
            Object objF2 = CoroutineScopeKt.f(function2, this);
            if (objF2 != objF) {
                mutex = mutexZza;
                obj = objF2;
                Mutex.DefaultImpls.c(mutex, null, 1, null);
                return obj;
            }
            return objF;
        } catch (Throwable th3) {
            mutex = mutexZza;
            th = th3;
            Mutex.DefaultImpls.c(mutex, null, 1, null);
            throw th;
        }
    }
}
