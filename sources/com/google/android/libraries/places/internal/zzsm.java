package com.google.android.libraries.places.internal;

import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzsm implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FlowCollector f78560a;

    public zzsm(FlowCollector flowCollector) {
        this.f78560a = flowCollector;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r7.emit(r8, r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.google.android.libraries.places.internal.zzsl
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.libraries.places.internal.zzsl r0 = (com.google.android.libraries.places.internal.zzsl) r0
            int r1 = r0.f78557b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f78557b = r1
            goto L18
        L13:
            com.google.android.libraries.places.internal.zzsl r0 = new com.google.android.libraries.places.internal.zzsl
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f78556a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f78557b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            goto L5c
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.f78558c
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.ResultKt.b(r8)
            goto L50
        L3c:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.flow.FlowCollector r8 = r6.f78560a
            kotlinx.coroutines.Deferred r7 = (kotlinx.coroutines.Deferred) r7
            r0.f78558c = r8
            r0.f78557b = r4
            java.lang.Object r7 = r7.await(r0)
            if (r7 == r1) goto L5f
            r5 = r8
            r8 = r7
            r7 = r5
        L50:
            r2 = 0
            r0.f78558c = r2
            r0.f78557b = r3
            java.lang.Object r7 = r7.emit(r8, r0)
            if (r7 != r1) goto L5c
            goto L5f
        L5c:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzsm.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
