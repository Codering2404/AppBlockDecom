package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.app.KeyguardManager;
import android.util.Log;
import android.view.Window;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class YW {
    public static byte[] A00;
    public static String[] A01 = {"cuUzkH3QdbH3cJp2RF", "kphHRdIOrc0r15jsPfyG2Jy", "YnKzEWoXtdzuP95TROGjIP", "O6qhnuon9ci7avdCdn", "JszjlqJauoZ2AkEe", "2iwMqZkAQKEhQz1BEXGjAw", "tv2fwm9vcfvUl0RC5d9GYW3eB7CSJdU", "VWHYkG5jfvcYH9oXKfgyVS7MLxk2p9iO"};
    public static final String A02;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[3].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "jOZxNa7dXP1jVDPJoO";
            strArr2[0] = "z9aGKGtKVlVAFuhw7X";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 48);
            i6++;
        }
    }

    public static void A02() {
        A00 = new byte[]{79, 119, 122, 71, 92, 90, 79, 75, 86, 80, 81, Ascii.US, 86, 81, Ascii.US, 72, 86, 81, 91, 80, 72, Ascii.US, 86, 81, 89, 80, Ascii.US, 92, 87, 90, 92, 84, 98, 108, 112, 110, 124, 104, 123, 109, 91, 87, 66, Ascii.SI, Ascii.DC4, Ascii.SO, Ascii.SYN, 4, 96, 113, 115, 124, 112, 117, 100, 113, 117, 110, 96, 99};
    }

    static {
        A02();
        A02 = YW.class.getSimpleName();
    }

    public static Map<String, String> A01(@Nullable C1648gi c1648gi) {
        Window window;
        HashMap map = new HashMap();
        if (c1648gi == null) {
            return map;
        }
        try {
            map.put(A00(40, 3, 0), String.valueOf(A04(c1648gi)));
            Activity activityA0E = c1648gi.A0E();
            if (activityA0E != null && (window = activityA0E.getWindow()) != null) {
                int i3 = window.getAttributes().flags;
                int flags = window.getAttributes().type;
                map.put(A00(58, 2, 39), Integer.toString(flags));
                int type = 4194304 & i3;
                String strA00 = A00(1, 1, 118);
                String flagDismissKeyguardEnabled = A00(0, 1, 79);
                map.put(A00(48, 5, 39), type > 0 ? strA00 : flagDismissKeyguardEnabled);
                int type2 = 524288 & i3;
                if (A01[6].length() == 6) {
                    throw new RuntimeException();
                }
                A01[7] = "5jjmsuOSeLdxH4ITovSaNkR7tPO8fpvx";
                if (type2 <= 0) {
                    strA00 = flagDismissKeyguardEnabled;
                }
                map.put(A00(53, 5, 50), strA00);
            }
        } catch (Exception e3) {
            Log.e(A02, A00(2, 30, 15), e3);
            InterfaceC1059Tc interfaceC1059TcA08 = c1648gi.A08();
            int type3 = AbstractC1060Td.A2T;
            interfaceC1059TcA08.ABC(A00(43, 5, 77), type3, new C1061Te(e3));
        }
        return map;
    }

    public static boolean A03(C1648gi c1648gi) {
        return !YC.A04(A01(c1648gi));
    }

    public static boolean A04(C1648gi c1648gi) {
        KeyguardManager keyguardManager = (KeyguardManager) c1648gi.getSystemService(A00(32, 8, 57));
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }
}
