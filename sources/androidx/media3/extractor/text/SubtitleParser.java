package androidx.media3.extractor.text;

import androidx.media3.common.Format;
import androidx.media3.common.util.Consumer;
import com.google.common.collect.ImmutableList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface SubtitleParser {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Factory f46959a = new Factory() { // from class: androidx.media3.extractor.text.SubtitleParser.Factory.1
            @Override // androidx.media3.extractor.text.SubtitleParser.Factory
            public boolean a(Format format) {
                return false;
            }

            @Override // androidx.media3.extractor.text.SubtitleParser.Factory
            public int b(Format format) {
                return 1;
            }

            @Override // androidx.media3.extractor.text.SubtitleParser.Factory
            public SubtitleParser c(Format format) {
                throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
            }
        };

        boolean a(Format format);

        int b(Format format);

        SubtitleParser c(Format format);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class OutputOptions {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final OutputOptions f46960c = new OutputOptions(-9223372036854775807L, false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f46961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f46962b;

        private OutputOptions(long j3, boolean z2) {
            this.f46961a = j3;
            this.f46962b = z2;
        }

        public static OutputOptions b() {
            return f46960c;
        }

        public static OutputOptions c(long j3) {
            return new OutputOptions(j3, true);
        }
    }

    void a(byte[] bArr, int i3, int i4, OutputOptions outputOptions, Consumer consumer);

    default Subtitle b(byte[] bArr, int i3, int i4) {
        final ImmutableList.Builder builderO = ImmutableList.o();
        OutputOptions outputOptions = OutputOptions.f46960c;
        Objects.requireNonNull(builderO);
        a(bArr, i3, i4, outputOptions, new Consumer() { // from class: androidx.media3.extractor.text.e
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                builderO.a((CuesWithTiming) obj);
            }
        });
        return new CuesWithTimingSubtitle(builderO.m());
    }

    int c();

    default void reset() {
    }
}
