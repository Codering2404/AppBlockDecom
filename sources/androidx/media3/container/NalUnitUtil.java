package androidx.media3.container;

import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.math.DoubleMath;
import com.sun.jna.Function;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class NalUnitUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f41674a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f41675b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f41676c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int[] f41677d = new int[10];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class H265LayerInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41679b;

        public H265LayerInfo(int i3, int i4) {
            this.f41678a = i3;
            this.f41679b = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class H265NalHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41682c;

        public H265NalHeader(int i3, int i4, int i5) {
            this.f41680a = i3;
            this.f41681b = i4;
            this.f41682c = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class H265ProfileTierLevel {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f41684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f41687e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f41688f;

        public H265ProfileTierLevel(int i3, boolean z2, int i4, int i5, int[] iArr, int i6) {
            this.f41683a = i3;
            this.f41684b = z2;
            this.f41685c = i4;
            this.f41686d = i5;
            this.f41687e = iArr;
            this.f41688f = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class H265ProfileTierLevelsAndIndices {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableList f41689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f41690b;

        public H265ProfileTierLevelsAndIndices(List list, int[] iArr) {
            this.f41689a = ImmutableList.t(list);
            this.f41690b = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class H265RepFormat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41694d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f41695e;

        public H265RepFormat(int i3, int i4, int i5, int i6, int i7) {
            this.f41691a = i3;
            this.f41692b = i4;
            this.f41693c = i5;
            this.f41694d = i6;
            this.f41695e = i7;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class H265RepFormatsAndIndices {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableList f41696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f41697b;

        public H265RepFormatsAndIndices(List list, int[] iArr) {
            this.f41696a = ImmutableList.t(list);
            this.f41697b = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class H265Sei3dRefDisplayInfoData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41701d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f41702e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f41703f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f41704g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f41705h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f41706i;

        public H265Sei3dRefDisplayInfoData(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f41698a = i3;
            this.f41699b = i4;
            this.f41700c = i5;
            this.f41701d = i6;
            this.f41702e = i7;
            this.f41703f = i8;
            this.f41704g = i9;
            this.f41705h = i10;
            this.f41706i = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class H265SpsData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final H265NalHeader f41707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final H265ProfileTierLevel f41709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f41711e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f41712f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f41713g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f41714h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f41715i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float f41716j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f41717k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f41718l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f41719m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f41720n;

        public H265SpsData(H265NalHeader h265NalHeader, int i3, H265ProfileTierLevel h265ProfileTierLevel, int i4, int i5, int i6, int i7, int i8, int i9, float f3, int i10, int i11, int i12, int i13) {
            this.f41707a = h265NalHeader;
            this.f41708b = i3;
            this.f41709c = h265ProfileTierLevel;
            this.f41710d = i4;
            this.f41711e = i5;
            this.f41712f = i6;
            this.f41713g = i7;
            this.f41714h = i8;
            this.f41715i = i9;
            this.f41716j = f3;
            this.f41717k = i10;
            this.f41718l = i11;
            this.f41719m = i12;
            this.f41720n = i13;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class H265VideoSignalInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41723c;

        public H265VideoSignalInfo(int i3, int i4, int i5) {
            this.f41721a = i3;
            this.f41722b = i4;
            this.f41723c = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class H265VideoSignalInfosAndIndices {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableList f41724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f41725b;

        public H265VideoSignalInfosAndIndices(List list, int[] iArr) {
            this.f41724a = ImmutableList.t(list);
            this.f41725b = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class H265VpsData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final H265NalHeader f41726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImmutableList f41727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final H265ProfileTierLevelsAndIndices f41728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final H265RepFormatsAndIndices f41729d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final H265VideoSignalInfosAndIndices f41730e;

        public H265VpsData(H265NalHeader h265NalHeader, List list, H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices, H265RepFormatsAndIndices h265RepFormatsAndIndices, H265VideoSignalInfosAndIndices h265VideoSignalInfosAndIndices) {
            this.f41726a = h265NalHeader;
            this.f41727b = list != null ? ImmutableList.t(list) : ImmutableList.y();
            this.f41728c = h265ProfileTierLevelsAndIndices;
            this.f41729d = h265RepFormatsAndIndices;
            this.f41730e = h265VideoSignalInfosAndIndices;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class PpsData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f41733c;

        public PpsData(int i3, int i4, boolean z2) {
            this.f41731a = i3;
            this.f41732b = i4;
            this.f41733c = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SpsData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f41738e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f41739f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f41740g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f41741h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f41742i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f41743j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f41744k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f41745l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f41746m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f41747n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f41748o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f41749p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f41750q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f41751r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f41752s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final int f41753t;

        public SpsData(int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f3, int i10, int i11, boolean z2, boolean z3, int i12, int i13, int i14, boolean z4, int i15, int i16, int i17, int i18) {
            this.f41734a = i3;
            this.f41735b = i4;
            this.f41736c = i5;
            this.f41737d = i6;
            this.f41738e = i7;
            this.f41739f = i8;
            this.f41740g = i9;
            this.f41741h = f3;
            this.f41742i = i10;
            this.f41743j = i11;
            this.f41744k = z2;
            this.f41745l = z3;
            this.f41746m = i12;
            this.f41747n = i13;
            this.f41748o = i14;
            this.f41749p = z4;
            this.f41750q = i15;
            this.f41751r = i16;
            this.f41752s = i17;
            this.f41753t = i18;
        }
    }

    public static PpsData A(byte[] bArr, int i3, int i4) {
        return B(bArr, i3 + 1, i4);
    }

    public static PpsData B(byte[] bArr, int i3, int i4) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i3, i4);
        int i5 = parsableNalUnitBitArray.i();
        int i6 = parsableNalUnitBitArray.i();
        parsableNalUnitBitArray.l();
        return new PpsData(i5, i6, parsableNalUnitBitArray.e());
    }

    public static SpsData C(byte[] bArr, int i3, int i4) {
        return D(bArr, i3 + 1, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x021f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.media3.container.NalUnitUtil.SpsData D(byte[] r32, int r33, int r34) {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.NalUnitUtil.D(byte[], int, int):androidx.media3.container.NalUnitUtil$SpsData");
    }

    private static void E(ParsableNalUnitBitArray parsableNalUnitBitArray, int i3, int[] iArr, int[] iArr2, boolean[][] zArr) {
        for (int i4 = 1; i4 < i3; i4++) {
            boolean zE = parsableNalUnitBitArray.e();
            int i5 = 0;
            while (i5 < iArr[i4]) {
                if ((i5 <= 0 || !zE) ? i5 == 0 : parsableNalUnitBitArray.e()) {
                    for (int i6 = 0; i6 < iArr2[i4]; i6++) {
                        if (zArr[i4][i6]) {
                            parsableNalUnitBitArray.i();
                        }
                    }
                    parsableNalUnitBitArray.i();
                    parsableNalUnitBitArray.i();
                }
                i5++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    private static void F(ParsableNalUnitBitArray parsableNalUnitBitArray, boolean z2, int i3) {
        ?? r9;
        ?? r12;
        boolean zE;
        boolean zE2;
        if (z2) {
            boolean zE3 = parsableNalUnitBitArray.e();
            boolean zE4 = parsableNalUnitBitArray.e();
            if (zE3 || zE4) {
                zE = parsableNalUnitBitArray.e();
                if (zE) {
                    parsableNalUnitBitArray.m(19);
                }
                parsableNalUnitBitArray.m(8);
                if (zE) {
                    parsableNalUnitBitArray.m(4);
                }
                parsableNalUnitBitArray.m(15);
                r12 = zE4;
                r9 = zE3;
            } else {
                zE = false;
                r12 = zE4;
                r9 = zE3;
            }
        } else {
            r9 = 0;
            r12 = 0;
            zE = false;
        }
        for (int i4 = 0; i4 <= i3; i4++) {
            boolean zE5 = parsableNalUnitBitArray.e();
            if (!zE5) {
                zE5 = parsableNalUnitBitArray.e();
            }
            if (zE5) {
                parsableNalUnitBitArray.i();
                zE2 = false;
            } else {
                zE2 = parsableNalUnitBitArray.e();
            }
            int i5 = !zE2 ? parsableNalUnitBitArray.i() : 0;
            int i6 = r9 + r12;
            for (int i7 = 0; i7 < i6; i7++) {
                for (int i8 = 0; i8 <= i5; i8++) {
                    parsableNalUnitBitArray.i();
                    parsableNalUnitBitArray.i();
                    if (zE) {
                        parsableNalUnitBitArray.i();
                        parsableNalUnitBitArray.i();
                    }
                    parsableNalUnitBitArray.l();
                }
            }
        }
    }

    private static void G(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = 0;
            while (i4 < 6) {
                int i5 = 1;
                if (parsableNalUnitBitArray.e()) {
                    int iMin = Math.min(64, 1 << ((i3 << 1) + 4));
                    if (i3 > 1) {
                        parsableNalUnitBitArray.h();
                    }
                    for (int i6 = 0; i6 < iMin; i6++) {
                        parsableNalUnitBitArray.h();
                    }
                } else {
                    parsableNalUnitBitArray.i();
                }
                if (i3 == 3) {
                    i5 = 3;
                }
                i4 += i5;
            }
        }
    }

    private static void H(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int i3 = parsableNalUnitBitArray.i();
        int[] iArr = new int[0];
        int[] iArrCopyOf = new int[0];
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < i3; i6++) {
            if (i6 == 0 || !parsableNalUnitBitArray.e()) {
                int i7 = parsableNalUnitBitArray.i();
                int i8 = parsableNalUnitBitArray.i();
                int[] iArr2 = new int[i7];
                int i9 = 0;
                while (i9 < i7) {
                    iArr2[i9] = (i9 > 0 ? iArr2[i9 - 1] : 0) - (parsableNalUnitBitArray.i() + 1);
                    parsableNalUnitBitArray.l();
                    i9++;
                }
                int[] iArr3 = new int[i8];
                int i10 = 0;
                while (i10 < i8) {
                    iArr3[i10] = (i10 > 0 ? iArr3[i10 - 1] : 0) + parsableNalUnitBitArray.i() + 1;
                    parsableNalUnitBitArray.l();
                    i10++;
                }
                i4 = i7;
                iArr = iArr2;
                i5 = i8;
                iArrCopyOf = iArr3;
            } else {
                int i11 = i4 + i5;
                int i12 = (1 - ((parsableNalUnitBitArray.e() ? 1 : 0) * 2)) * (parsableNalUnitBitArray.i() + 1);
                int i13 = i11 + 1;
                boolean[] zArr = new boolean[i13];
                for (int i14 = 0; i14 <= i11; i14++) {
                    if (parsableNalUnitBitArray.e()) {
                        zArr[i14] = true;
                    } else {
                        zArr[i14] = parsableNalUnitBitArray.e();
                    }
                }
                int[] iArr4 = new int[i13];
                int[] iArr5 = new int[i13];
                int i15 = 0;
                for (int i16 = i5 - 1; i16 >= 0; i16--) {
                    int i17 = iArrCopyOf[i16] + i12;
                    if (i17 < 0 && zArr[i4 + i16]) {
                        iArr4[i15] = i17;
                        i15++;
                    }
                }
                if (i12 < 0 && zArr[i11]) {
                    iArr4[i15] = i12;
                    i15++;
                }
                for (int i18 = 0; i18 < i4; i18++) {
                    int i19 = iArr[i18] + i12;
                    if (i19 < 0 && zArr[i18]) {
                        iArr4[i15] = i19;
                        i15++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr4, i15);
                int i20 = 0;
                for (int i21 = i4 - 1; i21 >= 0; i21--) {
                    int i22 = iArr[i21] + i12;
                    if (i22 > 0 && zArr[i21]) {
                        iArr5[i20] = i22;
                        i20++;
                    }
                }
                if (i12 > 0 && zArr[i11]) {
                    iArr5[i20] = i12;
                    i20++;
                }
                for (int i23 = 0; i23 < i5; i23++) {
                    int i24 = iArrCopyOf[i23] + i12;
                    if (i24 > 0 && zArr[i4 + i23]) {
                        iArr5[i20] = i24;
                        i20++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr5, i20);
                iArr = iArrCopyOf2;
                i4 = i15;
                i5 = i20;
            }
        }
    }

    private static void I(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int i3 = parsableNalUnitBitArray.i() + 1;
        parsableNalUnitBitArray.m(8);
        for (int i4 = 0; i4 < i3; i4++) {
            parsableNalUnitBitArray.i();
            parsableNalUnitBitArray.i();
            parsableNalUnitBitArray.l();
        }
        parsableNalUnitBitArray.m(20);
    }

    private static void J(ParsableNalUnitBitArray parsableNalUnitBitArray, int i3) {
        int iH = 8;
        int i4 = 8;
        for (int i5 = 0; i5 < i3; i5++) {
            if (iH != 0) {
                iH = ((parsableNalUnitBitArray.h() + i4) + Function.MAX_NARGS) % Function.MAX_NARGS;
            }
            if (iH != 0) {
                i4 = iH;
            }
        }
    }

    private static void K(ParsableNalUnitBitArray parsableNalUnitBitArray, int i3, boolean[][] zArr) {
        int i4 = parsableNalUnitBitArray.i() + 2;
        if (parsableNalUnitBitArray.e()) {
            parsableNalUnitBitArray.m(i4);
        } else {
            for (int i5 = 1; i5 < i3; i5++) {
                for (int i6 = 0; i6 < i5; i6++) {
                    if (zArr[i5][i6]) {
                        parsableNalUnitBitArray.m(i4);
                    }
                }
            }
        }
        int i7 = parsableNalUnitBitArray.i();
        for (int i8 = 1; i8 <= i7; i8++) {
            parsableNalUnitBitArray.m(8);
        }
    }

    public static int L(byte[] bArr, int i3) {
        int i4;
        synchronized (f41676c) {
            int iG = 0;
            int i5 = 0;
            while (iG < i3) {
                try {
                    iG = g(bArr, iG, i3);
                    if (iG < i3) {
                        int[] iArr = f41677d;
                        if (iArr.length <= i5) {
                            f41677d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f41677d[i5] = iG;
                        iG += 3;
                        i5++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i4 = i3 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = f41677d[i8] - i7;
                System.arraycopy(bArr, i7, bArr, i6, i9);
                int i10 = i6 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i6 = i10 + 2;
                bArr[i11] = 0;
                i7 += i9 + 3;
            }
            System.arraycopy(bArr, i7, bArr, i6, i4 - i6);
        }
        return i4;
    }

    private static int a(int i3, int i4, int i5, int i6) {
        return i3 - ((i4 == 1 ? 2 : 1) * (i5 + i6));
    }

    private static int b(int i3, int i4, int i5, int i6) {
        int i7 = 2;
        if (i4 != 1 && i4 != 2) {
            i7 = 1;
        }
        return i3 - (i7 * (i5 + i6));
    }

    public static void c(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static String d(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.m(4);
        int iF = parsableNalUnitBitArray.f(3);
        parsableNalUnitBitArray.l();
        H265ProfileTierLevel h265ProfileTierLevelQ = q(parsableNalUnitBitArray, true, iF, null);
        return CodecSpecificDataUtil.g(h265ProfileTierLevelQ.f41683a, h265ProfileTierLevelQ.f41684b, h265ProfileTierLevelQ.f41685c, h265ProfileTierLevelQ.f41686d, h265ProfileTierLevelQ.f41687e, h265ProfileTierLevelQ.f41688f);
    }

    public static int e(byte[] bArr, int i3, int i4, boolean[] zArr) {
        int i5 = i4 - i3;
        Assertions.g(i5 >= 0);
        if (i5 == 0) {
            return i4;
        }
        if (zArr[0]) {
            c(zArr);
            return i3 - 3;
        }
        if (i5 > 1 && zArr[1] && bArr[i3] == 1) {
            c(zArr);
            return i3 - 2;
        }
        if (i5 > 2 && zArr[2] && bArr[i3] == 0 && bArr[i3 + 1] == 1) {
            c(zArr);
            return i3 - 1;
        }
        int i6 = i4 - 1;
        int i7 = i3 + 2;
        while (i7 < i6) {
            byte b3 = bArr[i7];
            if ((b3 & 254) == 0) {
                int i8 = i7 - 2;
                if (bArr[i8] == 0 && bArr[i7 - 1] == 0 && b3 == 1) {
                    c(zArr);
                    return i8;
                }
                i7 -= 2;
            }
            i7 += 3;
        }
        zArr[0] = i5 <= 2 ? !(i5 != 2 ? !(zArr[1] && bArr[i6] == 1) : !(zArr[2] && bArr[i4 + (-2)] == 0 && bArr[i6] == 1)) : bArr[i4 + (-3)] == 0 && bArr[i4 + (-2)] == 0 && bArr[i6] == 1;
        zArr[1] = i5 <= 1 ? zArr[2] && bArr[i6] == 0 : bArr[i4 + (-2)] == 0 && bArr[i6] == 0;
        zArr[2] = bArr[i6] == 0;
        return i4;
    }

    private static ImmutableList f(byte[] bArr) {
        boolean[] zArr = new boolean[3];
        ImmutableList.Builder builderO = ImmutableList.o();
        int i3 = 0;
        while (i3 < bArr.length) {
            int iE = e(bArr, i3, bArr.length, zArr);
            if (iE != bArr.length) {
                builderO.a(Integer.valueOf(iE));
            }
            i3 = iE + 3;
        }
        return builderO.m();
    }

    private static int g(byte[] bArr, int i3, int i4) {
        while (i3 < i4 - 2) {
            if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                return i3;
            }
            i3++;
        }
        return i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String h(List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            byte[] bArr = (byte[]) list.get(i3);
            int length = bArr.length;
            if (length > 3) {
                ImmutableList immutableListF = f(bArr);
                for (int i4 = 0; i4 < immutableListF.size(); i4++) {
                    if (((Integer) immutableListF.get(i4)).intValue() + 3 < length) {
                        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, ((Integer) immutableListF.get(i4)).intValue() + 3, length);
                        H265NalHeader h265NalHeaderP = p(parsableNalUnitBitArray);
                        if (h265NalHeaderP.f41680a == 33 && h265NalHeaderP.f41681b == 0) {
                            return d(parsableNalUnitBitArray);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static int i(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 126) >> 1;
    }

    public static int j(byte[] bArr, int i3) {
        return bArr[i3 + 3] & Ascii.US;
    }

    public static boolean k(byte[] bArr, int i3, int i4, Format format) {
        if (Objects.equals(format.f40632o, "video/avc")) {
            return l(bArr[i3]);
        }
        if (Objects.equals(format.f40632o, "video/hevc")) {
            return m(bArr, i3, i4, format);
        }
        return true;
    }

    public static boolean l(byte b3) {
        if (((b3 & 96) >> 5) != 0) {
            return true;
        }
        int i3 = b3 & Ascii.US;
        return (i3 == 1 || i3 == 9 || i3 == 14) ? false : true;
    }

    private static boolean m(byte[] bArr, int i3, int i4, Format format) {
        H265NalHeader h265NalHeaderP = p(new ParsableNalUnitBitArray(bArr, i3, i4 + i3));
        int i5 = h265NalHeaderP.f41680a;
        if (i5 == 35) {
            return false;
        }
        return (i5 <= 14 && i5 % 2 == 0 && h265NalHeaderP.f41682c == format.D - 1) ? false : true;
    }

    public static boolean n(Format format, byte b3) {
        return ((Objects.equals(format.f40632o, "video/avc") || MimeTypes.b(format.f40628k, "video/avc")) && (b3 & Ascii.US) == 6) || ((Objects.equals(format.f40632o, "video/hevc") || MimeTypes.b(format.f40628k, "video/hevc")) && ((b3 & 126) >> 1) == 39);
    }

    public static int o(Format format) {
        if (Objects.equals(format.f40632o, "video/avc")) {
            return 1;
        }
        return (Objects.equals(format.f40632o, "video/hevc") || MimeTypes.b(format.f40628k, "video/hevc")) ? 2 : 0;
    }

    private static H265NalHeader p(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.l();
        return new H265NalHeader(parsableNalUnitBitArray.f(6), parsableNalUnitBitArray.f(6), parsableNalUnitBitArray.f(3) - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.media3.container.NalUnitUtil.H265ProfileTierLevel q(androidx.media3.container.ParsableNalUnitBitArray r19, boolean r20, int r21, androidx.media3.container.NalUnitUtil.H265ProfileTierLevel r22) {
        /*
            r0 = r19
            r1 = r21
            r2 = r22
            r3 = 6
            int[] r4 = new int[r3]
            r5 = 2
            r6 = 8
            r7 = 0
            if (r20 == 0) goto L42
            int r2 = r0.f(r5)
            boolean r8 = r0.e()
            r9 = 5
            int r9 = r0.f(r9)
            r10 = r7
            r11 = r10
        L1e:
            r12 = 32
            if (r10 >= r12) goto L2e
            boolean r12 = r0.e()
            if (r12 == 0) goto L2b
            r12 = 1
            int r12 = r12 << r10
            r11 = r11 | r12
        L2b:
            int r10 = r10 + 1
            goto L1e
        L2e:
            r10 = r7
        L2f:
            if (r10 >= r3) goto L3a
            int r12 = r0.f(r6)
            r4[r10] = r12
            int r10 = r10 + 1
            goto L2f
        L3a:
            r13 = r2
        L3b:
            r17 = r4
            r14 = r8
            r15 = r9
            r16 = r11
            goto L57
        L42:
            if (r2 == 0) goto L50
            int r3 = r2.f41683a
            boolean r8 = r2.f41684b
            int r9 = r2.f41685c
            int r11 = r2.f41686d
            int[] r4 = r2.f41687e
            r13 = r3
            goto L3b
        L50:
            r17 = r4
            r13 = r7
            r14 = r13
            r15 = r14
            r16 = r15
        L57:
            int r18 = r0.f(r6)
            r2 = r7
        L5c:
            if (r7 >= r1) goto L71
            boolean r3 = r0.e()
            if (r3 == 0) goto L66
            int r2 = r2 + 88
        L66:
            boolean r3 = r0.e()
            if (r3 == 0) goto L6e
            int r2 = r2 + 8
        L6e:
            int r7 = r7 + 1
            goto L5c
        L71:
            r0.m(r2)
            if (r1 <= 0) goto L7b
            int r6 = r6 - r1
            int r6 = r6 * r5
            r0.m(r6)
        L7b:
            androidx.media3.container.NalUnitUtil$H265ProfileTierLevel r12 = new androidx.media3.container.NalUnitUtil$H265ProfileTierLevel
            r12.<init>(r13, r14, r15, r16, r17, r18)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.NalUnitUtil.q(androidx.media3.container.ParsableNalUnitBitArray, boolean, int, androidx.media3.container.NalUnitUtil$H265ProfileTierLevel):androidx.media3.container.NalUnitUtil$H265ProfileTierLevel");
    }

    private static H265RepFormat r(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int i3;
        int i4;
        int iF;
        int iF2 = parsableNalUnitBitArray.f(16);
        int iF3 = parsableNalUnitBitArray.f(16);
        if (parsableNalUnitBitArray.e()) {
            int iF4 = parsableNalUnitBitArray.f(2);
            if (iF4 == 3) {
                parsableNalUnitBitArray.l();
            }
            int iF5 = parsableNalUnitBitArray.f(4);
            iF = parsableNalUnitBitArray.f(4);
            i4 = iF5;
            i3 = iF4;
        } else {
            i3 = 0;
            i4 = 0;
            iF = 0;
        }
        if (parsableNalUnitBitArray.e()) {
            int i5 = parsableNalUnitBitArray.i();
            int i6 = parsableNalUnitBitArray.i();
            int i7 = parsableNalUnitBitArray.i();
            int i8 = parsableNalUnitBitArray.i();
            iF2 = b(iF2, i3, i5, i6);
            iF3 = a(iF3, i3, i7, i8);
        }
        return new H265RepFormat(i3, i4, iF, iF2, iF3);
    }

    private static H265RepFormatsAndIndices s(ParsableNalUnitBitArray parsableNalUnitBitArray, int i3) {
        int i4 = parsableNalUnitBitArray.i();
        int i5 = i4 + 1;
        ImmutableList.Builder builderP = ImmutableList.p(i5);
        int[] iArr = new int[i3];
        for (int i6 = 0; i6 < i5; i6++) {
            builderP.a(r(parsableNalUnitBitArray));
        }
        int i7 = 1;
        if (i5 <= 1 || !parsableNalUnitBitArray.e()) {
            while (i7 < i3) {
                iArr[i7] = Math.min(i7, i4);
                i7++;
            }
        } else {
            int iD = DoubleMath.d(i5, RoundingMode.CEILING);
            while (i7 < i3) {
                iArr[i7] = parsableNalUnitBitArray.f(iD);
                i7++;
            }
        }
        return new H265RepFormatsAndIndices(builderP.m(), iArr);
    }

    public static H265Sei3dRefDisplayInfoData t(byte[] bArr, int i3, int i4) {
        byte b3;
        int i5 = i3 + 2;
        do {
            i4--;
            b3 = bArr[i4];
            if (b3 != 0) {
                break;
            }
        } while (i4 > i5);
        if (b3 != 0 && i4 > i5) {
            ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i5, i4 + 1);
            while (parsableNalUnitBitArray.c(16)) {
                int iF = parsableNalUnitBitArray.f(8);
                int i6 = 0;
                while (iF == 255) {
                    i6 += 255;
                    iF = parsableNalUnitBitArray.f(8);
                }
                int i7 = i6 + iF;
                int iF2 = parsableNalUnitBitArray.f(8);
                int i8 = 0;
                while (iF2 == 255) {
                    i8 += 255;
                    iF2 = parsableNalUnitBitArray.f(8);
                }
                int i9 = i8 + iF2;
                if (i9 == 0 || !parsableNalUnitBitArray.c(i9)) {
                    break;
                }
                if (i7 == 176) {
                    int i10 = parsableNalUnitBitArray.i();
                    boolean zE = parsableNalUnitBitArray.e();
                    int i11 = zE ? parsableNalUnitBitArray.i() : 0;
                    int i12 = parsableNalUnitBitArray.i();
                    int i13 = -1;
                    int i14 = -1;
                    int iF3 = -1;
                    int iF4 = -1;
                    int i15 = -1;
                    int iF5 = -1;
                    for (int i16 = 0; i16 <= i12; i16++) {
                        i13 = parsableNalUnitBitArray.i();
                        i14 = parsableNalUnitBitArray.i();
                        iF3 = parsableNalUnitBitArray.f(6);
                        if (iF3 == 63) {
                            return null;
                        }
                        iF4 = parsableNalUnitBitArray.f(iF3 == 0 ? Math.max(0, i10 - 30) : Math.max(0, (iF3 + i10) - 31));
                        if (zE) {
                            int iF6 = parsableNalUnitBitArray.f(6);
                            if (iF6 == 63) {
                                return null;
                            }
                            i15 = iF6;
                            iF5 = parsableNalUnitBitArray.f(iF6 == 0 ? Math.max(0, i11 - 30) : Math.max(0, (iF6 + i11) - 31));
                        }
                        if (parsableNalUnitBitArray.e()) {
                            parsableNalUnitBitArray.m(10);
                        }
                    }
                    return new H265Sei3dRefDisplayInfoData(i10, i11, i12 + 1, i13, i14, iF3, iF4, i15, iF5);
                }
            }
        }
        return null;
    }

    public static H265SpsData u(byte[] bArr, int i3, int i4, H265VpsData h265VpsData) {
        return v(bArr, i3 + 2, i4, p(new ParsableNalUnitBitArray(bArr, i3, i4)), h265VpsData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.media3.container.NalUnitUtil.H265SpsData v(byte[] r17, int r18, int r19, androidx.media3.container.NalUnitUtil.H265NalHeader r20, androidx.media3.container.NalUnitUtil.H265VpsData r21) {
        /*
            Method dump skipped, instruction units count: 603
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.NalUnitUtil.v(byte[], int, int, androidx.media3.container.NalUnitUtil$H265NalHeader, androidx.media3.container.NalUnitUtil$H265VpsData):androidx.media3.container.NalUnitUtil$H265SpsData");
    }

    private static H265VideoSignalInfo w(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.m(3);
        int i3 = parsableNalUnitBitArray.e() ? 1 : 2;
        int iN = ColorInfo.n(parsableNalUnitBitArray.f(8));
        int iO = ColorInfo.o(parsableNalUnitBitArray.f(8));
        parsableNalUnitBitArray.m(8);
        return new H265VideoSignalInfo(iN, i3, iO);
    }

    private static H265VideoSignalInfosAndIndices x(ParsableNalUnitBitArray parsableNalUnitBitArray, int i3, int i4, int[] iArr) {
        if (!parsableNalUnitBitArray.e() ? parsableNalUnitBitArray.e() : true) {
            parsableNalUnitBitArray.l();
        }
        boolean zE = parsableNalUnitBitArray.e();
        boolean zE2 = parsableNalUnitBitArray.e();
        if (zE || zE2) {
            for (int i5 = 0; i5 < i4; i5++) {
                for (int i6 = 0; i6 < iArr[i5]; i6++) {
                    boolean zE3 = zE ? parsableNalUnitBitArray.e() : false;
                    boolean zE4 = zE2 ? parsableNalUnitBitArray.e() : false;
                    if (zE3) {
                        parsableNalUnitBitArray.m(32);
                    }
                    if (zE4) {
                        parsableNalUnitBitArray.m(18);
                    }
                }
            }
        }
        boolean zE5 = parsableNalUnitBitArray.e();
        int iF = zE5 ? parsableNalUnitBitArray.f(4) + 1 : i3;
        ImmutableList.Builder builderP = ImmutableList.p(iF);
        int[] iArr2 = new int[i3];
        for (int i7 = 0; i7 < iF; i7++) {
            builderP.a(w(parsableNalUnitBitArray));
        }
        if (zE5 && iF > 1) {
            for (int i8 = 0; i8 < i3; i8++) {
                iArr2[i8] = parsableNalUnitBitArray.f(4);
            }
        }
        return new H265VideoSignalInfosAndIndices(builderP.m(), iArr2);
    }

    public static H265VpsData y(byte[] bArr, int i3, int i4) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i3, i4);
        return z(parsableNalUnitBitArray, p(parsableNalUnitBitArray));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static H265VpsData z(ParsableNalUnitBitArray parsableNalUnitBitArray, H265NalHeader h265NalHeader) {
        int[] iArr;
        int i3;
        int i4;
        int[] iArr2;
        H265VideoSignalInfosAndIndices h265VideoSignalInfosAndIndicesX;
        int i5;
        int i6;
        int i7;
        int[] iArr3;
        ImmutableList immutableList;
        int i8;
        boolean[][] zArr;
        int[] iArr4;
        int i9;
        int i10;
        parsableNalUnitBitArray.m(4);
        boolean zE = parsableNalUnitBitArray.e();
        boolean zE2 = parsableNalUnitBitArray.e();
        int iF = parsableNalUnitBitArray.f(6);
        int i11 = iF + 1;
        int iF2 = parsableNalUnitBitArray.f(3);
        parsableNalUnitBitArray.m(17);
        H265ProfileTierLevel h265ProfileTierLevelQ = q(parsableNalUnitBitArray, true, iF2, null);
        boolean z2 = false;
        for (int i12 = parsableNalUnitBitArray.e() ? 0 : iF2; i12 <= iF2; i12++) {
            parsableNalUnitBitArray.i();
            parsableNalUnitBitArray.i();
            parsableNalUnitBitArray.i();
        }
        int iF3 = parsableNalUnitBitArray.f(6);
        int i13 = parsableNalUnitBitArray.i() + 1;
        H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices = new H265ProfileTierLevelsAndIndices(ImmutableList.z(h265ProfileTierLevelQ), new int[1]);
        Object[] objArr = i11 >= 2 && i13 >= 2;
        Object[] objArr2 = zE && zE2;
        int i14 = iF3 + 1;
        Object[] objArr3 = i14 >= i11;
        if (objArr != true || objArr2 != true || objArr3 != true) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        Class cls = Integer.TYPE;
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) cls, i13, i14);
        int i15 = 1;
        int[] iArr6 = new int[i13];
        int[] iArr7 = new int[i13];
        iArr5[0][0] = 0;
        iArr6[0] = 1;
        iArr7[0] = 0;
        for (int i16 = 1; i16 < i13; i16++) {
            int i17 = 0;
            for (int i18 = 0; i18 <= iF3; i18++) {
                if (parsableNalUnitBitArray.e()) {
                    iArr5[i16][i17] = i18;
                    iArr7[i16] = i18;
                    i17++;
                }
                iArr6[i16] = i17;
            }
        }
        if (parsableNalUnitBitArray.e()) {
            parsableNalUnitBitArray.m(64);
            if (parsableNalUnitBitArray.e()) {
                parsableNalUnitBitArray.i();
            }
            int i19 = parsableNalUnitBitArray.i();
            int i20 = 0;
            while (i20 < i19) {
                parsableNalUnitBitArray.i();
                if (i20 == 0 || parsableNalUnitBitArray.e()) {
                    z2 = true;
                }
                F(parsableNalUnitBitArray, z2, iF2);
                i20++;
                z2 = false;
            }
        }
        if (!parsableNalUnitBitArray.e()) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        parsableNalUnitBitArray.b();
        H265ProfileTierLevel h265ProfileTierLevelQ2 = q(parsableNalUnitBitArray, false, iF2, h265ProfileTierLevelQ);
        boolean zE3 = parsableNalUnitBitArray.e();
        int i21 = 6;
        boolean[] zArr2 = new boolean[16];
        int i22 = 0;
        for (int i23 = 0; i23 < 16; i23++) {
            boolean zE4 = parsableNalUnitBitArray.e();
            zArr2[i23] = zE4;
            if (zE4) {
                i22++;
            }
        }
        if (i22 == 0 || !zArr2[1]) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int[] iArr8 = new int[i22];
        for (int i24 = 0; i24 < i22 - (zE3 ? 1 : 0); i24++) {
            iArr8[i24] = parsableNalUnitBitArray.f(3);
        }
        int[] iArr9 = new int[i22 + 1];
        if (zE3) {
            int i25 = 1;
            while (i25 < i22) {
                int[] iArr10 = iArr9;
                for (int i26 = 0; i26 < i25; i26++) {
                    iArr10[i25] = iArr10[i25] + iArr8[i26] + 1;
                }
                i25++;
                iArr9 = iArr10;
            }
            iArr = iArr9;
            iArr[i22] = 6;
        } else {
            iArr = iArr9;
        }
        int[][] iArr11 = (int[][]) Array.newInstance((Class<?>) cls, i11, i22);
        int[] iArr12 = new int[i11];
        iArr12[0] = 0;
        boolean zE5 = parsableNalUnitBitArray.e();
        int i27 = 1;
        while (i27 < i11) {
            if (zE5) {
                i10 = i27;
                iArr12[i10] = parsableNalUnitBitArray.f(i21);
            } else {
                i10 = i27;
                iArr12[i10] = i10;
            }
            if (zE3) {
                for (int i28 = 0; i28 < i22; i28++) {
                    iArr11[i10][i28] = (iArr12[i10] & ((1 << iArr[r33]) - 1)) >> iArr[i28];
                }
            } else {
                int i29 = 0;
                while (i29 < i22) {
                    int i30 = i29;
                    iArr11[i10][i30] = parsableNalUnitBitArray.f(iArr8[i29] + 1);
                    i29 = i30 + 1;
                }
            }
            i27 = i10 + 1;
            i21 = 6;
        }
        int[] iArr13 = new int[i14];
        int i31 = 1;
        int i32 = 0;
        while (i32 < i11) {
            iArr13[iArr12[i32]] = -1;
            int[] iArr14 = iArr13;
            int i33 = 0;
            int i34 = 0;
            while (i33 < 16) {
                if (zArr2[i33]) {
                    if (i33 == i15) {
                        iArr14[iArr12[i32]] = iArr11[i32][i34];
                    }
                    i34++;
                }
                i33++;
                i15 = 1;
            }
            if (i32 > 0) {
                int i35 = 0;
                while (true) {
                    if (i35 >= i32) {
                        i31++;
                        break;
                    }
                    int i36 = i35;
                    if (iArr14[iArr12[i32]] == iArr14[iArr12[i35]]) {
                        break;
                    }
                    i35 = i36 + 1;
                }
            }
            i32++;
            iArr13 = iArr14;
            i15 = 1;
        }
        int[] iArr15 = iArr13;
        int iF4 = parsableNalUnitBitArray.f(4);
        if (i31 < 2 || iF4 == 0) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int[] iArr16 = new int[i31];
        for (int i37 = 0; i37 < i31; i37++) {
            iArr16[i37] = parsableNalUnitBitArray.f(iF4);
        }
        int[] iArr17 = new int[i14];
        int i38 = 0;
        while (i38 < i11) {
            int[] iArr18 = iArr17;
            iArr18[Math.min(iArr12[i38], iF3)] = i38;
            i38++;
            iArr17 = iArr18;
        }
        int[] iArr19 = iArr17;
        ImmutableList.Builder builderO = ImmutableList.o();
        int i39 = 0;
        while (i39 <= iF3) {
            int i40 = i31;
            int[] iArr20 = iArr7;
            int iMin = Math.min(iArr15[i39], i40 - 1);
            builderO.a(new H265LayerInfo(iArr19[i39], iMin >= 0 ? iArr16[iMin] : -1));
            i39++;
            i31 = i40;
            iArr7 = iArr20;
            iArr16 = iArr16;
        }
        int[] iArr21 = iArr7;
        ImmutableList immutableListM = builderO.m();
        if (((H265LayerInfo) immutableListM.get(0)).f41679b == -1) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int i41 = 1;
        while (true) {
            if (i41 > iF3) {
                i3 = -1;
                i4 = -1;
                break;
            }
            i3 = -1;
            if (((H265LayerInfo) immutableListM.get(i41)).f41679b != -1) {
                i4 = i41;
                break;
            }
            i41++;
        }
        if (i4 == i3) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        Class cls2 = Boolean.TYPE;
        boolean[][] zArr3 = (boolean[][]) Array.newInstance((Class<?>) cls2, i11, i11);
        boolean[][] zArr4 = (boolean[][]) Array.newInstance((Class<?>) cls2, i11, i11);
        int i42 = 1;
        while (i42 < i11) {
            boolean[][] zArr5 = zArr4;
            for (int i43 = 0; i43 < i42; i43++) {
                boolean[] zArr6 = zArr3[i42];
                boolean[] zArr7 = zArr5[i42];
                boolean zE6 = parsableNalUnitBitArray.e();
                zArr7[i43] = zE6;
                zArr6[i43] = zE6;
            }
            i42++;
            zArr4 = zArr5;
        }
        boolean[][] zArr8 = zArr4;
        for (int i44 = 1; i44 < i11; i44++) {
            int i45 = 0;
            while (i45 < iF) {
                int[] iArr22 = iArr12;
                int i46 = 0;
                while (true) {
                    if (i46 < i44) {
                        boolean[] zArr9 = zArr8[i44];
                        if (zArr9[i46] && zArr8[i46][i45]) {
                            zArr9[i45] = true;
                            break;
                        }
                        i46++;
                    }
                }
                i45++;
                iArr12 = iArr22;
            }
        }
        int[] iArr23 = iArr12;
        int[] iArr24 = new int[i14];
        for (int i47 = 0; i47 < i11; i47++) {
            int i48 = 0;
            for (int i49 = 0; i49 < i47; i49++) {
                i48 += zArr3[i47][i49] ? 1 : 0;
            }
            iArr24[iArr23[i47]] = i48;
        }
        int i50 = 0;
        for (int i51 = 0; i51 < i11; i51++) {
            if (iArr24[iArr23[i51]] == 0) {
                i50++;
            }
        }
        if (i50 > 1) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int[] iArr25 = new int[i11];
        int[] iArr26 = new int[i13];
        if (parsableNalUnitBitArray.e()) {
            iArr2 = iArr24;
            int i52 = 0;
            while (i52 < i11) {
                int i53 = i52;
                iArr25[i53] = parsableNalUnitBitArray.f(3);
                i52 = i53 + 1;
            }
        } else {
            iArr2 = iArr24;
            Arrays.fill(iArr25, 0, i11, iF2);
        }
        int i54 = 0;
        while (i54 < i13) {
            int i55 = i54;
            boolean[][] zArr10 = zArr3;
            int[] iArr27 = iArr25;
            int iMax = 0;
            for (int i56 = 0; i56 < iArr6[i55]; i56++) {
                iMax = Math.max(iMax, iArr27[((H265LayerInfo) immutableListM.get(iArr5[i55][i56])).f41678a]);
            }
            iArr26[i55] = iMax + 1;
            i54 = i55 + 1;
            iArr25 = iArr27;
            zArr3 = zArr10;
        }
        boolean[][] zArr11 = zArr3;
        if (parsableNalUnitBitArray.e()) {
            int i57 = 0;
            while (i57 < iF) {
                int i58 = i57 + 1;
                int i59 = i58;
                while (i59 < i11) {
                    if (zArr11[i59][i57]) {
                        i9 = i57;
                        parsableNalUnitBitArray.m(3);
                    } else {
                        i9 = i57;
                    }
                    i59++;
                    i57 = i9;
                }
                i57 = i58;
            }
        }
        parsableNalUnitBitArray.l();
        int i60 = parsableNalUnitBitArray.i() + 1;
        ImmutableList.Builder builderO2 = ImmutableList.o();
        builderO2.a(h265ProfileTierLevelQ);
        if (i60 > 1) {
            builderO2.a(h265ProfileTierLevelQ2);
            for (int i61 = 2; i61 < i60; i61++) {
                h265ProfileTierLevelQ2 = q(parsableNalUnitBitArray, parsableNalUnitBitArray.e(), iF2, h265ProfileTierLevelQ2);
                builderO2.a(h265ProfileTierLevelQ2);
            }
        }
        ImmutableList immutableListM2 = builderO2.m();
        int i62 = parsableNalUnitBitArray.i() + i13;
        if (i62 > i13) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int iF5 = parsableNalUnitBitArray.f(2);
        boolean[][] zArr12 = (boolean[][]) Array.newInstance((Class<?>) cls2, i62, i14);
        int[] iArr28 = new int[i62];
        int i63 = 0;
        int[] iArr29 = new int[i62];
        int i64 = 0;
        while (i64 < i13) {
            iArr28[i64] = i63;
            iArr29[i64] = iArr21[i64];
            if (iF5 == 0) {
                i8 = i64;
                zArr = zArr12;
                immutableList = immutableListM2;
                iArr4 = iArr28;
                Arrays.fill(zArr12[i8], i63, iArr6[i8], true);
                iArr4[i8] = iArr6[i8];
            } else {
                immutableList = immutableListM2;
                i8 = i64;
                zArr = zArr12;
                iArr4 = iArr28;
                if (iF5 == 1) {
                    int i65 = iArr21[i8];
                    for (int i66 = 0; i66 < iArr6[i8]; i66++) {
                        zArr[i8][i66] = iArr5[i8][i66] == i65;
                    }
                    iArr4[i8] = 1;
                } else {
                    i63 = 0;
                    zArr[0][0] = true;
                    iArr4[0] = 1;
                    i64 = i8 + 1;
                    zArr12 = zArr;
                    iArr28 = iArr4;
                    immutableListM2 = immutableList;
                }
            }
            i63 = 0;
            i64 = i8 + 1;
            zArr12 = zArr;
            iArr28 = iArr4;
            immutableListM2 = immutableList;
        }
        ImmutableList immutableList2 = immutableListM2;
        boolean[][] zArr13 = zArr12;
        int[] iArr30 = iArr28;
        int[] iArr31 = new int[i14];
        int i67 = 2;
        int[] iArr32 = new int[2];
        iArr32[1] = i14;
        iArr32[i63] = i62;
        boolean[][] zArr14 = (boolean[][]) Array.newInstance((Class<?>) cls2, iArr32);
        int i68 = 1;
        int i69 = 0;
        while (i68 < i62) {
            if (iF5 == i67) {
                for (int i70 = 0; i70 < iArr6[i68]; i70++) {
                    zArr13[i68][i70] = parsableNalUnitBitArray.e();
                    int i71 = iArr30[i68];
                    boolean z3 = zArr13[i68][i70];
                    iArr30[i68] = i71 + (z3 ? 1 : 0);
                    if (z3) {
                        iArr29[i68] = iArr5[i68][i70];
                    }
                }
            }
            if (i69 == 0) {
                i5 = 0;
                if (iArr5[i68][0] == 0 && zArr13[i68][0]) {
                    for (int i72 = 1; i72 < iArr6[i68]; i72++) {
                        if (iArr5[i68][i72] == i4 && zArr13[i68][i4]) {
                            i69 = i68;
                        }
                    }
                }
            } else {
                i5 = 0;
            }
            int i73 = i5;
            while (i73 < iArr6[i68]) {
                if (i60 > 1) {
                    zArr14[i68][i73] = zArr13[i68][i73];
                    i7 = i4;
                    iArr3 = iArr31;
                    i6 = i60;
                    int iD = DoubleMath.d(i60, RoundingMode.CEILING);
                    if (!zArr14[i68][i73]) {
                        int i74 = ((H265LayerInfo) immutableListM.get(iArr5[i68][i73])).f41678a;
                        int i75 = i5;
                        while (true) {
                            if (i75 >= i73) {
                                break;
                            }
                            int i76 = i74;
                            if (zArr8[i76][((H265LayerInfo) immutableListM.get(iArr5[i68][i75])).f41678a]) {
                                zArr14[i68][i73] = true;
                                break;
                            }
                            i75++;
                            i74 = i76;
                        }
                    }
                    if (zArr14[i68][i73]) {
                        if (i69 <= 0 || i68 != i69) {
                            parsableNalUnitBitArray.m(iD);
                        } else {
                            iArr3[i73] = parsableNalUnitBitArray.f(iD);
                        }
                    }
                } else {
                    i6 = i60;
                    i7 = i4;
                    iArr3 = iArr31;
                }
                i73++;
                i4 = i7;
                iArr31 = iArr3;
                i60 = i6;
            }
            int i77 = i60;
            int i78 = i4;
            int[] iArr33 = iArr31;
            if (iArr30[i68] == 1 && iArr2[iArr29[i68]] > 0) {
                parsableNalUnitBitArray.l();
            }
            i68++;
            i4 = i78;
            iArr31 = iArr33;
            i60 = i77;
            i67 = 2;
        }
        int[] iArr34 = iArr31;
        if (i69 == 0) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        H265RepFormatsAndIndices h265RepFormatsAndIndicesS = s(parsableNalUnitBitArray, i11);
        parsableNalUnitBitArray.m(2);
        for (int i79 = 1; i79 < i11; i79++) {
            if (iArr2[iArr23[i79]] == 0) {
                parsableNalUnitBitArray.l();
            }
        }
        E(parsableNalUnitBitArray, i62, iArr26, iArr6, zArr14);
        K(parsableNalUnitBitArray, i11, zArr11);
        if (parsableNalUnitBitArray.e()) {
            parsableNalUnitBitArray.b();
            h265VideoSignalInfosAndIndicesX = x(parsableNalUnitBitArray, i11, i13, iArr26);
        } else {
            h265VideoSignalInfosAndIndicesX = null;
        }
        return new H265VpsData(h265NalHeader, immutableListM, new H265ProfileTierLevelsAndIndices(immutableList2, iArr34), h265RepFormatsAndIndicesS, h265VideoSignalInfosAndIndicesX);
    }
}
