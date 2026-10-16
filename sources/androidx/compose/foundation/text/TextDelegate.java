package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
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
import com.google.android.gms.common.api.Api;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class TextDelegate {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f9901l = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnnotatedString f9902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextStyle f9903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f9906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Density f9908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final FontFamily.Resolver f9909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f9910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MultiParagraphIntrinsics f9911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LayoutDirection f9912k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i3, int i4, boolean z2, int i5, Density density, FontFamily.Resolver resolver, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, i3, i4, z2, i5, density, resolver, list);
    }

    private final MultiParagraphIntrinsics f() {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.f9911j;
        if (multiParagraphIntrinsics != null) {
            return multiParagraphIntrinsics;
        }
        throw new IllegalStateException("layoutIntrinsics must be called first");
    }

    private final MultiParagraph n(long j3, LayoutDirection layoutDirection) {
        m(layoutDirection);
        int iN = Constraints.n(j3);
        int iL = ((this.f9906e || TextOverflow.h(this.f9907f, TextOverflow.f29661b.b())) && Constraints.h(j3)) ? Constraints.l(j3) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i3 = (this.f9906e || !TextOverflow.h(this.f9907f, TextOverflow.f29661b.b())) ? this.f9904c : 1;
        if (iN != iL) {
            iL = RangesKt.p(c(), iN, iL);
        }
        return new MultiParagraph(f(), Constraints.f29963b.b(0, iL, 0, Constraints.k(j3)), i3, this.f9907f, null);
    }

    public final Density a() {
        return this.f9908g;
    }

    public final FontFamily.Resolver b() {
        return this.f9909h;
    }

    public final int c() {
        return TextDelegateKt.a(f().c());
    }

    public final int d() {
        return this.f9904c;
    }

    public final int e() {
        return this.f9905d;
    }

    public final int g() {
        return this.f9907f;
    }

    public final List h() {
        return this.f9910i;
    }

    public final boolean i() {
        return this.f9906e;
    }

    public final TextStyle j() {
        return this.f9903b;
    }

    public final AnnotatedString k() {
        return this.f9902a;
    }

    public final TextLayoutResult l(long j3, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult) {
        if (textLayoutResult != null && TextLayoutHelperKt.a(textLayoutResult, this.f9902a, this.f9903b, this.f9910i, this.f9904c, this.f9906e, this.f9907f, this.f9908g, layoutDirection, this.f9909h, j3)) {
            return textLayoutResult.a(new TextLayoutInput(textLayoutResult.l().j(), this.f9903b, textLayoutResult.l().g(), textLayoutResult.l().e(), textLayoutResult.l().h(), textLayoutResult.l().f(), textLayoutResult.l().b(), textLayoutResult.l().d(), textLayoutResult.l().c(), j3, (DefaultConstructorMarker) null), ConstraintsKt.d(j3, IntSize.c((((long) TextDelegateKt.a(textLayoutResult.w().h())) & 4294967295L) | (((long) TextDelegateKt.a(textLayoutResult.w().D())) << 32))));
        }
        MultiParagraph multiParagraphN = n(j3, layoutDirection);
        return new TextLayoutResult(new TextLayoutInput(this.f9902a, this.f9903b, this.f9910i, this.f9904c, this.f9906e, this.f9907f, this.f9908g, layoutDirection, this.f9909h, j3, (DefaultConstructorMarker) null), multiParagraphN, ConstraintsKt.d(j3, IntSize.c((((long) TextDelegateKt.a(multiParagraphN.h())) & 4294967295L) | (((long) TextDelegateKt.a(multiParagraphN.D())) << 32))), null);
    }

    public final void m(LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.f9911j;
        if (multiParagraphIntrinsics == null || layoutDirection != this.f9912k || multiParagraphIntrinsics.a()) {
            this.f9912k = layoutDirection;
            multiParagraphIntrinsics = new MultiParagraphIntrinsics(this.f9902a, TextStyleKt.d(this.f9903b, layoutDirection), this.f9910i, this.f9908g, this.f9909h);
        }
        this.f9911j = multiParagraphIntrinsics;
    }

    private TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i3, int i4, boolean z2, int i5, Density density, FontFamily.Resolver resolver, List list) {
        this.f9902a = annotatedString;
        this.f9903b = textStyle;
        this.f9904c = i3;
        this.f9905d = i4;
        this.f9906e = z2;
        this.f9907f = i5;
        this.f9908g = density;
        this.f9909h = resolver;
        this.f9910i = list;
        if (!(i3 > 0)) {
            InlineClassHelperKt.a("no maxLines");
        }
        if (!(i4 > 0)) {
            InlineClassHelperKt.a("no minLines");
        }
        if (i4 <= i3) {
            return;
        }
        InlineClassHelperKt.a("minLines greater than maxLines");
    }

    public /* synthetic */ TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i3, int i4, boolean z2, int i5, Density density, FontFamily.Resolver resolver, List list, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (i6 & 4) != 0 ? Integer.MAX_VALUE : i3, (i6 & 8) != 0 ? 1 : i4, (i6 & 16) != 0 ? true : z2, (i6 & 32) != 0 ? TextOverflow.f29661b.a() : i5, density, resolver, (i6 & Function.MAX_NARGS) != 0 ? CollectionsKt.emptyList() : list, null);
    }
}
