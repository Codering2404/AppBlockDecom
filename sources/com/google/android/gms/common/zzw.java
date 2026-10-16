package com.google.android.gms.common;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f72364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f72365c;

    /* synthetic */ zzw(String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, byte[] bArr) {
        this.f72363a = str;
        this.f72364b = z2;
        this.f72365c = z5;
    }

    final boolean a() {
        return this.f72365c;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    final zzp b(Context context) {
        return new zzp(this.f72363a, this.f72364b, false, ObjectWrapper.i5(context), false, true, false);
    }
}
