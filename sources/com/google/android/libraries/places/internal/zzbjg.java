package com.google.android.libraries.places.internal;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbjg implements zzbji {
    @Override // com.google.android.libraries.places.internal.zzbjj
    public final OutputStream a(OutputStream outputStream) {
        return new GZIPOutputStream(outputStream);
    }

    @Override // com.google.android.libraries.places.internal.zzbjw
    public final InputStream b(InputStream inputStream) {
        return new GZIPInputStream(inputStream);
    }

    @Override // com.google.android.libraries.places.internal.zzbjj, com.google.android.libraries.places.internal.zzbjw
    public final String zza() {
        return "gzip";
    }
}
