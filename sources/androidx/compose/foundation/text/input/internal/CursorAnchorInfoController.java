package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

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
public final class CursorAnchorInfoController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransformedTextFieldState f10291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextLayoutState f10292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComposeInputMethodManager f10293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineScope f10294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Job f10297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10300j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f10301k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final CursorAnchorInfo.Builder f10302l = new CursorAnchorInfo.Builder();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float[] f10303m = Matrix.c(null, 1, null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final android.graphics.Matrix f10304n = new android.graphics.Matrix();

    public CursorAnchorInfoController(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, ComposeInputMethodManager composeInputMethodManager, CoroutineScope coroutineScope) {
        this.f10291a = transformedTextFieldState;
        this.f10292b = textLayoutState;
        this.f10293c = composeInputMethodManager;
        this.f10294d = coroutineScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CursorAnchorInfo c() {
        LayoutCoordinates layoutCoordinatesD;
        LayoutCoordinates layoutCoordinatesE;
        TextLayoutResult textLayoutResultF;
        LayoutCoordinates layoutCoordinatesJ = this.f10292b.j();
        if (layoutCoordinatesJ != null) {
            if (!layoutCoordinatesJ.m()) {
                layoutCoordinatesJ = null;
            }
            if (layoutCoordinatesJ != null && (layoutCoordinatesD = this.f10292b.d()) != null) {
                if (!layoutCoordinatesD.m()) {
                    layoutCoordinatesD = null;
                }
                if (layoutCoordinatesD != null && (layoutCoordinatesE = this.f10292b.e()) != null) {
                    if (!layoutCoordinatesE.m()) {
                        layoutCoordinatesE = null;
                    }
                    if (layoutCoordinatesE == null || (textLayoutResultF = this.f10292b.f()) == null) {
                        return null;
                    }
                    TextFieldCharSequence textFieldCharSequenceO = this.f10291a.o();
                    Matrix.h(this.f10303m);
                    layoutCoordinatesJ.i0(this.f10303m);
                    AndroidMatrixConversions_androidKt.a(this.f10304n, this.f10303m);
                    Rect rectI = SelectionManagerKt.i(layoutCoordinatesD);
                    Offset.Companion companion = Offset.f25596b;
                    return CursorAnchorInfoBuilder_androidKt.b(this.f10302l, textFieldCharSequenceO, textFieldCharSequenceO.g(), textFieldCharSequenceO.d(), textLayoutResultF, this.f10304n, rectI.B(layoutCoordinatesJ.S(layoutCoordinatesD, companion.c())), SelectionManagerKt.i(layoutCoordinatesE).B(layoutCoordinatesJ.S(layoutCoordinatesE, companion.c())), this.f10298h, this.f10299i, this.f10300j, this.f10301k);
                }
            }
        }
        return null;
    }

    private final void e(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f10298h = z4;
        this.f10299i = z5;
        this.f10300j = z6;
        this.f10301k = z7;
        if (z2) {
            this.f10296f = true;
            CursorAnchorInfo cursorAnchorInfoC = c();
            if (cursorAnchorInfoC != null) {
                this.f10293c.updateCursorAnchorInfo(cursorAnchorInfoC);
            }
        }
        this.f10295e = z3;
        f();
    }

    private final void f() {
        if (!this.f10295e) {
            Job job = this.f10297g;
            if (job != null) {
                Job.DefaultImpls.b(job, null, 1, null);
            }
            this.f10297g = null;
            return;
        }
        Job job2 = this.f10297g;
        if (job2 == null || !job2.isActive()) {
            this.f10297g = BuildersKt__Builders_commonKt.d(this.f10294d, null, CoroutineStart.f140919d, new CursorAnchorInfoController$startOrStopMonitoring$1(this, null), 1, null);
        }
    }

    public final void d(int i3) {
        CursorAnchorInfoController cursorAnchorInfoController;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = false;
        boolean z7 = (i3 & 1) != 0;
        boolean z8 = (i3 & 2) != 0;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33) {
            boolean z9 = (i3 & 16) != 0;
            boolean z10 = (i3 & 8) != 0;
            boolean z11 = (i3 & 4) != 0;
            if (i4 >= 34 && (i3 & 32) != 0) {
                z6 = true;
            }
            if (z9 || z10 || z11 || z6) {
                z3 = z6;
                z2 = z11;
                z5 = z10;
                z4 = z9;
                cursorAnchorInfoController = this;
            } else {
                cursorAnchorInfoController = this;
                if (i4 >= 34) {
                    z4 = true;
                    z5 = true;
                    z2 = true;
                    z3 = true;
                } else {
                    z3 = z6;
                    z4 = true;
                    z5 = true;
                    z2 = true;
                }
            }
        } else {
            cursorAnchorInfoController = this;
            z2 = false;
            z3 = false;
            z4 = true;
            z5 = true;
        }
        cursorAnchorInfoController.e(z7, z8, z4, z5, z2, z3);
    }
}
