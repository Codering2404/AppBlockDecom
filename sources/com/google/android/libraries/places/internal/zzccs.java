package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzccs {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f77592a;

    zzccs(String str) {
        this.f77592a = str;
    }

    public static zzccs a(String str) throws IOException {
        zzccs zzccsVar = HTTP_1_0;
        if (str.equals(zzccsVar.f77592a)) {
            return zzccsVar;
        }
        zzccs zzccsVar2 = HTTP_1_1;
        if (str.equals(zzccsVar2.f77592a)) {
            return zzccsVar2;
        }
        zzccs zzccsVar3 = HTTP_2;
        if (str.equals(zzccsVar3.f77592a)) {
            return zzccsVar3;
        }
        zzccs zzccsVar4 = SPDY_3;
        if (str.equals(zzccsVar4.f77592a)) {
            return zzccsVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f77592a;
    }
}
