package nl.dionsegijn.konfetti.models;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public interface Shape {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Circle implements Shape {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Circle f143765b = new Circle();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final RectF f143764a = new RectF();

        private Circle() {
        }

        @Override // nl.dionsegijn.konfetti.models.Shape
        public void a(Canvas canvas, Paint paint, float f3) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            RectF rectF = f143764a;
            rectF.set(0.0f, 0.0f, f3, f3);
            canvas.drawOval(rectF, paint);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DrawableShape implements Shape {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f143766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Drawable f143767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f143768c;

        public DrawableShape(Drawable drawable, boolean z2) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.f143767b = drawable;
            this.f143768c = z2;
            this.f143766a = (drawable.getIntrinsicHeight() == -1 && drawable.getIntrinsicWidth() == -1) ? 1.0f : (drawable.getIntrinsicHeight() == -1 || drawable.getIntrinsicWidth() == -1) ? 0.0f : drawable.getIntrinsicHeight() / drawable.getIntrinsicWidth();
        }

        public static /* synthetic */ DrawableShape c(DrawableShape drawableShape, Drawable drawable, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                drawable = drawableShape.f143767b;
            }
            if ((i3 & 2) != 0) {
                z2 = drawableShape.f143768c;
            }
            return drawableShape.b(drawable, z2);
        }

        @Override // nl.dionsegijn.konfetti.models.Shape
        public void a(Canvas canvas, Paint paint, float f3) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            if (this.f143768c) {
                this.f143767b.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
            } else {
                this.f143767b.setAlpha(paint.getAlpha());
            }
            int i3 = (int) (this.f143766a * f3);
            int i4 = (int) ((f3 - i3) / 2.0f);
            this.f143767b.setBounds(0, i4, (int) f3, i3 + i4);
            this.f143767b.draw(canvas);
        }

        public final DrawableShape b(Drawable drawable, boolean z2) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            return new DrawableShape(drawable, z2);
        }

        public final Drawable d() {
            return this.f143767b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawableShape)) {
                return false;
            }
            DrawableShape drawableShape = (DrawableShape) obj;
            return Intrinsics.areEqual(this.f143767b, drawableShape.f143767b) && this.f143768c == drawableShape.f143768c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            Drawable drawable = this.f143767b;
            int iHashCode = (drawable != null ? drawable.hashCode() : 0) * 31;
            boolean z2 = this.f143768c;
            ?? r12 = z2;
            if (z2) {
                r12 = 1;
            }
            return iHashCode + r12;
        }

        public String toString() {
            return "DrawableShape(drawable=" + this.f143767b + ", tint=" + this.f143768c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Rectangle implements Shape {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f143769a;

        @Override // nl.dionsegijn.konfetti.models.Shape
        public void a(Canvas canvas, Paint paint, float f3) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            float f4 = this.f143769a * f3;
            float f5 = (f3 - f4) / 2.0f;
            canvas.drawRect(0.0f, f5, f3, f5 + f4, paint);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Square implements Shape {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Square f143770a = new Square();

        private Square() {
        }

        @Override // nl.dionsegijn.konfetti.models.Shape
        public void a(Canvas canvas, Paint paint, float f3) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            canvas.drawRect(0.0f, 0.0f, f3, f3, paint);
        }
    }

    void a(Canvas canvas, Paint paint, float f3);
}
