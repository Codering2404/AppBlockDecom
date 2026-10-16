package com.google.android.libraries.places.widget;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzag extends FunctionReferenceImpl implements Function1 {
    zzag(Object obj) {
        super(1, obj, PlaceDetailsFragment.class, "onPlaceLoadFailed", "onPlaceLoadFailed(Ljava/lang/Exception;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        Exception p02 = (Exception) obj;
        Intrinsics.checkNotNullParameter(p02, "p0");
        PlaceDetailsFragment.A((PlaceDetailsFragment) this.receiver, p02);
        return Unit.f139807a;
    }
}
