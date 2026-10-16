package com.revenuecat.purchases.paywalls;

import android.graphics.Color;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

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
public final class PaywallColor {
    private final int colorInt;
    private final String stringRepresentation;
    private final Color underlyingColor;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Serializer implements KSerializer<PaywallColor> {
        public static final Serializer INSTANCE = new Serializer();
        private static final SerialDescriptor descriptor = SerialDescriptorsKt.c("PaywallColor", PrimitiveKind.STRING.f142732a);

        private Serializer() {
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public PaywallColor deserialize(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            return new PaywallColor(decoder.z());
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder, PaywallColor value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            encoder.G(value.toString());
        }
    }

    public PaywallColor(String stringRepresentation, Color color) {
        Intrinsics.checkNotNullParameter(stringRepresentation, "stringRepresentation");
        this.stringRepresentation = stringRepresentation;
        this.underlyingColor = color;
        this.colorInt = ColorUtilsKt.parseRGBAColor(stringRepresentation);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallColor)) {
            return false;
        }
        PaywallColor paywallColor = (PaywallColor) obj;
        return Intrinsics.areEqual(this.stringRepresentation, paywallColor.stringRepresentation) && Intrinsics.areEqual(this.underlyingColor, paywallColor.underlyingColor);
    }

    public final int getColorInt() {
        return this.colorInt;
    }

    public final String getStringRepresentation() {
        return this.stringRepresentation;
    }

    public final Color getUnderlyingColor() {
        return this.underlyingColor;
    }

    public int hashCode() {
        int iHashCode = this.stringRepresentation.hashCode() * 31;
        Color color = this.underlyingColor;
        return iHashCode + (color == null ? 0 : color.hashCode());
    }

    public String toString() {
        return "PaywallColor(stringRepresentation=" + this.stringRepresentation + ", underlyingColor=" + this.underlyingColor + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallColor(String stringRepresentation) {
        this(stringRepresentation, Color.valueOf(ColorUtilsKt.parseRGBAColor(stringRepresentation)));
        Intrinsics.checkNotNullParameter(stringRepresentation, "stringRepresentation");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PaywallColor(int i3) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(Locale.US, "#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & i3)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        this(str, Color.valueOf(i3));
    }
}
