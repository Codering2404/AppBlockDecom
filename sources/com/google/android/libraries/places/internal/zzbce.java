package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbce {
    static /* synthetic */ String b(int i3, int i4, byte b3, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + b3 + String.valueOf(i3).length());
        sb.append(str);
        sb.append(i4);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    public abstract void a(byte[] bArr, int i3, int i4);
}
