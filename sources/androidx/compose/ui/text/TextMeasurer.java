package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextMeasurer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f28913f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FontFamily.Resolver f28914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Density f28915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LayoutDirection f28916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f28917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextLayoutCache f28918e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TextLayoutResult b(TextLayoutInput textLayoutInput) {
            MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(textLayoutInput.j(), TextStyleKt.d(textLayoutInput.i(), textLayoutInput.d()), textLayoutInput.g(), textLayoutInput.b(), textLayoutInput.c());
            int iN = Constraints.n(textLayoutInput.a());
            int iL = ((textLayoutInput.h() || TextMeasurerKt.b(textLayoutInput.f())) && Constraints.h(textLayoutInput.a())) ? Constraints.l(textLayoutInput.a()) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int iE = (textLayoutInput.h() || !TextMeasurerKt.b(textLayoutInput.f())) ? textLayoutInput.e() : 1;
            if (iN != iL) {
                iL = RangesKt.p(ParagraphKt.d(multiParagraphIntrinsics.c()), iN, iL);
            }
            return new TextLayoutResult(textLayoutInput, new MultiParagraph(multiParagraphIntrinsics, Constraints.f29963b.b(0, iL, 0, Constraints.k(textLayoutInput.a())), iE, textLayoutInput.f(), null), ConstraintsKt.d(textLayoutInput.a(), IntSize.c((((long) ((int) Math.ceil(r5.D()))) << 32) | (((long) ((int) Math.ceil(r5.h()))) & 4294967295L))), null);
        }

        private Companion() {
        }
    }

    public TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i3) {
        this.f28914a = resolver;
        this.f28915b = density;
        this.f28916c = layoutDirection;
        this.f28917d = i3;
        this.f28918e = i3 > 0 ? new TextLayoutCache(i3) : null;
    }

    public static /* synthetic */ TextLayoutResult b(TextMeasurer textMeasurer, String str, TextStyle textStyle, int i3, boolean z2, int i4, long j3, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            textStyle = TextStyle.f28924d.a();
        }
        TextStyle textStyle2 = textStyle;
        if ((i5 & 4) != 0) {
            i3 = TextOverflow.f29661b.a();
        }
        return textMeasurer.a(str, textStyle2, i3, (i5 & 8) != 0 ? true : z2, (i5 & 16) != 0 ? Integer.MAX_VALUE : i4, (i5 & 32) != 0 ? ConstraintsKt.b(0, 0, 0, 0, 15, null) : j3, (i5 & 64) != 0 ? textMeasurer.f28916c : layoutDirection, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? textMeasurer.f28915b : density, (i5 & Function.MAX_NARGS) != 0 ? textMeasurer.f28914a : resolver, (i5 & 512) != 0 ? false : z3);
    }

    public static /* synthetic */ TextLayoutResult d(TextMeasurer textMeasurer, AnnotatedString annotatedString, TextStyle textStyle, int i3, boolean z2, int i4, List list, long j3, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            textStyle = TextStyle.f28924d.a();
        }
        return textMeasurer.c(annotatedString, textStyle, (i5 & 4) != 0 ? TextOverflow.f29661b.a() : i3, (i5 & 8) != 0 ? true : z2, (i5 & 16) != 0 ? Integer.MAX_VALUE : i4, (i5 & 32) != 0 ? CollectionsKt.emptyList() : list, (i5 & 64) != 0 ? ConstraintsKt.b(0, 0, 0, 0, 15, null) : j3, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? textMeasurer.f28916c : layoutDirection, (i5 & Function.MAX_NARGS) != 0 ? textMeasurer.f28915b : density, (i5 & 512) != 0 ? textMeasurer.f28914a : resolver, (i5 & 1024) != 0 ? false : z3);
    }

    public final TextLayoutResult a(String str, TextStyle textStyle, int i3, boolean z2, int i4, long j3, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z3) {
        return d(this, new AnnotatedString(str, null, 2, null), textStyle, i3, z2, i4, null, j3, layoutDirection, density, resolver, z3, 32, null);
    }

    public final TextLayoutResult c(AnnotatedString annotatedString, TextStyle textStyle, int i3, boolean z2, int i4, List list, long j3, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z3) {
        TextLayoutCache textLayoutCache;
        TextLayoutInput textLayoutInput = new TextLayoutInput(annotatedString, textStyle, list, i4, z2, i3, density, layoutDirection, resolver, j3, (DefaultConstructorMarker) null);
        TextLayoutResult textLayoutResultA = (z3 || (textLayoutCache = this.f28918e) == null) ? null : textLayoutCache.a(textLayoutInput);
        if (textLayoutResultA != null) {
            return textLayoutResultA.a(textLayoutInput, ConstraintsKt.d(j3, IntSize.c((((long) ParagraphKt.d(textLayoutResultA.w().D())) << 32) | (((long) ParagraphKt.d(textLayoutResultA.w().h())) & 4294967295L))));
        }
        TextLayoutResult textLayoutResultB = f28913f.b(textLayoutInput);
        TextLayoutCache textLayoutCache2 = this.f28918e;
        if (textLayoutCache2 != null) {
            textLayoutCache2.b(textLayoutInput, textLayoutResultB);
        }
        return textLayoutResultB;
    }
}
