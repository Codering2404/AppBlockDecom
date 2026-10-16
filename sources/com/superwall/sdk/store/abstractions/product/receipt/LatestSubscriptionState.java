package com.superwall.sdk.store.abstractions.product.receipt;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
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
public final class LatestSubscriptionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LatestSubscriptionState[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;

    @SerialName
    public static final LatestSubscriptionState GRACE_PERIOD = new LatestSubscriptionState("GRACE_PERIOD", 0);

    @SerialName
    public static final LatestSubscriptionState EXPIRED = new LatestSubscriptionState("EXPIRED", 1);

    @SerialName
    public static final LatestSubscriptionState SUBSCRIBED = new LatestSubscriptionState("SUBSCRIBED", 2);

    @SerialName
    public static final LatestSubscriptionState BILLING_RETRY = new LatestSubscriptionState("BILLING_RETRY", 3);

    @SerialName
    public static final LatestSubscriptionState REVOKED = new LatestSubscriptionState("REVOKED", 4);

    @SerialName
    public static final LatestSubscriptionState UNKNOWN = new LatestSubscriptionState("UNKNOWN", 5);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) LatestSubscriptionState.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<LatestSubscriptionState> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ LatestSubscriptionState[] $values() {
        return new LatestSubscriptionState[]{GRACE_PERIOD, EXPIRED, SUBSCRIBED, BILLING_RETRY, REVOKED, UNKNOWN};
    }

    static {
        LatestSubscriptionState[] latestSubscriptionStateArr$values = $values();
        $VALUES = latestSubscriptionStateArr$values;
        $ENTRIES = EnumEntriesKt.a(latestSubscriptionStateArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: com.superwall.sdk.store.abstractions.product.receipt.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LatestSubscriptionState._init_$_anonymous_();
            }
        });
    }

    private LatestSubscriptionState(String str, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.a("com.superwall.sdk.store.abstractions.product.receipt.LatestSubscriptionState", values(), new String[]{"grace_period", "expired", "subscribed", "billing_retry", "revoked", "unknown"}, new Annotation[][]{null, null, null, null, null, null}, null);
    }

    public static EnumEntries<LatestSubscriptionState> getEntries() {
        return $ENTRIES;
    }

    public static LatestSubscriptionState valueOf(String str) {
        return (LatestSubscriptionState) Enum.valueOf(LatestSubscriptionState.class, str);
    }

    public static LatestSubscriptionState[] values() {
        return (LatestSubscriptionState[]) $VALUES.clone();
    }
}
