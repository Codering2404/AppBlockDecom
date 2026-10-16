package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class OutlineResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f28132a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Outline f28133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.compose.ui.graphics.Outline f28134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Path f28135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Path f28136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f28137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f28138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Path f28139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RoundRect f28140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f28141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f28142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f28143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f28144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Path f28145n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Path f28146o;

    public OutlineResolver() {
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.f28133b = outline;
        this.f28142k = Offset.f25596b.c();
        this.f28143l = Size.f25617b.b();
    }

    private final boolean g(RoundRect roundRect, long j3, long j4, float f3) {
        if (roundRect != null && RoundRectKt.g(roundRect)) {
            int i3 = (int) (j3 >> 32);
            if (roundRect.e() == Float.intBitsToFloat(i3)) {
                int i4 = (int) (j3 & 4294967295L);
                if (roundRect.g() == Float.intBitsToFloat(i4) && roundRect.f() == Float.intBitsToFloat(i3) + Float.intBitsToFloat((int) (j4 >> 32)) && roundRect.a() == Float.intBitsToFloat(i4) + Float.intBitsToFloat((int) (j4 & 4294967295L)) && Float.intBitsToFloat((int) (roundRect.h() >> 32)) == f3) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void i() {
        if (this.f28137f) {
            this.f28142k = Offset.f25596b.c();
            this.f28141j = 0.0f;
            this.f28136e = null;
            this.f28137f = false;
            this.f28138g = false;
            androidx.compose.ui.graphics.Outline outline = this.f28134c;
            if (outline == null || !this.f28144m || Float.intBitsToFloat((int) (this.f28143l >> 32)) <= 0.0f || Float.intBitsToFloat((int) (this.f28143l & 4294967295L)) <= 0.0f) {
                this.f28133b.setEmpty();
                return;
            }
            this.f28132a = true;
            if (outline instanceof Outline.Rectangle) {
                k(((Outline.Rectangle) outline).b());
            } else if (outline instanceof Outline.Rounded) {
                l(((Outline.Rounded) outline).b());
            } else if (outline instanceof Outline.Generic) {
                j(((Outline.Generic) outline).b());
            }
        }
    }

    private final void j(Path path) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 28 || path.e()) {
            if (i3 >= 30) {
                OutlineVerificationHelper.f28147a.a(this.f28133b, path);
            } else {
                android.graphics.Outline outline = this.f28133b;
                if (!(path instanceof AndroidPath)) {
                    throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                }
                outline.setConvexPath(((AndroidPath) path).A());
            }
            this.f28138g = !this.f28133b.canClip();
        } else {
            this.f28132a = false;
            this.f28133b.setEmpty();
            this.f28138g = true;
        }
        this.f28136e = path;
    }

    private final void k(Rect rect) {
        float fO = rect.o();
        this.f28142k = Offset.e((((long) Float.floatToRawIntBits(rect.r())) & 4294967295L) | (Float.floatToRawIntBits(fO) << 32));
        float fP = rect.p() - rect.o();
        this.f28143l = Size.d((((long) Float.floatToRawIntBits(rect.i() - rect.r())) & 4294967295L) | (Float.floatToRawIntBits(fP) << 32));
        this.f28133b.setRect(Math.round(rect.o()), Math.round(rect.r()), Math.round(rect.p()), Math.round(rect.i()));
    }

    private final void l(RoundRect roundRect) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (roundRect.h() >> 32));
        float fE = roundRect.e();
        this.f28142k = Offset.e((((long) Float.floatToRawIntBits(roundRect.g())) & 4294967295L) | (Float.floatToRawIntBits(fE) << 32));
        float fJ = roundRect.j();
        this.f28143l = Size.d((((long) Float.floatToRawIntBits(roundRect.d())) & 4294967295L) | (Float.floatToRawIntBits(fJ) << 32));
        if (RoundRectKt.g(roundRect)) {
            this.f28133b.setRoundRect(Math.round(roundRect.e()), Math.round(roundRect.g()), Math.round(roundRect.f()), Math.round(roundRect.a()), fIntBitsToFloat);
            this.f28141j = fIntBitsToFloat;
            return;
        }
        Path pathA = this.f28135d;
        if (pathA == null) {
            pathA = AndroidPath_androidKt.a();
            this.f28135d = pathA;
        }
        pathA.reset();
        Path.s(pathA, roundRect, null, 2, null);
        j(pathA);
    }

    public final void a(Canvas canvas) {
        OutlineResolver outlineResolver;
        Path pathD = d();
        if (pathD != null) {
            Canvas.l(canvas, pathD, 0, 2, null);
            return;
        }
        float f3 = this.f28141j;
        if (f3 <= 0.0f) {
            Canvas.o(canvas, Float.intBitsToFloat((int) (this.f28142k >> 32)), Float.intBitsToFloat((int) (this.f28142k & 4294967295L)), Float.intBitsToFloat((int) (this.f28143l >> 32)) + Float.intBitsToFloat((int) (this.f28142k >> 32)), Float.intBitsToFloat((int) (this.f28143l & 4294967295L)) + Float.intBitsToFloat((int) (this.f28142k & 4294967295L)), 0, 16, null);
            return;
        }
        Path pathA = this.f28139h;
        RoundRect roundRect = this.f28140i;
        if (pathA != null) {
            outlineResolver = this;
            if (!g(roundRect, this.f28142k, this.f28143l, f3)) {
            }
            Canvas.l(canvas, pathA, 0, 2, null);
        }
        outlineResolver = this;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (outlineResolver.f28142k >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (outlineResolver.f28142k & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (outlineResolver.f28143l >> 32)) + Float.intBitsToFloat((int) (outlineResolver.f28142k >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (outlineResolver.f28143l & 4294967295L)) + Float.intBitsToFloat((int) (outlineResolver.f28142k & 4294967295L));
        float f4 = outlineResolver.f28141j;
        RoundRect roundRectD = RoundRectKt.d(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, CornerRadius.b((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L)));
        if (pathA == null) {
            pathA = AndroidPath_androidKt.a();
        } else {
            pathA.reset();
        }
        Path.s(pathA, roundRectD, null, 2, null);
        outlineResolver.f28140i = roundRectD;
        outlineResolver.f28139h = pathA;
        Canvas.l(canvas, pathA, 0, 2, null);
    }

    public final android.graphics.Outline b() {
        i();
        if (this.f28144m && this.f28132a) {
            return this.f28133b;
        }
        return null;
    }

    public final boolean c() {
        return this.f28137f;
    }

    public final Path d() {
        i();
        return this.f28136e;
    }

    public final boolean e() {
        return !this.f28138g;
    }

    public final boolean f(long j3) {
        androidx.compose.ui.graphics.Outline outline;
        if (this.f28144m && (outline = this.f28134c) != null) {
            return ShapeContainingUtilKt.b(outline, Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), this.f28145n, this.f28146o);
        }
        return true;
    }

    public final boolean h(androidx.compose.ui.graphics.Outline outline, float f3, boolean z2, float f4, long j3) {
        this.f28133b.setAlpha(f3);
        boolean zAreEqual = Intrinsics.areEqual(this.f28134c, outline);
        boolean z3 = !zAreEqual;
        if (!zAreEqual) {
            this.f28134c = outline;
            this.f28137f = true;
        }
        this.f28143l = j3;
        boolean z4 = outline != null && (z2 || f4 > 0.0f);
        if (this.f28144m != z4) {
            this.f28144m = z4;
            this.f28137f = true;
        }
        return z3;
    }
}
