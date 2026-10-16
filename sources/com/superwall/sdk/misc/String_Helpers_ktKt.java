package com.superwall.sdk.misc;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class String_Helpers_ktKt {
    public static final String camelCaseToSnakeCase(String str) {
        String strProcessCamelCaseRegex;
        String strProcessCamelCaseRegex2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        String strProcessCamelCaseRegex3 = processCamelCaseRegex(str, "([A-Z]+)([A-Z][a-z]|[0-9])");
        if (strProcessCamelCaseRegex3 != null && (strProcessCamelCaseRegex = processCamelCaseRegex(strProcessCamelCaseRegex3, "([a-z])([A-Z]|[0-9])")) != null && (strProcessCamelCaseRegex2 = processCamelCaseRegex(strProcessCamelCaseRegex, "([0-9])([A-Z])")) != null) {
            String lowerCase = strProcessCamelCaseRegex2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                return lowerCase;
            }
        }
        String lowerCase2 = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return lowerCase2;
    }

    private static final String processCamelCaseRegex(String str, String str2) {
        String strL = new Regex(str2).l(str, new Function1() { // from class: com.superwall.sdk.misc.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return String_Helpers_ktKt.processCamelCaseRegex$lambda$0((MatchResult) obj);
            }
        });
        if (StringsKt.p0(strL)) {
            return null;
        }
        return strL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence processCamelCaseRegex$lambda$0(MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        MatchGroup matchGroup = matchResult.d().get(1);
        String strB = matchGroup != null ? matchGroup.b() : null;
        MatchGroup matchGroup2 = matchResult.d().get(2);
        return strB + "_" + (matchGroup2 != null ? matchGroup2.b() : null);
    }
}
