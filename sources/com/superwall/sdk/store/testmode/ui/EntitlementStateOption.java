package com.superwall.sdk.store.testmode.ui;

import com.superwall.sdk.store.abstractions.product.receipt.LatestSubscriptionState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

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
@Serializable
public final class EntitlementStateOption {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EntitlementStateOption[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final String displayName;
    public static final EntitlementStateOption Inactive = new EntitlementStateOption("Inactive", 0, "Inactive");
    public static final EntitlementStateOption Subscribed = new EntitlementStateOption("Subscribed", 1, "Subscribed");
    public static final EntitlementStateOption InGracePeriod = new EntitlementStateOption("InGracePeriod", 2, "In Grace Period");
    public static final EntitlementStateOption BillingRetry = new EntitlementStateOption("BillingRetry", 3, "Billing Retry");
    public static final EntitlementStateOption Expired = new EntitlementStateOption("Expired", 4, "Expired");
    public static final EntitlementStateOption Revoked = new EntitlementStateOption("Revoked", 5, "Revoked");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) EntitlementStateOption.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<EntitlementStateOption> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EntitlementStateOption.values().length];
            try {
                iArr[EntitlementStateOption.Inactive.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EntitlementStateOption.Subscribed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EntitlementStateOption.InGracePeriod.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EntitlementStateOption.BillingRetry.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EntitlementStateOption.Expired.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EntitlementStateOption.Revoked.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ EntitlementStateOption[] $values() {
        return new EntitlementStateOption[]{Inactive, Subscribed, InGracePeriod, BillingRetry, Expired, Revoked};
    }

    static {
        EntitlementStateOption[] entitlementStateOptionArr$values = $values();
        $VALUES = entitlementStateOptionArr$values;
        $ENTRIES = EnumEntriesKt.a(entitlementStateOptionArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: com.superwall.sdk.store.testmode.ui.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EntitlementStateOption._init_$_anonymous_();
            }
        });
    }

    private EntitlementStateOption(String str, int i3, String str2) {
        this.displayName = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.b("com.superwall.sdk.store.testmode.ui.EntitlementStateOption", values());
    }

    public static EnumEntries<EntitlementStateOption> getEntries() {
        return $ENTRIES;
    }

    public static EntitlementStateOption valueOf(String str) {
        return (EntitlementStateOption) Enum.valueOf(EntitlementStateOption.class, str);
    }

    public static EntitlementStateOption[] values() {
        return (EntitlementStateOption[]) $VALUES.clone();
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final boolean isActive() {
        return this == Subscribed || this == InGracePeriod || this == BillingRetry;
    }

    public final LatestSubscriptionState toSubscriptionState() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return null;
            case 2:
                return LatestSubscriptionState.SUBSCRIBED;
            case 3:
                return LatestSubscriptionState.GRACE_PERIOD;
            case 4:
                return LatestSubscriptionState.BILLING_RETRY;
            case 5:
                return LatestSubscriptionState.EXPIRED;
            case 6:
                return LatestSubscriptionState.REVOKED;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
