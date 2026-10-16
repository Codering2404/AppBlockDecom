package com.google.android.libraries.places.internal;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Unsafe f76177a;

    zzbge(Unsafe unsafe) {
        this.f76177a = unsafe;
    }

    public abstract void a(Object obj, long j3, byte b3);

    public abstract boolean b(Object obj, long j3);

    public abstract void c(Object obj, long j3, boolean z2);

    public abstract float d(Object obj, long j3);

    public abstract void e(Object obj, long j3, float f3);

    public abstract double f(Object obj, long j3);

    public abstract void g(Object obj, long j3, double d3);
}
