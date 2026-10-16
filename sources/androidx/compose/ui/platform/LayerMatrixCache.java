package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.MatrixKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

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
public final class LayerMatrixCache<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f28115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Matrix f28116b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f28119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f28120f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float[] f28117c = androidx.compose.ui.graphics.Matrix.c(null, 1, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f28118d = androidx.compose.ui.graphics.Matrix.c(null, 1, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f28121g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f28122h = true;

    public LayerMatrixCache(Function2 function2) {
        this.f28115a = function2;
    }

    public final float[] a(Object obj) {
        float[] fArr = this.f28118d;
        if (this.f28120f) {
            this.f28121g = InvertMatrixKt.a(b(obj), fArr);
            this.f28120f = false;
        }
        if (this.f28121g) {
            return fArr;
        }
        return null;
    }

    public final float[] b(Object obj) {
        float[] fArr = this.f28117c;
        if (!this.f28119e) {
            return fArr;
        }
        Matrix matrix = this.f28116b;
        if (matrix == null) {
            matrix = new Matrix();
            this.f28116b = matrix;
        }
        this.f28115a.invoke(obj, matrix);
        AndroidMatrixConversions_androidKt.b(fArr, matrix);
        this.f28119e = false;
        this.f28122h = MatrixKt.a(fArr);
        return fArr;
    }

    public final void c() {
        this.f28119e = true;
        this.f28120f = true;
    }

    public final void d(Object obj, MutableRect mutableRect) {
        float[] fArrB = b(obj);
        if (this.f28122h) {
            return;
        }
        androidx.compose.ui.graphics.Matrix.g(fArrB, mutableRect);
    }

    public final long e(Object obj, long j3) {
        return !this.f28122h ? androidx.compose.ui.graphics.Matrix.f(b(obj), j3) : j3;
    }

    public final void f(Object obj, MutableRect mutableRect) {
        float[] fArrA = a(obj);
        if (fArrA == null) {
            mutableRect.g(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            if (this.f28122h) {
                return;
            }
            androidx.compose.ui.graphics.Matrix.g(fArrA, mutableRect);
        }
    }

    public final long g(Object obj, long j3) {
        float[] fArrA = a(obj);
        return fArrA == null ? Offset.f25596b.a() : !this.f28122h ? androidx.compose.ui.graphics.Matrix.f(fArrA, j3) : j3;
    }

    public final void h() {
        this.f28119e = false;
        this.f28120f = false;
        this.f28122h = true;
        this.f28121g = true;
        androidx.compose.ui.graphics.Matrix.h(this.f28117c);
        androidx.compose.ui.graphics.Matrix.h(this.f28118d);
    }
}
