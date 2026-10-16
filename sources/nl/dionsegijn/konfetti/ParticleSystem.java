package nl.dionsegijn.konfetti;

import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nl.dionsegijn.konfetti.emitters.BurstEmitter;
import nl.dionsegijn.konfetti.emitters.Emitter;
import nl.dionsegijn.konfetti.emitters.RenderSystem;
import nl.dionsegijn.konfetti.models.ConfettiConfig;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;
import nl.dionsegijn.konfetti.models.Vector;
import nl.dionsegijn.konfetti.modules.LocationModule;
import nl.dionsegijn.konfetti.modules.VelocityModule;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class ParticleSystem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Random f143724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LocationModule f143725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private VelocityModule f143726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f143727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Size[] f143728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Shape[] f143729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConfettiConfig f143730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Vector f143731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RenderSystem f143732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final KonfettiView f143733j;

    public ParticleSystem(KonfettiView konfettiView) {
        Intrinsics.checkNotNullParameter(konfettiView, "konfettiView");
        this.f143733j = konfettiView;
        Random random = new Random();
        this.f143724a = random;
        this.f143725b = new LocationModule(random);
        this.f143726c = new VelocityModule(random);
        this.f143727d = new int[]{-65536};
        this.f143728e = new Size[]{new Size(16, 0.0f, 2, null)};
        this.f143729f = new Shape[]{Shape.Square.f143770a};
        this.f143730g = new ConfettiConfig(false, 0L, false, false, 0L, false, 63, null);
        this.f143731h = new Vector(0.0f, 0.01f);
    }

    private final void m() {
        this.f143733j.b(this);
    }

    private final void n(Emitter emitter) {
        this.f143732i = new RenderSystem(this.f143725b, this.f143726c, this.f143731h, this.f143728e, this.f143729f, this.f143727d, this.f143730g, emitter, 0L, Function.MAX_NARGS, null);
        m();
    }

    public final ParticleSystem a(List colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.f143727d = CollectionsKt.toIntArray(colors);
        return this;
    }

    public final ParticleSystem b(Shape... shapes) {
        Intrinsics.checkNotNullParameter(shapes, "shapes");
        ArrayList arrayList = new ArrayList();
        for (Shape shape : shapes) {
            if (shape != null) {
                arrayList.add(shape);
            }
        }
        Object[] array = arrayList.toArray(new Shape[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this.f143729f = (Shape[]) array;
        return this;
    }

    public final ParticleSystem c(Size... possibleSizes) {
        Intrinsics.checkNotNullParameter(possibleSizes, "possibleSizes");
        ArrayList arrayList = new ArrayList();
        for (Size size : possibleSizes) {
            if (size != null) {
                arrayList.add(size);
            }
        }
        Object[] array = arrayList.toArray(new Size[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this.f143728e = (Size[]) array;
        return this;
    }

    public final void d(int i3) {
        n(new BurstEmitter().e(i3));
    }

    public final boolean e() {
        RenderSystem renderSystem = this.f143732i;
        if (renderSystem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderSystem");
        }
        return renderSystem.e();
    }

    public final long f() {
        return this.f143730g.b();
    }

    public final RenderSystem g() {
        RenderSystem renderSystem = this.f143732i;
        if (renderSystem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderSystem");
        }
        return renderSystem;
    }

    public final ParticleSystem h(double d3, double d4) {
        this.f143726c.h(Math.toRadians(d3));
        this.f143726c.f(Double.valueOf(Math.toRadians(d4)));
        return this;
    }

    public final ParticleSystem i(boolean z2) {
        this.f143730g.g(z2);
        return this;
    }

    public final ParticleSystem j(float f3, Float f4, float f5, Float f6) {
        this.f143725b.a(f3, f4);
        this.f143725b.b(f5, f6);
        return this;
    }

    public final ParticleSystem k(float f3, float f4) {
        this.f143726c.i(f3);
        this.f143726c.g(Float.valueOf(f4));
        return this;
    }

    public final ParticleSystem l(long j3) {
        this.f143730g.h(j3);
        return this;
    }
}
