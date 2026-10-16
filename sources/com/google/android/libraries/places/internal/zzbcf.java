package com.google.android.libraries.places.internal;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbcf extends zzbcg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f75990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f75991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbcl f75992c;

    zzbcf(zzbcl zzbclVar) {
        Objects.requireNonNull(zzbclVar);
        this.f75992c = zzbclVar;
        this.f75990a = 0;
        this.f75991b = zzbclVar.d();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f75990a < this.f75991b;
    }

    @Override // com.google.android.libraries.places.internal.zzbci
    public final byte zza() {
        int i3 = this.f75990a;
        if (i3 >= this.f75991b) {
            throw new NoSuchElementException();
        }
        this.f75990a = i3 + 1;
        return this.f75992c.b(i3);
    }
}
