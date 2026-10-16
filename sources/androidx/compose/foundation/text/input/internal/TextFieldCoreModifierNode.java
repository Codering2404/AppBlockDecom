package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.selection.AndroidTextFieldMagnifier_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Constraints;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
public final class TextFieldCoreModifierNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, SemanticsModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10450d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextLayoutState f10451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TransformedTextFieldState f10452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextFieldSelectionState f10453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Brush f10454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10455j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ScrollState f10456k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Orientation f10457l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private CursorAnimationState f10458m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Job f10459n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextRange f10460o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Rect f10461p = new Rect(-1.0f, -1.0f, -1.0f, -1.0f);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f10462q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final TextFieldMagnifierNode f10463r;

    public TextFieldCoreModifierNode(boolean z2, boolean z3, TextLayoutState textLayoutState, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, Brush brush, boolean z4, ScrollState scrollState, Orientation orientation) {
        this.f10449c = z2;
        this.f10450d = z3;
        this.f10451f = textLayoutState;
        this.f10452g = transformedTextFieldState;
        this.f10453h = textFieldSelectionState;
        this.f10454i = brush;
        this.f10455j = z4;
        this.f10456k = scrollState;
        this.f10457l = orientation;
        this.f10463r = (TextFieldMagnifierNode) m2(AndroidTextFieldMagnifier_androidKt.a(this.f10452g, this.f10453h, this.f10451f, this.f10449c || this.f10450d));
    }

    private final void A2(DrawScope drawScope, long j3, TextLayoutResult textLayoutResult) {
        int iL = TextRange.l(j3);
        int iK = TextRange.k(j3);
        if (iL != iK) {
            DrawScope.u0(drawScope, textLayoutResult.z(iL, iK), ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.a(this, TextSelectionColorsKt.b())).a(), 0.0f, null, null, 0, 60, null);
        }
    }

    private final void B2(DrawScope drawScope, TextLayoutResult textLayoutResult) throws Throwable {
        TextPainter.f28920a.a(drawScope.Q1().g(), textLayoutResult);
    }

    private final boolean C2() {
        if (this.f10455j) {
            return (this.f10449c || this.f10450d) && TextFieldCoreModifierKt.e(this.f10454i);
        }
        return false;
    }

    private final MeasureResult D2(final MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(Constraints.d(j3, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, 0, 13, null));
        final int iMin = Math.min(placeableN0.X0(), Constraints.l(j3));
        return MeasureScope.B0(measureScope, iMin, placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$measureHorizontalScroll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                this.f10464a.H2(measureScope, iMin, placeableN0.X0(), this.f10464a.f10452g.o().g(), measureScope.getLayoutDirection());
                Placeable.PlacementScope.m(placementScope, placeableN0, -this.f10464a.f10456k.n(), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    private final MeasureResult E2(final MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(Constraints.d(j3, 0, 0, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 7, null));
        final int iMin = Math.min(placeableN0.O0(), Constraints.k(j3));
        return MeasureScope.B0(measureScope, placeableN0.X0(), iMin, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$measureVerticalScroll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                this.f10468a.H2(measureScope, iMin, placeableN0.O0(), this.f10468a.f10452g.o().g(), measureScope.getLayoutDirection());
                Placeable.PlacementScope.m(placementScope, placeableN0, 0, -this.f10468a.f10456k.n(), 0.0f, 4, null);
            }
        }, 4, null);
    }

    private final void F2() {
        if (this.f10458m == null) {
            this.f10458m = new CursorAnimationState(((Boolean) CompositionLocalConsumerModifierNodeKt.a(this, CompositionLocalsKt.e())).booleanValue());
            DrawModifierNodeKt.a(this);
        }
        this.f10459n = BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new TextFieldCoreModifierNode$startCursorJob$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void H2(androidx.compose.ui.unit.Density r9, int r10, int r11, long r12, androidx.compose.ui.unit.LayoutDirection r14) {
        /*
            r8 = this;
            int r0 = r11 - r10
            androidx.compose.foundation.ScrollState r1 = r8.f10456k
            r1.o(r0)
            int r0 = r8.x2(r12, r11)
            if (r0 < 0) goto Lc6
            boolean r1 = r8.C2()
            if (r1 != 0) goto L15
            goto Lc6
        L15:
            androidx.compose.foundation.text.input.internal.TextLayoutState r1 = r8.f10451f
            androidx.compose.ui.text.TextLayoutResult r1 = r1.f()
            if (r1 != 0) goto L1f
            goto Lc6
        L1f:
            kotlin.ranges.IntRange r2 = new kotlin.ranges.IntRange
            androidx.compose.ui.text.TextLayoutInput r3 = r1.l()
            androidx.compose.ui.text.AnnotatedString r3 = r3.j()
            int r3 = r3.length()
            r4 = 0
            r2.<init>(r4, r3)
            int r0 = kotlin.ranges.RangesKt.q(r0, r2)
            androidx.compose.ui.geometry.Rect r0 = r1.e(r0)
            androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.f30002b
            r2 = 1
            if (r14 != r1) goto L40
            r14 = r2
            goto L41
        L40:
            r14 = r4
        L41:
            androidx.compose.ui.geometry.Rect r9 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierKt.a(r9, r0, r14, r11)
            float r14 = r9.o()
            androidx.compose.ui.geometry.Rect r1 = r8.f10461p
            float r1 = r1.o()
            int r14 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r14 != 0) goto L65
            float r14 = r9.r()
            androidx.compose.ui.geometry.Rect r1 = r8.f10461p
            float r1 = r1.r()
            int r14 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r14 != 0) goto L65
            int r14 = r8.f10462q
            if (r11 == r14) goto Lc6
        L65:
            androidx.compose.foundation.gestures.Orientation r14 = r8.f10457l
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.f6031a
            if (r14 != r1) goto L6c
            r4 = r2
        L6c:
            if (r4 == 0) goto L73
            float r14 = r9.r()
            goto L77
        L73:
            float r14 = r9.o()
        L77:
            if (r4 == 0) goto L7e
            float r1 = r9.i()
            goto L82
        L7e:
            float r1 = r9.p()
        L82:
            androidx.compose.foundation.ScrollState r2 = r8.f10456k
            int r2 = r2.n()
            int r3 = r2 + r10
            float r3 = (float) r3
            int r4 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r4 <= 0) goto L91
        L8f:
            float r1 = r1 - r3
            goto Laa
        L91:
            float r2 = (float) r2
            int r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r4 >= 0) goto L9e
            float r5 = r1 - r14
            float r6 = (float) r10
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L9e
            goto L8f
        L9e:
            if (r4 >= 0) goto La9
            float r1 = r1 - r14
            float r10 = (float) r10
            int r10 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r10 > 0) goto La9
            float r1 = r14 - r2
            goto Laa
        La9:
            r1 = 0
        Laa:
            androidx.compose.ui.text.TextRange r10 = androidx.compose.ui.text.TextRange.b(r12)
            r8.f10460o = r10
            r8.f10461p = r9
            r8.f10462q = r11
            kotlinx.coroutines.CoroutineScope r2 = r8.getCoroutineScope()
            kotlinx.coroutines.CoroutineStart r4 = kotlinx.coroutines.CoroutineStart.f140919d
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1 r5 = new androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1
            r9 = 0
            r5.<init>(r8, r1, r0, r9)
            r6 = 1
            r7 = 0
            r3 = 0
            kotlinx.coroutines.BuildersKt.d(r2, r3, r4, r5, r6, r7)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.H2(androidx.compose.ui.unit.Density, int, int, long, androidx.compose.ui.unit.LayoutDirection):void");
    }

    private final int x2(long j3, int i3) {
        TextRange textRange = this.f10460o;
        if (textRange == null || TextRange.i(j3) != TextRange.i(textRange.r())) {
            return TextRange.i(j3);
        }
        TextRange textRange2 = this.f10460o;
        if (textRange2 == null || TextRange.n(j3) != TextRange.n(textRange2.r())) {
            return TextRange.n(j3);
        }
        if (i3 != this.f10462q) {
            return TextRange.n(j3);
        }
        return -1;
    }

    private final void y2(DrawScope drawScope) {
        CursorAnimationState cursorAnimationState = this.f10458m;
        float fE = cursorAnimationState != null ? cursorAnimationState.e() : 0.0f;
        if (fE != 0.0f && C2()) {
            Rect rectW = this.f10453h.W();
            DrawScope.h2(drawScope, this.f10454i, rectW.s(), rectW.j(), rectW.p() - rectW.o(), 0, null, fE, null, 0, 432, null);
        }
    }

    private final void z2(DrawScope drawScope, Pair pair, TextLayoutResult textLayoutResult) {
        int i3 = ((TextHighlightType) pair.a()).i();
        long jR = ((TextRange) pair.b()).r();
        if (TextRange.h(jR)) {
            return;
        }
        Path pathZ = textLayoutResult.z(TextRange.l(jR), TextRange.k(jR));
        if (!TextHighlightType.f(i3, TextHighlightType.f10159b.a())) {
            DrawScope.u0(drawScope, pathZ, ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.a(this, TextSelectionColorsKt.b())).a(), 0.0f, null, null, 0, 60, null);
            return;
        }
        Brush brushI = textLayoutResult.l().i().i();
        if (brushI != null) {
            DrawScope.F1(drawScope, pathZ, brushI, 0.2f, null, null, 0, 56, null);
            return;
        }
        long j3 = textLayoutResult.l().i().j();
        if (j3 == 16) {
            j3 = Color.f25715b.a();
        }
        long j4 = j3;
        DrawScope.u0(drawScope, pathZ, Color.r(j4, Color.u(j4) * 0.2f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, null, null, 0, 60, null);
    }

    public final void G2(boolean z2, boolean z3, TextLayoutState textLayoutState, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, Brush brush, boolean z4, ScrollState scrollState, Orientation orientation) {
        boolean zC2 = C2();
        boolean z5 = this.f10449c;
        TransformedTextFieldState transformedTextFieldState2 = this.f10452g;
        TextLayoutState textLayoutState2 = this.f10451f;
        TextFieldSelectionState textFieldSelectionState2 = this.f10453h;
        ScrollState scrollState2 = this.f10456k;
        this.f10449c = z2;
        this.f10450d = z3;
        this.f10451f = textLayoutState;
        this.f10452g = transformedTextFieldState;
        this.f10453h = textFieldSelectionState;
        this.f10454i = brush;
        this.f10455j = z4;
        this.f10456k = scrollState;
        this.f10457l = orientation;
        this.f10463r.s2(transformedTextFieldState, textFieldSelectionState, textLayoutState, z2 || z3);
        if (!C2()) {
            Job job = this.f10459n;
            if (job != null) {
                Job.DefaultImpls.b(job, null, 1, null);
            }
            this.f10459n = null;
            CursorAnimationState cursorAnimationState = this.f10458m;
            if (cursorAnimationState != null) {
                cursorAnimationState.c();
            }
        } else if (!z5 || !Intrinsics.areEqual(transformedTextFieldState2, transformedTextFieldState) || !zC2) {
            F2();
        }
        if (Intrinsics.areEqual(transformedTextFieldState2, transformedTextFieldState) && Intrinsics.areEqual(textLayoutState2, textLayoutState) && Intrinsics.areEqual(textFieldSelectionState2, textFieldSelectionState) && Intrinsics.areEqual(scrollState2, scrollState)) {
            return;
        }
        LayoutModifierNodeKt.b(this);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void I(LayoutCoordinates layoutCoordinates) {
        this.f10451f.m(layoutCoordinates);
        this.f10463r.I(layoutCoordinates);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.f10463r.N(semanticsPropertyReceiver);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) throws Throwable {
        contentDrawScope.i2();
        TextFieldCharSequence textFieldCharSequenceO = this.f10452g.o();
        TextLayoutResult textLayoutResultF = this.f10451f.f();
        if (textLayoutResultF == null) {
            return;
        }
        Pair pairE = textFieldCharSequenceO.e();
        if (pairE != null) {
            z2(contentDrawScope, pairE, textLayoutResultF);
        }
        if (TextRange.h(textFieldCharSequenceO.g())) {
            B2(contentDrawScope, textLayoutResultF);
            if (textFieldCharSequenceO.i()) {
                y2(contentDrawScope);
            }
        } else {
            if (textFieldCharSequenceO.i()) {
                A2(contentDrawScope, textFieldCharSequenceO.g(), textLayoutResultF);
            }
            B2(contentDrawScope, textLayoutResultF);
        }
        this.f10463r.draw(contentDrawScope);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        return this.f10457l == Orientation.f6031a ? E2(measureScope, measurable, j3) : D2(measureScope, measurable, j3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        if (this.f10449c && C2()) {
            F2();
        }
    }
}
