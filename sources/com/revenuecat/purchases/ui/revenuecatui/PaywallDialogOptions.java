package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class PaywallDialogOptions {
    public static final int $stable = 0;
    private final Map<String, CustomVariableValue> customVariables;
    private final Function0<Unit> dismissRequest;
    private final FontProvider fontProvider;
    private final PaywallListener listener;
    private final Offering offering;
    private final PaywallPurchaseLogic purchaseLogic;
    private final Function1<CustomerInfo, Boolean> shouldDisplayBlock;
    private final boolean shouldDisplayDismissButton;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
        public static final int $stable = 8;
        private Function0<Unit> dismissRequest;
        private FontProvider fontProvider;
        private PaywallListener listener;
        private Offering offering;
        private PaywallPurchaseLogic purchaseLogic;
        private Function1<? super CustomerInfo, Boolean> shouldDisplayBlock;
        private boolean shouldDisplayDismissButton = true;
        private Map<String, ? extends CustomVariableValue> customVariables = MapsKt.emptyMap();

        public final PaywallDialogOptions build() {
            return new PaywallDialogOptions(this);
        }

        public final Map<String, CustomVariableValue> getCustomVariables$revenuecatui_defaultsBc8Release() {
            return this.customVariables;
        }

        public final Function0<Unit> getDismissRequest$revenuecatui_defaultsBc8Release() {
            return this.dismissRequest;
        }

        public final FontProvider getFontProvider$revenuecatui_defaultsBc8Release() {
            return this.fontProvider;
        }

        public final PaywallListener getListener$revenuecatui_defaultsBc8Release() {
            return this.listener;
        }

        public final Offering getOffering$revenuecatui_defaultsBc8Release() {
            return this.offering;
        }

        public final PaywallPurchaseLogic getPurchaseLogic$revenuecatui_defaultsBc8Release() {
            return this.purchaseLogic;
        }

        public final Function1<CustomerInfo, Boolean> getShouldDisplayBlock$revenuecatui_defaultsBc8Release() {
            return this.shouldDisplayBlock;
        }

        public final boolean getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release() {
            return this.shouldDisplayDismissButton;
        }

        public final Builder setCustomPurchaseLogic(PaywallPurchaseLogic paywallPurchaseLogic) {
            this.purchaseLogic = paywallPurchaseLogic;
            return this;
        }

        public final Builder setCustomVariables(Map<String, ? extends CustomVariableValue> variables) {
            Intrinsics.checkNotNullParameter(variables, "variables");
            this.customVariables = variables;
            return this;
        }

        public final void setCustomVariables$revenuecatui_defaultsBc8Release(Map<String, ? extends CustomVariableValue> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.customVariables = map;
        }

        public final Builder setDismissRequest(Function0<Unit> dismissRequest) {
            Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
            this.dismissRequest = dismissRequest;
            return this;
        }

        public final void setDismissRequest$revenuecatui_defaultsBc8Release(Function0<Unit> function0) {
            this.dismissRequest = function0;
        }

        public final Builder setFontProvider(FontProvider fontProvider) {
            this.fontProvider = fontProvider;
            return this;
        }

        public final void setFontProvider$revenuecatui_defaultsBc8Release(FontProvider fontProvider) {
            this.fontProvider = fontProvider;
        }

        public final Builder setListener(PaywallListener paywallListener) {
            this.listener = paywallListener;
            return this;
        }

        public final void setListener$revenuecatui_defaultsBc8Release(PaywallListener paywallListener) {
            this.listener = paywallListener;
        }

        public final Builder setOffering(Offering offering) {
            this.offering = offering;
            return this;
        }

        public final void setOffering$revenuecatui_defaultsBc8Release(Offering offering) {
            this.offering = offering;
        }

        public final void setPurchaseLogic$revenuecatui_defaultsBc8Release(PaywallPurchaseLogic paywallPurchaseLogic) {
            this.purchaseLogic = paywallPurchaseLogic;
        }

        public final Builder setRequiredEntitlementIdentifier(String str) {
            if (str != null) {
                this.shouldDisplayBlock = HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier(str);
            }
            return this;
        }

        public final Builder setShouldDisplayBlock(Function1<? super CustomerInfo, Boolean> function1) {
            this.shouldDisplayBlock = function1;
            return this;
        }

        public final void setShouldDisplayBlock$revenuecatui_defaultsBc8Release(Function1<? super CustomerInfo, Boolean> function1) {
            this.shouldDisplayBlock = function1;
        }

        public final Builder setShouldDisplayDismissButton(boolean z2) {
            this.shouldDisplayDismissButton = z2;
            return this;
        }

        public final void setShouldDisplayDismissButton$revenuecatui_defaultsBc8Release(boolean z2) {
            this.shouldDisplayDismissButton = z2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallDialogOptions(Function1<? super CustomerInfo, Boolean> function1, Function0<Unit> function0, Offering offering, boolean z2, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.shouldDisplayBlock = function1;
        this.dismissRequest = function0;
        this.offering = offering;
        this.shouldDisplayDismissButton = z2;
        this.fontProvider = fontProvider;
        this.listener = paywallListener;
        this.purchaseLogic = paywallPurchaseLogic;
        this.customVariables = customVariables;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallDialogOptions)) {
            return false;
        }
        PaywallDialogOptions paywallDialogOptions = (PaywallDialogOptions) obj;
        return Intrinsics.areEqual(this.shouldDisplayBlock, paywallDialogOptions.shouldDisplayBlock) && Intrinsics.areEqual(this.dismissRequest, paywallDialogOptions.dismissRequest) && Intrinsics.areEqual(this.offering, paywallDialogOptions.offering) && this.shouldDisplayDismissButton == paywallDialogOptions.shouldDisplayDismissButton && Intrinsics.areEqual(this.fontProvider, paywallDialogOptions.fontProvider) && Intrinsics.areEqual(this.listener, paywallDialogOptions.listener) && Intrinsics.areEqual(this.purchaseLogic, paywallDialogOptions.purchaseLogic) && Intrinsics.areEqual(this.customVariables, paywallDialogOptions.customVariables);
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }

    public final Function0<Unit> getDismissRequest() {
        return this.dismissRequest;
    }

    public final FontProvider getFontProvider() {
        return this.fontProvider;
    }

    public final PaywallListener getListener() {
        return this.listener;
    }

    public final Offering getOffering() {
        return this.offering;
    }

    public final OfferingSelection getOfferingSelection$revenuecatui_defaultsBc8Release() {
        Offering offering = this.offering;
        return offering != null ? new OfferingSelection.OfferingType(offering) : OfferingSelection.None.INSTANCE;
    }

    public final PaywallPurchaseLogic getPurchaseLogic() {
        return this.purchaseLogic;
    }

    public final Function1<CustomerInfo, Boolean> getShouldDisplayBlock() {
        return this.shouldDisplayBlock;
    }

    public final boolean getShouldDisplayDismissButton() {
        return this.shouldDisplayDismissButton;
    }

    public int hashCode() {
        Function1<CustomerInfo, Boolean> function1 = this.shouldDisplayBlock;
        int iHashCode = (function1 == null ? 0 : function1.hashCode()) * 31;
        Function0<Unit> function0 = this.dismissRequest;
        int iHashCode2 = (iHashCode + (function0 == null ? 0 : function0.hashCode())) * 31;
        Offering offering = this.offering;
        int iHashCode3 = (((iHashCode2 + (offering == null ? 0 : offering.hashCode())) * 31) + Boolean.hashCode(this.shouldDisplayDismissButton)) * 31;
        FontProvider fontProvider = this.fontProvider;
        int iHashCode4 = (iHashCode3 + (fontProvider == null ? 0 : fontProvider.hashCode())) * 31;
        PaywallListener paywallListener = this.listener;
        int iHashCode5 = (iHashCode4 + (paywallListener == null ? 0 : paywallListener.hashCode())) * 31;
        PaywallPurchaseLogic paywallPurchaseLogic = this.purchaseLogic;
        return ((iHashCode5 + (paywallPurchaseLogic != null ? paywallPurchaseLogic.hashCode() : 0)) * 31) + this.customVariables.hashCode();
    }

    public String toString() {
        return "PaywallDialogOptions(shouldDisplayBlock=" + this.shouldDisplayBlock + ", dismissRequest=" + this.dismissRequest + ", offering=" + this.offering + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", fontProvider=" + this.fontProvider + ", listener=" + this.listener + ", purchaseLogic=" + this.purchaseLogic + ", customVariables=" + this.customVariables + ')';
    }

    public /* synthetic */ PaywallDialogOptions(Function1 function1, Function0 function0, Offering offering, boolean z2, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function0, offering, z2, fontProvider, paywallListener, paywallPurchaseLogic, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallDialogOptions(Builder builder) {
        this(builder.getShouldDisplayBlock$revenuecatui_defaultsBc8Release(), builder.getDismissRequest$revenuecatui_defaultsBc8Release(), builder.getOffering$revenuecatui_defaultsBc8Release(), builder.getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release(), builder.getFontProvider$revenuecatui_defaultsBc8Release(), builder.getListener$revenuecatui_defaultsBc8Release(), builder.getPurchaseLogic$revenuecatui_defaultsBc8Release(), builder.getCustomVariables$revenuecatui_defaultsBc8Release());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }
}
