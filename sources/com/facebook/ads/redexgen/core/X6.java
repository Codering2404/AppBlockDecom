package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class X6 {
    public static byte[] A00;
    public static String[] A01 = {"T4dPy6oALRnRtXie0LYtNa7PXoaz5xNV", "GuB", "", "N5ZcwGbFLOfjQt8i7LOYdNhhAY9bfZ8J", "XGEF2r9HzP4eyBZiq0puzcaX55o", "r68Pu4BAqG0jUrZ19Ek7iVXcY822rh1q", "w97ZnD7u", "Y1Vl"};

    public static String A07(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A00 = new byte[]{77, 66, 83, 74, 78, 56, 77, 83, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 79, 89, 94, 73, 83, 88, 67, 71, 73, 66, 84, 91, 74, 82, 69, 70, 74, 84, 81, 74, 86, 90, 91, 65, 80, 91, 65, 85, 87, 90, 90, 83, 68, 73, 82, 89, 91, 87, Framer.STDIN_REQUEST_FRAME_PREFIX, 88, 88, 122, 117, 60, 111, 59, 104, 111, 122, 105, 111, 59, 90, 110, Ascii.DEL, 114, 126, 117, Framer.EXIT_FRAME_PREFIX, 126, 85, 126, 111, 108, 116, 105, 112, 90, Framer.EXIT_FRAME_PREFIX, 111, 114, 109, 114, 111, 98, 53, 59, 86, 122, 112, 126, 59, 104, 110, 105, 126, 59, 111, 115, 122, 111, 59, 114, 111, 60, 104, 59, 114, 117, 59, 98, 116, 110, 105, 59, 90, 117, Ascii.DEL, 105, 116, 114, Ascii.DEL, 86, 122, 117, 114, 125, 126, 104, 111, 53, 99, 118, 119, 59, 125, 114, 119, 126, 53, Ascii.FS, 1, Ascii.CR, Ascii.VT, Ascii.CAN, 6, Ascii.FF, Ascii.VT, Ascii.NAK, Ascii.NAK, 17, Ascii.DC2, 38, 55, 58, 54, 61, 48, 54, Ascii.GS, 54, 39, 36, 60, Framer.ENTER_FRAME_PREFIX, 56, Ascii.SUB, 104, 64, 79, 126, 64, 66, 85, 72, 87, 72, 85, 88, 41, 38, 44, 58, 39, Framer.ENTER_FRAME_PREFIX, 44, 36, 43, Framer.ENTER_FRAME_PREFIX, 55, 42, 44, Framer.ENTER_FRAME_PREFIX, 107, 44, 43, Framer.STDOUT_FRAME_PREFIX, 32, 43, Framer.STDOUT_FRAME_PREFIX, 107, 36, 38, Framer.STDOUT_FRAME_PREFIX, 44, 42, 43, 107, 19, Ascii.FF, 0, Ascii.DC2, 58, 53, 63, 41, 52, Framer.STDERR_FRAME_PREFIX, 63, 117, Framer.STDERR_FRAME_PREFIX, 53, 47, 62, 53, 47, 117, 56, 58, 47, 62, 60, 52, 41, 34, 117, Ascii.EM, 9, Ascii.DC4, Ascii.FF, 8, Ascii.SUB, Ascii.EM, Ascii.ETB, Ascii.RS, 112, 125, 125, 126, 70, 86, 75, 83, 87, 65, 86, 113, 118, 104, Framer.STDERR_FRAME_PREFIX, 48, 61, 61, 52, 35, Ascii.CAN, 53, Ascii.DC4, Ascii.SYN, Ascii.ESC, Ascii.ESC, Ascii.DC2, 5, 35, Ascii.SO, 7, Ascii.DC2, 54, 57, 60, 48, 59, Framer.ENTER_FRAME_PREFIX, 1, 58, 62, 48, 59, 113, 125, Ascii.DEL, 60, 115, 124, 118, 96, 125, 123, 118, 60, 112, 96, 125, 101, 97, 119, 96, 60, 115, 98, 98, 126, 123, 113, 115, 102, 123, 125, 124, 77, 123, 118, Ascii.SI, 3, 1, 66, Ascii.CR, 2, 8, Ascii.RS, 3, 5, 8, 66, Ascii.SUB, 9, 2, 8, 5, 2, Ascii.VT, 103, 107, 105, 42, 98, 101, 103, 97, 102, 107, 107, 111, 42, 99, 107, 107, 99, 104, 97, 116, 104, 101, 125, 119, 112, 107, 118, 97, 101, 106, 42, 67, 107, 107, 99, 104, 97, 84, 104, 101, 125, 87, 112, 107, 118, 97, 69, 74, 75, 114, 97, 118, 104, 101, 125, 65, 124, 112, 97, 118, 106, 101, 104, 69, 103, 112, 109, 114, 109, 112, 125, 109, 97, 99, 32, 104, 111, 109, 107, 108, 97, 97, 101, 32, 101, 111, 122, 111, 96, 111, 66, 78, 79, 71, 72, 70, 126, 82, 84, 81, 81, 78, 83, 85, 82, 108, 84, 77, 85, 72, 118, 72, 79, 69, 78, 86, 3, Ascii.SI, Ascii.SO, 6, 9, 7, 63, 19, Ascii.NAK, Ascii.DLE, Ascii.DLE, Ascii.SI, Ascii.DC2, Ascii.DC4, 19, 51, Ascii.DLE, Ascii.FF, 9, Ascii.DC4, 51, 3, Ascii.DC2, 5, 5, Ascii.SO, Framer.STDIN_FRAME_PREFIX, Ascii.NAK, Ascii.FF, Ascii.DC4, 9, 55, 9, Ascii.SO, 4, Ascii.SI, Ascii.ETB, 5, Ascii.DC4, 3, 7, Ascii.DC2, 3, 57, 8, 3, 17, 57, Ascii.DC2, 7, 4, 75, 79, 4, Ascii.VT, Ascii.SO, Ascii.SYN, 7, Ascii.DLE, 7, 6, 61, 1, Ascii.SO, Ascii.VT, 1, 9, 61, 6, 7, Ascii.SO, 3, Ascii.ESC, 61, Ascii.SI, 17, 39, 46, Framer.ENTER_FRAME_PREFIX, 43, 35, 42, 61, Ascii.ESC, 38, 34, 42, Ascii.ETB, Ascii.VT, Ascii.VT, Ascii.SI, 36, 56, 56, 60, 118, 99, 99, 60, 32, Framer.STDIN_FRAME_PREFIX, 53, 98, 43, 35, 35, 43, 32, 41, 98, 47, 35, Framer.ENTER_FRAME_PREFIX, 99, 63, 56, 35, 62, 41, 99, Framer.STDIN_FRAME_PREFIX, 60, 60, 63, 99, 38, 58, 58, 62, 61, 82, 78, 78, 74, 73, 0, Ascii.NAK, Ascii.NAK, 74, 86, 91, 67, Ascii.DC4, 93, 85, 85, 93, 86, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.DC4, 89, 85, 87, Ascii.NAK, 94, 5, Ascii.CAN, Ascii.NAK, 64, 71, 90, 93, 72, 71, 93, 118, 78, 72, 68, 76, 90, 61, 39, Ascii.VT, 55, 53, 55, Ascii.VT, Framer.STDERR_FRAME_PREFIX, 61, 56, 32, Framer.STDOUT_FRAME_PREFIX, 38, Ascii.VT, 55, 56, 61, 55, 63, 39, Ascii.VT, 59, 58, Ascii.VT, 55, 32, 53, Ascii.CR, Ascii.ETB, 59, 7, Ascii.SYN, 1, 5, Ascii.DLE, Ascii.CR, Ascii.DC2, 1, 59, 5, Ascii.ETB, 59, 7, Ascii.DLE, 5, 59, Ascii.DC2, 86, 110, 116, 88, 113, 53, 88, 99, 98, 116, 110, 96, 105, 87, 91, 72, 81, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, 38, 63, 44, 59, 37, 40, 48, 55, 43, 38, 62, 105, 32, 40, 40, 32, 43, 34, 105, 36, 40, 42, 36, 51, 37, 63, 44, 51, Ascii.ESC, 57, Framer.STDERR_FRAME_PREFIX, 51, 66, 89, 94, 70, 66, 82, 126, 83, 125, 98, 110, 124, Framer.STDIN_REQUEST_FRAME_PREFIX, 114, 123, 110};
    }

    static {
        A09();
    }

    private int A00(C1648gi c1648gi) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = c1648gi.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(A07(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, 19, 65), 0)) != null && !TextUtils.isEmpty(packageInfo.versionName)) {
                return Integer.parseInt(packageInfo.versionName.split(A07(166, 2, 9), 2)[0]);
            }
            return -1;
        } catch (PackageManager.NameNotFoundException | NumberFormatException unused) {
            return -1;
        }
    }

    public static Intent A01(Uri uri) {
        Intent intent = new Intent(A07(186, 26, 10), uri);
        intent.setComponent(null);
        intent.setSelector(null);
        return intent;
    }

    public static Intent A02(C1648gi c1648gi, Uri uri) {
        Intent intentA01 = A01(uri);
        intentA01.addCategory(A07(212, 33, 20));
        intentA01.addFlags(268435456);
        intentA01.putExtra(A07(288, 34, 93), c1648gi.getPackageName());
        intentA01.putExtra(A07(494, 14, 41), false);
        if (C1098Up.A24(c1648gi)) {
            if (A07(508, 2, 98).equals(uri.getScheme())) {
                intentA01.setPackage(A07(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, 19, 65));
            }
        }
        return intentA01;
    }

    public static Intent A03(C1648gi c1648gi, Uri uri) {
        Intent intentA01 = A01(uri);
        intentA01.setPackage(A07(322, 19, 35));
        intentA01.putExtra(A07(259, 8, 30), c1648gi.getPackageName());
        intentA01.putExtra(A07(694, 7, 6), true);
        return intentA01;
    }

    public static Uri A04(C1648gi c1648gi, Uri uri) {
        boolean zEquals = A07(688, 6, 117).equals(uri.getScheme());
        String strA07 = A07(587, 26, 117);
        if (zEquals) {
            return XB.A00(strA07 + uri.getEncodedQuery());
        }
        if (uri.toString().startsWith(strA07)) {
            return uri;
        }
        c1648gi.A0F().ABH(5);
        return null;
    }

    private final EnumC0897Mq A05(C1648gi c1648gi, Uri uri, String str, Map<String, String> map) throws C1150Ws {
        boolean zA05 = AbstractC1099Uq.A05(c1648gi);
        boolean isInAppBrowserEnabled = A0F(uri);
        if (isInAppBrowserEnabled && zA05) {
            A0C(c1648gi, uri, str, map);
            EnumC0897Mq enumC0897Mq = EnumC0897Mq.A08;
            if (A01[7].length() == 30) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "";
            strArr[1] = "Q7p";
            return enumC0897Mq;
        }
        c1648gi.A0F().A9x(zA05);
        A0A(c1648gi, uri);
        return EnumC0897Mq.A07;
    }

    public static EnumC0897Mq A06(X6 x6, C1648gi c1648gi, Uri uri, String str, Map<String, String> extraData) throws C1150Ws {
        boolean z2 = A0F(uri) && A07(701, 15, 8).equals(uri.getHost());
        boolean isGooglePlayWebLink = A07(688, 6, 117).equals(uri.getScheme());
        if (!isGooglePlayWebLink && !z2) {
            return x6.A05(c1648gi, uri, str, extraData);
        }
        try {
            x6.A0B(c1648gi, uri, str);
            return EnumC0897Mq.A03;
        } catch (X4 unused) {
            return x6.A05(c1648gi, uri, str, extraData);
        }
    }

    private String A08(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    private void A0A(C1648gi c1648gi, Uri uri) throws C1150Ws {
        C1152Wu.A0D(c1648gi, A02(c1648gi, uri));
    }

    private final void A0B(C1648gi c1648gi, Uri uri, String str) throws C1150Ws, X4 {
        if (A0H(c1648gi)) {
            if (C1098Up.A1I(c1648gi)) {
                String queryParameter = uri.getQueryParameter(A07(613, 2, 62));
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (A01[3].charAt(29) != 'Z') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[4] = "AXwrjbGi2NqoDqohSkmHlyhQGK6";
                    strArr[6] = "xSKC0PNk";
                    String strA07 = A07(615, 13, 102);
                    String packageName = uri.toString();
                    AbstractC0932Oa.A03(queryParameter, strA07, packageName);
                }
            }
            boolean z2 = (c1648gi.A0H().A01() && C1098Up.A1g(c1648gi)) || (C1098Up.A25(c1648gi) && A0I(c1648gi));
            if (!z2) {
                boolean shouldTryToOpenSplitScreen = C1098Up.A2S(c1648gi);
                if (shouldTryToOpenSplitScreen) {
                    boolean shouldTryToOpenSplitScreen2 = C1152Wu.A0E(c1648gi, A03(c1648gi, uri));
                    if (shouldTryToOpenSplitScreen2) {
                        return;
                    }
                }
            }
            boolean zA0M = A0M(c1648gi, uri, str);
            if (A01[3].charAt(29) != 'Z') {
                A01[7] = "w5Gj6271lmeoEbiTTMEsWTdaWp";
                if (zA0M) {
                    return;
                }
            } else {
                A01[3] = "TMuIQjN9vpUXBqY7VYY4Z8DVMg5lcZnK";
                if (zA0M) {
                    return;
                }
            }
            boolean shouldTryToOpenSplitScreen3 = A0K(c1648gi, uri);
            if (shouldTryToOpenSplitScreen3) {
                return;
            }
            Intent intentA02 = A02(c1648gi, uri);
            intentA02.setPackage(A07(322, 19, 35));
            if (Build.VERSION.SDK_INT >= 24 && z2) {
                intentA02.addFlags(268472320);
            }
            C1152Wu.A0D(c1648gi, intentA02);
            return;
        }
        throw new X4();
    }

    private void A0C(C1648gi c1648gi, Uri uri, String str, Map<String, String> map) {
        AdActivityIntent adActivityIntentA05 = C1152Wu.A05(c1648gi);
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            adActivityIntentA05.addFlags(268435456);
        }
        adActivityIntentA05.putExtra(A07(734, 8, 68), WK.A03);
        adActivityIntentA05.putExtra(A07(249, 10, 107), uri.toString());
        adActivityIntentA05.putExtra(A07(277, 11, 26), str);
        adActivityIntentA05.putExtra(A07(533, 11, 0), System.currentTimeMillis());
        if (map != null) {
            String strA07 = A07(267, 10, 56);
            adActivityIntentA05.putExtra(strA07, map.get(strA07));
            String strA072 = A07(655, 21, 43);
            adActivityIntentA05.putExtra(strA072, map.get(strA072));
            String strA073 = A07(628, 27, 27);
            adActivityIntentA05.putExtra(strA073, map.get(strA073));
            String strA074 = A07(510, 23, 45);
            adActivityIntentA05.putExtra(strA074, map.get(strA074));
            String strA075 = A07(726, 8, 120);
            String str2 = map.get(strA075);
            if (str2 != null) {
                adActivityIntentA05.putExtra(strA075, str2);
            }
            String[] strArr = A01;
            if (strArr[2].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "O2ZHG0wvVecFW0SnbGPXrhKJPtS";
            strArr2[6] = "QZ4K1TQ8";
            String strA076 = A07(676, 12, 72);
            String str3 = map.get(strA076);
            if (str3 != null) {
                adActivityIntentA05.putExtra(strA076, Boolean.valueOf(str3));
            }
        }
        try {
            C1152Wu.A0B(c1648gi, adActivityIntentA05);
        } catch (C1150Ws e3) {
            Throwable cause = e3.getCause();
            C1150Ws cause2 = e3;
            if (cause != null) {
                cause2 = e3.getCause();
            }
            c1648gi.A08().ABC(A07(168, 11, 110), AbstractC1060Td.A0D, new C1061Te(cause2));
            Log.e(A07(149, 17, 28), A07(50, 90, 84), cause2);
        }
    }

    public static void A0D(X6 x6, C1648gi c1648gi, Uri uri, String str) {
        x6.A0N(c1648gi, uri, str);
    }

    public static void A0E(X6 x6, C1648gi c1648gi, Uri uri, String str) throws C1150Ws {
        A06(x6, c1648gi, uri, str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0F(android.net.Uri r5) {
        /*
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 24
            r4 = 0
            if (r1 < r0) goto L1f
            android.security.NetworkSecurityPolicy r0 = android.security.NetworkSecurityPolicy.getInstance()
            boolean r0 = r0.isCleartextTrafficPermitted()
            if (r0 != 0) goto L1f
            android.security.NetworkSecurityPolicy r1 = android.security.NetworkSecurityPolicy.getInstance()
            java.lang.String r0 = r5.getHost()
            boolean r0 = r1.isCleartextTrafficPermitted(r0)
            if (r0 == 0) goto L45
        L1f:
            r0 = 1
        L20:
            java.lang.String r3 = r5.getScheme()
            if (r0 == 0) goto L35
            r2 = 544(0x220, float:7.62E-43)
            r1 = 4
            r0 = 48
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 != 0) goto L43
        L35:
            r2 = 582(0x246, float:8.16E-43)
            r1 = 5
            r0 = 1
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L44
        L43:
            r4 = 1
        L44:
            return r4
        L45:
            r0 = 0
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.X6.A0F(android.net.Uri):boolean");
    }

    private boolean A0G(C1648gi c1648gi) {
        if (!C1098Up.A1F(c1648gi)) {
            return false;
        }
        int deviceFBVersion = C1098Up.A0E(c1648gi);
        int iA00 = A00(c1648gi);
        if (deviceFBVersion == -1 || iA00 == -1 || deviceFBVersion > iA00) {
            return false;
        }
        int i3 = Build.VERSION.SDK_INT;
        String[] strArr = A01;
        String str = strArr[4];
        String str2 = strArr[6];
        int length = str.length();
        int fbVersionWithGPOverlay = str2.length();
        if (length == fbVersionWithGPOverlay) {
            throw new RuntimeException();
        }
        A01[7] = "9F";
        if (i3 < 28) {
            return false;
        }
        String[] strArr2 = A01;
        String str3 = strArr2[2];
        String str4 = strArr2[1];
        int length2 = str3.length();
        int fbVersionWithGPOverlay2 = str4.length();
        if (length2 != fbVersionWithGPOverlay2) {
            String[] strArr3 = A01;
            strArr3[4] = "HTEWLbQNfCJbfH7LEcJTogLCYG9";
            strArr3[6] = "jIuteURS";
            return true;
        }
        return true;
    }

    private boolean A0H(C1648gi c1648gi) {
        Intent playStoreIntent = new Intent(A07(186, 26, 10), XB.A00(A07(548, 34, 3)));
        Iterator<ResolveInfo> it = c1648gi.getPackageManager().queryIntentActivities(playStoreIntent, 0).iterator();
        do {
            boolean zHasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[5].charAt(7) != strArr[0].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "NqbTETCkL6wtg2G74gvKWlTJws9";
            strArr2[6] = "JszVyiBC";
            if (!zHasNext) {
                return false;
            }
        } while (!it.next().activityInfo.applicationInfo.packageName.equals(A07(322, 19, 35)));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079 A[PHI: r0 r1 r5
      0x0079: PHI (r0v21 int) = (r0v17 int), (r0v25 int) binds: [B:33:0x00d7, B:19:0x0077] A[DONT_GENERATE, DONT_INLINE]
      0x0079: PHI (r1v15 java.lang.String) = (r1v12 java.lang.String), (r1v19 java.lang.String) binds: [B:33:0x00d7, B:19:0x0077] A[DONT_GENERATE, DONT_INLINE]
      0x0079: PHI (r5v2 java.lang.String) = (r5v0 java.lang.String), (r5v3 java.lang.String) binds: [B:33:0x00d7, B:19:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0I(com.facebook.ads.redexgen.core.C1648gi r12) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.X6.A0I(com.facebook.ads.redexgen.X.gi):boolean");
    }

    public static boolean A0J(C1648gi c1648gi) {
        ActivityInfo activityInfo;
        try {
            Activity activityA0E = c1648gi.A0E();
            PackageManager packageManager = c1648gi.getPackageManager();
            if (activityA0E == null || packageManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT > 32) {
                activityInfo = packageManager.getActivityInfo(activityA0E.getComponentName(), PackageManager.ComponentInfoFlags.of(0L));
            } else {
                activityInfo = packageManager.getActivityInfo(activityA0E.getComponentName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            }
            Field declaredField = ActivityInfo.class.getDeclaredField(A07(716, 10, 25));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activityInfo);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue() != 0;
            }
        } catch (PackageManager.NameNotFoundException | IllegalAccessException | NoSuchFieldException e3) {
            c1648gi.A0F().AC5(e3.getMessage());
        }
        return false;
    }

    public static boolean A0K(C1648gi c1648gi, Uri uri) {
        String strA07 = A07(322, 19, 35);
        if (!C1098Up.A1H(c1648gi)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            c1648gi.A0F().ABH(1);
            return false;
        }
        PackageManager packageManager = c1648gi.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(strA07, 0);
            if (packageInfo != null && !TextUtils.isEmpty(packageInfo.versionName)) {
                String[] strArrSplit = packageInfo.versionName.split(A07(166, 2, 9), 2);
                if (strArrSplit.length < 1) {
                    c1648gi.A0F().ABH(2);
                    return false;
                }
                if (Integer.parseInt(strArrSplit[0]) < C1098Up.A0G(c1648gi)) {
                    c1648gi.A0F().ABH(3);
                    return false;
                }
            }
            Intent intent = new Intent(A07(186, 26, 10));
            String packageName = c1648gi.getPackageName();
            intent.setPackage(strA07);
            Uri hsdpUri = A04(c1648gi, uri);
            if (hsdpUri == null) {
                return false;
            }
            intent.setData(hsdpUri);
            intent.putExtra(A07(694, 7, 6), true);
            intent.putExtra(A07(259, 8, 30), packageName);
            if (intent.resolveActivity(packageManager) != null) {
                Activity activityA0E = c1648gi.A0E();
                if (activityA0E == null) {
                    activityA0E = ActivityUtils.A00();
                }
                if (activityA0E != null) {
                    activityA0E.startActivityForResult(intent, 945321098);
                    c1648gi.A0F().ABH(0);
                    return true;
                }
                c1648gi.A0F().ABH(7);
                return false;
            }
            InterfaceC0874Lt interfaceC0874LtA0F = c1648gi.A0F();
            String[] strArr = A01;
            if (strArr[2].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "";
            strArr2[1] = "uL3";
            interfaceC0874LtA0F.ABH(6);
            return false;
        } catch (PackageManager.NameNotFoundException | NumberFormatException unused) {
            c1648gi.A0F().ABH(4);
            return false;
        }
    }

    private boolean A0L(C1648gi c1648gi, Uri uri, String str) throws C1150Ws {
        try {
            Activity activityA0E = c1648gi.A0E();
            String string = uri.toString();
            if (activityA0E != null && !TextUtils.isEmpty(string)) {
                Intent fbIntent = new Intent();
                if (C1098Up.A1G(c1648gi)) {
                    String strA06 = AbstractC1813jd.A06(str);
                    if (TextUtils.isEmpty(strA06)) {
                        return false;
                    }
                    fbIntent.putExtra(A07(0, 20, 67), A08(strA06));
                }
                fbIntent.setComponent(new ComponentName(A07(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, 19, 65), A07(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 71, 75)));
                fbIntent.putExtra(A07(140, 9, 22), string);
                fbIntent.putExtra(A07(37, 13, 89), A08(A07(20, 17, 90)));
                if (!C1152Wu.A0E(c1648gi, fbIntent)) {
                    activityA0E.startActivityForResult(fbIntent, 2);
                    return true;
                }
                return true;
            }
            return false;
        } catch (ActivityNotFoundException | IllegalStateException e3) {
            c1648gi.A0F().ABG(e3.getMessage());
            return false;
        }
    }

    private boolean A0M(C1648gi c1648gi, Uri uri, String str) throws C1150Ws {
        return A0G(c1648gi) && A0L(c1648gi, uri, str);
    }

    private final boolean A0N(C1648gi c1648gi, Uri uri, String str) {
        return C1152Wu.A0G(c1648gi, uri, str);
    }

    public static boolean A0O(X6 x6, C1648gi c1648gi, Uri uri, String str) {
        try {
            A0E(x6, c1648gi, uri, str);
            return true;
        } catch (C1150Ws e3) {
            Throwable cause = e3.getCause();
            C1150Ws cause2 = e3;
            if (cause != null) {
                cause2 = e3.getCause();
            }
            c1648gi.A08().ABC(A07(168, 11, 110), AbstractC1060Td.A05, new C1061Te(cause2));
            return false;
        }
    }
}
