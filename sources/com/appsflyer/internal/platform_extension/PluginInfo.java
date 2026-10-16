package com.appsflyer.internal.platform_extension;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PluginInfo {
    private final Plugin AFInAppEventType;
    private final Map<String, String> AFKeystoreWrapper;
    private final String valueOf;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PluginInfo(Plugin plugin, String str) {
        this(plugin, str, null, 4, null);
        Intrinsics.checkNotNullParameter(plugin, "");
        Intrinsics.checkNotNullParameter(str, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PluginInfo copy$default(PluginInfo pluginInfo, Plugin plugin, String str, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            plugin = pluginInfo.AFInAppEventType;
        }
        if ((i3 & 2) != 0) {
            str = pluginInfo.valueOf;
        }
        if ((i3 & 4) != 0) {
            map = pluginInfo.AFKeystoreWrapper;
        }
        return pluginInfo.copy(plugin, str, map);
    }

    public final Plugin component1() {
        return this.AFInAppEventType;
    }

    public final String component2() {
        return this.valueOf;
    }

    public final Map<String, String> component3() {
        return this.AFKeystoreWrapper;
    }

    public final PluginInfo copy(Plugin plugin, String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(plugin, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        return new PluginInfo(plugin, str, map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PluginInfo)) {
            return false;
        }
        PluginInfo pluginInfo = (PluginInfo) obj;
        return this.AFInAppEventType == pluginInfo.AFInAppEventType && Intrinsics.areEqual(this.valueOf, pluginInfo.valueOf) && Intrinsics.areEqual(this.AFKeystoreWrapper, pluginInfo.AFKeystoreWrapper);
    }

    public final Map<String, String> getAdditionalParams() {
        return this.AFKeystoreWrapper;
    }

    public final Plugin getPlugin() {
        return this.AFInAppEventType;
    }

    public final String getVersion() {
        return this.valueOf;
    }

    public final int hashCode() {
        return (((this.AFInAppEventType.hashCode() * 31) + this.valueOf.hashCode()) * 31) + this.AFKeystoreWrapper.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PluginInfo(plugin=");
        sb.append(this.AFInAppEventType);
        sb.append(", version=");
        sb.append(this.valueOf);
        sb.append(", additionalParams=");
        sb.append(this.AFKeystoreWrapper);
        sb.append(')');
        return sb.toString();
    }

    public PluginInfo(Plugin plugin, String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(plugin, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.AFInAppEventType = plugin;
        this.valueOf = str;
        this.AFKeystoreWrapper = map;
    }

    public /* synthetic */ PluginInfo(Plugin plugin, String str, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(plugin, str, (i3 & 4) != 0 ? MapsKt.emptyMap() : map);
    }
}
