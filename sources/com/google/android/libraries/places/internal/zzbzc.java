package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbzc implements zzbpn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzbzd f77242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbzf f77243b;

    zzbzc(zzbzf zzbzfVar, zzbzd zzbzdVar) {
        Objects.requireNonNull(zzbzfVar);
        this.f77243b = zzbzfVar;
        this.f77242a = zzbzdVar;
    }

    private static final Integer d(zzbmg zzbmgVar) {
        String str = (String) zzbmgVar.b(zzbzf.B);
        if (str == null) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public final void a(zzbmg zzbmgVar) {
        AtomicInteger atomicInteger;
        int i3;
        int i4;
        zzbzd zzbzdVar = this.f77242a;
        int i5 = zzbzdVar.f77247d;
        if (i5 > 0) {
            zzbmc zzbmcVar = zzbzf.A;
            zzbmgVar.d(zzbmcVar);
            zzbmgVar.c(zzbmcVar, String.valueOf(i5));
        }
        zzbzf zzbzfVar = this.f77243b;
        zzbzfVar.Z(zzbzdVar);
        if (zzbzfVar.x().f77226f == zzbzdVar) {
            if (zzbzfVar.v() != null) {
                zzbze zzbzeVarV = zzbzfVar.v();
                do {
                    atomicInteger = zzbzeVarV.f77251d;
                    i3 = atomicInteger.get();
                    i4 = zzbzeVarV.f77248a;
                    if (i3 == i4) {
                        break;
                    }
                } while (!atomicInteger.compareAndSet(i3, Math.min(zzbzeVarV.f77250c + i3, i4)));
            }
            zzbnx zzbnxVar = (zzbnx) zzbzfVar.m();
            zzbnxVar.a(new zzbyv(this, zzbmgVar));
            zzbnxVar.zza();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ae  */
    @Override // com.google.android.libraries.places.internal.zzbpn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(com.google.android.libraries.places.internal.zzbnp r21, com.google.android.libraries.places.internal.zzbpm r22, com.google.android.libraries.places.internal.zzbmg r23) {
        /*
            Method dump skipped, instruction units count: 721
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbzc.b(com.google.android.libraries.places.internal.zzbnp, com.google.android.libraries.places.internal.zzbpm, com.google.android.libraries.places.internal.zzbmg):void");
    }

    @Override // com.google.android.libraries.places.internal.zzcad
    public final void c(zzcac zzcacVar) {
        zzbzf zzbzfVar = this.f77243b;
        zzbzd zzbzdVar = zzbzfVar.x().f77226f;
        Preconditions.A(zzbzdVar != null, "Headers should be received prior to messages.");
        if (zzbzdVar != this.f77242a) {
            zzbsz.g(zzcacVar);
            return;
        }
        zzbnx zzbnxVar = (zzbnx) zzbzfVar.m();
        zzbnxVar.a(new zzbza(this, zzcacVar));
        zzbnxVar.zza();
    }

    @Override // com.google.android.libraries.places.internal.zzcad
    public final void zzd() {
        zzbzf zzbzfVar = this.f77243b;
        if (zzbzfVar.zzm()) {
            zzbnx zzbnxVar = (zzbnx) zzbzfVar.m();
            zzbnxVar.a(new zzbzb(this));
            zzbnxVar.zza();
        }
    }
}
