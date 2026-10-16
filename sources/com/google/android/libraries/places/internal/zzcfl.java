package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcfl {
    public static final zzcft a(Socket socket) throws IOException {
        int i3 = zzcfm.f77748a;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        zzcfu zzcfuVar = new zzcfu(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream(...)");
        zzcfn sink = new zzcfn(outputStream, zzcfuVar);
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new zzcfc(zzcfuVar, sink);
    }

    public static final zzcfv b(Socket socket) {
        int i3 = zzcfm.f77748a;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        zzcfu zzcfuVar = new zzcfu(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        zzcfk source = new zzcfk(inputStream, zzcfuVar);
        Intrinsics.checkNotNullParameter(source, "source");
        return new zzcfd(zzcfuVar, source);
    }

    public static final zzcfh c(zzcfv zzcfvVar) {
        Intrinsics.checkNotNullParameter(zzcfvVar, "<this>");
        return new zzcfp(zzcfvVar);
    }

    public static final zzcfg d(zzcft zzcftVar) {
        Intrinsics.checkNotNullParameter(zzcftVar, "<this>");
        return new zzcfo(zzcftVar);
    }
}
