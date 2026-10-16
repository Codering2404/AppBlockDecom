package androidx.media3.exoplayer.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.extractor.metadata.MetadataDecoder;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    private long A;
    private Metadata B;
    private long C;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MetadataDecoderFactory f44345s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MetadataOutput f44346t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Handler f44347u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final MetadataInputBuffer f44348v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final boolean f44349w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private MetadataDecoder f44350x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f44351y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f44352z;

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.f44344a);
    }

    private void s0(Metadata metadata, List list) {
        for (int i3 = 0; i3 < metadata.e(); i3++) {
            Format formatA = metadata.d(i3).a();
            if (formatA == null || !this.f44345s.a(formatA)) {
                list.add(metadata.d(i3));
            } else {
                MetadataDecoder metadataDecoderB = this.f44345s.b(formatA);
                byte[] bArr = (byte[]) Assertions.e(metadata.d(i3).c());
                this.f44348v.f();
                this.f44348v.p(bArr.length);
                ((ByteBuffer) Util.k(this.f44348v.f42138d)).put(bArr);
                this.f44348v.q();
                Metadata metadataA = metadataDecoderB.a(this.f44348v);
                if (metadataA != null) {
                    s0(metadataA, list);
                }
            }
        }
    }

    private long t0(long j3) {
        Assertions.g(j3 != -9223372036854775807L);
        Assertions.g(this.C != -9223372036854775807L);
        return j3 - this.C;
    }

    private void u0(Metadata metadata) {
        Handler handler = this.f44347u;
        if (handler != null) {
            handler.obtainMessage(1, metadata).sendToTarget();
        } else {
            v0(metadata);
        }
    }

    private void v0(Metadata metadata) {
        this.f44346t.u(metadata);
    }

    private boolean w0(long j3) {
        boolean z2;
        Metadata metadata = this.B;
        if (metadata == null || (!this.f44349w && metadata.f40926b > t0(j3))) {
            z2 = false;
        } else {
            u0(this.B);
            this.B = null;
            z2 = true;
        }
        if (this.f44351y && this.B == null) {
            this.f44352z = true;
        }
        return z2;
    }

    private void x0() {
        if (this.f44351y || this.B != null) {
            return;
        }
        this.f44348v.f();
        FormatHolder formatHolderW = W();
        int iP0 = p0(formatHolderW, this.f44348v, 0);
        if (iP0 != -4) {
            if (iP0 == -5) {
                this.A = ((Format) Assertions.e(formatHolderW.f43108b)).f40637t;
                return;
            }
            return;
        }
        if (this.f44348v.i()) {
            this.f44351y = true;
            return;
        }
        if (this.f44348v.f42140g >= Y()) {
            MetadataInputBuffer metadataInputBuffer = this.f44348v;
            metadataInputBuffer.f46412k = this.A;
            metadataInputBuffer.q();
            Metadata metadataA = ((MetadataDecoder) Util.k(this.f44350x)).a(this.f44348v);
            if (metadataA != null) {
                ArrayList arrayList = new ArrayList(metadataA.e());
                s0(metadataA, arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                this.B = new Metadata(t0(this.f44348v.f42140g), arrayList);
            }
        }
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public int a(Format format) {
        if (this.f44345s.a(format)) {
            return RendererCapabilities.u(format.N == 0 ? 4 : 2);
        }
        return RendererCapabilities.u(0);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean b() {
        return this.f44352z;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void e0() {
        this.B = null;
        this.f44350x = null;
        this.C = -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void h(long j3, long j4) {
        boolean zW0 = true;
        while (zW0) {
            x0();
            zW0 = w0(j3);
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void h0(long j3, boolean z2) {
        this.B = null;
        this.f44351y = false;
        this.f44352z = false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        v0((Metadata) message.obj);
        return true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void n0(Format[] formatArr, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f44350x = this.f44345s.b(formatArr[0]);
        Metadata metadata = this.B;
        if (metadata != null) {
            this.B = metadata.c((metadata.f40926b + this.C) - j4);
        }
        this.C = j4;
    }

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        this(metadataOutput, looper, metadataDecoderFactory, false);
    }

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper, MetadataDecoderFactory metadataDecoderFactory, boolean z2) {
        super(5);
        this.f44346t = (MetadataOutput) Assertions.e(metadataOutput);
        this.f44347u = looper == null ? null : Util.B(looper, this);
        this.f44345s = (MetadataDecoderFactory) Assertions.e(metadataDecoderFactory);
        this.f44349w = z2;
        this.f44348v = new MetadataInputBuffer();
        this.C = -9223372036854775807L;
    }
}
