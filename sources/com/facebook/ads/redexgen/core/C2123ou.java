package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ou, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2123ou implements InterfaceC05317t {
    public static byte[] A05;
    public EP A00;
    public final int A01;
    public final long A02;
    public final Context A03;
    public final A6 A04;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 82);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-77, -44, -43, -48, -28, -37, -29, -63, -44, -35, -45, -44, -31, -44, -31, -30, -75, -48, -46, -29, -34, -31, -24, -95, -50, -50, -53, -50, 124, -59, -54, -49, -48, -67, -54, -48, -59, -67, -48, -59, -54, -61, 124, -94, -94, -55, -52, -63, -61, 124, -63, -44, -48, -63, -54, -49, -59, -53, -54, -70, -25, -25, -28, -25, -107, -34, -29, -24, -23, -42, -29, -23, -34, -42, -23, -34, -29, -36, -107, -69, -63, -74, -72, -107, -38, -19, -23, -38, -29, -24, -34, -28, -29, -12, Framer.ENTER_FRAME_PREFIX, Framer.ENTER_FRAME_PREFIX, Ascii.RS, Framer.ENTER_FRAME_PREFIX, -49, Ascii.CAN, Ascii.GS, 34, 35, Ascii.DLE, Ascii.GS, 35, Ascii.CAN, Ascii.DLE, 35, Ascii.CAN, Ascii.GS, Ascii.SYN, -49, -2, Ascii.US, 36, 34, -49, Ascii.DC4, 39, 35, Ascii.DC4, Ascii.GS, 34, Ascii.CAN, Ascii.RS, Ascii.GS, 6, 51, 51, 48, 51, -31, 42, 47, 52, 53, 34, 47, 53, 42, 34, 53, 42, 47, 40, -31, Ascii.ETB, 17, -6, -31, 38, 57, 53, 38, 47, 52, 42, 48, 47, Ascii.DLE, 51, 37, 40, 41, 40, -28, 10, 42, Framer.STDOUT_FRAME_PREFIX, 52, 41, 43, 5, 57, 40, Framer.STDIN_FRAME_PREFIX, 51, Ascii.SYN, 41, Framer.STDERR_FRAME_PREFIX, 40, 41, 54, 41, 54, -14, Ascii.SO, Framer.STDOUT_FRAME_PREFIX, 35, 38, 39, 38, -30, Ascii.SO, 43, 36, 40, 46, 35, 37, 3, 55, 38, 43, Framer.STDOUT_FRAME_PREFIX, Ascii.DC4, 39, 48, 38, 39, 52, 39, 52, -16, 6, 41, Ascii.ESC, Ascii.RS, Ascii.US, Ascii.RS, -38, 6, 35, Ascii.FS, 41, 42, 47, Framer.STDIN_FRAME_PREFIX, -5, 47, Ascii.RS, 35, 41, Ascii.FF, Ascii.US, 40, Ascii.RS, Ascii.US, 44, Ascii.US, 44, -24, 4, 39, Ascii.EM, Ascii.FS, Ascii.GS, Ascii.FS, -40, 4, Framer.ENTER_FRAME_PREFIX, Ascii.SUB, 46, 40, 48, Ascii.SO, Framer.ENTER_FRAME_PREFIX, Ascii.FS, Ascii.GS, 39, 10, Ascii.GS, 38, Ascii.FS, Ascii.GS, 42, Ascii.GS, 42, -26, -7, 5, 3, -60, -4, -9, -7, -5, -8, 5, 5, 1, -60, -9, -6, 9, -60, -9, 4, -6, 8, 5, -1, -6, Ascii.SO, -60, 3, -5, -6, -1, -9, -55, -60, -5, Ascii.SO, 5, 6, 2, -9, Ascii.SI, -5, 8, -60, -5, Ascii.SO, 10, -60, -4, -4, 3, 6, -5, -3, -60, -36, -4, 3, 6, -5, -3, -41, Ascii.VT, -6, -1, 5, -24, -5, 4, -6, -5, 8, -5, 8, Ascii.ESC, 39, 37, -26, Ascii.RS, Ascii.EM, Ascii.ESC, Ascii.GS, Ascii.SUB, 39, 39, 35, -26, Ascii.EM, Ascii.FS, 43, -26, Ascii.EM, 38, Ascii.FS, 42, 39, Framer.ENTER_FRAME_PREFIX, Ascii.FS, 48, -26, 37, Ascii.GS, Ascii.FS, Framer.ENTER_FRAME_PREFIX, Ascii.EM, -21, -26, Ascii.GS, 48, 39, 40, 36, Ascii.EM, Framer.STDOUT_FRAME_PREFIX, Ascii.GS, 42, -26, Ascii.GS, 48, 44, -26, Ascii.RS, 36, Ascii.EM, Ascii.ESC, -26, 4, Framer.ENTER_FRAME_PREFIX, Ascii.SUB, Ascii.RS, 36, Ascii.EM, Ascii.ESC, -7, Framer.STDIN_FRAME_PREFIX, Ascii.FS, Framer.ENTER_FRAME_PREFIX, 39, 10, Ascii.GS, 38, Ascii.FS, Ascii.GS, 42, Ascii.GS, 42, -56, -44, -46, -109, -53, -58, -56, -54, -57, -44, -44, -48, -109, -58, -55, -40, -109, -58, -45, -55, -41, -44, -50, -55, -35, -109, -46, -54, -55, -50, -58, -104, -109, -54, -35, -44, -43, -47, -58, -34, -54, -41, -109, -54, -35, -39, -109, -44, -43, -38, -40, -109, -79, -50, -57, -44, -43, -38, -40, -90, -38, -55, -50, -44, -73, -54, -45, -55, -54, -41, -54, -41, 35, 47, Framer.STDIN_FRAME_PREFIX, -18, 38, Framer.ENTER_FRAME_PREFIX, 35, 37, 34, 47, 47, 43, -18, Framer.ENTER_FRAME_PREFIX, 36, 51, -18, Framer.ENTER_FRAME_PREFIX, 46, 36, Framer.STDERR_FRAME_PREFIX, 47, 41, 36, 56, -18, Framer.STDIN_FRAME_PREFIX, 37, 36, 41, Framer.ENTER_FRAME_PREFIX, -13, -18, 37, 56, 47, 48, 44, Framer.ENTER_FRAME_PREFIX, 57, 37, Framer.STDERR_FRAME_PREFIX, -18, 37, 56, 52, -18, 54, 48, -7, -18, Ascii.FF, 41, 34, 54, 48, 56, Ascii.SYN, 41, 36, 37, 47, Ascii.DC2, 37, 46, 36, 37, Framer.STDERR_FRAME_PREFIX, 37, Framer.STDERR_FRAME_PREFIX};
    }

    public C2123ou(Context context) {
        this(context, 0);
    }

    public C2123ou(Context context, int i3) {
        this(context, null, i3, 5000L);
    }

    @Deprecated
    public C2123ou(Context context, A6 a6, int i3, long j3) {
        this.A00 = new C2124ov(this);
        this.A03 = context;
        this.A01 = i3;
        this.A02 = j3;
        this.A04 = a6;
    }

    private final void A02(Context context, A6 a6, long j3, Handler handler, GQ gq, int extensionRendererIndex, ArrayList<InterfaceC2117oo> arrayList) throws Exception {
        Class<?> cls;
        Class<?> clazz;
        Class<?> clazz2;
        Class<?> clazz3;
        arrayList.add(new AnonymousClass10(context, C1804jQ.A0T, new MediaCodecRendererMetaParameters(null, false), BT.A00, j3, a6, false, false, handler, gq, 50, 5, 0, 0, 0));
        if (extensionRendererIndex == 0) {
            return;
        }
        int size = arrayList.size();
        if (extensionRendererIndex == 2) {
            size--;
        }
        try {
            try {
                cls = Class.forName(A00(487, 70, 110));
                clazz = Boolean.TYPE;
                clazz2 = Long.TYPE;
                clazz3 = Integer.TYPE;
            } catch (Exception e3) {
                e = e3;
            }
            try {
                arrayList.add(size, (InterfaceC2117oo) cls.getConstructor(clazz, clazz2, Handler.class, GQ.class, clazz3, clazz3).newInstance(true, Long.valueOf(j3), handler, gq, 50, 5));
                Log.i(A00(0, 23, 29), A00(243, 27, 102));
            } catch (Exception e4) {
                e = e4;
                throw new RuntimeException(A00(127, 33, 111), e);
            }
        } catch (ClassNotFoundException unused) {
        }
    }

    private final void A03(Context context, A6 a6, InterfaceC04183k[] interfaceC04183kArr, Handler handler, InterfaceC05528p interfaceC05528p, int extensionRendererIndex, ArrayList<InterfaceC2117oo> arrayList) throws Exception {
        int extensionRendererIndex2;
        int extensionRendererIndex3;
        Constructor<?> constructor;
        Constructor<?> constructor2;
        String strA00 = A00(0, 23, 29);
        arrayList.add(new AnonymousClass12(context, C1804jQ.A0T, new MediaCodecRendererMetaParameters(null, false), BT.A00, a6, false, false, false, handler, interfaceC05528p, C8R.A02(context), interfaceC04183kArr));
        if (extensionRendererIndex == 0) {
            return;
        }
        int size = arrayList.size();
        if (extensionRendererIndex == 2) {
            size--;
        }
        try {
            extensionRendererIndex2 = size + 1;
            try {
                arrayList.add(size, (InterfaceC2117oo) Class.forName(A00(415, 72, 19)).getConstructor(Handler.class, InterfaceC05528p.class, InterfaceC04183k[].class).newInstance(handler, interfaceC05528p, interfaceC04183kArr));
                Log.i(strA00, A00(215, 28, 104));
            } catch (ClassNotFoundException unused) {
                size = extensionRendererIndex2;
                extensionRendererIndex2 = size;
            } catch (Exception e3) {
                e = e3;
                throw new RuntimeException(A00(93, 34, 93), e);
            }
        } catch (ClassNotFoundException unused2) {
        } catch (Exception e4) {
            e = e4;
        }
        try {
            constructor2 = Class.forName(A00(343, 72, 102)).getConstructor(Handler.class, InterfaceC05528p.class, InterfaceC04183k[].class);
            extensionRendererIndex3 = extensionRendererIndex2 + 1;
        } catch (ClassNotFoundException unused3) {
        } catch (Exception e5) {
            e = e5;
        }
        try {
            arrayList.add(extensionRendererIndex2, (InterfaceC2117oo) constructor2.newInstance(handler, interfaceC05528p, interfaceC04183kArr));
            Log.i(strA00, A00(187, 28, 112));
        } catch (ClassNotFoundException unused4) {
            extensionRendererIndex2 = extensionRendererIndex3;
            extensionRendererIndex3 = extensionRendererIndex2;
        } catch (Exception e6) {
            e = e6;
            throw new RuntimeException(A00(59, 34, 35), e);
        }
        try {
            try {
                constructor = Class.forName(A00(270, 73, 68)).getConstructor(Handler.class, InterfaceC05528p.class, InterfaceC04183k[].class);
            } catch (Exception e7) {
                e = e7;
            }
            try {
                arrayList.add(extensionRendererIndex3, (InterfaceC2117oo) constructor.newInstance(handler, interfaceC05528p, interfaceC04183kArr));
                Log.i(strA00, A00(160, 27, 114));
            } catch (Exception e8) {
                e = e8;
                throw new RuntimeException(A00(23, 36, 10), e);
            }
        } catch (ClassNotFoundException unused5) {
        }
    }

    private final void A04(Context context, InterfaceC0605Bf interfaceC0605Bf, Looper looper, int i3, ArrayList<InterfaceC2117oo> arrayList) {
        arrayList.add(new C03651f(interfaceC0605Bf, looper));
    }

    private final void A05(Context context, ES es, Looper looper, int i3, ArrayList<InterfaceC2117oo> arrayList) {
        arrayList.add(new C03611b(es, looper, this.A00));
    }

    private final InterfaceC04183k[] A06() {
        return new InterfaceC04183k[0];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05317t
    public final InterfaceC2117oo[] A5Y(Handler handler, GQ gq, InterfaceC05528p interfaceC05528p, ES es, InterfaceC0605Bf interfaceC0605Bf, A6 a6) throws Exception {
        A6 a62 = a6;
        if (a62 == null) {
            a62 = this.A04;
        }
        ArrayList<InterfaceC2117oo> arrayList = new ArrayList<>();
        A02(this.A03, a62, this.A02, handler, gq, this.A01, arrayList);
        A03(this.A03, a62, A06(), handler, interfaceC05528p, this.A01, arrayList);
        A05(this.A03, es, handler.getLooper(), this.A01, arrayList);
        A04(this.A03, interfaceC0605Bf, handler.getLooper(), this.A01, arrayList);
        return (InterfaceC2117oo[]) arrayList.toArray(new InterfaceC2117oo[arrayList.size()]);
    }
}
