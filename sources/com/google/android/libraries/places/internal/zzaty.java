package com.google.android.libraries.places.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaty extends zzbix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbnp f75896a;

    public zzaty(zzbnp error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f75896a = error;
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void a(zzbiw listener, zzbmg headers) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(headers, "headers");
        listener.c(this.f75896a, new zzbmg());
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void d() {
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void b(Object obj) {
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void c(int i3) {
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void e(String str, Throwable th) {
    }
}
