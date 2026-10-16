package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.ParagraphKt;
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
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ParagraphLayoutCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextStyle f11034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FontFamily.Resolver f11035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f11040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Density f11041i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Paragraph f11042j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11043k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f11044l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MinLinesConstrainer f11045m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ParagraphIntrinsics f11046n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LayoutDirection f11047o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f11048p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f11049q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f11050r;

    public /* synthetic */ ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i3, boolean z2, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i3, z2, i4, i5);
    }

    private final void i() {
        this.f11042j = null;
        this.f11046n = null;
        this.f11047o = null;
        this.f11049q = -1;
        this.f11050r = -1;
        this.f11048p = Constraints.f29963b.c(0, 0);
        long j3 = 0;
        this.f11044l = IntSize.c((j3 & 4294967295L) | (j3 << 32));
        this.f11043k = false;
    }

    private final boolean l(long j3, LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics;
        Paragraph paragraph = this.f11042j;
        if (paragraph == null || (paragraphIntrinsics = this.f11046n) == null || paragraphIntrinsics.a() || layoutDirection != this.f11047o) {
            return true;
        }
        if (Constraints.f(j3, this.f11048p)) {
            return false;
        }
        return Constraints.l(j3) != Constraints.l(this.f11048p) || Constraints.n(j3) != Constraints.n(this.f11048p) || ((float) Constraints.k(j3)) < paragraph.getHeight() || paragraph.r();
    }

    private final ParagraphIntrinsics n(LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsicsA = this.f11046n;
        if (paragraphIntrinsicsA == null || layoutDirection != this.f11047o || paragraphIntrinsicsA.a()) {
            this.f11047o = layoutDirection;
            String str = this.f11033a;
            TextStyle textStyleD = TextStyleKt.d(this.f11034b, layoutDirection);
            List listEmptyList = CollectionsKt.emptyList();
            Density density = this.f11041i;
            Intrinsics.checkNotNull(density);
            paragraphIntrinsicsA = ParagraphIntrinsicsKt.a(str, textStyleD, listEmptyList, density, this.f11035c, CollectionsKt.emptyList());
        }
        this.f11046n = paragraphIntrinsicsA;
        return paragraphIntrinsicsA;
    }

    private final long q(long j3, LayoutDirection layoutDirection, TextStyle textStyle) {
        MinLinesConstrainer.Companion companion = MinLinesConstrainer.f11000h;
        MinLinesConstrainer minLinesConstrainer = this.f11045m;
        Density density = this.f11041i;
        Intrinsics.checkNotNull(density);
        MinLinesConstrainer minLinesConstrainerA = companion.a(minLinesConstrainer, layoutDirection, textStyle, density, this.f11035c);
        this.f11045m = minLinesConstrainerA;
        return minLinesConstrainerA.c(j3, this.f11039g);
    }

    static /* synthetic */ long r(ParagraphLayoutCache paragraphLayoutCache, long j3, LayoutDirection layoutDirection, TextStyle textStyle, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            textStyle = paragraphLayoutCache.f11034b;
        }
        return paragraphLayoutCache.q(j3, layoutDirection, textStyle);
    }

    public final Density a() {
        return this.f11041i;
    }

    public final boolean b() {
        return this.f11043k;
    }

    public final long c() {
        return this.f11044l;
    }

    public final Unit d() {
        ParagraphIntrinsics paragraphIntrinsics = this.f11046n;
        if (paragraphIntrinsics != null) {
            paragraphIntrinsics.a();
        }
        return Unit.f139807a;
    }

    public final Paragraph e() {
        return this.f11042j;
    }

    public final int f(int i3, LayoutDirection layoutDirection) {
        ParagraphLayoutCache paragraphLayoutCache;
        LayoutDirection layoutDirection2;
        int i4 = this.f11049q;
        int i5 = this.f11050r;
        if (i3 == i4 && i4 != -1) {
            return i5;
        }
        long jA = ConstraintsKt.a(0, i3, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (this.f11039g > 1) {
            paragraphLayoutCache = this;
            layoutDirection2 = layoutDirection;
            jA = r(paragraphLayoutCache, jA, layoutDirection2, null, 4, null);
        } else {
            paragraphLayoutCache = this;
            layoutDirection2 = layoutDirection;
        }
        int iF = RangesKt.f(TextDelegateKt.a(g(jA, layoutDirection2).getHeight()), Constraints.m(jA));
        paragraphLayoutCache.f11049q = i3;
        paragraphLayoutCache.f11050r = iF;
        return iF;
    }

    public final Paragraph g(long j3, LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsicsN = n(layoutDirection);
        return ParagraphKt.c(paragraphIntrinsicsN, LayoutUtilsKt.a(j3, this.f11037e, this.f11036d, paragraphIntrinsicsN.c()), LayoutUtilsKt.b(this.f11037e, this.f11036d, this.f11038f), this.f11036d);
    }

    public final boolean h(long j3, LayoutDirection layoutDirection) {
        ParagraphLayoutCache paragraphLayoutCache;
        LayoutDirection layoutDirection2;
        boolean z2 = true;
        if (this.f11039g > 1) {
            paragraphLayoutCache = this;
            layoutDirection2 = layoutDirection;
            j3 = r(paragraphLayoutCache, j3, layoutDirection2, null, 4, null);
        } else {
            paragraphLayoutCache = this;
            layoutDirection2 = layoutDirection;
        }
        boolean z3 = false;
        if (l(j3, layoutDirection2)) {
            Paragraph paragraphG = g(j3, layoutDirection2);
            paragraphLayoutCache.f11048p = j3;
            paragraphLayoutCache.f11044l = ConstraintsKt.d(j3, IntSize.c((((long) TextDelegateKt.a(paragraphG.getWidth())) << 32) | (((long) TextDelegateKt.a(paragraphG.getHeight())) & 4294967295L)));
            if (!TextOverflow.h(paragraphLayoutCache.f11036d, TextOverflow.f29661b.e()) && (((int) (r13 >> 32)) < paragraphG.getWidth() || ((int) (r13 & 4294967295L)) < paragraphG.getHeight())) {
                z3 = true;
            }
            paragraphLayoutCache.f11043k = z3;
            paragraphLayoutCache.f11042j = paragraphG;
            return true;
        }
        if (!Constraints.f(j3, paragraphLayoutCache.f11048p)) {
            Paragraph paragraph = paragraphLayoutCache.f11042j;
            Intrinsics.checkNotNull(paragraph);
            paragraphLayoutCache.f11044l = ConstraintsKt.d(j3, IntSize.c((((long) TextDelegateKt.a(Math.min(paragraph.c(), paragraph.getWidth()))) << 32) | (((long) TextDelegateKt.a(paragraph.getHeight())) & 4294967295L)));
            if (TextOverflow.h(paragraphLayoutCache.f11036d, TextOverflow.f29661b.e()) || (((int) (r7 >> 32)) >= paragraph.getWidth() && ((int) (4294967295L & r7)) >= paragraph.getHeight())) {
                z2 = false;
            }
            paragraphLayoutCache.f11043k = z2;
            paragraphLayoutCache.f11048p = j3;
        }
        return false;
    }

    public final int j(LayoutDirection layoutDirection) {
        return TextDelegateKt.a(n(layoutDirection).c());
    }

    public final int k(LayoutDirection layoutDirection) {
        return TextDelegateKt.a(n(layoutDirection).e());
    }

    public final void m(Density density) {
        Density density2 = this.f11041i;
        long jD = density != null ? InlineDensity.d(density) : InlineDensity.f10997b.a();
        if (density2 == null) {
            this.f11041i = density;
            this.f11040h = jD;
        } else if (density == null || !InlineDensity.f(this.f11040h, jD)) {
            this.f11041i = density;
            this.f11040h = jD;
            i();
        }
    }

    public final TextLayoutResult o(TextStyle textStyle) {
        Density density;
        LayoutDirection layoutDirection = this.f11047o;
        if (layoutDirection == null || (density = this.f11041i) == null) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(this.f11033a, null, 2, null);
        if (this.f11042j == null || this.f11046n == null) {
            return null;
        }
        long jB = Constraints.b(this.f11048p & (-8589934589L));
        return new TextLayoutResult(new TextLayoutInput(annotatedString, textStyle, CollectionsKt.emptyList(), this.f11038f, this.f11037e, this.f11036d, density, layoutDirection, this.f11035c, jB, (DefaultConstructorMarker) null), new MultiParagraph(new MultiParagraphIntrinsics(annotatedString, textStyle, CollectionsKt.emptyList(), density, this.f11035c), jB, this.f11038f, this.f11036d, null), this.f11044l, null);
    }

    public final void p(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i3, boolean z2, int i4, int i5) {
        this.f11033a = str;
        this.f11034b = textStyle;
        this.f11035c = resolver;
        this.f11036d = i3;
        this.f11037e = z2;
        this.f11038f = i4;
        this.f11039g = i5;
        i();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParagraphLayoutCache(paragraph=");
        sb.append(this.f11042j != null ? "<paragraph>" : "null");
        sb.append(", lastDensity=");
        sb.append((Object) InlineDensity.j(this.f11040h));
        sb.append(')');
        return sb.toString();
    }

    private ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i3, boolean z2, int i4, int i5) {
        this.f11033a = str;
        this.f11034b = textStyle;
        this.f11035c = resolver;
        this.f11036d = i3;
        this.f11037e = z2;
        this.f11038f = i4;
        this.f11039g = i5;
        this.f11040h = InlineDensity.f10997b.a();
        long j3 = 0;
        this.f11044l = IntSize.c((j3 & 4294967295L) | (j3 << 32));
        this.f11048p = Constraints.f29963b.c(0, 0);
        this.f11049q = -1;
        this.f11050r = -1;
    }
}
