package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DecoderReuseEvaluation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Format f42874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Format f42875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f42876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f42877e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DecoderDiscardReasons {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DecoderReuseResult {
    }

    public DecoderReuseEvaluation(String str, Format format, Format format2, int i3, int i4) {
        Assertions.a(i3 == 0 || i4 == 0);
        this.f42873a = Assertions.d(str);
        this.f42874b = (Format) Assertions.e(format);
        this.f42875c = (Format) Assertions.e(format2);
        this.f42876d = i3;
        this.f42877e = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DecoderReuseEvaluation.class == obj.getClass()) {
            DecoderReuseEvaluation decoderReuseEvaluation = (DecoderReuseEvaluation) obj;
            if (this.f42876d == decoderReuseEvaluation.f42876d && this.f42877e == decoderReuseEvaluation.f42877e && this.f42873a.equals(decoderReuseEvaluation.f42873a) && this.f42874b.equals(decoderReuseEvaluation.f42874b) && this.f42875c.equals(decoderReuseEvaluation.f42875c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f42876d) * 31) + this.f42877e) * 31) + this.f42873a.hashCode()) * 31) + this.f42874b.hashCode()) * 31) + this.f42875c.hashCode();
    }
}
