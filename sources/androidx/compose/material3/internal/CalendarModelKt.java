package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

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
public final class CalendarModelKt {
    public static final DateInputFormat a(String str) {
        String strL0 = StringsKt.L0(StringsKt.O(new Regex("y{1,4}").replace(new Regex("M{1,2}").replace(new Regex("d{1,2}").replace(new Regex("[^dMy/\\-.]").replace(str, ""), "dd"), "MM"), "yyyy"), "My", "M/y", false, 4, null), ".");
        MatchResult matchResultE = Regex.e(new Regex("[/\\-.]"), strL0, 0, 2, null);
        Intrinsics.checkNotNull(matchResultE);
        MatchGroup matchGroup = matchResultE.d().get(0);
        Intrinsics.checkNotNull(matchGroup);
        int iG = matchGroup.a().g();
        String strSubstring = strL0.substring(iG, iG + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return new DateInputFormat(strL0, strSubstring.charAt(0));
    }
}
