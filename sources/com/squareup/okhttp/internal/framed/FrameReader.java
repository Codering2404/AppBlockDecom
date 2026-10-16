package com.squareup.okhttp.internal.framed;

import java.io.Closeable;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public interface FrameReader extends Closeable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Handler {
        void A(int i3, int i4, int i5, boolean z2);

        void B(boolean z2, Settings settings);

        void C(boolean z2, boolean z3, int i3, int i4, List list, HeadersMode headersMode);

        void D(int i3, ErrorCode errorCode, ByteString byteString);

        void e(int i3, long j3);

        void h(int i3, int i4, List list);

        void q(boolean z2, int i3, int i4);

        void x(int i3, ErrorCode errorCode);

        void y();

        void z(boolean z2, int i3, BufferedSource bufferedSource, int i4);
    }

    void N0();

    boolean y0(Handler handler);
}
