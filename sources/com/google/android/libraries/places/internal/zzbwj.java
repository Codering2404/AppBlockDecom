package com.google.android.libraries.places.internal;

import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbwj extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbwl f77089a;

    /* synthetic */ zzbwj(zzbwl zzbwlVar, byte[] bArr) {
        Objects.requireNonNull(zzbwlVar);
        this.f77089a = zzbwlVar;
    }

    @Override // java.io.OutputStream
    public final void write(int i3) {
        this.f77089a.c(new byte[]{(byte) i3}, 0, 1);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i3, int i4) {
        this.f77089a.c(bArr, i3, i4);
    }
}
