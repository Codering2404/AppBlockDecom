package androidx.media3.exoplayer;

import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DecoderCounters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f42864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f42865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f42866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f42867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f42868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f42869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f42870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f42871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f42872l;

    private void b(long j3, int i3) {
        this.f42871k += j3;
        this.f42872l += i3;
    }

    public void a(long j3) {
        b(j3, 1);
    }

    public synchronized void c() {
    }

    public String toString() {
        return Util.J("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f42861a), Integer.valueOf(this.f42862b), Integer.valueOf(this.f42863c), Integer.valueOf(this.f42864d), Integer.valueOf(this.f42865e), Integer.valueOf(this.f42866f), Integer.valueOf(this.f42867g), Integer.valueOf(this.f42868h), Integer.valueOf(this.f42869i), Integer.valueOf(this.f42870j), Long.valueOf(this.f42871k), Integer.valueOf(this.f42872l));
    }
}
