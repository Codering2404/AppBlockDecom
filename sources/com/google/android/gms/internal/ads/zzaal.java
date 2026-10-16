package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaal extends zzbk {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private final SparseArray zzh;
    private final SparseBooleanArray zzi;

    public zzaal() {
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
    }

    final /* synthetic */ boolean zzA() {
        return this.zzb;
    }

    final /* synthetic */ boolean zzB() {
        return this.zzc;
    }

    final /* synthetic */ boolean zzC() {
        return this.zzd;
    }

    final /* synthetic */ boolean zzD() {
        return this.zze;
    }

    final /* synthetic */ boolean zzE() {
        return this.zzf;
    }

    final /* synthetic */ boolean zzF() {
        return this.zzg;
    }

    final /* synthetic */ SparseArray zzG() {
        return this.zzh;
    }

    final /* synthetic */ SparseBooleanArray zzH() {
        return this.zzi;
    }

    protected final zzaal zzx(zzbl zzblVar) {
        super.zza(zzblVar);
        return this;
    }

    public final zzaal zzy(int i3, boolean z2) {
        SparseBooleanArray sparseBooleanArray = this.zzi;
        if (sparseBooleanArray.get(i3) == z2) {
            return this;
        }
        if (z2) {
            sparseBooleanArray.put(i3, true);
            return this;
        }
        sparseBooleanArray.delete(i3);
        return this;
    }

    final /* synthetic */ boolean zzz() {
        return this.zza;
    }

    /* synthetic */ zzaal(zzaam zzaamVar, byte[] bArr) {
        super(zzaamVar);
        this.zza = zzaamVar.zzK;
        this.zzb = zzaamVar.zzM;
        this.zzc = zzaamVar.zzO;
        this.zzd = zzaamVar.zzT;
        this.zze = zzaamVar.zzU;
        this.zzf = zzaamVar.zzV;
        this.zzg = zzaamVar.zzX;
        SparseArray sparseArray = new SparseArray();
        int i3 = 0;
        while (true) {
            SparseArray sparseArrayZze = zzaamVar.zze();
            if (i3 < sparseArrayZze.size()) {
                sparseArray.put(sparseArrayZze.keyAt(i3), new HashMap((Map) sparseArrayZze.valueAt(i3)));
                i3++;
            } else {
                this.zzh = sparseArray;
                this.zzi = zzaamVar.zzf().clone();
                return;
            }
        }
    }
}
