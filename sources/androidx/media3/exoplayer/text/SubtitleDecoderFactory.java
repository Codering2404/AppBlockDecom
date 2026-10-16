package androidx.media3.exoplayer.text;

import androidx.media3.common.Format;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.cea.Cea608Decoder;
import androidx.media3.extractor.text.cea.Cea708Decoder;
import com.superwall.sdk.billing.GoogleBillingWrapperKt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface SubtitleDecoderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SubtitleDecoderFactory f45305a = new SubtitleDecoderFactory() { // from class: androidx.media3.exoplayer.text.SubtitleDecoderFactory.1

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DefaultSubtitleParserFactory f45306b = new DefaultSubtitleParserFactory();

        @Override // androidx.media3.exoplayer.text.SubtitleDecoderFactory
        public boolean a(Format format) {
            String str = format.f40632o;
            return this.f45306b.a(format) || Objects.equals(str, "application/cea-608") || Objects.equals(str, "application/x-mp4-cea-608") || Objects.equals(str, "application/cea-708");
        }

        @Override // androidx.media3.exoplayer.text.SubtitleDecoderFactory
        public SubtitleDecoder b(Format format) {
            String str = format.f40632o;
            if (str != null) {
                switch (str) {
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new Cea608Decoder(str, format.J, GoogleBillingWrapperKt.RECONNECT_TIMER_MAX_TIME_MILLISECONDS);
                    case "application/cea-708":
                        return new Cea708Decoder(format.J, format.f40635r);
                }
            }
            if (!this.f45306b.a(format)) {
                throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
            }
            SubtitleParser subtitleParserC = this.f45306b.c(format);
            return new DelegatingSubtitleDecoder(subtitleParserC.getClass().getSimpleName() + "Decoder", subtitleParserC);
        }
    };

    boolean a(Format format);

    SubtitleDecoder b(Format format);
}
