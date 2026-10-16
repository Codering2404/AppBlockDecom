package androidx.compose.ui.graphics;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class AndroidPath implements Path {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.graphics.Path f25648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RectF f25649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f25650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private android.graphics.Matrix f25651e;

    public AndroidPath(android.graphics.Path path) {
        this.f25648b = path;
    }

    private final void B(Rect rect) {
        if (Float.isNaN(rect.o()) || Float.isNaN(rect.r()) || Float.isNaN(rect.p()) || Float.isNaN(rect.i())) {
            AndroidPath_androidKt.d("Invalid rectangle, make sure no value is NaN");
        }
    }

    public final android.graphics.Path A() {
        return this.f25648b;
    }

    @Override // androidx.compose.ui.graphics.Path
    public void a(float f3, float f4) {
        this.f25648b.moveTo(f3, f4);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void b(float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f25648b.cubicTo(f3, f4, f5, f6, f7, f8);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void c(float f3, float f4) {
        this.f25648b.lineTo(f3, f4);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void close() {
        this.f25648b.close();
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean e() {
        return this.f25648b.isConvex();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void f(float f3, float f4) {
        this.f25648b.rMoveTo(f3, f4);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void g(float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f25648b.rCubicTo(f3, f4, f5, f6, f7, f8);
    }

    @Override // androidx.compose.ui.graphics.Path
    public Rect getBounds() {
        if (this.f25649c == null) {
            this.f25649c = new RectF();
        }
        RectF rectF = this.f25649c;
        Intrinsics.checkNotNull(rectF);
        this.f25648b.computeBounds(rectF, true);
        return new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void h(float f3, float f4, float f5, float f6) {
        this.f25648b.quadTo(f3, f4, f5, f6);
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isEmpty() {
        return this.f25648b.isEmpty();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void j(float f3, float f4, float f5, float f6) {
        this.f25648b.rQuadTo(f3, f4, f5, f6);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void k(int i3) {
        this.f25648b.setFillType(PathFillType.f(i3, PathFillType.f25834b.a()) ? Path.FillType.EVEN_ODD : Path.FillType.WINDING);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void m(float f3, float f4, float f5, float f6) {
        this.f25648b.quadTo(f3, f4, f5, f6);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void n(Rect rect, Path.Direction direction) {
        if (this.f25649c == null) {
            this.f25649c = new RectF();
        }
        RectF rectF = this.f25649c;
        Intrinsics.checkNotNull(rectF);
        rectF.set(rect.o(), rect.r(), rect.p(), rect.i());
        android.graphics.Path path = this.f25648b;
        RectF rectF2 = this.f25649c;
        Intrinsics.checkNotNull(rectF2);
        path.addOval(rectF2, AndroidPath_androidKt.e(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void o(Rect rect, Path.Direction direction) {
        B(rect);
        if (this.f25649c == null) {
            this.f25649c = new RectF();
        }
        RectF rectF = this.f25649c;
        Intrinsics.checkNotNull(rectF);
        rectF.set(rect.o(), rect.r(), rect.p(), rect.i());
        android.graphics.Path path = this.f25648b;
        RectF rectF2 = this.f25649c;
        Intrinsics.checkNotNull(rectF2);
        path.addRect(rectF2, AndroidPath_androidKt.e(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void p(long j3) {
        android.graphics.Matrix matrix = this.f25651e;
        if (matrix == null) {
            this.f25651e = new android.graphics.Matrix();
        } else {
            Intrinsics.checkNotNull(matrix);
            matrix.reset();
        }
        android.graphics.Matrix matrix2 = this.f25651e;
        Intrinsics.checkNotNull(matrix2);
        matrix2.setTranslate(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
        android.graphics.Path path = this.f25648b;
        android.graphics.Matrix matrix3 = this.f25651e;
        Intrinsics.checkNotNull(matrix3);
        path.transform(matrix3);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void q(float f3, float f4, float f5, float f6) {
        this.f25648b.rQuadTo(f3, f4, f5, f6);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void r() {
        this.f25648b.rewind();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void reset() {
        this.f25648b.reset();
    }

    @Override // androidx.compose.ui.graphics.Path
    public int t() {
        return this.f25648b.getFillType() == Path.FillType.EVEN_ODD ? PathFillType.f25834b.a() : PathFillType.f25834b.b();
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean v(Path path, Path path2, int i3) {
        PathOperation.Companion companion = PathOperation.f25845b;
        Path.Op op = PathOperation.g(i3, companion.a()) ? Path.Op.DIFFERENCE : PathOperation.g(i3, companion.b()) ? Path.Op.INTERSECT : PathOperation.g(i3, companion.c()) ? Path.Op.REVERSE_DIFFERENCE : PathOperation.g(i3, companion.d()) ? Path.Op.UNION : Path.Op.XOR;
        android.graphics.Path path3 = this.f25648b;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        android.graphics.Path pathA = ((AndroidPath) path).A();
        if (path2 instanceof AndroidPath) {
            return path3.op(pathA, ((AndroidPath) path2).A(), op);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Path
    public void w(Rect rect, float f3, float f4, boolean z2) {
        float fO = rect.o();
        float fR = rect.r();
        float fP = rect.p();
        float fI = rect.i();
        if (this.f25649c == null) {
            this.f25649c = new RectF();
        }
        RectF rectF = this.f25649c;
        Intrinsics.checkNotNull(rectF);
        rectF.set(fO, fR, fP, fI);
        android.graphics.Path path = this.f25648b;
        RectF rectF2 = this.f25649c;
        Intrinsics.checkNotNull(rectF2);
        path.arcTo(rectF2, f3, f4, z2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void x(float f3, float f4) {
        this.f25648b.rLineTo(f3, f4);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void y(Path path, long j3) {
        android.graphics.Path path2 = this.f25648b;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        path2.addPath(((AndroidPath) path).A(), Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void z(RoundRect roundRect, Path.Direction direction) {
        if (this.f25649c == null) {
            this.f25649c = new RectF();
        }
        RectF rectF = this.f25649c;
        Intrinsics.checkNotNull(rectF);
        rectF.set(roundRect.e(), roundRect.g(), roundRect.f(), roundRect.a());
        if (this.f25650d == null) {
            this.f25650d = new float[8];
        }
        float[] fArr = this.f25650d;
        Intrinsics.checkNotNull(fArr);
        fArr[0] = Float.intBitsToFloat((int) (roundRect.h() >> 32));
        fArr[1] = Float.intBitsToFloat((int) (roundRect.h() & 4294967295L));
        fArr[2] = Float.intBitsToFloat((int) (roundRect.i() >> 32));
        fArr[3] = Float.intBitsToFloat((int) (roundRect.i() & 4294967295L));
        fArr[4] = Float.intBitsToFloat((int) (roundRect.c() >> 32));
        fArr[5] = Float.intBitsToFloat((int) (roundRect.c() & 4294967295L));
        fArr[6] = Float.intBitsToFloat((int) (roundRect.b() >> 32));
        fArr[7] = Float.intBitsToFloat((int) (roundRect.b() & 4294967295L));
        android.graphics.Path path = this.f25648b;
        RectF rectF2 = this.f25649c;
        Intrinsics.checkNotNull(rectF2);
        float[] fArr2 = this.f25650d;
        Intrinsics.checkNotNull(fArr2);
        path.addRoundRect(rectF2, fArr2, AndroidPath_androidKt.e(direction));
    }

    public /* synthetic */ AndroidPath(android.graphics.Path path, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new android.graphics.Path() : path);
    }
}
