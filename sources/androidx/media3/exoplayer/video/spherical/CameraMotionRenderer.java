package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.RendererCapabilities;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraMotionRenderer extends BaseRenderer {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final DecoderInputBuffer f45912s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ParsableByteArray f45913t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CameraMotionListener f45914u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f45915v;

    public CameraMotionRenderer() {
        super(6);
        this.f45912s = new DecoderInputBuffer(1);
        this.f45913t = new ParsableByteArray();
    }

    private float[] s0(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f45913t.U(byteBuffer.array(), byteBuffer.limit());
        this.f45913t.W(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr[i3] = Float.intBitsToFloat(this.f45913t.u());
        }
        return fArr;
    }

    private void t0() {
        CameraMotionListener cameraMotionListener = this.f45914u;
        if (cameraMotionListener != null) {
            cameraMotionListener.d();
        }
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public int a(Format format) {
        return "application/x-camera-motion".equals(format.f40632o) ? RendererCapabilities.u(4) : RendererCapabilities.u(0);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean b() {
        return k();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void e0() {
        t0();
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void h(long j3, long j4) {
        while (!k() && this.f45915v < 100000 + j3) {
            this.f45912s.f();
            if (p0(W(), this.f45912s, 0) != -4 || this.f45912s.i()) {
                return;
            }
            long j5 = this.f45912s.f42140g;
            this.f45915v = j5;
            boolean z2 = j5 < Y();
            if (this.f45914u != null && !z2) {
                this.f45912s.q();
                float[] fArrS0 = s0((ByteBuffer) Util.k(this.f45912s.f42138d));
                if (fArrS0 != null) {
                    ((CameraMotionListener) Util.k(this.f45914u)).a(this.f45915v - b0(), fArrS0);
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void h0(long j3, boolean z2) {
        this.f45915v = Long.MIN_VALUE;
        t0();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void w(int i3, Object obj) {
        if (i3 == 8) {
            this.f45914u = (CameraMotionListener) obj;
        } else {
            super.w(i3, obj);
        }
    }
}
