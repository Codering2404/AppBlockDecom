package com.google.android.gms.internal.consent_sdk;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzsq {
    private static final zzsq zza = new zzsq(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzsq(int i3, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = 0;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public static zzsq zzc() {
        return zza;
    }

    static zzsq zze(zzsq zzsqVar, zzsq zzsqVar2) {
        int i3 = zzsqVar.zzb;
        int i4 = zzsqVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzsqVar.zzc, 0);
        System.arraycopy(zzsqVar2.zzc, 0, iArrCopyOf, 0, 0);
        Object[] objArrCopyOf = Arrays.copyOf(zzsqVar.zzd, 0);
        System.arraycopy(zzsqVar2.zzd, 0, objArrCopyOf, 0, 0);
        return new zzsq(0, iArrCopyOf, objArrCopyOf, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzsq)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 506991;
    }

    public final int zza() {
        int i3 = this.zze;
        if (i3 != -1) {
            return i3;
        }
        this.zze = 0;
        return 0;
    }

    public final int zzb() {
        int i3 = this.zze;
        if (i3 != -1) {
            return i3;
        }
        this.zze = 0;
        return 0;
    }

    final zzsq zzd(zzsq zzsqVar) {
        if (zzsqVar.equals(zza)) {
            return this;
        }
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
        int[] iArr = this.zzc;
        int length = iArr.length;
        System.arraycopy(zzsqVar.zzc, 0, iArr, 0, 0);
        System.arraycopy(zzsqVar.zzd, 0, this.zzd, 0, 0);
        this.zzb = 0;
        return this;
    }

    public final void zzf() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    private zzsq() {
        this(0, new int[8], new Object[8], true);
    }

    final void zzh(zztb zztbVar) throws IOException {
    }

    final void zzg(StringBuilder sb, int i3) {
    }
}
