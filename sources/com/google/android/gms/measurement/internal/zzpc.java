package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.google.android.gms.internal.measurement.zzid f74421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    List f74422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    List f74423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f74424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzpg f74425e;

    /* synthetic */ zzpc(zzpg zzpgVar, byte[] bArr) {
        Objects.requireNonNull(zzpgVar);
        this.f74425e = zzpgVar;
    }

    private static final long b(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        return ((zzhsVar.zzf() / 1000) / 60) / 60;
    }

    public final boolean a(long j3, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        Preconditions.m(zzhsVar);
        if (this.f74423c == null) {
            this.f74423c = new ArrayList();
        }
        if (this.f74422b == null) {
            this.f74422b = new ArrayList();
        }
        if (!this.f74423c.isEmpty() && b((com.google.android.gms.internal.measurement.zzhs) this.f74423c.get(0)) != b(zzhsVar)) {
            return false;
        }
        long jZzcn = this.f74424d + ((long) zzhsVar.zzcn());
        zzpg zzpgVar = this.f74425e;
        if (!zzpgVar.B0().H(null, zzfy.f73633e1)) {
            zzpgVar.B0();
            if (jZzcn >= zzal.o()) {
                return false;
            }
        } else if (!this.f74423c.isEmpty()) {
            zzpgVar.B0();
            if (jZzcn >= zzal.o()) {
                return false;
            }
        }
        this.f74424d = jZzcn;
        this.f74423c.add(zzhsVar);
        this.f74422b.add(Long.valueOf(j3));
        int size = this.f74423c.size();
        zzpgVar.B0();
        return size < Math.max(1, ((Integer) zzfy.f73649k.b(null)).intValue());
    }
}
