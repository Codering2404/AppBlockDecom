package com.revenuecat.purchases.paywalls.components.properties;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
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
public final class Padding {
    private final double bottom;
    private final double leading;
    private final double top;
    private final double trailing;
    public static final Companion Companion = new Companion(null);
    private static final Padding zero = new Padding(0.0d, 0.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final Padding f3default = new Padding(10.0d, 10.0d, 20.0d, 20.0d);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Padding getDefault() {
            return Padding.f3default;
        }

        public final /* synthetic */ Padding getZero() {
            return Padding.zero;
        }

        public final KSerializer<Padding> serializer() {
            return Padding$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Padding() {
        this(0.0d, 0.0d, 0.0d, 0.0d, 15, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Padding padding, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || Double.compare(padding.top, 0.0d) != 0) {
            compositeEncoder.E(serialDescriptor, 0, padding.top);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || Double.compare(padding.bottom, 0.0d) != 0) {
            compositeEncoder.E(serialDescriptor, 1, padding.bottom);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || Double.compare(padding.leading, 0.0d) != 0) {
            compositeEncoder.E(serialDescriptor, 2, padding.leading);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && Double.compare(padding.trailing, 0.0d) == 0) {
            return;
        }
        compositeEncoder.E(serialDescriptor, 3, padding.trailing);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Padding)) {
            return false;
        }
        Padding padding = (Padding) obj;
        return Double.compare(this.top, padding.top) == 0 && Double.compare(this.bottom, padding.bottom) == 0 && Double.compare(this.leading, padding.leading) == 0 && Double.compare(this.trailing, padding.trailing) == 0;
    }

    public final /* synthetic */ double getBottom() {
        return this.bottom;
    }

    public final /* synthetic */ double getLeading() {
        return this.leading;
    }

    public final /* synthetic */ double getTop() {
        return this.top;
    }

    public final /* synthetic */ double getTrailing() {
        return this.trailing;
    }

    public int hashCode() {
        return (((((Double.hashCode(this.top) * 31) + Double.hashCode(this.bottom)) * 31) + Double.hashCode(this.leading)) * 31) + Double.hashCode(this.trailing);
    }

    public String toString() {
        return "Padding(top=" + this.top + ", bottom=" + this.bottom + ", leading=" + this.leading + ", trailing=" + this.trailing + ')';
    }

    public Padding(double d3, double d4, double d5, double d6) {
        this.top = d3;
        this.bottom = d4;
        this.leading = d5;
        this.trailing = d6;
    }

    @Deprecated
    public /* synthetic */ Padding(int i3, double d3, double d4, double d5, double d6, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i3 & 1) == 0) {
            this.top = 0.0d;
        } else {
            this.top = d3;
        }
        if ((i3 & 2) == 0) {
            this.bottom = 0.0d;
        } else {
            this.bottom = d4;
        }
        if ((i3 & 4) == 0) {
            this.leading = 0.0d;
        } else {
            this.leading = d5;
        }
        if ((i3 & 8) == 0) {
            this.trailing = 0.0d;
        } else {
            this.trailing = d6;
        }
    }

    public /* synthetic */ Padding(double d3, double d4, double d5, double d6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0d : d3, (i3 & 2) != 0 ? 0.0d : d4, (i3 & 4) != 0 ? 0.0d : d5, (i3 & 8) != 0 ? 0.0d : d6);
    }
}
