package com.revenuecat.purchases.paywalls.components.properties;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
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
@Serializable(with = CornerRadiusesSerializer.class)
public interface CornerRadiuses {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<CornerRadiuses> serializer() {
            return CornerRadiusesSerializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Dp implements CornerRadiuses {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: renamed from: default, reason: not valid java name */
        private static final Dp f2default;
        private static final Dp zero;
        private final double bottomLeading;
        private final double bottomTrailing;
        private final double topLeading;
        private final double topTrailing;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final /* synthetic */ Dp getDefault() {
                return Dp.f2default;
            }

            public final /* synthetic */ Dp getZero() {
                return Dp.zero;
            }

            public final KSerializer<Dp> serializer() {
                return CornerRadiuses$Dp$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        static {
            Dp dp = new Dp(0.0d, 0.0d, 0.0d, 0.0d);
            zero = dp;
            f2default = dp;
        }

        public Dp(double d3, double d4, double d5, double d6) {
            this.topLeading = d3;
            this.topTrailing = d4;
            this.bottomLeading = d5;
            this.bottomTrailing = d6;
        }

        public static /* synthetic */ Dp copy$default(Dp dp, double d3, double d4, double d5, double d6, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                d3 = dp.topLeading;
            }
            double d7 = d3;
            if ((i3 & 2) != 0) {
                d4 = dp.topTrailing;
            }
            double d8 = d4;
            if ((i3 & 4) != 0) {
                d5 = dp.bottomLeading;
            }
            return dp.copy(d7, d8, d5, (i3 & 8) != 0 ? dp.bottomTrailing : d6);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Dp dp, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.E(serialDescriptor, 0, dp.topLeading);
            compositeEncoder.E(serialDescriptor, 1, dp.topTrailing);
            compositeEncoder.E(serialDescriptor, 2, dp.bottomLeading);
            compositeEncoder.E(serialDescriptor, 3, dp.bottomTrailing);
        }

        public final Dp copy(double d3, double d4, double d5, double d6) {
            return new Dp(d3, d4, d5, d6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dp)) {
                return false;
            }
            Dp dp = (Dp) obj;
            return Double.compare(this.topLeading, dp.topLeading) == 0 && Double.compare(this.topTrailing, dp.topTrailing) == 0 && Double.compare(this.bottomLeading, dp.bottomLeading) == 0 && Double.compare(this.bottomTrailing, dp.bottomTrailing) == 0;
        }

        public final /* synthetic */ double getBottomLeading() {
            return this.bottomLeading;
        }

        public final /* synthetic */ double getBottomTrailing() {
            return this.bottomTrailing;
        }

        public final /* synthetic */ double getTopLeading() {
            return this.topLeading;
        }

        public final /* synthetic */ double getTopTrailing() {
            return this.topTrailing;
        }

        public int hashCode() {
            return (((((Double.hashCode(this.topLeading) * 31) + Double.hashCode(this.topTrailing)) * 31) + Double.hashCode(this.bottomLeading)) * 31) + Double.hashCode(this.bottomTrailing);
        }

        public String toString() {
            return "Dp(topLeading=" + this.topLeading + ", topTrailing=" + this.topTrailing + ", bottomLeading=" + this.bottomLeading + ", bottomTrailing=" + this.bottomTrailing + ')';
        }

        @Deprecated
        public /* synthetic */ Dp(int i3, @SerialName double d3, @SerialName double d4, @SerialName double d5, @SerialName double d6, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i3 & 15)) {
                PluginExceptionsKt.b(i3, 15, CornerRadiuses$Dp$$serializer.INSTANCE.getDescriptor());
            }
            this.topLeading = d3;
            this.topTrailing = d4;
            this.bottomLeading = d5;
            this.bottomTrailing = d6;
        }

        public Dp(double d3) {
            this(d3, d3, d3, d3);
        }

        @SerialName
        public static /* synthetic */ void getBottomLeading$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getBottomTrailing$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getTopLeading$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getTopTrailing$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Percentage implements CornerRadiuses {
        public static final Companion Companion = new Companion(null);
        private final int bottomLeading;
        private final int bottomTrailing;
        private final int topLeading;
        private final int topTrailing;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Percentage> serializer() {
                return CornerRadiuses$Percentage$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Percentage(int i3, int i4, int i5, int i6) {
            this.topLeading = i3;
            this.topTrailing = i4;
            this.bottomLeading = i5;
            this.bottomTrailing = i6;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Percentage percentage, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.w(serialDescriptor, 0, percentage.topLeading);
            compositeEncoder.w(serialDescriptor, 1, percentage.topTrailing);
            compositeEncoder.w(serialDescriptor, 2, percentage.bottomLeading);
            compositeEncoder.w(serialDescriptor, 3, percentage.bottomTrailing);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Percentage)) {
                return false;
            }
            Percentage percentage = (Percentage) obj;
            return this.topLeading == percentage.topLeading && this.topTrailing == percentage.topTrailing && this.bottomLeading == percentage.bottomLeading && this.bottomTrailing == percentage.bottomTrailing;
        }

        public final /* synthetic */ int getBottomLeading() {
            return this.bottomLeading;
        }

        public final /* synthetic */ int getBottomTrailing() {
            return this.bottomTrailing;
        }

        public final /* synthetic */ int getTopLeading() {
            return this.topLeading;
        }

        public final /* synthetic */ int getTopTrailing() {
            return this.topTrailing;
        }

        public int hashCode() {
            return (((((this.topLeading * 31) + this.topTrailing) * 31) + this.bottomLeading) * 31) + this.bottomTrailing;
        }

        public String toString() {
            return "Percentage(topLeading=" + this.topLeading + ", topTrailing=" + this.topTrailing + ", bottomLeading=" + this.bottomLeading + ", bottomTrailing=" + this.bottomTrailing + ')';
        }

        @Deprecated
        public /* synthetic */ Percentage(int i3, @SerialName int i4, @SerialName int i5, @SerialName int i6, @SerialName int i7, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i3 & 15)) {
                PluginExceptionsKt.b(i3, 15, CornerRadiuses$Percentage$$serializer.INSTANCE.getDescriptor());
            }
            this.topLeading = i4;
            this.topTrailing = i5;
            this.bottomLeading = i6;
            this.bottomTrailing = i7;
        }

        public Percentage(int i3) {
            this(i3, i3, i3, i3);
        }

        @SerialName
        public static /* synthetic */ void getBottomLeading$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getBottomTrailing$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getTopLeading$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getTopTrailing$annotations() {
        }
    }
}
