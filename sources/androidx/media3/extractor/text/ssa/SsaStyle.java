package androidx.media3.extractor.text.ssa;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;
import com.google.common.primitives.Ints;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
final class SsaStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f47153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f47154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f47155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f47156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f47157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f47158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f47159i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f47160j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static final class Format {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f47163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f47164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f47165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f47166f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f47167g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f47168h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f47169i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f47170j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f47171k;

        private Format(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
            this.f47161a = i3;
            this.f47162b = i4;
            this.f47163c = i5;
            this.f47164d = i6;
            this.f47165e = i7;
            this.f47166f = i8;
            this.f47167g = i9;
            this.f47168h = i10;
            this.f47169i = i11;
            this.f47170j = i12;
            this.f47171k = i13;
        }

        public static Format a(String str) {
            String[] strArrSplit = TextUtils.split(str.substring(7), ",");
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            for (int i13 = 0; i13 < strArrSplit.length; i13++) {
                String strE = Ascii.e(strArrSplit[i13].trim());
                strE.getClass();
                switch (strE) {
                    case "italic":
                        i9 = i13;
                        break;
                    case "underline":
                        i10 = i13;
                        break;
                    case "strikeout":
                        i11 = i13;
                        break;
                    case "primarycolour":
                        i5 = i13;
                        break;
                    case "bold":
                        i8 = i13;
                        break;
                    case "name":
                        i3 = i13;
                        break;
                    case "fontsize":
                        i7 = i13;
                        break;
                    case "borderstyle":
                        i12 = i13;
                        break;
                    case "alignment":
                        i4 = i13;
                        break;
                    case "outlinecolour":
                        i6 = i13;
                        break;
                }
            }
            if (i3 != -1) {
                return new Format(i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, strArrSplit.length);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static final class Overrides {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Pattern f47172c = Pattern.compile("\\{([^}]*)\\}");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Pattern f47173d = Pattern.compile(Util.J("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Pattern f47174e = Pattern.compile(Util.J("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Pattern f47175f = Pattern.compile("\\\\an(\\d+)");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f47177b;

        private Overrides(int i3, PointF pointF) {
            this.f47176a = i3;
            this.f47177b = pointF;
        }

        private static int a(String str) {
            Matcher matcher = f47175f.matcher(str);
            if (matcher.find()) {
                return SsaStyle.e((String) Assertions.e(matcher.group(1)));
            }
            return -1;
        }

        public static Overrides b(String str) {
            Matcher matcher = f47172c.matcher(str);
            PointF pointF = null;
            int i3 = -1;
            while (matcher.find()) {
                String str2 = (String) Assertions.e(matcher.group(1));
                try {
                    PointF pointFC = c(str2);
                    if (pointFC != null) {
                        pointF = pointFC;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int iA = a(str2);
                    if (iA != -1) {
                        i3 = iA;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new Overrides(i3, pointF);
        }

        private static PointF c(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = f47173d.matcher(str);
            Matcher matcher2 = f47174e.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    Log.g("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) Assertions.e(strGroup)).trim()), Float.parseFloat(((String) Assertions.e(strGroup2)).trim()));
        }

        public static String d(String str) {
            return f47172c.matcher(str).replaceAll("");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaAlignment {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaBorderStyle {
    }

    private SsaStyle(String str, int i3, Integer num, Integer num2, float f3, boolean z2, boolean z3, boolean z4, boolean z5, int i4) {
        this.f47151a = str;
        this.f47152b = i3;
        this.f47153c = num;
        this.f47154d = num2;
        this.f47155e = f3;
        this.f47156f = z2;
        this.f47157g = z3;
        this.f47158h = z4;
        this.f47159i = z5;
        this.f47160j = i4;
    }

    public static SsaStyle b(String str, Format format) {
        boolean z2;
        boolean z3;
        Assertions.a(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i3 = format.f47171k;
        if (length != i3) {
            Log.i("SsaStyle", Util.J("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i3), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[format.f47161a].trim();
            int i4 = format.f47162b;
            int iE = i4 != -1 ? e(strArrSplit[i4].trim()) : -1;
            int i5 = format.f47163c;
            Integer numH = i5 != -1 ? h(strArrSplit[i5].trim()) : null;
            int i6 = format.f47164d;
            Integer numH2 = i6 != -1 ? h(strArrSplit[i6].trim()) : null;
            int i7 = format.f47165e;
            float fI = i7 != -1 ? i(strArrSplit[i7].trim()) : -3.4028235E38f;
            int i8 = format.f47166f;
            boolean z4 = false;
            boolean z5 = true;
            if (i8 == -1 || !f(strArrSplit[i8].trim())) {
                z2 = false;
            } else {
                z2 = false;
                z4 = true;
            }
            int i9 = format.f47167g;
            if (i9 == -1 || !f(strArrSplit[i9].trim())) {
                z3 = true;
                z5 = z2;
            } else {
                z3 = true;
            }
            int i10 = format.f47168h;
            if (i10 == -1 || !f(strArrSplit[i10].trim())) {
                z3 = false;
            }
            int i11 = format.f47169i;
            boolean z6 = i11 != -1 && f(strArrSplit[i11].trim());
            int i12 = format.f47170j;
            return new SsaStyle(strTrim, iE, numH, numH2, fI, z4, z5, z3, z6, i12 != -1 ? g(strArrSplit[i12].trim()) : -1);
        } catch (RuntimeException e3) {
            Log.j("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e3);
            return null;
        }
    }

    private static boolean c(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static boolean d(int i3) {
        return i3 == 1 || i3 == 3;
    }

    private static boolean f(String str) {
        try {
            int i3 = Integer.parseInt(str);
            return i3 == 1 || i3 == -1;
        } catch (NumberFormatException e3) {
            Log.j("SsaStyle", "Failed to parse boolean value: '" + str + "'", e3);
            return false;
        }
    }

    private static int g(String str) {
        try {
            int i3 = Integer.parseInt(str.trim());
            if (d(i3)) {
                return i3;
            }
        } catch (NumberFormatException unused) {
        }
        Log.i("SsaStyle", "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    public static Integer h(String str) {
        try {
            long j3 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            Assertions.a(j3 <= 4294967295L);
            return Integer.valueOf(Color.argb(Ints.d(((j3 >> 24) & 255) ^ 255), Ints.d(j3 & 255), Ints.d((j3 >> 8) & 255), Ints.d((j3 >> 16) & 255)));
        } catch (IllegalArgumentException e3) {
            Log.j("SsaStyle", "Failed to parse color expression: '" + str + "'", e3);
            return null;
        }
    }

    private static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e3) {
            Log.j("SsaStyle", "Failed to parse font size: '" + str + "'", e3);
            return -3.4028235E38f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(String str) {
        try {
            int i3 = Integer.parseInt(str.trim());
            if (c(i3)) {
                return i3;
            }
        } catch (NumberFormatException unused) {
        }
        Log.i(KrzujOtzIk.ClQwTZdTmIWO, "Ignoring unknown alignment: " + str);
        return -1;
    }
}
