package com.revenuecat.purchases.strings;

import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.Store;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class OfferingStringsKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.PLAY_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Store.AMAZON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Store.GALAXY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[APIKeyValidator.ValidationResult.values().length];
            try {
                iArr2[APIKeyValidator.ValidationResult.VALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.SIMULATED_STORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.OTHER_PLATFORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.GOOGLE_KEY_AMAZON_STORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.AMAZON_KEY_GOOGLE_STORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.GOOGLE_KEY_GALAXY_STORE.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.GALAXY_KEY_GOOGLE_STORE.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.GALAXY_KEY_AMAZON_STORE.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.AMAZON_KEY_GALAXY_STORE.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indefiniteArticle(APIKeyValidator.ValidationResult validationResult, Store store) {
        switch (WhenMappings.$EnumSwitchMapping$1[validationResult.ordinal()]) {
            case 1:
                int i3 = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
                return (i3 == 1 || i3 != 2) ? "a" : "an";
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return "a";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String storeNameForLogging(APIKeyValidator.ValidationResult validationResult, Store store) {
        switch (WhenMappings.$EnumSwitchMapping$1[validationResult.ordinal()]) {
            case 1:
                int i3 = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
                if (i3 == 1) {
                    return "Play Store";
                }
                if (i3 == 2) {
                    return "Amazon Appstore";
                }
                if (i3 != 3) {
                    return null;
                }
                return "Galaxy Store";
            case 2:
                return "Play Store";
            case 3:
                return "Test Store";
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
