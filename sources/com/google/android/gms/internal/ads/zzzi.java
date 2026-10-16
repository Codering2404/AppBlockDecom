package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzi {
    private int zza;
    private final SparseArray zzb;
    private final zzdt zzc;

    public zzzi() {
        this(zzzh.zza);
    }

    public final Object zza(int i3) {
        SparseArray sparseArray;
        if (this.zza == -1) {
            this.zza = 0;
        }
        while (true) {
            int i4 = this.zza;
            if (i4 <= 0 || i3 >= this.zzb.keyAt(i4)) {
                break;
            }
            this.zza--;
        }
        while (true) {
            int i5 = this.zza;
            sparseArray = this.zzb;
            if (i5 >= sparseArray.size() - 1 || i3 < sparseArray.keyAt(this.zza + 1)) {
                break;
            }
            this.zza++;
        }
        return sparseArray.valueAt(this.zza);
    }

    public final void zzb(int i3, Object obj) {
        if (this.zza == -1) {
            zzgtj.zzi(this.zzb.size() == 0);
            this.zza = 0;
        }
        SparseArray sparseArray = this.zzb;
        if (sparseArray.size() > 0) {
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            zzgtj.zza(i3 >= iKeyAt);
            if (iKeyAt == i3) {
                this.zzc.zza(sparseArray.valueAt(sparseArray.size() - 1));
            }
        }
        sparseArray.append(i3, obj);
    }

    public final Object zzc() {
        return this.zzb.valueAt(r0.size() - 1);
    }

    public final void zzd(int i3) {
        int i4 = 0;
        while (true) {
            SparseArray sparseArray = this.zzb;
            if (i4 >= sparseArray.size() - 1) {
                return;
            }
            int i5 = i4 + 1;
            if (i3 < sparseArray.keyAt(i5)) {
                return;
            }
            this.zzc.zza(sparseArray.valueAt(i4));
            sparseArray.removeAt(i4);
            int i6 = this.zza;
            if (i6 > 0) {
                this.zza = i6 - 1;
            }
            i4 = i5;
        }
    }

    public final void zze() {
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.zzb;
            if (i3 >= sparseArray.size()) {
                this.zza = -1;
                sparseArray.clear();
                return;
            } else {
                this.zzc.zza(sparseArray.valueAt(i3));
                i3++;
            }
        }
    }

    public final boolean zzf() {
        return this.zzb.size() == 0;
    }

    public zzzi(zzdt zzdtVar) {
        this.zzb = new SparseArray();
        this.zzc = zzdtVar;
        this.zza = -1;
    }
}
