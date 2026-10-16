package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.Color;
import java.util.List;
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
public final class DefaultPaywallPreviewOverrides {
    public static final int $stable = 8;
    private final Bitmap appIconBitmap;
    private final String appName;
    private final Boolean isDebugBuild;
    private final List<Color> prominentColors;

    public DefaultPaywallPreviewOverrides() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultPaywallPreviewOverrides copy$default(DefaultPaywallPreviewOverrides defaultPaywallPreviewOverrides, String str, Bitmap bitmap, List list, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = defaultPaywallPreviewOverrides.appName;
        }
        if ((i3 & 2) != 0) {
            bitmap = defaultPaywallPreviewOverrides.appIconBitmap;
        }
        if ((i3 & 4) != 0) {
            list = defaultPaywallPreviewOverrides.prominentColors;
        }
        if ((i3 & 8) != 0) {
            bool = defaultPaywallPreviewOverrides.isDebugBuild;
        }
        return defaultPaywallPreviewOverrides.copy(str, bitmap, list, bool);
    }

    public final String component1() {
        return this.appName;
    }

    public final Bitmap component2() {
        return this.appIconBitmap;
    }

    public final List<Color> component3() {
        return this.prominentColors;
    }

    public final Boolean component4() {
        return this.isDebugBuild;
    }

    public final DefaultPaywallPreviewOverrides copy(String str, Bitmap bitmap, List<Color> list, Boolean bool) {
        return new DefaultPaywallPreviewOverrides(str, bitmap, list, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultPaywallPreviewOverrides)) {
            return false;
        }
        DefaultPaywallPreviewOverrides defaultPaywallPreviewOverrides = (DefaultPaywallPreviewOverrides) obj;
        return Intrinsics.areEqual(this.appName, defaultPaywallPreviewOverrides.appName) && Intrinsics.areEqual(this.appIconBitmap, defaultPaywallPreviewOverrides.appIconBitmap) && Intrinsics.areEqual(this.prominentColors, defaultPaywallPreviewOverrides.prominentColors) && Intrinsics.areEqual(this.isDebugBuild, defaultPaywallPreviewOverrides.isDebugBuild);
    }

    public final Bitmap getAppIconBitmap() {
        return this.appIconBitmap;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final List<Color> getProminentColors() {
        return this.prominentColors;
    }

    public int hashCode() {
        String str = this.appName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Bitmap bitmap = this.appIconBitmap;
        int iHashCode2 = (iHashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        List<Color> list = this.prominentColors;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.isDebugBuild;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public final Boolean isDebugBuild() {
        return this.isDebugBuild;
    }

    public String toString() {
        return "DefaultPaywallPreviewOverrides(appName=" + this.appName + ", appIconBitmap=" + this.appIconBitmap + ", prominentColors=" + this.prominentColors + ", isDebugBuild=" + this.isDebugBuild + ')';
    }

    public DefaultPaywallPreviewOverrides(String str, Bitmap bitmap, List<Color> list, Boolean bool) {
        this.appName = str;
        this.appIconBitmap = bitmap;
        this.prominentColors = list;
        this.isDebugBuild = bool;
    }

    public /* synthetic */ DefaultPaywallPreviewOverrides(String str, Bitmap bitmap, List list, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : bitmap, (i3 & 4) != 0 ? null : list, (i3 & 8) != 0 ? null : bool);
    }
}
