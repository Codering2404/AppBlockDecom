package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExtractorUtil {
    public static void a(boolean z2, String str) throws ParserException {
        if (!z2) {
            throw ParserException.a(str, null);
        }
    }

    public static boolean b(ExtractorInput extractorInput, byte[] bArr, int i3, int i4, boolean z2) throws EOFException {
        try {
            return extractorInput.d(bArr, i3, i4, z2);
        } catch (EOFException e3) {
            if (z2) {
                return false;
            }
            throw e3;
        }
    }

    public static int c(ExtractorInput extractorInput, byte[] bArr, int i3, int i4) {
        int i5 = 0;
        while (i5 < i4) {
            int iJ = extractorInput.j(bArr, i3 + i5, i4 - i5);
            if (iJ == -1) {
                break;
            }
            i5 += iJ;
        }
        return i5;
    }

    public static boolean d(ExtractorInput extractorInput, byte[] bArr, int i3, int i4) {
        try {
            extractorInput.readFully(bArr, i3, i4);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(ExtractorInput extractorInput, int i3) {
        try {
            extractorInput.k(i3);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
