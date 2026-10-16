package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgwv extends zzgwg {
    Object[] zzd;
    private int zze;

    public zzgwv() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzgwg, com.google.android.gms.internal.ads.zzgwh
    public final /* bridge */ /* synthetic */ zzgwh zzd(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzgwv zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int iZzo = zzgww.zzo(this.zzb);
            Object[] objArr = this.zzd;
            if (iZzo <= objArr.length) {
                int length = objArr.length - 1;
                int iHashCode = obj.hashCode();
                int iZza = zzgwf.zza(iHashCode);
                while (true) {
                    int i3 = iZza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i3];
                    if (obj2 == null) {
                        objArr2[i3] = obj;
                        this.zze += iHashCode;
                        super.zza(obj);
                        return this;
                    }
                    if (obj2.equals(obj)) {
                        return this;
                    }
                    iZza = i3 + 1;
                }
            }
        }
        this.zzd = null;
        super.zza(obj);
        return this;
    }

    public final zzgwv zzg(Iterable iterable) {
        iterable.getClass();
        if (this.zzd == null) {
            super.zzc(iterable);
            return this;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzf(it.next());
        }
        return this;
    }

    public final zzgww zzh() {
        zzgww zzgwwVarZzw;
        int i3 = this.zzb;
        if (i3 == 0) {
            return zzgyn.zza;
        }
        if (i3 == 1) {
            Object obj = this.zza[0];
            Objects.requireNonNull(obj);
            return new zzgyx(obj);
        }
        if (this.zzd == null || zzgww.zzo(i3) != this.zzd.length) {
            zzgwwVarZzw = zzgww.zzw(this.zzb, this.zza);
            this.zzb = zzgwwVarZzw.size();
        } else {
            int i4 = this.zzb;
            Object[] objArrCopyOf = this.zza;
            if (zzgww.zzx(i4, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
            }
            zzgwwVarZzw = new zzgyn(objArrCopyOf, this.zze, this.zzd, r6.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzgwwVarZzw;
    }

    zzgwv(int i3, boolean z2) {
        super(i3);
        this.zzd = new Object[zzgww.zzo(i3)];
    }
}
