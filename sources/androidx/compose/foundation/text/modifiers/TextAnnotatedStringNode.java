package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnnotatedString f11104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextStyle f11105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FontFamily.Resolver f11106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function1 f11107d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List f11112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Function1 f11113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private SelectionController f11114l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ColorProducer f11115m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextAutoSize f11116n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Function1 f11117o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Map f11118p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MultiParagraphLayoutCache f11119q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Function1 f11120r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextSubstitutionValue f11121s;

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i3, boolean z2, int i4, int i5, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize, Function1 function13, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i3, z2, i4, i5, list, function12, selectionController, colorProducer, textAutoSize, function13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E2(AnnotatedString annotatedString) {
        Unit unit;
        TextSubstitutionValue textSubstitutionValue = this.f11121s;
        if (textSubstitutionValue == null) {
            TextSubstitutionValue textSubstitutionValue2 = new TextSubstitutionValue(this.f11104a, annotatedString, false, null, 12, null);
            MultiParagraphLayoutCache multiParagraphLayoutCache = new MultiParagraphLayoutCache(annotatedString, this.f11105b, this.f11106c, this.f11108f, this.f11109g, this.f11110h, this.f11111i, CollectionsKt.emptyList(), this.f11116n, null);
            multiParagraphLayoutCache.t(v2().h());
            textSubstitutionValue2.e(multiParagraphLayoutCache);
            this.f11121s = textSubstitutionValue2;
            return true;
        }
        if (Intrinsics.areEqual(annotatedString, textSubstitutionValue.c())) {
            return false;
        }
        textSubstitutionValue.g(annotatedString);
        MultiParagraphLayoutCache multiParagraphLayoutCacheA = textSubstitutionValue.a();
        if (multiParagraphLayoutCacheA != null) {
            multiParagraphLayoutCacheA.x(annotatedString, this.f11105b, this.f11106c, this.f11108f, this.f11109g, this.f11110h, this.f11111i, CollectionsKt.emptyList(), this.f11116n);
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        return unit != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MultiParagraphLayoutCache v2() {
        if (this.f11119q == null) {
            this.f11119q = new MultiParagraphLayoutCache(this.f11104a, this.f11105b, this.f11106c, this.f11108f, this.f11109g, this.f11110h, this.f11111i, this.f11112j, this.f11116n, null);
        }
        MultiParagraphLayoutCache multiParagraphLayoutCache = this.f11119q;
        Intrinsics.checkNotNull(multiParagraphLayoutCache);
        return multiParagraphLayoutCache;
    }

    private final MultiParagraphLayoutCache w2(Density density) {
        MultiParagraphLayoutCache multiParagraphLayoutCacheA;
        TextSubstitutionValue textSubstitutionValue = this.f11121s;
        if (textSubstitutionValue != null && textSubstitutionValue.d() && (multiParagraphLayoutCacheA = textSubstitutionValue.a()) != null) {
            multiParagraphLayoutCacheA.t(density);
            return multiParagraphLayoutCacheA;
        }
        MultiParagraphLayoutCache multiParagraphLayoutCacheV2 = v2();
        multiParagraphLayoutCacheV2.t(density);
        return multiParagraphLayoutCacheV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y2() {
        SemanticsModifierNodeKt.b(this);
        LayoutModifierNodeKt.b(this);
        DrawModifierNodeKt.a(this);
    }

    public final int A2(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    public final MeasureResult B2(MeasureScope measureScope, Measurable measurable, long j3) {
        return mo11measure3p2s80s(measureScope, measurable, j3);
    }

    public final int C2(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    public final int D2(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    public final boolean F2(Function1 function1, Function1 function12, SelectionController selectionController, Function1 function13) {
        boolean z2;
        if (this.f11107d != function1) {
            this.f11107d = function1;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f11113k != function12) {
            this.f11113k = function12;
            z2 = true;
        }
        if (!Intrinsics.areEqual(this.f11114l, selectionController)) {
            this.f11114l = selectionController;
            z2 = true;
        }
        if (this.f11117o == function13) {
            return z2;
        }
        this.f11117o = function13;
        return true;
    }

    public final boolean G2(ColorProducer colorProducer, TextStyle textStyle) {
        boolean zAreEqual = Intrinsics.areEqual(colorProducer, this.f11115m);
        this.f11115m = colorProducer;
        return (zAreEqual && textStyle.H(this.f11105b)) ? false : true;
    }

    public final boolean H2(TextStyle textStyle, List list, int i3, int i4, boolean z2, FontFamily.Resolver resolver, int i5, TextAutoSize textAutoSize) {
        boolean z3 = !this.f11105b.I(textStyle);
        this.f11105b = textStyle;
        if (!Intrinsics.areEqual(this.f11112j, list)) {
            this.f11112j = list;
            z3 = true;
        }
        if (this.f11111i != i3) {
            this.f11111i = i3;
            z3 = true;
        }
        if (this.f11110h != i4) {
            this.f11110h = i4;
            z3 = true;
        }
        if (this.f11109g != z2) {
            this.f11109g = z2;
            z3 = true;
        }
        if (!Intrinsics.areEqual(this.f11106c, resolver)) {
            this.f11106c = resolver;
            z3 = true;
        }
        if (!TextOverflow.h(this.f11108f, i5)) {
            this.f11108f = i5;
            z3 = true;
        }
        if (Intrinsics.areEqual(this.f11116n, textAutoSize)) {
            return z3;
        }
        this.f11116n = textAutoSize;
        return true;
    }

    public final boolean I2(AnnotatedString annotatedString) {
        boolean zAreEqual = Intrinsics.areEqual(this.f11104a.k(), annotatedString.k());
        boolean z2 = (zAreEqual && this.f11104a.n(annotatedString)) ? false : true;
        if (z2) {
            this.f11104a = annotatedString;
        }
        if (!zAreEqual) {
            s2();
        }
        return z2;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Function1<List<TextLayoutResult>, Boolean> function1 = this.f11120r;
        if (function1 == null) {
            function1 = new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$1
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x00b7  */
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Boolean invoke(java.util.List r38) {
                    /*
                        r37 = this;
                        r0 = r37
                        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r1 = r0.f11126a
                        androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache r1 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.m2(r1)
                        androidx.compose.ui.text.TextLayoutResult r2 = r1.j()
                        if (r2 == 0) goto Lb7
                        androidx.compose.ui.text.TextLayoutInput r3 = new androidx.compose.ui.text.TextLayoutInput
                        androidx.compose.ui.text.TextLayoutInput r1 = r2.l()
                        androidx.compose.ui.text.AnnotatedString r4 = r1.j()
                        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r1 = r0.f11126a
                        androidx.compose.ui.text.TextStyle r5 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.p2(r1)
                        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r1 = r0.f11126a
                        androidx.compose.ui.graphics.ColorProducer r1 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.o2(r1)
                        if (r1 == 0) goto L2b
                        long r6 = r1.a()
                        goto L31
                    L2b:
                        androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.f25715b
                        long r6 = r1.k()
                    L31:
                        r35 = 16777214(0xfffffe, float:2.3509884E-38)
                        r36 = 0
                        r8 = 0
                        r10 = 0
                        r11 = 0
                        r12 = 0
                        r13 = 0
                        r14 = 0
                        r15 = 0
                        r17 = 0
                        r18 = 0
                        r19 = 0
                        r20 = 0
                        r22 = 0
                        r23 = 0
                        r24 = 0
                        r25 = 0
                        r26 = 0
                        r27 = 0
                        r29 = 0
                        r30 = 0
                        r31 = 0
                        r32 = 0
                        r33 = 0
                        r34 = 0
                        androidx.compose.ui.text.TextStyle r5 = androidx.compose.ui.text.TextStyle.N(r5, r6, r8, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32, r33, r34, r35, r36)
                        androidx.compose.ui.text.TextLayoutInput r1 = r2.l()
                        java.util.List r6 = r1.g()
                        androidx.compose.ui.text.TextLayoutInput r1 = r2.l()
                        int r7 = r1.e()
                        androidx.compose.ui.text.TextLayoutInput r1 = r2.l()
                        boolean r8 = r1.h()
                        androidx.compose.ui.text.TextLayoutInput r1 = r2.l()
                        int r9 = r1.f()
                        androidx.compose.ui.text.TextLayoutInput r1 = r2.l()
                        androidx.compose.ui.unit.Density r10 = r1.b()
                        androidx.compose.ui.text.TextLayoutInput r1 = r2.l()
                        androidx.compose.ui.unit.LayoutDirection r11 = r1.d()
                        androidx.compose.ui.text.TextLayoutInput r1 = r2.l()
                        androidx.compose.ui.text.font.FontFamily$Resolver r12 = r1.c()
                        androidx.compose.ui.text.TextLayoutInput r1 = r2.l()
                        long r13 = r1.a()
                        r15 = 0
                        r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15)
                        r6 = 2
                        r7 = 0
                        r4 = 0
                        androidx.compose.ui.text.TextLayoutResult r1 = androidx.compose.ui.text.TextLayoutResult.b(r2, r3, r4, r6, r7)
                        if (r1 == 0) goto Lb7
                        r2 = r38
                        r2.add(r1)
                        goto Lb8
                    Lb7:
                        r1 = 0
                    Lb8:
                        if (r1 == 0) goto Lbc
                        r1 = 1
                        goto Lbd
                    Lbc:
                        r1 = 0
                    Lbd:
                        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$1.invoke(java.util.List):java.lang.Boolean");
                }
            };
            this.f11120r = function1;
        }
        SemanticsPropertiesKt.y0(semanticsPropertyReceiver, this.f11104a);
        TextSubstitutionValue textSubstitutionValue = this.f11121s;
        if (textSubstitutionValue != null) {
            SemanticsPropertiesKt.C0(semanticsPropertyReceiver, textSubstitutionValue.c());
            SemanticsPropertiesKt.v0(semanticsPropertyReceiver, textSubstitutionValue.d());
        }
        SemanticsPropertiesKt.E0(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(AnnotatedString annotatedString) {
                this.f11127a.E2(annotatedString);
                this.f11127a.y2();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.K0(semanticsPropertyReceiver, null, new Function1<Boolean, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$3
            {
                super(1);
            }

            public final Boolean c(boolean z2) {
                if (this.f11128a.x2() == null) {
                    return Boolean.FALSE;
                }
                Function1 function12 = this.f11128a.f11117o;
                if (function12 != null) {
                    TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValueX2 = this.f11128a.x2();
                    Intrinsics.checkNotNull(textSubstitutionValueX2);
                    function12.invoke(textSubstitutionValueX2);
                }
                TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValueX22 = this.f11128a.x2();
                if (textSubstitutionValueX22 != null) {
                    textSubstitutionValueX22.f(z2);
                }
                this.f11128a.y2();
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Boolean) obj).booleanValue());
            }
        }, 1, null);
        SemanticsPropertiesKt.d(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                this.f11129a.s2();
                this.f11129a.y2();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.u(semanticsPropertyReceiver, null, function1, 1, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        if (isAttached()) {
            SelectionController selectionController = this.f11114l;
            if (selectionController != null) {
                selectionController.b(contentDrawScope);
            }
            Canvas canvasG = contentDrawScope.Q1().g();
            TextLayoutResult textLayoutResultK = w2(contentDrawScope).k();
            MultiParagraph multiParagraphW = textLayoutResultK.w();
            boolean z2 = true;
            boolean z3 = textLayoutResultK.i() && !TextOverflow.h(this.f11108f, TextOverflow.f29661b.e());
            if (z3) {
                Rect rectC = RectKt.c(Offset.f25596b.c(), Size.d((((long) Float.floatToRawIntBits((int) (textLayoutResultK.B() >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (textLayoutResultK.B() & 4294967295L))) & 4294967295L)));
                canvasG.t();
                Canvas.s(canvasG, rectC, 0, 2, null);
            }
            try {
                TextDecoration textDecorationC = this.f11105b.C();
                if (textDecorationC == null) {
                    textDecorationC = TextDecoration.f29625b.c();
                }
                TextDecoration textDecoration = textDecorationC;
                Shadow shadowZ = this.f11105b.z();
                if (shadowZ == null) {
                    shadowZ = Shadow.f25903d.a();
                }
                Shadow shadow = shadowZ;
                DrawStyle drawStyleK = this.f11105b.k();
                if (drawStyleK == null) {
                    drawStyleK = Fill.f26098a;
                }
                DrawStyle drawStyle = drawStyleK;
                Brush brushI = this.f11105b.i();
                if (brushI != null) {
                    MultiParagraph.J(multiParagraphW, canvasG, brushI, this.f11105b.f(), shadow, textDecoration, drawStyle, 0, 64, null);
                } else {
                    ColorProducer colorProducer = this.f11115m;
                    long jA = colorProducer != null ? colorProducer.a() : Color.f25715b.k();
                    if (jA == 16) {
                        jA = this.f11105b.j() != 16 ? this.f11105b.j() : Color.f25715b.a();
                    }
                    multiParagraphW.G(canvasG, (32 & 2) != 0 ? Color.f25715b.k() : jA, (32 & 4) != 0 ? null : shadow, (32 & 8) != 0 ? null : textDecoration, (32 & 16) == 0 ? drawStyle : null, (32 & 32) != 0 ? DrawScope.e8.a() : 0);
                }
                if (z3) {
                    canvasG.k();
                }
                TextSubstitutionValue textSubstitutionValue = this.f11121s;
                if (!((textSubstitutionValue == null || !textSubstitutionValue.d()) ? TextAnnotatedStringNodeKt.a(this.f11104a) : false)) {
                    List list = this.f11112j;
                    if (list != null && !list.isEmpty()) {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                }
                contentDrawScope.i2();
            } catch (Throwable th) {
                if (z3) {
                    canvasG.k();
                }
                throw th;
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return w2(intrinsicMeasureScope).l(i3, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return w2(intrinsicMeasureScope).q(intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        MultiParagraphLayoutCache multiParagraphLayoutCacheW2 = w2(measureScope);
        boolean zN = multiParagraphLayoutCacheW2.n(j3, measureScope.getLayoutDirection());
        TextLayoutResult textLayoutResultK = multiParagraphLayoutCacheW2.k();
        textLayoutResultK.w().j().a();
        if (zN) {
            LayoutModifierNodeKt.a(this);
            Function1 function1 = this.f11107d;
            if (function1 != null) {
                function1.invoke(textLayoutResultK);
            }
            SelectionController selectionController = this.f11114l;
            if (selectionController != null) {
                selectionController.h(textLayoutResultK);
            }
            Map linkedHashMap = this.f11118p;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap(2);
            }
            linkedHashMap.put(AlignmentLineKt.a(), Integer.valueOf(Math.round(textLayoutResultK.h())));
            linkedHashMap.put(AlignmentLineKt.b(), Integer.valueOf(Math.round(textLayoutResultK.k())));
            this.f11118p = linkedHashMap;
        }
        Function1 function12 = this.f11113k;
        if (function12 != null) {
            function12.invoke(textLayoutResultK.A());
        }
        final Placeable placeableN0 = measurable.n0(Constraints.f29963b.b((int) (textLayoutResultK.B() >> 32), (int) (textLayoutResultK.B() >> 32), (int) (textLayoutResultK.B() & 4294967295L), (int) (textLayoutResultK.B() & 4294967295L)));
        int iB = (int) (textLayoutResultK.B() >> 32);
        int iB2 = (int) (textLayoutResultK.B() & 4294967295L);
        Map map = this.f11118p;
        Intrinsics.checkNotNull(map);
        return measureScope.c1(iB, iB2, map, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.i(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
            }
        });
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return w2(intrinsicMeasureScope).l(i3, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return w2(intrinsicMeasureScope).r(intrinsicMeasureScope.getLayoutDirection());
    }

    public final void s2() {
        this.f11121s = null;
    }

    public final void t2(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (z3 || z4 || z5) {
            v2().x(this.f11104a, this.f11105b, this.f11106c, this.f11108f, this.f11109g, this.f11110h, this.f11111i, this.f11112j, this.f11116n);
        }
        if (isAttached()) {
            if (z3 || (z2 && this.f11120r != null)) {
                SemanticsModifierNodeKt.b(this);
            }
            if (z3 || z4 || z5) {
                LayoutModifierNodeKt.b(this);
                DrawModifierNodeKt.a(this);
            }
            if (z2) {
                DrawModifierNodeKt.a(this);
            }
        }
    }

    public final void u2(ContentDrawScope contentDrawScope) {
        draw(contentDrawScope);
    }

    public final TextSubstitutionValue x2() {
        return this.f11121s;
    }

    public final int z2(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    private TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i3, boolean z2, int i4, int i5, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize, Function1 function13) {
        this.f11104a = annotatedString;
        this.f11105b = textStyle;
        this.f11106c = resolver;
        this.f11107d = function1;
        this.f11108f = i3;
        this.f11109g = z2;
        this.f11110h = i4;
        this.f11111i = i5;
        this.f11112j = list;
        this.f11113k = function12;
        this.f11114l = selectionController;
        this.f11115m = colorProducer;
        this.f11116n = textAutoSize;
        this.f11117o = function13;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TextSubstitutionValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnnotatedString f11122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private AnnotatedString f11123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f11124c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MultiParagraphLayoutCache f11125d;

        public TextSubstitutionValue(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z2, MultiParagraphLayoutCache multiParagraphLayoutCache) {
            this.f11122a = annotatedString;
            this.f11123b = annotatedString2;
            this.f11124c = z2;
            this.f11125d = multiParagraphLayoutCache;
        }

        public final MultiParagraphLayoutCache a() {
            return this.f11125d;
        }

        public final AnnotatedString b() {
            return this.f11122a;
        }

        public final AnnotatedString c() {
            return this.f11123b;
        }

        public final boolean d() {
            return this.f11124c;
        }

        public final void e(MultiParagraphLayoutCache multiParagraphLayoutCache) {
            this.f11125d = multiParagraphLayoutCache;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextSubstitutionValue)) {
                return false;
            }
            TextSubstitutionValue textSubstitutionValue = (TextSubstitutionValue) obj;
            return Intrinsics.areEqual(this.f11122a, textSubstitutionValue.f11122a) && Intrinsics.areEqual(this.f11123b, textSubstitutionValue.f11123b) && this.f11124c == textSubstitutionValue.f11124c && Intrinsics.areEqual(this.f11125d, textSubstitutionValue.f11125d);
        }

        public final void f(boolean z2) {
            this.f11124c = z2;
        }

        public final void g(AnnotatedString annotatedString) {
            this.f11123b = annotatedString;
        }

        public int hashCode() {
            int iHashCode = ((((this.f11122a.hashCode() * 31) + this.f11123b.hashCode()) * 31) + Boolean.hashCode(this.f11124c)) * 31;
            MultiParagraphLayoutCache multiParagraphLayoutCache = this.f11125d;
            return iHashCode + (multiParagraphLayoutCache == null ? 0 : multiParagraphLayoutCache.hashCode());
        }

        public String toString() {
            return "TextSubstitutionValue(original=" + ((Object) this.f11122a) + ", substitution=" + ((Object) this.f11123b) + ", isShowingSubstitution=" + this.f11124c + ", layoutCache=" + this.f11125d + ')';
        }

        public /* synthetic */ TextSubstitutionValue(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z2, MultiParagraphLayoutCache multiParagraphLayoutCache, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(annotatedString, annotatedString2, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? null : multiParagraphLayoutCache);
        }
    }
}
