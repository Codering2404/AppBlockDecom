package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SimpleFrameDroppingShaderProgram extends PassthroughShaderProgram {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f42596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f42597g;

    public SimpleFrameDroppingShaderProgram(float f3, float f4) {
        int iRound = Math.round(f3 / f4);
        this.f42596f = iRound;
        Assertions.b(iRound >= 1, "The input frame rate should be greater than the target frame rate.");
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void c() {
        super.c();
        this.f42597g = 0;
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3) {
        if (this.f42597g % this.f42596f == 0) {
            super.d(glObjectsProvider, glTextureInfo, j3);
        } else {
            f().e(glTextureInfo);
            f().f();
        }
        this.f42597g++;
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void flush() {
        super.flush();
        this.f42597g = 0;
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() {
        super.release();
        this.f42597g = 0;
    }
}
