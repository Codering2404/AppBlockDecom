package com.google.android.libraries.places.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzsi extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    /* synthetic */ Object f78548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f78549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f78550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzsj f78551d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzsi(zzsj zzsjVar, Continuation continuation) {
        super(continuation);
        this.f78551d = zzsjVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f78548a = obj;
        this.f78549b |= Integer.MIN_VALUE;
        return this.f78551d.emit(null, this);
    }
}
