package com.google.android.libraries.places.internal;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.Target;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzpm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f78407a;

    public zzpm(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f78407a = context;
    }

    public final Object a(Uri uri, zzpo zzpoVar, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        Target targetC0 = ((RequestBuilder) Glide.t(this.f78407a).d().I0(uri).i()).C0(zzpoVar);
        Intrinsics.checkNotNullExpressionValue(targetC0, "into(...)");
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }
}
