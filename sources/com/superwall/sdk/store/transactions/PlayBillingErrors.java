package com.superwall.sdk.store.transactions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PlayBillingErrors {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PlayBillingErrors[] $VALUES;
    public static final Companion Companion;
    private final int code;
    private final String message;
    public static final PlayBillingErrors NETWORK_ERROR = new PlayBillingErrors("NETWORK_ERROR", 0, 12, "There was a problem with the network connection. Please check your connection and try again.");
    public static final PlayBillingErrors SERVICE_TIMEOUT = new PlayBillingErrors("SERVICE_TIMEOUT", 1, -3, "The request timed out. This is usually a temporary issue. Please try again.");
    public static final PlayBillingErrors SERVICE_DISCONNECTED = new PlayBillingErrors("SERVICE_DISCONNECTED", 2, -1, "The connection to the Google Play Store was lost. We are attempting to reconnect. Please try again in a few moments.");
    public static final PlayBillingErrors FEATURE_NOT_SUPPORTED = new PlayBillingErrors("FEATURE_NOT_SUPPORTED", 3, -2, "The requested feature is not supported on your device. You may need to update the Play Store app.");
    public static final PlayBillingErrors SERVICE_UNAVAILABLE = new PlayBillingErrors("SERVICE_UNAVAILABLE", 4, 2, "The Google Play Billing service is currently unavailable. This may be a temporary network issue. Please try again.");
    public static final PlayBillingErrors BILLING_UNAVAILABLE = new PlayBillingErrors("BILLING_UNAVAILABLE", 5, 3, "Billing is unavailable. This could be because the Play Store app is not available, you're in an unsupported country, or there's an issue with your payment method. Please check your Google Play account and try again.");
    public static final PlayBillingErrors USER_CANCELED = new PlayBillingErrors("USER_CANCELED", 6, 1, "You have canceled the purchase.");
    public static final PlayBillingErrors ITEM_UNAVAILABLE = new PlayBillingErrors("ITEM_UNAVAILABLE", 7, 4, "This item is not available for purchase. It may not be available in your country or the item is no longer for sale.");
    public static final PlayBillingErrors DEVELOPER_ERROR = new PlayBillingErrors("DEVELOPER_ERROR", 8, 5, "A developer error occurred. Please check the app's configuration.");
    public static final PlayBillingErrors ERROR = new PlayBillingErrors("ERROR", 9, 6, "An internal error occurred in the Google Play Store. This might be a temporary issue. Please try again later.");
    public static final PlayBillingErrors ITEM_ALREADY_OWNED = new PlayBillingErrors("ITEM_ALREADY_OWNED", 10, 7, "You already own this item. If you don't see your purchase, please check your purchase history in the Play Store.");
    public static final PlayBillingErrors ITEM_NOT_OWNED = new PlayBillingErrors("ITEM_NOT_OWNED", 11, 8, "You do not own the item you are trying to manage. Please check your purchase history in the Play Store.");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayBillingErrors fromCode(int i3) {
            for (PlayBillingErrors playBillingErrors : PlayBillingErrors.values()) {
                if (playBillingErrors.getCode() == i3) {
                    return playBillingErrors;
                }
            }
            return null;
        }

        private Companion() {
        }

        public final PlayBillingErrors fromCode(String str) {
            Integer numU;
            if (str == null || (numU = StringsKt.u(str)) == null) {
                return null;
            }
            return fromCode(numU.intValue());
        }
    }

    private static final /* synthetic */ PlayBillingErrors[] $values() {
        return new PlayBillingErrors[]{NETWORK_ERROR, SERVICE_TIMEOUT, SERVICE_DISCONNECTED, FEATURE_NOT_SUPPORTED, SERVICE_UNAVAILABLE, BILLING_UNAVAILABLE, USER_CANCELED, ITEM_UNAVAILABLE, DEVELOPER_ERROR, ERROR, ITEM_ALREADY_OWNED, ITEM_NOT_OWNED};
    }

    static {
        PlayBillingErrors[] playBillingErrorsArr$values = $values();
        $VALUES = playBillingErrorsArr$values;
        $ENTRIES = EnumEntriesKt.a(playBillingErrorsArr$values);
        Companion = new Companion(null);
    }

    private PlayBillingErrors(String str, int i3, int i4, String str2) {
        this.code = i4;
        this.message = str2;
    }

    public static EnumEntries<PlayBillingErrors> getEntries() {
        return $ENTRIES;
    }

    public static PlayBillingErrors valueOf(String str) {
        return (PlayBillingErrors) Enum.valueOf(PlayBillingErrors.class, str);
    }

    public static PlayBillingErrors[] values() {
        return (PlayBillingErrors[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }
}
