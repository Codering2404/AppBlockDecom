package com.applovin.impl;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f58131a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f58132b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f58133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f58134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f58135c;

        private b(int i3, int i4, String str) {
            this.f58133a = i3;
            this.f58134b = i4;
            this.f58135c = str;
        }
    }

    public static byte[] a(int i3, int i4, int i5) {
        return new byte[]{(byte) (((i3 << 3) & 248) | ((i4 >> 1) & 7)), (byte) (((i4 << 7) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) | ((i5 << 3) & 120))};
    }

    private static int b(zg zgVar) throws ch {
        int iA = zgVar.a(4);
        if (iA == 15) {
            return zgVar.a(24);
        }
        if (iA < 13) {
            return f58131a[iA];
        }
        throw ch.a(null, null);
    }

    private static int a(zg zgVar) {
        int iA = zgVar.a(5);
        return iA == 31 ? zgVar.a(6) + 32 : iA;
    }

    public static b a(zg zgVar, boolean z2) throws ch {
        int iA = a(zgVar);
        int iB = b(zgVar);
        int iA2 = zgVar.a(4);
        String str = "mp4a.40." + iA;
        if (iA == 5 || iA == 29) {
            iB = b(zgVar);
            iA = a(zgVar);
            if (iA == 22) {
                iA2 = zgVar.a(4);
            }
        }
        if (z2) {
            if (iA != 6 && iA != 7 && iA != 17 && iA != 1 && iA != 2 && iA != 3 && iA != 4) {
                switch (iA) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ch.a("Unsupported audio object type: " + iA);
                }
            }
            a(zgVar, iA, iA2);
            switch (iA) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iA3 = zgVar.a(2);
                    if (iA3 == 2 || iA3 == 3) {
                        throw ch.a("Unsupported epConfig: " + iA3);
                    }
                    break;
            }
        }
        int i3 = f58132b[iA2];
        if (i3 != -1) {
            return new b(iB, i3, str);
        }
        throw ch.a(null, null);
    }

    private static void a(zg zgVar, int i3, int i4) {
        if (zgVar.f()) {
            oc.d("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (zgVar.f()) {
            zgVar.d(14);
        }
        boolean zF = zgVar.f();
        if (i4 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i3 == 6 || i3 == 20) {
            zgVar.d(3);
        }
        if (zF) {
            if (i3 == 22) {
                zgVar.d(16);
            }
            if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                zgVar.d(3);
            }
            zgVar.d(1);
        }
    }

    public static b a(byte[] bArr) {
        return a(new zg(bArr), false);
    }
}
