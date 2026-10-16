package androidx.media3.extractor.text;

import androidx.media3.common.Format;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.dvb.DvbParser;
import androidx.media3.extractor.text.pgs.PgsParser;
import androidx.media3.extractor.text.ssa.SsaParser;
import androidx.media3.extractor.text.subrip.SubripParser;
import androidx.media3.extractor.text.ttml.TtmlParser;
import androidx.media3.extractor.text.tx3g.Tx3gParser;
import androidx.media3.extractor.text.vobsub.VobsubParser;
import androidx.media3.extractor.text.webvtt.Mp4WebvttParser;
import androidx.media3.extractor.text.webvtt.WebvttParser;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultSubtitleParserFactory implements SubtitleParser.Factory {
    @Override // androidx.media3.extractor.text.SubtitleParser.Factory
    public boolean a(Format format) {
        String str = format.f40632o;
        return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/vobsub") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
    }

    @Override // androidx.media3.extractor.text.SubtitleParser.Factory
    public int b(Format format) {
        String str = format.f40632o;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                case "application/pgs":
                case "application/x-mp4-vtt":
                    return 2;
                case "text/vtt":
                    return 1;
                case "application/x-quicktime-tx3g":
                    return 2;
                case "text/x-ssa":
                    return 1;
                case "application/vobsub":
                    return 2;
                case "application/x-subrip":
                case "application/ttml+xml":
                    return 1;
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: " + str);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser.Factory
    public SubtitleParser c(Format format) {
        String str = format.f40632o;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                    return new DvbParser(format.f40635r);
                case "application/pgs":
                    return new PgsParser();
                case "application/x-mp4-vtt":
                    return new Mp4WebvttParser();
                case "text/vtt":
                    return new WebvttParser();
                case "application/x-quicktime-tx3g":
                    return new Tx3gParser(format.f40635r);
                case "text/x-ssa":
                    return new SsaParser(format.f40635r);
                case "application/vobsub":
                    return new VobsubParser(format.f40635r);
                case "application/x-subrip":
                    return new SubripParser();
                case "application/ttml+xml":
                    return new TtmlParser();
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: " + str);
    }
}
