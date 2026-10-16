package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.emoji2.text.EmojiSpan;
import java.util.List;
import kotlin.Metadata;

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
public final class PlaceholderExtensions_androidKt {
    private static final int a(long j3) {
        long jG = TextUnit.g(j3);
        TextUnitType.Companion companion = TextUnitType.f30010b;
        if (TextUnitType.g(jG, companion.b())) {
            return 0;
        }
        return TextUnitType.g(jG, companion.a()) ? 1 : 2;
    }

    private static final int b(int i3) {
        PlaceholderVerticalAlign.Companion companion = PlaceholderVerticalAlign.f28756b;
        if (PlaceholderVerticalAlign.j(i3, companion.a())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.j(i3, companion.g())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.j(i3, companion.b())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.j(i3, companion.c())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.j(i3, companion.f())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.j(i3, companion.d())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.j(i3, companion.e())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign");
    }

    private static final void c(Spannable spannable, Placeholder placeholder, int i3, int i4, Density density) {
        for (Object obj : spannable.getSpans(i3, i4, EmojiSpan.class)) {
            spannable.removeSpan((EmojiSpan) obj);
        }
        SpannableExtensions_androidKt.w(spannable, new PlaceholderSpan(TextUnit.h(placeholder.c()), a(placeholder.c()), TextUnit.h(placeholder.a()), a(placeholder.a()), density.K1() * density.getDensity(), b(placeholder.b())), i3, i4);
    }

    public static final void d(Spannable spannable, List list, Density density) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range range = (AnnotatedString.Range) list.get(i3);
            c(spannable, (Placeholder) range.a(), range.b(), range.c(), density);
        }
    }
}
