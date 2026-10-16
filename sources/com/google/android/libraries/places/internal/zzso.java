package com.google.android.libraries.places.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzso extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f78562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function2 f78563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f78564c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzso(Function2 function2, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f78563b = function2;
        this.f78564c = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzso(this.f78563b, this.f78564c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzso) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f78562a;
        ResultKt.b(obj);
        if (i3 != 0) {
            return obj;
        }
        Function2 function2 = this.f78563b;
        Object obj2 = this.f78564c;
        this.f78562a = 1;
        Object objInvoke = function2.invoke(obj2, this);
        return objInvoke == objF ? objF : objInvoke;
    }
}
