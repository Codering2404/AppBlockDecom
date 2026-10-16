package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class HevcConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f46177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f46181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f46182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f46183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f46184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f46185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f46186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f46187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f46188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f46189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f46190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final NalUnitUtil.H265VpsData f46191o;

    private HevcConfig(List list, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f3, int i13, String str, NalUnitUtil.H265VpsData h265VpsData) {
        this.f46177a = list;
        this.f46178b = i3;
        this.f46179c = i4;
        this.f46180d = i5;
        this.f46181e = i6;
        this.f46182f = i7;
        this.f46183g = i8;
        this.f46184h = i9;
        this.f46185i = i10;
        this.f46186j = i11;
        this.f46187k = i12;
        this.f46188l = f3;
        this.f46189m = i13;
        this.f46190n = str;
        this.f46191o = h265VpsData;
    }

    public static HevcConfig a(ParsableByteArray parsableByteArray) {
        return b(parsableByteArray, false, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HevcConfig b(ParsableByteArray parsableByteArray, boolean z2, NalUnitUtil.H265VpsData h265VpsData) throws ParserException {
        boolean z3;
        int i3;
        NalUnitUtil.H265Sei3dRefDisplayInfoData h265Sei3dRefDisplayInfoDataT;
        int i4;
        try {
            if (z2) {
                parsableByteArray.X(4);
            } else {
                parsableByteArray.X(21);
            }
            int iH = parsableByteArray.H() & 3;
            int iH2 = parsableByteArray.H();
            int iF = parsableByteArray.f();
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                z3 = true;
                if (i6 >= iH2) {
                    break;
                }
                parsableByteArray.X(1);
                int iP = parsableByteArray.P();
                for (int i8 = 0; i8 < iP; i8++) {
                    int iP2 = parsableByteArray.P();
                    i7 += iP2 + 4;
                    parsableByteArray.X(iP2);
                }
                i6++;
            }
            parsableByteArray.W(iF);
            byte[] bArr = new byte[i7];
            NalUnitUtil.H265VpsData h265VpsData2 = h265VpsData;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            float f3 = 1.0f;
            String strG = null;
            int i19 = 0;
            int i20 = 0;
            while (i19 < iH2) {
                int iH3 = parsableByteArray.H() & 63;
                int iP3 = parsableByteArray.P();
                int i21 = i5;
                NalUnitUtil.H265VpsData h265VpsDataY = h265VpsData2;
                while (i21 < iP3) {
                    int iP4 = parsableByteArray.P();
                    boolean z4 = z3;
                    byte[] bArr2 = NalUnitUtil.f41674a;
                    int i22 = iH;
                    System.arraycopy(bArr2, i5, bArr, i20, bArr2.length);
                    int length = i20 + bArr2.length;
                    System.arraycopy(parsableByteArray.e(), parsableByteArray.f(), bArr, length, iP4);
                    if (iH3 == 32 && i21 == 0) {
                        h265VpsDataY = NalUnitUtil.y(bArr, length, length + iP4);
                        i3 = iH2;
                    } else {
                        if (iH3 == 33 && i21 == 0) {
                            NalUnitUtil.H265SpsData h265SpsDataU = NalUnitUtil.u(bArr, length, length + iP4, h265VpsDataY);
                            i9 = h265SpsDataU.f41708b + 1;
                            i10 = h265SpsDataU.f41714h;
                            int i23 = h265SpsDataU.f41715i;
                            i12 = h265SpsDataU.f41711e + 8;
                            i13 = h265SpsDataU.f41712f + 8;
                            int i24 = h265SpsDataU.f41718l;
                            i3 = iH2;
                            int i25 = h265SpsDataU.f41719m;
                            int i26 = h265SpsDataU.f41720n;
                            float f4 = h265SpsDataU.f41716j;
                            int i27 = h265SpsDataU.f41717k;
                            NalUnitUtil.H265ProfileTierLevel h265ProfileTierLevel = h265SpsDataU.f41709c;
                            if (h265ProfileTierLevel != null) {
                                i4 = i27;
                                strG = CodecSpecificDataUtil.g(h265ProfileTierLevel.f41683a, h265ProfileTierLevel.f41684b, h265ProfileTierLevel.f41685c, h265ProfileTierLevel.f41686d, h265ProfileTierLevel.f41687e, h265ProfileTierLevel.f41688f);
                            } else {
                                i4 = i27;
                            }
                            f3 = f4;
                            i18 = i4;
                            i15 = i25;
                            i16 = i26;
                            i14 = i24;
                            i11 = i23;
                        } else {
                            i3 = iH2;
                            if (iH3 == 39 && i21 == 0 && (h265Sei3dRefDisplayInfoDataT = NalUnitUtil.t(bArr, length, length + iP4)) != null && h265VpsDataY != null) {
                                i5 = 0;
                                i17 = h265Sei3dRefDisplayInfoDataT.f41701d == ((NalUnitUtil.H265LayerInfo) h265VpsDataY.f41727b.get(0)).f41679b ? 4 : 5;
                            }
                        }
                        i5 = 0;
                    }
                    i20 = length + iP4;
                    parsableByteArray.X(iP4);
                    i21++;
                    z3 = z4;
                    iH = i22;
                    iH2 = i3;
                }
                i19++;
                h265VpsData2 = h265VpsDataY;
            }
            return new HevcConfig(i7 == 0 ? Collections.EMPTY_LIST : Collections.singletonList(bArr), iH + 1, i9, i10, i11, i12, i13, i14, i15, i16, i17, f3, i18, strG, h265VpsData2);
        } catch (ArrayIndexOutOfBoundsException e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error parsing");
            sb.append(z2 ? "L-HEVC config" : "HEVC config");
            throw ParserException.a(sb.toString(), e3);
        }
    }

    public static HevcConfig c(ParsableByteArray parsableByteArray, NalUnitUtil.H265VpsData h265VpsData) {
        return b(parsableByteArray, true, h265VpsData);
    }
}
