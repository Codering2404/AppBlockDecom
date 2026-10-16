package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent$$serializer;
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
public final class PaywallComponentsConfig {
    public static final Companion Companion = new Companion(null);
    private final Background background;
    private final HeaderComponent header;
    private final StackComponent stack;
    private final StickyFooterComponent stickyFooter;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PaywallComponentsConfig> serializer() {
            return PaywallComponentsConfig$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ PaywallComponentsConfig(int i3, StackComponent stackComponent, Background background, @SerialName StickyFooterComponent stickyFooterComponent, HeaderComponent headerComponent, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, PaywallComponentsConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.stack = stackComponent;
        this.background = background;
        if ((i3 & 4) == 0) {
            this.stickyFooter = null;
        } else {
            this.stickyFooter = stickyFooterComponent;
        }
        if ((i3 & 8) == 0) {
            this.header = null;
        } else {
            this.header = headerComponent;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallComponentsConfig paywallComponentsConfig, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, StackComponent$$serializer.INSTANCE, paywallComponentsConfig.stack);
        compositeEncoder.C(serialDescriptor, 1, BackgroundDeserializer.INSTANCE, paywallComponentsConfig.background);
        if (compositeEncoder.z(serialDescriptor, 2) || paywallComponentsConfig.stickyFooter != null) {
            compositeEncoder.i(serialDescriptor, 2, StickyFooterComponent$$serializer.INSTANCE, paywallComponentsConfig.stickyFooter);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && paywallComponentsConfig.header == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 3, HeaderComponent$$serializer.INSTANCE, paywallComponentsConfig.header);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallComponentsConfig)) {
            return false;
        }
        PaywallComponentsConfig paywallComponentsConfig = (PaywallComponentsConfig) obj;
        return Intrinsics.areEqual(this.stack, paywallComponentsConfig.stack) && Intrinsics.areEqual(this.background, paywallComponentsConfig.background) && Intrinsics.areEqual(this.stickyFooter, paywallComponentsConfig.stickyFooter) && Intrinsics.areEqual(this.header, paywallComponentsConfig.header);
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ HeaderComponent getHeader() {
        return this.header;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ StickyFooterComponent getStickyFooter() {
        return this.stickyFooter;
    }

    public int hashCode() {
        int iHashCode = ((this.stack.hashCode() * 31) + this.background.hashCode()) * 31;
        StickyFooterComponent stickyFooterComponent = this.stickyFooter;
        int iHashCode2 = (iHashCode + (stickyFooterComponent == null ? 0 : stickyFooterComponent.hashCode())) * 31;
        HeaderComponent headerComponent = this.header;
        return iHashCode2 + (headerComponent != null ? headerComponent.hashCode() : 0);
    }

    public String toString() {
        return "PaywallComponentsConfig(stack=" + this.stack + ", background=" + this.background + ", stickyFooter=" + this.stickyFooter + ", header=" + this.header + ')';
    }

    public PaywallComponentsConfig(StackComponent stack, Background background, StickyFooterComponent stickyFooterComponent, HeaderComponent headerComponent) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(background, "background");
        this.stack = stack;
        this.background = background;
        this.stickyFooter = stickyFooterComponent;
        this.header = headerComponent;
    }

    public /* synthetic */ PaywallComponentsConfig(StackComponent stackComponent, Background background, StickyFooterComponent stickyFooterComponent, HeaderComponent headerComponent, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(stackComponent, background, (i3 & 4) != 0 ? null : stickyFooterComponent, (i3 & 8) != 0 ? null : headerComponent);
    }

    @SerialName
    public static /* synthetic */ void getStickyFooter$annotations() {
    }
}
