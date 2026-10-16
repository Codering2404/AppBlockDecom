package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajw implements zzao {
    public final List zza;

    public zzajw(List list) {
        this.zza = list;
        boolean z2 = false;
        if (!list.isEmpty()) {
            long j3 = ((zzajv) list.get(0)).zzb;
            int i3 = 1;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                if (((zzajv) list.get(i3)).zza < j3) {
                    z2 = true;
                    break;
                } else {
                    j3 = ((zzajv) list.get(i3)).zzb;
                    i3++;
                }
            }
        }
        zzgtj.zza(!z2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzajw.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzajw) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=".concat(this.zza.toString());
    }
}
