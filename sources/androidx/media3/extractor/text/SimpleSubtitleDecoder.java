package androidx.media3.extractor.text;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.SimpleDecoder;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleSubtitleDecoder extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f46941o;

    protected SimpleSubtitleDecoder(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.f46941o = str;
        w(1024);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException k(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    protected abstract Subtitle B(byte[] bArr, int i3, boolean z2);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException l(SubtitleInputBuffer subtitleInputBuffer, SubtitleOutputBuffer subtitleOutputBuffer, boolean z2) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(subtitleInputBuffer.f42138d);
            subtitleOutputBuffer.p(subtitleInputBuffer.f42140g, B(byteBuffer.array(), byteBuffer.limit(), z2), subtitleInputBuffer.f46956k);
            subtitleOutputBuffer.f42148d = false;
            return null;
        } catch (SubtitleDecoderException e3) {
            return e3;
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final String getName() {
        return this.f46941o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final SubtitleInputBuffer i() {
        return new SubtitleInputBuffer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public final SubtitleOutputBuffer j() {
        return new SubtitleOutputBuffer() { // from class: androidx.media3.extractor.text.SimpleSubtitleDecoder.1
            @Override // androidx.media3.decoder.DecoderOutputBuffer
            public void o() {
                SimpleSubtitleDecoder.this.t(this);
            }
        };
    }

    @Override // androidx.media3.extractor.text.SubtitleDecoder
    public void c(long j3) {
    }
}
