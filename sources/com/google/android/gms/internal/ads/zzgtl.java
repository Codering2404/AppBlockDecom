package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgtl implements Serializable, zzgtk {
    private final List zza;

    public final boolean equals(Object obj) {
        if (obj instanceof zzgtl) {
            return this.zza.equals(((zzgtl) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append("and(");
        boolean z2 = true;
        for (Object obj : this.zza) {
            if (!z2) {
                sb.append(',');
            }
            sb.append(obj);
            z2 = false;
        }
        sb.append(')');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    public final boolean zza(Object obj) {
        int i3 = 0;
        while (true) {
            List list = this.zza;
            if (i3 >= list.size()) {
                return true;
            }
            if (!((zzgtk) list.get(i3)).zza(obj)) {
                return false;
            }
            i3++;
        }
    }
}
