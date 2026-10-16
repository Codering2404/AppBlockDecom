package com.superwall.sdk.analytics.superwall;

import java.util.Map;
import kotlin.Deprecated;
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
public final class SuperwallEventInfo {
    private final SuperwallEvent event;
    private final Map<String, Object> params;

    public SuperwallEventInfo(SuperwallEvent event, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        this.event = event;
        this.params = params;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuperwallEventInfo copy$default(SuperwallEventInfo superwallEventInfo, SuperwallEvent superwallEvent, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            superwallEvent = superwallEventInfo.event;
        }
        if ((i3 & 2) != 0) {
            map = superwallEventInfo.params;
        }
        return superwallEventInfo.copy(superwallEvent, map);
    }

    public final SuperwallEvent component1() {
        return this.event;
    }

    public final Map<String, Object> component2() {
        return this.params;
    }

    public final SuperwallEventInfo copy(SuperwallEvent event, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        return new SuperwallEventInfo(event, params);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperwallEventInfo)) {
            return false;
        }
        SuperwallEventInfo superwallEventInfo = (SuperwallEventInfo) obj;
        return Intrinsics.areEqual(this.event, superwallEventInfo.event) && Intrinsics.areEqual(this.params, superwallEventInfo.params);
    }

    public final SuperwallEvent getEvent() {
        return this.event;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final SuperwallEvent getPlacement() {
        return this.event;
    }

    public int hashCode() {
        return (this.event.hashCode() * 31) + this.params.hashCode();
    }

    public String toString() {
        return "SuperwallEventInfo(event=" + this.event + ", params=" + this.params + ")";
    }

    @Deprecated
    public static /* synthetic */ void getPlacement$annotations() {
    }
}
