package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.ExtractorOutput;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface TsPayloadReader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class DvbSubtitleInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f47735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f47737c;

        public DvbSubtitleInfo(String str, int i3, byte[] bArr) {
            this.f47735a = str;
            this.f47736b = i3;
            this.f47737c = bArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EsInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f47739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f47740c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f47741d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f47742e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface AudioType {
        }

        public EsInfo(int i3, String str, int i4, List list, byte[] bArr) {
            this.f47738a = i3;
            this.f47739b = str;
            this.f47740c = i4;
            this.f47741d = list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
            this.f47742e = bArr;
        }

        public int a() {
            int i3 = this.f47740c;
            if (i3 != 2) {
                return i3 != 3 ? 0 : 512;
            }
            return 2048;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {
        TsPayloadReader a(int i3, EsInfo esInfo);

        SparseArray b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class TrackIdGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f47743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f47744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f47745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f47746d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f47747e;

        public TrackIdGenerator(int i3, int i4) {
            this(Integer.MIN_VALUE, i3, i4);
        }

        private void d() {
            if (this.f47746d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i3 = this.f47746d;
            this.f47746d = i3 == Integer.MIN_VALUE ? this.f47744b : i3 + this.f47745c;
            this.f47747e = this.f47743a + this.f47746d;
        }

        public String b() {
            d();
            return this.f47747e;
        }

        public int c() {
            d();
            return this.f47746d;
        }

        public TrackIdGenerator(int i3, int i4, int i5) {
            String str;
            if (i3 != Integer.MIN_VALUE) {
                str = i3 + "/";
            } else {
                str = "";
            }
            this.f47743a = str;
            this.f47744b = i4;
            this.f47745c = i5;
            this.f47746d = Integer.MIN_VALUE;
            this.f47747e = "";
        }
    }

    void a(ParsableByteArray parsableByteArray, int i3);

    void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void c();
}
