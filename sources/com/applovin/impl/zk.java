package com.applovin.impl;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.legacy.content.Werj.QgXempTBEfV;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f65442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f65443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f65444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f65445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f65446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f65447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f65448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f65449h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f65451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f65452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f65453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f65454e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f65455f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f65456g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f65457h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f65458i;

        private a(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f65450a = i3;
            this.f65451b = i4;
            this.f65452c = i5;
            this.f65453d = i6;
            this.f65454e = i7;
            this.f65455f = i8;
            this.f65456g = i9;
            this.f65457h = i10;
            this.f65458i = i11;
        }

        public static a a(String str) {
            byte b3;
            String[] strArrSplit = TextUtils.split(str.substring(7), ",");
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                String lowerCase = Ascii.toLowerCase(strArrSplit[i11].trim());
                lowerCase.getClass();
                switch (lowerCase.hashCode()) {
                    case -1178781136:
                        b3 = lowerCase.equals("italic") ? (byte) 0 : (byte) -1;
                        break;
                    case -1026963764:
                        b3 = lowerCase.equals("underline") ? (byte) 1 : (byte) -1;
                        break;
                    case -192095652:
                        b3 = lowerCase.equals("strikeout") ? (byte) 2 : (byte) -1;
                        break;
                    case -70925746:
                        b3 = lowerCase.equals("primarycolour") ? (byte) 3 : (byte) -1;
                        break;
                    case 3029637:
                        b3 = lowerCase.equals(QgXempTBEfV.WcvL) ? (byte) 4 : (byte) -1;
                        break;
                    case 3373707:
                        b3 = lowerCase.equals("name") ? (byte) 5 : (byte) -1;
                        break;
                    case 366554320:
                        b3 = lowerCase.equals("fontsize") ? (byte) 6 : (byte) -1;
                        break;
                    case 1767875043:
                        b3 = lowerCase.equals("alignment") ? (byte) 7 : (byte) -1;
                        break;
                    default:
                        b3 = -1;
                        break;
                }
                switch (b3) {
                    case 0:
                        i8 = i11;
                        break;
                    case 1:
                        i9 = i11;
                        break;
                    case 2:
                        i10 = i11;
                        break;
                    case 3:
                        i5 = i11;
                        break;
                    case 4:
                        i7 = i11;
                        break;
                    case 5:
                        i3 = i11;
                        break;
                    case 6:
                        i6 = i11;
                        break;
                    case 7:
                        i4 = i11;
                        break;
                }
            }
            if (i3 != -1) {
                return new a(i3, i4, i5, i6, i7, i8, i9, i10, strArrSplit.length);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Pattern f65459c = Pattern.compile("\\{([^}]*)\\}");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Pattern f65460d = Pattern.compile(xp.a("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Pattern f65461e = Pattern.compile(xp.a("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Pattern f65462f = Pattern.compile("\\\\an(\\d+)");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f65464b;

        private b(int i3, PointF pointF) {
            this.f65463a = i3;
            this.f65464b = pointF;
        }

        private static int a(String str) {
            Matcher matcher = f65462f.matcher(str);
            if (matcher.find()) {
                return zk.b((String) b1.a((Object) matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = f65459c.matcher(str);
            PointF pointF = null;
            int i3 = -1;
            while (matcher.find()) {
                String str2 = (String) b1.a((Object) matcher.group(1));
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
            return new b(i3, pointF);
        }

        public static String d(String str) {
            return f65459c.matcher(str).replaceAll("");
        }

        private static PointF c(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = f65460d.matcher(str);
            Matcher matcher2 = f65461e.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    oc.c("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + KLAQHFCRAUejH.IplZjrl);
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
            return new PointF(Float.parseFloat(((String) b1.a((Object) strGroup)).trim()), Float.parseFloat(((String) b1.a((Object) strGroup2)).trim()));
        }
    }

    private zk(String str, int i3, Integer num, float f3, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f65442a = str;
        this.f65443b = i3;
        this.f65444c = num;
        this.f65445d = f3;
        this.f65446e = z2;
        this.f65447f = z3;
        this.f65448g = z4;
        this.f65449h = z5;
    }

    private static boolean a(int i3) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(String str) {
        try {
            int i3 = Integer.parseInt(str.trim());
            if (a(i3)) {
                return i3;
            }
        } catch (NumberFormatException unused) {
        }
        oc.d("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    private static boolean c(String str) {
        try {
            int i3 = Integer.parseInt(str);
            return i3 == 1 || i3 == -1;
        } catch (NumberFormatException e3) {
            oc.c("SsaStyle", "Failed to parse boolean value: '" + str + "'", e3);
            return false;
        }
    }

    public static Integer d(String str) {
        try {
            long j3 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            b1.a(j3 <= 4294967295L);
            return Integer.valueOf(Color.argb(tb.a(((j3 >> 24) & 255) ^ 255), tb.a(j3 & 255), tb.a((j3 >> 8) & 255), tb.a((j3 >> 16) & 255)));
        } catch (IllegalArgumentException e3) {
            oc.c("SsaStyle", "Failed to parse color expression: '" + str + "'", e3);
            return null;
        }
    }

    private static float e(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e3) {
            oc.c("SsaStyle", "Failed to parse font size: '" + str + "'", e3);
            return -3.4028235E38f;
        }
    }

    public static zk a(String str, a aVar) {
        boolean z2;
        boolean z3;
        boolean z4;
        b1.a(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i3 = aVar.f65458i;
        if (length != i3) {
            oc.d("SsaStyle", xp.a("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i3), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[aVar.f65450a].trim();
            int i4 = aVar.f65451b;
            int iB = i4 != -1 ? b(strArrSplit[i4].trim()) : -1;
            int i5 = aVar.f65452c;
            Integer numD = i5 != -1 ? d(strArrSplit[i5].trim()) : null;
            int i6 = aVar.f65453d;
            float fE = i6 != -1 ? e(strArrSplit[i6].trim()) : -3.4028235E38f;
            int i7 = aVar.f65454e;
            boolean z5 = false;
            boolean z6 = true;
            if (i7 == -1 || !c(strArrSplit[i7].trim())) {
                z2 = false;
            } else {
                z2 = false;
                z5 = true;
            }
            int i8 = aVar.f65455f;
            if (i8 == -1 || !c(strArrSplit[i8].trim())) {
                z3 = true;
                z6 = z2;
            } else {
                z3 = true;
            }
            int i9 = aVar.f65456g;
            if (i9 == -1 || !c(strArrSplit[i9].trim())) {
                z4 = z3;
                z3 = z2;
            } else {
                z4 = z3;
            }
            int i10 = aVar.f65457h;
            if (i10 == -1 || !c(strArrSplit[i10].trim())) {
                z4 = z2;
            }
            return new zk(strTrim, iB, numD, fE, z5, z6, z3, z4);
        } catch (RuntimeException e3) {
            oc.c("SsaStyle", "Skipping malformed 'Style:' line: '" + str + KrzujOtzIk.bYmdlW, e3);
            return null;
        }
    }
}
