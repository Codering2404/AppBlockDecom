package com.google.android.libraries.places.internal;

import java.util.HashMap;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzsc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f78544a = 0;

    static {
        Math.abs(new Random().nextInt());
        new HashMap();
    }

    public static final Runnable a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return new zzsb(new Ref.ObjectRef(), zzrh.b(false), runnable);
    }
}
