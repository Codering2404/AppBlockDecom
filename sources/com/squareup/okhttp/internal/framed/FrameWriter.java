package com.squareup.okhttp.internal.framed;

import java.io.Closeable;
import java.util.List;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public interface FrameWriter extends Closeable {
    void E2(Settings settings);

    void Y(int i3, ErrorCode errorCode, byte[] bArr);

    void d0();

    void d2(Settings settings);

    void e(int i3, long j3);

    int f1();

    void flush();

    void h(int i3, int i4, List list);

    void k0(boolean z2, int i3, Buffer buffer, int i4);

    void q(boolean z2, int i3, int i4);

    void x(int i3, ErrorCode errorCode);

    void y2(boolean z2, boolean z3, int i3, int i4, List list);
}
