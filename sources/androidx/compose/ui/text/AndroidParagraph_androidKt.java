package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.android.SpannedExtensions_androidKt;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
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
public final class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence j(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : null;
        if (spannableString == null) {
            spannableString = new SpannableString(charSequence);
        }
        if (!SpannedExtensions_androidKt.a(spannableString, IndentationFixSpan.class)) {
            SpannableExtensions_androidKt.w(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(TextLayout textLayout, int i3) {
        int iM = textLayout.m();
        for (int i4 = 0; i4 < iM; i4++) {
            if (textLayout.l(i4) > i3) {
                return i4;
            }
        }
        return textLayout.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(TextStyle textStyle, boolean z2) {
        if (z2 && !TextUnit.e(textStyle.s(), TextUnitKt.i(0)) && !TextUnit.e(textStyle.s(), TextUnit.f30006b.a())) {
            int iB = textStyle.B();
            TextAlign.Companion companion = TextAlign.f29616b;
            if (!TextAlign.k(iB, companion.g()) && !TextAlign.k(textStyle.B(), companion.f()) && !TextAlign.k(textStyle.B(), companion.c())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(int i3) {
        TextAlign.Companion companion = TextAlign.f29616b;
        if (TextAlign.k(i3, companion.d())) {
            return 3;
        }
        if (TextAlign.k(i3, companion.e())) {
            return 4;
        }
        if (TextAlign.k(i3, companion.a())) {
            return 2;
        }
        return (!TextAlign.k(i3, companion.f()) && TextAlign.k(i3, companion.b())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(int i3) {
        LineBreak.Strategy.Companion companion = LineBreak.Strategy.f29573b;
        if (LineBreak.Strategy.f(i3, companion.c())) {
            return 0;
        }
        if (LineBreak.Strategy.f(i3, companion.b())) {
            return 1;
        }
        return LineBreak.Strategy.f(i3, companion.a()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(int i3) {
        Hyphens.Companion companion = Hyphens.f29562b;
        if (Hyphens.g(i3, companion.a())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        Hyphens.g(i3, companion.b());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(int i3) {
        LineBreak.Strictness.Companion companion = LineBreak.Strictness.f29579b;
        if (LineBreak.Strictness.g(i3, companion.a())) {
            return 0;
        }
        if (LineBreak.Strictness.g(i3, companion.b())) {
            return 1;
        }
        if (LineBreak.Strictness.g(i3, companion.c())) {
            return 2;
        }
        return LineBreak.Strictness.g(i3, companion.d()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(int i3) {
        LineBreak.WordBreak.Companion companion = LineBreak.WordBreak.f29586b;
        return (!LineBreak.WordBreak.e(i3, companion.a()) && LineBreak.WordBreak.e(i3, companion.b())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int r(int i3) {
        TextGranularity.Companion companion = TextGranularity.f28879b;
        return (!TextGranularity.e(i3, companion.a()) && TextGranularity.e(i3, companion.b())) ? 1 : 0;
    }
}
