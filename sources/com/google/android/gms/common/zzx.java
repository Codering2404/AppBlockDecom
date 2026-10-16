package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzx extends zzy {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Callable f72366f;

    /* synthetic */ zzx(Callable callable, byte[] bArr) {
        super(false, 1, 5, null, null, -1L, null);
        this.f72366f = callable;
    }

    @Override // com.google.android.gms.common.zzy
    final String a() {
        try {
            return (String) this.f72366f.call();
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }
}
