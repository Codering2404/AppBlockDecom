package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LegacyCursorAnchorInfoController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f10370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputMethodManager f10371b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextFieldValue f10379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextLayoutResult f10380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private OffsetMapping f10381l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Rect f10382m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Rect f10383n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f10372c = new Object();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final CursorAnchorInfo.Builder f10384o = new CursorAnchorInfo.Builder();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final float[] f10385p = Matrix.c(null, 1, null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final android.graphics.Matrix f10386q = new android.graphics.Matrix();

    public LegacyCursorAnchorInfoController(Function1 function1, InputMethodManager inputMethodManager) {
        this.f10370a = function1;
        this.f10371b = inputMethodManager;
    }

    private final void c() {
        if (!this.f10371b.isActive() || this.f10379j == null || this.f10381l == null || this.f10380k == null || this.f10382m == null || this.f10383n == null) {
            return;
        }
        Matrix.h(this.f10385p);
        this.f10370a.invoke(Matrix.a(this.f10385p));
        float[] fArr = this.f10385p;
        Rect rect = this.f10383n;
        Intrinsics.checkNotNull(rect);
        float f3 = -rect.o();
        Rect rect2 = this.f10383n;
        Intrinsics.checkNotNull(rect2);
        Matrix.n(fArr, f3, -rect2.r(), 0.0f);
        AndroidMatrixConversions_androidKt.a(this.f10386q, this.f10385p);
        InputMethodManager inputMethodManager = this.f10371b;
        CursorAnchorInfo.Builder builder = this.f10384o;
        TextFieldValue textFieldValue = this.f10379j;
        Intrinsics.checkNotNull(textFieldValue);
        OffsetMapping offsetMapping = this.f10381l;
        Intrinsics.checkNotNull(offsetMapping);
        TextLayoutResult textLayoutResult = this.f10380k;
        Intrinsics.checkNotNull(textLayoutResult);
        android.graphics.Matrix matrix = this.f10386q;
        Rect rect3 = this.f10382m;
        Intrinsics.checkNotNull(rect3);
        Rect rect4 = this.f10383n;
        Intrinsics.checkNotNull(rect4);
        inputMethodManager.updateCursorAnchorInfo(LegacyCursorAnchorInfoBuilder_androidKt.b(builder, textFieldValue, offsetMapping, textLayoutResult, matrix, rect3, rect4, this.f10375f, this.f10376g, this.f10377h, this.f10378i));
        this.f10374e = false;
    }

    public final void a() {
        synchronized (this.f10372c) {
            this.f10379j = null;
            this.f10381l = null;
            this.f10380k = null;
            this.f10382m = null;
            this.f10383n = null;
            Unit unit = Unit.f139807a;
        }
    }

    public final void b(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        synchronized (this.f10372c) {
            try {
                this.f10375f = z4;
                this.f10376g = z5;
                this.f10377h = z6;
                this.f10378i = z7;
                if (z2) {
                    this.f10374e = true;
                    if (this.f10379j != null) {
                        c();
                    }
                }
                this.f10373d = z3;
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect rect, Rect rect2) {
        synchronized (this.f10372c) {
            try {
                this.f10379j = textFieldValue;
                this.f10381l = offsetMapping;
                this.f10380k = textLayoutResult;
                this.f10382m = rect;
                this.f10383n = rect2;
                if (this.f10374e || this.f10373d) {
                    c();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
