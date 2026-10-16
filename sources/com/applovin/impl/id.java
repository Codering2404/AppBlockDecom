package com.applovin.impl;

import android.media.MediaCodec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class id extends n5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jd f60437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f60438b;

    public id(Throwable th, jd jdVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Decoder failed: ");
        sb.append(jdVar == null ? null : jdVar.f60691a);
        super(sb.toString(), th);
        this.f60437a = jdVar;
        this.f60438b = xp.f65027a >= 21 ? a(th) : null;
    }

    private static String a(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
