package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbfq implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f76159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f76160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Iterator f76161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbfs f76162d;

    /* synthetic */ zzbfq(zzbfs zzbfsVar, byte[] bArr) {
        Objects.requireNonNull(zzbfsVar);
        this.f76162d = zzbfsVar;
        this.f76159a = -1;
    }

    private final Iterator a() {
        if (this.f76161c == null) {
            this.f76161c = this.f76162d.k().entrySet().iterator();
        }
        return this.f76161c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3 = this.f76159a + 1;
        zzbfs zzbfsVar = this.f76162d;
        if (i3 >= zzbfsVar.j()) {
            return !zzbfsVar.k().isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.f76160b = true;
        int i3 = this.f76159a + 1;
        this.f76159a = i3;
        zzbfs zzbfsVar = this.f76162d;
        return i3 < zzbfsVar.j() ? (zzbfp) zzbfsVar.i()[i3] : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f76160b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f76160b = false;
        zzbfs zzbfsVar = this.f76162d;
        zzbfsVar.h();
        int i3 = this.f76159a;
        if (i3 >= zzbfsVar.j()) {
            a().remove();
        } else {
            this.f76159a = i3 - 1;
            zzbfsVar.g(i3);
        }
    }
}
