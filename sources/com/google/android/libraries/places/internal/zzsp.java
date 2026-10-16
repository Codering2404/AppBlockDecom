package com.google.android.libraries.places.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzsp implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProducerScope f78565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function2 f78566b;

    zzsp(ProducerScope producerScope, Function2 function2) {
        this.f78565a = producerScope;
        this.f78566b = function2;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ProducerScope producerScope = this.f78565a;
        Object objY = producerScope.y(BuildersKt__Builders_commonKt.b(producerScope, null, null, new zzso(this.f78566b, obj, null), 3, null), continuation);
        return objY == IntrinsicsKt.f() ? objY : Unit.f139807a;
    }
}
