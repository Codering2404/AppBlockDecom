package com.google.android.libraries.places.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzsr {
    public static final Flow a(Flow flow, int i3, Function2 f3) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(f3, "f");
        if (i3 > 0) {
            return i3 == 1 ? new zzsk(flow, f3) : new zzsn(FlowKt__ContextKt.b(FlowKt.j(new zzsq(flow, f3, null)), i3 - 2, null, 2, null));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 39);
        sb.append("concurrency must be at least 1 but was ");
        sb.append(i3);
        throw new IllegalArgumentException(sb.toString());
    }
}
