package androidx.compose.ui.text.input;

import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
@Deprecated
@Metadata
public final class CursorAnchorInfoController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MatrixPositionCalculator f29309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputMethodManager f29310b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f29312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f29313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f29314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f29315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f29316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f29317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextFieldValue f29318j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextLayoutResult f29319k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private OffsetMapping f29320l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Rect f29322n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Rect f29323o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f29311c = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Function1 f29321m = new Function1<Matrix, Unit>() { // from class: androidx.compose.ui.text.input.CursorAnchorInfoController$textFieldToRootTransform$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c(((Matrix) obj).p());
            return Unit.f139807a;
        }

        public final void c(float[] fArr) {
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final CursorAnchorInfo.Builder f29324p = new CursorAnchorInfo.Builder();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final float[] f29325q = Matrix.c(null, 1, null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final android.graphics.Matrix f29326r = new android.graphics.Matrix();

    public CursorAnchorInfoController(MatrixPositionCalculator matrixPositionCalculator, InputMethodManager inputMethodManager) {
        this.f29309a = matrixPositionCalculator;
        this.f29310b = inputMethodManager;
    }

    private final void c() {
        if (this.f29310b.isActive()) {
            this.f29321m.invoke(Matrix.a(this.f29325q));
            this.f29309a.q(this.f29325q);
            AndroidMatrixConversions_androidKt.a(this.f29326r, this.f29325q);
            InputMethodManager inputMethodManager = this.f29310b;
            CursorAnchorInfo.Builder builder = this.f29324p;
            TextFieldValue textFieldValue = this.f29318j;
            Intrinsics.checkNotNull(textFieldValue);
            OffsetMapping offsetMapping = this.f29320l;
            Intrinsics.checkNotNull(offsetMapping);
            TextLayoutResult textLayoutResult = this.f29319k;
            Intrinsics.checkNotNull(textLayoutResult);
            android.graphics.Matrix matrix = this.f29326r;
            Rect rect = this.f29322n;
            Intrinsics.checkNotNull(rect);
            Rect rect2 = this.f29323o;
            Intrinsics.checkNotNull(rect2);
            inputMethodManager.updateCursorAnchorInfo(CursorAnchorInfoBuilder_androidKt.b(builder, textFieldValue, offsetMapping, textLayoutResult, matrix, rect, rect2, this.f29314f, this.f29315g, this.f29316h, this.f29317i));
            this.f29313e = false;
        }
    }

    public final void a() {
        synchronized (this.f29311c) {
            this.f29318j = null;
            this.f29320l = null;
            this.f29319k = null;
            this.f29321m = new Function1<Matrix, Unit>() { // from class: androidx.compose.ui.text.input.CursorAnchorInfoController$invalidate$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c(((Matrix) obj).p());
                    return Unit.f139807a;
                }

                public final void c(float[] fArr) {
                }
            };
            this.f29322n = null;
            this.f29323o = null;
            Unit unit = Unit.f139807a;
        }
    }

    public final void b(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        synchronized (this.f29311c) {
            try {
                this.f29314f = z4;
                this.f29315g = z5;
                this.f29316h = z6;
                this.f29317i = z7;
                if (z2) {
                    this.f29313e = true;
                    if (this.f29318j != null) {
                        c();
                    }
                }
                this.f29312d = z3;
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Function1 function1, Rect rect, Rect rect2) {
        synchronized (this.f29311c) {
            try {
                this.f29318j = textFieldValue;
                this.f29320l = offsetMapping;
                this.f29319k = textLayoutResult;
                this.f29321m = function1;
                this.f29322n = rect;
                this.f29323o = rect2;
                if (this.f29313e || this.f29312d) {
                    c();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
