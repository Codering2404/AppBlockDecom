package com.google.android.libraries.places.widget.internal.placedetails;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzam implements Observer, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Function1 f79184a;

    zzam(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f79184a = function;
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void a(Object obj) {
        this.f79184a.invoke(obj);
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function b() {
        return this.f79184a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(b(), ((FunctionAdapter) obj).b());
        }
        return false;
    }

    public final int hashCode() {
        return b().hashCode();
    }
}
