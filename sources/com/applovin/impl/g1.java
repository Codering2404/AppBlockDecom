package com.applovin.impl;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.applovin.exoplayer2.common.base.Supplier;
import com.applovin.impl.g1;
import com.applovin.impl.gd;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class g1 implements gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f59842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i1 f59843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h1 f59844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f59845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f59846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f59847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Surface f59848g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b implements gd.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Supplier f59849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Supplier f59850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f59851d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f59852e;

        public b(final int i3, boolean z2, boolean z3) {
            this(new Supplier() { // from class: com.applovin.impl.hx
                @Override // com.applovin.exoplayer2.common.base.Supplier
                public final Object get() {
                    return g1.b.a(i3);
                }
            }, new Supplier() { // from class: com.applovin.impl.ix
                @Override // com.applovin.exoplayer2.common.base.Supplier
                public final Object get() {
                    return g1.b.b(i3);
                }
            }, z2, z3);
        }

        @Override // com.applovin.impl.gd.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g1 a(gd.a aVar) throws Exception {
            Exception exc;
            MediaCodec mediaCodecCreateByCodecName;
            String str = aVar.f59964a.f60691a;
            g1 g1Var = null;
            try {
                ko.a("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    g1 g1Var2 = new g1(mediaCodecCreateByCodecName, (HandlerThread) this.f59849b.get(), (HandlerThread) this.f59850c.get(), this.f59851d, this.f59852e);
                    try {
                        ko.a();
                    } catch (Exception e3) {
                        e = e3;
                    }
                    try {
                        g1Var2.a(aVar.f59965b, aVar.f59967d, aVar.f59968e, aVar.f59969f, aVar.f59970g);
                        return g1Var2;
                    } catch (Exception e4) {
                        e = e4;
                        g1Var2 = g1Var2;
                        exc = e;
                        g1Var = g1Var2;
                        if (g1Var != null) {
                            g1Var.a();
                            throw exc;
                        }
                        if (mediaCodecCreateByCodecName == null) {
                            throw exc;
                        }
                        mediaCodecCreateByCodecName.release();
                        throw exc;
                    }
                } catch (Exception e5) {
                    exc = e5;
                }
            } catch (Exception e6) {
                exc = e6;
                mediaCodecCreateByCodecName = null;
            }
        }

        b(Supplier supplier, Supplier supplier2, boolean z2, boolean z3) {
            this.f59849b = supplier;
            this.f59850c = supplier2;
            this.f59851d = z2;
            this.f59852e = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread a(int i3) {
            return new HandlerThread(g1.f(i3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread b(int i3) {
            return new HandlerThread(g1.g(i3));
        }
    }

    private g1(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z2, boolean z3) {
        this.f59842a = mediaCodec;
        this.f59843b = new i1(handlerThread);
        this.f59844c = new h1(mediaCodec, handlerThread2, z2);
        this.f59845d = z3;
        this.f59847f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(int i3) {
        return a(i3, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(int i3) {
        return a(i3, "ExoPlayer:MediaCodecQueueingThread:");
    }

    @Override // com.applovin.impl.gd
    public void b() {
        this.f59844c.b();
        this.f59842a.flush();
        i1 i1Var = this.f59843b;
        final MediaCodec mediaCodec = this.f59842a;
        Objects.requireNonNull(mediaCodec);
        i1Var.a(new Runnable() { // from class: com.applovin.impl.fx
            @Override // java.lang.Runnable
            public final void run() {
                mediaCodec.start();
            }
        });
    }

    @Override // com.applovin.impl.gd
    public boolean c() {
        return false;
    }

    private void f() {
        if (this.f59845d) {
            try {
                this.f59844c.i();
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e3);
            }
        }
    }

    @Override // com.applovin.impl.gd
    public void c(int i3) {
        f();
        this.f59842a.setVideoScalingMode(i3);
    }

    @Override // com.applovin.impl.gd
    public int d() {
        return this.f59843b.a();
    }

    @Override // com.applovin.impl.gd
    public MediaFormat e() {
        return this.f59843b.c();
    }

    private static String a(int i3, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i3 == 1) {
            sb.append("Audio");
        } else if (i3 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i3);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // com.applovin.impl.gd
    public ByteBuffer b(int i3) {
        return this.f59842a.getOutputBuffer(i3);
    }

    @Override // com.applovin.impl.gd
    public int a(MediaCodec.BufferInfo bufferInfo) {
        return this.f59843b.a(bufferInfo);
    }

    @Override // com.applovin.impl.gd
    public ByteBuffer a(int i3) {
        return this.f59842a.getInputBuffer(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i3, boolean z2) {
        this.f59843b.a(this.f59842a);
        ko.a("configureCodec");
        this.f59842a.configure(mediaFormat, surface, mediaCrypto, i3);
        ko.a();
        if (z2) {
            this.f59848g = this.f59842a.createInputSurface();
        }
        this.f59844c.h();
        ko.a("startCodec");
        this.f59842a.start();
        ko.a();
        this.f59847f = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(gd.c cVar, MediaCodec mediaCodec, long j3, long j4) {
        cVar.a(this, j3, j4);
    }

    @Override // com.applovin.impl.gd
    public void a(int i3, int i4, int i5, long j3, int i6) {
        this.f59844c.b(i3, i4, i5, j3, i6);
    }

    @Override // com.applovin.impl.gd
    public void a(int i3, int i4, z4 z4Var, long j3, int i5) {
        this.f59844c.a(i3, i4, z4Var, j3, i5);
    }

    @Override // com.applovin.impl.gd
    public void a() {
        try {
            if (this.f59847f == 1) {
                this.f59844c.g();
                this.f59843b.h();
            }
            this.f59847f = 2;
            Surface surface = this.f59848g;
            if (surface != null) {
                surface.release();
            }
            if (this.f59846e) {
                return;
            }
            this.f59842a.release();
            this.f59846e = true;
        } catch (Throwable th) {
            Surface surface2 = this.f59848g;
            if (surface2 != null) {
                surface2.release();
            }
            if (!this.f59846e) {
                this.f59842a.release();
                this.f59846e = true;
            }
            throw th;
        }
    }

    @Override // com.applovin.impl.gd
    public void a(int i3, long j3) {
        this.f59842a.releaseOutputBuffer(i3, j3);
    }

    @Override // com.applovin.impl.gd
    public void a(int i3, boolean z2) {
        this.f59842a.releaseOutputBuffer(i3, z2);
    }

    @Override // com.applovin.impl.gd
    public void a(final gd.c cVar, Handler handler) {
        f();
        this.f59842a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.applovin.impl.gx
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j3, long j4) {
                this.f60065a.a(cVar, mediaCodec, j3, j4);
            }
        }, handler);
    }

    @Override // com.applovin.impl.gd
    public void a(Surface surface) {
        f();
        this.f59842a.setOutputSurface(surface);
    }

    @Override // com.applovin.impl.gd
    public void a(Bundle bundle) {
        f();
        this.f59842a.setParameters(bundle);
    }
}
