package com.facebook.ads.redexgen.core;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.To, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1071To {
    public static byte[] A02;
    public static String[] A03 = {"ksHi49HeyLxhEuEQ3ZpH94jUoJqLqgaO", "OjCJx3NFQ0DFgiyf16DgggNozGEs4R4q", "GEO9tIl26J6KBxgfZlF82GfP7HtNAY9Z", "nOASZQwcdTvox6Zrqcm6Ob1f72Bs0sPe", "97ugpJwHRGNEpoGk3FmXenG", "0hX3UIoeWP89IzRfugcPHePTUXouBxgf", "dDjk4aEiSkmoIE6VCcWXk7EEukMkdVWT", "2G0bY4RpV1kXQIyv7KcyHSXfT8fWnCKY"};
    public static final String A04;
    public final T8 A00;
    public final String A01;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-57, -44, -54, -40, -43, -49, -54, -108, -42, -53, -40, -45, -49, -39, -39, -49, -43, -44, -108, -88, -81, -76, -86, -59, -89, -87, -87, -85, -71, -71, -81, -88, -81, -78, -81, -70, -65, -59, -71, -85, -72, -68, -81, -87, -85, -103, -105, -96, -105, -92, -101, -107, -65, -73, -66, -67, -76};
    }

    static {
        A02();
        A04 = Build.VERSION.RELEASE;
    }

    public C1071To(T8 t8) {
        this(t8, null);
    }

    public C1071To(T8 t8, String str) {
        this.A00 = t8;
        this.A01 = str;
    }

    private String A00() {
        int i3;
        if (this.A01 != null) {
            return this.A01;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            i3 = 67108864;
        } else {
            i3 = 0;
        }
        PendingIntent activity = PendingIntent.getActivity(this.A00, 0, new Intent(), i3);
        if (activity == null) {
            return A01(0, 0, 54);
        }
        return activity.getCreatorPackage();
    }

    public final int A03() {
        return XK.A01(this.A00);
    }

    public final int A04() {
        try {
            return this.A00.getPackageManager().getPackageInfo(A00(), 0).versionCode;
        } catch (Throwable t2) {
            this.A00.A08().ABC(A01(45, 7, 31), AbstractC1060Td.A1M, new C1061Te(t2));
            return 0;
        }
    }

    public final String A05() {
        try {
            CharSequence appLabel = this.A00.getPackageManager().getApplicationLabel(this.A00.getPackageManager().getApplicationInfo(A00(), 0));
            if (appLabel != null && appLabel.length() > 0) {
                return appLabel.toString();
            }
        } catch (Throwable th) {
            this.A00.A08().ABC(A01(45, 7, 31), AbstractC1060Td.A1M, new C1061Te(th));
        }
        return A01(0, 0, 54);
    }

    public final String A06() {
        String str = null;
        try {
            str = this.A00.getPackageManager().getPackageInfo(A00(), 0).versionName;
        } catch (Throwable t2) {
            InterfaceC1059Tc interfaceC1059TcA08 = this.A00.A08();
            int i3 = AbstractC1060Td.A1M;
            C1061Te c1061Te = new C1061Te(t2);
            String appVersionName = A01(45, 7, 31);
            interfaceC1059TcA08.ABz(appVersionName, i3, c1061Te);
        }
        return !TextUtils.isEmpty(str) ? str : A01(0, 0, 54);
    }

    public final String A07() {
        String bundleOverride = this.A00.A05().A79();
        if (bundleOverride != null) {
            return bundleOverride;
        }
        return A00();
    }

    public final String A08() {
        TelephonyManager telephonyManager = (TelephonyManager) this.A00.getSystemService(A01(52, 5, 60));
        if (telephonyManager != null) {
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (A03[2].charAt(10) != '6') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[5] = "Y0rO6junFBlFHafjvJcSeB7fUCyZ4Mo6";
            strArr[7] = "E4dacaRM3DS0bJ8W8Pcl72SYoh6IL0u8";
            if (networkOperatorName != null && networkOperatorName.length() > 0) {
                return networkOperatorName;
            }
        }
        return A01(0, 0, 54);
    }

    public final String A09() {
        if (Build.MANUFACTURER != null) {
            String str = Build.MANUFACTURER;
            String[] strArr = A03;
            if (strArr[3].charAt(20) == strArr[0].charAt(20)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[3] = "17co7YvrhvaQQJ3lRMCxQ7nYKJi0wzqK";
            strArr2[0] = "xVh8HKEIQLp4oZwybdpyhu7U8ElYQBbb";
            if (str.length() > 0) {
                return Build.MANUFACTURER;
            }
        }
        return A01(0, 0, 54);
    }

    public final String A0A() {
        return (Build.MODEL == null || Build.MODEL.length() <= 0) ? A01(0, 0, 54) : Build.MODEL;
    }

    public final String A0B() {
        String installer_name;
        try {
            String strA00 = A00();
            if (strA00 != null && strA00.length() >= 0 && (installer_name = this.A00.getPackageManager().getInstallerPackageName(strA00)) != null) {
                if (installer_name.length() > 0) {
                    return installer_name;
                }
            }
        } catch (Throwable th) {
            this.A00.A08().ABz(A01(45, 7, 31), AbstractC1060Td.A1M, new C1061Te(th));
        }
        return A01(0, 0, 54);
    }

    public final boolean A0C() {
        return this.A00.checkCallingOrSelfPermission(A01(0, 45, 83)) == 0;
    }
}
