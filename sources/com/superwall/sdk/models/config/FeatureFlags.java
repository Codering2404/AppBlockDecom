package com.superwall.sdk.models.config;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class FeatureFlags {
    public static final Companion Companion = new Companion(null);
    private boolean disableVerboseEvents;
    private boolean enableCELLogging;
    private boolean enableConfigRefresh;
    private boolean enableMultiplePaywallUrls;
    private boolean enablePostback;
    private boolean enableSessionEvents;
    private boolean enableUserIdSeed;
    private boolean web2App;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<FeatureFlags> serializer() {
            return FeatureFlags$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ FeatureFlags(int i3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, SerializationConstructorMarker serializationConstructorMarker) {
        if (255 != (i3 & 255)) {
            PluginExceptionsKt.b(i3, 255, FeatureFlags$$serializer.INSTANCE.getDescriptor());
        }
        this.enableConfigRefresh = z2;
        this.enableSessionEvents = z3;
        this.enablePostback = z4;
        this.enableUserIdSeed = z5;
        this.disableVerboseEvents = z6;
        this.enableMultiplePaywallUrls = z7;
        this.enableCELLogging = z8;
        this.web2App = z9;
    }

    public static /* synthetic */ FeatureFlags copy$default(FeatureFlags featureFlags, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = featureFlags.enableConfigRefresh;
        }
        if ((i3 & 2) != 0) {
            z3 = featureFlags.enableSessionEvents;
        }
        if ((i3 & 4) != 0) {
            z4 = featureFlags.enablePostback;
        }
        if ((i3 & 8) != 0) {
            z5 = featureFlags.enableUserIdSeed;
        }
        if ((i3 & 16) != 0) {
            z6 = featureFlags.disableVerboseEvents;
        }
        if ((i3 & 32) != 0) {
            z7 = featureFlags.enableMultiplePaywallUrls;
        }
        if ((i3 & 64) != 0) {
            z8 = featureFlags.enableCELLogging;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z9 = featureFlags.web2App;
        }
        boolean z10 = z8;
        boolean z11 = z9;
        boolean z12 = z6;
        boolean z13 = z7;
        return featureFlags.copy(z2, z3, z4, z5, z12, z13, z10, z11);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(FeatureFlags featureFlags, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.x(serialDescriptor, 0, featureFlags.enableConfigRefresh);
        compositeEncoder.x(serialDescriptor, 1, featureFlags.enableSessionEvents);
        compositeEncoder.x(serialDescriptor, 2, featureFlags.enablePostback);
        compositeEncoder.x(serialDescriptor, 3, featureFlags.enableUserIdSeed);
        compositeEncoder.x(serialDescriptor, 4, featureFlags.disableVerboseEvents);
        compositeEncoder.x(serialDescriptor, 5, featureFlags.enableMultiplePaywallUrls);
        compositeEncoder.x(serialDescriptor, 6, featureFlags.enableCELLogging);
        compositeEncoder.x(serialDescriptor, 7, featureFlags.web2App);
    }

    public final boolean component1() {
        return this.enableConfigRefresh;
    }

    public final boolean component2() {
        return this.enableSessionEvents;
    }

    public final boolean component3() {
        return this.enablePostback;
    }

    public final boolean component4() {
        return this.enableUserIdSeed;
    }

    public final boolean component5() {
        return this.disableVerboseEvents;
    }

    public final boolean component6() {
        return this.enableMultiplePaywallUrls;
    }

    public final boolean component7() {
        return this.enableCELLogging;
    }

    public final boolean component8() {
        return this.web2App;
    }

    public final FeatureFlags copy(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        return new FeatureFlags(z2, z3, z4, z5, z6, z7, z8, z9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureFlags)) {
            return false;
        }
        FeatureFlags featureFlags = (FeatureFlags) obj;
        return this.enableConfigRefresh == featureFlags.enableConfigRefresh && this.enableSessionEvents == featureFlags.enableSessionEvents && this.enablePostback == featureFlags.enablePostback && this.enableUserIdSeed == featureFlags.enableUserIdSeed && this.disableVerboseEvents == featureFlags.disableVerboseEvents && this.enableMultiplePaywallUrls == featureFlags.enableMultiplePaywallUrls && this.enableCELLogging == featureFlags.enableCELLogging && this.web2App == featureFlags.web2App;
    }

    public final boolean getDisableVerboseEvents() {
        return this.disableVerboseEvents;
    }

    public final boolean getEnableCELLogging() {
        return this.enableCELLogging;
    }

    public final boolean getEnableConfigRefresh() {
        return this.enableConfigRefresh;
    }

    public final boolean getEnableMultiplePaywallUrls() {
        return this.enableMultiplePaywallUrls;
    }

    public final boolean getEnablePostback() {
        return this.enablePostback;
    }

    public final boolean getEnableSessionEvents() {
        return this.enableSessionEvents;
    }

    public final boolean getEnableUserIdSeed() {
        return this.enableUserIdSeed;
    }

    public final boolean getWeb2App() {
        return this.web2App;
    }

    public int hashCode() {
        return (((((((((((((Boolean.hashCode(this.enableConfigRefresh) * 31) + Boolean.hashCode(this.enableSessionEvents)) * 31) + Boolean.hashCode(this.enablePostback)) * 31) + Boolean.hashCode(this.enableUserIdSeed)) * 31) + Boolean.hashCode(this.disableVerboseEvents)) * 31) + Boolean.hashCode(this.enableMultiplePaywallUrls)) * 31) + Boolean.hashCode(this.enableCELLogging)) * 31) + Boolean.hashCode(this.web2App);
    }

    public final void setDisableVerboseEvents(boolean z2) {
        this.disableVerboseEvents = z2;
    }

    public final void setEnableCELLogging(boolean z2) {
        this.enableCELLogging = z2;
    }

    public final void setEnableConfigRefresh(boolean z2) {
        this.enableConfigRefresh = z2;
    }

    public final void setEnableMultiplePaywallUrls(boolean z2) {
        this.enableMultiplePaywallUrls = z2;
    }

    public final void setEnablePostback(boolean z2) {
        this.enablePostback = z2;
    }

    public final void setEnableSessionEvents(boolean z2) {
        this.enableSessionEvents = z2;
    }

    public final void setEnableUserIdSeed(boolean z2) {
        this.enableUserIdSeed = z2;
    }

    public final void setWeb2App(boolean z2) {
        this.web2App = z2;
    }

    public String toString() {
        return "FeatureFlags(enableConfigRefresh=" + this.enableConfigRefresh + ", enableSessionEvents=" + this.enableSessionEvents + ", enablePostback=" + this.enablePostback + ", enableUserIdSeed=" + this.enableUserIdSeed + ", disableVerboseEvents=" + this.disableVerboseEvents + ", enableMultiplePaywallUrls=" + this.enableMultiplePaywallUrls + ", enableCELLogging=" + this.enableCELLogging + ", web2App=" + this.web2App + ")";
    }

    public FeatureFlags(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.enableConfigRefresh = z2;
        this.enableSessionEvents = z3;
        this.enablePostback = z4;
        this.enableUserIdSeed = z5;
        this.disableVerboseEvents = z6;
        this.enableMultiplePaywallUrls = z7;
        this.enableCELLogging = z8;
        this.web2App = z9;
    }

    @SerialName
    public static /* synthetic */ void getDisableVerboseEvents$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEnableCELLogging$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEnableConfigRefresh$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEnableMultiplePaywallUrls$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEnablePostback$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEnableSessionEvents$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEnableUserIdSeed$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getWeb2App$annotations() {
    }
}
