package com.revenuecat.purchases.ui.revenuecatui.views;

import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
public final class PaywallViewAttributesReader {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final boolean DEFAULT_CONDENSED = false;
    private static final Map<int[], Map<Companion.Attributes, Integer>> styleablesByStyleSet;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private enum Attributes {
            OfferingId,
            ShouldDisplayDismissButton,
            FontFamily
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.revenuecat.purchases.ui.revenuecatui.views.PaywallViewAttributesReader.PaywallViewAttributes parseAttributes(android.content.Context r7, android.util.AttributeSet r8, int[] r9) {
            /*
                Method dump skipped, instruction units count: 211
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.views.PaywallViewAttributesReader.Companion.parseAttributes(android.content.Context, android.util.AttributeSet, int[]):com.revenuecat.purchases.ui.revenuecatui.views.PaywallViewAttributesReader$PaywallViewAttributes");
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallViewAttributes {
        public static final int $stable = 8;
        private final Boolean condensed;
        private final FontProvider fontProvider;
        private final String offeringId;
        private final Boolean shouldDisplayDismissButton;

        public PaywallViewAttributes(String str, FontProvider fontProvider, Boolean bool, Boolean bool2) {
            this.offeringId = str;
            this.fontProvider = fontProvider;
            this.shouldDisplayDismissButton = bool;
            this.condensed = bool2;
        }

        public static /* synthetic */ PaywallViewAttributes copy$default(PaywallViewAttributes paywallViewAttributes, String str, FontProvider fontProvider, Boolean bool, Boolean bool2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paywallViewAttributes.offeringId;
            }
            if ((i3 & 2) != 0) {
                fontProvider = paywallViewAttributes.fontProvider;
            }
            if ((i3 & 4) != 0) {
                bool = paywallViewAttributes.shouldDisplayDismissButton;
            }
            if ((i3 & 8) != 0) {
                bool2 = paywallViewAttributes.condensed;
            }
            return paywallViewAttributes.copy(str, fontProvider, bool, bool2);
        }

        public final String component1() {
            return this.offeringId;
        }

        public final FontProvider component2() {
            return this.fontProvider;
        }

        public final Boolean component3() {
            return this.shouldDisplayDismissButton;
        }

        public final Boolean component4() {
            return this.condensed;
        }

        public final PaywallViewAttributes copy(String str, FontProvider fontProvider, Boolean bool, Boolean bool2) {
            return new PaywallViewAttributes(str, fontProvider, bool, bool2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallViewAttributes)) {
                return false;
            }
            PaywallViewAttributes paywallViewAttributes = (PaywallViewAttributes) obj;
            return Intrinsics.areEqual(this.offeringId, paywallViewAttributes.offeringId) && Intrinsics.areEqual(this.fontProvider, paywallViewAttributes.fontProvider) && Intrinsics.areEqual(this.shouldDisplayDismissButton, paywallViewAttributes.shouldDisplayDismissButton) && Intrinsics.areEqual(this.condensed, paywallViewAttributes.condensed);
        }

        public final Boolean getCondensed() {
            return this.condensed;
        }

        public final FontProvider getFontProvider() {
            return this.fontProvider;
        }

        public final String getOfferingId() {
            return this.offeringId;
        }

        public final Boolean getShouldDisplayDismissButton() {
            return this.shouldDisplayDismissButton;
        }

        public int hashCode() {
            String str = this.offeringId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            FontProvider fontProvider = this.fontProvider;
            int iHashCode2 = (iHashCode + (fontProvider == null ? 0 : fontProvider.hashCode())) * 31;
            Boolean bool = this.shouldDisplayDismissButton;
            int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.condensed;
            return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "PaywallViewAttributes(offeringId=" + this.offeringId + ", fontProvider=" + this.fontProvider + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", condensed=" + this.condensed + ')';
        }
    }

    static {
        int[] iArr = R.styleable.PaywallView;
        Companion.Attributes attributes = Companion.Attributes.OfferingId;
        Pair pairA = TuplesKt.a(attributes, Integer.valueOf(R.styleable.PaywallView_offeringIdentifier));
        Pair pairA2 = TuplesKt.a(Companion.Attributes.ShouldDisplayDismissButton, Integer.valueOf(R.styleable.PaywallView_shouldDisplayDismissButton));
        Companion.Attributes attributes2 = Companion.Attributes.FontFamily;
        styleablesByStyleSet = MapsKt.mapOf(TuplesKt.a(iArr, MapsKt.mapOf(pairA, pairA2, TuplesKt.a(attributes2, Integer.valueOf(R.styleable.PaywallView_android_fontFamily)))), TuplesKt.a(R.styleable.PaywallFooterView, MapsKt.mapOf(TuplesKt.a(attributes, Integer.valueOf(R.styleable.PaywallFooterView_offeringIdentifier)), TuplesKt.a(attributes2, Integer.valueOf(R.styleable.PaywallFooterView_android_fontFamily)))));
    }
}
