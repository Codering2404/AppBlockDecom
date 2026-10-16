package androidx.media3.extractor;

import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface Extractor {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReadResult {
    }

    void a(long j3, long j4);

    boolean g(ExtractorInput extractorInput);

    void h(ExtractorOutput extractorOutput);

    default List i() {
        return ImmutableList.y();
    }

    int j(ExtractorInput extractorInput, PositionHolder positionHolder);

    void release();

    default Extractor c() {
        return this;
    }
}
