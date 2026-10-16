package org.threeten.bp.chrono;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class HijrahDate extends ChronoDateImpl<HijrahDate> implements Serializable {
    private static final Integer[] A;
    private static final Integer[] B;
    private static final Integer[] C;
    private static final Integer[] D;
    private static final Integer[] E;
    private static final Integer[] F;
    private static final Integer[] G;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f146260k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f146261l = {0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f146262m = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f146263n = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f146264o = {0, 1, 0, 1, 0, 1, 1};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f146265p = {1, 9999, 11, 51, 5, 29, 354};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f146266q = {1, 9999, 11, 52, 6, 30, 355};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f146267r = {0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final char f146268s;
    private static final long serialVersionUID = -5207853542612002020L;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f146269t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f146270u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final HashMap f146271v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final HashMap f146272w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final HashMap f146273x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Long[] f146274y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Integer[] f146275z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient HijrahEra f146276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient int f146277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f146278d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient int f146279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient int f146280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient DayOfWeek f146281h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f146282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final transient boolean f146283j;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.HijrahDate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146284a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f146284a = iArr;
            try {
                iArr[ChronoField.f146502x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146284a[ChronoField.f146503y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146284a[ChronoField.A.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146284a[ChronoField.E.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146284a[ChronoField.f146499u.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146284a[ChronoField.f146500v.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146284a[ChronoField.f146501w.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f146284a[ChronoField.f146504z.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f146284a[ChronoField.B.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f146284a[ChronoField.C.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f146284a[ChronoField.F.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f146284a[ChronoField.G.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        int[] iArr = {0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};
        f146260k = iArr;
        char c3 = File.separatorChar;
        f146268s = c3;
        f146269t = File.pathSeparator;
        f146270u = "org" + c3 + "threeten" + c3 + "bp" + c3 + "chrono";
        f146271v = new HashMap();
        f146272w = new HashMap();
        f146273x = new HashMap();
        C = new Integer[iArr.length];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr2 = f146260k;
            if (i4 >= iArr2.length) {
                break;
            }
            C[i4] = Integer.valueOf(iArr2[i4]);
            i4++;
        }
        D = new Integer[f146261l.length];
        int i5 = 0;
        while (true) {
            int[] iArr3 = f146261l;
            if (i5 >= iArr3.length) {
                break;
            }
            D[i5] = Integer.valueOf(iArr3[i5]);
            i5++;
        }
        E = new Integer[f146262m.length];
        int i6 = 0;
        while (true) {
            int[] iArr4 = f146262m;
            if (i6 >= iArr4.length) {
                break;
            }
            E[i6] = Integer.valueOf(iArr4[i6]);
            i6++;
        }
        F = new Integer[f146263n.length];
        int i7 = 0;
        while (true) {
            int[] iArr5 = f146263n;
            if (i7 >= iArr5.length) {
                break;
            }
            F[i7] = Integer.valueOf(iArr5[i7]);
            i7++;
        }
        G = new Integer[f146267r.length];
        int i8 = 0;
        while (true) {
            int[] iArr6 = f146267r;
            if (i8 >= iArr6.length) {
                break;
            }
            G[i8] = Integer.valueOf(iArr6[i8]);
            i8++;
        }
        f146274y = new Long[334];
        int i9 = 0;
        while (true) {
            Long[] lArr = f146274y;
            if (i9 >= lArr.length) {
                break;
            }
            lArr[i9] = Long.valueOf(i9 * 10631);
            i9++;
        }
        f146275z = new Integer[f146264o.length];
        int i10 = 0;
        while (true) {
            int[] iArr7 = f146264o;
            if (i10 >= iArr7.length) {
                break;
            }
            f146275z[i10] = Integer.valueOf(iArr7[i10]);
            i10++;
        }
        A = new Integer[f146265p.length];
        int i11 = 0;
        while (true) {
            int[] iArr8 = f146265p;
            if (i11 >= iArr8.length) {
                break;
            }
            A[i11] = Integer.valueOf(iArr8[i11]);
            i11++;
        }
        B = new Integer[f146266q.length];
        while (true) {
            int[] iArr9 = f146266q;
            if (i3 >= iArr9.length) {
                try {
                    B0();
                    return;
                } catch (IOException | ParseException unused) {
                    return;
                }
            } else {
                B[i3] = Integer.valueOf(iArr9[i3]);
                i3++;
            }
        }
    }

    private HijrahDate(long j3) {
        int[] iArrD0 = d0(j3);
        Q(iArrD0[1]);
        P(iArrD0[2]);
        H(iArrD0[3]);
        I(iArrD0[4]);
        this.f146276b = HijrahEra.d(iArrD0[0]);
        int i3 = iArrD0[1];
        this.f146277c = i3;
        this.f146278d = iArrD0[2];
        this.f146279f = iArrD0[3];
        this.f146280g = iArrD0[4];
        this.f146281h = DayOfWeek.l(iArrD0[5]);
        this.f146282i = j3;
        this.f146283j = isLeapYear(i3);
    }

    private static void B0() throws Throwable {
        InputStream inputStreamW = W();
        if (inputStreamW == null) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamW));
            int i3 = 0;
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        bufferedReader2.close();
                        return;
                    } else {
                        i3++;
                        s0(line.trim(), i3);
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static ChronoLocalDate C0(DataInput dataInput) throws IOException {
        return HijrahChronology.f146256f.b(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private static HijrahDate D0(int i3, int i4, int i5) {
        int iH0 = h0(i4 - 1, i3);
        if (i5 > iH0) {
            i5 = iH0;
        }
        return o0(i3, i4, i5);
    }

    private static void G(int i3, int i4, int i5, int i6, int i7) {
        char c3;
        int i8;
        int i9 = 1;
        if (i3 < 1) {
            throw new IllegalArgumentException("startYear < 1");
        }
        if (i5 < 1) {
            throw new IllegalArgumentException("endYear < 1");
        }
        if (i4 >= 0) {
            char c4 = 11;
            if (i4 <= 11) {
                if (i6 < 0 || i6 > 11) {
                    throw new IllegalArgumentException("endMonth < 0 || endMonth > 11");
                }
                if (i5 > 9999) {
                    throw new IllegalArgumentException("endYear > 9999");
                }
                if (i5 < i3) {
                    throw new IllegalArgumentException("startYear > endYear");
                }
                if (i5 == i3 && i6 < i4) {
                    throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
                }
                boolean zIsLeapYear = isLeapYear(i3);
                Integer[] numArr = (Integer[]) f146271v.get(Integer.valueOf(i3));
                if (numArr == null) {
                    if (!zIsLeapYear) {
                        numArr = new Integer[f146260k.length];
                        int i10 = 0;
                        while (true) {
                            int[] iArr = f146260k;
                            if (i10 >= iArr.length) {
                                break;
                            }
                            numArr[i10] = Integer.valueOf(iArr[i10]);
                            i10++;
                        }
                    } else {
                        numArr = new Integer[f146261l.length];
                        int i11 = 0;
                        while (true) {
                            int[] iArr2 = f146261l;
                            if (i11 >= iArr2.length) {
                                break;
                            }
                            numArr[i11] = Integer.valueOf(iArr2[i11]);
                            i11++;
                        }
                    }
                }
                Integer[] numArr2 = new Integer[numArr.length];
                for (int i12 = 0; i12 < 12; i12++) {
                    if (i12 > i4) {
                        numArr2[i12] = Integer.valueOf(numArr[i12].intValue() - i7);
                    } else {
                        Integer num = numArr[i12];
                        num.intValue();
                        numArr2[i12] = num;
                    }
                }
                f146271v.put(Integer.valueOf(i3), numArr2);
                Integer[] numArr3 = (Integer[]) f146272w.get(Integer.valueOf(i3));
                if (numArr3 == null) {
                    if (!zIsLeapYear) {
                        numArr3 = new Integer[f146262m.length];
                        int i13 = 0;
                        while (true) {
                            int[] iArr3 = f146262m;
                            if (i13 >= iArr3.length) {
                                break;
                            }
                            numArr3[i13] = Integer.valueOf(iArr3[i13]);
                            i13++;
                        }
                    } else {
                        numArr3 = new Integer[f146263n.length];
                        int i14 = 0;
                        while (true) {
                            int[] iArr4 = f146263n;
                            if (i14 >= iArr4.length) {
                                break;
                            }
                            numArr3[i14] = Integer.valueOf(iArr4[i14]);
                            i14++;
                        }
                    }
                }
                Integer[] numArr4 = new Integer[numArr3.length];
                for (int i15 = 0; i15 < 12; i15++) {
                    if (i15 == i4) {
                        numArr4[i15] = Integer.valueOf(numArr3[i15].intValue() - i7);
                    } else {
                        Integer num2 = numArr3[i15];
                        num2.intValue();
                        numArr4[i15] = num2;
                    }
                }
                f146272w.put(Integer.valueOf(i3), numArr4);
                if (i3 != i5) {
                    int i16 = i3 - 1;
                    int i17 = i16 / 30;
                    int i18 = i16 % 30;
                    Integer[] numArr5 = (Integer[]) f146273x.get(Integer.valueOf(i17));
                    if (numArr5 == null) {
                        int length = f146267r.length;
                        Integer[] numArr6 = new Integer[length];
                        for (int i19 = 0; i19 < length; i19++) {
                            numArr6[i19] = Integer.valueOf(f146267r[i19]);
                        }
                        numArr5 = numArr6;
                    }
                    for (int i20 = i18 + 1; i20 < f146267r.length; i20++) {
                        numArr5[i20] = Integer.valueOf(numArr5[i20].intValue() - i7);
                    }
                    f146273x.put(Integer.valueOf(i17), numArr5);
                    int i21 = i5 - 1;
                    int i22 = i21 / 30;
                    if (i17 != i22) {
                        int i23 = i17 + 1;
                        while (true) {
                            Long[] lArr = f146274y;
                            if (i23 >= lArr.length) {
                                break;
                            }
                            lArr[i23] = Long.valueOf(lArr[i23].longValue() - ((long) i7));
                            i23++;
                            i9 = i9;
                            c4 = c4;
                        }
                        i8 = i9;
                        c3 = c4;
                        int i24 = i22 + 1;
                        while (true) {
                            Long[] lArr2 = f146274y;
                            if (i24 >= lArr2.length) {
                                break;
                            }
                            lArr2[i24] = Long.valueOf(lArr2[i24].longValue() + ((long) i7));
                            i24++;
                            i22 = i22;
                        }
                    } else {
                        i8 = 1;
                        c3 = 11;
                    }
                    int i25 = i22;
                    int i26 = i21 % 30;
                    Integer[] numArr7 = (Integer[]) f146273x.get(Integer.valueOf(i25));
                    if (numArr7 == null) {
                        int length2 = f146267r.length;
                        Integer[] numArr8 = new Integer[length2];
                        for (int i27 = 0; i27 < length2; i27++) {
                            numArr8[i27] = Integer.valueOf(f146267r[i27]);
                        }
                        numArr7 = numArr8;
                    }
                    for (int i28 = i26 + i8; i28 < f146267r.length; i28++) {
                        numArr7[i28] = Integer.valueOf(numArr7[i28].intValue() + i7);
                    }
                    f146273x.put(Integer.valueOf(i25), numArr7);
                } else {
                    c3 = 11;
                }
                boolean zIsLeapYear2 = isLeapYear(i5);
                Integer[] numArr9 = (Integer[]) f146271v.get(Integer.valueOf(i5));
                if (numArr9 == null) {
                    if (!zIsLeapYear2) {
                        numArr9 = new Integer[f146260k.length];
                        int i29 = 0;
                        while (true) {
                            int[] iArr5 = f146260k;
                            if (i29 >= iArr5.length) {
                                break;
                            }
                            numArr9[i29] = Integer.valueOf(iArr5[i29]);
                            i29++;
                        }
                    } else {
                        numArr9 = new Integer[f146261l.length];
                        int i30 = 0;
                        while (true) {
                            int[] iArr6 = f146261l;
                            if (i30 >= iArr6.length) {
                                break;
                            }
                            numArr9[i30] = Integer.valueOf(iArr6[i30]);
                            i30++;
                        }
                    }
                }
                Integer[] numArr10 = new Integer[numArr9.length];
                for (int i31 = 0; i31 < 12; i31++) {
                    if (i31 > i6) {
                        numArr10[i31] = Integer.valueOf(numArr9[i31].intValue() + i7);
                    } else {
                        Integer num3 = numArr9[i31];
                        num3.intValue();
                        numArr10[i31] = num3;
                    }
                }
                f146271v.put(Integer.valueOf(i5), numArr10);
                Integer[] numArr11 = (Integer[]) f146272w.get(Integer.valueOf(i5));
                if (numArr11 == null) {
                    if (!zIsLeapYear2) {
                        numArr11 = new Integer[f146262m.length];
                        int i32 = 0;
                        while (true) {
                            int[] iArr7 = f146262m;
                            if (i32 >= iArr7.length) {
                                break;
                            }
                            numArr11[i32] = Integer.valueOf(iArr7[i32]);
                            i32++;
                        }
                    } else {
                        numArr11 = new Integer[f146263n.length];
                        int i33 = 0;
                        while (true) {
                            int[] iArr8 = f146263n;
                            if (i33 >= iArr8.length) {
                                break;
                            }
                            numArr11[i33] = Integer.valueOf(iArr8[i33]);
                            i33++;
                        }
                    }
                }
                Integer[] numArr12 = new Integer[numArr11.length];
                for (int i34 = 0; i34 < 12; i34++) {
                    if (i34 == i6) {
                        numArr12[i34] = Integer.valueOf(numArr11[i34].intValue() + i7);
                    } else {
                        Integer num4 = numArr11[i34];
                        num4.intValue();
                        numArr12[i34] = num4;
                    }
                }
                HashMap map = f146272w;
                map.put(Integer.valueOf(i5), numArr12);
                Integer[] numArr13 = (Integer[]) map.get(Integer.valueOf(i3));
                Integer[] numArr14 = (Integer[]) map.get(Integer.valueOf(i5));
                HashMap map2 = f146271v;
                Integer[] numArr15 = (Integer[]) map2.get(Integer.valueOf(i3));
                Integer[] numArr16 = (Integer[]) map2.get(Integer.valueOf(i5));
                int iIntValue = numArr13[i4].intValue();
                int iIntValue2 = numArr14[i6].intValue();
                int iIntValue3 = numArr15[c3].intValue() + numArr13[c3].intValue();
                int iIntValue4 = numArr16[c3].intValue() + numArr14[c3].intValue();
                Integer[] numArr17 = B;
                int iIntValue5 = numArr17[5].intValue();
                Integer[] numArr18 = A;
                int iIntValue6 = numArr18[5].intValue();
                if (iIntValue5 < iIntValue) {
                    iIntValue5 = iIntValue;
                }
                if (iIntValue5 < iIntValue2) {
                    iIntValue5 = iIntValue2;
                }
                numArr17[5] = Integer.valueOf(iIntValue5);
                if (iIntValue6 <= iIntValue) {
                    iIntValue = iIntValue6;
                }
                if (iIntValue <= iIntValue2) {
                    iIntValue2 = iIntValue;
                }
                numArr18[5] = Integer.valueOf(iIntValue2);
                int iIntValue7 = numArr17[6].intValue();
                int iIntValue8 = numArr18[6].intValue();
                if (iIntValue7 < iIntValue3) {
                    iIntValue7 = iIntValue3;
                }
                if (iIntValue7 < iIntValue4) {
                    iIntValue7 = iIntValue4;
                }
                numArr17[6] = Integer.valueOf(iIntValue7);
                if (iIntValue8 <= iIntValue3) {
                    iIntValue3 = iIntValue8;
                }
                if (iIntValue3 <= iIntValue4) {
                    iIntValue4 = iIntValue3;
                }
                numArr18[6] = Integer.valueOf(iIntValue4);
                return;
            }
        }
        throw new IllegalArgumentException("startMonth < 0 || startMonth > 11");
    }

    private static void H(int i3) {
        if (i3 < 1 || i3 > e0()) {
            throw new DateTimeException("Invalid day of month of Hijrah date, day " + i3 + " greater than " + e0() + " or less than 1");
        }
    }

    private static long H0(int i3) {
        Long lValueOf;
        int i4 = i3 - 1;
        int i5 = i4 / 30;
        int i6 = i4 % 30;
        int iIntValue = R(i5)[Math.abs(i6)].intValue();
        if (i6 < 0) {
            iIntValue = -iIntValue;
        }
        try {
            lValueOf = f146274y[i5];
        } catch (ArrayIndexOutOfBoundsException unused) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            lValueOf = Long.valueOf(i5 * 10631);
        }
        return (lValueOf.longValue() + ((long) iIntValue)) - 492149;
    }

    private static void I(int i3) {
        if (i3 < 1 || i3 > f0()) {
            throw new DateTimeException("Invalid day of year of Hijrah date");
        }
    }

    private static void P(int i3) {
        if (i3 < 1 || i3 > 12) {
            throw new DateTimeException("Invalid month of Hijrah date");
        }
    }

    private static void Q(int i3) {
        if (i3 < 1 || i3 > 9999) {
            throw new DateTimeException("Invalid year of Hijrah Era");
        }
    }

    private static Integer[] R(int i3) {
        Integer[] numArr;
        try {
            numArr = (Integer[]) f146273x.get(Integer.valueOf(i3));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? G : numArr;
    }

    private static Integer[] S(int i3) {
        Integer[] numArr;
        try {
            numArr = (Integer[]) f146271v.get(Integer.valueOf(i3));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? isLeapYear((long) i3) ? D : C : numArr;
    }

    private static Integer[] U(int i3) {
        Integer[] numArr;
        try {
            numArr = (Integer[]) f146272w.get(Integer.valueOf(i3));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? isLeapYear((long) i3) ? F : E : numArr;
    }

    private static InputStream W() {
        ZipFile zipFile;
        String property = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (property == null) {
            property = "hijrah_deviation.cfg";
        }
        String property2 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        if (property2 != null) {
            if (property2.length() != 0 || !property2.endsWith(System.getProperty("file.separator"))) {
                property2 = property2 + System.getProperty("file.separator");
            }
            File file = new File(property2 + f146268s + property);
            if (file.exists()) {
                return new FileInputStream(file);
            }
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.class.path"), f146269t);
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            File file2 = new File(strNextToken);
            if (file2.exists()) {
                if (file2.isDirectory()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(strNextToken);
                    char c3 = f146268s;
                    sb.append(c3);
                    String str = f146270u;
                    sb.append(str);
                    if (new File(sb.toString(), property).exists()) {
                        return new FileInputStream(strNextToken + c3 + str + c3 + property);
                    }
                } else {
                    try {
                        zipFile = new ZipFile(file2);
                    } catch (IOException unused) {
                        zipFile = null;
                    }
                    if (zipFile != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(f146270u);
                        char c4 = f146268s;
                        sb2.append(c4);
                        sb2.append(property);
                        String string = sb2.toString();
                        ZipEntry entry = zipFile.getEntry(string);
                        if (entry == null) {
                            if (c4 == '/') {
                                string = string.replace('/', '\\');
                            } else if (c4 == '\\') {
                                string = string.replace('\\', '/');
                            }
                            entry = zipFile.getEntry(string);
                        }
                        if (entry != null) {
                            return zipFile.getInputStream(entry);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    private static int X(long j3) {
        Long[] lArr = f146274y;
        for (int i3 = 0; i3 < lArr.length; i3++) {
            try {
                if (j3 < lArr[i3].longValue()) {
                    return i3 - 1;
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                return ((int) j3) / 10631;
            }
        }
        return ((int) j3) / 10631;
    }

    private static int Y(long j3, int i3) {
        Long lValueOf;
        try {
            lValueOf = f146274y[i3];
        } catch (ArrayIndexOutOfBoundsException unused) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            lValueOf = Long.valueOf(i3 * 10631);
        }
        return (int) (j3 - lValueOf.longValue());
    }

    private static int Z(int i3, int i4, int i5) {
        int iIntValue;
        Integer[] numArrS = S(i5);
        if (i3 < 0) {
            i3 = isLeapYear((long) i5) ? i3 + 355 : i3 + 354;
            if (i4 <= 0) {
                return i3;
            }
            iIntValue = numArrS[i4].intValue();
        } else {
            if (i4 <= 0) {
                return i3;
            }
            iIntValue = numArrS[i4].intValue();
        }
        return i3 - iIntValue;
    }

    private static int a0(int i3, int i4, int i5) {
        Integer[] numArrR = R(i3);
        return i4 > 0 ? i4 - numArrR[i5].intValue() : numArrR[i5].intValue() + i4;
    }

    private static long c0(int i3, int i4, int i5) {
        return H0(i3) + ((long) h0(i4 - 1, i3)) + ((long) i5);
    }

    private static int[] d0(long j3) {
        int i3;
        int iA0;
        int iK0;
        int iZ;
        int value;
        long j4 = j3 - (-492148);
        if (j4 >= 0) {
            int iX = X(j4);
            int iY = Y(j4, iX);
            int iL0 = l0(iX, iY);
            iA0 = a0(iX, iY, iL0);
            i3 = (iX * 30) + iL0 + 1;
            iK0 = k0(iA0, i3);
            iZ = Z(iA0, iK0, i3) + 1;
            value = HijrahEra.AH.getValue();
        } else {
            int i4 = (int) j4;
            int i5 = i4 / 10631;
            int i6 = i4 % 10631;
            if (i6 == 0) {
                i5++;
                i6 = -10631;
            }
            int iL02 = l0(i5, i6);
            int iA02 = a0(i5, i6, iL02);
            i3 = 1 - ((i5 * 30) - iL02);
            iA0 = isLeapYear((long) i3) ? iA02 + 355 : iA02 + 354;
            iK0 = k0(iA0, i3);
            iZ = Z(iA0, iK0, i3) + 1;
            value = HijrahEra.BEFORE_AH.getValue();
        }
        int i7 = (int) ((j3 - (-492153)) % 7);
        return new int[]{value, i3, iK0 + 1, iZ, iA0 + 1, i7 + (i7 <= 0 ? 7 : 0)};
    }

    static int e0() {
        return B[5].intValue();
    }

    static int f0() {
        return B[6].intValue();
    }

    private static int h0(int i3, int i4) {
        return S(i4)[i3].intValue();
    }

    static int i0(int i3, int i4) {
        return U(i4)[i3].intValue();
    }

    static boolean isLeapYear(long j3) {
        if (j3 <= 0) {
            j3 = -j3;
        }
        return ((j3 * 11) + 14) % 30 < 11;
    }

    private static int k0(int i3, int i4) {
        Integer[] numArrS = S(i4);
        int i5 = 0;
        if (i3 >= 0) {
            while (i5 < numArrS.length) {
                if (i3 < numArrS[i5].intValue()) {
                    return i5 - 1;
                }
                i5++;
            }
            return 11;
        }
        int i6 = isLeapYear((long) i4) ? i3 + 355 : i3 + 354;
        while (i5 < numArrS.length) {
            if (i6 < numArrS[i5].intValue()) {
                return i5 - 1;
            }
            i5++;
        }
        return 11;
    }

    private static int l0(int i3, long j3) {
        Integer[] numArrR = R(i3);
        int i4 = 0;
        if (j3 == 0) {
            return 0;
        }
        if (j3 > 0) {
            while (i4 < numArrR.length) {
                if (j3 < numArrR[i4].intValue()) {
                    return i4 - 1;
                }
                i4++;
            }
            return 29;
        }
        long j4 = -j3;
        while (i4 < numArrR.length) {
            if (j4 <= numArrR[i4].intValue()) {
                return i4 - 1;
            }
            i4++;
        }
        return 29;
    }

    static int m0(int i3) {
        Integer[] numArr;
        int i4 = i3 - 1;
        int i5 = i4 / 30;
        try {
            numArr = (Integer[]) f146273x.get(Integer.valueOf(i5));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr == null) {
            return isLeapYear((long) i3) ? 355 : 354;
        }
        int i6 = i4 % 30;
        if (i6 != 29) {
            return numArr[i6 + 1].intValue() - numArr[i6].intValue();
        }
        Long[] lArr = f146274y;
        return (lArr[i5 + 1].intValue() - lArr[i5].intValue()) - numArr[i6].intValue();
    }

    public static HijrahDate o0(int i3, int i4, int i5) {
        return i3 >= 1 ? q0(HijrahEra.AH, i3, i4, i5) : q0(HijrahEra.BEFORE_AH, 1 - i3, i4, i5);
    }

    static HijrahDate p0(LocalDate localDate) {
        return new HijrahDate(localDate.toEpochDay());
    }

    static HijrahDate q0(HijrahEra hijrahEra, int i3, int i4, int i5) {
        Jdk8Methods.i(hijrahEra, "era");
        Q(i3);
        P(i4);
        H(i5);
        return new HijrahDate(c0(hijrahEra.f(i3), i4, i5));
    }

    static HijrahDate r0(long j3) {
        return new HijrahDate(j3);
    }

    private Object readResolve() {
        return new HijrahDate(this.f146282i);
    }

    private static void s0(String str, int i3) throws ParseException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf(58);
            if (iIndexOf == -1) {
                throw new ParseException("Offset has incorrect format at line " + i3 + ".", i3);
            }
            try {
                int i4 = Integer.parseInt(strNextToken.substring(iIndexOf + 1, strNextToken.length()));
                int iIndexOf2 = strNextToken.indexOf(45);
                if (iIndexOf2 == -1) {
                    throw new ParseException("Start and end year/month has incorrect format at line " + i3 + ".", i3);
                }
                String strSubstring = strNextToken.substring(0, iIndexOf2);
                String strSubstring2 = strNextToken.substring(iIndexOf2 + 1, iIndexOf);
                int iIndexOf3 = strSubstring.indexOf(47);
                int iIndexOf4 = strSubstring2.indexOf(47);
                if (iIndexOf3 == -1) {
                    throw new ParseException("Start year/month has incorrect format at line " + i3 + ".", i3);
                }
                String strSubstring3 = strSubstring.substring(0, iIndexOf3);
                String strSubstring4 = strSubstring.substring(iIndexOf3 + 1, strSubstring.length());
                try {
                    int i5 = Integer.parseInt(strSubstring3);
                    try {
                        int i6 = Integer.parseInt(strSubstring4);
                        if (iIndexOf4 == -1) {
                            throw new ParseException("End year/month has incorrect format at line " + i3 + ".", i3);
                        }
                        String strSubstring5 = strSubstring2.substring(0, iIndexOf4);
                        String strSubstring6 = strSubstring2.substring(iIndexOf4 + 1, strSubstring2.length());
                        try {
                            int i7 = Integer.parseInt(strSubstring5);
                            try {
                                int i8 = Integer.parseInt(strSubstring6);
                                if (i5 == -1 || i6 == -1 || i7 == -1 || i8 == -1) {
                                    throw new ParseException("Unknown error at line " + i3 + ".", i3);
                                }
                                G(i5, i6, i7, i8, i4);
                            } catch (NumberFormatException unused) {
                                throw new ParseException("End month is not properly set at line " + i3 + ".", i3);
                            }
                        } catch (NumberFormatException unused2) {
                            throw new ParseException("End year is not properly set at line " + i3 + ".", i3);
                        }
                    } catch (NumberFormatException unused3) {
                        throw new ParseException("Start month is not properly set at line " + i3 + ".", i3);
                    }
                } catch (NumberFormatException unused4) {
                    throw new ParseException("Start year is not properly set at line " + i3 + ".", i3);
                }
            } catch (NumberFormatException unused5) {
                throw new ParseException("Offset is not properly set at line " + i3 + ".", i3);
            }
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public HijrahDate z(TemporalAdjuster temporalAdjuster) {
        return (HijrahDate) super.z(temporalAdjuster);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public HijrahDate a(TemporalField temporalField, long j3) {
        if (!(temporalField instanceof ChronoField)) {
            return (HijrahDate) temporalField.a(this, j3);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.g(j3);
        int i3 = (int) j3;
        switch (AnonymousClass1.f146284a[chronoField.ordinal()]) {
            case 1:
                return D0(this.f146277c, this.f146278d, i3);
            case 2:
                int i4 = i3 - 1;
                return D0(this.f146277c, (i4 / 30) + 1, (i4 % 30) + 1);
            case 3:
                return D((j3 - m(ChronoField.A)) * 7);
            case 4:
                if (this.f146277c < 1) {
                    i3 = 1 - i3;
                }
                return D0(i3, this.f146278d, this.f146279f);
            case 5:
                return D(j3 - ((long) this.f146281h.getValue()));
            case 6:
                return D(j3 - m(ChronoField.f146500v));
            case 7:
                return D(j3 - m(ChronoField.f146501w));
            case 8:
                return new HijrahDate(i3);
            case 9:
                return D((j3 - m(ChronoField.B)) * 7);
            case 10:
                return D0(this.f146277c, i3, this.f146279f);
            case 11:
                return D0(i3, this.f146278d, this.f146279f);
            case 12:
                return D0(1 - this.f146277c, this.f146278d, this.f146279f);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    void G0(DataOutput dataOutput) {
        dataOutput.writeInt(j(ChronoField.F));
        dataOutput.writeByte(j(ChronoField.C));
        dataOutput.writeByte(j(ChronoField.f146502x));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public HijrahChronology s() {
        return HijrahChronology.f146256f;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public HijrahEra t() {
        return this.f146276b;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        if (g(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i3 = AnonymousClass1.f146284a[chronoField.ordinal()];
            return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? s().w(chronoField) : ValueRange.i(1L, 1000L) : ValueRange.i(1L, 5L) : ValueRange.i(1L, lengthOfYear()) : ValueRange.i(1L, lengthOfMonth());
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ long i(Temporal temporal, TemporalUnit temporalUnit) {
        return super.i(temporal, temporalUnit);
    }

    public int lengthOfMonth() {
        return i0(this.f146278d - 1, this.f146277c);
    }

    public int lengthOfYear() {
        return m0(this.f146277c);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        int value;
        int i3;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        switch (AnonymousClass1.f146284a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                value = this.f146279f;
                return value;
            case 2:
                value = this.f146280g;
                return value;
            case 3:
                i3 = (this.f146279f - 1) / 7;
                value = i3 + 1;
                return value;
            case 4:
                value = this.f146277c;
                return value;
            case 5:
                value = this.f146281h.getValue();
                return value;
            case 6:
                i3 = (this.f146279f - 1) % 7;
                value = i3 + 1;
                return value;
            case 7:
                i3 = (this.f146280g - 1) % 7;
                value = i3 + 1;
                return value;
            case 8:
                return toEpochDay();
            case 9:
                i3 = (this.f146280g - 1) / 7;
                value = i3 + 1;
                return value;
            case 10:
                value = this.f146278d;
                return value;
            case 11:
                value = this.f146277c;
                return value;
            case 12:
                value = this.f146276b.getValue();
                return value;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public HijrahDate t(long j3, TemporalUnit temporalUnit) {
        return (HijrahDate) super.t(j3, temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    public final ChronoLocalDateTime q(LocalTime localTime) {
        return super.q(localTime);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public HijrahDate u(long j3, TemporalUnit temporalUnit) {
        return (HijrahDate) super.u(j3, temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        return c0(this.f146277c, this.f146278d, this.f146279f);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public HijrahDate y(TemporalAmount temporalAmount) {
        return (HijrahDate) super.y(temporalAmount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public HijrahDate D(long j3) {
        return new HijrahDate(this.f146282i + j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public HijrahDate E(long j3) {
        if (j3 == 0) {
            return this;
        }
        int i3 = (this.f146278d - 1) + ((int) j3);
        int iO = i3 / 12;
        int i4 = i3 % 12;
        while (i4 < 0) {
            i4 += 12;
            iO = Jdk8Methods.o(iO, 1);
        }
        return q0(this.f146276b, Jdk8Methods.j(this.f146277c, iO), i4 + 1, this.f146279f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public HijrahDate F(long j3) {
        if (j3 == 0) {
            return this;
        }
        return q0(this.f146276b, Jdk8Methods.j(this.f146277c, (int) j3), this.f146278d, this.f146279f);
    }
}
