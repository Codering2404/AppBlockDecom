package nl.dionsegijn.konfetti;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.dionsegijn.konfetti.listeners.OnParticleSystemUpdateListener;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class KonfettiView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f143720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TimerIntegration f143721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnParticleSystemUpdateListener f143722c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TimerIntegration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f143723a = -1;

        public final float a() {
            if (this.f143723a == -1) {
                this.f143723a = System.nanoTime();
            }
            float f3 = (r0 - this.f143723a) / 1000000.0f;
            this.f143723a = System.nanoTime();
            return f3 / 1000;
        }

        public final long b(long j3) {
            return System.currentTimeMillis() - j3;
        }

        public final void c() {
            this.f143723a = -1L;
        }
    }

    public KonfettiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f143720a = new ArrayList();
        this.f143721b = new TimerIntegration();
    }

    public final ParticleSystem a() {
        return new ParticleSystem(this);
    }

    public final void b(ParticleSystem particleSystem) {
        Intrinsics.checkNotNullParameter(particleSystem, "particleSystem");
        this.f143720a.add(particleSystem);
        OnParticleSystemUpdateListener onParticleSystemUpdateListener = this.f143722c;
        if (onParticleSystemUpdateListener != null) {
            onParticleSystemUpdateListener.a(this, particleSystem, this.f143720a.size());
        }
        invalidate();
    }

    public final List<ParticleSystem> getActiveSystems() {
        return this.f143720a;
    }

    public final OnParticleSystemUpdateListener getOnParticleSystemUpdateListener() {
        return this.f143722c;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float fA = this.f143721b.a();
        for (int size = this.f143720a.size() - 1; size >= 0; size--) {
            ParticleSystem particleSystem = (ParticleSystem) this.f143720a.get(size);
            if (this.f143721b.b(particleSystem.g().c()) >= particleSystem.f()) {
                particleSystem.g().f(canvas, fA);
            }
            if (particleSystem.e()) {
                this.f143720a.remove(size);
                OnParticleSystemUpdateListener onParticleSystemUpdateListener = this.f143722c;
                if (onParticleSystemUpdateListener != null) {
                    onParticleSystemUpdateListener.b(this, particleSystem, this.f143720a.size());
                }
            }
        }
        if (this.f143720a.size() != 0) {
            invalidate();
        } else {
            this.f143721b.c();
        }
    }

    public final void setOnParticleSystemUpdateListener(OnParticleSystemUpdateListener onParticleSystemUpdateListener) {
        this.f143722c = onParticleSystemUpdateListener;
    }
}
