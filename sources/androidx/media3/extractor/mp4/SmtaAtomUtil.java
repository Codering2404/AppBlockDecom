package androidx.media3.extractor.mp4;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SmtaAtomUtil {
    private static int a(int i3, ParsableByteArray parsableByteArray, int i4) {
        if (i3 == 12) {
            return 240;
        }
        if (i3 == 13) {
            return 120;
        }
        if (i3 == 21 && parsableByteArray.a() >= 8 && parsableByteArray.f() + 8 <= i4) {
            int iQ = parsableByteArray.q();
            int iQ2 = parsableByteArray.q();
            if (iQ >= 12 && iQ2 == 1936877170) {
                return parsableByteArray.I();
            }
        }
        return -2147483647;
    }

    public static Metadata b(ParsableByteArray parsableByteArray, int i3) {
        parsableByteArray.X(12);
        while (parsableByteArray.f() < i3) {
            int iF = parsableByteArray.f();
            int iQ = parsableByteArray.q();
            if (parsableByteArray.q() == 1935766900) {
                if (iQ < 16) {
                    return null;
                }
                parsableByteArray.X(4);
                int i4 = -1;
                int i5 = 0;
                for (int i6 = 0; i6 < 2; i6++) {
                    int iH = parsableByteArray.H();
                    int iH2 = parsableByteArray.H();
                    if (iH == 0) {
                        i4 = iH2;
                    } else if (iH == 1) {
                        i5 = iH2;
                    }
                }
                int iA = a(i4, parsableByteArray, i3);
                if (iA == -2147483647) {
                    return null;
                }
                return new Metadata(new SmtaMetadataEntry(iA, i5));
            }
            parsableByteArray.W(iF + iQ);
        }
        return null;
    }
}
