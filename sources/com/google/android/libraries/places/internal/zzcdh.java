package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcdh implements zzcdl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f77663a = Logger.getLogger(zzcde.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcfj f77664b;

    static {
        zzcfj zzcfjVar = zzcfj.f77742d;
        f77664b = zzcfi.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    }

    static /* synthetic */ IllegalArgumentException c(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    static /* synthetic */ int e(int i3, byte b3, short s2) throws IOException {
        if ((b3 & 8) != 0) {
            i3--;
        }
        if (s2 <= i3) {
            return i3 - s2;
        }
        throw i("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s2), Integer.valueOf(i3));
    }

    static /* synthetic */ int f(zzcfh zzcfhVar) {
        return (zzcfhVar.zzj() & 255) | ((zzcfhVar.zzj() & 255) << 16) | ((zzcfhVar.zzj() & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IOException i(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(Locale.US, str, objArr));
    }

    @Override // com.google.android.libraries.places.internal.zzcdl
    public final zzccy a(zzcfg zzcfgVar, boolean z2) {
        return new zzcdg(zzcfgVar, true);
    }

    @Override // com.google.android.libraries.places.internal.zzcdl
    public final zzccx b(zzcfh zzcfhVar, boolean z2) {
        return new zzcdf(zzcfhVar, 4096, true);
    }
}
