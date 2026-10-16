package com.revenuecat.purchases.ui.revenuecatui.activity;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.fonts.ParcelizableFontProvider;
import com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallFontFamily;
import com.revenuecat.purchases.ui.revenuecatui.fonts.TypographyType;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class PaywallActivityArgs implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PaywallActivityArgs> CREATOR = new Creator();
    private final Map<String, CustomVariableValue> customVariables;
    private final boolean edgeToEdge;
    private final Map<TypographyType, PaywallFontFamily> fonts;
    private final Integer nonSerializableArgsKey;
    private final OfferingSelection.IdAndPresentedOfferingContext offeringIdAndPresentedOfferingContext;
    private final String requiredEntitlementIdentifier;
    private final boolean shouldDisplayDismissButton;
    private final boolean wasLaunchedThroughSDK;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<PaywallActivityArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        public final PaywallActivityArgs createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            int i3;
            LinkedHashMap linkedHashMap2;
            boolean z2;
            boolean z3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContextCreateFromParcel = parcel.readInt() == 0 ? null : OfferingSelection.IdAndPresentedOfferingContext.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i4 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(i4);
                for (int i5 = 0; i5 != i4; i5++) {
                    linkedHashMap.put(TypographyType.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : PaywallFontFamily.CREATOR.createFromParcel(parcel));
                }
            }
            boolean z4 = 1;
            if (parcel.readInt() != 0) {
                i3 = 0;
                linkedHashMap2 = linkedHashMap;
                z2 = true;
            } else {
                i3 = 0;
                linkedHashMap2 = linkedHashMap;
                z2 = false;
            }
            if (parcel.readInt() != 0) {
                z3 = true;
            } else {
                z3 = true;
                z4 = i3;
            }
            boolean z5 = z3;
            if (parcel.readInt() == 0) {
                z5 = i3;
            }
            int i6 = parcel.readInt();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(i6);
            while (i3 != i6) {
                linkedHashMap3.put(parcel.readString(), parcel.readParcelable(PaywallActivityArgs.class.getClassLoader()));
                i3++;
            }
            return new PaywallActivityArgs(string, idAndPresentedOfferingContextCreateFromParcel, linkedHashMap2, z2, z4, z5, linkedHashMap3, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaywallActivityArgs[] newArray(int i3) {
            return new PaywallActivityArgs[i3];
        }
    }

    public PaywallActivityArgs() {
        this((String) null, (OfferingSelection.IdAndPresentedOfferingContext) null, (Map) null, false, false, false, (Map) null, (Integer) null, 255, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallActivityArgs copy$default(PaywallActivityArgs paywallActivityArgs, String str, OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext, Map map, boolean z2, boolean z3, boolean z4, Map map2, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = paywallActivityArgs.requiredEntitlementIdentifier;
        }
        if ((i3 & 2) != 0) {
            idAndPresentedOfferingContext = paywallActivityArgs.offeringIdAndPresentedOfferingContext;
        }
        if ((i3 & 4) != 0) {
            map = paywallActivityArgs.fonts;
        }
        if ((i3 & 8) != 0) {
            z2 = paywallActivityArgs.shouldDisplayDismissButton;
        }
        if ((i3 & 16) != 0) {
            z3 = paywallActivityArgs.edgeToEdge;
        }
        if ((i3 & 32) != 0) {
            z4 = paywallActivityArgs.wasLaunchedThroughSDK;
        }
        if ((i3 & 64) != 0) {
            map2 = paywallActivityArgs.customVariables;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            num = paywallActivityArgs.nonSerializableArgsKey;
        }
        Map map3 = map2;
        Integer num2 = num;
        boolean z5 = z3;
        boolean z6 = z4;
        return paywallActivityArgs.copy(str, idAndPresentedOfferingContext, map, z2, z5, z6, map3, num2);
    }

    public final String component1() {
        return this.requiredEntitlementIdentifier;
    }

    public final OfferingSelection.IdAndPresentedOfferingContext component2() {
        return this.offeringIdAndPresentedOfferingContext;
    }

    public final Map<TypographyType, PaywallFontFamily> component3() {
        return this.fonts;
    }

    public final boolean component4() {
        return this.shouldDisplayDismissButton;
    }

    public final boolean component5() {
        return this.edgeToEdge;
    }

    public final boolean component6() {
        return this.wasLaunchedThroughSDK;
    }

    public final Map<String, CustomVariableValue> component7() {
        return this.customVariables;
    }

    public final Integer component8() {
        return this.nonSerializableArgsKey;
    }

    public final PaywallActivityArgs copy(String str, OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext, Map<TypographyType, PaywallFontFamily> map, boolean z2, boolean z3, boolean z4, Map<String, ? extends CustomVariableValue> customVariables, Integer num) {
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        return new PaywallActivityArgs(str, idAndPresentedOfferingContext, map, z2, z3, z4, customVariables, num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallActivityArgs)) {
            return false;
        }
        PaywallActivityArgs paywallActivityArgs = (PaywallActivityArgs) obj;
        return Intrinsics.areEqual(this.requiredEntitlementIdentifier, paywallActivityArgs.requiredEntitlementIdentifier) && Intrinsics.areEqual(this.offeringIdAndPresentedOfferingContext, paywallActivityArgs.offeringIdAndPresentedOfferingContext) && Intrinsics.areEqual(this.fonts, paywallActivityArgs.fonts) && this.shouldDisplayDismissButton == paywallActivityArgs.shouldDisplayDismissButton && this.edgeToEdge == paywallActivityArgs.edgeToEdge && this.wasLaunchedThroughSDK == paywallActivityArgs.wasLaunchedThroughSDK && Intrinsics.areEqual(this.customVariables, paywallActivityArgs.customVariables) && Intrinsics.areEqual(this.nonSerializableArgsKey, paywallActivityArgs.nonSerializableArgsKey);
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }

    public final boolean getEdgeToEdge() {
        return this.edgeToEdge;
    }

    public final Map<TypographyType, PaywallFontFamily> getFonts() {
        return this.fonts;
    }

    public final Integer getNonSerializableArgsKey() {
        return this.nonSerializableArgsKey;
    }

    public final OfferingSelection.IdAndPresentedOfferingContext getOfferingIdAndPresentedOfferingContext() {
        return this.offeringIdAndPresentedOfferingContext;
    }

    public final String getRequiredEntitlementIdentifier() {
        return this.requiredEntitlementIdentifier;
    }

    public final boolean getShouldDisplayDismissButton() {
        return this.shouldDisplayDismissButton;
    }

    public final boolean getWasLaunchedThroughSDK() {
        return this.wasLaunchedThroughSDK;
    }

    public int hashCode() {
        String str = this.requiredEntitlementIdentifier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext = this.offeringIdAndPresentedOfferingContext;
        int iHashCode2 = (iHashCode + (idAndPresentedOfferingContext == null ? 0 : idAndPresentedOfferingContext.hashCode())) * 31;
        Map<TypographyType, PaywallFontFamily> map = this.fonts;
        int iHashCode3 = (((((((((iHashCode2 + (map == null ? 0 : map.hashCode())) * 31) + Boolean.hashCode(this.shouldDisplayDismissButton)) * 31) + Boolean.hashCode(this.edgeToEdge)) * 31) + Boolean.hashCode(this.wasLaunchedThroughSDK)) * 31) + this.customVariables.hashCode()) * 31;
        Integer num = this.nonSerializableArgsKey;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "PaywallActivityArgs(requiredEntitlementIdentifier=" + this.requiredEntitlementIdentifier + ", offeringIdAndPresentedOfferingContext=" + this.offeringIdAndPresentedOfferingContext + ", fonts=" + this.fonts + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", edgeToEdge=" + this.edgeToEdge + ", wasLaunchedThroughSDK=" + this.wasLaunchedThroughSDK + ", customVariables=" + this.customVariables + ", nonSerializableArgsKey=" + this.nonSerializableArgsKey + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.requiredEntitlementIdentifier);
        OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext = this.offeringIdAndPresentedOfferingContext;
        if (idAndPresentedOfferingContext == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            idAndPresentedOfferingContext.writeToParcel(out, i3);
        }
        Map<TypographyType, PaywallFontFamily> map = this.fonts;
        if (map == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(map.size());
            for (Map.Entry<TypographyType, PaywallFontFamily> entry : map.entrySet()) {
                out.writeString(entry.getKey().name());
                PaywallFontFamily value = entry.getValue();
                if (value == null) {
                    out.writeInt(0);
                } else {
                    out.writeInt(1);
                    value.writeToParcel(out, i3);
                }
            }
        }
        out.writeInt(this.shouldDisplayDismissButton ? 1 : 0);
        out.writeInt(this.edgeToEdge ? 1 : 0);
        out.writeInt(this.wasLaunchedThroughSDK ? 1 : 0);
        Map<String, CustomVariableValue> map2 = this.customVariables;
        out.writeInt(map2.size());
        for (Map.Entry<String, CustomVariableValue> entry2 : map2.entrySet()) {
            out.writeString(entry2.getKey());
            out.writeParcelable(entry2.getValue(), i3);
        }
        Integer num = this.nonSerializableArgsKey;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallActivityArgs(String str, OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext, Map<TypographyType, PaywallFontFamily> map, boolean z2, boolean z3, boolean z4, Map<String, ? extends CustomVariableValue> customVariables, Integer num) {
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.requiredEntitlementIdentifier = str;
        this.offeringIdAndPresentedOfferingContext = idAndPresentedOfferingContext;
        this.fonts = map;
        this.shouldDisplayDismissButton = z2;
        this.edgeToEdge = z3;
        this.wasLaunchedThroughSDK = z4;
        this.customVariables = customVariables;
        this.nonSerializableArgsKey = num;
    }

    public /* synthetic */ PaywallActivityArgs(String str, OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext, Map map, boolean z2, boolean z3, boolean z4, Map map2, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : idAndPresentedOfferingContext, (Map<TypographyType, PaywallFontFamily>) ((i3 & 4) != 0 ? null : map), (i3 & 8) != 0 ? true : z2, (i3 & 16) != 0 ? PaywallActivityArgsKt.getDefaultEdgeToEdge() : z3, (i3 & 32) != 0 ? true : z4, (Map<String, ? extends CustomVariableValue>) ((i3 & 64) != 0 ? MapsKt.emptyMap() : map2), (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : num);
    }

    public /* synthetic */ PaywallActivityArgs(String str, OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, boolean z4, Map map, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : idAndPresentedOfferingContext, parcelizableFontProvider, (i3 & 8) != 0 ? true : z2, (i3 & 16) != 0 ? PaywallActivityArgsKt.getDefaultEdgeToEdge() : z3, (i3 & 32) != 0 ? true : z4, (Map<String, ? extends CustomVariableValue>) ((i3 & 64) != 0 ? MapsKt.emptyMap() : map), (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : num);
    }

    public PaywallActivityArgs(String str, OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, boolean z4, Map<String, ? extends CustomVariableValue> customVariables, Integer num) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        if (parcelizableFontProvider != null) {
            TypographyType[] typographyTypeArrValues = TypographyType.values();
            linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(typographyTypeArrValues.length), 16));
            for (TypographyType typographyType : typographyTypeArrValues) {
                linkedHashMap.put(typographyType, parcelizableFontProvider.getFont(typographyType));
            }
        } else {
            linkedHashMap = null;
        }
        this(str, idAndPresentedOfferingContext, linkedHashMap, z2, z3, z4, customVariables, num);
    }
}
