package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzsc extends Exception {
    public zzsc(long j3, long j4) {
        StringBuilder sb = new StringBuilder(String.valueOf(j4).length() + 63 + String.valueOf(j3).length());
        sb.append("Unexpected audio track timestamp discontinuity: expected ");
        sb.append(j4);
        sb.append(", got ");
        sb.append(j3);
        super(sb.toString());
    }
}
