package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzvh implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zztv f78680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f78681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f78682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzvi f78683d;

    /* synthetic */ zzvh(zzvi zzviVar, zztv zztvVar, int i3, byte[] bArr) {
        Objects.requireNonNull(zzviVar);
        this.f78683d = zzviVar;
        this.f78680a = zztvVar;
        int i4 = i3 & 31;
        this.f78681b = i4;
        this.f78682c = i3 >>> (i4 + 5);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f78681b >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objE = this.f78680a.e(this.f78683d.f(this.f78681b));
        int i3 = this.f78682c;
        if (i3 == 0) {
            this.f78681b = -1;
            return objE;
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i3) + 1;
        this.f78682c >>>= iNumberOfTrailingZeros;
        this.f78681b += iNumberOfTrailingZeros;
        return objE;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
