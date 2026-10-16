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
public final class Shadow {
    public static final Companion Companion = new Companion(null);
    private final ColorScheme color;
    private final double radius;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final double f92313x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final double f92314y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Shadow> serializer() {
            return Shadow$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ Shadow(int i3, ColorScheme colorScheme, double d3, double d4, double d5, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i3 & 15)) {
            PluginExceptionsKt.b(i3, 15, Shadow$$serializer.INSTANCE.getDescriptor());
        }
        this.color = colorScheme;
        this.radius = d3;
        this.f92313x = d4;
        this.f92314y = d5;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Shadow shadow, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, ColorScheme$$serializer.INSTANCE, shadow.color);
        compositeEncoder.E(serialDescriptor, 1, shadow.radius);
        compositeEncoder.E(serialDescriptor, 2, shadow.f92313x);
        compositeEncoder.E(serialDescriptor, 3, shadow.f92314y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) obj;
        return Intrinsics.areEqual(this.color, shadow.color) && Double.compare(this.radius, shadow.radius) == 0 && Double.compare(this.f92313x, shadow.f92313x) == 0 && Double.compare(this.f92314y, shadow.f92314y) == 0;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    public final /* synthetic */ double getRadius() {
        return this.radius;
    }

    public final /* synthetic */ double getX() {
        return this.f92313x;
    }

    public final /* synthetic */ double getY() {
        return this.f92314y;
    }

    public int hashCode() {
        return (((((this.color.hashCode() * 31) + Double.hashCode(this.radius)) * 31) + Double.hashCode(this.f92313x)) * 31) + Double.hashCode(this.f92314y);
    }

    public String toString() {
        return "Shadow(color=" + this.color + ", radius=" + this.radius + ", x=" + this.f92313x + ", y=" + this.f92314y + ')';
    }

    public Shadow(ColorScheme color, double d3, double d4, double d5) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
        this.radius = d3;
        this.f92313x = d4;
        this.f92314y = d5;
    }
}
