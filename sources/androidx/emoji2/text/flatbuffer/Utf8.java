package androidx.emoji2.text.flatbuffer;

import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Utf8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Utf8 f36987a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DecodeUtil {
        static void a(byte b3, byte b4, byte b5, byte b6, char[] cArr, int i3) {
            if (f(b4) || (((b3 << Ascii.FS) + (b4 + 112)) >> 30) != 0 || f(b5) || f(b6)) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            int iK = ((b3 & 7) << 18) | (k(b4) << 12) | (k(b5) << 6) | k(b6);
            cArr[i3] = e(iK);
            cArr[i3 + 1] = j(iK);
        }

        static void b(byte b3, char[] cArr, int i3) {
            cArr[i3] = (char) b3;
        }

        static void c(byte b3, byte b4, byte b5, char[] cArr, int i3) {
            if (f(b4) || ((b3 == -32 && b4 < -96) || ((b3 == -19 && b4 >= -96) || f(b5)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i3] = (char) (((b3 & Ascii.SI) << 12) | (k(b4) << 6) | k(b5));
        }

        static void d(byte b3, byte b4, char[] cArr, int i3) {
            if (b3 < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            }
            if (f(b4)) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            cArr[i3] = (char) (((b3 & Ascii.US) << 6) | k(b4));
        }

        private static char e(int i3) {
            return (char) ((i3 >>> 10) + 55232);
        }

        private static boolean f(byte b3) {
            return b3 > -65;
        }

        static boolean g(byte b3) {
            return b3 >= 0;
        }

        static boolean h(byte b3) {
            return b3 < -16;
        }

        static boolean i(byte b3) {
            return b3 < -32;
        }

        private static char j(int i3) {
            return (char) ((i3 & 1023) + 56320);
        }

        private static int k(byte b3) {
            return b3 & 63;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class UnpairedSurrogateException extends IllegalArgumentException {
    }

    public static Utf8 a() {
        if (f36987a == null) {
            f36987a = new Utf8Safe();
        }
        return f36987a;
    }
}
