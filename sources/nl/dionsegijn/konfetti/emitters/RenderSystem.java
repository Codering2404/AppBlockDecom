package nl.dionsegijn.konfetti.emitters;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import nl.dionsegijn.konfetti.Confetti;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class RenderSystem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f143737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Random f143738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f143739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LocationModule f143740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final VelocityModule f143741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Vector f143742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Size[] f143743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Shape[] f143744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f143745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ConfettiConfig f143746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Emitter f143747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f143748l;

    /* JADX INFO: renamed from: nl.dionsegijn.konfetti.emitters.RenderSystem$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(RenderSystem renderSystem) {
            super(0, renderSystem, RenderSystem.class, "addConfetti", "addConfetti()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m2204invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2204invoke() {
            ((RenderSystem) this.receiver).b();
        }
    }

    public RenderSystem(LocationModule location, VelocityModule velocity, Vector gravity, Size[] sizes, Shape[] shapes, int[] colors, ConfettiConfig config, Emitter emitter, long j3) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(velocity, "velocity");
        Intrinsics.checkNotNullParameter(gravity, "gravity");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        Intrinsics.checkNotNullParameter(shapes, "shapes");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        this.f143740d = location;
        this.f143741e = velocity;
        this.f143742f = gravity;
        this.f143743g = sizes;
        this.f143744h = shapes;
        this.f143745i = colors;
        this.f143746j = config;
        this.f143747k = emitter;
        this.f143748l = j3;
        this.f143737a = true;
        this.f143738b = new Random();
        this.f143739c = new ArrayList();
        emitter.d(new AnonymousClass1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        List list = this.f143739c;
        Vector vector = new Vector(this.f143740d.c(), this.f143740d.d());
        Size[] sizeArr = this.f143743g;
        Size size = sizeArr[this.f143738b.nextInt(sizeArr.length)];
        Shape shapeD = d();
        int[] iArr = this.f143745i;
        Vector vector2 = null;
        list.add(new Confetti(vector, iArr[this.f143738b.nextInt(iArr.length)], size, shapeD, this.f143746j.f(), this.f143746j.c(), vector2, this.f143741e.e(), this.f143746j.d(), this.f143746j.a(), this.f143741e.a(), this.f143741e.c(), this.f143746j.e(), 64, null));
    }

    private final Shape d() {
        Drawable drawableD;
        Drawable drawableNewDrawable;
        Shape[] shapeArr = this.f143744h;
        Shape shape = shapeArr[this.f143738b.nextInt(shapeArr.length)];
        if (!(shape instanceof Shape.DrawableShape)) {
            return shape;
        }
        Shape.DrawableShape drawableShape = (Shape.DrawableShape) shape;
        Drawable.ConstantState constantState = drawableShape.d().getConstantState();
        if (constantState == null || (drawableNewDrawable = constantState.newDrawable()) == null || (drawableD = drawableNewDrawable.mutate()) == null) {
            drawableD = drawableShape.d();
        }
        Intrinsics.checkNotNullExpressionValue(drawableD, "shape.drawable.constantS…utate() ?: shape.drawable");
        return Shape.DrawableShape.c(drawableShape, drawableD, false, 2, null);
    }

    public final long c() {
        return this.f143748l;
    }

    public final boolean e() {
        if (this.f143747k.c() && this.f143739c.size() == 0) {
            return true;
        }
        return !this.f143737a && this.f143739c.size() == 0;
    }

    public final void f(Canvas canvas, float f3) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.f143737a) {
            this.f143747k.a(f3);
        }
        for (int size = this.f143739c.size() - 1; size >= 0; size--) {
            Confetti confetti = (Confetti) this.f143739c.get(size);
            confetti.a(this.f143742f);
            confetti.e(canvas, f3);
        }
        CollectionsKt.removeAll(this.f143739c, (Function1) new Function1<Confetti, Boolean>() { // from class: nl.dionsegijn.konfetti.emitters.RenderSystem$render$1
            public final boolean c(Confetti it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.d();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Boolean.valueOf(c((Confetti) obj));
            }
        });
    }

    public /* synthetic */ RenderSystem(LocationModule locationModule, VelocityModule velocityModule, Vector vector, Size[] sizeArr, Shape[] shapeArr, int[] iArr, ConfettiConfig confettiConfig, Emitter emitter, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(locationModule, velocityModule, vector, sizeArr, shapeArr, iArr, confettiConfig, emitter, (i3 & Function.MAX_NARGS) != 0 ? System.currentTimeMillis() : j3);
    }
}
