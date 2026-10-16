package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.PromoOfferConfig;
import com.revenuecat.purchases.paywalls.components.common.ResilientPromoOfferConfigSerializer;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
@SerialName
@Metadata
@Serializable
public final class PackageComponent implements PaywallComponent {
    private final boolean isSelectedByDefault;
    private final String name;
    private final List<ComponentOverride<PartialPackageComponent>> overrides;
    private final String packageId;
    private final PromoOfferConfig playStoreOffer;
    private final StackComponent stack;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, new ArrayListSerializer(ComponentOverride.Companion.serializer(PartialPackageComponent$$serializer.INSTANCE))};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PackageComponent> serializer() {
            return PackageComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ PackageComponent(int i3, @SerialName String str, @SerialName boolean z2, StackComponent stackComponent, @SerialName @Serializable(with = ResilientPromoOfferConfigSerializer.class) PromoOfferConfig promoOfferConfig, @SerialName String str2, Boolean bool, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, PackageComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.packageId = str;
        this.isSelectedByDefault = z2;
        this.stack = stackComponent;
        if ((i3 & 8) == 0) {
            this.playStoreOffer = null;
        } else {
            this.playStoreOffer = promoOfferConfig;
        }
        if ((i3 & 16) == 0) {
            this.name = null;
        } else {
            this.name = str2;
        }
        if ((i3 & 32) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i3 & 64) == 0) {
            this.overrides = CollectionsKt.emptyList();
        } else {
            this.overrides = list;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PackageComponent packageComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, packageComponent.packageId);
        compositeEncoder.x(serialDescriptor, 1, packageComponent.isSelectedByDefault);
        compositeEncoder.C(serialDescriptor, 2, StackComponent$$serializer.INSTANCE, packageComponent.stack);
        if (compositeEncoder.z(serialDescriptor, 3) || packageComponent.playStoreOffer != null) {
            compositeEncoder.i(serialDescriptor, 3, ResilientPromoOfferConfigSerializer.INSTANCE, packageComponent.playStoreOffer);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || packageComponent.name != null) {
            compositeEncoder.i(serialDescriptor, 4, StringSerializer.f142891a, packageComponent.name);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || packageComponent.visible != null) {
            compositeEncoder.i(serialDescriptor, 5, BooleanSerializer.f142767a, packageComponent.visible);
        }
        if (!compositeEncoder.z(serialDescriptor, 6) && Intrinsics.areEqual(packageComponent.overrides, CollectionsKt.emptyList())) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 6, kSerializerArr[6], packageComponent.overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PackageComponent)) {
            return false;
        }
        PackageComponent packageComponent = (PackageComponent) obj;
        return Intrinsics.areEqual(this.packageId, packageComponent.packageId) && this.isSelectedByDefault == packageComponent.isSelectedByDefault && Intrinsics.areEqual(this.stack, packageComponent.stack) && Intrinsics.areEqual(this.playStoreOffer, packageComponent.playStoreOffer) && Intrinsics.areEqual(this.name, packageComponent.name) && Intrinsics.areEqual(this.visible, packageComponent.visible) && Intrinsics.areEqual(this.overrides, packageComponent.overrides);
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ String getPackageId() {
        return this.packageId;
    }

    public final /* synthetic */ PromoOfferConfig getPlayStoreOffer() {
        return this.playStoreOffer;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((this.packageId.hashCode() * 31) + Boolean.hashCode(this.isSelectedByDefault)) * 31) + this.stack.hashCode()) * 31;
        PromoOfferConfig promoOfferConfig = this.playStoreOffer;
        int iHashCode2 = (iHashCode + (promoOfferConfig == null ? 0 : promoOfferConfig.hashCode())) * 31;
        String str = this.name;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.visible;
        return ((iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31) + this.overrides.hashCode();
    }

    public final /* synthetic */ boolean isSelectedByDefault() {
        return this.isSelectedByDefault;
    }

    public String toString() {
        return "PackageComponent(packageId=" + this.packageId + ", isSelectedByDefault=" + this.isSelectedByDefault + ", stack=" + this.stack + ", playStoreOffer=" + this.playStoreOffer + ", name=" + this.name + ", visible=" + this.visible + ", overrides=" + this.overrides + ')';
    }

    public PackageComponent(String packageId, boolean z2, StackComponent stack, PromoOfferConfig promoOfferConfig, String str, Boolean bool, List<ComponentOverride<PartialPackageComponent>> overrides) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.packageId = packageId;
        this.isSelectedByDefault = z2;
        this.stack = stack;
        this.playStoreOffer = promoOfferConfig;
        this.name = str;
        this.visible = bool;
        this.overrides = overrides;
    }

    public /* synthetic */ PackageComponent(String str, boolean z2, StackComponent stackComponent, PromoOfferConfig promoOfferConfig, String str2, Boolean bool, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z2, stackComponent, (i3 & 8) != 0 ? null : promoOfferConfig, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : bool, (i3 & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    @SerialName
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPackageId$annotations() {
    }

    @SerialName
    @Serializable(with = ResilientPromoOfferConfigSerializer.class)
    public static /* synthetic */ void getPlayStoreOffer$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isSelectedByDefault$annotations() {
    }
}
