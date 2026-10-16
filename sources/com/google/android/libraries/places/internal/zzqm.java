package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.Place;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzqm extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f78467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzqr f78468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Place f78469c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzqm(zzqr zzqrVar, Place place, Continuation continuation) {
        super(2, continuation);
        this.f78468b = zzqrVar;
        this.f78469c = place;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzqm(this.f78468b, this.f78469c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzqm) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f78467a;
        ResultKt.b(obj);
        if (i3 != 0) {
            return obj;
        }
        zzqr zzqrVar = this.f78468b;
        List listR = this.f78469c.R();
        this.f78467a = 1;
        Object objL0 = zzqrVar.L0(listR, this);
        return objL0 == objF ? objF : objL0;
    }
}
