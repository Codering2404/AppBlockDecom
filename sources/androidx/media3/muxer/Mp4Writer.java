package androidx.media3.muxer;

import android.media.MediaCodec;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import com.google.common.collect.Range;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Mp4Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileChannel f47871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MetadataCollector f47872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnnexBToAvccConverter f47873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f47874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f47875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f47876f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f47881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f47882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f47883m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f47884n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f47885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f47886p;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f47877g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f47878h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f47879i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Range f47887q = Range.f(0L, 0L);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f47888r = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinearByteBufferAllocator f47880j = new LinearByteBufferAllocator(0);

    public Mp4Writer(FileChannel fileChannel, MetadataCollector metadataCollector, AnnexBToAvccConverter annexBToAvccConverter, int i3, boolean z2, boolean z3, boolean z4) {
        this.f47871a = fileChannel;
        this.f47872b = metadataCollector;
        this.f47873c = annexBToAvccConverter;
        this.f47874d = i3;
        this.f47875e = z2;
        this.f47876f = z3;
        this.f47883m = z4;
    }

    private ByteBuffer e() {
        return Boxes.O(this.f47877g, this.f47872b, false, this.f47874d);
    }

    private void f() throws IOException {
        boolean zM = m(this.f47877g);
        m(this.f47878h);
        if (zM && this.f47883m) {
            l();
        }
    }

    private ByteBuffer i() {
        ByteBuffer byteBufferW = Boxes.w();
        MetadataCollector metadataCollector = new MetadataCollector();
        MuxerUtil.i(metadataCollector, this.f47872b.f47839d, true, this.f47878h);
        return BoxUtils.a(Boxes.x(byteBufferW.remaining() + r1.remaining()), byteBufferW, Boxes.O(this.f47878h, metadataCollector, false, this.f47874d));
    }

    private long j(long j3) {
        return Math.min(1000000000L, Math.max(500000L, (long) (j3 * 0.2f)));
    }

    private void k(long j3) throws IOException {
        if (this.f47883m) {
            return;
        }
        long j4 = this.f47886p;
        if (j4 + j3 >= this.f47885o) {
            n(j(j4) + j3);
        }
    }

    private void l() throws IOException {
        ByteBuffer byteBufferE = e();
        int iRemaining = byteBufferE.remaining();
        long jRemaining = byteBufferE.remaining() + 8;
        long j3 = this.f47882l;
        long j4 = this.f47881k;
        if (jRemaining <= j3 - j4) {
            this.f47871a.position(j4);
            this.f47871a.write(byteBufferE);
            this.f47871a.write(BoxUtils.c("free", ByteBuffer.allocate((int) ((this.f47882l - this.f47871a.position()) - 8))));
        } else {
            this.f47883m = false;
            long j5 = this.f47886p;
            this.f47885o = j5;
            this.f47871a.position(j5);
            this.f47871a.write(byteBufferE);
            this.f47887q = Range.f(Long.valueOf(this.f47885o), Long.valueOf(this.f47885o + ((long) iRemaining)));
            this.f47871a.write(BoxUtils.c("free", ByteBuffer.allocate((int) ((this.f47882l - this.f47881k) - 8))), this.f47881k);
        }
        p(this.f47886p - this.f47884n);
    }

    private boolean m(List list) throws IOException {
        boolean z2 = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Track track = (Track) list.get(i3);
            if (track.f47895g.size() > 2) {
                if (((MediaCodec.BufferInfo) Assertions.e((MediaCodec.BufferInfo) track.f47895g.peekLast())).presentationTimeUs - ((MediaCodec.BufferInfo) Assertions.e((MediaCodec.BufferInfo) track.f47895g.peekFirst())).presentationTimeUs > 1000000) {
                    s(track);
                    z2 = true;
                }
            }
        }
        return z2;
    }

    private void n(long j3) throws IOException {
        o(Math.max(this.f47885o + j3, ((Long) this.f47887q.D()).longValue()), e());
    }

    private void o(long j3, ByteBuffer byteBuffer) throws IOException {
        Assertions.g(j3 >= ((Long) this.f47887q.D()).longValue());
        Assertions.g(j3 >= this.f47885o);
        this.f47871a.position(j3);
        this.f47871a.write(BoxUtils.c("free", byteBuffer.duplicate()));
        long j4 = 8 + j3;
        this.f47885o = j4;
        p(j4 - this.f47884n);
        this.f47887q = Range.f(Long.valueOf(j3), Long.valueOf(j3 + ((long) byteBuffer.remaining())));
    }

    private void p(long j3) throws IOException {
        this.f47871a.position(this.f47884n + 8);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putLong(j3);
        byteBufferAllocate.flip();
        this.f47871a.write(byteBufferAllocate);
    }

    private void q() throws IOException {
        MdtaMetadataEntry mdtaMetadataEntryC = MuxerUtil.c(0L);
        this.f47872b.a(mdtaMetadataEntryC);
        ByteBuffer byteBufferI = i();
        this.f47872b.a(MuxerUtil.a(byteBufferI.remaining()));
        g();
        this.f47872b.b(mdtaMetadataEntryC);
        this.f47872b.a(MuxerUtil.c(this.f47871a.size()));
        long size = this.f47871a.size();
        g();
        Assertions.g(size == this.f47871a.size());
        FileChannel fileChannel = this.f47871a;
        fileChannel.position(fileChannel.size());
        this.f47871a.write(byteBufferI);
    }

    private void r() throws IOException {
        this.f47871a.position(0L);
        this.f47871a.write(Boxes.w());
        if (this.f47883m) {
            this.f47881k = this.f47871a.position();
            this.f47871a.write(BoxUtils.c("free", ByteBuffer.allocate(400000)));
            this.f47882l = this.f47871a.position();
        }
        this.f47884n = this.f47871a.position();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.put(Util.t0("mdat"));
        byteBufferAllocate.putLong(16L);
        byteBufferAllocate.flip();
        this.f47871a.write(byteBufferAllocate);
        long j3 = this.f47884n + 16;
        this.f47886p = j3;
        if (this.f47883m) {
            j3 = Long.MAX_VALUE;
        }
        this.f47885o = j3;
    }

    private void s(Track track) throws IOException {
        Assertions.g(track.f47896h.size() == track.f47895g.size());
        if (track.f47895g.isEmpty()) {
            return;
        }
        if (!this.f47879i.getAndSet(true)) {
            r();
        }
        Iterator it = track.f47896h.iterator();
        long jLimit = 0;
        while (it.hasNext()) {
            jLimit += (long) ((ByteBuffer) it.next()).limit();
        }
        k(jLimit);
        track.f47893e.add(Long.valueOf(this.f47886p));
        track.f47894f.add(Integer.valueOf(track.f47895g.size()));
        do {
            MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo) track.f47895g.removeFirst();
            ByteBuffer byteBufferB = (ByteBuffer) track.f47896h.removeFirst();
            if (AnnexBUtils.a((String) Assertions.e(track.f47890b.f40632o))) {
                byteBufferB = this.f47873c.b(byteBufferB, this.f47880j);
                bufferInfo.set(byteBufferB.position(), byteBufferB.remaining(), bufferInfo.presentationTimeUs, bufferInfo.flags);
            }
            k(byteBufferB.remaining());
            long j3 = this.f47886p;
            this.f47886p = j3 + ((long) this.f47871a.write(byteBufferB, j3));
            this.f47880j.b();
            track.f47892d.add(bufferInfo);
        } while (!track.f47895g.isEmpty());
        Assertions.g(this.f47886p <= this.f47885o);
    }

    public Track c(int i3, int i4, Format format) {
        Track track = new Track(i3, format, i4, this.f47875e);
        this.f47878h.add(track);
        Collections.sort(this.f47878h, new Comparator() { // from class: androidx.media3.muxer.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((Track) obj).f47891c, ((Track) obj2).f47891c);
            }
        });
        return track;
    }

    public Track d(int i3, int i4, Format format) {
        Track track = new Track(i3, format, i4, this.f47875e);
        this.f47877g.add(track);
        Collections.sort(this.f47877g, new Comparator() { // from class: androidx.media3.muxer.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((Track) obj).f47891c, ((Track) obj2).f47891c);
            }
        });
        return track;
    }

    public void g() throws IOException {
        if (this.f47883m) {
            l();
            return;
        }
        ByteBuffer byteBufferE = e();
        int iRemaining = byteBufferE.remaining();
        long j3 = iRemaining + 8;
        if (this.f47885o - this.f47886p < j3) {
            o(((Long) this.f47887q.D()).longValue() + j3, byteBufferE);
            Assertions.g(this.f47885o - this.f47886p >= j3);
        }
        long j4 = this.f47886p;
        this.f47871a.position(j4);
        this.f47871a.write(byteBufferE);
        long j5 = ((long) iRemaining) + j4;
        long jLongValue = ((Long) this.f47887q.D()).longValue() - j5;
        Assertions.g(jLongValue < 2147483647L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt((int) jLongValue);
        byteBufferAllocate.put(Util.t0("free"));
        byteBufferAllocate.flip();
        this.f47871a.write(byteBufferAllocate);
        this.f47885o = j4;
        p(j4 - this.f47884n);
        this.f47887q = Range.f(Long.valueOf(j4), Long.valueOf(j4 + ((long) byteBufferE.limit())));
        this.f47871a.truncate(j5);
    }

    public void h() throws IOException {
        for (int i3 = 0; i3 < this.f47877g.size(); i3++) {
            s((Track) this.f47877g.get(i3));
        }
        for (int i4 = 0; i4 < this.f47878h.size(); i4++) {
            s((Track) this.f47878h.get(i4));
        }
        if (this.f47879i.get()) {
            g();
            if (this.f47878h.isEmpty()) {
                return;
            }
            q();
        }
    }

    public void t(Track track, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws IOException {
        track.b(byteBuffer, bufferInfo);
        if (this.f47876f) {
            f();
            return;
        }
        s(track);
        boolean zContains = this.f47877g.contains(track);
        long j3 = bufferInfo.presentationTimeUs;
        if (zContains && this.f47883m && j3 - this.f47888r >= 1000000) {
            l();
            this.f47888r = j3;
        }
    }
}
