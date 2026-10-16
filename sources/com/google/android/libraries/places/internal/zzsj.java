package com.google.android.libraries.places.internal;

import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzsj implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FlowCollector f78552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function2 f78553b;

    public zzsj(FlowCollector flowCollector, Function2 function2) {
        this.f78552a = flowCollector;
        this.f78553b = function2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
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
            boolean r0 = r8 instanceof com.google.android.libraries.places.internal.zzsi
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.libraries.places.internal.zzsi r0 = (com.google.android.libraries.places.internal.zzsi) r0
            int r1 = r0.f78549b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f78549b = r1
            goto L18
        L13:
            com.google.android.libraries.places.internal.zzsi r0 = new com.google.android.libraries.places.internal.zzsi
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f78548a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f78549b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            goto L64
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.f78550c
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.ResultKt.b(r8)
            goto L58
        L3c:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.flow.FlowCollector r8 = r6.f78552a
            kotlin.jvm.functions.Function2 r2 = r6.f78553b
            r0.f78550c = r8
            r0.f78549b = r4
            r4 = 6
            kotlin.jvm.internal.InlineMarker.c(r4)
            java.lang.Object r7 = r2.invoke(r7, r0)
            r2 = 7
            kotlin.jvm.internal.InlineMarker.c(r2)
            if (r7 == r1) goto L67
            r5 = r8
            r8 = r7
            r7 = r5
        L58:
            r2 = 0
            r0.f78550c = r2
            r0.f78549b = r3
            java.lang.Object r7 = r7.emit(r8, r0)
            if (r7 != r1) goto L64
            goto L67
        L64:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzsj.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
