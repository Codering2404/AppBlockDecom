package com.superwall.sdk.paywall.view.webview.messaging;

import java.util.List;
import kotlin.Metadata;
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
public final class PayloadMessages {
    private final List<PaywallMessage> messages;

    /* JADX WARN: Multi-variable type inference failed */
    public PayloadMessages(List<? extends PaywallMessage> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.messages = messages;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayloadMessages copy$default(PayloadMessages payloadMessages, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = payloadMessages.messages;
        }
        return payloadMessages.copy(list);
    }

    public final List<PaywallMessage> component1() {
        return this.messages;
    }

    public final PayloadMessages copy(List<? extends PaywallMessage> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        return new PayloadMessages(messages);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PayloadMessages) && Intrinsics.areEqual(this.messages, ((PayloadMessages) obj).messages);
    }

    public final List<PaywallMessage> getMessages() {
        return this.messages;
    }

    public int hashCode() {
        return this.messages.hashCode();
    }

    public String toString() {
        return "PayloadMessages(messages=" + this.messages + ")";
    }
}
