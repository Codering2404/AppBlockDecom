package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzatv {
    protected static final Comparator zza = new zzatu();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList(64);
    private int zzd = 0;

    public zzatv(int i3) {
    }

    private final synchronized void zzc() {
        while (this.zzd > 4096) {
            byte[] bArr = (byte[]) this.zzb.remove(0);
            this.zzc.remove(bArr);
            this.zzd -= bArr.length;
        }
    }

    public final synchronized byte[] zza(int i3) {
        int i4 = 0;
        while (true) {
            List list = this.zzc;
            if (i4 >= list.size()) {
                return new byte[i3];
            }
            byte[] bArr = (byte[]) list.get(i4);
            int length = bArr.length;
            if (length >= i3) {
                this.zzd -= length;
                list.remove(i4);
                this.zzb.remove(bArr);
                return bArr;
            }
            i4++;
        }
    }

    public final synchronized void zzb(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            if (length <= 4096) {
                this.zzb.add(bArr);
                List list = this.zzc;
                int iBinarySearch = Collections.binarySearch(list, bArr, zza);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                list.add(iBinarySearch, bArr);
                this.zzd += length;
                zzc();
            }
        }
    }
}
