package com.google.android.gms.internal.ads;

import androidx.legacy.content.Werj.QgXempTBEfV;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzsa extends Exception {
    public final boolean zza;

    public zzsa(int i3, int i4, int i5, int i6, int i7, zzv zzvVar, boolean z2, Exception exc) {
        String strValueOf = String.valueOf(zzvVar);
        int length = String.valueOf(i4).length();
        int length2 = String.valueOf(i5).length();
        int length3 = String.valueOf(i6).length();
        StringBuilder sb = new StringBuilder(length + 34 + length2 + 2 + length3 + 2 + String.valueOf(i7).length() + 2 + strValueOf.length());
        sb.append("AudioTrack init failed 0 Config(");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append(", ");
        sb.append(i6);
        sb.append(", ");
        sb.append(i7);
        sb.append(") ");
        sb.append(strValueOf);
        sb.append(QgXempTBEfV.NoviAigK);
        super(sb.toString(), exc);
        this.zza = false;
    }
}
