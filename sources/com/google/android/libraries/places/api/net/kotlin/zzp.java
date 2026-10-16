package com.google.android.libraries.places.api.net.kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzp extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    /* synthetic */ Object f75444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f75445b;

    zzp(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f75444a = obj;
        this.f75445b |= Integer.MIN_VALUE;
        return PlacesClientKt.awaitSearchByText(null, null, null, null, this);
    }
}
