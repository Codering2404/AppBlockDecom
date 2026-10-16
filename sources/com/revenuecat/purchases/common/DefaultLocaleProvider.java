package com.revenuecat.purchases.common;

import androidx.core.os.LocaleListCompat;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class DefaultLocaleProvider implements LocaleProvider {
    private String preferredLocaleOverride;

    @Override // com.revenuecat.purchases.common.LocaleProvider
    public String getCurrentLocalesLanguageTags() {
        String str = this.preferredLocaleOverride;
        if (str != null) {
            String strI = LocaleListCompat.e().i();
            Intrinsics.checkNotNullExpressionValue(strI, "getDefault().toLanguageTags()");
            if (strI.length() != 0) {
                str = str + ',' + strI;
            }
            if (str != null) {
                return str;
            }
        }
        String strI2 = LocaleListCompat.e().i();
        Intrinsics.checkNotNullExpressionValue(strI2, "getDefault().toLanguageTags()");
        return strI2;
    }

    public final void setPreferredLocaleOverride(String str) {
        this.preferredLocaleOverride = str;
    }
}
