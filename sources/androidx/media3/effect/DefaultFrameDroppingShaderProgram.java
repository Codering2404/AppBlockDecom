package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class DefaultFrameDroppingShaderProgram extends FrameCacheGlShaderProgram {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f42277i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f42278j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f42279k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f42280l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f42281m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private GlTextureInfo f42282n;

    public DefaultFrameDroppingShaderProgram(Context context, boolean z2, float f3) {
        super(context, 1, z2);
        this.f42277i = z2;
        this.f42278j = (long) (1000000.0f / f3);
        this.f42280l = -9223372036854775807L;
        this.f42279k = -9223372036854775807L;
    }

    private void s(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3) {
        try {
            if (this.f42282n == null) {
                this.f42282n = glObjectsProvider.b(GlUtil.u(glTextureInfo.f40693d, glTextureInfo.f40694e, this.f42277i), glTextureInfo.f40693d, glTextureInfo.f40694e);
            }
            GlTextureInfo glTextureInfoB = (GlTextureInfo) Assertions.e(this.f42282n);
            if (glTextureInfoB.f40694e != glTextureInfo.f40694e || glTextureInfoB.f40693d != glTextureInfo.f40693d) {
                glTextureInfoB.a();
                glTextureInfoB = glObjectsProvider.b(GlUtil.u(glTextureInfo.f40693d, glTextureInfo.f40694e, this.f42277i), glTextureInfo.f40693d, glTextureInfo.f40694e);
            }
            GlUtil.H(glTextureInfoB.f40691b, glTextureInfoB.f40693d, glTextureInfoB.f40694e);
            GlUtil.g();
            n(glTextureInfo.f40690a, j3);
            this.f42279k = j3;
            this.f42282n = glTextureInfoB;
        } catch (VideoFrameProcessingException e3) {
            e = e3;
            q(e);
        } catch (GlUtil.GlException e4) {
            e = e4;
            q(e);
        }
    }

    private void t(GlObjectsProvider glObjectsProvider) {
        try {
            GlTextureInfo glTextureInfo = (GlTextureInfo) Assertions.e(this.f42282n);
            Size sizeJ = j(glTextureInfo.f40693d, glTextureInfo.f40694e);
            this.f42175a.d(glObjectsProvider, sizeJ.b(), sizeJ.a());
            GlTextureInfo glTextureInfoL = this.f42175a.l();
            GlUtil.H(glTextureInfoL.f40691b, glTextureInfoL.f40693d, glTextureInfoL.f40694e);
            GlUtil.g();
            n(glTextureInfo.f40690a, this.f42279k);
            p().a(glTextureInfoL, this.f42279k);
            this.f42280l = this.f42279k;
        } catch (VideoFrameProcessingException | GlUtil.GlException e3) {
            q(e3);
        }
    }

    private void u() {
        try {
            GlTextureInfo glTextureInfo = this.f42282n;
            if (glTextureInfo != null) {
                glTextureInfo.a();
            }
        } catch (GlUtil.GlException e3) {
            q(e3);
        }
        this.f42280l = -9223372036854775807L;
        this.f42279k = -9223372036854775807L;
        this.f42281m = 0;
    }

    private boolean v(long j3) {
        if (this.f42281m == 2) {
            return false;
        }
        long j4 = this.f42279k;
        long j5 = this.f42280l;
        return Math.abs((j4 - j5) - this.f42278j) < Math.abs((j3 - j5) - this.f42278j);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void c() {
        super.c();
        u();
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3) {
        int i3 = this.f42281m + 1;
        this.f42281m = i3;
        if (i3 == 1) {
            s(glObjectsProvider, glTextureInfo, j3);
            t(glObjectsProvider);
            o().e(glTextureInfo);
            o().f();
            return;
        }
        if (v(j3)) {
            t(glObjectsProvider);
        }
        s(glObjectsProvider, glTextureInfo, j3);
        o().e(glTextureInfo);
        if (this.f42175a.h() > 0) {
            o().f();
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void flush() {
        super.flush();
        u();
    }

    @Override // androidx.media3.effect.FrameCacheGlShaderProgram, androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            GlTextureInfo glTextureInfo = this.f42282n;
            if (glTextureInfo != null) {
                glTextureInfo.a();
            }
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }
}
