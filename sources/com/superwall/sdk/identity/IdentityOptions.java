package com.superwall.sdk.identity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class IdentityOptions {
    private final boolean restorePaywallAssignments;

    public IdentityOptions() {
        this(false, 1, null);
    }

    public static /* synthetic */ IdentityOptions copy$default(IdentityOptions identityOptions, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = identityOptions.restorePaywallAssignments;
        }
        return identityOptions.copy(z2);
    }

    public final boolean component1() {
        return this.restorePaywallAssignments;
    }

    public final IdentityOptions copy(boolean z2) {
        return new IdentityOptions(z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IdentityOptions) && this.restorePaywallAssignments == ((IdentityOptions) obj).restorePaywallAssignments;
    }

    public final boolean getRestorePaywallAssignments() {
        return this.restorePaywallAssignments;
    }

    public int hashCode() {
        return Boolean.hashCode(this.restorePaywallAssignments);
    }

    public String toString() {
        return "IdentityOptions(restorePaywallAssignments=" + this.restorePaywallAssignments + ")";
    }

    public IdentityOptions(boolean z2) {
        this.restorePaywallAssignments = z2;
    }

    public /* synthetic */ IdentityOptions(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2);
    }
}
