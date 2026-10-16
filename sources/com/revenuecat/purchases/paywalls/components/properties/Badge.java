package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
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
public final class Badge {
    public static final Companion Companion = new Companion(null);
    private final TwoDimensionalAlignment alignment;
    private final StackComponent stack;
    private final Style style;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Badge> serializer() {
            return Badge$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = BadgeStyleSerializer.class)
    public enum Style {
        Overlay,
        EdgeToEdge,
        Nested;

        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Style> serializer() {
                return BadgeStyleSerializer.INSTANCE;
            }

            private Companion() {
            }
        }
    }

    @Deprecated
    public /* synthetic */ Badge(int i3, StackComponent stackComponent, Style style, TwoDimensionalAlignment twoDimensionalAlignment, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, Badge$$serializer.INSTANCE.getDescriptor());
        }
        this.stack = stackComponent;
        this.style = style;
        this.alignment = twoDimensionalAlignment;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Badge badge, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, StackComponent$$serializer.INSTANCE, badge.stack);
        compositeEncoder.C(serialDescriptor, 1, BadgeStyleSerializer.INSTANCE, badge.style);
        compositeEncoder.C(serialDescriptor, 2, TwoDimensionalAlignmentDeserializer.INSTANCE, badge.alignment);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Badge)) {
            return false;
        }
        Badge badge = (Badge) obj;
        return Intrinsics.areEqual(this.stack, badge.stack) && this.style == badge.style && this.alignment == badge.alignment;
    }

    public final /* synthetic */ TwoDimensionalAlignment getAlignment() {
        return this.alignment;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ Style getStyle() {
        return this.style;
    }

    public int hashCode() {
        return (((this.stack.hashCode() * 31) + this.style.hashCode()) * 31) + this.alignment.hashCode();
    }

    public String toString() {
        return "Badge(stack=" + this.stack + ", style=" + this.style + ", alignment=" + this.alignment + ')';
    }

    public Badge(StackComponent stack, Style style, TwoDimensionalAlignment alignment) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.stack = stack;
        this.style = style;
        this.alignment = alignment;
    }
}
