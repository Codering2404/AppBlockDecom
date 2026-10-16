package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class Colors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f12473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f12474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f12475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f12476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f12477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f12478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f12479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f12480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f12481i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableState f12482j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f12483k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableState f12484l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableState f12485m;

    public /* synthetic */ Colors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, z2);
    }

    public final void A(long j3) {
        this.f12476d.setValue(Color.n(j3));
    }

    public final void B(long j3) {
        this.f12478f.setValue(Color.n(j3));
    }

    public final Colors a(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, boolean z2) {
        return new Colors(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, z2, null);
    }

    public final long c() {
        return ((Color) this.f12477e.getValue()).B();
    }

    public final long d() {
        return ((Color) this.f12479g.getValue()).B();
    }

    public final long e() {
        return ((Color) this.f12482j.getValue()).B();
    }

    public final long f() {
        return ((Color) this.f12484l.getValue()).B();
    }

    public final long g() {
        return ((Color) this.f12480h.getValue()).B();
    }

    public final long h() {
        return ((Color) this.f12481i.getValue()).B();
    }

    public final long i() {
        return ((Color) this.f12483k.getValue()).B();
    }

    public final long j() {
        return ((Color) this.f12473a.getValue()).B();
    }

    public final long k() {
        return ((Color) this.f12474b.getValue()).B();
    }

    public final long l() {
        return ((Color) this.f12475c.getValue()).B();
    }

    public final long m() {
        return ((Color) this.f12476d.getValue()).B();
    }

    public final long n() {
        return ((Color) this.f12478f.getValue()).B();
    }

    public final boolean o() {
        return ((Boolean) this.f12485m.getValue()).booleanValue();
    }

    public final void p(long j3) {
        this.f12477e.setValue(Color.n(j3));
    }

    public final void q(long j3) {
        this.f12479g.setValue(Color.n(j3));
    }

    public final void r(boolean z2) {
        this.f12485m.setValue(Boolean.valueOf(z2));
    }

    public final void s(long j3) {
        this.f12482j.setValue(Color.n(j3));
    }

    public final void t(long j3) {
        this.f12484l.setValue(Color.n(j3));
    }

    public String toString() {
        return "Colors(primary=" + ((Object) Color.A(j())) + ", primaryVariant=" + ((Object) Color.A(k())) + ", secondary=" + ((Object) Color.A(l())) + ", secondaryVariant=" + ((Object) Color.A(m())) + ", background=" + ((Object) Color.A(c())) + ", surface=" + ((Object) Color.A(n())) + ", error=" + ((Object) Color.A(d())) + ", onPrimary=" + ((Object) Color.A(g())) + ", onSecondary=" + ((Object) Color.A(h())) + ", onBackground=" + ((Object) Color.A(e())) + ", onSurface=" + ((Object) Color.A(i())) + ", onError=" + ((Object) Color.A(f())) + ", isLight=" + o() + ')';
    }

    public final void u(long j3) {
        this.f12480h.setValue(Color.n(j3));
    }

    public final void v(long j3) {
        this.f12481i.setValue(Color.n(j3));
    }

    public final void w(long j3) {
        this.f12483k.setValue(Color.n(j3));
    }

    public final void x(long j3) {
        this.f12473a.setValue(Color.n(j3));
    }

    public final void y(long j3) {
        this.f12474b.setValue(Color.n(j3));
    }

    public final void z(long j3) {
        this.f12475c.setValue(Color.n(j3));
    }

    private Colors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, boolean z2) {
        this.f12473a = SnapshotStateKt.i(Color.n(j3), SnapshotStateKt.r());
        this.f12474b = SnapshotStateKt.i(Color.n(j4), SnapshotStateKt.r());
        this.f12475c = SnapshotStateKt.i(Color.n(j5), SnapshotStateKt.r());
        this.f12476d = SnapshotStateKt.i(Color.n(j6), SnapshotStateKt.r());
        this.f12477e = SnapshotStateKt.i(Color.n(j7), SnapshotStateKt.r());
        this.f12478f = SnapshotStateKt.i(Color.n(j8), SnapshotStateKt.r());
        this.f12479g = SnapshotStateKt.i(Color.n(j9), SnapshotStateKt.r());
        this.f12480h = SnapshotStateKt.i(Color.n(j10), SnapshotStateKt.r());
        this.f12481i = SnapshotStateKt.i(Color.n(j11), SnapshotStateKt.r());
        this.f12482j = SnapshotStateKt.i(Color.n(j12), SnapshotStateKt.r());
        this.f12483k = SnapshotStateKt.i(Color.n(j13), SnapshotStateKt.r());
        this.f12484l = SnapshotStateKt.i(Color.n(j14), SnapshotStateKt.r());
        this.f12485m = SnapshotStateKt.i(Boolean.valueOf(z2), SnapshotStateKt.r());
    }
}
