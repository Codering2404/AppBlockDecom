package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

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
public final class MultiWidgetSelectionDelegate implements Selectable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f11246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function0 f11247c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextLayoutResult f11249e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f11248d = this;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11250f = -1;

    public MultiWidgetSelectionDelegate(long j3, Function0 function0, Function0 function02) {
        this.f11245a = j3;
        this.f11246b = function0;
        this.f11247c = function02;
    }

    private final int c(TextLayoutResult textLayoutResult) {
        int i3;
        int iN;
        synchronized (this.f11248d) {
            try {
                if (this.f11249e != textLayoutResult) {
                    if (!textLayoutResult.f() || textLayoutResult.w().f()) {
                        iN = textLayoutResult.n() - 1;
                    } else {
                        int iK = RangesKt.k(textLayoutResult.r((int) (textLayoutResult.B() & 4294967295L)), textLayoutResult.n() - 1);
                        while (iK >= 0 && textLayoutResult.v(iK) >= ((int) (textLayoutResult.B() & 4294967295L))) {
                            iK--;
                        }
                        iN = RangesKt.f(iK, 0);
                    }
                    this.f11250f = textLayoutResult.o(iN, true);
                    this.f11249e = textLayoutResult;
                }
                i3 = this.f11250f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i3;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float a(int i3) {
        int iQ;
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.f11247c.invoke();
        if (textLayoutResult != null && (iQ = textLayoutResult.q(i3)) < textLayoutResult.n()) {
            return textLayoutResult.t(iQ);
        }
        return -1.0f;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float b(int i3) {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.f11247c.invoke();
        if (textLayoutResult != null) {
            return TextLayoutHelperKt.b(textLayoutResult, i3);
        }
        return 0.0f;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float d(int i3) {
        int iQ;
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.f11247c.invoke();
        if (textLayoutResult != null && (iQ = textLayoutResult.q(i3)) < textLayoutResult.n()) {
            return textLayoutResult.s(iQ);
        }
        return -1.0f;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Rect f(int i3) {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.f11247c.invoke();
        if (textLayoutResult == null) {
            return Rect.f25601e.a();
        }
        int length = textLayoutResult.l().j().length();
        return length < 1 ? Rect.f25601e.a() : textLayoutResult.d(RangesKt.p(i3, 0, length - 1));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long g(Selection selection, boolean z2) {
        if ((z2 && selection.e().e() != j()) || (!z2 && selection.c().e() != j())) {
            return Offset.f25596b.b();
        }
        if (z() == null) {
            return Offset.f25596b.b();
        }
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.f11247c.invoke();
        if (textLayoutResult == null) {
            return Offset.f25596b.b();
        }
        return TextSelectionDelegateKt.b(textLayoutResult, RangesKt.p((z2 ? selection.e() : selection.c()).d(), 0, c(textLayoutResult)), z2, selection.d());
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public AnnotatedString getText() {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.f11247c.invoke();
        return textLayoutResult == null ? new AnnotatedString("", null, 2, null) : textLayoutResult.l().j();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public int h() {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.f11247c.invoke();
        if (textLayoutResult == null) {
            return 0;
        }
        return c(textLayoutResult);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float i(int i3) {
        int iQ;
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.f11247c.invoke();
        if (textLayoutResult == null || (iQ = textLayoutResult.q(i3)) >= textLayoutResult.n()) {
            return -1.0f;
        }
        float fV = textLayoutResult.v(iQ);
        return ((textLayoutResult.m(iQ) - fV) / 2) + fV;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long j() {
        return this.f11245a;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Selection k() {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.f11247c.invoke();
        if (textLayoutResult == null) {
            return null;
        }
        int length = textLayoutResult.l().j().length();
        return new Selection(new Selection.AnchorInfo(textLayoutResult.c(0), 0, j()), new Selection.AnchorInfo(textLayoutResult.c(Math.max(length - 1, 0)), length, j()), false);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public void l(SelectionLayoutBuilder selectionLayoutBuilder) {
        TextLayoutResult textLayoutResult;
        LayoutCoordinates layoutCoordinatesZ = z();
        if (layoutCoordinatesZ == null || (textLayoutResult = (TextLayoutResult) this.f11247c.invoke()) == null) {
            return;
        }
        LayoutCoordinates layoutCoordinatesC = selectionLayoutBuilder.c();
        Offset.Companion companion = Offset.f25596b;
        long jS = layoutCoordinatesC.S(layoutCoordinatesZ, companion.c());
        MultiWidgetSelectionDelegateKt.a(selectionLayoutBuilder, textLayoutResult, Offset.p(selectionLayoutBuilder.d(), jS), (selectionLayoutBuilder.e() & 9223372034707292159L) == 9205357640488583168L ? companion.b() : Offset.p(selectionLayoutBuilder.e(), jS), j());
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long m(int i3) {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.f11247c.invoke();
        if (textLayoutResult == null) {
            return TextRange.f28921b.a();
        }
        int iC = c(textLayoutResult);
        if (iC < 1) {
            return TextRange.f28921b.a();
        }
        int iQ = textLayoutResult.q(RangesKt.p(i3, 0, iC - 1));
        return TextRangeKt.b(textLayoutResult.u(iQ), textLayoutResult.o(iQ, true));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public LayoutCoordinates z() {
        LayoutCoordinates layoutCoordinates = (LayoutCoordinates) this.f11246b.invoke();
        if (layoutCoordinates == null || !layoutCoordinates.m()) {
            return null;
        }
        return layoutCoordinates;
    }
}
