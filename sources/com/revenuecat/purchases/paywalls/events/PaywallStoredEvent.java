package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.utils.Event;
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
import kotlinx.serialization.json.Json;

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
public final class PaywallStoredEvent implements Event {
    public static final Companion Companion = new Companion(null);
    private static final Json.Default json = Json.f142959d;
    private final PaywallEvent event;
    private final String userID;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaywallStoredEvent fromString(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            Json.Default json = getJson();
            json.a();
            return (PaywallStoredEvent) json.d(PaywallStoredEvent.Companion.serializer(), string);
        }

        public final Json.Default getJson() {
            return PaywallStoredEvent.json;
        }

        public final KSerializer<PaywallStoredEvent> serializer() {
            return PaywallStoredEvent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ PaywallStoredEvent(int i3, PaywallEvent paywallEvent, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, PaywallStoredEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.event = paywallEvent;
        this.userID = str;
    }

    public static /* synthetic */ PaywallStoredEvent copy$default(PaywallStoredEvent paywallStoredEvent, PaywallEvent paywallEvent, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            paywallEvent = paywallStoredEvent.event;
        }
        if ((i3 & 2) != 0) {
            str = paywallStoredEvent.userID;
        }
        return paywallStoredEvent.copy(paywallEvent, str);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallStoredEvent paywallStoredEvent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, PaywallEvent$$serializer.INSTANCE, paywallStoredEvent.event);
        compositeEncoder.y(serialDescriptor, 1, paywallStoredEvent.userID);
    }

    public final PaywallEvent component1() {
        return this.event;
    }

    public final String component2() {
        return this.userID;
    }

    public final PaywallStoredEvent copy(PaywallEvent event, String userID) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(userID, "userID");
        return new PaywallStoredEvent(event, userID);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallStoredEvent)) {
            return false;
        }
        PaywallStoredEvent paywallStoredEvent = (PaywallStoredEvent) obj;
        return Intrinsics.areEqual(this.event, paywallStoredEvent.event) && Intrinsics.areEqual(this.userID, paywallStoredEvent.userID);
    }

    public final PaywallEvent getEvent() {
        return this.event;
    }

    public final String getUserID() {
        return this.userID;
    }

    public int hashCode() {
        return (this.event.hashCode() * 31) + this.userID.hashCode();
    }

    public final BackendEvent.Paywalls toBackendEvent() {
        BackendPaywallComponentFields backendComponentFields = PaywallEventKt.toBackendComponentFields(this.event.getComponentInteraction());
        String string = this.event.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "event.creationData.id.toString()");
        String value = this.event.getType().getValue();
        String str = this.userID;
        String string2 = this.event.getData().getSessionIdentifier().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "event.data.sessionIdentifier.toString()");
        String offeringIdentifier = this.event.getData().getPresentedOfferingContext().getOfferingIdentifier();
        String paywallIdentifier = this.event.getData().getPaywallIdentifier();
        int paywallRevision = this.event.getData().getPaywallRevision();
        long time = this.event.getCreationData().getDate().getTime();
        String displayMode = this.event.getData().getDisplayMode();
        boolean darkMode = this.event.getData().getDarkMode();
        String localeIdentifier = this.event.getData().getLocaleIdentifier();
        BackendEvent.PresentedOfferingContextData presentedOfferingContextDataFromContext = BackendEvent.PresentedOfferingContextData.Companion.fromContext(this.event.getData().getPresentedOfferingContext());
        ExitOfferType exitOfferType = this.event.getData().getExitOfferType();
        return new BackendEvent.Paywalls(string, 1, value, str, string2, offeringIdentifier, paywallIdentifier, paywallRevision, time, displayMode, darkMode, localeIdentifier, presentedOfferingContextDataFromContext, exitOfferType != null ? exitOfferType.getValue() : null, this.event.getData().getExitOfferingIdentifier(), this.event.getData().getPackageIdentifier(), this.event.getData().getProductIdentifier(), this.event.getData().getErrorCode(), this.event.getData().getErrorMessage(), backendComponentFields.getComponentType(), backendComponentFields.getComponentName(), backendComponentFields.getComponentValue(), backendComponentFields.getComponentUrl(), backendComponentFields.getOriginIndex(), backendComponentFields.getDestinationIndex(), backendComponentFields.getOriginContextName(), backendComponentFields.getDestinationContextName(), backendComponentFields.getDefaultIndex(), backendComponentFields.getOriginPackageIdentifier(), backendComponentFields.getDestinationPackageIdentifier(), backendComponentFields.getDefaultPackageIdentifier(), backendComponentFields.getOriginProductIdentifier(), backendComponentFields.getDestinationProductIdentifier(), backendComponentFields.getDefaultProductIdentifier(), backendComponentFields.getCurrentPackageIdentifier(), backendComponentFields.getResultingPackageIdentifier(), backendComponentFields.getCurrentProductIdentifier(), backendComponentFields.getResultingProductIdentifier());
    }

    @Override // com.revenuecat.purchases.utils.Event
    public String toString() {
        Json.Default r02 = json;
        r02.a();
        return r02.b(Companion.serializer(), this);
    }

    public PaywallStoredEvent(PaywallEvent event, String userID) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(userID, "userID");
        this.event = event;
        this.userID = userID;
    }
}
