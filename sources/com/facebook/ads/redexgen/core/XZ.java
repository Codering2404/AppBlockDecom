package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class XZ implements InvocationHandler {
    public static byte[] A03;
    public final /* synthetic */ int A00;
    public final /* synthetic */ T8 A01;
    public final /* synthetic */ LinkedBlockingQueue A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{40, 42, Framer.ENTER_FRAME_PREFIX, 42, 61, 38, 44, 43, 41, 56, Ascii.US, 60, 32, 37, 56, 2, Framer.STDIN_FRAME_PREFIX, Framer.ENTER_FRAME_PREFIX, 41, 43, 41, 56, Ascii.CAN, 53, 60, 41, 73, 75, 90, Framer.EXIT_FRAME_PREFIX, 79, 66, 91, 75, Ascii.GS, Ascii.FS, Framer.STDOUT_FRAME_PREFIX, Ascii.SUB, Ascii.ETB, 17, Ascii.EM, 1, 7, Ascii.US, 1, 32, Ascii.ETB, 19, Ascii.SYN, Ascii.VT};
    }

    public XZ(int i3, LinkedBlockingQueue linkedBlockingQueue, T8 t8) {
        this.A00 = i3;
        this.A02 = linkedBlockingQueue;
        this.A01 = t8;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            if (method.getName().equals(A00(34, 16, 70)) && objArr.length == 1 && (objArr[0] instanceof List)) {
                for (Object c3 : (List) objArr[0]) {
                    String str = (String) c3.getClass().getMethod(A00(7, 12, 120), new Class[0]).invoke(c3, new Object[0]);
                    int iIntValue = ((Integer) c3.getClass().getMethod(A00(19, 7, 120), new Class[0]).invoke(c3, new Object[0])).intValue();
                    if (str == null && iIntValue == this.A00) {
                        byte[] value = (byte[]) c3.getClass().getMethod(A00(26, 8, 26), new Class[0]).invoke(c3, new Object[0]);
                        this.A02.put(value);
                        return null;
                    }
                }
                this.A02.put(null);
            }
        } catch (Throwable t2) {
            this.A01.A08().ABC(A00(0, 7, 123), AbstractC1060Td.A1G, new C1061Te(t2));
        }
        return null;
    }
}
