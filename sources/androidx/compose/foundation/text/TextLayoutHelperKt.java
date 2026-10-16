package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextLayoutHelperKt {
    public static final boolean a(TextLayoutResult textLayoutResult, AnnotatedString annotatedString, TextStyle textStyle, List list, int i3, boolean z2, int i4, Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j3) {
        TextLayoutInput textLayoutInputL = textLayoutResult.l();
        if (textLayoutResult.w().j().a() || !Intrinsics.areEqual(textLayoutInputL.j(), annotatedString) || !textLayoutInputL.i().I(textStyle) || !Intrinsics.areEqual(textLayoutInputL.g(), list) || textLayoutInputL.e() != i3 || textLayoutInputL.h() != z2 || !TextOverflow.h(textLayoutInputL.f(), i4) || !Intrinsics.areEqual(textLayoutInputL.b(), density) || textLayoutInputL.d() != layoutDirection || !Intrinsics.areEqual(textLayoutInputL.c(), resolver) || Constraints.n(j3) != Constraints.n(textLayoutInputL.a())) {
            return false;
        }
        if (z2 || TextOverflow.h(i4, TextOverflow.f29661b.b())) {
            return Constraints.l(j3) == Constraints.l(textLayoutInputL.a()) && Constraints.k(j3) == Constraints.k(textLayoutInputL.a());
        }
        return true;
    }

    public static final float b(TextLayoutResult textLayoutResult, int i3) {
        if (i3 < 0 || textLayoutResult.l().j().length() == 0) {
            return 0.0f;
        }
        int iMin = Math.min(textLayoutResult.w().p(i3), Math.min(textLayoutResult.w().w() - 1, textLayoutResult.w().m() - 1));
        if (i3 > MultiParagraph.o(textLayoutResult.w(), iMin, false, 2, null)) {
            return 0.0f;
        }
        return textLayoutResult.w().r(iMin);
    }
}
