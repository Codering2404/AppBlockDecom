package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ReusableGraphicsLayerScope implements GraphicsLayerScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f25881a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f25885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f25886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f25887h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f25890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f25891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f25892m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f25896q;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private RenderEffect f25901v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Outline f25902w;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f25882b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f25883c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f25884d = 1.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f25888i = GraphicsLayerScopeKt.a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f25889j = GraphicsLayerScopeKt.a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f25893n = 8.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f25894o = TransformOrigin.f25955b.a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Shape f25895p = RectangleShapeKt.a();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f25897r = CompositingStrategy.f25737b.a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f25898s = Size.f25617b.a();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Density f25899t = DensityKt.b(1.0f, 0.0f, 2, null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private LayoutDirection f25900u = LayoutDirection.f30001a;

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float A() {
        return this.f25893n;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void A0(long j3) {
        if (TransformOrigin.e(this.f25894o, j3)) {
            return;
        }
        this.f25881a |= 4096;
        this.f25894o = j3;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void B(boolean z2) {
        if (this.f25896q != z2) {
            this.f25881a |= 16384;
            this.f25896q = z2;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void C(long j3) {
        if (Color.t(this.f25889j, j3)) {
            return;
        }
        this.f25881a |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        this.f25889j = j3;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float D() {
        return this.f25882b;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void E(float f3) {
        if (this.f25887h == f3) {
            return;
        }
        this.f25881a |= 32;
        this.f25887h = f3;
    }

    public final LayoutDirection H() {
        return this.f25900u;
    }

    public final int I() {
        return this.f25881a;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void I1(Shape shape) {
        if (Intrinsics.areEqual(this.f25895p, shape)) {
            return;
        }
        this.f25881a |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.f25895p = shape;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float J() {
        return this.f25886g;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float K() {
        return this.f25885f;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return this.f25899t.K1();
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float L() {
        return this.f25890k;
    }

    public final Outline N() {
        return this.f25902w;
    }

    public RenderEffect O() {
        return this.f25901v;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float P() {
        return this.f25883c;
    }

    public float Q() {
        return this.f25887h;
    }

    public Shape R() {
        return this.f25895p;
    }

    public long S() {
        return this.f25889j;
    }

    public final void T() {
        e(1.0f);
        k(1.0f);
        c(1.0f);
        l(0.0f);
        d(0.0f);
        E(0.0f);
        y(GraphicsLayerScopeKt.a());
        C(GraphicsLayerScopeKt.a());
        h(0.0f);
        i(0.0f);
        j(0.0f);
        g(8.0f);
        A0(TransformOrigin.f25955b.a());
        I1(RectangleShapeKt.a());
        B(false);
        f(null);
        s(CompositingStrategy.f25737b.a());
        Y(Size.f25617b.a());
        this.f25902w = null;
        this.f25881a = 0;
    }

    public final void U(Density density) {
        this.f25899t = density;
    }

    public final void X(LayoutDirection layoutDirection) {
        this.f25900u = layoutDirection;
    }

    public void Y(long j3) {
        this.f25898s = j3;
    }

    public final void Z() {
        this.f25902w = R().mo29createOutlinePq9zytI(b(), this.f25900u, this.f25899t);
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public long b() {
        return this.f25898s;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void c(float f3) {
        if (this.f25884d == f3) {
            return;
        }
        this.f25881a |= 4;
        this.f25884d = f3;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void d(float f3) {
        if (this.f25886g == f3) {
            return;
        }
        this.f25881a |= 16;
        this.f25886g = f3;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void e(float f3) {
        if (this.f25882b == f3) {
            return;
        }
        this.f25881a |= 1;
        this.f25882b = f3;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void f(RenderEffect renderEffect) {
        if (Intrinsics.areEqual(this.f25901v, renderEffect)) {
            return;
        }
        this.f25881a |= 131072;
        this.f25901v = renderEffect;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void g(float f3) {
        if (this.f25893n == f3) {
            return;
        }
        this.f25881a |= 2048;
        this.f25893n = f3;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f25899t.getDensity();
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void h(float f3) {
        if (this.f25890k == f3) {
            return;
        }
        this.f25881a |= Function.MAX_NARGS;
        this.f25890k = f3;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void i(float f3) {
        if (this.f25891l == f3) {
            return;
        }
        this.f25881a |= 512;
        this.f25891l = f3;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void j(float f3) {
        if (this.f25892m == f3) {
            return;
        }
        this.f25881a |= 1024;
        this.f25892m = f3;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void k(float f3) {
        if (this.f25883c == f3) {
            return;
        }
        this.f25881a |= 2;
        this.f25883c = f3;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void l(float f3) {
        if (this.f25885f == f3) {
            return;
        }
        this.f25881a |= 8;
        this.f25885f = f3;
    }

    public float m() {
        return this.f25884d;
    }

    public long p() {
        return this.f25888i;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void s(int i3) {
        if (CompositingStrategy.g(this.f25897r, i3)) {
            return;
        }
        this.f25881a |= 32768;
        this.f25897r = i3;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float t() {
        return this.f25891l;
    }

    public boolean u() {
        return this.f25896q;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float w() {
        return this.f25892m;
    }

    public int x() {
        return this.f25897r;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void y(long j3) {
        if (Color.t(this.f25888i, j3)) {
            return;
        }
        this.f25881a |= 64;
        this.f25888i = j3;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public long y0() {
        return this.f25894o;
    }

    public final Density z() {
        return this.f25899t;
    }
}
