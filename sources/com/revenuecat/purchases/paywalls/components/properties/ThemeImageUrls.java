package com.revenuecat.purchases.paywalls.components.properties;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Serializable
public final class ThemeImageUrls {
    public static final Companion Companion = new Companion(null);
    private final ImageUrls dark;
    private final ImageUrls light;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ThemeImageUrls> serializer() {
            return ThemeImageUrls$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ ThemeImageUrls(int i3, ImageUrls imageUrls, ImageUrls imageUrls2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, ThemeImageUrls$$serializer.INSTANCE.getDescriptor());
        }
        this.light = imageUrls;
        if ((i3 & 2) == 0) {
            this.dark = null;
        } else {
            this.dark = imageUrls2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ThemeImageUrls themeImageUrls, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        ImageUrls$$serializer imageUrls$$serializer = ImageUrls$$serializer.INSTANCE;
        compositeEncoder.C(serialDescriptor, 0, imageUrls$$serializer, themeImageUrls.light);
        if (!compositeEncoder.z(serialDescriptor, 1) && themeImageUrls.dark == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 1, imageUrls$$serializer, themeImageUrls.dark);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThemeImageUrls)) {
            return false;
        }
        ThemeImageUrls themeImageUrls = (ThemeImageUrls) obj;
        return Intrinsics.areEqual(this.light, themeImageUrls.light) && Intrinsics.areEqual(this.dark, themeImageUrls.dark);
    }

    public final /* synthetic */ ImageUrls getDark() {
        return this.dark;
    }

    public final /* synthetic */ ImageUrls getLight() {
        return this.light;
    }

    public int hashCode() {
        int iHashCode = this.light.hashCode() * 31;
        ImageUrls imageUrls = this.dark;
        return iHashCode + (imageUrls == null ? 0 : imageUrls.hashCode());
    }

    public String toString() {
        return "ThemeImageUrls(light=" + this.light + ", dark=" + this.dark + ')';
    }

    public ThemeImageUrls(ImageUrls light, ImageUrls imageUrls) {
        Intrinsics.checkNotNullParameter(light, "light");
        this.light = light;
        this.dark = imageUrls;
    }

    public /* synthetic */ ThemeImageUrls(ImageUrls imageUrls, ImageUrls imageUrls2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageUrls, (i3 & 2) != 0 ? null : imageUrls2);
    }
}
