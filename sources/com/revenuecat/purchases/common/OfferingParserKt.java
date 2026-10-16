package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PackageType;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

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
public final class OfferingParserKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final URL getWebCheckoutURL(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("web_checkout_url");
        if (strOptString == null || strOptString.length() == 0) {
            strOptString = null;
        }
        if (strOptString == null) {
            return null;
        }
        try {
            return new URL(strOptString);
        } catch (MalformedURLException e3) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing web checkout URL: " + strOptString, e3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageType toPackageType(String str) {
        PackageType packageType;
        PackageType[] packageTypeArrValues = PackageType.values();
        int length = packageTypeArrValues.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                packageType = null;
                break;
            }
            packageType = packageTypeArrValues[i3];
            if (Intrinsics.areEqual(packageType.getIdentifier(), str)) {
                break;
            }
            i3++;
        }
        return packageType == null ? StringsKt.U(str, "$rc_", false, 2, null) ? PackageType.UNKNOWN : PackageType.CUSTOM : packageType;
    }
}
