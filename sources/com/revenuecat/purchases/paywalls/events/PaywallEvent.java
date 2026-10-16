package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.serializers.DateSerializer;
import com.revenuecat.purchases.utils.serializers.UUIDSerializer;
import com.sun.jna.Function;
import java.util.Date;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Serializable
public final class PaywallEvent implements FeatureEvent {
    private final PaywallComponentInteractionData componentInteraction;
    private final CreationData creationData;
    private final Data data;
    private final PaywallEventType type;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, PaywallEventType.Companion.serializer(), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PaywallEvent> serializer() {
            return PaywallEvent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class CreationData {
        public static final Companion Companion = new Companion(null);
        private final Date date;
        private final UUID id;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CreationData> serializer() {
                return PaywallEvent$CreationData$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ CreationData(int i3, @Serializable(with = UUIDSerializer.class) UUID uuid, @Serializable(with = DateSerializer.class) Date date, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, PaywallEvent$CreationData$$serializer.INSTANCE.getDescriptor());
            }
            this.id = uuid;
            this.date = date;
        }

        public static /* synthetic */ CreationData copy$default(CreationData creationData, UUID uuid, Date date, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uuid = creationData.id;
            }
            if ((i3 & 2) != 0) {
                date = creationData.date;
            }
            return creationData.copy(uuid, date);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CreationData creationData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.C(serialDescriptor, 0, UUIDSerializer.INSTANCE, creationData.id);
            compositeEncoder.C(serialDescriptor, 1, DateSerializer.INSTANCE, creationData.date);
        }

        public final UUID component1() {
            return this.id;
        }

        public final Date component2() {
            return this.date;
        }

        public final CreationData copy(UUID id, Date date) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(date, "date");
            return new CreationData(id, date);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CreationData)) {
                return false;
            }
            CreationData creationData = (CreationData) obj;
            return Intrinsics.areEqual(this.id, creationData.id) && Intrinsics.areEqual(this.date, creationData.date);
        }

        public final Date getDate() {
            return this.date;
        }

        public final UUID getId() {
            return this.id;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.date.hashCode();
        }

        public String toString() {
            return "CreationData(id=" + this.id + ", date=" + this.date + ')';
        }

        public CreationData(UUID id, Date date) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(date, "date");
            this.id = id;
            this.date = date;
        }

        @Serializable(with = DateSerializer.class)
        public static /* synthetic */ void getDate$annotations() {
        }

        @Serializable(with = UUIDSerializer.class)
        public static /* synthetic */ void getId$annotations() {
        }
    }

    @Deprecated
    public /* synthetic */ PaywallEvent(int i3, CreationData creationData, Data data, PaywallEventType paywallEventType, PaywallComponentInteractionData paywallComponentInteractionData, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, PaywallEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.creationData = creationData;
        this.data = data;
        this.type = paywallEventType;
        if ((i3 & 8) == 0) {
            this.componentInteraction = null;
        } else {
            this.componentInteraction = paywallComponentInteractionData;
        }
    }

    public static /* synthetic */ PaywallEvent copy$default(PaywallEvent paywallEvent, CreationData creationData, Data data, PaywallEventType paywallEventType, PaywallComponentInteractionData paywallComponentInteractionData, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            creationData = paywallEvent.creationData;
        }
        if ((i3 & 2) != 0) {
            data = paywallEvent.data;
        }
        if ((i3 & 4) != 0) {
            paywallEventType = paywallEvent.type;
        }
        if ((i3 & 8) != 0) {
            paywallComponentInteractionData = paywallEvent.componentInteraction;
        }
        return paywallEvent.copy(creationData, data, paywallEventType, paywallComponentInteractionData);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallEvent paywallEvent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, PaywallEvent$CreationData$$serializer.INSTANCE, paywallEvent.creationData);
        compositeEncoder.C(serialDescriptor, 1, PaywallEventDataSerializer.INSTANCE, paywallEvent.data);
        compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], paywallEvent.type);
        if (!compositeEncoder.z(serialDescriptor, 3) && paywallEvent.componentInteraction == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 3, PaywallComponentInteractionData$$serializer.INSTANCE, paywallEvent.componentInteraction);
    }

    public final CreationData component1() {
        return this.creationData;
    }

    public final Data component2() {
        return this.data;
    }

    public final PaywallEventType component3() {
        return this.type;
    }

    public final PaywallComponentInteractionData component4() {
        return this.componentInteraction;
    }

    public final PaywallEvent copy(CreationData creationData, Data data, PaywallEventType type, PaywallComponentInteractionData paywallComponentInteractionData) {
        Intrinsics.checkNotNullParameter(creationData, "creationData");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(type, "type");
        return new PaywallEvent(creationData, data, type, paywallComponentInteractionData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallEvent)) {
            return false;
        }
        PaywallEvent paywallEvent = (PaywallEvent) obj;
        return Intrinsics.areEqual(this.creationData, paywallEvent.creationData) && Intrinsics.areEqual(this.data, paywallEvent.data) && this.type == paywallEvent.type && Intrinsics.areEqual(this.componentInteraction, paywallEvent.componentInteraction);
    }

    public final PaywallComponentInteractionData getComponentInteraction() {
        return this.componentInteraction;
    }

    public final CreationData getCreationData() {
        return this.creationData;
    }

    public final Data getData() {
        return this.data;
    }

    public final PaywallEventType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((((this.creationData.hashCode() * 31) + this.data.hashCode()) * 31) + this.type.hashCode()) * 31;
        PaywallComponentInteractionData paywallComponentInteractionData = this.componentInteraction;
        return iHashCode + (paywallComponentInteractionData == null ? 0 : paywallComponentInteractionData.hashCode());
    }

    @Override // com.revenuecat.purchases.common.events.FeatureEvent
    public boolean isPriorityEvent() {
        return this.type == PaywallEventType.IMPRESSION;
    }

    public final PaywallPostReceiptData toPaywallPostReceiptData$purchases_defaultsBc8Release() {
        String paywallIdentifier = this.data.getPaywallIdentifier();
        String string = this.data.getSessionIdentifier().toString();
        Intrinsics.checkNotNullExpressionValue(string, "data.sessionIdentifier.toString()");
        return new PaywallPostReceiptData(paywallIdentifier, string, this.data.getPaywallRevision(), this.data.getDisplayMode(), this.data.getDarkMode(), this.data.getLocaleIdentifier(), this.data.getPresentedOfferingContext().getOfferingIdentifier());
    }

    public String toString() {
        return "PaywallEvent(creationData=" + this.creationData + ", data=" + this.data + ", type=" + this.type + ", componentInteraction=" + this.componentInteraction + ')';
    }

    public PaywallEvent(CreationData creationData, Data data, PaywallEventType type, PaywallComponentInteractionData paywallComponentInteractionData) {
        Intrinsics.checkNotNullParameter(creationData, "creationData");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(type, "type");
        this.creationData = creationData;
        this.data = data;
        this.type = type;
        this.componentInteraction = paywallComponentInteractionData;
    }

    public /* synthetic */ PaywallEvent(CreationData creationData, Data data, PaywallEventType paywallEventType, PaywallComponentInteractionData paywallComponentInteractionData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(creationData, data, paywallEventType, (i3 & 8) != 0 ? null : paywallComponentInteractionData);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = PaywallEventDataSerializer.class)
    public static final class Data {
        public static final Companion Companion = new Companion(null);
        private final boolean darkMode;
        private final String displayMode;
        private final Integer errorCode;
        private final String errorMessage;
        private final ExitOfferType exitOfferType;
        private final String exitOfferingIdentifier;
        private final String localeIdentifier;
        private final String packageIdentifier;
        private final String paywallIdentifier;
        private final int paywallRevision;
        private final PresentedOfferingContext presentedOfferingContext;
        private final String productIdentifier;
        private final UUID sessionIdentifier;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Data> serializer() {
                return PaywallEventDataSerializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Data(String str, PresentedOfferingContext presentedOfferingContext, int i3, UUID sessionIdentifier, String displayMode, String localeIdentifier, boolean z2, ExitOfferType exitOfferType, String str2, String str3, String str4, Integer num, String str5) {
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            Intrinsics.checkNotNullParameter(sessionIdentifier, "sessionIdentifier");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            this.paywallIdentifier = str;
            this.presentedOfferingContext = presentedOfferingContext;
            this.paywallRevision = i3;
            this.sessionIdentifier = sessionIdentifier;
            this.displayMode = displayMode;
            this.localeIdentifier = localeIdentifier;
            this.darkMode = z2;
            this.exitOfferType = exitOfferType;
            this.exitOfferingIdentifier = str2;
            this.packageIdentifier = str3;
            this.productIdentifier = str4;
            this.errorCode = num;
            this.errorMessage = str5;
        }

        public static /* synthetic */ Data copy$default(Data data, String str, PresentedOfferingContext presentedOfferingContext, int i3, UUID uuid, String str2, String str3, boolean z2, ExitOfferType exitOfferType, String str4, String str5, String str6, Integer num, String str7, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = data.paywallIdentifier;
            }
            return data.copy(str, (i4 & 2) != 0 ? data.presentedOfferingContext : presentedOfferingContext, (i4 & 4) != 0 ? data.paywallRevision : i3, (i4 & 8) != 0 ? data.sessionIdentifier : uuid, (i4 & 16) != 0 ? data.displayMode : str2, (i4 & 32) != 0 ? data.localeIdentifier : str3, (i4 & 64) != 0 ? data.darkMode : z2, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? data.exitOfferType : exitOfferType, (i4 & Function.MAX_NARGS) != 0 ? data.exitOfferingIdentifier : str4, (i4 & 512) != 0 ? data.packageIdentifier : str5, (i4 & 1024) != 0 ? data.productIdentifier : str6, (i4 & 2048) != 0 ? data.errorCode : num, (i4 & 4096) != 0 ? data.errorMessage : str7);
        }

        public final String component1() {
            return this.paywallIdentifier;
        }

        public final String component10() {
            return this.packageIdentifier;
        }

        public final String component11() {
            return this.productIdentifier;
        }

        public final Integer component12() {
            return this.errorCode;
        }

        public final String component13() {
            return this.errorMessage;
        }

        public final PresentedOfferingContext component2() {
            return this.presentedOfferingContext;
        }

        public final int component3() {
            return this.paywallRevision;
        }

        public final UUID component4() {
            return this.sessionIdentifier;
        }

        public final String component5() {
            return this.displayMode;
        }

        public final String component6() {
            return this.localeIdentifier;
        }

        public final boolean component7() {
            return this.darkMode;
        }

        public final ExitOfferType component8() {
            return this.exitOfferType;
        }

        public final String component9() {
            return this.exitOfferingIdentifier;
        }

        public final Data copy(String str, PresentedOfferingContext presentedOfferingContext, int i3, UUID sessionIdentifier, String displayMode, String localeIdentifier, boolean z2, ExitOfferType exitOfferType, String str2, String str3, String str4, Integer num, String str5) {
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            Intrinsics.checkNotNullParameter(sessionIdentifier, "sessionIdentifier");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            return new Data(str, presentedOfferingContext, i3, sessionIdentifier, displayMode, localeIdentifier, z2, exitOfferType, str2, str3, str4, num, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual(this.paywallIdentifier, data.paywallIdentifier) && Intrinsics.areEqual(this.presentedOfferingContext, data.presentedOfferingContext) && this.paywallRevision == data.paywallRevision && Intrinsics.areEqual(this.sessionIdentifier, data.sessionIdentifier) && Intrinsics.areEqual(this.displayMode, data.displayMode) && Intrinsics.areEqual(this.localeIdentifier, data.localeIdentifier) && this.darkMode == data.darkMode && this.exitOfferType == data.exitOfferType && Intrinsics.areEqual(this.exitOfferingIdentifier, data.exitOfferingIdentifier) && Intrinsics.areEqual(this.packageIdentifier, data.packageIdentifier) && Intrinsics.areEqual(this.productIdentifier, data.productIdentifier) && Intrinsics.areEqual(this.errorCode, data.errorCode) && Intrinsics.areEqual(this.errorMessage, data.errorMessage);
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final String getDisplayMode() {
            return this.displayMode;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final ExitOfferType getExitOfferType() {
            return this.exitOfferType;
        }

        public final String getExitOfferingIdentifier() {
            return this.exitOfferingIdentifier;
        }

        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        public final String getPackageIdentifier() {
            return this.packageIdentifier;
        }

        public final String getPaywallIdentifier() {
            return this.paywallIdentifier;
        }

        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        public final PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        public final UUID getSessionIdentifier() {
            return this.sessionIdentifier;
        }

        public int hashCode() {
            String str = this.paywallIdentifier;
            int iHashCode = (((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.presentedOfferingContext.hashCode()) * 31) + Integer.hashCode(this.paywallRevision)) * 31) + this.sessionIdentifier.hashCode()) * 31) + this.displayMode.hashCode()) * 31) + this.localeIdentifier.hashCode()) * 31) + Boolean.hashCode(this.darkMode)) * 31;
            ExitOfferType exitOfferType = this.exitOfferType;
            int iHashCode2 = (iHashCode + (exitOfferType == null ? 0 : exitOfferType.hashCode())) * 31;
            String str2 = this.exitOfferingIdentifier;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.packageIdentifier;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.productIdentifier;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num = this.errorCode;
            int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            String str5 = this.errorMessage;
            return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "Data(paywallIdentifier=" + this.paywallIdentifier + ", presentedOfferingContext=" + this.presentedOfferingContext + ", paywallRevision=" + this.paywallRevision + ", sessionIdentifier=" + this.sessionIdentifier + ", displayMode=" + this.displayMode + ", localeIdentifier=" + this.localeIdentifier + ", darkMode=" + this.darkMode + ", exitOfferType=" + this.exitOfferType + ", exitOfferingIdentifier=" + this.exitOfferingIdentifier + ", packageIdentifier=" + this.packageIdentifier + ", productIdentifier=" + this.productIdentifier + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ')';
        }

        @Serializable(with = UUIDSerializer.class)
        public static /* synthetic */ void getSessionIdentifier$annotations() {
        }

        public /* synthetic */ Data(String str, PresentedOfferingContext presentedOfferingContext, int i3, UUID uuid, String str2, String str3, boolean z2, ExitOfferType exitOfferType, String str4, String str5, String str6, Integer num, String str7, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, presentedOfferingContext, i3, uuid, str2, str3, z2, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : exitOfferType, (i4 & Function.MAX_NARGS) != 0 ? null : str4, (i4 & 512) != 0 ? null : str5, (i4 & 1024) != 0 ? null : str6, (i4 & 2048) != 0 ? null : num, (i4 & 4096) != 0 ? null : str7);
        }
    }
}
