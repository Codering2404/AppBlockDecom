package com.revenuecat.purchases.paywalls;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class ColorUtilsKt {
    private static final int ALPHA_MATCH_GROUP_INDEX = 4;
    private static final int ALPHA_SHIFT_BITS = 24;
    private static final String DEFAULT_ALPHA_HEX = "FF";
    private static final int GREEN_SHIFT_BITS = 8;
    private static final int HEX_RADIX = 16;
    private static final int RED_SHIFT_BITS = 16;
    private static final Regex rgbaColorRegex = new Regex("^#([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})?$");

    public static final int colorInt(int i3, int i4, int i5, int i6) {
        return (i3 << 24) | (i4 << 16) | (i5 << 8) | i6;
    }

    public static final int parseRGBAColor(String stringRepresentation) {
        Intrinsics.checkNotNullParameter(stringRepresentation, "stringRepresentation");
        MatchResult matchResultJ = rgbaColorRegex.j(stringRepresentation);
        if (matchResultJ == null) {
            return Color.parseColor(stringRepresentation);
        }
        MatchResult.Destructured destructuredA = matchResultJ.a();
        String str = (String) destructuredA.a().b().get(1);
        String str2 = (String) destructuredA.a().b().get(2);
        String str3 = (String) destructuredA.a().b().get(3);
        Object orNull = CollectionsKt.getOrNull(matchResultJ.b(), 4);
        String str4 = (String) orNull;
        if (str4 == null || StringsKt.p0(str4)) {
            orNull = null;
        }
        String str5 = (String) orNull;
        if (str5 == null) {
            str5 = DEFAULT_ALPHA_HEX;
        }
        return colorInt(Integer.parseInt(str5, CharsKt.checkRadix(16)), Integer.parseInt(str, CharsKt.checkRadix(16)), Integer.parseInt(str2, CharsKt.checkRadix(16)), Integer.parseInt(str3, CharsKt.checkRadix(16)));
    }
}
