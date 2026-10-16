package com.revenuecat.purchases.ui.revenuecatui.helpers;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class LocaleHelpersKt {
    public static final Locale createLocaleFromString(String localeString) {
        Intrinsics.checkNotNullParameter(localeString, "localeString");
        if (!StringsKt.Z(localeString, '-', false, 2, null) && !StringsKt.Z(localeString, '_', false, 2, null)) {
            return new Locale(localeString);
        }
        List listU0 = StringsKt.Z(localeString, '-', false, 2, null) ? StringsKt.U0(localeString, new char[]{'-'}, false, 2, 2, null) : StringsKt.U0(localeString, new char[]{'_'}, false, 2, 2, null);
        return listU0.size() >= 2 ? new Locale((String) listU0.get(0), (String) listU0.get(1)) : new Locale((String) listU0.get(0));
    }
}
