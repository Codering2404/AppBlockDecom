package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzihe extends Exception {
    zzihe(int i3, int i4) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 32 + String.valueOf(i4).length());
        sb.append("Unpaired surrogate at index ");
        sb.append(i3);
        sb.append(" of ");
        sb.append(i4);
        super(sb.toString());
    }
}
