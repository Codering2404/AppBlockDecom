package androidx.media3.extractor;

import android.util.Base64;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import androidx.media3.extractor.metadata.vorbis.VorbisComment;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VorbisUtil {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class CommentHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f46242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f46243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f46244c;

        public CommentHeader(String str, String[] strArr, int i3) {
            this.f46242a = str;
            this.f46243b = strArr;
            this.f46244c = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Mode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f46245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f46246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f46247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f46248d;

        public Mode(boolean z2, int i3, int i4, int i5) {
            this.f46245a = z2;
            this.f46246b = i3;
            this.f46247c = i4;
            this.f46248d = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class VorbisIdHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f46249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f46250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f46251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f46252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f46253e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f46254f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f46255g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f46256h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f46257i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final byte[] f46258j;

        public VorbisIdHeader(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z2, byte[] bArr) {
            this.f46249a = i3;
            this.f46250b = i4;
            this.f46251c = i5;
            this.f46252d = i6;
            this.f46253e = i7;
            this.f46254f = i8;
            this.f46255g = i9;
            this.f46256h = i10;
            this.f46257i = z2;
            this.f46258j = bArr;
        }
    }

    public static int[] a(int i3) {
        if (i3 == 3) {
            return new int[]{0, 2, 1};
        }
        if (i3 == 5) {
            return new int[]{0, 2, 1, 3, 4};
        }
        if (i3 == 6) {
            return new int[]{0, 2, 1, 5, 3, 4};
        }
        if (i3 == 7) {
            return new int[]{0, 2, 1, 6, 5, 3, 4};
        }
        if (i3 != 8) {
            return null;
        }
        return new int[]{0, 2, 1, 7, 5, 6, 3, 4};
    }

    public static int b(int i3) {
        int i4 = 0;
        while (i3 > 0) {
            i4++;
            i3 >>>= 1;
        }
        return i4;
    }

    private static long c(long j3, long j4) {
        return (long) Math.floor(Math.pow(j3, 1.0d / j4));
    }

    public static Metadata d(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = (String) list.get(i3);
            String[] strArrI1 = Util.i1(str, "=");
            if (strArrI1.length != 2) {
                Log.i("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (strArrI1[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.d(new ParsableByteArray(Base64.decode(strArrI1[1], 0))));
                } catch (RuntimeException e3) {
                    Log.j("VorbisUtil", "Failed to parse vorbis picture", e3);
                }
            } else {
                arrayList.add(new VorbisComment(strArrI1[0], strArrI1[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static ImmutableList e(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.X(1);
        int i3 = 0;
        while (parsableByteArray.a() > 0 && parsableByteArray.j() == 255) {
            i3 += 255;
            parsableByteArray.X(1);
        }
        int iH = i3 + parsableByteArray.H();
        int i4 = 0;
        while (parsableByteArray.a() > 0 && parsableByteArray.j() == 255) {
            i4 += 255;
            parsableByteArray.X(1);
        }
        int iH2 = i4 + parsableByteArray.H();
        byte[] bArr2 = new byte[iH];
        int iF = parsableByteArray.f();
        System.arraycopy(bArr, iF, bArr2, 0, iH);
        int i5 = iF + iH + iH2;
        int length = bArr.length - i5;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, i5, bArr3, 0, length);
        return ImmutableList.A(bArr2, bArr3);
    }

    private static void f(VorbisBitArray vorbisBitArray) throws ParserException {
        int iD = vorbisBitArray.d(6) + 1;
        for (int i3 = 0; i3 < iD; i3++) {
            int iD2 = vorbisBitArray.d(16);
            if (iD2 == 0) {
                vorbisBitArray.e(8);
                vorbisBitArray.e(16);
                vorbisBitArray.e(16);
                vorbisBitArray.e(6);
                vorbisBitArray.e(8);
                int iD3 = vorbisBitArray.d(4) + 1;
                for (int i4 = 0; i4 < iD3; i4++) {
                    vorbisBitArray.e(8);
                }
            } else {
                if (iD2 != 1) {
                    throw ParserException.a("floor type greater than 1 not decodable: " + iD2, null);
                }
                int iD4 = vorbisBitArray.d(5);
                int[] iArr = new int[iD4];
                int i5 = -1;
                for (int i6 = 0; i6 < iD4; i6++) {
                    int iD5 = vorbisBitArray.d(4);
                    iArr[i6] = iD5;
                    if (iD5 > i5) {
                        i5 = iD5;
                    }
                }
                int i7 = i5 + 1;
                int[] iArr2 = new int[i7];
                for (int i8 = 0; i8 < i7; i8++) {
                    iArr2[i8] = vorbisBitArray.d(3) + 1;
                    int iD6 = vorbisBitArray.d(2);
                    if (iD6 > 0) {
                        vorbisBitArray.e(8);
                    }
                    for (int i9 = 0; i9 < (1 << iD6); i9++) {
                        vorbisBitArray.e(8);
                    }
                }
                vorbisBitArray.e(2);
                int iD7 = vorbisBitArray.d(4);
                int i10 = 0;
                int i11 = 0;
                for (int i12 = 0; i12 < iD4; i12++) {
                    i10 += iArr2[iArr[i12]];
                    while (i11 < i10) {
                        vorbisBitArray.e(iD7);
                        i11++;
                    }
                }
            }
        }
    }

    private static void g(int i3, VorbisBitArray vorbisBitArray) throws ParserException {
        int iD = vorbisBitArray.d(6) + 1;
        for (int i4 = 0; i4 < iD; i4++) {
            int iD2 = vorbisBitArray.d(16);
            if (iD2 != 0) {
                Log.d("VorbisUtil", "mapping type other than 0 not supported: " + iD2);
            } else {
                int iD3 = vorbisBitArray.c() ? vorbisBitArray.d(4) + 1 : 1;
                if (vorbisBitArray.c()) {
                    int iD4 = vorbisBitArray.d(8) + 1;
                    for (int i5 = 0; i5 < iD4; i5++) {
                        int i6 = i3 - 1;
                        vorbisBitArray.e(b(i6));
                        vorbisBitArray.e(b(i6));
                    }
                }
                if (vorbisBitArray.d(2) != 0) {
                    throw ParserException.a("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (iD3 > 1) {
                    for (int i7 = 0; i7 < i3; i7++) {
                        vorbisBitArray.e(4);
                    }
                }
                for (int i8 = 0; i8 < iD3; i8++) {
                    vorbisBitArray.e(8);
                    vorbisBitArray.e(8);
                    vorbisBitArray.e(8);
                }
            }
        }
    }

    private static Mode[] h(VorbisBitArray vorbisBitArray) {
        int iD = vorbisBitArray.d(6) + 1;
        Mode[] modeArr = new Mode[iD];
        for (int i3 = 0; i3 < iD; i3++) {
            modeArr[i3] = new Mode(vorbisBitArray.c(), vorbisBitArray.d(16), vorbisBitArray.d(16), vorbisBitArray.d(8));
        }
        return modeArr;
    }

    private static void i(VorbisBitArray vorbisBitArray) throws ParserException {
        int iD = vorbisBitArray.d(6) + 1;
        for (int i3 = 0; i3 < iD; i3++) {
            if (vorbisBitArray.d(16) > 2) {
                throw ParserException.a("residueType greater than 2 is not decodable", null);
            }
            vorbisBitArray.e(24);
            vorbisBitArray.e(24);
            vorbisBitArray.e(24);
            int iD2 = vorbisBitArray.d(6) + 1;
            vorbisBitArray.e(8);
            int[] iArr = new int[iD2];
            for (int i4 = 0; i4 < iD2; i4++) {
                iArr[i4] = ((vorbisBitArray.c() ? vorbisBitArray.d(5) : 0) * 8) + vorbisBitArray.d(3);
            }
            for (int i5 = 0; i5 < iD2; i5++) {
                for (int i6 = 0; i6 < 8; i6++) {
                    if ((iArr[i5] & (1 << i6)) != 0) {
                        vorbisBitArray.e(8);
                    }
                }
            }
        }
    }

    public static CommentHeader j(ParsableByteArray parsableByteArray) {
        return k(parsableByteArray, true, true);
    }

    public static CommentHeader k(ParsableByteArray parsableByteArray, boolean z2, boolean z3) throws ParserException {
        if (z2) {
            o(3, parsableByteArray, false);
        }
        String strE = parsableByteArray.E((int) parsableByteArray.x());
        int length = strE.length();
        long jX = parsableByteArray.x();
        String[] strArr = new String[(int) jX];
        int length2 = length + 15;
        for (int i3 = 0; i3 < jX; i3++) {
            String strE2 = parsableByteArray.E((int) parsableByteArray.x());
            strArr[i3] = strE2;
            length2 = length2 + 4 + strE2.length();
        }
        if (z3 && (parsableByteArray.H() & 1) == 0) {
            throw ParserException.a("framing bit expected to be set", null);
        }
        return new CommentHeader(strE, strArr, length2 + 1);
    }

    public static VorbisIdHeader l(ParsableByteArray parsableByteArray) throws ParserException {
        o(1, parsableByteArray, false);
        int iY = parsableByteArray.y();
        int iH = parsableByteArray.H();
        int iY2 = parsableByteArray.y();
        int iU = parsableByteArray.u();
        if (iU <= 0) {
            iU = -1;
        }
        int iU2 = parsableByteArray.u();
        if (iU2 <= 0) {
            iU2 = -1;
        }
        int iU3 = parsableByteArray.u();
        if (iU3 <= 0) {
            iU3 = -1;
        }
        int iH2 = parsableByteArray.H();
        return new VorbisIdHeader(iY, iH, iY2, iU, iU2, iU3, (int) Math.pow(2.0d, iH2 & 15), (int) Math.pow(2.0d, (iH2 & 240) >> 4), (parsableByteArray.H() & 1) > 0, Arrays.copyOf(parsableByteArray.e(), parsableByteArray.g()));
    }

    public static Mode[] m(ParsableByteArray parsableByteArray, int i3) throws ParserException {
        o(5, parsableByteArray, false);
        int iH = parsableByteArray.H() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.e());
        vorbisBitArray.e(parsableByteArray.f() * 8);
        for (int i4 = 0; i4 < iH; i4++) {
            n(vorbisBitArray);
        }
        int iD = vorbisBitArray.d(6) + 1;
        for (int i5 = 0; i5 < iD; i5++) {
            if (vorbisBitArray.d(16) != 0) {
                throw ParserException.a("placeholder of time domain transforms not zeroed out", null);
            }
        }
        f(vorbisBitArray);
        i(vorbisBitArray);
        g(i3, vorbisBitArray);
        Mode[] modeArrH = h(vorbisBitArray);
        if (vorbisBitArray.c()) {
            return modeArrH;
        }
        throw ParserException.a("framing bit after modes not set as expected", null);
    }

    private static void n(VorbisBitArray vorbisBitArray) throws ParserException {
        if (vorbisBitArray.d(24) != 5653314) {
            throw ParserException.a("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.b(), null);
        }
        int iD = vorbisBitArray.d(16);
        int iD2 = vorbisBitArray.d(24);
        int iD3 = 0;
        if (vorbisBitArray.c()) {
            vorbisBitArray.e(5);
            while (iD3 < iD2) {
                iD3 += vorbisBitArray.d(b(iD2 - iD3));
            }
        } else {
            boolean zC = vorbisBitArray.c();
            while (iD3 < iD2) {
                if (!zC) {
                    vorbisBitArray.e(5);
                } else if (vorbisBitArray.c()) {
                    vorbisBitArray.e(5);
                }
                iD3++;
            }
        }
        int iD4 = vorbisBitArray.d(4);
        if (iD4 > 2) {
            throw ParserException.a("lookup type greater than 2 not decodable: " + iD4, null);
        }
        if (iD4 == 1 || iD4 == 2) {
            vorbisBitArray.e(32);
            vorbisBitArray.e(32);
            int iD5 = vorbisBitArray.d(4) + 1;
            vorbisBitArray.e(1);
            vorbisBitArray.e((int) ((iD4 == 1 ? iD != 0 ? c(iD2, iD) : 0L : ((long) iD) * ((long) iD2)) * ((long) iD5)));
        }
    }

    public static boolean o(int i3, ParsableByteArray parsableByteArray, boolean z2) throws ParserException {
        if (parsableByteArray.a() < 7) {
            if (z2) {
                return false;
            }
            throw ParserException.a("too short header: " + parsableByteArray.a(), null);
        }
        if (parsableByteArray.H() != i3) {
            if (z2) {
                return false;
            }
            throw ParserException.a("expected header type " + Integer.toHexString(i3), null);
        }
        if (parsableByteArray.H() == 118 && parsableByteArray.H() == 111 && parsableByteArray.H() == 114 && parsableByteArray.H() == 98 && parsableByteArray.H() == 105 && parsableByteArray.H() == 115) {
            return true;
        }
        if (z2) {
            return false;
        }
        throw ParserException.a("expected characters 'vorbis'", null);
    }
}
