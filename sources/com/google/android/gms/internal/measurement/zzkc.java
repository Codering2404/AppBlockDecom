package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkc extends zzkm {
    zzkc(zzkg zzkgVar, String str, Long l3, boolean z2) {
        super(zzkgVar, str, l3, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String str = this.zzb;
        String string = obj.toString();
        StringBuilder sb = new StringBuilder(str.length() + 25 + string.length());
        sb.append("Invalid long value for ");
        sb.append(str);
        sb.append(": ");
        sb.append(string);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
