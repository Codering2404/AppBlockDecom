package androidx.media3.extractor;

import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WavUtil {
    public static int a(int i3, int i4) {
        if (i3 != 1) {
            if (i3 == 3) {
                return i4 == 32 ? 4 : 0;
            }
            if (i3 != 65534) {
                return 0;
            }
        }
        return Util.h0(i4);
    }

    public static int b(int i3) {
        if (i3 == 2 || i3 == 3) {
            return 1;
        }
        if (i3 == 4) {
            return 3;
        }
        if (i3 == 21 || i3 == 22) {
            return 1;
        }
        throw new IllegalArgumentException();
    }
}
