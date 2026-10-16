package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
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
public final class ParagraphStyleKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f28752a = TextUnit.f30006b.a();

    public static final ParagraphStyle a(ParagraphStyle paragraphStyle, int i3, int i4, long j3, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion) {
        long j4;
        long j5;
        int iH = i3;
        TextIndent textIndentJ = textIndent;
        TextAlign.Companion companion = TextAlign.f29616b;
        if (TextAlign.k(iH, companion.g()) || TextAlign.k(iH, paragraphStyle.h())) {
            if (TextUnit.f(j3) == 0) {
                j4 = 0;
                j5 = j3;
            } else {
                j4 = 0;
                j5 = j3;
                if (TextUnit.e(j5, paragraphStyle.e())) {
                }
            }
            if ((textIndentJ == null || Intrinsics.areEqual(textIndentJ, paragraphStyle.j())) && ((TextDirection.j(i4, TextDirection.f29630b.f()) || TextDirection.j(i4, paragraphStyle.i())) && ((platformParagraphStyle == null || Intrinsics.areEqual(platformParagraphStyle, paragraphStyle.g())) && ((lineHeightStyle == null || Intrinsics.areEqual(lineHeightStyle, paragraphStyle.f())) && ((LineBreak.f(i5, LineBreak.f29567b.b()) || LineBreak.f(i5, paragraphStyle.d())) && ((Hyphens.g(i6, Hyphens.f29562b.c()) || Hyphens.g(i6, paragraphStyle.c())) && (textMotion == null || Intrinsics.areEqual(textMotion, paragraphStyle.k())))))))) {
                return paragraphStyle;
            }
        } else {
            j4 = 0;
            j5 = j3;
        }
        long jE = TextUnit.f(j5) == j4 ? paragraphStyle.e() : j5;
        if (textIndentJ == null) {
            textIndentJ = paragraphStyle.j();
        }
        TextIndent textIndent2 = textIndentJ;
        if (TextAlign.k(iH, companion.g())) {
            iH = paragraphStyle.h();
        }
        return new ParagraphStyle(iH, !TextDirection.j(i4, TextDirection.f29630b.f()) ? i4 : paragraphStyle.i(), jE, textIndent2, d(paragraphStyle, platformParagraphStyle), lineHeightStyle == null ? paragraphStyle.f() : lineHeightStyle, !LineBreak.f(i5, LineBreak.f29567b.b()) ? i5 : paragraphStyle.d(), !Hyphens.g(i6, Hyphens.f29562b.c()) ? i6 : paragraphStyle.c(), textMotion == null ? paragraphStyle.k() : textMotion, null);
    }

    public static final ParagraphStyle b(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, float f3) {
        int iN = ((TextAlign) SpanStyleKt.d(TextAlign.h(paragraphStyle.h()), TextAlign.h(paragraphStyle2.h()), f3)).n();
        int iM = ((TextDirection) SpanStyleKt.d(TextDirection.g(paragraphStyle.i()), TextDirection.g(paragraphStyle2.i()), f3)).m();
        long jF = SpanStyleKt.f(paragraphStyle.e(), paragraphStyle2.e(), f3);
        TextIndent textIndentJ = paragraphStyle.j();
        if (textIndentJ == null) {
            textIndentJ = TextIndent.f29647c.a();
        }
        TextIndent textIndentJ2 = paragraphStyle2.j();
        if (textIndentJ2 == null) {
            textIndentJ2 = TextIndent.f29647c.a();
        }
        return new ParagraphStyle(iN, iM, jF, TextIndentKt.a(textIndentJ, textIndentJ2, f3), c(paragraphStyle.g(), paragraphStyle2.g(), f3), (LineHeightStyle) SpanStyleKt.d(paragraphStyle.f(), paragraphStyle2.f(), f3), ((LineBreak) SpanStyleKt.d(LineBreak.c(paragraphStyle.d()), LineBreak.c(paragraphStyle2.d()), f3)).l(), ((Hyphens) SpanStyleKt.d(Hyphens.d(paragraphStyle.c()), Hyphens.d(paragraphStyle2.c()), f3)).j(), (TextMotion) SpanStyleKt.d(paragraphStyle.k(), paragraphStyle2.k(), f3), null);
    }

    private static final PlatformParagraphStyle c(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f3) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.f28765c.a();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.f28765c.a();
        }
        return AndroidTextStyle_androidKt.b(platformParagraphStyle, platformParagraphStyle2, f3);
    }

    private static final PlatformParagraphStyle d(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        return paragraphStyle.g() == null ? platformParagraphStyle : platformParagraphStyle == null ? paragraphStyle.g() : paragraphStyle.g().d(platformParagraphStyle);
    }

    public static final ParagraphStyle e(ParagraphStyle paragraphStyle, LayoutDirection layoutDirection) {
        int iH = paragraphStyle.h();
        TextAlign.Companion companion = TextAlign.f29616b;
        int iF = TextAlign.k(iH, companion.g()) ? companion.f() : paragraphStyle.h();
        int iE = TextStyleKt.e(layoutDirection, paragraphStyle.i());
        long jE = TextUnit.f(paragraphStyle.e()) == 0 ? f28752a : paragraphStyle.e();
        TextIndent textIndentJ = paragraphStyle.j();
        if (textIndentJ == null) {
            textIndentJ = TextIndent.f29647c.a();
        }
        TextIndent textIndent = textIndentJ;
        PlatformParagraphStyle platformParagraphStyleG = paragraphStyle.g();
        LineHeightStyle lineHeightStyleF = paragraphStyle.f();
        int iD = paragraphStyle.d();
        LineBreak.Companion companion2 = LineBreak.f29567b;
        int iA = LineBreak.f(iD, companion2.b()) ? companion2.a() : paragraphStyle.d();
        int iC = paragraphStyle.c();
        Hyphens.Companion companion3 = Hyphens.f29562b;
        int iB = Hyphens.g(iC, companion3.c()) ? companion3.b() : paragraphStyle.c();
        TextMotion textMotionK = paragraphStyle.k();
        if (textMotionK == null) {
            textMotionK = TextMotion.f29651c.a();
        }
        return new ParagraphStyle(iF, iE, jE, textIndent, platformParagraphStyleG, lineHeightStyleF, iA, iB, textMotionK, null);
    }
}
