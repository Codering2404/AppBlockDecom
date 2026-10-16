package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzbed extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f76093a;

    public zzbed(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    final void a() {
        this.f76093a = true;
    }

    final boolean b() {
        return this.f76093a;
    }

    public zzbed(String str) {
        super(str);
    }
}
