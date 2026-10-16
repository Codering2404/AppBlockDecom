package com.revenuecat.purchases.ui.revenuecatui.customercenter.composables;

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
public final class SettingsButtonConfig {
    public static final int $stable = 0;
    private final boolean enabled;
    private final boolean loading;

    /* JADX WARN: Illegal instructions before constructor call */
    public SettingsButtonConfig() {
        boolean z2 = false;
        this(z2, z2, 3, null);
    }

    public static /* synthetic */ SettingsButtonConfig copy$default(SettingsButtonConfig settingsButtonConfig, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = settingsButtonConfig.enabled;
        }
        if ((i3 & 2) != 0) {
            z3 = settingsButtonConfig.loading;
        }
        return settingsButtonConfig.copy(z2, z3);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final boolean component2() {
        return this.loading;
    }

    public final SettingsButtonConfig copy(boolean z2, boolean z3) {
        return new SettingsButtonConfig(z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettingsButtonConfig)) {
            return false;
        }
        SettingsButtonConfig settingsButtonConfig = (SettingsButtonConfig) obj;
        return this.enabled == settingsButtonConfig.enabled && this.loading == settingsButtonConfig.loading;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.enabled) * 31) + Boolean.hashCode(this.loading);
    }

    public String toString() {
        return "SettingsButtonConfig(enabled=" + this.enabled + ", loading=" + this.loading + ')';
    }

    public SettingsButtonConfig(boolean z2, boolean z3) {
        this.enabled = z2;
        this.loading = z3;
    }

    public /* synthetic */ SettingsButtonConfig(boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? false : z3);
    }
}
