package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class MatrixUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Matrix f53444a = new Matrix() { // from class: androidx.transition.MatrixUtils.1
        void a() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f3, float f4, float f5) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f3, float f4, float f5, float f6) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f3, float f4, float f5, float f6) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f3, float f4, float f5) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f3, float f4, float f5, float f6) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f3, float f4, float f5, float f6) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            a();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            a();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i3, float[] fArr2, int i4, int i5) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f3, float f4, float f5) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f3, float f4, float f5, float f6) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f3, float f4, float f5, float f6) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f3, float f4, float f5, float f6) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f3, float f4) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            a();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f3) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f3) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f3) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f3, float f4) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f3, float f4) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f3, float f4) {
            a();
        }
    };
}
