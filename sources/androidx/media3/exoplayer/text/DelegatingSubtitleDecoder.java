package androidx.media3.exoplayer.text;

import androidx.media3.extractor.text.SimpleSubtitleDecoder;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class DelegatingSubtitleDecoder extends SimpleSubtitleDecoder {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final SubtitleParser f45301p;

    public DelegatingSubtitleDecoder(String str, SubtitleParser subtitleParser) {
        super(str);
        this.f45301p = subtitleParser;
    }

    @Override // androidx.media3.extractor.text.SimpleSubtitleDecoder
    protected Subtitle B(byte[] bArr, int i3, boolean z2) {
        if (z2) {
            this.f45301p.reset();
        }
        return this.f45301p.b(bArr, 0, i3);
    }
}
