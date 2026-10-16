package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzglc extends RuntimeException {
    public zzglc() {
        this(0);
    }

    public zzglc(int i3) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 3);
        sb.append("r: ");
        sb.append(i3);
        super(sb.toString());
    }

    public zzglc(int i3, Throwable th) {
        super("r: 2", th);
    }
}
