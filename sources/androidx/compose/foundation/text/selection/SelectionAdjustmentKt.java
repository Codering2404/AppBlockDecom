package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class SelectionAdjustmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection e(SelectionLayout selectionLayout, BoundaryFunction boundaryFunction) {
        boolean z2 = selectionLayout.e() == CrossStatus.f11212a;
        return new Selection(f(selectionLayout.k(), z2, true, selectionLayout.l(), boundaryFunction), f(selectionLayout.j(), z2, false, selectionLayout.d(), boundaryFunction), z2);
    }

    private static final Selection.AnchorInfo f(SelectableInfo selectableInfo, boolean z2, boolean z3, int i3, BoundaryFunction boundaryFunction) {
        int iG = z3 ? selectableInfo.g() : selectableInfo.e();
        if (i3 != selectableInfo.i()) {
            return selectableInfo.a(iG);
        }
        long jA = boundaryFunction.a(selectableInfo, iG);
        return selectableInfo.a(z2 ^ z3 ? TextRange.n(jA) : TextRange.i(jA));
    }

    private static final Selection.AnchorInfo g(Selection.AnchorInfo anchorInfo, SelectableInfo selectableInfo, int i3) {
        return Selection.AnchorInfo.b(anchorInfo, selectableInfo.k().c(i3), i3, 0L, 4, null);
    }

    public static final Selection h(Selection selection, SelectionLayout selectionLayout) {
        if (SelectionLayoutKt.d(selection, selectionLayout)) {
            return (selectionLayout.getSize() > 1 || selectionLayout.g() == null || selectionLayout.b().c().length() == 0) ? selection : i(selection, selectionLayout);
        }
        return selection;
    }

    private static final Selection i(Selection selection, SelectionLayout selectionLayout) {
        SelectableInfo selectableInfoB = selectionLayout.b();
        String strC = selectableInfoB.c();
        int iG = selectableInfoB.g();
        int length = strC.length();
        if (iG == 0) {
            int iA = StringHelpers_androidKt.a(strC, 0);
            return selectionLayout.a() ? Selection.b(selection, g(selection.e(), selectableInfoB, iA), null, true, 2, null) : Selection.b(selection, null, g(selection.c(), selectableInfoB, iA), false, 1, null);
        }
        if (iG == length) {
            int iB = StringHelpers_androidKt.b(strC, length);
            return selectionLayout.a() ? Selection.b(selection, g(selection.e(), selectableInfoB, iB), null, false, 2, null) : Selection.b(selection, null, g(selection.c(), selectableInfoB, iB), true, 1, null);
        }
        Selection selectionG = selectionLayout.g();
        boolean z2 = selectionG != null && selectionG.d();
        int iB2 = selectionLayout.a() ^ z2 ? StringHelpers_androidKt.b(strC, iG) : StringHelpers_androidKt.a(strC, iG);
        return selectionLayout.a() ? Selection.b(selection, g(selection.e(), selectableInfoB, iB2), null, z2, 2, null) : Selection.b(selection, null, g(selection.c(), selectableInfoB, iB2), z2, 1, null);
    }

    private static final boolean j(SelectableInfo selectableInfo, int i3, boolean z2) {
        if (selectableInfo.f() == -1) {
            return true;
        }
        if (i3 == selectableInfo.f()) {
            return false;
        }
        return z2 ^ (selectableInfo.d() == CrossStatus.f11212a) ? i3 < selectableInfo.f() : i3 > selectableInfo.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection.AnchorInfo k(SelectableInfo selectableInfo, int i3, int i4, int i5, boolean z2, boolean z3) {
        long jC = selectableInfo.k().C(i4);
        int iN = selectableInfo.k().q(TextRange.n(jC)) == i3 ? TextRange.n(jC) : i3 >= selectableInfo.k().n() ? selectableInfo.k().u(selectableInfo.k().n() - 1) : selectableInfo.k().u(i3);
        int i6 = selectableInfo.k().q(TextRange.i(jC)) == i3 ? TextRange.i(jC) : i3 >= selectableInfo.k().n() ? TextLayoutResult.p(selectableInfo.k(), selectableInfo.k().n() - 1, false, 2, null) : TextLayoutResult.p(selectableInfo.k(), i3, false, 2, null);
        if (iN == i5) {
            return selectableInfo.a(i6);
        }
        if (i6 == i5) {
            return selectableInfo.a(iN);
        }
        if (!(z2 ^ z3) ? i4 >= iN : i4 > i6) {
            iN = i6;
        }
        return selectableInfo.a(iN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection.AnchorInfo l(final SelectionLayout selectionLayout, final SelectableInfo selectableInfo, Selection.AnchorInfo anchorInfo) {
        final int iG = selectionLayout.a() ? selectableInfo.g() : selectableInfo.e();
        if ((selectionLayout.a() ? selectionLayout.l() : selectionLayout.d()) != selectableInfo.i()) {
            return selectableInfo.a(iG);
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139763c;
        final Lazy lazyA = LazyKt.a(lazyThreadSafetyMode, new Function0<Integer>() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustmentKt$updateSelectionBoundary$currentRawLine$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(selectableInfo.k().q(iG));
            }
        });
        final int iE = selectionLayout.a() ? selectableInfo.e() : selectableInfo.g();
        Lazy lazyA2 = LazyKt.a(lazyThreadSafetyMode, new Function0<Selection.AnchorInfo>() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustmentKt$updateSelectionBoundary$anchorSnappedToWordBoundary$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Selection.AnchorInfo invoke() {
                return SelectionAdjustmentKt.k(selectableInfo, SelectionAdjustmentKt.m(lazyA), iG, iE, selectionLayout.a(), selectionLayout.e() == CrossStatus.f11212a);
            }
        });
        if (selectableInfo.h() != anchorInfo.e()) {
            return n(lazyA2);
        }
        int iF = selectableInfo.f();
        if (iG == iF) {
            return anchorInfo;
        }
        if (m(lazyA) != selectableInfo.k().q(iF)) {
            return n(lazyA2);
        }
        int iD = anchorInfo.d();
        long jC = selectableInfo.k().C(iD);
        return !j(selectableInfo, iG, selectionLayout.a()) ? selectableInfo.a(iG) : (iD == TextRange.n(jC) || iD == TextRange.i(jC)) ? n(lazyA2) : selectableInfo.a(iG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(Lazy lazy) {
        return ((Number) lazy.getValue()).intValue();
    }

    private static final Selection.AnchorInfo n(Lazy lazy) {
        return (Selection.AnchorInfo) lazy.getValue();
    }
}
