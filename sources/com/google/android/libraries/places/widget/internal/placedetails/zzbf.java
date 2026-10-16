package com.google.android.libraries.places.widget.internal.placedetails;

import com.google.android.libraries.places.internal.zzsr;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbf extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f79254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f79255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f79256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbj f79257d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbf(List list, zzbj zzbjVar, Continuation continuation) {
        super(2, continuation);
        this.f79256c = list;
        this.f79257d = zzbjVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzbf zzbfVar = new zzbf(this.f79256c, this.f79257d, continuation);
        zzbfVar.f79255b = obj;
        return zzbfVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbf) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f79254a;
        ResultKt.b(obj);
        if (i3 == 0) {
            CoroutineScope coroutineScope = (CoroutineScope) this.f79255b;
            Flow flowA = zzsr.a(FlowKt.a(this.f79256c), FlowKt.N(), new zzbe(coroutineScope, this.f79257d, null));
            this.f79254a = 1;
            if (FlowKt.k(flowA, this) == objF) {
                return objF;
            }
        }
        return Unit.f139807a;
    }
}
