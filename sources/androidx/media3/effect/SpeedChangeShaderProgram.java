package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.audio.SpeedProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SpeedChangeShaderProgram extends PassthroughShaderProgram {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OffsetSpeedProvider f42617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f42618g = -9223372036854775807L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f42619h = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class OffsetSpeedProvider implements SpeedProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SpeedProvider f42620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f42621b;

        public OffsetSpeedProvider(SpeedProvider speedProvider) {
            this.f42620a = speedProvider;
        }

        @Override // androidx.media3.common.audio.SpeedProvider
        public float a(long j3) {
            return this.f42620a.a(j3 - this.f42621b);
        }

        @Override // androidx.media3.common.audio.SpeedProvider
        public long b(long j3) {
            long jB = this.f42620a.b(j3 - this.f42621b);
            if (jB == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f42621b + jB;
        }

        public void c(long j3) {
            this.f42621b = j3;
        }
    }

    public SpeedChangeShaderProgram(SpeedProvider speedProvider) {
        this.f42617f = new OffsetSpeedProvider(speedProvider);
    }

    private long n(long j3, float f3) {
        return (long) (this.f42619h + ((j3 - this.f42618g) / f3));
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void c() {
        super.c();
        this.f42618g = -9223372036854775807L;
        this.f42619h = -9223372036854775807L;
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3) {
        long j4 = this.f42618g;
        if (j4 == -9223372036854775807L) {
            this.f42618g = j3;
            this.f42619h = j3;
            this.f42617f.c(j3);
        } else {
            long jB = this.f42617f.b(j4);
            while (jB != -9223372036854775807L && jB <= j3) {
                this.f42619h = n(jB, this.f42617f.a(this.f42618g));
                this.f42618g = jB;
                jB = this.f42617f.b(jB);
            }
            j3 = n(j3, this.f42617f.a(j3));
        }
        super.d(glObjectsProvider, glTextureInfo, j3);
    }
}
