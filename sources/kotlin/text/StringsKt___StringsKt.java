package kotlin.text;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static char A1(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static String B1(String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i3 >= 0) {
            String strSubstring = str.substring(0, RangesKt.k(i3, str.length()));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i3 + " is less than zero.").toString());
    }

    public static String C1(String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i3 >= 0) {
            int length = str.length();
            String strSubstring = str.substring(length - RangesKt.k(i3, length));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i3 + " is less than zero.").toString());
    }

    public static String w1(String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i3 >= 0) {
            String strSubstring = str.substring(RangesKt.k(i3, str.length()));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i3 + " is less than zero.").toString());
    }

    public static char y1(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char z1(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(StringsKt__StringsKt.h0(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String x1(String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i3 >= 0) {
            return B1(str, RangesKt.f(str.length() - i3, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i3 + YvFRmou.moPwgSTXMGTUVO).toString());
    }
}
