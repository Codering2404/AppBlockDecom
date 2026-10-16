package androidx.media3.effect;

import android.opengl.GLES20;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlRect;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.effect.ByteBufferGlEffect;
import androidx.media3.effect.QueuingGlShaderProgram;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ByteBufferConcurrentEffect<T> implements QueuingGlShaderProgram.ConcurrentEffect<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBufferGlEffect.Processor f42207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f42208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue f42209c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue f42210d = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PixelBufferObjectProvider f42211e = new PixelBufferObjectProvider();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f42212f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f42213g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private GlTextureInfo f42214h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PixelBufferObjectInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f42216b;

        public PixelBufferObjectInfo(int i3) {
            this.f42216b = i3;
            this.f42215a = GlUtil.s(i3);
        }

        public void a() throws GlUtil.GlException {
            GlUtil.y(this.f42215a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PixelBufferObjectProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue f42217a = new ArrayDeque();

        /* JADX INFO: Access modifiers changed from: private */
        public PixelBufferObjectInfo c(int i3) throws GlUtil.GlException {
            while (true) {
                PixelBufferObjectInfo pixelBufferObjectInfo = (PixelBufferObjectInfo) this.f42217a.poll();
                if (pixelBufferObjectInfo == null) {
                    return new PixelBufferObjectInfo(i3);
                }
                if (pixelBufferObjectInfo.f42216b == i3) {
                    return pixelBufferObjectInfo;
                }
                GlUtil.y(pixelBufferObjectInfo.f42215a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(PixelBufferObjectInfo pixelBufferObjectInfo) {
            this.f42217a.add(pixelBufferObjectInfo);
        }

        public void e() throws GlUtil.GlException {
            while (true) {
                PixelBufferObjectInfo pixelBufferObjectInfo = (PixelBufferObjectInfo) this.f42217a.poll();
                if (pixelBufferObjectInfo == null) {
                    return;
                } else {
                    pixelBufferObjectInfo.a();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TexturePixelBuffer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SettableFuture f42218a = SettableFuture.F();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final GlTextureInfo f42219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private PixelBufferObjectInfo f42220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f42221d;

        public TexturePixelBuffer(GlTextureInfo glTextureInfo) {
            this.f42219b = glTextureInfo;
        }

        public void a() throws GlUtil.GlException {
            ByteBuffer byteBufferV;
            Assertions.e(this.f42220c);
            if (Util.f41609a >= 24) {
                PixelBufferObjectInfo pixelBufferObjectInfo = this.f42220c;
                byteBufferV = GlUtil.V(pixelBufferObjectInfo.f42215a, pixelBufferObjectInfo.f42216b);
            } else {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(ByteBufferConcurrentEffect.g(this.f42219b));
                GlTextureInfo glTextureInfo = this.f42219b;
                GlUtil.H(glTextureInfo.f40691b, glTextureInfo.f40693d, glTextureInfo.f40694e);
                GlUtil.e();
                GlTextureInfo glTextureInfo2 = this.f42219b;
                GLES20.glReadPixels(0, 0, glTextureInfo2.f40693d, glTextureInfo2.f40694e, 6408, 5121, byteBufferAllocateDirect);
                GlUtil.e();
                byteBufferV = byteBufferAllocateDirect;
            }
            SettableFuture settableFuture = this.f42218a;
            GlTextureInfo glTextureInfo3 = this.f42219b;
            settableFuture.B(new ByteBufferGlEffect.Image(glTextureInfo3.f40693d, glTextureInfo3.f40694e, byteBufferV));
            this.f42221d = true;
        }

        public void b(PixelBufferObjectProvider pixelBufferObjectProvider) throws GlUtil.GlException {
            PixelBufferObjectInfo pixelBufferObjectInfoC = pixelBufferObjectProvider.c(ByteBufferConcurrentEffect.g(this.f42219b));
            this.f42220c = pixelBufferObjectInfoC;
            if (Util.f41609a >= 24) {
                GlTextureInfo glTextureInfo = this.f42219b;
                GlUtil.W(glTextureInfo.f40691b, glTextureInfo.f40693d, glTextureInfo.f40694e, pixelBufferObjectInfoC.f42215a);
            }
        }

        public void c(PixelBufferObjectProvider pixelBufferObjectProvider) throws GlUtil.GlException {
            Assertions.e(this.f42220c);
            if (this.f42221d && Util.f41609a >= 24) {
                GlUtil.Z(this.f42220c.f42215a);
            }
            pixelBufferObjectProvider.d(this.f42220c);
        }
    }

    public ByteBufferConcurrentEffect(int i3, ByteBufferGlEffect.Processor processor) {
        this.f42207a = processor;
        this.f42208b = i3;
    }

    private boolean f() throws GlUtil.GlException {
        TexturePixelBuffer texturePixelBuffer = (TexturePixelBuffer) this.f42209c.poll();
        if (texturePixelBuffer == null) {
            return false;
        }
        texturePixelBuffer.a();
        this.f42210d.add(texturePixelBuffer);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(GlTextureInfo glTextureInfo) {
        return glTextureInfo.f40693d * glTextureInfo.f40694e * 4;
    }

    private void h() throws GlUtil.GlException {
        while (true) {
            TexturePixelBuffer texturePixelBuffer = (TexturePixelBuffer) this.f42209c.poll();
            if (texturePixelBuffer == null) {
                break;
            } else {
                texturePixelBuffer.c(this.f42211e);
            }
        }
        while (true) {
            TexturePixelBuffer texturePixelBuffer2 = (TexturePixelBuffer) this.f42210d.poll();
            if (texturePixelBuffer2 == null) {
                return;
            } else {
                texturePixelBuffer2.c(this.f42211e);
            }
        }
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void a(GlTextureInfo glTextureInfo, long j3, Object obj) throws VideoFrameProcessingException {
        try {
            ((TexturePixelBuffer) Assertions.e((TexturePixelBuffer) this.f42210d.poll())).c(this.f42211e);
            this.f42207a.a(glTextureInfo, j3, obj);
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void c() throws VideoFrameProcessingException {
        do {
            try {
            } catch (GlUtil.GlException e3) {
                throw new VideoFrameProcessingException(e3);
            }
        } while (f());
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public Future d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j3) {
        while (this.f42209c.size() >= this.f42208b) {
            try {
                Assertions.g(f());
            } catch (VideoFrameProcessingException e3) {
                e = e3;
                return Futures.e(e);
            } catch (GlUtil.GlException e4) {
                e = e4;
                return Futures.e(e);
            }
        }
        if (this.f42214h == null || glTextureInfo.f40693d != this.f42212f || glTextureInfo.f40694e != this.f42213g) {
            while (f()) {
            }
            int i3 = glTextureInfo.f40693d;
            this.f42212f = i3;
            int i4 = glTextureInfo.f40694e;
            this.f42213g = i4;
            Size sizeC = this.f42207a.c(i3, i4);
            GlTextureInfo glTextureInfo2 = this.f42214h;
            if (glTextureInfo2 != null) {
                glTextureInfo2.a();
            }
            this.f42214h = glObjectsProvider.b(GlUtil.u(sizeC.b(), sizeC.a(), false), sizeC.b(), sizeC.a());
        }
        int i5 = glTextureInfo.f40691b;
        GlRect glRectD = this.f42207a.d(j3);
        GlTextureInfo glTextureInfo3 = this.f42214h;
        GlUtil.c(i5, glRectD, glTextureInfo3.f40691b, new GlRect(glTextureInfo3.f40693d, glTextureInfo3.f40694e));
        TexturePixelBuffer texturePixelBuffer = new TexturePixelBuffer(this.f42214h);
        texturePixelBuffer.b(this.f42211e);
        this.f42209c.add(texturePixelBuffer);
        return Util.r1(texturePixelBuffer.f42218a, new AsyncFunction() { // from class: androidx.media3.effect.k
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return this.f42739a.f42207a.e((ByteBufferGlEffect.Image) obj, j3);
            }
        });
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void flush() throws VideoFrameProcessingException {
        try {
            h();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void release() throws VideoFrameProcessingException {
        try {
            h();
            this.f42211e.e();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }
}
