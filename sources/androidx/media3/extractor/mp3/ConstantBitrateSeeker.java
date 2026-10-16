package androidx.media3.extractor.mp3;

import androidx.media3.extractor.ConstantBitrateSeekMap;
import androidx.media3.extractor.MpegAudioUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f46623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f46624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f46625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f46626k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f46627l;

    public ConstantBitrateSeeker(long j3, long j4, MpegAudioUtil.Header header, boolean z2) {
        this(j3, j4, header.f46208f, header.f46205c, z2);
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long d() {
        return this.f46627l;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long f(long j3) {
        return c(j3);
    }

    public ConstantBitrateSeeker h(long j3) {
        return new ConstantBitrateSeeker(j3, this.f46623h, this.f46624i, this.f46625j, this.f46626k);
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public int k() {
        return this.f46624i;
    }

    public ConstantBitrateSeeker(long j3, long j4, int i3, int i4, boolean z2) {
        super(j3, j4, i3, i4, z2);
        long j5 = j3;
        this.f46623h = j4;
        this.f46624i = i3;
        this.f46625j = i4;
        this.f46626k = z2;
        this.f46627l = j5 == -1 ? -1L : j5;
    }
}
