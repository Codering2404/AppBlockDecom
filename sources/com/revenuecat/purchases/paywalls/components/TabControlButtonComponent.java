package com.revenuecat.purchases.paywalls.components;

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
public final class TabControlButtonComponent implements PaywallComponent {
    public static final Companion Companion = new Companion(null);
    private final String name;
    private final StackComponent stack;
    private final String tabId;
    private final int tabIndex;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TabControlButtonComponent> serializer() {
            return TabControlButtonComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ TabControlButtonComponent(int i3, @SerialName int i4, @SerialName String str, StackComponent stackComponent, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, TabControlButtonComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.tabIndex = i4;
        this.tabId = str;
        this.stack = stackComponent;
        if ((i3 & 8) == 0) {
            this.name = null;
        } else {
            this.name = str2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(TabControlButtonComponent tabControlButtonComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.w(serialDescriptor, 0, tabControlButtonComponent.tabIndex);
        compositeEncoder.y(serialDescriptor, 1, tabControlButtonComponent.tabId);
        compositeEncoder.C(serialDescriptor, 2, StackComponent$$serializer.INSTANCE, tabControlButtonComponent.stack);
        if (!compositeEncoder.z(serialDescriptor, 3) && tabControlButtonComponent.name == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 3, StringSerializer.f142891a, tabControlButtonComponent.name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabControlButtonComponent)) {
            return false;
        }
        TabControlButtonComponent tabControlButtonComponent = (TabControlButtonComponent) obj;
        return this.tabIndex == tabControlButtonComponent.tabIndex && Intrinsics.areEqual(this.tabId, tabControlButtonComponent.tabId) && Intrinsics.areEqual(this.stack, tabControlButtonComponent.stack) && Intrinsics.areEqual(this.name, tabControlButtonComponent.name);
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final /* synthetic */ int getTabIndex() {
        return this.tabIndex;
    }

    public int hashCode() {
        int iHashCode = ((((this.tabIndex * 31) + this.tabId.hashCode()) * 31) + this.stack.hashCode()) * 31;
        String str = this.name;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TabControlButtonComponent(tabIndex=" + this.tabIndex + ", tabId=" + this.tabId + ", stack=" + this.stack + ", name=" + this.name + ')';
    }

    public TabControlButtonComponent(int i3, String tabId, StackComponent stack, String str) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.tabIndex = i3;
        this.tabId = tabId;
        this.stack = stack;
        this.name = str;
    }

    public /* synthetic */ TabControlButtonComponent(int i3, String str, StackComponent stackComponent, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, stackComponent, (i4 & 8) != 0 ? null : str2);
    }

    @SerialName
    public static /* synthetic */ void getTabId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTabIndex$annotations() {
    }
}
