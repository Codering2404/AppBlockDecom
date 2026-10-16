package com.superwall.sdk.paywall.view.webview.messaging;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class WrappedPaywallMessages {
    private final PayloadMessages payload;
    private int version;

    public WrappedPaywallMessages(int i3, PayloadMessages payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.version = i3;
        this.payload = payload;
    }

    public static /* synthetic */ WrappedPaywallMessages copy$default(WrappedPaywallMessages wrappedPaywallMessages, int i3, PayloadMessages payloadMessages, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = wrappedPaywallMessages.version;
        }
        if ((i4 & 2) != 0) {
            payloadMessages = wrappedPaywallMessages.payload;
        }
        return wrappedPaywallMessages.copy(i3, payloadMessages);
    }

    public final int component1() {
        return this.version;
    }

    public final PayloadMessages component2() {
        return this.payload;
    }

    public final WrappedPaywallMessages copy(int i3, PayloadMessages payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return new WrappedPaywallMessages(i3, payload);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WrappedPaywallMessages)) {
            return false;
        }
        WrappedPaywallMessages wrappedPaywallMessages = (WrappedPaywallMessages) obj;
        return this.version == wrappedPaywallMessages.version && Intrinsics.areEqual(this.payload, wrappedPaywallMessages.payload);
    }

    public final PayloadMessages getPayload() {
        return this.payload;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (Integer.hashCode(this.version) * 31) + this.payload.hashCode();
    }

    public final void setVersion(int i3) {
        this.version = i3;
    }

    public String toString() {
        return "WrappedPaywallMessages(version=" + this.version + ", payload=" + this.payload + ")";
    }

    public /* synthetic */ WrappedPaywallMessages(int i3, PayloadMessages payloadMessages, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 1 : i3, payloadMessages);
    }
}
