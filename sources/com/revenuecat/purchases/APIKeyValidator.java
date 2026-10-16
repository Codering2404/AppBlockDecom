package com.revenuecat.purchases;

import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.ConfigureStrings;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class APIKeyValidator {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private enum APIKeyPlatform {
        GOOGLE,
        AMAZON,
        GALAXY,
        LEGACY,
        TEST,
        OTHER_PLATFORM
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum ValidationResult {
        VALID,
        GOOGLE_KEY_AMAZON_STORE,
        GOOGLE_KEY_GALAXY_STORE,
        AMAZON_KEY_GOOGLE_STORE,
        AMAZON_KEY_GALAXY_STORE,
        GALAXY_KEY_GOOGLE_STORE,
        GALAXY_KEY_AMAZON_STORE,
        LEGACY,
        SIMULATED_STORE,
        OTHER_PLATFORM
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ValidationResult.values().length];
            try {
                iArr[ValidationResult.AMAZON_KEY_GOOGLE_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ValidationResult.GOOGLE_KEY_AMAZON_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ValidationResult.GALAXY_KEY_GOOGLE_STORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ValidationResult.GOOGLE_KEY_GALAXY_STORE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ValidationResult.GALAXY_KEY_AMAZON_STORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ValidationResult.AMAZON_KEY_GALAXY_STORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ValidationResult.LEGACY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ValidationResult.OTHER_PLATFORM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ValidationResult.SIMULATED_STORE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ValidationResult.VALID.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final APIKeyPlatform getApiKeyPlatform(String str) {
        return StringsKt.U(str, "goog_", false, 2, null) ? APIKeyPlatform.GOOGLE : StringsKt.U(str, "amzn_", false, 2, null) ? APIKeyPlatform.AMAZON : StringsKt.U(str, "galx_", false, 2, null) ? APIKeyPlatform.GALAXY : StringsKt.U(str, "test_", false, 2, null) ? APIKeyPlatform.TEST : !StringsKt.Z(str, '_', false, 2, null) ? APIKeyPlatform.LEGACY : APIKeyPlatform.OTHER_PLATFORM;
    }

    private final void logValidationResult(ValidationResult validationResult) {
        switch (WhenMappings.$EnumSwitchMapping$0[validationResult.ordinal()]) {
            case 1:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.AMAZON_API_KEY_GOOGLE_STORE, null);
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.GOOGLE_API_KEY_AMAZON_STORE, null);
                break;
            case 3:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.GALAXY_API_KEY_GOOGLE_STORE, null);
                break;
            case 4:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.GOOGLE_API_KEY_GALAXY_STORE, null);
                break;
            case 5:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.GALAXY_API_KEY_AMAZON_STORE, null);
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.AMAZON_API_KEY_GALAXY_STORE, null);
                break;
            case 7:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), ConfigureStrings.LEGACY_API_KEY);
                }
                break;
            case 8:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.INVALID_API_KEY, null);
                break;
            case 9:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), ConfigureStrings.SIMULATED_STORE_API_KEY);
                }
                break;
        }
    }

    private final ValidationResult validate(String str, Store store) {
        APIKeyPlatform apiKeyPlatform = getApiKeyPlatform(str);
        if (apiKeyPlatform == APIKeyPlatform.TEST) {
            return ValidationResult.SIMULATED_STORE;
        }
        APIKeyPlatform aPIKeyPlatform = APIKeyPlatform.GOOGLE;
        if (apiKeyPlatform == aPIKeyPlatform && store == Store.PLAY_STORE) {
            return ValidationResult.VALID;
        }
        APIKeyPlatform aPIKeyPlatform2 = APIKeyPlatform.AMAZON;
        if (apiKeyPlatform == aPIKeyPlatform2 && store == Store.AMAZON) {
            return ValidationResult.VALID;
        }
        APIKeyPlatform aPIKeyPlatform3 = APIKeyPlatform.GALAXY;
        return (apiKeyPlatform == aPIKeyPlatform3 && store == Store.GALAXY) ? ValidationResult.VALID : (apiKeyPlatform == aPIKeyPlatform && store == Store.AMAZON) ? ValidationResult.GOOGLE_KEY_AMAZON_STORE : (apiKeyPlatform == aPIKeyPlatform2 && store == Store.PLAY_STORE) ? ValidationResult.AMAZON_KEY_GOOGLE_STORE : (apiKeyPlatform == aPIKeyPlatform && store == Store.GALAXY) ? ValidationResult.GOOGLE_KEY_GALAXY_STORE : (apiKeyPlatform == aPIKeyPlatform3 && store == Store.PLAY_STORE) ? ValidationResult.GALAXY_KEY_GOOGLE_STORE : (apiKeyPlatform == aPIKeyPlatform3 && store == Store.AMAZON) ? ValidationResult.GALAXY_KEY_AMAZON_STORE : (apiKeyPlatform == aPIKeyPlatform2 && store == Store.GALAXY) ? ValidationResult.AMAZON_KEY_GALAXY_STORE : apiKeyPlatform == APIKeyPlatform.LEGACY ? ValidationResult.LEGACY : apiKeyPlatform == APIKeyPlatform.OTHER_PLATFORM ? ValidationResult.OTHER_PLATFORM : ValidationResult.OTHER_PLATFORM;
    }

    public final String redactApiKey(String apiKey) {
        String strB1;
        String strSubstring;
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        int iM0 = StringsKt.m0(apiKey, '_', 0, false, 6, null);
        if (iM0 == -1) {
            strB1 = "";
            strSubstring = apiKey;
        } else {
            int i3 = iM0 + 1;
            strB1 = StringsKt.B1(apiKey, i3);
            strSubstring = apiKey.substring(i3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        }
        if (strSubstring.length() < 6) {
            return apiKey;
        }
        return strB1 + StringsKt.B1(strSubstring, 2) + "********" + StringsKt.C1(strSubstring, 4);
    }

    public final ValidationResult validateAndLog(String apiKey, Store configuredStore) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(configuredStore, "configuredStore");
        ValidationResult validationResultValidate = validate(apiKey, configuredStore);
        logValidationResult(validationResultValidate);
        return validationResultValidate;
    }
}
