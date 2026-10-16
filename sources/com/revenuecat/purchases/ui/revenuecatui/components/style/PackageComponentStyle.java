package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPackagePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PackageComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final String componentName;
    private final boolean isSelectable;
    private final boolean isSelectedByDefault;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<PresentedPackagePartial>> overrides;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final Size size;
    private final StackComponentStyle stackComponentStyle;
    private final Integer tabIndex;
    private final boolean visible;

    public PackageComponentStyle(Package rcPackage, boolean z2, String str, StackComponentStyle stackComponentStyle, boolean z3, ResolvedOffer resolvedOffer, boolean z4, List<PresentedOverride<PresentedPackagePartial>> overrides, OfferEligibility offerEligibility) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.rcPackage = rcPackage;
        this.isSelectedByDefault = z2;
        this.componentName = str;
        this.stackComponentStyle = stackComponentStyle;
        this.isSelectable = z3;
        this.resolvedOffer = resolvedOffer;
        this.visible = z4;
        this.overrides = overrides;
        this.offerEligibility = offerEligibility;
        this.size = stackComponentStyle.getSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PackageComponentStyle copy$default(PackageComponentStyle packageComponentStyle, Package r12, boolean z2, String str, StackComponentStyle stackComponentStyle, boolean z3, ResolvedOffer resolvedOffer, boolean z4, List list, OfferEligibility offerEligibility, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            r12 = packageComponentStyle.rcPackage;
        }
        if ((i3 & 2) != 0) {
            z2 = packageComponentStyle.isSelectedByDefault;
        }
        if ((i3 & 4) != 0) {
            str = packageComponentStyle.componentName;
        }
        if ((i3 & 8) != 0) {
            stackComponentStyle = packageComponentStyle.stackComponentStyle;
        }
        if ((i3 & 16) != 0) {
            z3 = packageComponentStyle.isSelectable;
        }
        if ((i3 & 32) != 0) {
            resolvedOffer = packageComponentStyle.resolvedOffer;
        }
        if ((i3 & 64) != 0) {
            z4 = packageComponentStyle.visible;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            list = packageComponentStyle.overrides;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            offerEligibility = packageComponentStyle.offerEligibility;
        }
        List list2 = list;
        OfferEligibility offerEligibility2 = offerEligibility;
        ResolvedOffer resolvedOffer2 = resolvedOffer;
        boolean z5 = z4;
        boolean z6 = z3;
        String str2 = str;
        return packageComponentStyle.copy(r12, z2, str2, stackComponentStyle, z6, resolvedOffer2, z5, list2, offerEligibility2);
    }

    public final Package component1() {
        return this.rcPackage;
    }

    public final boolean component2() {
        return this.isSelectedByDefault;
    }

    public final String component3() {
        return this.componentName;
    }

    public final StackComponentStyle component4() {
        return this.stackComponentStyle;
    }

    public final boolean component5() {
        return this.isSelectable;
    }

    public final ResolvedOffer component6() {
        return this.resolvedOffer;
    }

    public final boolean component7() {
        return this.visible;
    }

    public final List<PresentedOverride<PresentedPackagePartial>> component8() {
        return this.overrides;
    }

    public final OfferEligibility component9() {
        return this.offerEligibility;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i3) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i3);
    }

    public final PackageComponentStyle copy(Package rcPackage, boolean z2, String str, StackComponentStyle stackComponentStyle, boolean z3, ResolvedOffer resolvedOffer, boolean z4, List<PresentedOverride<PresentedPackagePartial>> overrides, OfferEligibility offerEligibility) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new PackageComponentStyle(rcPackage, z2, str, stackComponentStyle, z3, resolvedOffer, z4, overrides, offerEligibility);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PackageComponentStyle)) {
            return false;
        }
        PackageComponentStyle packageComponentStyle = (PackageComponentStyle) obj;
        return Intrinsics.areEqual(this.rcPackage, packageComponentStyle.rcPackage) && this.isSelectedByDefault == packageComponentStyle.isSelectedByDefault && Intrinsics.areEqual(this.componentName, packageComponentStyle.componentName) && Intrinsics.areEqual(this.stackComponentStyle, packageComponentStyle.stackComponentStyle) && this.isSelectable == packageComponentStyle.isSelectable && Intrinsics.areEqual(this.resolvedOffer, packageComponentStyle.resolvedOffer) && this.visible == packageComponentStyle.visible && Intrinsics.areEqual(this.overrides, packageComponentStyle.overrides) && Intrinsics.areEqual(this.offerEligibility, packageComponentStyle.offerEligibility);
    }

    public final /* synthetic */ String getComponentName() {
        return this.componentName;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public String getPackageUniqueId() {
        return PackageContext.DefaultImpls.getPackageUniqueId(this);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Package getRcPackage() {
        return this.rcPackage;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }

    public final /* synthetic */ StackComponentStyle getStackComponentStyle() {
        return this.stackComponentStyle;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Integer getTabIndex() {
        return this.tabIndex;
    }

    public final /* synthetic */ String getUniqueId() {
        SubscriptionOption option;
        ResolvedOffer resolvedOffer = getResolvedOffer();
        String id = null;
        ResolvedOffer.ConfiguredOffer configuredOffer = resolvedOffer instanceof ResolvedOffer.ConfiguredOffer ? (ResolvedOffer.ConfiguredOffer) resolvedOffer : null;
        if (configuredOffer != null && (option = configuredOffer.getOption()) != null) {
            id = option.getId();
        }
        if (id == null) {
            return getRcPackage().getIdentifier();
        }
        return getRcPackage().getIdentifier() + ':' + id;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((this.rcPackage.hashCode() * 31) + Boolean.hashCode(this.isSelectedByDefault)) * 31;
        String str = this.componentName;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.stackComponentStyle.hashCode()) * 31) + Boolean.hashCode(this.isSelectable)) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode3 = (((((iHashCode2 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31) + Boolean.hashCode(this.visible)) * 31) + this.overrides.hashCode()) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        return iHashCode3 + (offerEligibility != null ? offerEligibility.hashCode() : 0);
    }

    public final /* synthetic */ boolean isSelectable() {
        return this.isSelectable;
    }

    public final /* synthetic */ boolean isSelectedByDefault() {
        return this.isSelectedByDefault;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public String toString() {
        return "PackageComponentStyle(rcPackage=" + this.rcPackage + ", isSelectedByDefault=" + this.isSelectedByDefault + ", componentName=" + this.componentName + QaXmqxvjHhxVy.OhaqL + this.stackComponentStyle + ", isSelectable=" + this.isSelectable + ", resolvedOffer=" + this.resolvedOffer + ", visible=" + this.visible + ", overrides=" + this.overrides + ", offerEligibility=" + this.offerEligibility + ')';
    }

    public /* synthetic */ PackageComponentStyle(Package r2, boolean z2, String str, StackComponentStyle stackComponentStyle, boolean z3, ResolvedOffer resolvedOffer, boolean z4, List list, OfferEligibility offerEligibility, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, z2, (i3 & 4) != 0 ? null : str, stackComponentStyle, z3, (i3 & 32) != 0 ? null : resolvedOffer, z4, list, (i3 & Function.MAX_NARGS) != 0 ? null : offerEligibility);
    }
}
