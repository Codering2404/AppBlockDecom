package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzoz extends zzpe {
    zzoz() {
        super(null);
    }

    @Override // com.google.android.recaptcha.internal.zzpe
    public final void zza() {
        if (!zzj()) {
            for (int i3 = 0; i3 < zzc(); i3++) {
                ((zzms) ((zzpa) zzg(i3)).zza()).zzg();
            }
            Iterator it = zzd().iterator();
            while (it.hasNext()) {
                ((zzms) ((Map.Entry) it.next()).getKey()).zzg();
            }
        }
        super.zza();
    }
}
