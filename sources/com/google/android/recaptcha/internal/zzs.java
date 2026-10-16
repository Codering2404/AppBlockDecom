package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
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
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzs extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzv zzb;
    final /* synthetic */ String zzc;
    private /* synthetic */ Object zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzs(zzv zzvVar, String str, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzvVar;
        this.zzc = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzs zzsVar = new zzs(this.zzb, this.zzc, continuation);
        zzsVar.zzd = obj;
        return zzsVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzs) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.zza;
        ResultKt.b(obj);
        if (i3 == 0) {
            CoroutineScope coroutineScope = (CoroutineScope) this.zzd;
            ArrayList arrayList = new ArrayList();
            this.zzb.zzo().put(this.zzc, arrayList);
            ArrayList arrayList2 = new ArrayList();
            List list = this.zzb.zzb;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : list) {
                if (((zzy) obj2).zzf()) {
                    arrayList3.add(obj2);
                }
            }
            int size = arrayList3.size();
            for (int i4 = 0; i4 < size; i4++) {
                arrayList2.add(BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new zzr((zzy) arrayList3.get(i4), this.zzc, arrayList, null), 3, null));
            }
            Job[] jobArr = (Job[]) arrayList2.toArray(new Job[0]);
            Job[] jobArr2 = (Job[]) Arrays.copyOf(jobArr, jobArr.length);
            this.zza = 1;
            if (AwaitKt.d(jobArr2, this) == objF) {
                return objF;
            }
        }
        Result.Companion companion = Result.f139772b;
        return Result.a(Result.b(this.zzb.zzq(this.zzc)));
    }
}
