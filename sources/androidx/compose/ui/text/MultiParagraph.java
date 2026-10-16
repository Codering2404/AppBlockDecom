package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidMultiParagraphDraw_androidKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MultiParagraph {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MultiParagraphIntrinsics f28710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f28712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f28713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f28714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f28715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f28716g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f28717h;

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j3, i3, i4);
    }

    public static /* synthetic */ void J(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            f3 = Float.NaN;
        }
        multiParagraph.I(canvas, brush, f3, (i4 & 8) != 0 ? null : shadow, (i4 & 16) != 0 ? null : textDecoration, (i4 & 32) != 0 ? null : drawStyle, (i4 & 64) != 0 ? DrawScope.e8.a() : i3);
    }

    private final void K(int i3) {
        boolean z2 = false;
        if (i3 >= 0 && i3 < b().k().length()) {
            z2 = true;
        }
        if (z2) {
            return;
        }
        InlineClassHelperKt.a("offset(" + i3 + ") is out of bounds [0, " + b().length() + ')');
    }

    private final void L(int i3) {
        boolean z2 = false;
        if (i3 >= 0 && i3 <= b().k().length()) {
            z2 = true;
        }
        if (z2) {
            return;
        }
        InlineClassHelperKt.a("offset(" + i3 + ") is out of bounds [0, " + b().length() + ']');
    }

    private final void M(int i3) {
        boolean z2 = false;
        if (i3 >= 0 && i3 < this.f28715f) {
            z2 = true;
        }
        if (z2) {
            return;
        }
        InlineClassHelperKt.a("lineIndex(" + i3 + ") is out of bounds [0, " + this.f28715f + ')');
    }

    private final AnnotatedString b() {
        return this.f28710a.d();
    }

    public static /* synthetic */ int o(MultiParagraph multiParagraph, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z2 = false;
        }
        return multiParagraph.n(i3, z2);
    }

    public final Path A(final int i3, final int i4) {
        if (!(i3 >= 0 && i3 <= i4 && i4 <= b().k().length())) {
            InlineClassHelperKt.a("Start(" + i3 + ") or End(" + i4 + ") is out of range [0.." + b().k().length() + "), or start > end!");
        }
        if (i3 == i4) {
            return AndroidPath_androidKt.a();
        }
        final Path pathA = AndroidPath_androidKt.a();
        MultiParagraphKt.d(this.f28717h, TextRangeKt.b(i3, i4), new Function1<ParagraphInfo, Unit>() { // from class: androidx.compose.ui.text.MultiParagraph$getPathForRange$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(ParagraphInfo paragraphInfo) {
                Path.u(pathA, paragraphInfo.j(paragraphInfo.e().t(paragraphInfo.r(i3), paragraphInfo.r(i4))), 0L, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((ParagraphInfo) obj);
                return Unit.f139807a;
            }
        });
        return pathA;
    }

    public final List B() {
        return this.f28716g;
    }

    public final long C(Rect rect, int i3, TextInclusionStrategy textInclusionStrategy) {
        TextRange.Companion companion;
        TextRange.Companion companion2;
        int iC = MultiParagraphKt.c(this.f28717h, rect.r());
        if (((ParagraphInfo) this.f28717h.get(iC)).a() >= rect.i() || iC == CollectionsKt.getLastIndex(this.f28717h)) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(iC);
            return ParagraphInfo.l(paragraphInfo, paragraphInfo.e().A(paragraphInfo.p(rect), i3, textInclusionStrategy), false, 1, null);
        }
        int iC2 = MultiParagraphKt.c(this.f28717h, rect.i());
        long jA = TextRange.f28921b.a();
        while (true) {
            companion = TextRange.f28921b;
            if (!TextRange.g(jA, companion.a()) || iC > iC2) {
                break;
            }
            ParagraphInfo paragraphInfo2 = (ParagraphInfo) this.f28717h.get(iC);
            jA = ParagraphInfo.l(paragraphInfo2, paragraphInfo2.e().A(paragraphInfo2.p(rect), i3, textInclusionStrategy), false, 1, null);
            iC++;
        }
        if (TextRange.g(jA, companion.a())) {
            return companion.a();
        }
        long jA2 = companion.a();
        while (true) {
            companion2 = TextRange.f28921b;
            if (!TextRange.g(jA2, companion2.a()) || iC > iC2) {
                break;
            }
            ParagraphInfo paragraphInfo3 = (ParagraphInfo) this.f28717h.get(iC2);
            jA2 = ParagraphInfo.l(paragraphInfo3, paragraphInfo3.e().A(paragraphInfo3.p(rect), i3, textInclusionStrategy), false, 1, null);
            iC2--;
        }
        return TextRange.g(jA2, companion2.a()) ? jA : TextRangeKt.b(TextRange.n(jA), TextRange.i(jA2));
    }

    public final float D() {
        return this.f28713d;
    }

    public final long E(int i3) {
        L(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(i3 == b().length() ? CollectionsKt.getLastIndex(this.f28717h) : MultiParagraphKt.a(this.f28717h, i3));
        return paragraphInfo.k(paragraphInfo.e().k(paragraphInfo.r(i3)), false);
    }

    public final boolean F(int i3) {
        M(i3);
        return ((ParagraphInfo) this.f28717h.get(MultiParagraphKt.b(this.f28717h, i3))).e().n(i3);
    }

    public final void G(Canvas canvas, long j3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3) {
        canvas.t();
        List list = this.f28717h;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i4);
            paragraphInfo.e().j(canvas, j3, shadow, textDecoration, drawStyle, i3);
            canvas.e(0.0f, paragraphInfo.e().getHeight());
        }
        canvas.k();
    }

    public final void I(Canvas canvas, Brush brush, float f3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3) {
        AndroidMultiParagraphDraw_androidKt.a(this, canvas, brush, f3, shadow, textDecoration, drawStyle, i3);
    }

    public final float[] a(final long j3, final float[] fArr, int i3) {
        K(TextRange.l(j3));
        L(TextRange.k(j3));
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.f140142a = i3;
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        MultiParagraphKt.d(this.f28717h, j3, new Function1<ParagraphInfo, Unit>() { // from class: androidx.compose.ui.text.MultiParagraph$fillBoundingBoxes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(ParagraphInfo paragraphInfo) {
                long j4 = j3;
                float[] fArr2 = fArr;
                Ref.IntRef intRef2 = intRef;
                Ref.FloatRef floatRef2 = floatRef;
                long jB = TextRangeKt.b(paragraphInfo.r(paragraphInfo.f() > TextRange.l(j4) ? paragraphInfo.f() : TextRange.l(j4)), paragraphInfo.r(paragraphInfo.b() < TextRange.k(j4) ? paragraphInfo.b() : TextRange.k(j4)));
                paragraphInfo.e().x(jB, fArr2, intRef2.f140142a);
                int iJ = intRef2.f140142a + (TextRange.j(jB) * 4);
                for (int i4 = intRef2.f140142a; i4 < iJ; i4 += 4) {
                    int i5 = i4 + 1;
                    float f3 = fArr2[i5];
                    float f4 = floatRef2.f140141a;
                    fArr2[i5] = f3 + f4;
                    int i6 = i4 + 3;
                    fArr2[i6] = fArr2[i6] + f4;
                }
                intRef2.f140142a = iJ;
                floatRef2.f140141a += paragraphInfo.e().getHeight();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((ParagraphInfo) obj);
                return Unit.f139807a;
            }
        });
        return fArr;
    }

    public final ResolvedTextDirection c(int i3) {
        L(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(i3 == b().length() ? CollectionsKt.getLastIndex(this.f28717h) : MultiParagraphKt.a(this.f28717h, i3));
        return paragraphInfo.e().B(paragraphInfo.r(i3));
    }

    public final Rect d(int i3) {
        K(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(MultiParagraphKt.a(this.f28717h, i3));
        return paragraphInfo.i(paragraphInfo.e().f(paragraphInfo.r(i3)));
    }

    public final Rect e(int i3) {
        L(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(i3 == b().length() ? CollectionsKt.getLastIndex(this.f28717h) : MultiParagraphKt.a(this.f28717h, i3));
        return paragraphInfo.i(paragraphInfo.e().i(paragraphInfo.r(i3)));
    }

    public final boolean f() {
        return this.f28712c;
    }

    public final float g() {
        if (this.f28717h.isEmpty()) {
            return 0.0f;
        }
        return ((ParagraphInfo) this.f28717h.get(0)).e().l();
    }

    public final float h() {
        return this.f28714e;
    }

    public final float i(int i3, boolean z2) {
        L(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(i3 == b().length() ? CollectionsKt.getLastIndex(this.f28717h) : MultiParagraphKt.a(this.f28717h, i3));
        return paragraphInfo.e().u(paragraphInfo.r(i3), z2);
    }

    public final MultiParagraphIntrinsics j() {
        return this.f28710a;
    }

    public final float k() {
        if (this.f28717h.isEmpty()) {
            return 0.0f;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) CollectionsKt.last(this.f28717h);
        return paragraphInfo.o(paragraphInfo.e().y());
    }

    public final float l(int i3) {
        M(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(MultiParagraphKt.b(this.f28717h, i3));
        return paragraphInfo.o(paragraphInfo.e().C(paragraphInfo.s(i3)));
    }

    public final int m() {
        return this.f28715f;
    }

    public final int n(int i3, boolean z2) {
        M(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(MultiParagraphKt.b(this.f28717h, i3));
        return paragraphInfo.m(paragraphInfo.e().p(paragraphInfo.s(i3), z2));
    }

    public final int p(int i3) {
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(i3 >= b().length() ? CollectionsKt.getLastIndex(this.f28717h) : i3 < 0 ? 0 : MultiParagraphKt.a(this.f28717h, i3));
        return paragraphInfo.n(paragraphInfo.e().z(paragraphInfo.r(i3)));
    }

    public final int q(float f3) {
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(MultiParagraphKt.c(this.f28717h, f3));
        return paragraphInfo.d() == 0 ? paragraphInfo.g() : paragraphInfo.n(paragraphInfo.e().s(paragraphInfo.t(f3)));
    }

    public final float r(int i3) {
        M(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(MultiParagraphKt.b(this.f28717h, i3));
        return paragraphInfo.e().b(paragraphInfo.s(i3));
    }

    public final float s(int i3) {
        M(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(MultiParagraphKt.b(this.f28717h, i3));
        return paragraphInfo.e().d(paragraphInfo.s(i3));
    }

    public final float t(int i3) {
        M(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(MultiParagraphKt.b(this.f28717h, i3));
        return paragraphInfo.e().a(paragraphInfo.s(i3));
    }

    public final int u(int i3) {
        M(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(MultiParagraphKt.b(this.f28717h, i3));
        return paragraphInfo.m(paragraphInfo.e().o(paragraphInfo.s(i3)));
    }

    public final float v(int i3) {
        M(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(MultiParagraphKt.b(this.f28717h, i3));
        return paragraphInfo.o(paragraphInfo.e().h(paragraphInfo.s(i3)));
    }

    public final int w() {
        return this.f28711b;
    }

    public final int x(long j3) {
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(MultiParagraphKt.c(this.f28717h, Float.intBitsToFloat((int) (4294967295L & j3))));
        return paragraphInfo.d() == 0 ? paragraphInfo.f() : paragraphInfo.m(paragraphInfo.e().m(paragraphInfo.q(j3)));
    }

    public final ResolvedTextDirection y(int i3) {
        L(i3);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.f28717h.get(i3 == b().length() ? CollectionsKt.getLastIndex(this.f28717h) : MultiParagraphKt.a(this.f28717h, i3));
        return paragraphInfo.e().g(paragraphInfo.r(i3));
    }

    public final List z() {
        return this.f28717h;
    }

    private MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j3, int i3, int i4) {
        this.f28710a = multiParagraphIntrinsics;
        this.f28711b = i3;
        boolean z2 = true;
        if (!(Constraints.n(j3) == 0 && Constraints.m(j3) == 0)) {
            InlineClassHelperKt.a("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        ArrayList arrayList = new ArrayList();
        List listF = multiParagraphIntrinsics.f();
        int size = listF.size();
        int i5 = 0;
        float f3 = 0.0f;
        int i6 = 0;
        while (i6 < size) {
            ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) listF.get(i6);
            Paragraph paragraphC = ParagraphKt.c(paragraphIntrinsicInfo.b(), ConstraintsKt.b(0, Constraints.l(j3), 0, Constraints.g(j3) ? RangesKt.f(Constraints.k(j3) - ParagraphKt.d(f3), 0) : Constraints.k(j3), 5, null), this.f28711b - i5, i4);
            float height = f3 + paragraphC.getHeight();
            int iQ = i5 + paragraphC.q();
            arrayList.add(new ParagraphInfo(paragraphC, paragraphIntrinsicInfo.c(), paragraphIntrinsicInfo.a(), i5, iQ, f3, height));
            if (paragraphC.r() || (iQ == this.f28711b && i6 != CollectionsKt.getLastIndex(this.f28710a.f()))) {
                i5 = iQ;
                f3 = height;
                break;
            } else {
                i6++;
                i5 = iQ;
                f3 = height;
            }
        }
        z2 = false;
        this.f28714e = f3;
        this.f28715f = i5;
        this.f28712c = z2;
        this.f28717h = arrayList;
        this.f28713d = Constraints.l(j3);
        List arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i7 = 0; i7 < size2; i7++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i7);
            List listD = paragraphInfo.e().D();
            ArrayList arrayList3 = new ArrayList(listD.size());
            int size3 = listD.size();
            for (int i8 = 0; i8 < size3; i8++) {
                Rect rect = (Rect) listD.get(i8);
                arrayList3.add(rect != null ? paragraphInfo.i(rect) : null);
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        if (arrayList2.size() < this.f28710a.g().size()) {
            int size4 = this.f28710a.g().size() - arrayList2.size();
            ArrayList arrayList4 = new ArrayList(size4);
            for (int i9 = 0; i9 < size4; i9++) {
                arrayList4.add(null);
            }
            arrayList2 = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList4);
        }
        this.f28716g = arrayList2;
    }
}
