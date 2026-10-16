package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Types {
    }

    public abstract int M();

    public final String toString() {
        long jZza = zza();
        int iM = M();
        String strZzc = zzc();
        int length = String.valueOf(jZza).length();
        StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(iM).length() + 3 + strZzc.length());
        sb.append(jZza);
        sb.append("\t");
        sb.append(iM);
        sb.append("\t-1");
        sb.append(strZzc);
        return sb.toString();
    }

    public abstract long zza();

    public abstract String zzc();
}
