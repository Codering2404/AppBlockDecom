package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ParagraphStyle implements AnnotatedString.Annotation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f28745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextIndent f28746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PlatformParagraphStyle f28747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LineHeightStyle f28748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f28749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f28750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextMotion f28751i;

    public /* synthetic */ ParagraphStyle(int i3, int i4, long j3, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, j3, textIndent, platformParagraphStyle, lineHeightStyle, i5, i6, textMotion);
    }

    public static /* synthetic */ ParagraphStyle b(ParagraphStyle paragraphStyle, int i3, int i4, long j3, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i3 = paragraphStyle.f28743a;
        }
        if ((i7 & 2) != 0) {
            i4 = paragraphStyle.f28744b;
        }
        if ((i7 & 4) != 0) {
            j3 = paragraphStyle.f28745c;
        }
        if ((i7 & 8) != 0) {
            textIndent = paragraphStyle.f28746d;
        }
        if ((i7 & 16) != 0) {
            platformParagraphStyle = paragraphStyle.f28747e;
        }
        if ((i7 & 32) != 0) {
            lineHeightStyle = paragraphStyle.f28748f;
        }
        if ((i7 & 64) != 0) {
            i5 = paragraphStyle.f28749g;
        }
        if ((i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            i6 = paragraphStyle.f28750h;
        }
        if ((i7 & Function.MAX_NARGS) != 0) {
            textMotion = paragraphStyle.f28751i;
        }
        int i8 = i6;
        TextMotion textMotion2 = textMotion;
        long j4 = j3;
        return paragraphStyle.a(i3, i4, j4, textIndent, platformParagraphStyle, lineHeightStyle, i5, i8, textMotion2);
    }

    public final ParagraphStyle a(int i3, int i4, long j3, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion) {
        return new ParagraphStyle(i3, i4, j3, textIndent, platformParagraphStyle, lineHeightStyle, i5, i6, textMotion, null);
    }

    public final int c() {
        return this.f28750h;
    }

    public final int d() {
        return this.f28749g;
    }

    public final long e() {
        return this.f28745c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
        return TextAlign.k(this.f28743a, paragraphStyle.f28743a) && TextDirection.j(this.f28744b, paragraphStyle.f28744b) && TextUnit.e(this.f28745c, paragraphStyle.f28745c) && Intrinsics.areEqual(this.f28746d, paragraphStyle.f28746d) && Intrinsics.areEqual(this.f28747e, paragraphStyle.f28747e) && Intrinsics.areEqual(this.f28748f, paragraphStyle.f28748f) && LineBreak.f(this.f28749g, paragraphStyle.f28749g) && Hyphens.g(this.f28750h, paragraphStyle.f28750h) && Intrinsics.areEqual(this.f28751i, paragraphStyle.f28751i);
    }

    public final LineHeightStyle f() {
        return this.f28748f;
    }

    public final PlatformParagraphStyle g() {
        return this.f28747e;
    }

    public final int h() {
        return this.f28743a;
    }

    public int hashCode() {
        int iL = ((((TextAlign.l(this.f28743a) * 31) + TextDirection.k(this.f28744b)) * 31) + TextUnit.i(this.f28745c)) * 31;
        TextIndent textIndent = this.f28746d;
        int iHashCode = (iL + (textIndent != null ? textIndent.hashCode() : 0)) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.f28747e;
        int iHashCode2 = (iHashCode + (platformParagraphStyle != null ? platformParagraphStyle.hashCode() : 0)) * 31;
        LineHeightStyle lineHeightStyle = this.f28748f;
        int iHashCode3 = (((((iHashCode2 + (lineHeightStyle != null ? lineHeightStyle.hashCode() : 0)) * 31) + LineBreak.j(this.f28749g)) * 31) + Hyphens.h(this.f28750h)) * 31;
        TextMotion textMotion = this.f28751i;
        return iHashCode3 + (textMotion != null ? textMotion.hashCode() : 0);
    }

    public final int i() {
        return this.f28744b;
    }

    public final TextIndent j() {
        return this.f28746d;
    }

    public final TextMotion k() {
        return this.f28751i;
    }

    public final ParagraphStyle l(ParagraphStyle paragraphStyle) {
        return paragraphStyle == null ? this : ParagraphStyleKt.a(this, paragraphStyle.f28743a, paragraphStyle.f28744b, paragraphStyle.f28745c, paragraphStyle.f28746d, paragraphStyle.f28747e, paragraphStyle.f28748f, paragraphStyle.f28749g, paragraphStyle.f28750h, paragraphStyle.f28751i);
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + ((Object) TextAlign.m(this.f28743a)) + ", textDirection=" + ((Object) TextDirection.l(this.f28744b)) + ", lineHeight=" + ((Object) TextUnit.l(this.f28745c)) + ", textIndent=" + this.f28746d + ", platformStyle=" + this.f28747e + ", lineHeightStyle=" + this.f28748f + ", lineBreak=" + ((Object) LineBreak.k(this.f28749g)) + ", hyphens=" + ((Object) Hyphens.i(this.f28750h)) + ", textMotion=" + this.f28751i + ')';
    }

    private ParagraphStyle(int i3, int i4, long j3, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion) {
        this.f28743a = i3;
        this.f28744b = i4;
        this.f28745c = j3;
        this.f28746d = textIndent;
        this.f28747e = platformParagraphStyle;
        this.f28748f = lineHeightStyle;
        this.f28749g = i5;
        this.f28750h = i6;
        this.f28751i = textMotion;
        if (TextUnit.e(j3, TextUnit.f30006b.a())) {
            return;
        }
        if (TextUnit.h(j3) >= 0.0f) {
            return;
        }
        InlineClassHelperKt.c("lineHeight can't be negative (" + TextUnit.h(j3) + ')');
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ParagraphStyle(int i3, int i4, long j3, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        int iG = (i7 & 1) != 0 ? TextAlign.f29616b.g() : i3;
        int iF = (i7 & 2) != 0 ? TextDirection.f29630b.f() : i4;
        long jA = (i7 & 4) != 0 ? TextUnit.f30006b.a() : j3;
        TextIndent textIndent2 = (i7 & 8) != 0 ? null : textIndent;
        PlatformParagraphStyle platformParagraphStyle2 = (i7 & 16) != 0 ? null : platformParagraphStyle;
        LineHeightStyle lineHeightStyle2 = (i7 & 32) != 0 ? null : lineHeightStyle;
        int iB = (i7 & 64) != 0 ? LineBreak.f29567b.b() : i5;
        int iC = (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Hyphens.f29562b.c() : i6;
        this(iG, iF, jA, textIndent2, platformParagraphStyle2, lineHeightStyle2, iB, iC, (i7 & Function.MAX_NARGS) == 0 ? textMotion : null, null);
    }
}
