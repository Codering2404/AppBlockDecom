package androidx.media3.extractor.jpeg;

import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class JpegExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Extractor f46387a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public JpegExtractor(int i3) {
        if ((i3 & 1) != 0) {
            this.f46387a = new SingleSampleExtractor(65496, 2, "image/jpeg");
        } else {
            this.f46387a = new JpegMotionPhotoExtractor();
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f46387a.a(j3, j4);
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        return this.f46387a.g(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46387a.h(extractorOutput);
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f46387a.j(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
        this.f46387a.release();
    }
}
