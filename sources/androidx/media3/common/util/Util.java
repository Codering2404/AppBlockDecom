package androidx.media3.common.util;

import android.app.Notification;
import android.app.Service;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseLongArray;
import android.view.Display;
import android.view.WindowManager;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.Player;
import androidx.media3.common.audio.AudioManagerCompat;
import androidx.media3.common.audio.AudioProcessor;
import com.facebook.ads.AdError;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.common.base.Ascii;
import com.google.common.io.ByteStreams;
import com.google.common.math.DoubleMath;
import com.google.common.math.LongMath;
import com.google.common.primitives.UnsignedBytes;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f41610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f41611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f41612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f41613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f41614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long[] f41615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f41616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f41617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f41618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f41619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static HashMap f41620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f41621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String[] f41622n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f41623o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f41624p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f41625q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api29 {
        public static void a(Service service, int i3, Notification notification, int i4, String str) {
            try {
                service.startForeground(i3, notification, i4);
            } catch (RuntimeException e3) {
                Log.d("Util", "The service must be declared with a foregroundServiceType that includes " + str);
                throw e3;
            }
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        f41609a = i3;
        String str = Build.DEVICE;
        f41610b = str;
        String str2 = Build.MANUFACTURER;
        f41611c = str2;
        String str3 = Build.MODEL;
        f41612d = str3;
        f41613e = str + ", " + str3 + ", " + str2 + ", " + i3;
        f41614f = new byte[0];
        f41615g = new long[0];
        f41616h = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f41617i = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f41618j = Pattern.compile("%([A-Fa-f0-9]{2})");
        f41619k = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        f41621m = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f41622n = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f41623o = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f41624p = new int[]{0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
        f41625q = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, SensibleDefaults.X_OFFSET, 179, 186, 189, 199, 192, RCHTTPStatusCodes.CREATED, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 149, 146, ModuleDescriptor.MODULE_VERSION, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static int A(byte[] bArr, int i3, int i4, int i5) {
        while (i3 < i4) {
            i5 = f41625q[i5 ^ (bArr[i3] & 255)];
            i3++;
        }
        return i5;
    }

    public static boolean A0(String str) {
        str.getClass();
        switch (str) {
            case "image/avif":
                return f41609a >= 34;
            case "image/heic":
            case "image/heif":
                return f41609a >= 26;
            case "image/jpeg":
            case "image/webp":
            case "image/bmp":
            case "image/png":
                return true;
            default:
                return false;
        }
    }

    public static Handler B(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static boolean B0(int i3) {
        return i3 == 21 || i3 == 1342177280 || i3 == 22 || i3 == 1610612736 || i3 == 4;
    }

    public static Handler C() {
        return D(null);
    }

    public static boolean C0(int i3) {
        return i3 == 3 || i3 == 2 || i3 == 268435456 || i3 == 21 || i3 == 1342177280 || i3 == 22 || i3 == 1610612736 || i3 == 4;
    }

    public static Handler D(Handler.Callback callback) {
        return B((Looper) Assertions.i(Looper.myLooper()), callback);
    }

    public static boolean D0(Context context) {
        int i3 = f41609a;
        if (i3 < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        if (i3 == 30) {
            String str = Build.MODEL;
            if (Ascii.a(str, "moto g(20)") || Ascii.a(str, "rmx3231")) {
                return true;
            }
        }
        return i3 == 34 && Ascii.a(Build.MODEL, "sm-x200");
    }

    public static Handler E() {
        return F(null);
    }

    public static boolean E0(int i3) {
        return i3 == 10 || i3 == 13;
    }

    public static Handler F(Handler.Callback callback) {
        return B(Y(), callback);
    }

    public static boolean F0(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    private static HashMap G() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap map = new HashMap(iSOLanguages.length + f41621m.length);
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
            String[] strArr = f41621m;
            if (i3 >= strArr.length) {
                return map;
            }
            map.put(strArr[i3], strArr[i3 + 1]);
            i3 += 2;
        }
    }

    public static boolean G0() {
        String strE = Ascii.e(Build.DEVICE);
        return strE.contains("emulator") || strE.contains("emu64a") || strE.contains("emu64x") || strE.contains("generic");
    }

    public static ByteBuffer H(ByteBuffer byteBuffer) {
        return byteBuffer.asReadOnlyBuffer().order(byteBuffer.order());
    }

    public static boolean H0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static long I(long j3, int i3) {
        return b1(j3, i3, 1000000L, RoundingMode.UP);
    }

    public static boolean I0(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static String J(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int J0(int[] iArr, int i3) {
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (iArr[i4] == i3) {
                return i4;
            }
        }
        return -1;
    }

    public static String K(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static String K0(Context context, String str) {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            return K(ByteStreams.j(inputStreamOpen));
        } finally {
            o(inputStreamOpen);
        }
    }

    public static String L(byte[] bArr, int i3, int i4) {
        return new String(bArr, i3, i4, StandardCharsets.UTF_8);
    }

    public static boolean L0(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, Inflater inflater) {
        return parsableByteArray.a() > 0 && parsableByteArray.j() == 120 && x0(parsableByteArray, parsableByteArray2, inflater);
    }

    public static int M(Context context) {
        return AudioManagerCompat.c(context).generateAudioSessionId();
    }

    private static String M0(String str) {
        int i3 = 0;
        while (true) {
            String[] strArr = f41622n;
            if (i3 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i3])) {
                return strArr[i3 + 1] + str.substring(strArr[i3].length());
            }
            i3 += 2;
        }
    }

    public static int N(int i3) {
        if (i3 == 20) {
            return 30;
        }
        if (i3 == 22) {
            return 31;
        }
        if (i3 == 30) {
            return 34;
        }
        switch (i3) {
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 21;
            case 7:
            case 8:
                return 23;
            case 9:
            case 10:
            case 11:
            case 12:
                return 28;
            default:
                switch (i3) {
                    case 14:
                        return 25;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        return 28;
                    default:
                        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
        }
    }

    public static long N0(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() == 0) {
            throw new NoSuchElementException();
        }
        long jMin = Long.MAX_VALUE;
        for (int i3 = 0; i3 < sparseLongArray.size(); i3++) {
            jMin = Math.min(jMin, sparseLongArray.valueAt(i3));
        }
        return jMin;
    }

    public static AudioFormat O(int i3, int i4, int i5) {
        return new AudioFormat.Builder().setSampleRate(i3).setChannelMask(i4).setEncoding(i5).build();
    }

    public static void O0(List list, int i3, int i4, int i5) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i6 = (i4 - i3) - 1; i6 >= 0; i6--) {
            arrayDeque.addFirst(list.remove(i3 + i6));
        }
        list.addAll(Math.min(i5, list.size()), arrayDeque);
    }

    public static int P(int i3) {
        if (i3 == 10) {
            return f41609a >= 32 ? 737532 : 6396;
        }
        if (i3 == 12) {
            return 743676;
        }
        if (i3 == 24) {
            return f41609a >= 32 ? 67108860 : 0;
        }
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
                return 6396;
            default:
                return 0;
        }
    }

    public static long P0(long j3) {
        return (j3 == -9223372036854775807L || j3 == Long.MIN_VALUE) ? j3 : j3 * 1000;
    }

    public static String Q(int i3) {
        if (i3 == 0) {
            return "undefined";
        }
        if (i3 == 1) {
            return "original";
        }
        if (i3 == 2) {
            return "depth-linear";
        }
        if (i3 == 3) {
            return "depth-inverse";
        }
        if (i3 == 4) {
            return "depth metadata";
        }
        throw new IllegalStateException("Unsupported auxiliary track type");
    }

    public static ExecutorService Q0(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: androidx.media3.common.util.n
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return Util.d(str, runnable);
            }
        });
    }

    public static Player.Commands R(Player player, Player.Commands commands) {
        boolean zF = player.f();
        boolean zA0 = player.a0();
        boolean zS = player.S();
        boolean zT = player.t();
        boolean zP0 = player.p0();
        boolean zA = player.A();
        boolean zQ = player.E().q();
        boolean z2 = false;
        Player.Commands.Builder builderD = new Player.Commands.Builder().b(commands).d(4, !zF).d(5, zA0 && !zF).d(6, zS && !zF).d(7, !zQ && (zS || !zP0 || zA0) && !zF).d(8, zT && !zF).d(9, !zQ && (zT || (zP0 && zA)) && !zF).d(10, !zF).d(11, zA0 && !zF);
        if (zA0 && !zF) {
            z2 = true;
        }
        return builderD.d(12, z2).e();
    }

    public static ScheduledExecutorService R0(final String str) {
        return Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: androidx.media3.common.util.o
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return Util.c(str, runnable);
            }
        });
    }

    public static int S(ByteBuffer byteBuffer, int i3) {
        int i4 = byteBuffer.getInt(i3);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i4 : Integer.reverseBytes(i4);
    }

    public static String S0(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals("und")) {
            str = strReplace;
        }
        String strE = Ascii.e(str);
        String str2 = i1(strE, "-")[0];
        if (f41620l == null) {
            f41620l = G();
        }
        String str3 = (String) f41620l.get(str2);
        if (str3 != null) {
            strE = str3 + strE.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? M0(strE) : strE;
    }

    public static int T(int i3) {
        if (i3 != 2) {
            if (i3 == 3) {
                return 1;
            }
            if (i3 != 4) {
                if (i3 != 21) {
                    if (i3 != 22) {
                        if (i3 != 268435456) {
                            if (i3 != 1342177280) {
                                if (i3 != 1610612736) {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                }
                return 3;
            }
            return 4;
        }
        return 2;
    }

    public static Object[] T0(Object[] objArr, Object[] objArr2) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + objArr2.length);
        System.arraycopy(objArr2, 0, objArrCopyOf, objArr.length, objArr2.length);
        return objArrCopyOf;
    }

    public static String U(String str, int i3) {
        String[] strArrJ1 = j1(str);
        if (strArrJ1.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrJ1) {
            if (i3 == MimeTypes.m(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static Object[] U0(Object[] objArr, int i3) {
        Assertions.a(i3 <= objArr.length);
        return Arrays.copyOf(objArr, i3);
    }

    public static String V(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return Ascii.g(networkCountryIso);
            }
        }
        return Ascii.g(Locale.getDefault().getCountry());
    }

    public static Object[] V0(Object[] objArr, int i3, int i4) {
        Assertions.a(i3 >= 0);
        Assertions.a(i4 <= objArr.length);
        return Arrays.copyOfRange(objArr, i3, i4);
    }

    public static Point W(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display == null) {
            display = ((WindowManager) Assertions.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return X(context, display);
    }

    public static boolean W0(Handler handler, Runnable runnable) {
        Looper looper = handler.getLooper();
        if (!looper.getThread().isAlive()) {
            return false;
        }
        if (looper != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static Point X(Context context, Display display) {
        if (display.getDisplayId() == 0 && H0(context)) {
            String strR0 = f41609a < 28 ? r0("sys.display-size") : r0("vendor.display-size");
            if (!TextUtils.isEmpty(strR0)) {
                try {
                    String[] strArrH1 = h1(strR0.trim(), "x");
                    if (strArrH1.length == 2) {
                        int i3 = Integer.parseInt(strArrH1[0]);
                        int i4 = Integer.parseInt(strArrH1[1]);
                        if (i3 > 0 && i4 > 0) {
                            return new Point(i3, i4);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                Log.d("Util", "Invalid display size: " + strR0);
            }
            if ("Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        if (f41609a >= 23) {
            Z(display, point);
        } else {
            display.getRealSize(point);
        }
        return point;
    }

    public static void X0(List list, int i3, int i4) {
        if (i3 < 0 || i4 > list.size() || i3 > i4) {
            throw new IllegalArgumentException();
        }
        if (i3 != i4) {
            list.subList(i3, i4).clear();
        }
    }

    public static Looper Y() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static long Y0(long j3, int i3) {
        return b1(j3, 1000000L, i3, RoundingMode.DOWN);
    }

    private static void Z(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static long Z0(long j3, long j4, long j5) {
        return b1(j3, j4, j5, RoundingMode.DOWN);
    }

    public static /* synthetic */ void a(SettableFuture settableFuture, ListenableFuture listenableFuture) {
        if (settableFuture.isCancelled()) {
            listenableFuture.cancel(false);
        }
    }

    public static int a0(int i3) {
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

    public static void a1(long[] jArr, long j3, long j4) {
        d1(jArr, j3, j4, RoundingMode.DOWN);
    }

    public static /* synthetic */ void b(ListenableFuture listenableFuture, SettableFuture settableFuture, AsyncFunction asyncFunction) {
        try {
            try {
                settableFuture.D(asyncFunction.apply(Futures.c(listenableFuture)));
            } catch (Throwable th) {
                settableFuture.C(th);
            }
        } catch (Error e3) {
            e = e3;
            settableFuture.C(e);
        } catch (CancellationException unused) {
            settableFuture.cancel(false);
        } catch (RuntimeException e4) {
            e = e4;
            settableFuture.C(e);
        } catch (ExecutionException e5) {
            e = e5;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            settableFuture.C(e);
        }
    }

    public static int b0(String str) {
        String[] strArrH1;
        int length;
        int i3 = 0;
        if (str == null || (length = (strArrH1 = h1(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = strArrH1[length - 1];
        boolean z2 = length >= 3 && "neg".equals(strArrH1[length - 2]);
        try {
            i3 = Integer.parseInt((String) Assertions.e(str2));
            if (z2) {
                return -i3;
            }
        } catch (NumberFormatException unused) {
        }
        return i3;
    }

    public static long b1(long j3, long j4, long j5, RoundingMode roundingMode) {
        if (j3 == 0 || j4 == 0) {
            return 0L;
        }
        return (j5 < j4 || j5 % j4 != 0) ? (j5 >= j4 || j4 % j5 != 0) ? (j5 < j3 || j5 % j3 != 0) ? (j5 >= j3 || j3 % j5 != 0) ? c1(j3, j4, j5, roundingMode) : LongMath.e(j4, LongMath.b(j3, j5, RoundingMode.UNNECESSARY)) : LongMath.b(j4, LongMath.b(j5, j3, RoundingMode.UNNECESSARY), roundingMode) : LongMath.e(j3, LongMath.b(j4, j5, RoundingMode.UNNECESSARY)) : LongMath.b(j3, LongMath.b(j5, j4, RoundingMode.UNNECESSARY), roundingMode);
    }

    public static /* synthetic */ Thread c(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static String c0(int i3) {
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

    private static long c1(long j3, long j4, long j5, RoundingMode roundingMode) {
        long jE = LongMath.e(j3, j4);
        if (jE != Long.MAX_VALUE && jE != Long.MIN_VALUE) {
            return LongMath.b(jE, j5, roundingMode);
        }
        long jC = LongMath.c(Math.abs(j4), Math.abs(j5));
        RoundingMode roundingMode2 = RoundingMode.UNNECESSARY;
        long jB = LongMath.b(j4, jC, roundingMode2);
        long jB2 = LongMath.b(j5, jC, roundingMode2);
        long jC2 = LongMath.c(Math.abs(j3), Math.abs(jB2));
        long jB3 = LongMath.b(j3, jC2, roundingMode2);
        long jB4 = LongMath.b(jB2, jC2, roundingMode2);
        long jE2 = LongMath.e(jB3, jB);
        if (jE2 != Long.MAX_VALUE && jE2 != Long.MIN_VALUE) {
            return LongMath.b(jE2, jB4, roundingMode);
        }
        double d3 = jB3 * (jB / jB4);
        if (d3 > 9.223372036854776E18d) {
            return Long.MAX_VALUE;
        }
        if (d3 < -9.223372036854776E18d) {
            return Long.MIN_VALUE;
        }
        return DoubleMath.f(d3, roundingMode);
    }

    public static /* synthetic */ Thread d(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static String d0(Locale locale) {
        return locale.toLanguageTag();
    }

    public static void d1(long[] jArr, long j3, long j4, RoundingMode roundingMode) {
        if (j3 == 0) {
            Arrays.fill(jArr, 0L);
            return;
        }
        int i3 = 0;
        if (j4 >= j3 && j4 % j3 == 0) {
            long jB = LongMath.b(j4, j3, RoundingMode.UNNECESSARY);
            while (i3 < jArr.length) {
                jArr[i3] = LongMath.b(jArr[i3], jB, roundingMode);
                i3++;
            }
            return;
        }
        if (j4 < j3 && j3 % j4 == 0) {
            long jB2 = LongMath.b(j3, j4, RoundingMode.UNNECESSARY);
            while (i3 < jArr.length) {
                jArr[i3] = LongMath.e(jArr[i3], jB2);
                i3++;
            }
            return;
        }
        for (int i4 = 0; i4 < jArr.length; i4++) {
            long j5 = jArr[i4];
            if (j5 != 0) {
                if (j4 >= j5 && j4 % j5 == 0) {
                    jArr[i4] = LongMath.b(j3, LongMath.b(j4, j5, RoundingMode.UNNECESSARY), roundingMode);
                } else if (j4 >= j5 || j5 % j4 != 0) {
                    jArr[i4] = c1(j5, j3, j4, roundingMode);
                } else {
                    jArr[i4] = LongMath.e(j3, LongMath.b(j5, j4, RoundingMode.UNNECESSARY));
                }
            }
        }
    }

    public static long e(long j3, long j4, long j5) {
        long j6 = j3 + j4;
        return ((j3 ^ j6) & (j4 ^ j6)) < 0 ? j5 : j6;
    }

    public static int e0(Context context) {
        return D0(context) ? 1 : 5;
    }

    public static void e1(Service service, int i3, Notification notification, int i4, String str) {
        if (f41609a >= 29) {
            Api29.a(service, i3, notification, i4, str);
        } else {
            service.startForeground(i3, notification);
        }
    }

    public static int f(long[] jArr, long j3, boolean z2, boolean z3) {
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

    public static long f0(long j3, float f3) {
        return f3 == 1.0f ? j3 : Math.round(j3 * ((double) f3));
    }

    public static void f1(Throwable th) throws Throwable {
        g1(th);
    }

    public static int g(LongArray longArray, long j3, boolean z2, boolean z3) {
        int i3;
        int iD = longArray.d() - 1;
        int i4 = 0;
        while (i4 <= iD) {
            int i5 = (i4 + iD) >>> 1;
            if (longArray.c(i5) < j3) {
                i4 = i5 + 1;
            } else {
                iD = i5 - 1;
            }
        }
        if (z2 && (i3 = iD + 1) < longArray.d() && longArray.c(i3) == j3) {
            return i3;
        }
        if (z3 && iD == -1) {
            return 0;
        }
        return iD;
    }

    public static long g0(long j3) {
        return j3 == -9223372036854775807L ? System.currentTimeMillis() : android.os.SystemClock.elapsedRealtime() + j3;
    }

    public static int h(List list, Comparable comparable, boolean z2, boolean z3) {
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

    public static int h0(int i3) {
        if (i3 == 8) {
            return 3;
        }
        if (i3 == 16) {
            return 2;
        }
        if (i3 != 24) {
            return i3 != 32 ? 0 : 22;
        }
        return 21;
    }

    public static String[] h1(String str, String str2) {
        return str.split(str2, -1);
    }

    public static int i(int[] iArr, int i3, boolean z2, boolean z3) {
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

    public static Format i0(int i3, int i4, int i5) {
        return new Format.Builder().u0("audio/raw").R(i4).v0(i5).o0(i3).N();
    }

    public static String[] i1(String str, String str2) {
        return str.split(str2, 2);
    }

    public static int j(long[] jArr, long j3, boolean z2, boolean z3) {
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

    public static Format j0(AudioProcessor.AudioFormat audioFormat) {
        return i0(audioFormat.f41289c, audioFormat.f41288b, audioFormat.f41287a);
    }

    public static String[] j1(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : h1(str.trim(), "(\\s*,\\s*)");
    }

    public static int k0(int i3, int i4) {
        return T(i3) * i4;
    }

    public static ComponentName k1(Context context, Intent intent) {
        return f41609a >= 26 ? context.startForegroundService(intent) : context.startService(intent);
    }

    public static long l0(long j3, float f3) {
        return f3 == 1.0f ? j3 : Math.round(j3 / ((double) f3));
    }

    public static long l1(long j3, long j4, long j5) {
        long j6 = j3 - j4;
        return ((j3 ^ j6) & (j4 ^ j3)) < 0 ? j5 : j6;
    }

    public static int m(int i3, int i4) {
        return ((i3 + i4) - 1) / i4;
    }

    public static List m0(int i3) {
        ArrayList arrayList = new ArrayList();
        if ((i3 & 1) != 0) {
            arrayList.add("main");
        }
        if ((i3 & 2) != 0) {
            arrayList.add("alt");
        }
        if ((i3 & 4) != 0) {
            arrayList.add("supplementary");
        }
        if ((i3 & 8) != 0) {
            arrayList.add("commentary");
        }
        if ((i3 & 16) != 0) {
            arrayList.add("dub");
        }
        if ((i3 & 32) != 0) {
            arrayList.add("emergency");
        }
        if ((i3 & 64) != 0) {
            arrayList.add("caption");
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            arrayList.add("subtitle");
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            arrayList.add("sign");
        }
        if ((i3 & 512) != 0) {
            arrayList.add("describes-video");
        }
        if ((i3 & 1024) != 0) {
            arrayList.add("describes-music");
        }
        if ((i3 & 2048) != 0) {
            arrayList.add("enhanced-intelligibility");
        }
        if ((i3 & 4096) != 0) {
            arrayList.add("transcribes-dialog");
        }
        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            arrayList.add("easy-read");
        }
        if ((i3 & 16384) != 0) {
            arrayList.add("trick-play");
        }
        if ((i3 & 32768) != 0) {
            arrayList.add("auxiliary");
        }
        return arrayList;
    }

    public static boolean m1(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    public static long n(long j3, long j4) {
        return ((j3 + j4) - 1) / j4;
    }

    public static List n0(int i3) {
        ArrayList arrayList = new ArrayList();
        if ((i3 & 4) != 0) {
            arrayList.add("auto");
        }
        if ((i3 & 1) != 0) {
            arrayList.add("default");
        }
        if ((i3 & 2) != 0) {
            arrayList.add("forced");
        }
        return arrayList;
    }

    public static byte[] n1(int... iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        int i3 = 0;
        for (int i4 : iArr) {
            bArr[i3] = (byte) (i4 >> 24);
            bArr[i3 + 1] = (byte) (i4 >> 16);
            int i5 = i3 + 3;
            bArr[i3 + 2] = (byte) (i4 >> 8);
            i3 += 4;
            bArr[i5] = (byte) i4;
        }
        return bArr;
    }

    public static void o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String[] o0() {
        String[] strArrP0 = p0();
        for (int i3 = 0; i3 < strArrP0.length; i3++) {
            strArrP0[i3] = S0(strArrP0[i3]);
        }
        return strArrP0;
    }

    public static String o1(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            sb.append(Character.forDigit((bArr[i3] >> 4) & 15, 16));
            sb.append(Character.forDigit(bArr[i3] & com.applovin.exoplayer2.common.base.Ascii.SI, 16));
        }
        return sb.toString();
    }

    public static int p(long j3, long j4) {
        if (j3 < j4) {
            return -1;
        }
        return j3 == j4 ? 0 : 1;
    }

    private static String[] p0() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return f41609a >= 24 ? q0(configuration) : new String[]{d0(configuration.locale)};
    }

    public static long p1(int i3, int i4) {
        return q1(i4) | (q1(i3) << 32);
    }

    public static float q(float f3, float f4, float f5) {
        return Math.max(f4, Math.min(f3, f5));
    }

    private static String[] q0(Configuration configuration) {
        return h1(configuration.getLocales().toLanguageTags(), ",");
    }

    public static long q1(int i3) {
        return ((long) i3) & 4294967295L;
    }

    public static int r(int i3, int i4, int i5) {
        return Math.max(i4, Math.min(i3, i5));
    }

    private static String r0(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e3) {
            Log.e("Util", "Failed to read system property " + str, e3);
            return null;
        }
    }

    public static ListenableFuture r1(final ListenableFuture listenableFuture, final AsyncFunction asyncFunction) {
        final SettableFuture settableFutureF = SettableFuture.F();
        settableFutureF.addListener(new Runnable() { // from class: androidx.media3.common.util.p
            @Override // java.lang.Runnable
            public final void run() {
                Util.a(settableFutureF, listenableFuture);
            }
        }, MoreExecutors.a());
        listenableFuture.addListener(new Runnable() { // from class: androidx.media3.common.util.q
            @Override // java.lang.Runnable
            public final void run() {
                Util.b(listenableFuture, settableFutureF, asyncFunction);
            }
        }, MoreExecutors.a());
        return settableFutureF;
    }

    public static long s(long j3, long j4, long j5) {
        return Math.max(j4, Math.min(j3, j5));
    }

    public static String s0(int i3) {
        switch (i3) {
            case -2:
                return IntegrityManager.INTEGRITY_TYPE_NONE;
            case -1:
                return "unknown";
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO;
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            case 6:
                return "camera motion";
            default:
                if (i3 < 10000) {
                    return "?";
                }
                return "custom (" + i3 + ")";
        }
    }

    public static String s1(String str) {
        int length = str.length();
        int iEnd = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) == '%') {
                i3++;
            }
        }
        if (i3 == 0) {
            return str;
        }
        int i5 = length - (i3 * 2);
        StringBuilder sb = new StringBuilder(i5);
        Matcher matcher = f41618j.matcher(str);
        while (i3 > 0 && matcher.find()) {
            char c3 = (char) Integer.parseInt((String) Assertions.e(matcher.group(1)), 16);
            sb.append((CharSequence) str, iEnd, matcher.start());
            sb.append(c3);
            iEnd = matcher.end();
            i3--;
        }
        if (iEnd < length) {
            sb.append((CharSequence) str, iEnd, length);
        }
        if (sb.length() != i5) {
            return null;
        }
        return sb.toString();
    }

    public static boolean t(SparseArray sparseArray, int i3) {
        return sparseArray.indexOfKey(i3) >= 0;
    }

    public static byte[] t0(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    public static long t1(long j3) {
        return (j3 == -9223372036854775807L || j3 == Long.MIN_VALUE) ? j3 : j3 / 1000;
    }

    public static boolean u(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (Objects.equals(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static int u0(Uri uri) {
        int iV0;
        String scheme = uri.getScheme();
        if (scheme != null && (Ascii.a("rtsp", scheme) || Ascii.a("rtspt", scheme))) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int iLastIndexOf = lastPathSegment.lastIndexOf(46);
        if (iLastIndexOf >= 0 && (iV0 = v0(lastPathSegment.substring(iLastIndexOf + 1))) != 4) {
            return iV0;
        }
        Matcher matcher = f41619k.matcher((CharSequence) Assertions.e(uri.getPath()));
        if (!matcher.matches()) {
            return 4;
        }
        String strGroup = matcher.group(2);
        if (strGroup != null) {
            if (strGroup.contains("format=mpd-time-csf")) {
                return 0;
            }
            if (strGroup.contains("format=m3u8-aapl")) {
                return 2;
            }
        }
        return 1;
    }

    public static boolean v(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null) {
            return sparseArray2 == null;
        }
        if (sparseArray2 == null) {
            return false;
        }
        if (f41609a >= 31) {
            return sparseArray.contentEquals(sparseArray2);
        }
        int size = sparseArray.size();
        if (size != sparseArray2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < size; i3++) {
            if (!Objects.equals(sparseArray.valueAt(i3), sparseArray2.get(sparseArray.keyAt(i3)))) {
                return false;
            }
        }
        return true;
    }

    public static int v0(String str) {
        String strE = Ascii.e(str);
        strE.getClass();
        switch (strE) {
            case "ism":
            case "isml":
                return 1;
            case "mpd":
                return 0;
            case "m3u8":
                return 2;
            default:
                return 4;
        }
    }

    public static int w(SparseArray sparseArray) {
        if (f41609a >= 31) {
            return sparseArray.contentHashCode();
        }
        int iKeyAt = 17;
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            iKeyAt = (((iKeyAt * 31) + sparseArray.keyAt(i3)) * 31) + Objects.hashCode(sparseArray.valueAt(i3));
        }
        return iKeyAt;
    }

    public static int w0(Uri uri, String str) {
        if (str == null) {
            return u0(uri);
        }
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            case "application/x-rtsp":
                return 3;
            default:
                return 4;
        }
    }

    public static int x(byte[] bArr, int i3, int i4, int i5) {
        while (i3 < i4) {
            int iD = UnsignedBytes.d(bArr[i3]);
            i5 = y(iD & 15, y(iD >> 4, i5));
            i3++;
        }
        return i5;
    }

    public static boolean x0(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, Inflater inflater) {
        if (parsableByteArray.a() <= 0) {
            return false;
        }
        if (parsableByteArray2.b() < parsableByteArray.a()) {
            parsableByteArray2.c(parsableByteArray.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(parsableByteArray.e(), parsableByteArray.f(), parsableByteArray.a());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(parsableByteArray2.e(), iInflate, parsableByteArray2.b() - iInflate);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    }
                    if (iInflate == parsableByteArray2.b()) {
                        parsableByteArray2.c(parsableByteArray2.b() * 2);
                    }
                } else {
                    parsableByteArray2.V(iInflate);
                    inflater.reset();
                    return true;
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    private static int y(int i3, int i4) {
        return (f41624p[(i3 ^ ((i4 >> 12) & 255)) & 255] ^ ((i4 << 4) & 65535)) & 65535;
    }

    public static String y0(int i3) {
        return Integer.toString(i3, 36);
    }

    public static int z(byte[] bArr, int i3, int i4, int i5) {
        while (i3 < i4) {
            i5 = f41623o[((i5 >>> 24) ^ (bArr[i3] & 255)) & 255] ^ (i5 << 8);
            i3++;
        }
        return i5;
    }

    public static boolean z0(Context context) {
        return f41609a >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    private static void g1(Throwable th) throws Throwable {
        throw th;
    }

    public static Object k(Object obj) {
        return obj;
    }

    public static Object[] l(Object[] objArr) {
        return objArr;
    }
}
