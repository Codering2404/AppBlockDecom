package com.google.android.libraries.places.internal;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcfd implements zzcfv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcfv f77738a;

    zzcfd(zzcfe zzcfeVar, zzcfv zzcfvVar) {
        this.f77738a = zzcfvVar;
    }

    @Override // com.google.android.libraries.places.internal.zzcfv
    public final long A2(zzcff sink, long j3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            return this.f77738a.A2(sink, j3);
        } catch (IOException e3) {
            throw e3;
        } finally {
            zzcfe.b();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcfv, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.f77738a.close();
            Unit unit = Unit.f139807a;
        } catch (IOException e3) {
            throw e3;
        } finally {
            zzcfe.b();
        }
    }

    public final String toString() {
        zzcfv zzcfvVar = this.f77738a;
        StringBuilder sb = new StringBuilder(zzcfvVar.toString().length() + 21);
        sb.append("AsyncTimeout.source(");
        sb.append(zzcfvVar);
        sb.append(")");
        return sb.toString();
    }
}
