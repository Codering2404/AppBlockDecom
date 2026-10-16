package androidx.compose.foundation.text;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

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
public final class TextLinkScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnnotatedString f10030a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnnotatedString f10032c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f10031b = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SnapshotStateList f10033d = SnapshotStateKt.f();

    public TextLinkScope(AnnotatedString annotatedString) {
        this.f10030a = annotatedString;
        this.f10032c = annotatedString.a(new Function1<AnnotatedString.Range<? extends AnnotatedString.Annotation>, List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>>>() { // from class: androidx.compose.foundation.text.TextLinkScope.1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final List invoke(AnnotatedString.Range range) {
                SpanStyle spanStyle;
                if (range.g() instanceof LinkAnnotation) {
                    Object objG = range.g();
                    Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation");
                    if (!TextLinkScopeKt.b(((LinkAnnotation) objG).b())) {
                        Object objG2 = range.g();
                        Intrinsics.checkNotNull(objG2, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation");
                        TextLinkStyles textLinkStylesB = ((LinkAnnotation) objG2).b();
                        if (textLinkStylesB == null || (spanStyle = textLinkStylesB.d()) == null) {
                            spanStyle = new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65535, (DefaultConstructorMarker) null);
                        }
                        return CollectionsKt.arrayListOf(range, new AnnotatedString.Range(spanStyle, range.h(), range.f()));
                    }
                }
                return CollectionsKt.arrayListOf(range);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(final Object[] objArr, final Function1 function1, Composer composer, final int i3) {
        Composer composerK = composer.k(-2083052099);
        int i4 = (i3 & 48) == 0 ? (composerK.I(function1) ? 32 : 16) | i3 : i3;
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        composerK.K(-416604407, Integer.valueOf(objArr.length));
        for (Object obj : objArr) {
            i4 |= composerK.I(obj) ? 4 : 0;
        }
        composerK.X();
        if ((i4 & 14) == 0) {
            i4 |= 2;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2083052099, i4, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:315)");
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.a(function1);
            spreadBuilder.b(objArr);
            Object[] objArrD = spreadBuilder.d(new Object[spreadBuilder.c()]);
            boolean zI = composerK.I(this) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        this.f10046a.f10033d.add(function1);
                        final TextLinkScope textLinkScope = this.f10046a;
                        final Function1 function12 = function1;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                textLinkScope.f10033d.remove(function12);
                            }
                        };
                    }
                };
                composerK.w(objG);
            }
            EffectsKt.d(objArrD, (Function1) objG, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    TextLinkScope textLinkScope = this.f10050a;
                    Object[] objArr2 = objArr;
                    textLinkScope.c(Arrays.copyOf(objArr2, objArr2.length), function1, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private final AnnotatedString.Range j(AnnotatedString.Range range, TextLayoutResult textLayoutResult) {
        int iP = TextLayoutResult.p(textLayoutResult, textLayoutResult.n() - 1, false, 2, null);
        if (range.h() < iP) {
            return AnnotatedString.Range.e(range, null, 0, Math.min(range.f(), iP), null, 11, null);
        }
        return null;
    }

    private final Modifier k(Modifier modifier, final AnnotatedString.Range range) {
        return GraphicsLayerModifierKt.a(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$clipLink$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GraphicsLayerScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                Shape shapeS = this.f10054a.s(range);
                if (shapeS != null) {
                    graphicsLayerScope.I1(shapeS);
                    graphicsLayerScope.B(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(LinkAnnotation linkAnnotation, UriHandler uriHandler) {
        LinkInteractionListener linkInteractionListenerA;
        Unit unit;
        if (!(linkAnnotation instanceof LinkAnnotation.Url)) {
            if (!(linkAnnotation instanceof LinkAnnotation.Clickable) || (linkInteractionListenerA = linkAnnotation.a()) == null) {
                return;
            }
            linkInteractionListenerA.a(linkAnnotation);
            return;
        }
        LinkInteractionListener linkInteractionListenerA2 = linkAnnotation.a();
        if (linkInteractionListenerA2 != null) {
            linkInteractionListenerA2.a(linkAnnotation);
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            try {
                uriHandler.openUri(((LinkAnnotation.Url) linkAnnotation).c());
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpanStyle p(SpanStyle spanStyle, SpanStyle spanStyle2) {
        SpanStyle spanStyleY;
        return (spanStyle == null || (spanStyleY = spanStyle.y(spanStyle2)) == null) ? spanStyle2 : spanStyleY;
    }

    private final Path q(AnnotatedString.Range range) {
        Path pathZ = null;
        if (!((Boolean) l().invoke()).booleanValue()) {
            return null;
        }
        TextLayoutResult textLayoutResultN = n();
        if (textLayoutResultN != null) {
            AnnotatedString.Range rangeJ = j(range, textLayoutResultN);
            if (rangeJ == null) {
                return null;
            }
            pathZ = textLayoutResultN.z(rangeJ.h(), rangeJ.f());
            Rect rectD = textLayoutResultN.d(rangeJ.h());
            pathZ.p(Offset.e(Offset.e((((long) Float.floatToRawIntBits(textLayoutResultN.q(rangeJ.h()) == textLayoutResultN.q(rangeJ.f() + (-1)) ? Math.min(textLayoutResultN.d(rangeJ.f() - 1).o(), rectD.o()) : 0.0f)) << 32) | (((long) Float.floatToRawIntBits(rectD.r())) & 4294967295L)) ^ (-9223372034707292160L)));
        }
        return pathZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Shape s(AnnotatedString.Range range) {
        final Path pathQ = q(range);
        if (pathQ != null) {
            return new Shape() { // from class: androidx.compose.foundation.text.TextLinkScope$shapeForRange$1$1
                @Override // androidx.compose.ui.graphics.Shape
                /* JADX INFO: renamed from: createOutline-Pq9zytI */
                public Outline mo29createOutlinePq9zytI(long j3, LayoutDirection layoutDirection, Density density) {
                    return new Outline.Generic(pathQ);
                }
            };
        }
        return null;
    }

    private final Modifier t(Modifier modifier, final AnnotatedString.Range range) {
        return modifier.then(new TextRangeLayoutModifier(new TextRangeScopeMeasurePolicy() { // from class: androidx.compose.foundation.text.c
            @Override // androidx.compose.foundation.text.TextRangeScopeMeasurePolicy
            public final TextRangeLayoutMeasureResult a(TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
                return TextLinkScope.u(this.f10094a, range, textRangeLayoutMeasureScope);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextRangeLayoutMeasureResult u(TextLinkScope textLinkScope, AnnotatedString.Range range, TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
        TextLayoutResult textLayoutResultN = textLinkScope.n();
        if (textLayoutResultN == null) {
            return textRangeLayoutMeasureScope.a(0, 0, new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$layoutResult$1
                public final long c() {
                    return IntOffset.f29988b.b();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    return IntOffset.c(c());
                }
            });
        }
        AnnotatedString.Range rangeJ = textLinkScope.j(range, textLayoutResultN);
        if (rangeJ == null) {
            return textRangeLayoutMeasureScope.a(0, 0, new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$updatedRange$1
                public final long c() {
                    return IntOffset.f29988b.b();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    return IntOffset.c(c());
                }
            });
        }
        final IntRect intRectB = IntRectKt.b(textLayoutResultN.z(rangeJ.h(), rangeJ.f()).getBounds());
        return textRangeLayoutMeasureScope.a(intRectB.l(), intRectB.f(), new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$1
            {
                super(0);
            }

            public final long c() {
                return intRectB.k();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return IntOffset.c(c());
            }
        });
    }

    public final void b(Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1154651354);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(this) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        int i5 = 1;
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1154651354, i4, -1, "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:214)");
            }
            final UriHandler uriHandler = (UriHandler) composerK.q(CompositionLocalsKt.s());
            AnnotatedString annotatedString = this.f10032c;
            List listE = annotatedString.e(0, annotatedString.length());
            int size = listE.size();
            int i6 = 0;
            while (i6 < size) {
                final AnnotatedString.Range range = (AnnotatedString.Range) listE.get(i6);
                if (range.h() != range.f()) {
                    composerK.a0(1386075176);
                    Object objG = composerK.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG == companion.a()) {
                        objG = InteractionSourceKt.a();
                        composerK.w(objG);
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG;
                    Modifier modifierB = PointerIconKt.b(HoverableKt.b(t(SemanticsModifierKt.f(k(Modifier.b8, range), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            semanticsPropertyReceiver.a(SemanticsProperties.f28517a.w(), Unit.f139807a);
                        }
                    }, i5, null), range), mutableInteractionSource, false, 2, null), PointerIcon.f26847a.b(), false, 2, null);
                    boolean zI = composerK.I(this) | composerK.Z(range) | composerK.I(uriHandler);
                    Object objG2 = composerK.G();
                    if (zI || objG2 == companion.a()) {
                        objG2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m74invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m74invoke() {
                                this.f10036a.o((LinkAnnotation) range.g(), uriHandler);
                            }
                        };
                        composerK.w(objG2);
                    }
                    BoxKt.a(ClickableKt.h(modifierB, mutableInteractionSource, null, false, null, null, null, null, null, false, (Function0) objG2, 508, null), composerK, 0);
                    if (TextLinkScopeKt.b(((LinkAnnotation) range.g()).b())) {
                        composerK.a0(1388926990);
                        composerK.U();
                    } else {
                        composerK.a0(1386898319);
                        Object objG3 = composerK.G();
                        if (objG3 == companion.a()) {
                            objG3 = new LinkStateInteractionSourceObserver(mutableInteractionSource);
                            composerK.w(objG3);
                        }
                        final LinkStateInteractionSourceObserver linkStateInteractionSourceObserver = (LinkStateInteractionSourceObserver) objG3;
                        Unit unit = Unit.f139807a;
                        Object objG4 = composerK.G();
                        if (objG4 == companion.a()) {
                            objG4 = new TextLinkScope$LinksComposables$1$3$1(linkStateInteractionSourceObserver, null);
                            composerK.w(objG4);
                        }
                        EffectsKt.g(unit, (Function2) objG4, composerK, 6);
                        Boolean boolValueOf = Boolean.valueOf(linkStateInteractionSourceObserver.g());
                        Boolean boolValueOf2 = Boolean.valueOf(linkStateInteractionSourceObserver.f());
                        Boolean boolValueOf3 = Boolean.valueOf(linkStateInteractionSourceObserver.h());
                        TextLinkStyles textLinkStylesB = ((LinkAnnotation) range.g()).b();
                        SpanStyle spanStyleD = textLinkStylesB != null ? textLinkStylesB.d() : null;
                        TextLinkStyles textLinkStylesB2 = ((LinkAnnotation) range.g()).b();
                        SpanStyle spanStyleA = textLinkStylesB2 != null ? textLinkStylesB2.a() : null;
                        TextLinkStyles textLinkStylesB3 = ((LinkAnnotation) range.g()).b();
                        SpanStyle spanStyleB = textLinkStylesB3 != null ? textLinkStylesB3.b() : null;
                        TextLinkStyles textLinkStylesB4 = ((LinkAnnotation) range.g()).b();
                        Object[] objArr = {boolValueOf, boolValueOf2, boolValueOf3, spanStyleD, spanStyleA, spanStyleB, textLinkStylesB4 != null ? textLinkStylesB4.c() : null};
                        boolean zI2 = composerK.I(this) | composerK.Z(range);
                        Object objG5 = composerK.G();
                        if (zI2 || objG5 == companion.a()) {
                            objG5 = new Function1<TextAnnotatorScope, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final void c(TextAnnotatorScope textAnnotatorScope) {
                                    TextLinkStyles textLinkStylesB5;
                                    TextLinkStyles textLinkStylesB6;
                                    TextLinkStyles textLinkStylesB7;
                                    TextLinkScope textLinkScope = this.f10041a;
                                    TextLinkStyles textLinkStylesB8 = ((LinkAnnotation) range.g()).b();
                                    SpanStyle spanStyleC = null;
                                    SpanStyle spanStyleP = textLinkScope.p(textLinkScope.p(textLinkStylesB8 != null ? textLinkStylesB8.d() : null, (!linkStateInteractionSourceObserver.f() || (textLinkStylesB7 = ((LinkAnnotation) range.g()).b()) == null) ? null : textLinkStylesB7.a()), (!linkStateInteractionSourceObserver.g() || (textLinkStylesB6 = ((LinkAnnotation) range.g()).b()) == null) ? null : textLinkStylesB6.b());
                                    if (linkStateInteractionSourceObserver.h() && (textLinkStylesB5 = ((LinkAnnotation) range.g()).b()) != null) {
                                        spanStyleC = textLinkStylesB5.c();
                                    }
                                    textAnnotatorScope.b(range, textLinkScope.p(spanStyleP, spanStyleC));
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    c((TextAnnotatorScope) obj);
                                    return Unit.f139807a;
                                }
                            };
                            composerK.w(objG5);
                        }
                        c(objArr, (Function1) objG5, composerK, (i4 << 6) & 896);
                        composerK.U();
                    }
                    composerK.U();
                } else {
                    composerK.a0(1388940878);
                    composerK.U();
                }
                i6++;
                i5 = 1;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    this.f10044a.b(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public final AnnotatedString i() {
        AnnotatedString annotatedStringA;
        if (this.f10033d.isEmpty()) {
            annotatedStringA = this.f10032c;
        } else {
            TextAnnotatorScope textAnnotatorScope = new TextAnnotatorScope(this.f10032c);
            SnapshotStateList snapshotStateList = this.f10033d;
            int size = snapshotStateList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((Function1) snapshotStateList.get(i3)).invoke(textAnnotatorScope);
            }
            annotatedStringA = textAnnotatorScope.a();
        }
        this.f10032c = annotatedStringA;
        return annotatedStringA;
    }

    public final Function0 l() {
        return new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextLinkScope$shouldMeasureLinks$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                TextLayoutInput textLayoutInputL;
                AnnotatedString annotatedStringM = this.f10057a.m();
                TextLayoutResult textLayoutResultN = this.f10057a.n();
                return Boolean.valueOf(Intrinsics.areEqual(annotatedStringM, (textLayoutResultN == null || (textLayoutInputL = textLayoutResultN.l()) == null) ? null : textLayoutInputL.j()));
            }
        };
    }

    public final AnnotatedString m() {
        return this.f10032c;
    }

    public final TextLayoutResult n() {
        return (TextLayoutResult) this.f10031b.getValue();
    }

    public final void r(TextLayoutResult textLayoutResult) {
        this.f10031b.setValue(textLayoutResult);
    }
}
