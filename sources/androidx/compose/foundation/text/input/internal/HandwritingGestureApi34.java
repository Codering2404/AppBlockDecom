package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

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
public final class HandwritingGestureApi34 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HandwritingGestureApi34 f10329a = new HandwritingGestureApi34();

    private HandwritingGestureApi34() {
    }

    private final void A(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        e(transformedTextFieldState, HandwritingGesture_androidKt.w(textLayoutState, RectHelper_androidKt.f(deleteGesture.getDeletionArea()), L(deleteGesture.getGranularity()), TextInclusionStrategy.f28883a.h()), TextHighlightType.f10159b.a());
    }

    private final void B(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.e0(HandwritingGesture_androidKt.x(legacyTextFieldState, RectHelper_androidKt.f(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.f(deleteRangeGesture.getDeletionEndArea()), L(deleteRangeGesture.getGranularity()), TextInclusionStrategy.f28883a.h()));
        }
    }

    private final void C(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        e(transformedTextFieldState, HandwritingGesture_androidKt.y(textLayoutState, RectHelper_androidKt.f(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.f(deleteRangeGesture.getDeletionEndArea()), L(deleteRangeGesture.getGranularity()), TextInclusionStrategy.f28883a.h()), TextHighlightType.f10159b.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(TransformedTextFieldState transformedTextFieldState) {
        TextFieldState textFieldState = transformedTextFieldState.f10664a;
        InputTransformation inputTransformation = transformedTextFieldState.f10665b;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        textFieldState.f().e().e();
        TextFieldBuffer textFieldBufferF = textFieldState.f();
        textFieldBufferF.c();
        transformedTextFieldState.G(textFieldBufferF);
        textFieldState.d(inputTransformation, true, textFieldEditUndoBehavior);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.p();
        }
    }

    private final void H(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.o0(HandwritingGesture_androidKt.v(legacyTextFieldState, RectHelper_androidKt.f(selectGesture.getSelectionArea()), L(selectGesture.getGranularity()), TextInclusionStrategy.f28883a.h()));
        }
    }

    private final void I(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        e(transformedTextFieldState, HandwritingGesture_androidKt.w(textLayoutState, RectHelper_androidKt.f(selectGesture.getSelectionArea()), L(selectGesture.getGranularity()), TextInclusionStrategy.f28883a.h()), TextHighlightType.f10159b.b());
    }

    private final void J(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.o0(HandwritingGesture_androidKt.x(legacyTextFieldState, RectHelper_androidKt.f(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.f(selectRangeGesture.getSelectionEndArea()), L(selectRangeGesture.getGranularity()), TextInclusionStrategy.f28883a.h()));
        }
    }

    private final void K(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        e(transformedTextFieldState, HandwritingGesture_androidKt.y(textLayoutState, RectHelper_androidKt.f(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.f(selectRangeGesture.getSelectionEndArea()), L(selectRangeGesture.getGranularity()), TextInclusionStrategy.f28883a.h()), TextHighlightType.f10159b.b());
    }

    private final int L(int i3) {
        return i3 != 1 ? i3 != 2 ? TextGranularity.f28879b.a() : TextGranularity.f28879b.a() : TextGranularity.f28879b.b();
    }

    private final int c(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture) {
        TextFieldState textFieldState = transformedTextFieldState.f10664a;
        InputTransformation inputTransformation = transformedTextFieldState.f10665b;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        textFieldState.f().e().e();
        TextFieldBuffer textFieldBufferF = textFieldState.f();
        textFieldBufferF.c();
        transformedTextFieldState.G(textFieldBufferF);
        textFieldState.d(inputTransformation, true, textFieldEditUndoBehavior);
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        TransformedTextFieldState.x(transformedTextFieldState, fallbackText, true, null, false, 12, null);
        return 5;
    }

    private final int d(HandwritingGesture handwritingGesture, Function1 function1) {
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        function1.invoke(new CommitTextCommand(fallbackText, 1));
        return 5;
    }

    private final void e(TransformedTextFieldState transformedTextFieldState, long j3, int i3) {
        if (!TextRange.h(j3)) {
            transformedTextFieldState.p(i3, j3);
            return;
        }
        TextFieldState textFieldState = transformedTextFieldState.f10664a;
        InputTransformation inputTransformation = transformedTextFieldState.f10665b;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        textFieldState.f().e().e();
        TextFieldBuffer textFieldBufferF = textFieldState.f();
        textFieldBufferF.c();
        transformedTextFieldState.G(textFieldBufferF);
        textFieldState.d(inputTransformation, true, textFieldEditUndoBehavior);
    }

    private final int f(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, AnnotatedString annotatedString, Function1 function1) {
        int iL = L(deleteGesture.getGranularity());
        long jV = HandwritingGesture_androidKt.v(legacyTextFieldState, RectHelper_androidKt.f(deleteGesture.getDeletionArea()), iL, TextInclusionStrategy.f28883a.h());
        if (TextRange.h(jV)) {
            return f10329a.d(m0.a(deleteGesture), function1);
        }
        k(jV, annotatedString, TextGranularity.e(iL, TextGranularity.f28879b.b()), function1);
        return 1;
    }

    private final int g(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        int iL = L(deleteGesture.getGranularity());
        long jW = HandwritingGesture_androidKt.w(textLayoutState, RectHelper_androidKt.f(deleteGesture.getDeletionArea()), iL, TextInclusionStrategy.f28883a.h());
        if (TextRange.h(jW)) {
            return f10329a.c(transformedTextFieldState, m0.a(deleteGesture));
        }
        j(transformedTextFieldState, jW, TextGranularity.e(iL, TextGranularity.f28879b.b()));
        return 1;
    }

    private final int h(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, AnnotatedString annotatedString, Function1 function1) {
        int iL = L(deleteRangeGesture.getGranularity());
        long jX = HandwritingGesture_androidKt.x(legacyTextFieldState, RectHelper_androidKt.f(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.f(deleteRangeGesture.getDeletionEndArea()), iL, TextInclusionStrategy.f28883a.h());
        if (TextRange.h(jX)) {
            return f10329a.d(m0.a(deleteRangeGesture), function1);
        }
        k(jX, annotatedString, TextGranularity.e(iL, TextGranularity.f28879b.b()), function1);
        return 1;
    }

    private final int i(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        int iL = L(deleteRangeGesture.getGranularity());
        long jY = HandwritingGesture_androidKt.y(textLayoutState, RectHelper_androidKt.f(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.f(deleteRangeGesture.getDeletionEndArea()), iL, TextInclusionStrategy.f28883a.h());
        if (TextRange.h(jY)) {
            return f10329a.c(transformedTextFieldState, m0.a(deleteRangeGesture));
        }
        j(transformedTextFieldState, jY, TextGranularity.e(iL, TextGranularity.f28879b.b()));
        return 1;
    }

    private final void j(TransformedTextFieldState transformedTextFieldState, long j3, boolean z2) {
        if (z2) {
            j3 = HandwritingGesture_androidKt.m(j3, transformedTextFieldState.o());
        }
        TransformedTextFieldState.z(transformedTextFieldState, "", j3, null, false, 12, null);
    }

    private final void k(long j3, AnnotatedString annotatedString, boolean z2, Function1 function1) {
        if (z2) {
            j3 = HandwritingGesture_androidKt.m(j3, annotatedString);
        }
        function1.invoke(HandwritingGesture_androidKt.n(new SetSelectionCommand(TextRange.i(j3), TextRange.i(j3)), new DeleteSurroundingTextCommand(TextRange.j(j3), 0)));
    }

    private final int n(LegacyTextFieldState legacyTextFieldState, InsertGesture insertGesture, ViewConfiguration viewConfiguration, Function1 function1) {
        TextLayoutResultProxy textLayoutResultProxyL;
        TextLayoutResult textLayoutResultF;
        if (viewConfiguration == null) {
            return d(m0.a(insertGesture), function1);
        }
        int iQ = HandwritingGesture_androidKt.q(legacyTextFieldState, HandwritingGesture_androidKt.F(insertGesture.getInsertionPoint()), viewConfiguration);
        if (iQ == -1 || !((textLayoutResultProxyL = legacyTextFieldState.l()) == null || (textLayoutResultF = textLayoutResultProxyL.f()) == null || !HandwritingGesture_androidKt.z(textLayoutResultF, iQ))) {
            return d(m0.a(insertGesture), function1);
        }
        p(iQ, insertGesture.getTextToInsert(), function1);
        return 1;
    }

    private final int o(TransformedTextFieldState transformedTextFieldState, InsertGesture insertGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        int iR = HandwritingGesture_androidKt.r(textLayoutState, HandwritingGesture_androidKt.F(insertGesture.getInsertionPoint()), viewConfiguration);
        if (iR == -1) {
            return c(transformedTextFieldState, m0.a(insertGesture));
        }
        TransformedTextFieldState.z(transformedTextFieldState, insertGesture.getTextToInsert(), TextRangeKt.a(iR), null, false, 12, null);
        return 1;
    }

    private final void p(int i3, String str, Function1 function1) {
        function1.invoke(HandwritingGesture_androidKt.n(new SetSelectionCommand(i3, i3), new CommitTextCommand(str, 1)));
    }

    private final int q(LegacyTextFieldState legacyTextFieldState, JoinOrSplitGesture joinOrSplitGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1 function1) {
        TextLayoutResultProxy textLayoutResultProxyL;
        TextLayoutResult textLayoutResultF;
        if (viewConfiguration == null) {
            return d(m0.a(joinOrSplitGesture), function1);
        }
        int iQ = HandwritingGesture_androidKt.q(legacyTextFieldState, HandwritingGesture_androidKt.F(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
        if (iQ == -1 || !((textLayoutResultProxyL = legacyTextFieldState.l()) == null || (textLayoutResultF = textLayoutResultProxyL.f()) == null || !HandwritingGesture_androidKt.z(textLayoutResultF, iQ))) {
            return d(m0.a(joinOrSplitGesture), function1);
        }
        long jE = HandwritingGesture_androidKt.E(annotatedString, iQ);
        if (TextRange.h(jE)) {
            p(TextRange.n(jE), " ", function1);
        } else {
            k(jE, annotatedString, false, function1);
        }
        return 1;
    }

    private final int r(TransformedTextFieldState transformedTextFieldState, JoinOrSplitGesture joinOrSplitGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        TextLayoutResult textLayoutResultF;
        if (transformedTextFieldState.l() != transformedTextFieldState.n()) {
            return 3;
        }
        int iR = HandwritingGesture_androidKt.r(textLayoutState, HandwritingGesture_androidKt.F(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
        if (iR == -1 || ((textLayoutResultF = textLayoutState.f()) != null && HandwritingGesture_androidKt.z(textLayoutResultF, iR))) {
            return c(transformedTextFieldState, m0.a(joinOrSplitGesture));
        }
        long jE = HandwritingGesture_androidKt.E(transformedTextFieldState.o(), iR);
        if (TextRange.h(jE)) {
            TransformedTextFieldState.z(transformedTextFieldState, " ", jE, null, false, 12, null);
        } else {
            j(transformedTextFieldState, jE, false);
        }
        return 1;
    }

    private final int s(LegacyTextFieldState legacyTextFieldState, RemoveSpaceGesture removeSpaceGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1 function1) {
        TextLayoutResultProxy textLayoutResultProxyL = legacyTextFieldState.l();
        long jT = HandwritingGesture_androidKt.t(textLayoutResultProxyL != null ? textLayoutResultProxyL.f() : null, HandwritingGesture_androidKt.F(removeSpaceGesture.getStartPoint()), HandwritingGesture_androidKt.F(removeSpaceGesture.getEndPoint()), legacyTextFieldState.k(), viewConfiguration);
        if (TextRange.h(jT)) {
            return f10329a.d(m0.a(removeSpaceGesture), function1);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.f140142a = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.f140142a = -1;
        String strL = new Regex("\\s+").l(TextRangeKt.e(annotatedString, jT), new Function1<MatchResult, CharSequence>() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$performRemoveSpaceGesture$newText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                Ref.IntRef intRef3 = intRef;
                if (intRef3.f140142a == -1) {
                    intRef3.f140142a = matchResult.c().g();
                }
                intRef2.f140142a = matchResult.c().h() + 1;
                return "";
            }
        });
        if (intRef.f140142a == -1 || intRef2.f140142a == -1) {
            return d(m0.a(removeSpaceGesture), function1);
        }
        int iN = TextRange.n(jT) + intRef.f140142a;
        int iN2 = TextRange.n(jT) + intRef2.f140142a;
        String strSubstring = strL.substring(intRef.f140142a, strL.length() - (TextRange.j(jT) - intRef2.f140142a));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        function1.invoke(HandwritingGesture_androidKt.n(new SetSelectionCommand(iN, iN2), new CommitTextCommand(strSubstring, 1)));
        return 1;
    }

    private final int t(TransformedTextFieldState transformedTextFieldState, RemoveSpaceGesture removeSpaceGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        long jT = HandwritingGesture_androidKt.t(textLayoutState.f(), HandwritingGesture_androidKt.F(removeSpaceGesture.getStartPoint()), HandwritingGesture_androidKt.F(removeSpaceGesture.getEndPoint()), textLayoutState.j(), viewConfiguration);
        if (TextRange.h(jT)) {
            return f10329a.c(transformedTextFieldState, m0.a(removeSpaceGesture));
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.f140142a = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.f140142a = -1;
        String strL = new Regex("\\s+").l(TextRangeKt.e(transformedTextFieldState.o(), jT), new Function1<MatchResult, CharSequence>() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$performRemoveSpaceGesture$newText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                Ref.IntRef intRef3 = intRef;
                if (intRef3.f140142a == -1) {
                    intRef3.f140142a = matchResult.c().g();
                }
                intRef2.f140142a = matchResult.c().h() + 1;
                return "";
            }
        });
        if (intRef.f140142a == -1 || intRef2.f140142a == -1) {
            return c(transformedTextFieldState, m0.a(removeSpaceGesture));
        }
        long jB = TextRangeKt.b(TextRange.n(jT) + intRef.f140142a, TextRange.n(jT) + intRef2.f140142a);
        String strSubstring = strL.substring(intRef.f140142a, strL.length() - (TextRange.j(jT) - intRef2.f140142a));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        TransformedTextFieldState.z(transformedTextFieldState, strSubstring, jB, null, false, 12, null);
        return 1;
    }

    private final int u(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager, Function1 function1) {
        long jV = HandwritingGesture_androidKt.v(legacyTextFieldState, RectHelper_androidKt.f(selectGesture.getSelectionArea()), L(selectGesture.getGranularity()), TextInclusionStrategy.f28883a.h());
        if (TextRange.h(jV)) {
            return f10329a.d(m0.a(selectGesture), function1);
        }
        y(jV, textFieldSelectionManager, function1);
        return 1;
    }

    private final int v(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState, Function0 function0) {
        long jW = HandwritingGesture_androidKt.w(textLayoutState, RectHelper_androidKt.f(selectGesture.getSelectionArea()), L(selectGesture.getGranularity()), TextInclusionStrategy.f28883a.h());
        if (TextRange.h(jW)) {
            return f10329a.c(transformedTextFieldState, m0.a(selectGesture));
        }
        transformedTextFieldState.B(jW);
        if (function0 == null) {
            return 1;
        }
        function0.invoke();
        return 1;
    }

    private final int w(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager, Function1 function1) {
        long jX = HandwritingGesture_androidKt.x(legacyTextFieldState, RectHelper_androidKt.f(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.f(selectRangeGesture.getSelectionEndArea()), L(selectRangeGesture.getGranularity()), TextInclusionStrategy.f28883a.h());
        if (TextRange.h(jX)) {
            return f10329a.d(m0.a(selectRangeGesture), function1);
        }
        y(jX, textFieldSelectionManager, function1);
        return 1;
    }

    private final int x(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState, Function0 function0) {
        long jY = HandwritingGesture_androidKt.y(textLayoutState, RectHelper_androidKt.f(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.f(selectRangeGesture.getSelectionEndArea()), L(selectRangeGesture.getGranularity()), TextInclusionStrategy.f28883a.h());
        if (TextRange.h(jY)) {
            return f10329a.c(transformedTextFieldState, m0.a(selectRangeGesture));
        }
        transformedTextFieldState.B(jY);
        if (function0 == null) {
            return 1;
        }
        function0.invoke();
        return 1;
    }

    private final void y(long j3, TextFieldSelectionManager textFieldSelectionManager, Function1 function1) {
        function1.invoke(new SetSelectionCommand(TextRange.n(j3), TextRange.i(j3)));
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.x(true);
        }
    }

    private final void z(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.e0(HandwritingGesture_androidKt.v(legacyTextFieldState, RectHelper_androidKt.f(deleteGesture.getDeletionArea()), L(deleteGesture.getGranularity()), TextInclusionStrategy.f28883a.h()));
        }
    }

    public final boolean D(LegacyTextFieldState legacyTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, final TextFieldSelectionManager textFieldSelectionManager, CancellationSignal cancellationSignal) {
        TextLayoutResult textLayoutResultF;
        TextLayoutInput textLayoutInputL;
        AnnotatedString annotatedStringY = legacyTextFieldState.y();
        if (annotatedStringY == null) {
            return false;
        }
        TextLayoutResultProxy textLayoutResultProxyL = legacyTextFieldState.l();
        if (!Intrinsics.areEqual(annotatedStringY, (textLayoutResultProxyL == null || (textLayoutResultF = textLayoutResultProxyL.f()) == null || (textLayoutInputL = textLayoutResultF.l()) == null) ? null : textLayoutInputL.j())) {
            return false;
        }
        if (w.a(previewableHandwritingGesture)) {
            H(legacyTextFieldState, h0.a(previewableHandwritingGesture), textFieldSelectionManager);
        } else if (s0.a(previewableHandwritingGesture)) {
            z(legacyTextFieldState, u0.a(previewableHandwritingGesture), textFieldSelectionManager);
        } else if (v0.a(previewableHandwritingGesture)) {
            J(legacyTextFieldState, w0.a(previewableHandwritingGesture), textFieldSelectionManager);
        } else {
            if (!x0.a(previewableHandwritingGesture)) {
                return false;
            }
            B(legacyTextFieldState, y0.a(previewableHandwritingGesture), textFieldSelectionManager);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.compose.foundation.text.input.internal.b1
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                HandwritingGestureApi34.G(textFieldSelectionManager);
            }
        });
        return true;
    }

    public final boolean E(final TransformedTextFieldState transformedTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, TextLayoutState textLayoutState, CancellationSignal cancellationSignal) {
        if (w.a(previewableHandwritingGesture)) {
            I(transformedTextFieldState, h0.a(previewableHandwritingGesture), textLayoutState);
        } else if (s0.a(previewableHandwritingGesture)) {
            A(transformedTextFieldState, u0.a(previewableHandwritingGesture), textLayoutState);
        } else if (v0.a(previewableHandwritingGesture)) {
            K(transformedTextFieldState, w0.a(previewableHandwritingGesture), textLayoutState);
        } else {
            if (!x0.a(previewableHandwritingGesture)) {
                return false;
            }
            C(transformedTextFieldState, y0.a(previewableHandwritingGesture), textLayoutState);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.compose.foundation.text.input.internal.c1
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                HandwritingGestureApi34.F(transformedTextFieldState);
            }
        });
        return true;
    }

    public final int l(LegacyTextFieldState legacyTextFieldState, HandwritingGesture handwritingGesture, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration, Function1 function1) {
        TextLayoutResult textLayoutResultF;
        TextLayoutInput textLayoutInputL;
        AnnotatedString annotatedStringY = legacyTextFieldState.y();
        if (annotatedStringY == null) {
            return 3;
        }
        TextLayoutResultProxy textLayoutResultProxyL = legacyTextFieldState.l();
        if (!Intrinsics.areEqual(annotatedStringY, (textLayoutResultProxyL == null || (textLayoutResultF = textLayoutResultProxyL.f()) == null || (textLayoutInputL = textLayoutResultF.l()) == null) ? null : textLayoutInputL.j())) {
            return 3;
        }
        if (w.a(handwritingGesture)) {
            return u(legacyTextFieldState, h0.a(handwritingGesture), textFieldSelectionManager, function1);
        }
        if (s0.a(handwritingGesture)) {
            return f(legacyTextFieldState, u0.a(handwritingGesture), annotatedStringY, function1);
        }
        if (v0.a(handwritingGesture)) {
            return w(legacyTextFieldState, w0.a(handwritingGesture), textFieldSelectionManager, function1);
        }
        if (x0.a(handwritingGesture)) {
            return h(legacyTextFieldState, y0.a(handwritingGesture), annotatedStringY, function1);
        }
        if (k0.a(handwritingGesture)) {
            return q(legacyTextFieldState, l0.a(handwritingGesture), annotatedStringY, viewConfiguration, function1);
        }
        if (f0.a(handwritingGesture)) {
            return n(legacyTextFieldState, g0.a(handwritingGesture), viewConfiguration, function1);
        }
        if (i0.a(handwritingGesture)) {
            return s(legacyTextFieldState, j0.a(handwritingGesture), annotatedStringY, viewConfiguration, function1);
        }
        return 2;
    }

    public final int m(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture, TextLayoutState textLayoutState, Function0 function0, ViewConfiguration viewConfiguration) {
        if (w.a(handwritingGesture)) {
            return v(transformedTextFieldState, h0.a(handwritingGesture), textLayoutState, function0);
        }
        if (s0.a(handwritingGesture)) {
            return g(transformedTextFieldState, u0.a(handwritingGesture), textLayoutState);
        }
        if (v0.a(handwritingGesture)) {
            return x(transformedTextFieldState, w0.a(handwritingGesture), textLayoutState, function0);
        }
        if (x0.a(handwritingGesture)) {
            return i(transformedTextFieldState, y0.a(handwritingGesture), textLayoutState);
        }
        if (k0.a(handwritingGesture)) {
            return r(transformedTextFieldState, l0.a(handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (f0.a(handwritingGesture)) {
            return o(transformedTextFieldState, g0.a(handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (i0.a(handwritingGesture)) {
            return t(transformedTextFieldState, j0.a(handwritingGesture), textLayoutState, viewConfiguration);
        }
        return 2;
    }
}
