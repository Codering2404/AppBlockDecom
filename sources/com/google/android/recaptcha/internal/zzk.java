package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzk extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzl zzb;
    final /* synthetic */ zzek zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzsc zze;
    private /* synthetic */ Object zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzk(zzl zzlVar, zzek zzekVar, long j3, zzsc zzscVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzlVar;
        this.zzc = zzekVar;
        this.zzd = j3;
        this.zze = zzscVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzk zzkVar = new zzk(this.zzb, this.zzc, this.zzd, this.zze, continuation);
        zzkVar.zzf = obj;
        return zzkVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzk) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        zzen zzenVar;
        Object objB2;
        Object objF = IntrinsicsKt.f();
        if (this.zza != 0) {
            zzenVar = (zzen) this.zzf;
            ResultKt.b(obj);
            objB = obj;
        } else {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.zzf;
            this.zzb.zzb = this.zzc;
            zzek zzekVar = this.zzc;
            zzekVar.zzc(zzekVar.zzd());
            zzen zzenVarZzf = zzekVar.zzf(30);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzb.zzd().iterator();
            while (it.hasNext()) {
                arrayList.add(BuildersKt__Builders_commonKt.b(coroutineScope, null, null, new zzj((zze) it.next(), this.zzd, this.zze, null), 3, null));
            }
            Deferred[] deferredArr = (Deferred[]) arrayList.toArray(new Deferred[0]);
            Deferred[] deferredArr2 = (Deferred[]) Arrays.copyOf(deferredArr, deferredArr.length);
            this.zzf = zzenVarZzf;
            this.zza = 1;
            objB = AwaitKt.b(deferredArr2, this);
            if (objB == objF) {
                return objF;
            }
            zzenVar = zzenVarZzf;
        }
        List list = (List) objB;
        if ((list instanceof Collection) && list.isEmpty()) {
            zzbd zzbdVar = new zzbd(zzbb.zzb, zzba.zzY, null);
            zzenVar.zzb(zzbdVar);
            Result.Companion companion = Result.f139772b;
            objB2 = Result.b(ResultKt.a(zzbdVar));
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (!Result.g(((Result) it2.next()).j())) {
                    zzenVar.zza();
                    objB2 = Result.b(Unit.f139807a);
                    break;
                }
            }
            zzbd zzbdVar2 = new zzbd(zzbb.zzb, zzba.zzY, null);
            zzenVar.zzb(zzbdVar2);
            Result.Companion companion2 = Result.f139772b;
            objB2 = Result.b(ResultKt.a(zzbdVar2));
        }
        return Result.a(objB2);
    }
}
