package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface TrackOutput {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class CryptoData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f46227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f46228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f46229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f46230d;

        public CryptoData(int i3, byte[] bArr, int i4, int i5) {
            this.f46227a = i3;
            this.f46228b = bArr;
            this.f46229c = i4;
            this.f46230d = i5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && CryptoData.class == obj.getClass()) {
                CryptoData cryptoData = (CryptoData) obj;
                if (this.f46227a == cryptoData.f46227a && this.f46229c == cryptoData.f46229c && this.f46230d == cryptoData.f46230d && Arrays.equals(this.f46228b, cryptoData.f46228b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f46227a * 31) + Arrays.hashCode(this.f46228b)) * 31) + this.f46229c) * 31) + this.f46230d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SampleDataPart {
    }

    void a(ParsableByteArray parsableByteArray, int i3, int i4);

    default void b(ParsableByteArray parsableByteArray, int i3) {
        a(parsableByteArray, i3, 0);
    }

    void c(Format format);

    default int d(DataReader dataReader, int i3, boolean z2) {
        return f(dataReader, i3, z2, 0);
    }

    int f(DataReader dataReader, int i3, boolean z2, int i4);

    void g(long j3, int i3, int i4, int i5, CryptoData cryptoData);

    default void e(long j3) {
    }
}
