package nl.dionsegijn.konfetti;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;
import nl.dionsegijn.konfetti.models.Vector;

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
public final class Confetti {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f143698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f143699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f143700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Paint f143701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f143702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f143703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f143704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f143705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f143706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Vector f143707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f143708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Size f143709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Shape f143710m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f143711n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f143712o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Vector f143713p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Vector f143714q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f143715r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f143716s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final float f143717t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final float f143718u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f143719v;

    public Confetti(Vector location, int i3, Size size, Shape shape, long j3, boolean z2, Vector acceleration, Vector velocity, boolean z3, boolean z4, float f3, float f4, boolean z5) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(acceleration, "acceleration");
        Intrinsics.checkNotNullParameter(velocity, "velocity");
        this.f143707j = location;
        this.f143708k = i3;
        this.f143709l = size;
        this.f143710m = shape;
        this.f143711n = j3;
        this.f143712o = z2;
        this.f143713p = acceleration;
        this.f143714q = velocity;
        this.f143715r = z3;
        this.f143716s = z4;
        this.f143717t = f3;
        this.f143718u = f4;
        this.f143719v = z5;
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        float f5 = system.getDisplayMetrics().density;
        this.f143698a = f5;
        this.f143699b = size.a();
        this.f143700c = size.b();
        Paint paint = new Paint();
        this.f143701d = paint;
        this.f143704g = this.f143700c;
        this.f143705h = 60.0f;
        this.f143706i = 255;
        float f6 = f5 * 0.29f;
        float f7 = 3 * f6;
        if (z3) {
            this.f143702e = ((f7 * Random.f140182a.h()) + f6) * f4;
        }
        paint.setColor(i3);
    }

    private final void b(Canvas canvas) {
        if (this.f143707j.d() > canvas.getHeight()) {
            this.f143711n = 0L;
            return;
        }
        if (this.f143707j.c() <= canvas.getWidth()) {
            float f3 = 0;
            if (this.f143707j.c() + c() < f3 || this.f143707j.d() + c() < f3) {
                return;
            }
            this.f143701d.setColor((this.f143706i << 24) | (this.f143708k & 16777215));
            float f4 = 2;
            float fAbs = Math.abs((this.f143704g / this.f143700c) - 0.5f) * f4;
            float f5 = (this.f143700c * fAbs) / f4;
            int iSave = canvas.save();
            canvas.translate(this.f143707j.c() - f5, this.f143707j.d());
            canvas.rotate(this.f143703f, f5, this.f143700c / f4);
            canvas.scale(fAbs, 1.0f);
            this.f143710m.a(canvas, this.f143701d, this.f143700c);
            canvas.restoreToCount(iSave);
        }
    }

    private final float c() {
        return this.f143700c;
    }

    private final void f(float f3) {
        if (this.f143716s) {
            float fD = this.f143713p.d();
            float f4 = this.f143717t;
            if (fD < f4 || f4 == -1.0f) {
                this.f143714q.a(this.f143713p);
            }
        }
        if (this.f143719v) {
            this.f143707j.b(this.f143714q, this.f143705h * f3 * this.f143698a);
        } else {
            this.f143707j.b(this.f143714q, this.f143705h * f3);
        }
        long j3 = this.f143711n;
        if (j3 <= 0) {
            g(f3);
        } else {
            this.f143711n = j3 - ((long) (1000 * f3));
        }
        float f5 = this.f143702e * f3 * this.f143705h;
        float f6 = this.f143703f + f5;
        this.f143703f = f6;
        if (f6 >= 360) {
            this.f143703f = 0.0f;
        }
        float f7 = this.f143704g - f5;
        this.f143704g = f7;
        if (f7 < 0) {
            this.f143704g = this.f143700c;
        }
    }

    private final void g(float f3) {
        int iF = 0;
        if (this.f143712o) {
            iF = RangesKt.f(this.f143706i - ((int) ((5 * f3) * this.f143705h)), 0);
        }
        this.f143706i = iF;
    }

    public final void a(Vector force) {
        Intrinsics.checkNotNullParameter(force, "force");
        this.f143713p.b(force, 1.0f / this.f143699b);
    }

    public final boolean d() {
        return this.f143706i <= 0;
    }

    public final void e(Canvas canvas, float f3) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        f(f3);
        b(canvas);
    }

    public /* synthetic */ Confetti(Vector vector, int i3, Size size, Shape shape, long j3, boolean z2, Vector vector2, Vector vector3, boolean z3, boolean z4, float f3, float f4, boolean z5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(vector, i3, size, shape, (i4 & 16) != 0 ? -1L : j3, (i4 & 32) != 0 ? true : z2, (i4 & 64) != 0 ? new Vector(0.0f, 0.0f) : vector2, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new Vector(0.0f, 0.0f, 3, null) : vector3, (i4 & Function.MAX_NARGS) != 0 ? true : z3, (i4 & 512) != 0 ? true : z4, (i4 & 1024) != 0 ? -1.0f : f3, (i4 & 2048) != 0 ? 1.0f : f4, (i4 & 4096) != 0 ? true : z5);
    }
}
