package androidx.media3.extractor.mkv;

import androidx.media3.extractor.ExtractorInput;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface EbmlProcessor {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({java.lang.annotation.ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ElementType {
    }

    void a(int i3);

    void b(int i3, double d3);

    void c(int i3, int i4, ExtractorInput extractorInput);

    void d(int i3, long j3);

    int e(int i3);

    boolean f(int i3);

    void g(int i3, String str);

    void h(int i3, long j3, long j4);
}
