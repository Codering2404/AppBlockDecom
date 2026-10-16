package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaun extends zzimf implements Closeable {
    static {
        zzimm.zzb(zzaun.class);
    }

    public zzaun(zzimg zzimgVar, zzaum zzaumVar) throws IOException {
        zzd(zzimgVar, zzimgVar.zzb(), zzaumVar);
    }

    @Override // com.google.android.gms.internal.ads.zzimf
    public final String toString() {
        String string = this.zzc.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 7);
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzimf, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }
}
