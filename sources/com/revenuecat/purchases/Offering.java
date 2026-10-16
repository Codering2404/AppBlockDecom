package com.revenuecat.purchases;

import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Offering {
    private final Lazy annual$delegate;
    private final List<Package> availablePackages;
    private final String identifier;
    private final Lazy lifetime$delegate;
    private final Map<String, Object> metadata;
    private final Lazy monthly$delegate;
    private final PaywallData paywall;
    private final PaywallComponents paywallComponents;
    private final String serverDescription;
    private final Lazy sixMonth$delegate;
    private final Lazy threeMonth$delegate;
    private final Lazy twoMonth$delegate;
    private final URL webCheckoutURL;
    private final Lazy weekly$delegate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallComponents {
        private final PaywallComponentsData data;
        private final UiConfig uiConfig;

        public PaywallComponents(UiConfig uiConfig, PaywallComponentsData data) {
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            Intrinsics.checkNotNullParameter(data, "data");
            this.uiConfig = uiConfig;
            this.data = data;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallComponents)) {
                return false;
            }
            PaywallComponents paywallComponents = (PaywallComponents) obj;
            return Intrinsics.areEqual(this.uiConfig, paywallComponents.uiConfig) && Intrinsics.areEqual(this.data, paywallComponents.data);
        }

        public final PaywallComponentsData getData() {
            return this.data;
        }

        public final UiConfig getUiConfig() {
            return this.uiConfig;
        }

        public int hashCode() {
            return (this.uiConfig.hashCode() * 31) + this.data.hashCode();
        }

        public String toString() {
            return "PaywallComponents(uiConfig=" + this.uiConfig + ", data=" + this.data + ')';
        }
    }

    public Offering(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages, PaywallData paywallData, PaywallComponents paywallComponents, URL url) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(serverDescription, "serverDescription");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
        this.identifier = identifier;
        this.serverDescription = serverDescription;
        this.metadata = metadata;
        this.availablePackages = availablePackages;
        this.paywall = paywallData;
        this.paywallComponents = paywallComponents;
        this.webCheckoutURL = url;
        this.lifetime$delegate = LazyKt.b(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$lifetime$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.LIFETIME);
            }
        });
        this.annual$delegate = LazyKt.b(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$annual$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.ANNUAL);
            }
        });
        this.sixMonth$delegate = LazyKt.b(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$sixMonth$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.SIX_MONTH);
            }
        });
        this.threeMonth$delegate = LazyKt.b(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$threeMonth$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.THREE_MONTH);
            }
        });
        this.twoMonth$delegate = LazyKt.b(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$twoMonth$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.TWO_MONTH);
            }
        });
        this.monthly$delegate = LazyKt.b(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$monthly$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.MONTHLY);
            }
        });
        this.weekly$delegate = LazyKt.b(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$weekly$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                return this.this$0.findPackage(PackageType.WEEKLY);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Package findPackage(PackageType packageType) {
        Object next;
        Iterator<T> it = this.availablePackages.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Package) next).getIdentifier(), packageType.getIdentifier())) {
                break;
            }
        }
        return (Package) next;
    }

    public final Offering copy(PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        String str = this.identifier;
        String str2 = this.serverDescription;
        Map<String, Object> map = this.metadata;
        List<Package> list = this.availablePackages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Package) it.next()).copy$purchases_defaultsBc8Release(presentedOfferingContext));
        }
        return new Offering(str, str2, map, arrayList, this.paywall, this.paywallComponents, this.webCheckoutURL);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Offering)) {
            return false;
        }
        Offering offering = (Offering) obj;
        return Intrinsics.areEqual(this.identifier, offering.identifier) && Intrinsics.areEqual(this.serverDescription, offering.serverDescription) && Intrinsics.areEqual(this.metadata, offering.metadata) && Intrinsics.areEqual(this.availablePackages, offering.availablePackages) && Intrinsics.areEqual(this.paywall, offering.paywall) && Intrinsics.areEqual(this.paywallComponents, offering.paywallComponents) && Intrinsics.areEqual(this.webCheckoutURL, offering.webCheckoutURL);
    }

    public final Package get(String s2) {
        Intrinsics.checkNotNullParameter(s2, "s");
        return getPackage(s2);
    }

    public final Package getAnnual() {
        return (Package) this.annual$delegate.getValue();
    }

    public final List<Package> getAvailablePackages() {
        return this.availablePackages;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Package getLifetime() {
        return (Package) this.lifetime$delegate.getValue();
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getMetadataString(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        Object obj = this.metadata.get(key);
        String str2 = obj instanceof String ? (String) obj : null;
        return str2 == null ? str : str2;
    }

    public final Package getMonthly() {
        return (Package) this.monthly$delegate.getValue();
    }

    public final Package getPackage(String identifier) throws NoSuchElementException {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        for (Package r12 : this.availablePackages) {
            if (Intrinsics.areEqual(r12.getIdentifier(), identifier)) {
                return r12;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final PaywallData getPaywall() {
        return this.paywall;
    }

    public final PaywallComponents getPaywallComponents() {
        return this.paywallComponents;
    }

    public final String getServerDescription() {
        return this.serverDescription;
    }

    public final Package getSixMonth() {
        return (Package) this.sixMonth$delegate.getValue();
    }

    public final Package getThreeMonth() {
        return (Package) this.threeMonth$delegate.getValue();
    }

    public final Package getTwoMonth() {
        return (Package) this.twoMonth$delegate.getValue();
    }

    public final URL getWebCheckoutURL() {
        return this.webCheckoutURL;
    }

    public final Package getWeekly() {
        return (Package) this.weekly$delegate.getValue();
    }

    public final boolean hasPaywall() {
        return (this.paywall == null && this.paywallComponents == null) ? false : true;
    }

    public int hashCode() {
        int iHashCode = ((((((this.identifier.hashCode() * 31) + this.serverDescription.hashCode()) * 31) + this.metadata.hashCode()) * 31) + this.availablePackages.hashCode()) * 31;
        PaywallData paywallData = this.paywall;
        int iHashCode2 = (iHashCode + (paywallData == null ? 0 : paywallData.hashCode())) * 31;
        PaywallComponents paywallComponents = this.paywallComponents;
        int iHashCode3 = (iHashCode2 + (paywallComponents == null ? 0 : paywallComponents.hashCode())) * 31;
        URL url = this.webCheckoutURL;
        return iHashCode3 + (url != null ? url.hashCode() : 0);
    }

    public String toString() {
        return "Offering(identifier=" + this.identifier + ", serverDescription=" + this.serverDescription + ", metadata=" + this.metadata + ", availablePackages=" + this.availablePackages + ", paywall=" + this.paywall + ", paywallComponents=" + this.paywallComponents + ", webCheckoutURL=" + this.webCheckoutURL + ')';
    }

    public /* synthetic */ Offering(String str, String str2, Map map, List list, PaywallData paywallData, PaywallComponents paywallComponents, URL url, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, map, list, (i3 & 16) != 0 ? null : paywallData, (i3 & 32) != 0 ? null : paywallComponents, (i3 & 64) != 0 ? null : url);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Offering(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages) {
        this(identifier, serverDescription, metadata, availablePackages, null, null, null);
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(serverDescription, "serverDescription");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
    }

    public static /* synthetic */ void getPaywall$annotations() {
    }

    public static /* synthetic */ void getPaywallComponents$annotations() {
    }

    public static /* synthetic */ void hasPaywall$annotations() {
    }
}
