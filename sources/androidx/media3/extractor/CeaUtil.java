package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CeaUtil {
    public static void a(long j3, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        while (true) {
            if (parsableByteArray.a() <= 1) {
                return;
            }
            int iC = c(parsableByteArray);
            int iC2 = c(parsableByteArray);
            int iF = parsableByteArray.f() + iC2;
            if (iC2 == -1 || iC2 > parsableByteArray.a()) {
                Log.i("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iF = parsableByteArray.g();
            } else if (iC == 4 && iC2 >= 8) {
                int iH = parsableByteArray.H();
                int iP = parsableByteArray.P();
                int iQ = iP == 49 ? parsableByteArray.q() : 0;
                int iH2 = parsableByteArray.H();
                if (iP == 47) {
                    parsableByteArray.X(1);
                }
                boolean z2 = iH == 181 && (iP == 49 || iP == 47) && iH2 == 3;
                if (iP == 49) {
                    z2 &= iQ == 1195456820;
                }
                if (z2) {
                    b(j3, parsableByteArray, trackOutputArr);
                }
            }
            parsableByteArray.W(iF);
        }
    }

    public static void b(long j3, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        int iH = parsableByteArray.H();
        if ((iH & 64) != 0) {
            parsableByteArray.X(1);
            int i3 = (iH & 31) * 3;
            int iF = parsableByteArray.f();
            for (TrackOutput trackOutput : trackOutputArr) {
                parsableByteArray.W(iF);
                trackOutput.b(parsableByteArray, i3);
                Assertions.g(j3 != -9223372036854775807L);
                trackOutput.g(j3, 1, i3, 0, null);
            }
        }
    }

    private static int c(ParsableByteArray parsableByteArray) {
        int i3 = 0;
        while (parsableByteArray.a() != 0) {
            int iH = parsableByteArray.H();
            i3 += iH;
            if (iH != 255) {
                return i3;
            }
        }
        return -1;
    }
}
