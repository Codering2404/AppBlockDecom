package com.superwall.sdk.paywall.presentation.rule_logic;

import java.util.Map;
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
public final class RuleAttributes {
    private final Map<String, Object> device;
    private final Map<String, Object> user;

    public RuleAttributes(Map<String, ? extends Object> user, Map<String, ? extends Object> device) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(device, "device");
        this.user = user;
        this.device = device;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RuleAttributes copy$default(RuleAttributes ruleAttributes, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = ruleAttributes.user;
        }
        if ((i3 & 2) != 0) {
            map2 = ruleAttributes.device;
        }
        return ruleAttributes.copy(map, map2);
    }

    public final Map<String, Object> component1() {
        return this.user;
    }

    public final Map<String, Object> component2() {
        return this.device;
    }

    public final RuleAttributes copy(Map<String, ? extends Object> user, Map<String, ? extends Object> device) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(device, "device");
        return new RuleAttributes(user, device);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RuleAttributes)) {
            return false;
        }
        RuleAttributes ruleAttributes = (RuleAttributes) obj;
        return Intrinsics.areEqual(this.user, ruleAttributes.user) && Intrinsics.areEqual(this.device, ruleAttributes.device);
    }

    public final Map<String, Object> getDevice() {
        return this.device;
    }

    public final Map<String, Object> getUser() {
        return this.user;
    }

    public int hashCode() {
        return (this.user.hashCode() * 31) + this.device.hashCode();
    }

    public String toString() {
        return "RuleAttributes(user=" + this.user + ", device=" + this.device + ")";
    }
}
