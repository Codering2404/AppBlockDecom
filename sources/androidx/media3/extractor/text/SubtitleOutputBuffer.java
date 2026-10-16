package androidx.media3.extractor.text;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderOutputBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Subtitle f46957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f46958g;

    @Override // androidx.media3.extractor.text.Subtitle
    public int a(long j3) {
        return ((Subtitle) Assertions.e(this.f46957f)).a(j3 - this.f46958g);
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public List b(long j3) {
        return ((Subtitle) Assertions.e(this.f46957f)).b(j3 - this.f46958g);
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long c(int i3) {
        return ((Subtitle) Assertions.e(this.f46957f)).c(i3) + this.f46958g;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int d() {
        return ((Subtitle) Assertions.e(this.f46957f)).d();
    }

    @Override // androidx.media3.decoder.DecoderOutputBuffer, androidx.media3.decoder.Buffer
    public void f() {
        super.f();
        this.f46957f = null;
    }

    public void p(long j3, Subtitle subtitle, long j4) {
        this.f42146b = j3;
        this.f46957f = subtitle;
        if (j4 != Long.MAX_VALUE) {
            j3 = j4;
        }
        this.f46958g = j3;
    }
}
