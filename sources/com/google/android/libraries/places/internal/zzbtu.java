package com.google.android.libraries.places.internal;

import java.net.SocketAddress;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f76870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f76871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f76872c;

    public zzbtu(List list) {
        this.f76870a = list;
    }

    public final boolean a() {
        return this.f76871b < this.f76870a.size();
    }

    public final boolean b() {
        return this.f76871b == 0 && this.f76872c == 0;
    }

    public final void c() {
        zzbka zzbkaVar = (zzbka) this.f76870a.get(this.f76871b);
        int i3 = this.f76872c + 1;
        this.f76872c = i3;
        if (i3 >= zzbkaVar.a().size()) {
            this.f76871b++;
            this.f76872c = 0;
        }
    }

    public final void d() {
        this.f76871b = 0;
        this.f76872c = 0;
    }

    public final SocketAddress e() {
        return (SocketAddress) ((zzbka) this.f76870a.get(this.f76871b)).a().get(this.f76872c);
    }

    public final zzbio f() {
        return ((zzbka) this.f76870a.get(this.f76871b)).b();
    }

    public final void g(List list) {
        this.f76870a = list;
        d();
    }

    public final boolean h(SocketAddress socketAddress) {
        for (int i3 = 0; i3 < this.f76870a.size(); i3++) {
            int iIndexOf = ((zzbka) this.f76870a.get(i3)).a().indexOf(socketAddress);
            if (iIndexOf != -1) {
                this.f76871b = i3;
                this.f76872c = iIndexOf;
                return true;
            }
        }
        return false;
    }
}
