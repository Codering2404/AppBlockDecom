package com.google.android.libraries.places.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzsl extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    /* synthetic */ Object f78556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f78557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f78558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzsm f78559d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzsl(zzsm zzsmVar, Continuation continuation) {
        super(continuation);
        this.f78559d = zzsmVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f78556a = obj;
        this.f78557b |= Integer.MIN_VALUE;
        return this.f78559d.emit(null, this);
    }
}
