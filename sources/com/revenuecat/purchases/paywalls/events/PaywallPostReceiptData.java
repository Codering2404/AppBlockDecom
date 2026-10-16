package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.utils.JsonElementExtensionsKt;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
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
public final class PaywallPostReceiptData {
    public static final Companion Companion = new Companion(null);
    private static final Json.Default json = Json.f142959d;
    private final boolean darkMode;
    private final String displayMode;
    private final String localeIdentifier;
    private final String offeringId;
    private final String paywallID;
    private final int revision;
    private final String sessionID;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Json.Default getJson() {
            return PaywallPostReceiptData.json;
        }

        public final KSerializer<PaywallPostReceiptData> serializer() {
            return PaywallPostReceiptData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ PaywallPostReceiptData(int i3, @SerialName String str, @SerialName String str2, @SerialName int i4, @SerialName String str3, @SerialName boolean z2, @SerialName String str4, @SerialName String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i3 & 127)) {
            PluginExceptionsKt.b(i3, 127, PaywallPostReceiptData$$serializer.INSTANCE.getDescriptor());
        }
        this.paywallID = str;
        this.sessionID = str2;
        this.revision = i4;
        this.displayMode = str3;
        this.darkMode = z2;
        this.localeIdentifier = str4;
        this.offeringId = str5;
    }

    public static /* synthetic */ PaywallPostReceiptData copy$default(PaywallPostReceiptData paywallPostReceiptData, String str, String str2, int i3, String str3, boolean z2, String str4, String str5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = paywallPostReceiptData.paywallID;
        }
        if ((i4 & 2) != 0) {
            str2 = paywallPostReceiptData.sessionID;
        }
        if ((i4 & 4) != 0) {
            i3 = paywallPostReceiptData.revision;
        }
        if ((i4 & 8) != 0) {
            str3 = paywallPostReceiptData.displayMode;
        }
        if ((i4 & 16) != 0) {
            z2 = paywallPostReceiptData.darkMode;
        }
        if ((i4 & 32) != 0) {
            str4 = paywallPostReceiptData.localeIdentifier;
        }
        if ((i4 & 64) != 0) {
            str5 = paywallPostReceiptData.offeringId;
        }
        String str6 = str4;
        String str7 = str5;
        boolean z3 = z2;
        int i5 = i3;
        return paywallPostReceiptData.copy(str, str2, i5, str3, z3, str6, str7);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallPostReceiptData paywallPostReceiptData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.i(serialDescriptor, 0, StringSerializer.f142891a, paywallPostReceiptData.paywallID);
        compositeEncoder.y(serialDescriptor, 1, paywallPostReceiptData.sessionID);
        compositeEncoder.w(serialDescriptor, 2, paywallPostReceiptData.revision);
        compositeEncoder.y(serialDescriptor, 3, paywallPostReceiptData.displayMode);
        compositeEncoder.x(serialDescriptor, 4, paywallPostReceiptData.darkMode);
        compositeEncoder.y(serialDescriptor, 5, paywallPostReceiptData.localeIdentifier);
        compositeEncoder.y(serialDescriptor, 6, paywallPostReceiptData.offeringId);
    }

    public final String component1() {
        return this.paywallID;
    }

    public final String component2() {
        return this.sessionID;
    }

    public final int component3() {
        return this.revision;
    }

    public final String component4() {
        return this.displayMode;
    }

    public final boolean component5() {
        return this.darkMode;
    }

    public final String component6() {
        return this.localeIdentifier;
    }

    public final String component7() {
        return this.offeringId;
    }

    public final PaywallPostReceiptData copy(String str, String sessionID, int i3, String displayMode, boolean z2, String localeIdentifier, String offeringId) {
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        return new PaywallPostReceiptData(str, sessionID, i3, displayMode, z2, localeIdentifier, offeringId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallPostReceiptData)) {
            return false;
        }
        PaywallPostReceiptData paywallPostReceiptData = (PaywallPostReceiptData) obj;
        return Intrinsics.areEqual(this.paywallID, paywallPostReceiptData.paywallID) && Intrinsics.areEqual(this.sessionID, paywallPostReceiptData.sessionID) && this.revision == paywallPostReceiptData.revision && Intrinsics.areEqual(this.displayMode, paywallPostReceiptData.displayMode) && this.darkMode == paywallPostReceiptData.darkMode && Intrinsics.areEqual(this.localeIdentifier, paywallPostReceiptData.localeIdentifier) && Intrinsics.areEqual(this.offeringId, paywallPostReceiptData.offeringId);
    }

    public final boolean getDarkMode() {
        return this.darkMode;
    }

    public final String getDisplayMode() {
        return this.displayMode;
    }

    public final String getLocaleIdentifier() {
        return this.localeIdentifier;
    }

    public final String getOfferingId() {
        return this.offeringId;
    }

    public final String getPaywallID() {
        return this.paywallID;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final String getSessionID() {
        return this.sessionID;
    }

    public int hashCode() {
        String str = this.paywallID;
        return ((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.sessionID.hashCode()) * 31) + Integer.hashCode(this.revision)) * 31) + this.displayMode.hashCode()) * 31) + Boolean.hashCode(this.darkMode)) * 31) + this.localeIdentifier.hashCode()) * 31) + this.offeringId.hashCode();
    }

    public final Map<String, Object> toMap() {
        Json.Default r02 = json;
        r02.a();
        Map<String, Object> mapAsMap = JsonElementExtensionsKt.asMap(r02.e(Companion.serializer(), this));
        if (mapAsMap == null) {
            return null;
        }
        return MapExtensionsKt.filterNotNullValues(mapAsMap);
    }

    public String toString() {
        return "PaywallPostReceiptData(paywallID=" + this.paywallID + ", sessionID=" + this.sessionID + ", revision=" + this.revision + ", displayMode=" + this.displayMode + ", darkMode=" + this.darkMode + ", localeIdentifier=" + this.localeIdentifier + ", offeringId=" + this.offeringId + ')';
    }

    public PaywallPostReceiptData(String str, String sessionID, int i3, String displayMode, boolean z2, String localeIdentifier, String offeringId) {
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        this.paywallID = str;
        this.sessionID = sessionID;
        this.revision = i3;
        this.displayMode = displayMode;
        this.darkMode = z2;
        this.localeIdentifier = localeIdentifier;
        this.offeringId = offeringId;
    }

    @SerialName
    public static /* synthetic */ void getDarkMode$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getDisplayMode$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getLocaleIdentifier$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getOfferingId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPaywallID$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getRevision$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getSessionID$annotations() {
    }
}
