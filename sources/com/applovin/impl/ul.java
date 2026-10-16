package com.applovin.impl;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.applovin.impl.gd;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ul implements gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f64269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Surface f64270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteBuffer[] f64271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer[] f64272d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {
        public static Surface a(MediaCodec mediaCodec) {
            return mediaCodec.createInputSurface();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class c implements gd.b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.applovin.impl.ul$a] */
        /* JADX WARN: Type inference failed for: r0v1, types: [android.view.Surface] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        @Override // com.applovin.impl.gd.b
        public gd a(gd.a aVar) throws Throwable {
            MediaCodec mediaCodecB;
            Surface surfaceA;
            ?? r02 = 0;
            r02 = 0;
            r02 = 0;
            try {
                mediaCodecB = b(aVar);
                try {
                    ko.a("configureCodec");
                    mediaCodecB.configure(aVar.f59965b, aVar.f59967d, aVar.f59968e, aVar.f59969f);
                    ko.a();
                    if (!aVar.f59970g) {
                        surfaceA = null;
                    } else {
                        if (xp.f65027a < 18) {
                            throw new IllegalStateException("Encoding from a surface is only supported on API 18 and up.");
                        }
                        surfaceA = b.a(mediaCodecB);
                    }
                } catch (IOException e3) {
                    e = e3;
                } catch (RuntimeException e4) {
                    e = e4;
                }
                try {
                    ko.a("startCodec");
                    mediaCodecB.start();
                    ko.a();
                    return new ul(mediaCodecB, surfaceA);
                } catch (IOException | RuntimeException e5) {
                    r02 = surfaceA;
                    e = e5;
                    if (r02 != 0) {
                        r02.release();
                    }
                    if (mediaCodecB != null) {
                        mediaCodecB.release();
                    }
                    throw e;
                }
            } catch (IOException | RuntimeException e6) {
                e = e6;
                mediaCodecB = null;
            }
        }

        protected MediaCodec b(gd.a aVar) throws IOException {
            b1.a(aVar.f59964a);
            String str = aVar.f59964a.f60691a;
            ko.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            ko.a();
            return mediaCodecCreateByCodecName;
        }
    }

    private ul(MediaCodec mediaCodec, Surface surface) {
        this.f64269a = mediaCodec;
        this.f64270b = surface;
        if (xp.f65027a < 21) {
            this.f64271c = mediaCodec.getInputBuffers();
            this.f64272d = mediaCodec.getOutputBuffers();
        }
    }

    @Override // com.applovin.impl.gd
    public void b() {
        this.f64269a.flush();
    }

    @Override // com.applovin.impl.gd
    public boolean c() {
        return false;
    }

    @Override // com.applovin.impl.gd
    public int d() {
        return this.f64269a.dequeueInputBuffer(0L);
    }

    @Override // com.applovin.impl.gd
    public MediaFormat e() {
        return this.f64269a.getOutputFormat();
    }

    @Override // com.applovin.impl.gd
    public int a(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.f64269a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && xp.f65027a < 21) {
                this.f64272d = this.f64269a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.applovin.impl.gd
    public ByteBuffer b(int i3) {
        return xp.f65027a >= 21 ? this.f64269a.getOutputBuffer(i3) : ((ByteBuffer[]) xp.a((Object) this.f64272d))[i3];
    }

    @Override // com.applovin.impl.gd
    public void c(int i3) {
        this.f64269a.setVideoScalingMode(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(gd.c cVar, MediaCodec mediaCodec, long j3, long j4) {
        cVar.a(this, j3, j4);
    }

    @Override // com.applovin.impl.gd
    public void a(int i3, int i4, int i5, long j3, int i6) {
        this.f64269a.queueInputBuffer(i3, i4, i5, j3, i6);
    }

    @Override // com.applovin.impl.gd
    public void a(int i3, int i4, z4 z4Var, long j3, int i5) {
        this.f64269a.queueSecureInputBuffer(i3, i4, z4Var.a(), j3, i5);
    }

    @Override // com.applovin.impl.gd
    public void a() {
        this.f64271c = null;
        this.f64272d = null;
        Surface surface = this.f64270b;
        if (surface != null) {
            surface.release();
        }
        this.f64269a.release();
    }

    @Override // com.applovin.impl.gd
    public void a(int i3, long j3) {
        this.f64269a.releaseOutputBuffer(i3, j3);
    }

    @Override // com.applovin.impl.gd
    public void a(int i3, boolean z2) {
        this.f64269a.releaseOutputBuffer(i3, z2);
    }

    @Override // com.applovin.impl.gd
    public void a(final gd.c cVar, Handler handler) {
        this.f64269a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.applovin.impl.s60
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j3, long j4) {
                this.f62997a.a(cVar, mediaCodec, j3, j4);
            }
        }, handler);
    }

    @Override // com.applovin.impl.gd
    public void a(Surface surface) {
        this.f64269a.setOutputSurface(surface);
    }

    @Override // com.applovin.impl.gd
    public void a(Bundle bundle) {
        this.f64269a.setParameters(bundle);
    }

    @Override // com.applovin.impl.gd
    public ByteBuffer a(int i3) {
        if (xp.f65027a >= 21) {
            return this.f64269a.getInputBuffer(i3);
        }
        return ((ByteBuffer[]) xp.a((Object) this.f64271c))[i3];
    }
}
