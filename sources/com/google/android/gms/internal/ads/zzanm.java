package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzanm implements zzagb {
    private final zzagb zzb;
    private final zzanj zzc;
    private final SparseArray zzd = new SparseArray();
    private boolean zze;

    public zzanm(zzagb zzagbVar, zzanj zzanjVar) {
        this.zzb = zzagbVar;
        this.zzc = zzanjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final zzahk zzu(int i3, int i4) {
        if (i4 != 3 && i4 != 5) {
            this.zze = true;
        }
        if (i4 != 3) {
            return this.zzb.zzu(i3, i4);
        }
        SparseArray sparseArray = this.zzd;
        zzano zzanoVar = (zzano) sparseArray.get(i3);
        if (zzanoVar != null) {
            return zzanoVar;
        }
        zzano zzanoVar2 = new zzano(this.zzb.zzu(i3, 3), this.zzc);
        sparseArray.put(i3, zzanoVar2);
        return zzanoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void zzv() {
        this.zzb.zzv();
        if (!this.zze) {
            return;
        }
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.zzd;
            if (i3 >= sparseArray.size()) {
                return;
            }
            ((zzano) sparseArray.valueAt(i3)).zzf(true);
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void zzw(zzahb zzahbVar) {
        this.zzb.zzw(zzahbVar);
    }
}
