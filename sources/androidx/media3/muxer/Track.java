package androidx.media3.muxer;

import android.media.MediaCodec;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Track {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Format f47890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f47892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f47893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f47894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Deque f47895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Deque f47896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f47897i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f47898j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f47899k;

    public Track(int i3, Format format, boolean z2) {
        this(i3, format, 1, z2);
    }

    public int a() {
        return MimeTypes.n(this.f47890b.f40632o) ? 48000 : 90000;
    }

    public void b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Assertions.b(this.f47898j == -9223372036854775807L, "Samples can not be written after writing a sample with MediaCodec.BUFFER_FLAG_END_OF_STREAM flag");
        if (bufferInfo.size == 0 || byteBuffer.remaining() == 0) {
            if ((bufferInfo.flags & 4) != 0) {
                this.f47898j = bufferInfo.presentationTimeUs;
                return;
            }
            return;
        }
        if ((bufferInfo.flags & 1) > 0) {
            this.f47897i = true;
        }
        if (this.f47897i || !MimeTypes.q(this.f47890b.f40632o)) {
            if (this.f47899k) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
                byteBufferAllocateDirect.put(byteBuffer);
                byteBufferAllocateDirect.rewind();
                byteBuffer = byteBufferAllocateDirect;
            }
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            bufferInfo2.set(byteBuffer.position(), byteBuffer.remaining(), bufferInfo.presentationTimeUs, bufferInfo.flags);
            this.f47895g.addLast(bufferInfo2);
            this.f47896h.addLast(byteBuffer);
        }
    }

    public Track(int i3, Format format, int i4, boolean z2) {
        this.f47889a = i3;
        this.f47890b = format;
        this.f47891c = i4;
        this.f47899k = z2;
        this.f47892d = new ArrayList();
        this.f47893e = new ArrayList();
        this.f47894f = new ArrayList();
        this.f47895g = new ArrayDeque();
        this.f47896h = new ArrayDeque();
        this.f47898j = -9223372036854775807L;
    }
}
