package androidx.core.util;

import com.facebook.AccessTokenManager;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TimeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f34374a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static char[] f34375b = new char[24];

    private static int a(int i3, int i4, boolean z2, int i5) {
        if (i3 > 99 || (z2 && i5 >= 3)) {
            return i4 + 3;
        }
        if (i3 > 9 || (z2 && i5 >= 2)) {
            return i4 + 2;
        }
        if (z2 || i3 > 0) {
            return i4 + 1;
        }
        return 0;
    }

    public static void b(long j3, long j4, PrintWriter printWriter) {
        if (j3 == 0) {
            printWriter.print("--");
        } else {
            d(j3 - j4, printWriter, 0);
        }
    }

    public static void c(long j3, PrintWriter printWriter) {
        d(j3, printWriter, 0);
    }

    public static void d(long j3, PrintWriter printWriter, int i3) {
        synchronized (f34374a) {
            printWriter.print(new String(f34375b, 0, f(j3, i3)));
        }
    }

    public static void e(long j3, StringBuilder sb) {
        synchronized (f34374a) {
            sb.append(f34375b, 0, f(j3, 0));
        }
    }

    private static int f(long j3, int i3) {
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j4 = j3;
        if (f34375b.length < i3) {
            f34375b = new char[i3];
        }
        char[] cArr = f34375b;
        if (j4 == 0) {
            int i8 = i3 - 1;
            while (i8 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j4 > 0) {
            c3 = '+';
        } else {
            j4 = -j4;
            c3 = '-';
        }
        int i9 = (int) (j4 % 1000);
        int iFloor = (int) Math.floor(j4 / 1000);
        if (iFloor > 86400) {
            i4 = iFloor / AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS;
            iFloor -= AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS * i4;
        } else {
            i4 = 0;
        }
        if (iFloor > 3600) {
            i5 = iFloor / AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS;
            iFloor -= i5 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS;
        } else {
            i5 = 0;
        }
        if (iFloor > 60) {
            int i10 = iFloor / 60;
            iFloor -= i10 * 60;
            i6 = i10;
        } else {
            i6 = 0;
        }
        if (i3 != 0) {
            int iA = a(i4, 1, false, 0);
            int iA2 = iA + a(i5, 1, iA > 0, 2);
            int iA3 = iA2 + a(i6, 1, iA2 > 0, 2);
            int iA4 = iA3 + a(iFloor, 1, iA3 > 0, 2);
            i7 = 0;
            for (int iA5 = iA4 + a(i9, 2, true, iA4 > 0 ? 3 : 0) + 1; iA5 < i3; iA5++) {
                cArr[i7] = ' ';
                i7++;
            }
        } else {
            i7 = 0;
        }
        cArr[i7] = c3;
        int i11 = i7 + 1;
        boolean z2 = i3 != 0;
        int iG = g(cArr, i4, 'd', i11, false, 0);
        int iG2 = g(cArr, i5, 'h', iG, iG != i11, z2 ? 2 : 0);
        int iG3 = g(cArr, i6, 'm', iG2, iG2 != i11, z2 ? 2 : 0);
        int iG4 = g(cArr, iFloor, 's', iG3, iG3 != i11, z2 ? 2 : 0);
        int iG5 = g(cArr, i9, 'm', iG4, true, (!z2 || iG4 == i11) ? 0 : 3);
        cArr[iG5] = 's';
        return iG5 + 1;
    }

    private static int g(char[] cArr, int i3, char c3, int i4, boolean z2, int i5) {
        int i6;
        if (!z2 && i3 <= 0) {
            return i4;
        }
        if ((!z2 || i5 < 3) && i3 <= 99) {
            i6 = i4;
        } else {
            int i7 = i3 / 100;
            cArr[i4] = (char) (i7 + 48);
            i6 = i4 + 1;
            i3 -= i7 * 100;
        }
        if ((z2 && i5 >= 2) || i3 > 9 || i4 != i6) {
            int i8 = i3 / 10;
            cArr[i6] = (char) (i8 + 48);
            i6++;
            i3 -= i8 * 10;
        }
        cArr[i6] = (char) (i3 + 48);
        cArr[i6 + 1] = c3;
        return i6 + 2;
    }
}
