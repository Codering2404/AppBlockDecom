package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzccd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzccb f77486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzccy f77487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f77488c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzcca f77489d = new zzcca(this, 0, 65535, null);

    public zzccd(zzccb zzccbVar, zzccy zzccyVar) {
        this.f77486a = (zzccb) Preconditions.u(zzccbVar, "transport");
        this.f77487b = (zzccy) Preconditions.u(zzccyVar, "frameWriter");
    }

    public final boolean a(int i3) {
        if (i3 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 29);
            sb.append("Invalid initial window size: ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        }
        int i4 = i3 - this.f77488c;
        this.f77488c = i3;
        for (zzcca zzccaVar : this.f77486a.zzm()) {
            zzccaVar.f(i4);
        }
        return i4 > 0;
    }

    public final int b(zzcca zzccaVar, int i3) {
        if (zzccaVar == null) {
            int iF = this.f77489d.f(i3);
            f();
            return iF;
        }
        int iF2 = zzccaVar.f(i3);
        zzccc zzcccVar = new zzccc(null);
        zzccaVar.i(zzccaVar.g(), zzcccVar);
        if (!zzcccVar.a()) {
            return iF2;
        }
        d();
        return iF2;
    }

    public final void c(boolean z2, zzcca zzccaVar, zzcff zzcffVar, boolean z3) {
        Preconditions.u(zzcffVar, "source");
        int iG = zzccaVar.g();
        boolean zH = zzccaVar.h();
        int iZzb = (int) zzcffVar.zzb();
        if (zH || iG < iZzb) {
            if (!zH && iG > 0) {
                zzccaVar.j(zzcffVar, iG, false);
            }
            zzccaVar.k(zzcffVar, (int) zzcffVar.zzb(), z2);
        } else {
            zzccaVar.j(zzcffVar, iZzb, z2);
        }
        if (z3) {
            d();
        }
    }

    public final void d() {
        try {
            this.f77487b.zze();
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final zzcca e(zzcbz zzcbzVar, int i3) {
        return new zzcca(this, i3, this.f77488c, (zzcbz) Preconditions.u(zzcbzVar, "stream"));
    }

    public final void f() {
        int i3;
        zzccb zzccbVar = this.f77486a;
        zzcca[] zzccaVarArrZzm = zzccbVar.zzm();
        Collections.shuffle(Arrays.asList(zzccaVarArrZzm));
        int length = zzccaVarArrZzm.length;
        int iA = this.f77489d.a();
        while (true) {
            i3 = 0;
            if (length <= 0 || iA <= 0) {
                break;
            }
            int iCeil = (int) Math.ceil(iA / length);
            for (int i4 = 0; i4 < length && iA > 0; i4++) {
                zzcca zzccaVar = zzccaVarArrZzm[i4];
                int iMin = Math.min(iA, Math.min(zzccaVar.d(), iCeil));
                if (iMin > 0) {
                    zzccaVar.b(iMin);
                    iA -= iMin;
                }
                if (zzccaVar.d() > 0) {
                    zzccaVarArrZzm[i3] = zzccaVar;
                    i3++;
                }
            }
            length = i3;
        }
        zzccc zzcccVar = new zzccc(null);
        zzcca[] zzccaVarArrZzm2 = zzccbVar.zzm();
        int length2 = zzccaVarArrZzm2.length;
        while (i3 < length2) {
            zzcca zzccaVar2 = zzccaVarArrZzm2[i3];
            zzccaVar2.i(zzccaVar2.c(), zzcccVar);
            zzccaVar2.e();
            i3++;
        }
        if (zzcccVar.a()) {
            d();
        }
    }

    final /* synthetic */ zzccy g() {
        return this.f77487b;
    }

    final /* synthetic */ zzcca h() {
        return this.f77489d;
    }
}
