package com.google.android.libraries.places.internal;

import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzcfm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f77748a = 0;

    static {
        Logger.getLogger("okio.Okio");
    }

    public static final boolean a(AssertionError assertionError) {
        String message;
        Intrinsics.checkNotNullParameter(assertionError, "<this>");
        return (assertionError.getCause() == null || (message = assertionError.getMessage()) == null || !StringsKt.a0(message, "getsockname failed", false, 2, null)) ? false : true;
    }
}
