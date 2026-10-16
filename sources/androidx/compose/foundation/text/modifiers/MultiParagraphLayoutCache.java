package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class MultiParagraphLayoutCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnnotatedString f11012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FontFamily.Resolver f11013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f11018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextAutoSize f11019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MinLinesConstrainer f11020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f11021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Density f11022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextStyle f11023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MultiParagraphIntrinsics f11024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LayoutDirection f11025n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextLayoutResult f11026o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f11027p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f11028q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextAutoSizeLayoutScopeImpl f11029r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class TextAutoSizeLayoutScopeImpl implements TextAutoSizeLayoutScope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextLayoutResult f11030a;

        public TextAutoSizeLayoutScopeImpl() {
        }

        @Override // androidx.compose.ui.unit.Density
        public float J0(long j3) {
            if (!TextUnit.j(j3)) {
                return M1(q(j3));
            }
            if (TextUnit.j(MultiParagraphLayoutCache.this.f11023l.n())) {
                throw new IllegalStateException("InternalAutoSize -> toPx(): Cannot convert Em to Px when style.fontSize is Em\nDeclare the composable's style.fontSize with Sp units instead.");
            }
            if (TextUnit.e(MultiParagraphLayoutCache.this.f11023l.n(), TextUnit.f30006b.a())) {
                throw new IllegalStateException("InternalAutoSize -> toPx(): Cannot convert Em to Px when style.fontSize is not set. Please specify a font size.");
            }
            return J0(MultiParagraphLayoutCache.this.f11023l.n()) * TextUnit.h(j3);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float K1() {
            Density densityH = MultiParagraphLayoutCache.this.h();
            Intrinsics.checkNotNull(densityH);
            return densityH.K1();
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            Density densityH = MultiParagraphLayoutCache.this.h();
            Intrinsics.checkNotNull(densityH);
            return densityH.getDensity();
        }

        public final TextLayoutResult m() {
            return this.f11030a;
        }

        @Override // androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope
        public TextLayoutResult t0(long j3, AnnotatedString annotatedString, long j4) {
            long jY;
            TextStyle textStyle = MultiParagraphLayoutCache.this.f11023l;
            long jB = TextUnit.j(j4) ? MultiParagraphLayoutCacheKt.b(MultiParagraphLayoutCache.this.f11023l.n(), j4) : j4;
            if (!TextUnit.e(jB, MultiParagraphLayoutCache.this.f11023l.n())) {
                MultiParagraphLayoutCache multiParagraphLayoutCache = MultiParagraphLayoutCache.this;
                multiParagraphLayoutCache.v(TextStyle.e(multiParagraphLayoutCache.f11023l, 0L, jB, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null));
            }
            if (MultiParagraphLayoutCache.this.f11017f > 1) {
                MultiParagraphLayoutCache multiParagraphLayoutCache2 = MultiParagraphLayoutCache.this;
                LayoutDirection layoutDirection = multiParagraphLayoutCache2.f11025n;
                Intrinsics.checkNotNull(layoutDirection);
                jY = multiParagraphLayoutCache2.y(j3, layoutDirection);
            } else {
                jY = j3;
            }
            MultiParagraphLayoutCache multiParagraphLayoutCache3 = MultiParagraphLayoutCache.this;
            LayoutDirection layoutDirection2 = multiParagraphLayoutCache3.f11025n;
            Intrinsics.checkNotNull(layoutDirection2);
            MultiParagraph multiParagraphM = multiParagraphLayoutCache3.m(jY, layoutDirection2);
            MultiParagraphLayoutCache multiParagraphLayoutCache4 = MultiParagraphLayoutCache.this;
            LayoutDirection layoutDirection3 = multiParagraphLayoutCache4.f11025n;
            Intrinsics.checkNotNull(layoutDirection3);
            TextLayoutResult textLayoutResultW = multiParagraphLayoutCache4.w(layoutDirection3, jY, multiParagraphM);
            this.f11030a = textLayoutResultW;
            MultiParagraphLayoutCache.this.v(textStyle);
            return textLayoutResultW;
        }
    }

    public /* synthetic */ MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, int i3, boolean z2, int i4, int i5, List list, TextAutoSize textAutoSize, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, i3, z2, i4, i5, list, textAutoSize);
    }

    private final TextAutoSizeLayoutScopeImpl i() {
        if (this.f11029r == null) {
            this.f11029r = new TextAutoSizeLayoutScopeImpl();
        }
        TextAutoSizeLayoutScopeImpl textAutoSizeLayoutScopeImpl = this.f11029r;
        Intrinsics.checkNotNull(textAutoSizeLayoutScopeImpl);
        return textAutoSizeLayoutScopeImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MultiParagraph m(long j3, LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics multiParagraphIntrinsicsU = u(layoutDirection);
        return new MultiParagraph(multiParagraphIntrinsicsU, LayoutUtilsKt.a(j3, this.f11015d, this.f11014c, multiParagraphIntrinsicsU.c()), LayoutUtilsKt.b(this.f11015d, this.f11014c, this.f11016e), this.f11014c, null);
    }

    private final void o() {
        this.f11024m = null;
        this.f11026o = null;
        this.f11028q = -1;
        this.f11027p = -1;
        this.f11029r = null;
    }

    private final void p() {
        this.f11024m = null;
        this.f11026o = null;
        this.f11028q = -1;
        this.f11027p = -1;
    }

    private final boolean s(TextLayoutResult textLayoutResult, long j3, LayoutDirection layoutDirection) {
        if (textLayoutResult == null || textLayoutResult.w().j().a() || layoutDirection != textLayoutResult.l().d()) {
            return true;
        }
        if (Constraints.f(j3, textLayoutResult.l().a())) {
            return false;
        }
        return Constraints.l(j3) != Constraints.l(textLayoutResult.l().a()) || Constraints.n(j3) != Constraints.n(textLayoutResult.l().a()) || ((float) Constraints.k(j3)) < textLayoutResult.w().h() || textLayoutResult.w().f();
    }

    private final MultiParagraphIntrinsics u(LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.f11024m;
        if (multiParagraphIntrinsics == null || layoutDirection != this.f11025n || multiParagraphIntrinsics.a()) {
            this.f11025n = layoutDirection;
            AnnotatedString annotatedString = this.f11012a;
            TextStyle textStyleD = TextStyleKt.d(this.f11023l, layoutDirection);
            Density density = this.f11022k;
            Intrinsics.checkNotNull(density);
            FontFamily.Resolver resolver = this.f11013b;
            List listEmptyList = this.f11018g;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, textStyleD, listEmptyList, density, resolver);
        }
        this.f11024m = multiParagraphIntrinsics;
        return multiParagraphIntrinsics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(TextStyle textStyle) {
        boolean zI = textStyle.I(this.f11023l);
        this.f11023l = textStyle;
        if (zI) {
            return;
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextLayoutResult w(LayoutDirection layoutDirection, long j3, MultiParagraph multiParagraph) {
        float fMin = Math.min(multiParagraph.j().c(), multiParagraph.D());
        AnnotatedString annotatedString = this.f11012a;
        TextStyle textStyle = this.f11023l;
        List listEmptyList = this.f11018g;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        int i3 = this.f11016e;
        boolean z2 = this.f11015d;
        int i4 = this.f11014c;
        Density density = this.f11022k;
        Intrinsics.checkNotNull(density);
        return new TextLayoutResult(new TextLayoutInput(annotatedString, textStyle, listEmptyList, i3, z2, i4, density, layoutDirection, this.f11013b, j3, (DefaultConstructorMarker) null), multiParagraph, ConstraintsKt.d(j3, IntSize.c((((long) TextDelegateKt.a(fMin)) << 32) | (((long) TextDelegateKt.a(multiParagraph.h())) & 4294967295L))), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long y(long j3, LayoutDirection layoutDirection) {
        MinLinesConstrainer.Companion companion = MinLinesConstrainer.f11000h;
        MinLinesConstrainer minLinesConstrainer = this.f11020i;
        TextStyle textStyle = this.f11023l;
        Density density = this.f11022k;
        Intrinsics.checkNotNull(density);
        MinLinesConstrainer minLinesConstrainerA = companion.a(minLinesConstrainer, layoutDirection, textStyle, density, this.f11013b);
        this.f11020i = minLinesConstrainerA;
        return minLinesConstrainerA.c(j3, this.f11017f);
    }

    public final Density h() {
        return this.f11022k;
    }

    public final TextLayoutResult j() {
        return this.f11026o;
    }

    public final TextLayoutResult k() {
        TextLayoutResult textLayoutResult = this.f11026o;
        if (textLayoutResult != null) {
            return textLayoutResult;
        }
        throw new IllegalStateException("You must call layoutWithConstraints first");
    }

    public final int l(int i3, LayoutDirection layoutDirection) {
        int i4 = this.f11027p;
        int i5 = this.f11028q;
        if (i3 == i4 && i4 != -1) {
            return i5;
        }
        long jA = ConstraintsKt.a(0, i3, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (this.f11017f > 1) {
            jA = y(jA, layoutDirection);
        }
        int iF = RangesKt.f(TextDelegateKt.a(m(jA, layoutDirection).h()), Constraints.m(jA));
        this.f11027p = i3;
        this.f11028q = iF;
        return iF;
    }

    public final boolean n(long j3, LayoutDirection layoutDirection) {
        long jY = this.f11017f > 1 ? y(j3, layoutDirection) : j3;
        if (!s(this.f11026o, jY, layoutDirection)) {
            TextLayoutResult textLayoutResult = this.f11026o;
            Intrinsics.checkNotNull(textLayoutResult);
            if (Constraints.f(jY, textLayoutResult.l().a())) {
                return false;
            }
            TextLayoutResult textLayoutResult2 = this.f11026o;
            Intrinsics.checkNotNull(textLayoutResult2);
            this.f11026o = w(layoutDirection, jY, textLayoutResult2.w());
            return true;
        }
        if (this.f11019h != null) {
            this.f11025n = layoutDirection;
            long jN = this.f11023l.n();
            TextAutoSize textAutoSize = this.f11019h;
            Intrinsics.checkNotNull(textAutoSize);
            long jA = textAutoSize.a(i(), j3, this.f11012a);
            if (TextUnit.j(jA)) {
                jA = MultiParagraphLayoutCacheKt.b(jN, jA);
            }
            long j4 = jA;
            TextLayoutResult textLayoutResultM = i().m();
            if (textLayoutResultM != null && TextUnit.e(j4, textLayoutResultM.l().i().n()) && TextOverflow.h(textLayoutResultM.l().f(), this.f11014c)) {
                this.f11026o = textLayoutResultM;
                return true;
            }
            v(TextStyle.e(this.f11023l, 0L, j4, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null));
        }
        this.f11026o = w(layoutDirection, jY, m(jY, layoutDirection));
        return true;
    }

    public final int q(LayoutDirection layoutDirection) {
        return TextDelegateKt.a(u(layoutDirection).c());
    }

    public final int r(LayoutDirection layoutDirection) {
        return TextDelegateKt.a(u(layoutDirection).e());
    }

    public final void t(Density density) {
        Density density2 = this.f11022k;
        long jD = density != null ? InlineDensity.d(density) : InlineDensity.f10997b.a();
        if (density2 == null) {
            this.f11022k = density;
            this.f11021j = jD;
        } else if (density == null || !InlineDensity.f(this.f11021j, jD)) {
            this.f11022k = density;
            this.f11021j = jD;
            o();
        }
    }

    public final void x(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, int i3, boolean z2, int i4, int i5, List list, TextAutoSize textAutoSize) {
        this.f11012a = annotatedString;
        v(textStyle);
        this.f11013b = resolver;
        this.f11014c = i3;
        this.f11015d = z2;
        this.f11016e = i4;
        this.f11017f = i5;
        this.f11018g = list;
        this.f11019h = textAutoSize;
        o();
    }

    private MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, int i3, boolean z2, int i4, int i5, List list, TextAutoSize textAutoSize) {
        this.f11012a = annotatedString;
        this.f11013b = resolver;
        this.f11014c = i3;
        this.f11015d = z2;
        this.f11016e = i4;
        this.f11017f = i5;
        this.f11018g = list;
        this.f11019h = textAutoSize;
        this.f11021j = InlineDensity.f10997b.a();
        this.f11023l = textStyle;
        this.f11027p = -1;
        this.f11028q = -1;
    }
}
