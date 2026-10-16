package androidx.media3.muxer;

import android.media.MediaCodec;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FragmentedMp4Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PositionTrackingOutputStream f47809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WritableByteChannel f47810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MetadataCollector f47811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnnexBToAvccConverter f47812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f47813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f47814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f47815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f47816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LinearByteBufferAllocator f47817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Track f47818j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f47819k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f47820l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f47821m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f47822n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f47823o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ProcessedTrackInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f47828c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImmutableList f47829d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImmutableList f47830e;

        public ProcessedTrackInfo(int i3, int i4, boolean z2, ImmutableList immutableList, ImmutableList immutableList2) {
            this.f47826a = i3;
            this.f47827b = i4;
            this.f47828c = z2;
            this.f47829d = immutableList;
            this.f47830e = immutableList2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SampleMetadata {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f47833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f47834d;

        public SampleMetadata(int i3, int i4, int i5, int i6) {
            this.f47831a = i3;
            this.f47832b = i4;
            this.f47833c = i5;
            this.f47834d = i6;
        }
    }

    public FragmentedMp4Writer(OutputStream outputStream, MetadataCollector metadataCollector, AnnexBToAvccConverter annexBToAvccConverter, long j3, boolean z2) {
        PositionTrackingOutputStream positionTrackingOutputStream = new PositionTrackingOutputStream(outputStream);
        this.f47809a = positionTrackingOutputStream;
        this.f47810b = Channels.newChannel(positionTrackingOutputStream);
        this.f47811c = metadataCollector;
        this.f47812d = annexBToAvccConverter;
        this.f47813e = j3 * 1000;
        this.f47814f = z2;
        this.f47815g = 1;
        this.f47816h = new ArrayList();
        this.f47821m = Long.MAX_VALUE;
        this.f47819k = 1;
        this.f47817i = new LinearByteBufferAllocator(0);
    }

    private static int b(List list) {
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            ProcessedTrackInfo processedTrackInfo = (ProcessedTrackInfo) list.get(i3);
            iA += Boxes.A(processedTrackInfo.f47830e.size(), processedTrackInfo.f47828c) + 40;
        }
        return 24 + iA;
    }

    private void d() throws IOException {
        ImmutableList immutableListG = g();
        ImmutableList immutableListF = f(immutableListG, this.f47809a.a());
        if (immutableListF.isEmpty()) {
            return;
        }
        this.f47810b.write(Boxes.N(Boxes.L(this.f47819k), immutableListF));
        j(immutableListG);
        this.f47819k++;
        this.f47822n = 0L;
    }

    private void e() throws IOException {
        this.f47810b.write(Boxes.w());
        this.f47810b.write(Boxes.O(this.f47816h, this.f47811c, true, this.f47815g));
    }

    private static ImmutableList f(List list, long j3) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int iB = b(list) + 8;
        for (int i3 = 0; i3 < list.size(); i3++) {
            ProcessedTrackInfo processedTrackInfo = (ProcessedTrackInfo) list.get(i3);
            builder.a(Boxes.h0(Boxes.f0(processedTrackInfo.f47826a, j3), Boxes.k0(processedTrackInfo.f47830e, iB, processedTrackInfo.f47828c)));
            iB += processedTrackInfo.f47827b;
        }
        return builder.m();
    }

    private ImmutableList g() {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i3 = 0; i3 < this.f47816h.size(); i3++) {
            if (!((Track) this.f47816h.get(i3)).f47895g.isEmpty()) {
                builder.a(h(i3 + 1, (Track) this.f47816h.get(i3)));
            }
        }
        return builder.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProcessedTrackInfo h(int i3, Track track) {
        Assertions.g(track.f47896h.size() == track.f47895g.size());
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList.Builder builder2 = new ImmutableList.Builder();
        if (AnnexBUtils.a((String) Assertions.e(track.f47890b.f40632o))) {
            while (!track.f47896h.isEmpty()) {
                ByteBuffer byteBufferB = this.f47812d.b((ByteBuffer) track.f47896h.removeFirst(), this.f47817i);
                builder.a(byteBufferB);
                MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo) track.f47895g.removeFirst();
                bufferInfo.set(byteBufferB.position(), byteBufferB.remaining(), bufferInfo.presentationTimeUs, bufferInfo.flags);
                builder2.a(bufferInfo);
            }
        } else {
            builder.k(track.f47896h);
            track.f47896h.clear();
            builder2.k(track.f47895g);
            track.f47895g.clear();
        }
        ImmutableList immutableListM = builder2.m();
        List listK = Boxes.k(immutableListM, track.a(), 1, track.f47898j);
        List listF = Boxes.f(immutableListM, listK, track.a());
        boolean zIsEmpty = listF.isEmpty();
        boolean z2 = !zIsEmpty;
        ImmutableList.Builder builder3 = new ImmutableList.Builder();
        int i4 = 0;
        for (int i5 = 0; i5 < immutableListM.size(); i5++) {
            i4 += ((MediaCodec.BufferInfo) immutableListM.get(i5)).size;
            builder3.a(new SampleMetadata(((Integer) listK.get(i5)).intValue(), ((MediaCodec.BufferInfo) immutableListM.get(i5)).size, ((MediaCodec.BufferInfo) immutableListM.get(i5)).flags, !zIsEmpty ? ((Integer) listF.get(i5)).intValue() : 0));
        }
        return new ProcessedTrackInfo(i3, i4, z2, builder.m(), builder3.m());
    }

    private boolean i(Track track, MediaCodec.BufferInfo bufferInfo) {
        Track track2 = this.f47818j;
        if (track2 == null) {
            return this.f47822n >= this.f47813e;
        }
        if (track.equals(track2) && track.f47897i && (bufferInfo.flags & 1) > 0) {
            if (((MediaCodec.BufferInfo) Assertions.e((MediaCodec.BufferInfo) track.f47895g.peekLast())).presentationTimeUs - ((MediaCodec.BufferInfo) Assertions.e((MediaCodec.BufferInfo) track.f47895g.peekFirst())).presentationTimeUs >= this.f47813e) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j(List list) throws IOException {
        long jRemaining = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            ProcessedTrackInfo processedTrackInfo = (ProcessedTrackInfo) list.get(i3);
            for (int i4 = 0; i4 < processedTrackInfo.f47829d.size(); i4++) {
                jRemaining += (long) ((ByteBuffer) processedTrackInfo.f47829d.get(i4)).remaining();
            }
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        long j3 = ((long) 8) + jRemaining;
        Assertions.b(j3 <= 4294967295L, "Only 32-bit long mdat size supported in the fragmented MP4");
        byteBufferAllocate.putInt((int) j3);
        byteBufferAllocate.put(Util.t0("mdat"));
        byteBufferAllocate.flip();
        this.f47810b.write(byteBufferAllocate);
        for (int i5 = 0; i5 < list.size(); i5++) {
            ProcessedTrackInfo processedTrackInfo2 = (ProcessedTrackInfo) list.get(i5);
            for (int i6 = 0; i6 < processedTrackInfo2.f47829d.size(); i6++) {
                this.f47810b.write((ByteBuffer) processedTrackInfo2.f47829d.get(i6));
            }
        }
        this.f47817i.b();
    }

    public Track a(int i3, Format format) {
        int i4 = this.f47823o;
        this.f47823o = i4 + 1;
        Track track = new Track(i4, format, this.f47814f);
        this.f47816h.add(track);
        if (MimeTypes.q(format.f40632o)) {
            this.f47818j = track;
        }
        return track;
    }

    public void c() throws IOException {
        try {
            d();
        } finally {
            this.f47810b.close();
            this.f47809a.close();
        }
    }

    public void k(Track track, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws IOException {
        if (!this.f47820l) {
            e();
            this.f47820l = true;
        }
        if (i(track, bufferInfo)) {
            d();
        }
        track.b(byteBuffer, bufferInfo);
        MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) Assertions.e((MediaCodec.BufferInfo) track.f47895g.peekFirst());
        MediaCodec.BufferInfo bufferInfo3 = (MediaCodec.BufferInfo) Assertions.e((MediaCodec.BufferInfo) track.f47895g.peekLast());
        this.f47821m = Math.min(this.f47821m, bufferInfo2.presentationTimeUs);
        this.f47822n = Math.max(this.f47822n, bufferInfo3.presentationTimeUs - bufferInfo2.presentationTimeUs);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PositionTrackingOutputStream extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OutputStream f47824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f47825b = 0;

        public PositionTrackingOutputStream(OutputStream outputStream) {
            this.f47824a = outputStream;
        }

        public long a() {
            return this.f47825b;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f47824a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f47824a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i3) throws IOException {
            this.f47825b++;
            this.f47824a.write(i3);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f47825b += (long) bArr.length;
            this.f47824a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i3, int i4) throws IOException {
            this.f47825b += (long) i4;
            this.f47824a.write(bArr, i3, i4);
        }
    }
}
