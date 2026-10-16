package com.applovin.impl;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.app.jE.vxrlPPpdv;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.impl.e9;
import com.facebook.ads.AdError;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class xp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f65027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f65028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f65029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f65030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f65031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f65032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f65033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f65034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f65035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f65036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static HashMap f65037k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f65038l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f65039m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f65040n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f65041o;

    public static int a(long j3, long j4) {
        if (j3 < j4) {
            return -1;
        }
        return j3 == j4 ? 0 : 1;
    }

    public static Point c(Context context) {
        DisplayManager displayManager;
        Display display = (f65027a < 17 || (displayManager = (DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY)) == null) ? null : displayManager.getDisplay(0);
        if (display == null) {
            display = ((WindowManager) b1.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return a(context, display);
    }

    public static int d(int i3) {
        if (i3 == 8) {
            return 3;
        }
        if (i3 == 16) {
            return 2;
        }
        if (i3 != 24) {
            return i3 != 32 ? 0 : 805306368;
        }
        return 536870912;
    }

    public static int e(int i3) {
        if (i3 == 13) {
            return 1;
        }
        switch (i3) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static boolean f(int i3) {
        return i3 == 536870912 || i3 == 805306368 || i3 == 4;
    }

    public static boolean g(int i3) {
        return i3 == 3 || i3 == 2 || i3 == 268435456 || i3 == 536870912 || i3 == 805306368 || i3 == 4;
    }

    public static boolean h(int i3) {
        return i3 == 10 || i3 == 13;
    }

    public static long i(int i3) {
        return ((long) i3) & 4294967295L;
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        f65027a = i3;
        String str = Build.DEVICE;
        f65028b = str;
        String str2 = Build.MANUFACTURER;
        f65029c = str2;
        String str3 = Build.MODEL;
        f65030d = str3;
        f65031e = str + ", " + str3 + ", " + str2 + ", " + i3;
        f65032f = new byte[0];
        f65033g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f65034h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f65035i = Pattern.compile("%([A-Fa-f0-9]{2})");
        f65036j = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        f65038l = new String[]{"alb", "sq", MHoiDDglUlPJC.evWEHaRO, "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", vxrlPPpdv.bWOCLW, "iw", "he", "heb", "he", "ji", "yi", "in", vxrlPPpdv.bWOCLW, "ind", vxrlPPpdv.bWOCLW, "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f65039m = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f65040n = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f65041o = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, SensibleDefaults.X_OFFSET, 179, 186, 189, 199, 192, RCHTTPStatusCodes.CREATED, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 149, 146, ModuleDescriptor.MODULE_VERSION, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static long a(long j3, long j4, long j5) {
        long j6 = j3 + j4;
        return ((j3 ^ j6) & (j4 ^ j6)) < 0 ? j5 : j6;
    }

    public static int b(int i3) {
        if (i3 == 2 || i3 == 4) {
            return 6005;
        }
        if (i3 == 10) {
            return 6004;
        }
        if (i3 == 7) {
            return 6005;
        }
        if (i3 == 8) {
            return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
        }
        switch (i3) {
            case 15:
                return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i3) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return AdError.ICONVIEW_MISSING_ERROR_CODE;
                    default:
                        return 6006;
                }
        }
    }

    public static long d(long j3, long j4, long j5) {
        long j6 = j3 - j4;
        return ((j3 ^ j6) & (j4 ^ j3)) < 0 ? j5 : j6;
    }

    public static ExecutorService e(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.applovin.impl.u80
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return xp.a(str, runnable);
            }
        });
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals("und")) {
            str = strReplace;
        }
        String lowerCase = Ascii.toLowerCase(str);
        String str2 = b(lowerCase, "-")[0];
        if (f65037k == null) {
            f65037k = c();
        }
        String str3 = (String) f65037k.get(str2);
        if (str3 != null) {
            lowerCase = str3 + lowerCase.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? d(lowerCase) : lowerCase;
    }

    public static Object a(Object obj) {
        return obj;
    }

    public static long b(long j3) {
        return (j3 == -9223372036854775807L || j3 == Long.MIN_VALUE) ? j3 : j3 * 1000;
    }

    public static boolean d(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static String[] e() {
        String[] strArrF = f();
        for (int i3 = 0; i3 < strArrF.length; i3++) {
            strArrF[i3] = f(strArrF[i3]);
        }
        return strArrF;
    }

    public static Object[] a(Object[] objArr) {
        return objArr;
    }

    public static int b(List list, Comparable comparable, boolean z2, boolean z3) {
        int i3;
        int i4;
        int iBinarySearch = Collections.binarySearch(list, comparable);
        if (iBinarySearch < 0) {
            i4 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i3 = iBinarySearch - 1;
                if (i3 < 0 || ((Comparable) list.get(i3)).compareTo(comparable) != 0) {
                    break;
                }
                iBinarySearch = i3;
            }
            i4 = z2 ? iBinarySearch : i3;
        }
        return z3 ? Math.max(0, i4) : i4;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static String d(String str) {
        int i3 = 0;
        while (true) {
            String[] strArr = f65039m;
            if (i3 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i3])) {
                return strArr[i3 + 1] + str.substring(strArr[i3].length());
            }
            i3 += 2;
        }
    }

    public static int a(List list, Comparable comparable, boolean z2, boolean z3) {
        int i3;
        int i4;
        int iBinarySearch = Collections.binarySearch(list, comparable);
        if (iBinarySearch < 0) {
            i4 = ~iBinarySearch;
        } else {
            int size = list.size();
            while (true) {
                i3 = iBinarySearch + 1;
                if (i3 >= size || ((Comparable) list.get(i3)).compareTo(comparable) != 0) {
                    break;
                }
                iBinarySearch = i3;
            }
            i4 = z2 ? iBinarySearch : i3;
        }
        return z3 ? Math.min(list.size() - 1, i4) : i4;
    }

    public static int b(long[] jArr, long j3, boolean z2, boolean z3) {
        int i3;
        int i4;
        int iBinarySearch = Arrays.binarySearch(jArr, j3);
        if (iBinarySearch < 0) {
            i4 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i3 = iBinarySearch - 1;
                if (i3 < 0 || jArr[i3] != j3) {
                    break;
                }
                iBinarySearch = i3;
            }
            i4 = z2 ? iBinarySearch : i3;
        }
        return z3 ? Math.max(0, i4) : i4;
    }

    private static void c(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static Looper d() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static int a(long[] jArr, long j3, boolean z2, boolean z3) {
        int i3;
        int i4;
        int iBinarySearch = Arrays.binarySearch(jArr, j3);
        if (iBinarySearch < 0) {
            i4 = ~iBinarySearch;
        } else {
            while (true) {
                i3 = iBinarySearch + 1;
                if (i3 >= jArr.length || jArr[i3] != j3) {
                    break;
                }
                iBinarySearch = i3;
            }
            i4 = z2 ? iBinarySearch : i3;
        }
        return z3 ? Math.min(jArr.length - 1, i4) : i4;
    }

    public static long b(long j3, long j4, long j5) {
        return Math.max(j4, Math.min(j3, j5));
    }

    public static String c(int i3) {
        if (i3 == 0) {
            return "NO";
        }
        if (i3 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i3 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i3 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i3 == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static int b(byte[] bArr, int i3, int i4, int i5) {
        while (i3 < i4) {
            i5 = f65041o[i5 ^ (bArr[i3] & 255)];
            i3++;
        }
        return i5;
    }

    public static Handler b() {
        return b((Handler.Callback) null);
    }

    public static int a(qc qcVar, long j3, boolean z2, boolean z3) {
        int i3;
        int iA = qcVar.a() - 1;
        int i4 = 0;
        while (i4 <= iA) {
            int i5 = (i4 + iA) >>> 1;
            if (qcVar.a(i5) < j3) {
                i4 = i5 + 1;
            } else {
                iA = i5 - 1;
            }
        }
        if (z2 && (i3 = iA + 1) < qcVar.a() && qcVar.a(i3) == j3) {
            return i3;
        }
        if (z3 && iA == -1) {
            return 0;
        }
        return iA;
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return Ascii.toUpperCase(networkCountryIso);
            }
        }
        return Ascii.toUpperCase(Locale.getDefault().getCountry());
    }

    private static String[] f() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return f65027a >= 24 ? a(configuration) : new String[]{a(configuration.locale)};
    }

    public static int a(int[] iArr, int i3, boolean z2, boolean z3) {
        int i4;
        int i5;
        int iBinarySearch = Arrays.binarySearch(iArr, i3);
        if (iBinarySearch < 0) {
            i5 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i4 = iBinarySearch - 1;
                if (i4 < 0 || iArr[i4] != i3) {
                    break;
                }
                iBinarySearch = i4;
            }
            i5 = z2 ? iBinarySearch : i4;
        }
        return z3 ? Math.max(0, i5) : i5;
    }

    public static byte[] c(String str) {
        return str.getBytes(Charsets.UTF_8);
    }

    public static long c(long j3, long j4, long j5) {
        if (j5 >= j4 && j5 % j4 == 0) {
            return j3 / (j5 / j4);
        }
        if (j5 < j4 && j4 % j5 == 0) {
            return j3 * (j4 / j5);
        }
        return (long) (j3 * (j4 / j5));
    }

    private static void b(Display display, Point point) {
        display.getRealSize(point);
    }

    public static int a(int i3, int i4) {
        return ((i3 + i4) - 1) / i4;
    }

    private static String b(Locale locale) {
        return locale.toLanguageTag();
    }

    public static void a(h5 h5Var) {
        if (h5Var != null) {
            try {
                h5Var.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int b(int i3, int i4) {
        if (i3 != 2) {
            if (i3 == 3) {
                return i4;
            }
            if (i3 != 4) {
                if (i3 != 268435456) {
                    if (i3 == 536870912) {
                        return i4 * 3;
                    }
                    if (i3 != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i4 * 4;
        }
        return i4 * 2;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long b(long j3, float f3) {
        return f3 == 1.0f ? j3 : Math.round(j3 / ((double) f3));
    }

    public static float a(float f3, float f4, float f5) {
        return Math.max(f4, Math.min(f3, f5));
    }

    public static String[] b(String str, String str2) {
        return str.split(str2, 2);
    }

    public static long c(int i3, int i4) {
        return i(i4) | (i(i3) << 32);
    }

    public static int a(int i3, int i4, int i5) {
        return Math.max(i4, Math.min(i3, i5));
    }

    public static Handler b(Handler.Callback callback) {
        return a(d(), callback);
    }

    public static long c(long j3) {
        return (j3 == -9223372036854775807L || j3 == Long.MIN_VALUE) ? j3 : j3 / 1000;
    }

    public static int a(byte[] bArr, int i3, int i4, int i5) {
        while (i3 < i4) {
            i5 = f65040n[((i5 >>> 24) ^ (bArr[i3] & 255)) & 255] ^ (i5 << 8);
            i3++;
        }
        return i5;
    }

    public static String b(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < objArr.length; i3++) {
            sb.append(objArr[i3].getClass().getSimpleName());
            if (i3 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private static HashMap c() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap map = new HashMap(iSOLanguages.length + f65038l.length);
        int i3 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    map.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = f65038l;
            if (i3 >= strArr.length) {
                return map;
            }
            map.put(strArr[i3], strArr[i3 + 1]);
            i3 += 2;
        }
    }

    public static Handler a() {
        return a((Handler.Callback) null);
    }

    public static int a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static int a(int i3) {
        switch (i3) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i4 = f65027a;
                return (i4 < 23 && i4 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int a(ByteBuffer byteBuffer, int i3) {
        int i4 = byteBuffer.getInt(i3);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i4 : Integer.reverseBytes(i4);
    }

    public static e9 b(int i3, int i4, int i5) {
        return new e9.b().f("audio/raw").c(i4).n(i5).j(i3).a();
    }

    public static Point a(Context context, Display display) {
        String strB;
        if (display.getDisplayId() == 0 && d(context)) {
            if (f65027a < 28) {
                strB = b("sys.display-size");
            } else {
                strB = b("vendor.display-size");
            }
            if (!TextUtils.isEmpty(strB)) {
                try {
                    String[] strArrA = a(strB.trim(), "x");
                    if (strArrA.length == 2) {
                        int i3 = Integer.parseInt(strArrA[0]);
                        int i4 = Integer.parseInt(strArrA[1]);
                        if (i3 > 0 && i4 > 0) {
                            return new Point(i3, i4);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                oc.b("Util", "Invalid display size: " + strB);
            }
            if ("Sony".equals(f65029c) && f65030d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i5 = f65027a;
        if (i5 >= 23) {
            c(display, point);
        } else if (i5 >= 17) {
            b(display, point);
        } else {
            a(display, point);
        }
        return point;
    }

    private static String b(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e3) {
            oc.a("Util", "Failed to read system property " + str, e3);
            return null;
        }
    }

    private static void a(Display display, Point point) {
        display.getSize(point);
    }

    public static int a(String str) {
        String[] strArrA;
        int length;
        int i3 = 0;
        if (str == null || (length = (strArrA = a(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = strArrA[length - 1];
        boolean z2 = length >= 3 && "neg".equals(strArrA[length - 2]);
        try {
            i3 = Integer.parseInt((String) b1.a((Object) str2));
            if (z2) {
                return -i3;
            }
        } catch (NumberFormatException unused) {
        }
        return i3;
    }

    public static long a(long j3, float f3) {
        return f3 == 1.0f ? j3 : Math.round(j3 * ((double) f3));
    }

    public static long a(long j3) {
        if (j3 == -9223372036854775807L) {
            return System.currentTimeMillis();
        }
        return SystemClock.elapsedRealtime() + j3;
    }

    public static String a(StringBuilder sb, Formatter formatter, long j3) {
        if (j3 == -9223372036854775807L) {
            j3 = 0;
        }
        String str = j3 < 0 ? "-" : "";
        long jAbs = (Math.abs(j3) + 500) / 1000;
        long j4 = jAbs % 60;
        long j5 = (jAbs / 60) % 60;
        long j6 = jAbs / 3600;
        sb.setLength(0);
        if (j6 > 0) {
            return formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)).toString();
        }
        return formatter.format("%s%02d:%02d", str, Long.valueOf(j5), Long.valueOf(j4)).toString();
    }

    private static String[] a(Configuration configuration) {
        return a(configuration.getLocales().toLanguageTags(), ",");
    }

    public static String a(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.15.1";
    }

    public static boolean a(ah ahVar, ah ahVar2, Inflater inflater) {
        if (ahVar.a() <= 0) {
            return false;
        }
        if (ahVar2.b() < ahVar.a()) {
            ahVar2.a(ahVar.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(ahVar.c(), ahVar.d(), ahVar.a());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(ahVar2.c(), iInflate, ahVar2.b() - iInflate);
                if (inflater.finished()) {
                    ahVar2.e(iInflate);
                    inflater.reset();
                    return true;
                }
                if (inflater.needsDictionary() || inflater.needsInput()) {
                    break;
                }
                if (iInflate == ahVar2.b()) {
                    ahVar2.a(ahVar2.b() * 2);
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static boolean a(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static int a(int[] iArr, int i3) {
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (iArr[i4] == i3) {
                return i4;
            }
        }
        return -1;
    }

    public static Object[] a(Object[] objArr, Object[] objArr2) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + objArr2.length);
        System.arraycopy(objArr2, 0, objArrCopyOf, objArr.length, objArr2.length);
        return objArrCopyOf;
    }

    public static Object[] a(Object[] objArr, int i3) {
        b1.a(i3 <= objArr.length);
        return Arrays.copyOf(objArr, i3);
    }

    public static Object[] a(Object[] objArr, int i3, int i4) {
        b1.a(i3 >= 0);
        b1.a(i4 <= objArr.length);
        return Arrays.copyOfRange(objArr, i3, i4);
    }

    public static boolean a(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
            return true;
        }
        return handler.post(runnable);
    }

    public static boolean a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void a(long[] jArr, long j3, long j4) {
        int i3 = 0;
        if (j4 >= j3 && j4 % j3 == 0) {
            long j5 = j4 / j3;
            while (i3 < jArr.length) {
                jArr[i3] = jArr[i3] / j5;
                i3++;
            }
            return;
        }
        if (j4 < j3 && j3 % j4 == 0) {
            long j6 = j3 / j4;
            while (i3 < jArr.length) {
                jArr[i3] = jArr[i3] * j6;
                i3++;
            }
            return;
        }
        double d3 = j3 / j4;
        while (i3 < jArr.length) {
            jArr[i3] = (long) (jArr[i3] * d3);
            i3++;
        }
    }

    public static String[] a(String str, String str2) {
        return str.split(str2, -1);
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 != -1) {
                byteArrayOutputStream.write(bArr, 0, i3);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static CharSequence a(CharSequence charSequence, int i3) {
        return charSequence.length() <= i3 ? charSequence : charSequence.subSequence(0, i3);
    }

    public static void a(Parcel parcel, boolean z2) {
        parcel.writeInt(z2 ? 1 : 0);
    }

    public static Handler a(Handler.Callback callback) {
        return a((Looper) b1.b(Looper.myLooper()), callback);
    }

    public static Handler a(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread a(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static String a(Locale locale) {
        return f65027a >= 21 ? b(locale) : locale.toString();
    }

    public static String a(byte[] bArr) {
        return new String(bArr, Charsets.UTF_8);
    }

    public static String a(byte[] bArr, int i3, int i4) {
        return new String(bArr, i3, i4, Charsets.UTF_8);
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }
}
