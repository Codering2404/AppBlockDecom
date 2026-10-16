package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class AndroidCanvas implements Canvas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.graphics.Canvas f25622a = AndroidCanvas_androidKt.f25625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f25623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Rect f25624c;

    private final void a(List list, Paint paint, int i3) {
        if (list.size() >= 2) {
            android.graphics.Paint paintY = paint.y();
            int i4 = 0;
            while (i4 < list.size() - 1) {
                long jU = ((Offset) list.get(i4)).u();
                long jU2 = ((Offset) list.get(i4 + 1)).u();
                this.f25622a.drawLine(Float.intBitsToFloat((int) (jU >> 32)), Float.intBitsToFloat((int) (jU & 4294967295L)), Float.intBitsToFloat((int) (jU2 >> 32)), Float.intBitsToFloat((int) (jU2 & 4294967295L)), paintY);
                i4 += i3;
            }
        }
    }

    private final void b(List list, Paint paint) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            long jU = ((Offset) list.get(i3)).u();
            this.f25622a.drawPoint(Float.intBitsToFloat((int) (jU >> 32)), Float.intBitsToFloat((int) (jU & 4294967295L)), paint.y());
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void A(float f3, float f4, float f5, float f6, float f7, float f8, Paint paint) {
        this.f25622a.drawRoundRect(f3, f4, f5, f6, f7, f8, paint.y());
    }

    public final android.graphics.Canvas B() {
        return this.f25622a;
    }

    public final void C(android.graphics.Canvas canvas) {
        this.f25622a = canvas;
    }

    public final Region.Op D(int i3) {
        return ClipOp.e(i3, ClipOp.f25711b.a()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void c(float f3, float f4, float f5, float f6, int i3) {
        this.f25622a.clipRect(f3, f4, f5, f6, D(i3));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void d(Path path, int i3) {
        android.graphics.Canvas canvas = this.f25622a;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.clipPath(((AndroidPath) path).A(), D(i3));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void e(float f3, float f4) {
        this.f25622a.translate(f3, f4);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void f(float f3, float f4) {
        this.f25622a.scale(f3, f4);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void g(float f3, float f4, float f5, float f6, Paint paint) {
        this.f25622a.drawRect(f3, f4, f5, f6, paint.y());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void h(int i3, List list, Paint paint) {
        PointMode.Companion companion = PointMode.f25867b;
        if (PointMode.f(i3, companion.a())) {
            a(list, paint, 2);
        } else if (PointMode.f(i3, companion.c())) {
            a(list, paint, 1);
        } else if (PointMode.f(i3, companion.b())) {
            b(list, paint);
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void i(ImageBitmap imageBitmap, long j3, long j4, long j5, long j6, Paint paint) {
        if (this.f25623b == null) {
            this.f25623b = new Rect();
            this.f25624c = new Rect();
        }
        android.graphics.Canvas canvas = this.f25622a;
        Bitmap bitmapB = AndroidImageBitmap_androidKt.b(imageBitmap);
        Rect rect = this.f25623b;
        Intrinsics.checkNotNull(rect);
        rect.left = IntOffset.k(j3);
        rect.top = IntOffset.l(j3);
        rect.right = IntOffset.k(j3) + ((int) (j4 >> 32));
        rect.bottom = IntOffset.l(j3) + ((int) (j4 & 4294967295L));
        Unit unit = Unit.f139807a;
        Rect rect2 = this.f25624c;
        Intrinsics.checkNotNull(rect2);
        rect2.left = IntOffset.k(j5);
        rect2.top = IntOffset.l(j5);
        rect2.right = IntOffset.k(j5) + ((int) (j6 >> 32));
        rect2.bottom = IntOffset.l(j5) + ((int) (j6 & 4294967295L));
        canvas.drawBitmap(bitmapB, rect, rect2, paint.y());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void j(ImageBitmap imageBitmap, long j3, Paint paint) {
        this.f25622a.drawBitmap(AndroidImageBitmap_androidKt.b(imageBitmap), Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), paint.y());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void k() {
        this.f25622a.restore();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void m(float f3, float f4, float f5, float f6, float f7, float f8, boolean z2, Paint paint) {
        this.f25622a.drawArc(f3, f4, f5, f6, f7, f8, z2, paint.y());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void n() {
        CanvasUtils.f25706a.a(this.f25622a, true);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void p(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        this.f25622a.saveLayer(rect.o(), rect.r(), rect.p(), rect.i(), paint.y(), 31);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void q(long j3, long j4, Paint paint) {
        this.f25622a.drawLine(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)), paint.y());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void r(float f3) {
        this.f25622a.rotate(f3);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void t() {
        this.f25622a.save();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void u() {
        CanvasUtils.f25706a.a(this.f25622a, false);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void v(float[] fArr) {
        if (MatrixKt.a(fArr)) {
            return;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        AndroidMatrixConversions_androidKt.a(matrix, fArr);
        this.f25622a.concat(matrix);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void x(Path path, Paint paint) {
        android.graphics.Canvas canvas = this.f25622a;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((AndroidPath) path).A(), paint.y());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void z(long j3, float f3, Paint paint) {
        this.f25622a.drawCircle(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), f3, paint.y());
    }
}
