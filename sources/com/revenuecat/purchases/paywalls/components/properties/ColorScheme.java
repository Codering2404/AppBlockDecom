package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
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
public final class ColorScheme {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final ColorInfo dark;
    private final ColorInfo light;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ColorScheme> serializer() {
            return ColorScheme$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        KClass kClassB = Reflection.b(ColorInfo.class);
        KClass[] kClassArr = {Reflection.b(ColorInfo.Alias.class), Reflection.b(ColorInfo.Gradient.Linear.class), Reflection.b(ColorInfo.Gradient.Radial.class), Reflection.b(ColorInfo.Hex.class)};
        ColorInfo$Alias$$serializer colorInfo$Alias$$serializer = ColorInfo$Alias$$serializer.INSTANCE;
        ColorInfo$Gradient$Linear$$serializer colorInfo$Gradient$Linear$$serializer = ColorInfo$Gradient$Linear$$serializer.INSTANCE;
        ColorInfo$Gradient$Radial$$serializer colorInfo$Gradient$Radial$$serializer = ColorInfo$Gradient$Radial$$serializer.INSTANCE;
        ColorInfo$Hex$$serializer colorInfo$Hex$$serializer = ColorInfo$Hex$$serializer.INSTANCE;
        $childSerializers = new KSerializer[]{new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.properties.ColorInfo", kClassB, kClassArr, new KSerializer[]{colorInfo$Alias$$serializer, colorInfo$Gradient$Linear$$serializer, colorInfo$Gradient$Radial$$serializer, colorInfo$Hex$$serializer}, new Annotation[0]), new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.properties.ColorInfo", Reflection.b(ColorInfo.class), new KClass[]{Reflection.b(ColorInfo.Alias.class), Reflection.b(ColorInfo.Gradient.Linear.class), Reflection.b(ColorInfo.Gradient.Radial.class), Reflection.b(ColorInfo.Hex.class)}, new KSerializer[]{colorInfo$Alias$$serializer, colorInfo$Gradient$Linear$$serializer, colorInfo$Gradient$Radial$$serializer, colorInfo$Hex$$serializer}, new Annotation[0])};
    }

    @Deprecated
    public /* synthetic */ ColorScheme(int i3, ColorInfo colorInfo, ColorInfo colorInfo2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, ColorScheme$$serializer.INSTANCE.getDescriptor());
        }
        this.light = colorInfo;
        if ((i3 & 2) == 0) {
            this.dark = null;
        } else {
            this.dark = colorInfo2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ColorScheme colorScheme, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], colorScheme.light);
        if (!compositeEncoder.z(serialDescriptor, 1) && colorScheme.dark == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 1, kSerializerArr[1], colorScheme.dark);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorScheme)) {
            return false;
        }
        ColorScheme colorScheme = (ColorScheme) obj;
        return Intrinsics.areEqual(this.light, colorScheme.light) && Intrinsics.areEqual(this.dark, colorScheme.dark);
    }

    public final /* synthetic */ ColorInfo getDark() {
        return this.dark;
    }

    public final /* synthetic */ ColorInfo getLight() {
        return this.light;
    }

    public int hashCode() {
        int iHashCode = this.light.hashCode() * 31;
        ColorInfo colorInfo = this.dark;
        return iHashCode + (colorInfo == null ? 0 : colorInfo.hashCode());
    }

    public String toString() {
        return "ColorScheme(light=" + this.light + ", dark=" + this.dark + ')';
    }

    public ColorScheme(ColorInfo light, ColorInfo colorInfo) {
        Intrinsics.checkNotNullParameter(light, "light");
        this.light = light;
        this.dark = colorInfo;
    }

    public /* synthetic */ ColorScheme(ColorInfo colorInfo, ColorInfo colorInfo2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorInfo, (i3 & 2) != 0 ? null : colorInfo2);
    }
}
