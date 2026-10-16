package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzigj extends zzign {
    zzigj() {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzign
    public final void zza() {
        if (!zzb()) {
            for (int i3 = 0; i3 < zzc(); i3++) {
                Map.Entry entryZzd = zzd(i3);
                if (((zzids) ((zzigk) entryZzd).zza()).zzd()) {
                    entryZzd.setValue(Collections.unmodifiableList((List) entryZzd.getValue()));
                }
            }
            for (Map.Entry entry : zze()) {
                if (((zzids) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
