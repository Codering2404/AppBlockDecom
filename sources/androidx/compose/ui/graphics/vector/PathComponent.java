package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class PathComponent extends VNode {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Brush f26359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f26360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List f26361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f26362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f26363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f26364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Brush f26365i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f26366j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f26367k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f26368l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f26369m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f26370n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f26371o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f26372p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f26373q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f26374r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Stroke f26375s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Path f26376t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Path f26377u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f26378v;

    public PathComponent() {
        super(null);
        this.f26358b = "";
        this.f26360d = 1.0f;
        this.f26361e = VectorKt.e();
        this.f26362f = VectorKt.b();
        this.f26363g = 1.0f;
        this.f26366j = VectorKt.c();
        this.f26367k = VectorKt.d();
        this.f26368l = 4.0f;
        this.f26370n = 1.0f;
        this.f26372p = true;
        this.f26373q = true;
        Path pathA = AndroidPath_androidKt.a();
        this.f26376t = pathA;
        this.f26377u = pathA;
        this.f26378v = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<PathMeasure>() { // from class: androidx.compose.ui.graphics.vector.PathComponent$pathMeasure$2
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final PathMeasure invoke() {
                return AndroidPathMeasure_androidKt.a();
            }
        });
    }

    private final PathMeasure f() {
        return (PathMeasure) this.f26378v.getValue();
    }

    private final void v() {
        PathParserKt.c(this.f26361e, this.f26376t);
        w();
    }

    private final void w() {
        if (this.f26369m == 0.0f && this.f26370n == 1.0f) {
            this.f26377u = this.f26376t;
            return;
        }
        if (Intrinsics.areEqual(this.f26377u, this.f26376t)) {
            this.f26377u = AndroidPath_androidKt.a();
        } else {
            int iT = this.f26377u.t();
            this.f26377u.r();
            this.f26377u.k(iT);
        }
        f().b(this.f26376t, false);
        float length = f().getLength();
        float f3 = this.f26369m;
        float f4 = this.f26371o;
        float f5 = ((f3 + f4) % 1.0f) * length;
        float f6 = ((this.f26370n + f4) % 1.0f) * length;
        if (f5 <= f6) {
            f().a(f5, f6, this.f26377u, true);
        } else {
            f().a(f5, length, this.f26377u, true);
            f().a(0.0f, f6, this.f26377u, true);
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void a(DrawScope drawScope) {
        Stroke stroke;
        if (this.f26372p) {
            v();
        } else if (this.f26374r) {
            w();
        }
        this.f26372p = false;
        this.f26374r = false;
        Brush brush = this.f26359c;
        if (brush != null) {
            DrawScope.F1(drawScope, this.f26377u, brush, this.f26360d, null, null, 0, 56, null);
        }
        Brush brush2 = this.f26365i;
        if (brush2 != null) {
            Stroke stroke2 = this.f26375s;
            if (this.f26373q || stroke2 == null) {
                Stroke stroke3 = new Stroke(this.f26364h, this.f26368l, this.f26366j, this.f26367k, null, 16, null);
                this.f26375s = stroke3;
                this.f26373q = false;
                stroke = stroke3;
            } else {
                stroke = stroke2;
            }
            DrawScope.F1(drawScope, this.f26377u, brush2, this.f26363g, stroke, null, 0, 48, null);
        }
    }

    public final Brush e() {
        return this.f26359c;
    }

    public final Brush g() {
        return this.f26365i;
    }

    public final void h(Brush brush) {
        this.f26359c = brush;
        c();
    }

    public final void i(float f3) {
        this.f26360d = f3;
        c();
    }

    public final void j(String str) {
        this.f26358b = str;
        c();
    }

    public final void k(List list) {
        this.f26361e = list;
        this.f26372p = true;
        c();
    }

    public final void l(int i3) {
        this.f26362f = i3;
        this.f26377u.k(i3);
        c();
    }

    public final void m(Brush brush) {
        this.f26365i = brush;
        c();
    }

    public final void n(float f3) {
        this.f26363g = f3;
        c();
    }

    public final void o(int i3) {
        this.f26366j = i3;
        this.f26373q = true;
        c();
    }

    public final void p(int i3) {
        this.f26367k = i3;
        this.f26373q = true;
        c();
    }

    public final void q(float f3) {
        this.f26368l = f3;
        this.f26373q = true;
        c();
    }

    public final void r(float f3) {
        this.f26364h = f3;
        this.f26373q = true;
        c();
    }

    public final void s(float f3) {
        this.f26370n = f3;
        this.f26374r = true;
        c();
    }

    public final void t(float f3) {
        this.f26371o = f3;
        this.f26374r = true;
        c();
    }

    public String toString() {
        return this.f26376t.toString();
    }

    public final void u(float f3) {
        this.f26369m = f3;
        this.f26374r = true;
        c();
    }
}
