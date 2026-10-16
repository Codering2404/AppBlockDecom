package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcn extends Exception {
    public zzcn(String str, zzcl zzclVar) {
        String strValueOf = String.valueOf(zzclVar);
        StringBuilder sb = new StringBuilder(str.length() + 1 + strValueOf.length());
        sb.append(str);
        sb.append(" ");
        sb.append(strValueOf);
        super(sb.toString());
    }
}
