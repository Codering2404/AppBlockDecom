package com.revenuecat.purchases.ui.revenuecatui.activity;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableKeyValidator;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.fonts.ParcelizableFontProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class PaywallActivityLaunchOptions {
    public static final int $stable = 8;
    private final Map<String, CustomVariableValue> customVariables;
    private final boolean edgeToEdge;
    private final ParcelizableFontProvider fontProvider;
    private final PaywallListener listener;
    private final Offering offering;
    private final String offeringIdentifier;
    private final PresentedOfferingContext presentedOfferingContext;
    private final PaywallPurchaseLogic purchaseLogic;
    private final boolean shouldDisplayDismissButton;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
        public static final int $stable = 8;
        private ParcelizableFontProvider fontProvider;
        private PaywallListener listener;
        private Offering offering;
        private String offeringIdentifier;
        private PresentedOfferingContext presentedOfferingContext;
        private PaywallPurchaseLogic purchaseLogic;
        private boolean shouldDisplayDismissButton = true;
        private boolean edgeToEdge = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        private Map<String, ? extends CustomVariableValue> customVariables = MapsKt.emptyMap();

        public final PaywallActivityLaunchOptions build() {
            return new PaywallActivityLaunchOptions(this.offering, this.fontProvider, this.shouldDisplayDismissButton, this.edgeToEdge, this.customVariables, this.purchaseLogic, this.listener, this.offeringIdentifier, this.presentedOfferingContext, null);
        }

        public final Builder setCustomVariables(Map<String, ? extends CustomVariableValue> customVariables) {
            Intrinsics.checkNotNullParameter(customVariables, "customVariables");
            this.customVariables = CustomVariableKeyValidator.INSTANCE.validateAndFilter(customVariables);
            return this;
        }

        public final Builder setEdgeToEdge(boolean z2) {
            this.edgeToEdge = z2;
            return this;
        }

        public final Builder setFontProvider(ParcelizableFontProvider parcelizableFontProvider) {
            this.fontProvider = parcelizableFontProvider;
            return this;
        }

        public final Builder setListener(PaywallListener paywallListener) {
            this.listener = paywallListener;
            return this;
        }

        public final Builder setOffering(Offering offering) {
            this.offering = offering;
            this.offeringIdentifier = null;
            this.presentedOfferingContext = null;
            return this;
        }

        public final Builder setOfferingIdentifier(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext) {
            Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            this.offeringIdentifier = offeringIdentifier;
            this.presentedOfferingContext = presentedOfferingContext;
            this.offering = null;
            return this;
        }

        public final Builder setPurchaseLogic(PaywallPurchaseLogic paywallPurchaseLogic) {
            this.purchaseLogic = paywallPurchaseLogic;
            return this;
        }

        public final Builder setShouldDisplayDismissButton(boolean z2) {
            this.shouldDisplayDismissButton = z2;
            return this;
        }
    }

    public /* synthetic */ PaywallActivityLaunchOptions(Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, Map map, PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener, String str, PresentedOfferingContext presentedOfferingContext, DefaultConstructorMarker defaultConstructorMarker) {
        this(offering, parcelizableFontProvider, z2, z3, map, paywallPurchaseLogic, paywallListener, str, presentedOfferingContext);
    }

    public final Map<String, CustomVariableValue> getCustomVariables$revenuecatui_defaultsBc8Release() {
        return this.customVariables;
    }

    public final boolean getEdgeToEdge$revenuecatui_defaultsBc8Release() {
        return this.edgeToEdge;
    }

    public final ParcelizableFontProvider getFontProvider$revenuecatui_defaultsBc8Release() {
        return this.fontProvider;
    }

    public final PaywallListener getListener$revenuecatui_defaultsBc8Release() {
        return this.listener;
    }

    public final Offering getOffering$revenuecatui_defaultsBc8Release() {
        return this.offering;
    }

    public final String getOfferingIdentifier$revenuecatui_defaultsBc8Release() {
        return this.offeringIdentifier;
    }

    public final PresentedOfferingContext getPresentedOfferingContext$revenuecatui_defaultsBc8Release() {
        return this.presentedOfferingContext;
    }

    public final PaywallPurchaseLogic getPurchaseLogic$revenuecatui_defaultsBc8Release() {
        return this.purchaseLogic;
    }

    public final boolean getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release() {
        return this.shouldDisplayDismissButton;
    }

    public final OfferingSelection.IdAndPresentedOfferingContext toOfferingSelection$revenuecatui_defaultsBc8Release() {
        if (this.offeringIdentifier != null) {
            return new OfferingSelection.IdAndPresentedOfferingContext(this.offeringIdentifier, this.presentedOfferingContext);
        }
        if (this.offering == null) {
            return null;
        }
        String identifier = this.offering.getIdentifier();
        Package r3 = (Package) CollectionsKt.firstOrNull((List) this.offering.getAvailablePackages());
        return new OfferingSelection.IdAndPresentedOfferingContext(identifier, r3 != null ? r3.getPresentedOfferingContext() : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PaywallActivityLaunchOptions(Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, Map<String, ? extends CustomVariableValue> map, PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener, String str, PresentedOfferingContext presentedOfferingContext) {
        this.offering = offering;
        this.fontProvider = parcelizableFontProvider;
        this.shouldDisplayDismissButton = z2;
        this.edgeToEdge = z3;
        this.customVariables = map;
        this.purchaseLogic = paywallPurchaseLogic;
        this.listener = paywallListener;
        this.offeringIdentifier = str;
        this.presentedOfferingContext = presentedOfferingContext;
    }
}
