package com.google.android.libraries.places.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzsq extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f78567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f78568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f78569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function2 f78570d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzsq(Flow flow, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f78569c = flow;
        this.f78570d = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzsq zzsqVar = new zzsq(this.f78569c, this.f78570d, continuation);
        zzsqVar.f78568b = obj;
        return zzsqVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzsq) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f78567a;
        ResultKt.b(obj);
        if (i3 == 0) {
            ProducerScope producerScope = (ProducerScope) this.f78568b;
            Flow flow = this.f78569c;
            zzsp zzspVar = new zzsp(producerScope, this.f78570d);
            this.f78567a = 1;
            if (flow.collect(zzspVar, this) == objF) {
                return objF;
            }
        }
        return Unit.f139807a;
    }
}
