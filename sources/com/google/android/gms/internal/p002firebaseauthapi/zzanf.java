package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzanf extends zzang {
    zzanf() {
        super();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzang
    public final void zza() {
        if (!zze()) {
            for (int i3 = 0; i3 < zzb(); i3++) {
                Map.Entry entryZza = zza(i3);
                if (((zzakz) entryZza.getKey()).zze()) {
                    entryZza.setValue(Collections.unmodifiableList((List) entryZza.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzakz) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
