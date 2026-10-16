package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AvcConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f46052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f46056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f46057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f46058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f46059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f46060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f46061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f46062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f46063l;

    private AvcConfig(List list, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, float f3, String str) {
        this.f46052a = list;
        this.f46053b = i3;
        this.f46054c = i4;
        this.f46055d = i5;
        this.f46056e = i6;
        this.f46057f = i7;
        this.f46058g = i8;
        this.f46059h = i9;
        this.f46060i = i10;
        this.f46061j = i11;
        this.f46062k = f3;
        this.f46063l = str;
    }

    private static byte[] a(ParsableByteArray parsableByteArray) {
        int iP = parsableByteArray.P();
        int iF = parsableByteArray.f();
        parsableByteArray.X(iP);
        return CodecSpecificDataUtil.h(parsableByteArray.e(), iF, iP);
    }

    public static AvcConfig b(ParsableByteArray parsableByteArray) throws ParserException {
        String strD;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f3;
        int i9;
        int i10;
        try {
            parsableByteArray.X(4);
            int iH = (parsableByteArray.H() & 3) + 1;
            if (iH == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iH2 = parsableByteArray.H() & 31;
            for (int i11 = 0; i11 < iH2; i11++) {
                arrayList.add(a(parsableByteArray));
            }
            int iH3 = parsableByteArray.H();
            for (int i12 = 0; i12 < iH3; i12++) {
                arrayList.add(a(parsableByteArray));
            }
            if (iH2 > 0) {
                NalUnitUtil.SpsData spsDataC = NalUnitUtil.C((byte[]) arrayList.get(0), NalUnitUtil.f41674a.length, ((byte[]) arrayList.get(0)).length);
                int i13 = spsDataC.f41739f;
                int i14 = spsDataC.f41740g;
                int i15 = spsDataC.f41742i + 8;
                int i16 = spsDataC.f41743j + 8;
                int i17 = spsDataC.f41750q;
                int i18 = spsDataC.f41751r;
                int i19 = spsDataC.f41752s;
                int i20 = spsDataC.f41753t;
                float f4 = spsDataC.f41741h;
                strD = CodecSpecificDataUtil.d(spsDataC.f41734a, spsDataC.f41735b, spsDataC.f41736c);
                i7 = i19;
                i8 = i20;
                f3 = f4;
                i6 = i16;
                i9 = i17;
                i10 = i18;
                i3 = i13;
                i4 = i14;
                i5 = i15;
            } else {
                strD = null;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                i6 = -1;
                i7 = -1;
                i8 = 16;
                f3 = 1.0f;
                i9 = -1;
                i10 = -1;
            }
            return new AvcConfig(arrayList, iH, i3, i4, i5, i6, i9, i10, i7, i8, f3, strD);
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw ParserException.a("Error parsing AVC config", e3);
        }
    }
}
