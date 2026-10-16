package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcff f77478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f77479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f77480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f77481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzcbz f77482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f77483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ zzccd f77484g;

    zzcca(zzccd zzccdVar, int i3, int i4, zzcbz zzcbzVar) {
        Objects.requireNonNull(zzccdVar);
        this.f77484g = zzccdVar;
        this.f77478a = new zzcff();
        this.f77483f = false;
        this.f77479b = i3;
        this.f77480c = i4;
        this.f77482e = zzcbzVar;
    }

    final int a() {
        return this.f77480c;
    }

    final void b(int i3) {
        this.f77481d += i3;
    }

    final int c() {
        return this.f77481d;
    }

    final int d() {
        return Math.max(0, Math.min(this.f77480c, (int) this.f77478a.zzb())) - this.f77481d;
    }

    final void e() {
        this.f77481d = 0;
    }

    final int f(int i3) {
        if (i3 <= 0 || Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 >= this.f77480c) {
            int i4 = this.f77480c + i3;
            this.f77480c = i4;
            return i4;
        }
        int i5 = this.f77479b;
        StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 33);
        sb.append("Window size overflow for stream: ");
        sb.append(i5);
        throw new IllegalArgumentException(sb.toString());
    }

    final int g() {
        return Math.min(this.f77480c, this.f77484g.h().f77480c);
    }

    final boolean h() {
        return this.f77478a.zzb() > 0;
    }

    final int i(int i3, zzccc zzcccVar) {
        int iMin = Math.min(i3, g());
        int iZzb = 0;
        while (h() && iMin > 0) {
            zzcff zzcffVar = this.f77478a;
            if (iMin >= zzcffVar.zzb()) {
                iZzb += (int) zzcffVar.zzb();
                j(zzcffVar, (int) zzcffVar.zzb(), this.f77483f);
            } else {
                iZzb += iMin;
                j(zzcffVar, iMin, false);
            }
            zzcccVar.f77485a++;
            iMin = Math.min(i3 - iZzb, g());
        }
        return iZzb;
    }

    final void j(zzcff zzcffVar, int i3, boolean z2) {
        do {
            zzccd zzccdVar = this.f77484g;
            int iMin = Math.min(i3, zzccdVar.g().zzg());
            int i4 = -iMin;
            zzccdVar.h().f(i4);
            f(i4);
            try {
                boolean z3 = false;
                if (zzcffVar.zzb() == iMin && z2) {
                    z3 = true;
                }
                zzccdVar.g().Y0(z3, this.f77479b, zzcffVar, iMin);
                this.f77482e.zzt(iMin);
                i3 -= iMin;
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        } while (i3 > 0);
    }

    final void k(zzcff zzcffVar, int i3, boolean z2) {
        this.f77478a.i2(zzcffVar, i3);
        this.f77483f |= z2;
    }
}
