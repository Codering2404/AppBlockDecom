package androidx.compose.ui.graphics;

import android.graphics.Shader;
import kotlin.Metadata;

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
public final class AndroidPaint implements Paint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.graphics.Paint f25640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f25641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Shader f25642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorFilter f25643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PathEffect f25644e;

    public AndroidPaint(android.graphics.Paint paint) {
        this.f25640a = paint;
        this.f25641b = BlendMode.f25667b.B();
    }

    @Override // androidx.compose.ui.graphics.Paint
    public Shader A() {
        return this.f25642c;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void B(ColorFilter colorFilter) {
        this.f25643d = colorFilter;
        AndroidPaint_androidKt.o(this.f25640a, colorFilter);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void C(float f3) {
        AndroidPaint_androidKt.u(this.f25640a, f3);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public int D() {
        return AndroidPaint_androidKt.e(this.f25640a);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void E(int i3) {
        AndroidPaint_androidKt.w(this.f25640a, i3);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void F(float f3) {
        AndroidPaint_androidKt.v(this.f25640a, f3);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public float G() {
        return AndroidPaint_androidKt.i(this.f25640a);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public float a() {
        return AndroidPaint_androidKt.c(this.f25640a);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public ColorFilter b() {
        return this.f25643d;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void c(float f3) {
        AndroidPaint_androidKt.k(this.f25640a, f3);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public long d() {
        return AndroidPaint_androidKt.d(this.f25640a);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public int m() {
        return this.f25641b;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void n(boolean z2) {
        AndroidPaint_androidKt.l(this.f25640a, z2);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void o(int i3) {
        AndroidPaint_androidKt.s(this.f25640a, i3);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void p(int i3) {
        if (BlendMode.F(this.f25641b, i3)) {
            return;
        }
        this.f25641b = i3;
        AndroidPaint_androidKt.m(this.f25640a, i3);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void q(int i3) {
        AndroidPaint_androidKt.p(this.f25640a, i3);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public int r() {
        return AndroidPaint_androidKt.f(this.f25640a);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void s(PathEffect pathEffect) {
        AndroidPaint_androidKt.q(this.f25640a, pathEffect);
        this.f25644e = pathEffect;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void t(int i3) {
        AndroidPaint_androidKt.t(this.f25640a, i3);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void u(long j3) {
        AndroidPaint_androidKt.n(this.f25640a, j3);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public PathEffect v() {
        return this.f25644e;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public int w() {
        return AndroidPaint_androidKt.g(this.f25640a);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public float x() {
        return AndroidPaint_androidKt.h(this.f25640a);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public android.graphics.Paint y() {
        return this.f25640a;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void z(Shader shader) {
        this.f25642c = shader;
        AndroidPaint_androidKt.r(this.f25640a, shader);
    }

    public AndroidPaint() {
        this(AndroidPaint_androidKt.j());
    }
}
