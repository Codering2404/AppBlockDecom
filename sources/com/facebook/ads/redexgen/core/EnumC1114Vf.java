package com.facebook.ads.redexgen.core;

import com.facebook.ads.VideoAutoplayBehavior;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class EnumC1114Vf {
    public static byte[] A00;
    public static String[] A01 = {"t11qfTcdRX3vtzWg9o3D7yzOQIlsgekI", "6i20agDhmSdy9vSyuA65WoFMQBMnYQqu", "rdyvRl0mnrLy9iBwCAplKJJzDaMabc0M", "SOZt7VgRETJYcVg4", "xbstiP5KKiAzncux", "VTcuBCbEWMb14OGNQVtfuGUmCLIRmz1L", "NW0LuK6Vb9eH6jcO6lyYeFn7KSHSxynw", "5brGPIOfpSxIScBaveghLVMlb1271YeU"};
    public static final /* synthetic */ EnumC1114Vf[] A02;
    public static final EnumC1114Vf A03;
    public static final EnumC1114Vf A04;
    public static final EnumC1114Vf A05;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{88, 89, 90, 93, 73, 80, 72, 98, 107, 107, 2, 3};
    }

    static {
        A02();
        A03 = new EnumC1114Vf(A01(0, 7, 61), 0);
        A05 = new EnumC1114Vf(A01(10, 2, 108), 1);
        A04 = new EnumC1114Vf(A01(7, 3, 12), 2);
        A02 = A03();
    }

    public EnumC1114Vf(String str, int i3) {
    }

    public static VideoAutoplayBehavior A00(@Nullable EnumC1114Vf enumC1114Vf) {
        if (enumC1114Vf == null) {
            return VideoAutoplayBehavior.DEFAULT;
        }
        switch (enumC1114Vf.ordinal()) {
            case 0:
                VideoAutoplayBehavior videoAutoplayBehavior = VideoAutoplayBehavior.DEFAULT;
                if (A01[1].charAt(31) != 'u') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[2] = "tGhoRPzzdwkU9rBMhrkq51QPgJKMKCG7";
                strArr[7] = "oLzw2E9OShYSASB843fXRAiyIcSfpUGD";
                return videoAutoplayBehavior;
            case 1:
                return VideoAutoplayBehavior.ON;
            case 2:
                return VideoAutoplayBehavior.OFF;
            default:
                return VideoAutoplayBehavior.DEFAULT;
        }
    }

    public static /* synthetic */ EnumC1114Vf[] A03() {
        EnumC1114Vf[] enumC1114VfArr = new EnumC1114Vf[3];
        enumC1114VfArr[0] = A03;
        if (A01[5].charAt(31) != 'L') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "zoiTRupMudK7uDXw";
        strArr[4] = "VFYrxWbIb3tlnjHn";
        enumC1114VfArr[1] = A05;
        enumC1114VfArr[2] = A04;
        return enumC1114VfArr;
    }

    public static EnumC1114Vf valueOf(String str) {
        return (EnumC1114Vf) Enum.valueOf(EnumC1114Vf.class, str);
    }

    public static EnumC1114Vf[] values() {
        return (EnumC1114Vf[]) A02.clone();
    }
}
