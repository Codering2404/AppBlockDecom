package com.superwall.sdk.models.entitlements;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.product.Store;
import com.superwall.sdk.models.product.StoreSerializer;
import com.superwall.sdk.models.serialization.DateSerializer;
import com.superwall.sdk.store.abstractions.product.receipt.LatestPeriodType;
import com.superwall.sdk.store.abstractions.product.receipt.LatestSubscriptionState;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
public final class Entitlement {
    private final Date expiresAt;
    private final String id;
    private final boolean isActive;
    private final Boolean isLifetime;
    private final String latestProductId;
    private final LatestPeriodType offerType;
    private final Set<String> productIds;
    private final Date renewedAt;
    private final Date startsAt;
    private final LatestSubscriptionState state;
    private final Store store;
    private final Type type;
    private final Boolean willRenew;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, Type.Companion.serializer(), null, new LinkedHashSetSerializer(StringSerializer.f142891a), null, null, null, null, null, null, LatestSubscriptionState.Companion.serializer(), LatestPeriodType.Companion.serializer(), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Entitlement> serializer() {
            return Entitlement$$serializer.INSTANCE;
        }

        public final Entitlement stub() {
            return new Entitlement("test", Type.SERVICE_LEVEL);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
        public static final Companion Companion;

        @SerialName
        public static final Type SERVICE_LEVEL = new Type("SERVICE_LEVEL", 0, "SERVICE_LEVEL");
        private final String raw;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) Type.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Type> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{SERVICE_LEVEL};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.a(typeArr$values);
            Companion = new Companion(null);
            $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: e0.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Entitlement.Type._init_$_anonymous_();
                }
            });
        }

        private Type(String str, int i3, String str2) {
            this.raw = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.a("com.superwall.sdk.models.entitlements.Entitlement.Type", values(), new String[]{"SERVICE_LEVEL"}, new Annotation[][]{null}, null);
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final String getRaw() {
            return this.raw;
        }
    }

    public /* synthetic */ Entitlement(int i3, String str, Type type, boolean z2, Set set, String str2, Date date, Date date2, Date date3, Boolean bool, Boolean bool2, LatestSubscriptionState latestSubscriptionState, LatestPeriodType latestPeriodType, Store store, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, Entitlement$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        if ((i3 & 2) == 0) {
            this.type = Type.SERVICE_LEVEL;
        } else {
            this.type = type;
        }
        if ((i3 & 4) == 0) {
            this.isActive = false;
        } else {
            this.isActive = z2;
        }
        if ((i3 & 8) == 0) {
            this.productIds = SetsKt.emptySet();
        } else {
            this.productIds = set;
        }
        if ((i3 & 16) == 0) {
            this.latestProductId = null;
        } else {
            this.latestProductId = str2;
        }
        if ((i3 & 32) == 0) {
            this.startsAt = null;
        } else {
            this.startsAt = date;
        }
        if ((i3 & 64) == 0) {
            this.renewedAt = null;
        } else {
            this.renewedAt = date2;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.expiresAt = null;
        } else {
            this.expiresAt = date3;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.isLifetime = null;
        } else {
            this.isLifetime = bool;
        }
        if ((i3 & 512) == 0) {
            this.willRenew = null;
        } else {
            this.willRenew = bool2;
        }
        if ((i3 & 1024) == 0) {
            this.state = null;
        } else {
            this.state = latestSubscriptionState;
        }
        if ((i3 & 2048) == 0) {
            this.offerType = null;
        } else {
            this.offerType = latestPeriodType;
        }
        if ((i3 & 4096) == 0) {
            this.store = null;
        } else {
            this.store = store;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Entitlement copy$default(Entitlement entitlement, String str, Type type, boolean z2, Set set, String str2, Date date, Date date2, Date date3, Boolean bool, Boolean bool2, LatestSubscriptionState latestSubscriptionState, LatestPeriodType latestPeriodType, Store store, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = entitlement.id;
        }
        return entitlement.copy(str, (i3 & 2) != 0 ? entitlement.type : type, (i3 & 4) != 0 ? entitlement.isActive : z2, (i3 & 8) != 0 ? entitlement.productIds : set, (i3 & 16) != 0 ? entitlement.latestProductId : str2, (i3 & 32) != 0 ? entitlement.startsAt : date, (i3 & 64) != 0 ? entitlement.renewedAt : date2, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? entitlement.expiresAt : date3, (i3 & Function.MAX_NARGS) != 0 ? entitlement.isLifetime : bool, (i3 & 512) != 0 ? entitlement.willRenew : bool2, (i3 & 1024) != 0 ? entitlement.state : latestSubscriptionState, (i3 & 2048) != 0 ? entitlement.offerType : latestPeriodType, (i3 & 4096) != 0 ? entitlement.store : store);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(Entitlement entitlement, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, entitlement.id);
        if (compositeEncoder.z(serialDescriptor, 1) || entitlement.type != Type.SERVICE_LEVEL) {
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], entitlement.type);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || entitlement.isActive) {
            compositeEncoder.x(serialDescriptor, 2, entitlement.isActive);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || !Intrinsics.areEqual(entitlement.productIds, SetsKt.emptySet())) {
            compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], entitlement.productIds);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || entitlement.latestProductId != null) {
            compositeEncoder.i(serialDescriptor, 4, StringSerializer.f142891a, entitlement.latestProductId);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || entitlement.startsAt != null) {
            compositeEncoder.i(serialDescriptor, 5, DateSerializer.INSTANCE, entitlement.startsAt);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || entitlement.renewedAt != null) {
            compositeEncoder.i(serialDescriptor, 6, DateSerializer.INSTANCE, entitlement.renewedAt);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || entitlement.expiresAt != null) {
            compositeEncoder.i(serialDescriptor, 7, DateSerializer.INSTANCE, entitlement.expiresAt);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || entitlement.isLifetime != null) {
            compositeEncoder.i(serialDescriptor, 8, BooleanSerializer.f142767a, entitlement.isLifetime);
        }
        if (compositeEncoder.z(serialDescriptor, 9) || entitlement.willRenew != null) {
            compositeEncoder.i(serialDescriptor, 9, BooleanSerializer.f142767a, entitlement.willRenew);
        }
        if (compositeEncoder.z(serialDescriptor, 10) || entitlement.state != null) {
            compositeEncoder.i(serialDescriptor, 10, kSerializerArr[10], entitlement.state);
        }
        if (compositeEncoder.z(serialDescriptor, 11) || entitlement.offerType != null) {
            compositeEncoder.i(serialDescriptor, 11, kSerializerArr[11], entitlement.offerType);
        }
        if (!compositeEncoder.z(serialDescriptor, 12) && entitlement.store == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 12, StoreSerializer.INSTANCE, entitlement.store);
    }

    public final String component1() {
        return this.id;
    }

    public final Boolean component10() {
        return this.willRenew;
    }

    public final LatestSubscriptionState component11() {
        return this.state;
    }

    public final LatestPeriodType component12() {
        return this.offerType;
    }

    public final Store component13() {
        return this.store;
    }

    public final Type component2() {
        return this.type;
    }

    public final boolean component3() {
        return this.isActive;
    }

    public final Set<String> component4() {
        return this.productIds;
    }

    public final String component5() {
        return this.latestProductId;
    }

    public final Date component6() {
        return this.startsAt;
    }

    public final Date component7() {
        return this.renewedAt;
    }

    public final Date component8() {
        return this.expiresAt;
    }

    public final Boolean component9() {
        return this.isLifetime;
    }

    public final Entitlement copy(String id, Type type, boolean z2, Set<String> productIds, String str, Date date, Date date2, Date date3, Boolean bool, Boolean bool2, LatestSubscriptionState latestSubscriptionState, LatestPeriodType latestPeriodType, Store store) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        return new Entitlement(id, type, z2, productIds, str, date, date2, date3, bool, bool2, latestSubscriptionState, latestPeriodType, store);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Entitlement)) {
            return false;
        }
        Entitlement entitlement = (Entitlement) obj;
        return Intrinsics.areEqual(this.id, entitlement.id) && this.type == entitlement.type && this.isActive == entitlement.isActive && Intrinsics.areEqual(this.productIds, entitlement.productIds) && Intrinsics.areEqual(this.latestProductId, entitlement.latestProductId) && Intrinsics.areEqual(this.startsAt, entitlement.startsAt) && Intrinsics.areEqual(this.renewedAt, entitlement.renewedAt) && Intrinsics.areEqual(this.expiresAt, entitlement.expiresAt) && Intrinsics.areEqual(this.isLifetime, entitlement.isLifetime) && Intrinsics.areEqual(this.willRenew, entitlement.willRenew) && this.state == entitlement.state && this.offerType == entitlement.offerType && this.store == entitlement.store;
    }

    public final Date getExpiresAt() {
        return this.expiresAt;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLatestProductId() {
        return this.latestProductId;
    }

    public final LatestPeriodType getOfferType() {
        return this.offerType;
    }

    public final Set<String> getProductIds() {
        return this.productIds;
    }

    public final Date getRenewedAt() {
        return this.renewedAt;
    }

    public final Date getRenewsAt() {
        if (this.isActive && Intrinsics.areEqual(this.willRenew, Boolean.TRUE)) {
            return this.expiresAt;
        }
        return null;
    }

    public final Date getStartsAt() {
        return this.startsAt;
    }

    public final LatestSubscriptionState getState() {
        return this.state;
    }

    public final Store getStore() {
        return this.store;
    }

    public final Type getType() {
        return this.type;
    }

    public final Boolean getWillRenew() {
        return this.willRenew;
    }

    public int hashCode() {
        int iHashCode = ((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.isActive)) * 31) + this.productIds.hashCode()) * 31;
        String str = this.latestProductId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Date date = this.startsAt;
        int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.renewedAt;
        int iHashCode4 = (iHashCode3 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Date date3 = this.expiresAt;
        int iHashCode5 = (iHashCode4 + (date3 == null ? 0 : date3.hashCode())) * 31;
        Boolean bool = this.isLifetime;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.willRenew;
        int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        LatestSubscriptionState latestSubscriptionState = this.state;
        int iHashCode8 = (iHashCode7 + (latestSubscriptionState == null ? 0 : latestSubscriptionState.hashCode())) * 31;
        LatestPeriodType latestPeriodType = this.offerType;
        int iHashCode9 = (iHashCode8 + (latestPeriodType == null ? 0 : latestPeriodType.hashCode())) * 31;
        Store store = this.store;
        return iHashCode9 + (store != null ? store.hashCode() : 0);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isDistinct(Entitlement other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return (Intrinsics.areEqual(this.id, other.id) && this.type == other.type && this.isActive == other.isActive && Intrinsics.areEqual(this.startsAt, other.startsAt) && Intrinsics.areEqual(this.renewedAt, other.renewedAt) && Intrinsics.areEqual(this.expiresAt, other.expiresAt) && Intrinsics.areEqual(this.isLifetime, other.isLifetime) && Intrinsics.areEqual(this.willRenew, other.willRenew) && this.state == other.state && this.offerType == other.offerType && this.store == other.store) ? false : true;
    }

    public final Boolean isInGracePeriod() {
        LatestSubscriptionState latestSubscriptionState = this.state;
        if (latestSubscriptionState != null) {
            return Boolean.valueOf(latestSubscriptionState == LatestSubscriptionState.GRACE_PERIOD);
        }
        return null;
    }

    public final Boolean isLifetime() {
        return this.isLifetime;
    }

    public final Boolean isRevoked() {
        return null;
    }

    public String toString() {
        return "Entitlement(id=" + this.id + ", type=" + this.type + ", isActive=" + this.isActive + ", productIds=" + this.productIds + ", latestProductId=" + this.latestProductId + ", startsAt=" + this.startsAt + ", renewedAt=" + this.renewedAt + ", expiresAt=" + this.expiresAt + ", isLifetime=" + this.isLifetime + ", willRenew=" + this.willRenew + ", state=" + this.state + ", offerType=" + this.offerType + ", store=" + this.store + ")";
    }

    public Entitlement(String id, Type type, boolean z2, Set<String> productIds, String str, Date date, Date date2, Date date3, Boolean bool, Boolean bool2, LatestSubscriptionState latestSubscriptionState, LatestPeriodType latestPeriodType, Store store) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        this.id = id;
        this.type = type;
        this.isActive = z2;
        this.productIds = productIds;
        this.latestProductId = str;
        this.startsAt = date;
        this.renewedAt = date2;
        this.expiresAt = date3;
        this.isLifetime = bool;
        this.willRenew = bool2;
        this.state = latestSubscriptionState;
        this.offerType = latestPeriodType;
        this.store = store;
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getExpiresAt$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getLatestProductId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getOfferType$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProductIds$annotations() {
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getRenewedAt$annotations() {
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getStartsAt$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getState$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getStore$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getWillRenew$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isActive$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isLifetime$annotations() {
    }

    public /* synthetic */ Entitlement(String str, Type type, boolean z2, Set set, String str2, Date date, Date date2, Date date3, Boolean bool, Boolean bool2, LatestSubscriptionState latestSubscriptionState, LatestPeriodType latestPeriodType, Store store, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? Type.SERVICE_LEVEL : type, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? SetsKt.emptySet() : set, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : date, (i3 & 64) != 0 ? null : date2, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : date3, (i3 & Function.MAX_NARGS) != 0 ? null : bool, (i3 & 512) != 0 ? null : bool2, (i3 & 1024) != 0 ? null : latestSubscriptionState, (i3 & 2048) != 0 ? null : latestPeriodType, (i3 & 4096) != 0 ? null : store);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Entitlement(String id) {
        this(id, Type.SERVICE_LEVEL, true, (Set) null, (String) null, (Date) null, (Date) null, (Date) null, (Boolean) null, (Boolean) null, (LatestSubscriptionState) null, (LatestPeriodType) null, (Store) null, 8184, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(id, "id");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Entitlement(String id, Type type) {
        this(id, type, true, (Set) null, (String) null, (Date) null, (Date) null, (Date) null, (Boolean) null, (Boolean) null, (LatestSubscriptionState) null, (LatestPeriodType) null, (Store) null, 8184, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
    }
}
