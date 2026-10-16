package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
public final class PaywallOptions {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final int hashMultiplier = 31;
    private final Map<String, CustomVariableValue> customVariables;
    private final Function0<Unit> dismissRequest;
    private final Function2<Offering, PaywallResult, Unit> dismissRequestWithExitOffering;
    private final FontProvider fontProvider;
    private final PaywallListener listener;
    private final PaywallMode mode;
    private final OfferingSelection offeringSelection;
    private final PaywallPurchaseLogic purchaseLogic;
    private final boolean shouldDisplayDismissButton;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
        public static final int $stable = 8;
        private Map<String, ? extends CustomVariableValue> customVariables;
        private final Function0<Unit> dismissRequest;
        private Function2<? super Offering, ? super PaywallResult, Unit> dismissRequestWithExitOffering;
        private FontProvider fontProvider;
        private PaywallListener listener;
        private PaywallMode mode;
        private OfferingSelection offeringSelection;
        private PaywallPurchaseLogic purchaseLogic;
        private boolean shouldDisplayDismissButton;

        public Builder(Function0<Unit> dismissRequest) {
            Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
            this.dismissRequest = dismissRequest;
            this.offeringSelection = OfferingSelection.None.INSTANCE;
            this.mode = PaywallMode.Companion.getDefault();
            this.customVariables = MapsKt.emptyMap();
        }

        public final PaywallOptions build() {
            return new PaywallOptions(this);
        }

        public final Map<String, CustomVariableValue> getCustomVariables$revenuecatui_defaultsBc8Release() {
            return this.customVariables;
        }

        public final Function0<Unit> getDismissRequest$revenuecatui_defaultsBc8Release() {
            return this.dismissRequest;
        }

        public final Function2<Offering, PaywallResult, Unit> getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release() {
            return this.dismissRequestWithExitOffering;
        }

        public final FontProvider getFontProvider$revenuecatui_defaultsBc8Release() {
            return this.fontProvider;
        }

        public final PaywallListener getListener$revenuecatui_defaultsBc8Release() {
            return this.listener;
        }

        public final PaywallMode getMode$revenuecatui_defaultsBc8Release() {
            return this.mode;
        }

        public final OfferingSelection getOfferingSelection$revenuecatui_defaultsBc8Release() {
            return this.offeringSelection;
        }

        public final PaywallPurchaseLogic getPurchaseLogic$revenuecatui_defaultsBc8Release() {
            return this.purchaseLogic;
        }

        public final boolean getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release() {
            return this.shouldDisplayDismissButton;
        }

        public final Builder setCustomVariables(Map<String, ? extends CustomVariableValue> variables) {
            Intrinsics.checkNotNullParameter(variables, "variables");
            this.customVariables = CustomVariableKeyValidator.INSTANCE.validateAndFilter(variables);
            return this;
        }

        public final void setCustomVariables$revenuecatui_defaultsBc8Release(Map<String, ? extends CustomVariableValue> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.customVariables = map;
        }

        /* JADX INFO: renamed from: setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release, reason: collision with other method in class */
        public final void m686setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release(Function2<? super Offering, ? super PaywallResult, Unit> function2) {
            this.dismissRequestWithExitOffering = function2;
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

        /* JADX INFO: renamed from: setMode$revenuecatui_defaultsBc8Release, reason: collision with other method in class */
        public final void m687setMode$revenuecatui_defaultsBc8Release(PaywallMode paywallMode) {
            Intrinsics.checkNotNullParameter(paywallMode, "<set-?>");
            this.mode = paywallMode;
        }

        public final Builder setOffering(Offering offering) {
            this.offeringSelection = offering != null ? new OfferingSelection.OfferingType(offering) : OfferingSelection.None.INSTANCE;
            return this;
        }

        public final Builder setOfferingIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release(OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext) {
            OfferingSelection offeringSelection = idAndPresentedOfferingContext;
            if (idAndPresentedOfferingContext == null) {
                offeringSelection = OfferingSelection.None.INSTANCE;
            }
            this.offeringSelection = offeringSelection;
            return this;
        }

        /* JADX INFO: renamed from: setOfferingSelection$revenuecatui_defaultsBc8Release, reason: collision with other method in class */
        public final void m688setOfferingSelection$revenuecatui_defaultsBc8Release(OfferingSelection offeringSelection) {
            Intrinsics.checkNotNullParameter(offeringSelection, "<set-?>");
            this.offeringSelection = offeringSelection;
        }

        public final Builder setPurchaseLogic(PaywallPurchaseLogic paywallPurchaseLogic) {
            this.purchaseLogic = paywallPurchaseLogic;
            return this;
        }

        public final void setPurchaseLogic$revenuecatui_defaultsBc8Release(PaywallPurchaseLogic paywallPurchaseLogic) {
            this.purchaseLogic = paywallPurchaseLogic;
        }

        public final Builder setShouldDisplayDismissButton(boolean z2) {
            this.shouldDisplayDismissButton = z2;
            return this;
        }

        public final void setShouldDisplayDismissButton$revenuecatui_defaultsBc8Release(boolean z2) {
            this.shouldDisplayDismissButton = z2;
        }

        public final Builder setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release(Function2<? super Offering, ? super PaywallResult, Unit> function2) {
            this.dismissRequestWithExitOffering = function2;
            return this;
        }

        public final Builder setMode$revenuecatui_defaultsBc8Release(PaywallMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.mode = mode;
            return this;
        }

        public final Builder setOfferingSelection$revenuecatui_defaultsBc8Release(OfferingSelection offeringSelection) {
            if (offeringSelection == null) {
                offeringSelection = OfferingSelection.None.INSTANCE;
            }
            this.offeringSelection = offeringSelection;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallOptions(OfferingSelection offeringSelection, boolean z2, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, PaywallMode mode, Function0<Unit> dismissRequest, Function2<? super Offering, ? super PaywallResult, Unit> function2, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(offeringSelection, "offeringSelection");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.offeringSelection = offeringSelection;
        this.shouldDisplayDismissButton = z2;
        this.fontProvider = fontProvider;
        this.listener = paywallListener;
        this.purchaseLogic = paywallPurchaseLogic;
        this.mode = mode;
        this.dismissRequest = dismissRequest;
        this.dismissRequestWithExitOffering = function2;
        this.customVariables = customVariables;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallOptions copy$revenuecatui_defaultsBc8Release$default(PaywallOptions paywallOptions, OfferingSelection offeringSelection, boolean z2, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, PaywallMode paywallMode, Function0 function0, Function2 function2, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            offeringSelection = paywallOptions.offeringSelection;
        }
        if ((i3 & 2) != 0) {
            z2 = paywallOptions.shouldDisplayDismissButton;
        }
        if ((i3 & 4) != 0) {
            fontProvider = paywallOptions.fontProvider;
        }
        if ((i3 & 8) != 0) {
            paywallListener = paywallOptions.listener;
        }
        if ((i3 & 16) != 0) {
            paywallPurchaseLogic = paywallOptions.purchaseLogic;
        }
        if ((i3 & 32) != 0) {
            paywallMode = paywallOptions.mode;
        }
        if ((i3 & 64) != 0) {
            function0 = paywallOptions.dismissRequest;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            function2 = paywallOptions.dismissRequestWithExitOffering;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            map = paywallOptions.customVariables;
        }
        Function2 function22 = function2;
        Map map2 = map;
        PaywallMode paywallMode2 = paywallMode;
        Function0 function02 = function0;
        PaywallPurchaseLogic paywallPurchaseLogic2 = paywallPurchaseLogic;
        FontProvider fontProvider2 = fontProvider;
        return paywallOptions.copy$revenuecatui_defaultsBc8Release(offeringSelection, z2, fontProvider2, paywallListener, paywallPurchaseLogic2, paywallMode2, function02, function22, map2);
    }

    public final PaywallOptions copy$revenuecatui_defaultsBc8Release(OfferingSelection offeringSelection, boolean z2, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, PaywallMode mode, Function0<Unit> dismissRequest, Function2<? super Offering, ? super PaywallResult, Unit> function2, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(offeringSelection, "offeringSelection");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        return new PaywallOptions(offeringSelection, z2, fontProvider, paywallListener, paywallPurchaseLogic, mode, dismissRequest, function2, customVariables);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallOptions)) {
            return false;
        }
        PaywallOptions paywallOptions = (PaywallOptions) obj;
        if (Intrinsics.areEqual(this.offeringSelection, paywallOptions.offeringSelection) && this.shouldDisplayDismissButton == paywallOptions.shouldDisplayDismissButton && Intrinsics.areEqual(this.fontProvider, paywallOptions.fontProvider) && Intrinsics.areEqual(this.listener, paywallOptions.listener) && Intrinsics.areEqual(this.purchaseLogic, paywallOptions.purchaseLogic) && this.mode == paywallOptions.mode && Intrinsics.areEqual(this.customVariables, paywallOptions.customVariables)) {
            return Intrinsics.areEqual(this.dismissRequest, paywallOptions.dismissRequest);
        }
        return false;
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }

    public final Function0<Unit> getDismissRequest() {
        return this.dismissRequest;
    }

    public final Function2<Offering, PaywallResult, Unit> getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release() {
        return this.dismissRequestWithExitOffering;
    }

    public final FontProvider getFontProvider() {
        return this.fontProvider;
    }

    public final PaywallListener getListener() {
        return this.listener;
    }

    public final PaywallMode getMode$revenuecatui_defaultsBc8Release() {
        return this.mode;
    }

    public final OfferingSelection getOfferingSelection$revenuecatui_defaultsBc8Release() {
        return this.offeringSelection;
    }

    public final PaywallPurchaseLogic getPurchaseLogic() {
        return this.purchaseLogic;
    }

    public final boolean getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release() {
        return this.shouldDisplayDismissButton;
    }

    public int hashCode() {
        String offeringIdentifier = this.offeringSelection.getOfferingIdentifier();
        return ((((((offeringIdentifier != null ? offeringIdentifier.hashCode() : 0) * 31) + Boolean.hashCode(this.shouldDisplayDismissButton)) * 31) + this.mode.hashCode()) * 31) + this.customVariables.hashCode();
    }

    public String toString() {
        return "PaywallOptions(offeringSelection=" + this.offeringSelection + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", fontProvider=" + this.fontProvider + ", listener=" + this.listener + ", purchaseLogic=" + this.purchaseLogic + ", mode=" + this.mode + ", dismissRequest=" + this.dismissRequest + ", dismissRequestWithExitOffering=" + this.dismissRequestWithExitOffering + ", customVariables=" + this.customVariables + ')';
    }

    public /* synthetic */ PaywallOptions(OfferingSelection offeringSelection, boolean z2, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, PaywallMode paywallMode, Function0 function0, Function2 function2, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(offeringSelection, z2, fontProvider, paywallListener, paywallPurchaseLogic, paywallMode, function0, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : function2, (i3 & Function.MAX_NARGS) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallOptions(Builder builder) {
        this(builder.getOfferingSelection$revenuecatui_defaultsBc8Release(), builder.getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release(), builder.getFontProvider$revenuecatui_defaultsBc8Release(), builder.getListener$revenuecatui_defaultsBc8Release(), builder.getPurchaseLogic$revenuecatui_defaultsBc8Release(), builder.getMode$revenuecatui_defaultsBc8Release(), builder.getDismissRequest$revenuecatui_defaultsBc8Release(), builder.getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release(), builder.getCustomVariables$revenuecatui_defaultsBc8Release());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }
}
