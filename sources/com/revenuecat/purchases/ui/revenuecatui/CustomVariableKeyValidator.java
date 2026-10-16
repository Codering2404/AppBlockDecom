package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
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
public final class CustomVariableKeyValidator {
    public static final int $stable = 0;
    public static final CustomVariableKeyValidator INSTANCE = new CustomVariableKeyValidator();

    private CustomVariableKeyValidator() {
    }

    private final boolean isValidKey(String str) {
        if (str.length() > 0 && Character.isLetter(StringsKt.y1(str))) {
            for (int i3 = 0; i3 < str.length(); i3++) {
                char cCharAt = str.charAt(i3);
                if (Character.isLetter(cCharAt) || Character.isDigit(cCharAt) || cCharAt == '_') {
                }
            }
            return true;
        }
        return false;
    }

    public final Map<String, CustomVariableValue> validateAndFilter(Map<String, ? extends CustomVariableValue> variables) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends CustomVariableValue> entry : variables.entrySet()) {
            String key = entry.getKey();
            CustomVariableValue value = entry.getValue();
            if (isValidKey(key)) {
                linkedHashMap.put(key, value);
            } else {
                Logger.INSTANCE.w("Custom variable key '" + key + "' is invalid and will be ignored. Keys must start with a letter and contain only letters, numbers, and underscores.");
            }
        }
        return linkedHashMap;
    }
}
