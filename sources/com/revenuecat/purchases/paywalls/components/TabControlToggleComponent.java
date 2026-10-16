package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
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
public final class TabControlToggleComponent implements PaywallComponent {
    public static final Companion Companion = new Companion(null);
    private final boolean defaultValue;
    private final String name;
    private final ColorScheme thumbColorOff;
    private final ColorScheme thumbColorOn;
    private final ColorScheme trackColorOff;
    private final ColorScheme trackColorOn;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TabControlToggleComponent> serializer() {
            return TabControlToggleComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ TabControlToggleComponent(int i3, @SerialName boolean z2, String str, @SerialName ColorScheme colorScheme, @SerialName ColorScheme colorScheme2, @SerialName ColorScheme colorScheme3, @SerialName ColorScheme colorScheme4, SerializationConstructorMarker serializationConstructorMarker) {
        if (61 != (i3 & 61)) {
            PluginExceptionsKt.b(i3, 61, TabControlToggleComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.defaultValue = z2;
        if ((i3 & 2) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
        this.thumbColorOn = colorScheme;
        this.thumbColorOff = colorScheme2;
        this.trackColorOn = colorScheme3;
        this.trackColorOff = colorScheme4;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(TabControlToggleComponent tabControlToggleComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.x(serialDescriptor, 0, tabControlToggleComponent.defaultValue);
        if (compositeEncoder.z(serialDescriptor, 1) || tabControlToggleComponent.name != null) {
            compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, tabControlToggleComponent.name);
        }
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        compositeEncoder.C(serialDescriptor, 2, colorScheme$$serializer, tabControlToggleComponent.thumbColorOn);
        compositeEncoder.C(serialDescriptor, 3, colorScheme$$serializer, tabControlToggleComponent.thumbColorOff);
        compositeEncoder.C(serialDescriptor, 4, colorScheme$$serializer, tabControlToggleComponent.trackColorOn);
        compositeEncoder.C(serialDescriptor, 5, colorScheme$$serializer, tabControlToggleComponent.trackColorOff);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabControlToggleComponent)) {
            return false;
        }
        TabControlToggleComponent tabControlToggleComponent = (TabControlToggleComponent) obj;
        return this.defaultValue == tabControlToggleComponent.defaultValue && Intrinsics.areEqual(this.name, tabControlToggleComponent.name) && Intrinsics.areEqual(this.thumbColorOn, tabControlToggleComponent.thumbColorOn) && Intrinsics.areEqual(this.thumbColorOff, tabControlToggleComponent.thumbColorOff) && Intrinsics.areEqual(this.trackColorOn, tabControlToggleComponent.trackColorOn) && Intrinsics.areEqual(this.trackColorOff, tabControlToggleComponent.trackColorOff);
    }

    public final /* synthetic */ boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    public final /* synthetic */ ColorScheme getThumbColorOff() {
        return this.thumbColorOff;
    }

    public final /* synthetic */ ColorScheme getThumbColorOn() {
        return this.thumbColorOn;
    }

    public final /* synthetic */ ColorScheme getTrackColorOff() {
        return this.trackColorOff;
    }

    public final /* synthetic */ ColorScheme getTrackColorOn() {
        return this.trackColorOn;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.defaultValue) * 31;
        String str = this.name;
        return ((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.thumbColorOn.hashCode()) * 31) + this.thumbColorOff.hashCode()) * 31) + this.trackColorOn.hashCode()) * 31) + this.trackColorOff.hashCode();
    }

    public String toString() {
        return "TabControlToggleComponent(defaultValue=" + this.defaultValue + ", name=" + this.name + ", thumbColorOn=" + this.thumbColorOn + ", thumbColorOff=" + this.thumbColorOff + ", trackColorOn=" + this.trackColorOn + ", trackColorOff=" + this.trackColorOff + ')';
    }

    public TabControlToggleComponent(boolean z2, String str, ColorScheme thumbColorOn, ColorScheme thumbColorOff, ColorScheme trackColorOn, ColorScheme trackColorOff) {
        Intrinsics.checkNotNullParameter(thumbColorOn, "thumbColorOn");
        Intrinsics.checkNotNullParameter(thumbColorOff, "thumbColorOff");
        Intrinsics.checkNotNullParameter(trackColorOn, "trackColorOn");
        Intrinsics.checkNotNullParameter(trackColorOff, "trackColorOff");
        this.defaultValue = z2;
        this.name = str;
        this.thumbColorOn = thumbColorOn;
        this.thumbColorOff = thumbColorOff;
        this.trackColorOn = trackColorOn;
        this.trackColorOff = trackColorOff;
    }

    public /* synthetic */ TabControlToggleComponent(boolean z2, String str, ColorScheme colorScheme, ColorScheme colorScheme2, ColorScheme colorScheme3, ColorScheme colorScheme4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, (i3 & 2) != 0 ? null : str, colorScheme, colorScheme2, colorScheme3, colorScheme4);
    }

    @SerialName
    public static /* synthetic */ void getDefaultValue$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getThumbColorOff$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getThumbColorOn$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTrackColorOff$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTrackColorOn$annotations() {
    }
}
