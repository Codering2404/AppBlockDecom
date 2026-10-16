package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.modifiers.TextStringSimpleNode;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
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
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.TextUnit;
import androidx.glance.session.ecY.lisODU;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TextStringSimpleNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextStyle f11140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FontFamily.Resolver f11141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11142d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ColorProducer f11146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map f11147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ParagraphLayoutCache f11148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Function1 f11149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextSubstitutionValue f11150m;

    public /* synthetic */ TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i3, boolean z2, int i4, int i5, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i3, z2, i4, i5, colorProducer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t2() {
        this.f11150m = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParagraphLayoutCache v2() {
        if (this.f11148k == null) {
            this.f11148k = new ParagraphLayoutCache(this.f11139a, this.f11140b, this.f11141c, this.f11142d, this.f11143f, this.f11144g, this.f11145h, null);
        }
        ParagraphLayoutCache paragraphLayoutCache = this.f11148k;
        Intrinsics.checkNotNull(paragraphLayoutCache);
        return paragraphLayoutCache;
    }

    private final ParagraphLayoutCache w2(IntrinsicMeasureScope intrinsicMeasureScope) {
        ParagraphLayoutCache paragraphLayoutCacheX2 = x2();
        paragraphLayoutCacheX2.m(intrinsicMeasureScope);
        return paragraphLayoutCacheX2;
    }

    private final ParagraphLayoutCache x2() {
        ParagraphLayoutCache paragraphLayoutCacheA;
        TextSubstitutionValue textSubstitutionValue = this.f11150m;
        if (textSubstitutionValue != null) {
            if (!textSubstitutionValue.c()) {
                textSubstitutionValue = null;
            }
            if (textSubstitutionValue != null && (paragraphLayoutCacheA = textSubstitutionValue.a()) != null) {
                return paragraphLayoutCacheA;
            }
        }
        return v2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y2() {
        SemanticsModifierNodeKt.b(this);
        LayoutModifierNodeKt.b(this);
        DrawModifierNodeKt.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z2(String str) {
        Unit unit;
        TextSubstitutionValue textSubstitutionValue = this.f11150m;
        if (textSubstitutionValue == null) {
            TextSubstitutionValue textSubstitutionValue2 = new TextSubstitutionValue(this.f11139a, str, false, null, 12, null);
            ParagraphLayoutCache paragraphLayoutCache = new ParagraphLayoutCache(str, this.f11140b, this.f11141c, this.f11142d, this.f11143f, this.f11144g, this.f11145h, null);
            paragraphLayoutCache.m(v2().a());
            textSubstitutionValue2.d(paragraphLayoutCache);
            this.f11150m = textSubstitutionValue2;
            return true;
        }
        if (Intrinsics.areEqual(str, textSubstitutionValue.b())) {
            return false;
        }
        textSubstitutionValue.f(str);
        ParagraphLayoutCache paragraphLayoutCacheA = textSubstitutionValue.a();
        if (paragraphLayoutCacheA != null) {
            paragraphLayoutCacheA.p(str, this.f11140b, this.f11141c, this.f11142d, this.f11143f, this.f11144g, this.f11145h);
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        return unit != null;
    }

    public final boolean A2(ColorProducer colorProducer, TextStyle textStyle) {
        boolean zAreEqual = Intrinsics.areEqual(colorProducer, this.f11146i);
        this.f11146i = colorProducer;
        return (zAreEqual && textStyle.H(this.f11140b)) ? false : true;
    }

    public final boolean B2(TextStyle textStyle, int i3, int i4, boolean z2, FontFamily.Resolver resolver, int i5) {
        boolean z3 = !this.f11140b.I(textStyle);
        this.f11140b = textStyle;
        if (this.f11145h != i3) {
            this.f11145h = i3;
            z3 = true;
        }
        if (this.f11144g != i4) {
            this.f11144g = i4;
            z3 = true;
        }
        if (this.f11143f != z2) {
            this.f11143f = z2;
            z3 = true;
        }
        if (!Intrinsics.areEqual(this.f11141c, resolver)) {
            this.f11141c = resolver;
            z3 = true;
        }
        if (TextOverflow.h(this.f11142d, i5)) {
            return z3;
        }
        this.f11142d = i5;
        return true;
    }

    public final boolean C2(String str) {
        if (Intrinsics.areEqual(this.f11139a, str)) {
            return false;
        }
        this.f11139a = str;
        t2();
        return true;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Function1<List<TextLayoutResult>, Boolean> function1 = this.f11149l;
        if (function1 == null) {
            function1 = new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(List list) {
                    ParagraphLayoutCache paragraphLayoutCacheV2 = this.f11155a.v2();
                    TextStyle textStyle = this.f11155a.f11140b;
                    ColorProducer colorProducer = this.f11155a.f11146i;
                    TextLayoutResult textLayoutResultO = paragraphLayoutCacheV2.o(textStyle.M((16609105 & 1) != 0 ? Color.f25715b.k() : colorProducer != null ? colorProducer.a() : Color.f25715b.k(), (16609105 & 2) != 0 ? TextUnit.f30006b.a() : 0L, (16609105 & 4) != 0 ? null : null, (16609105 & 8) != 0 ? null : null, (16609105 & 16) != 0 ? null : null, (16609105 & 32) != 0 ? null : null, (16609105 & 64) != 0 ? null : null, (16609105 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? TextUnit.f30006b.a() : 0L, (16609105 & Function.MAX_NARGS) != 0 ? null : null, (16609105 & 512) != 0 ? null : null, (16609105 & 1024) != 0 ? null : null, (16609105 & 2048) != 0 ? Color.f25715b.k() : 0L, (16609105 & 4096) != 0 ? null : null, (16609105 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : null, (16609105 & 16384) != 0 ? null : null, (16609105 & 32768) != 0 ? TextAlign.f29616b.g() : 0, (16609105 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? TextDirection.f29630b.f() : 0, (16609105 & 131072) != 0 ? TextUnit.f30006b.a() : 0L, (16609105 & 262144) != 0 ? null : null, (16609105 & 524288) != 0 ? null : null, (16609105 & 1048576) != 0 ? LineBreak.f29567b.b() : 0, (16609105 & 2097152) != 0 ? Hyphens.f29562b.c() : 0, (16609105 & 4194304) != 0 ? null : null, (16609105 & 8388608) != 0 ? null : null));
                    if (textLayoutResultO != null) {
                        list.add(textLayoutResultO);
                    } else {
                        textLayoutResultO = null;
                    }
                    return Boolean.valueOf(textLayoutResultO != null);
                }
            };
            this.f11149l = function1;
        }
        SemanticsPropertiesKt.y0(semanticsPropertyReceiver, new AnnotatedString(this.f11139a, null, 2, null));
        TextSubstitutionValue textSubstitutionValue = this.f11150m;
        if (textSubstitutionValue != null) {
            SemanticsPropertiesKt.v0(semanticsPropertyReceiver, textSubstitutionValue.c());
            SemanticsPropertiesKt.C0(semanticsPropertyReceiver, new AnnotatedString(textSubstitutionValue.b(), null, 2, null));
        }
        SemanticsPropertiesKt.E0(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(AnnotatedString annotatedString) {
                this.f11156a.z2(annotatedString.k());
                this.f11156a.y2();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.K0(semanticsPropertyReceiver, null, new Function1<Boolean, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$3
            {
                super(1);
            }

            public final Boolean c(boolean z2) {
                if (this.f11157a.f11150m == null) {
                    return Boolean.FALSE;
                }
                TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue2 = this.f11157a.f11150m;
                if (textSubstitutionValue2 != null) {
                    textSubstitutionValue2.e(z2);
                }
                this.f11157a.y2();
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Boolean) obj).booleanValue());
            }
        }, 1, null);
        SemanticsPropertiesKt.d(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                this.f11158a.t2();
                this.f11158a.y2();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.u(semanticsPropertyReceiver, null, function1, 1, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return w2(intrinsicMeasureScope).f(i3, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return w2(intrinsicMeasureScope).j(intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        ParagraphLayoutCache paragraphLayoutCacheW2 = w2(measureScope);
        boolean zH = paragraphLayoutCacheW2.h(j3, measureScope.getLayoutDirection());
        paragraphLayoutCacheW2.d();
        Paragraph paragraphE = paragraphLayoutCacheW2.e();
        Intrinsics.checkNotNull(paragraphE);
        long jC = paragraphLayoutCacheW2.c();
        if (zH) {
            LayoutModifierNodeKt.a(this);
            Map map = this.f11147j;
            if (map == null) {
                map = new HashMap(2);
                this.f11147j = map;
            }
            map.put(AlignmentLineKt.a(), Integer.valueOf(Math.round(paragraphE.l())));
            map.put(AlignmentLineKt.b(), Integer.valueOf(Math.round(paragraphE.y())));
        }
        int i3 = (int) (jC >> 32);
        int i4 = (int) (jC & 4294967295L);
        final Placeable placeableN0 = measurable.n0(Constraints.f29963b.b(i3, i3, i4, i4));
        Map map2 = this.f11147j;
        Intrinsics.checkNotNull(map2);
        return measureScope.c1(i3, i4, map2, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$measure$1
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
        return w2(intrinsicMeasureScope).f(i3, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return w2(intrinsicMeasureScope).k(intrinsicMeasureScope.getLayoutDirection());
    }

    public final void u2(boolean z2, boolean z3, boolean z4) {
        if (z3 || z4) {
            v2().p(this.f11139a, this.f11140b, this.f11141c, this.f11142d, this.f11143f, this.f11144g, this.f11145h);
        }
        if (isAttached()) {
            if (z3 || (z2 && this.f11149l != null)) {
                SemanticsModifierNodeKt.b(this);
            }
            if (z3 || z4) {
                LayoutModifierNodeKt.b(this);
                DrawModifierNodeKt.a(this);
            }
            if (z2) {
                DrawModifierNodeKt.a(this);
            }
        }
    }

    private TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i3, boolean z2, int i4, int i5, ColorProducer colorProducer) {
        this.f11139a = str;
        this.f11140b = textStyle;
        this.f11141c = resolver;
        this.f11142d = i3;
        this.f11143f = z2;
        this.f11144g = i4;
        this.f11145h = i5;
        this.f11146i = colorProducer;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long jK;
        if (isAttached()) {
            ParagraphLayoutCache paragraphLayoutCacheX2 = x2();
            Paragraph paragraphE = paragraphLayoutCacheX2.e();
            if (paragraphE != null) {
                Canvas canvasG = contentDrawScope.Q1().g();
                boolean zB = paragraphLayoutCacheX2.b();
                if (zB) {
                    float fC = (int) (paragraphLayoutCacheX2.c() >> 32);
                    float fC2 = (int) (paragraphLayoutCacheX2.c() & 4294967295L);
                    canvasG.t();
                    Canvas.o(canvasG, 0.0f, 0.0f, fC, fC2, 0, 16, null);
                }
                try {
                    TextDecoration textDecorationC = this.f11140b.C();
                    if (textDecorationC == null) {
                        textDecorationC = TextDecoration.f29625b.c();
                    }
                    TextDecoration textDecoration = textDecorationC;
                    Shadow shadowZ = this.f11140b.z();
                    if (shadowZ == null) {
                        shadowZ = Shadow.f25903d.a();
                    }
                    Shadow shadow = shadowZ;
                    DrawStyle drawStyleK = this.f11140b.k();
                    if (drawStyleK == null) {
                        drawStyleK = Fill.f26098a;
                    }
                    DrawStyle drawStyle = drawStyleK;
                    Brush brushI = this.f11140b.i();
                    if (brushI != null) {
                        Paragraph.E(paragraphE, canvasG, brushI, this.f11140b.f(), shadow, textDecoration, drawStyle, 0, 64, null);
                    } else {
                        ColorProducer colorProducer = this.f11146i;
                        if (colorProducer != null) {
                            jK = colorProducer.a();
                        } else {
                            jK = Color.f25715b.k();
                        }
                        if (jK == 16) {
                            if (this.f11140b.j() != 16) {
                                jK = this.f11140b.j();
                            } else {
                                jK = Color.f25715b.a();
                            }
                        }
                        Paragraph.v(paragraphE, canvasG, jK, shadow, textDecoration, drawStyle, 0, 32, null);
                    }
                    if (zB) {
                        canvasG.k();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (zB) {
                        canvasG.k();
                    }
                    throw th;
                }
            }
            InlineClassHelperKt.b("no paragraph (layoutCache=" + this.f11148k + lisODU.HgBLVojlkH + this.f11150m + ')');
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata
    public static final class TextSubstitutionValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f11152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f11153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ParagraphLayoutCache f11154d;

        public TextSubstitutionValue(String str, String str2, boolean z2, ParagraphLayoutCache paragraphLayoutCache) {
            this.f11151a = str;
            this.f11152b = str2;
            this.f11153c = z2;
            this.f11154d = paragraphLayoutCache;
        }

        public final ParagraphLayoutCache a() {
            return this.f11154d;
        }

        public final String b() {
            return this.f11152b;
        }

        public final boolean c() {
            return this.f11153c;
        }

        public final void d(ParagraphLayoutCache paragraphLayoutCache) {
            this.f11154d = paragraphLayoutCache;
        }

        public final void e(boolean z2) {
            this.f11153c = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextSubstitutionValue)) {
                return false;
            }
            TextSubstitutionValue textSubstitutionValue = (TextSubstitutionValue) obj;
            return Intrinsics.areEqual(this.f11151a, textSubstitutionValue.f11151a) && Intrinsics.areEqual(this.f11152b, textSubstitutionValue.f11152b) && this.f11153c == textSubstitutionValue.f11153c && Intrinsics.areEqual(this.f11154d, textSubstitutionValue.f11154d);
        }

        public final void f(String str) {
            this.f11152b = str;
        }

        public int hashCode() {
            int iHashCode = ((((this.f11151a.hashCode() * 31) + this.f11152b.hashCode()) * 31) + Boolean.hashCode(this.f11153c)) * 31;
            ParagraphLayoutCache paragraphLayoutCache = this.f11154d;
            return iHashCode + (paragraphLayoutCache == null ? 0 : paragraphLayoutCache.hashCode());
        }

        public String toString() {
            return "TextSubstitution(layoutCache=" + this.f11154d + ", isShowingSubstitution=" + this.f11153c + ')';
        }

        public /* synthetic */ TextSubstitutionValue(String str, String str2, boolean z2, ParagraphLayoutCache paragraphLayoutCache, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? null : paragraphLayoutCache);
        }
    }
}
