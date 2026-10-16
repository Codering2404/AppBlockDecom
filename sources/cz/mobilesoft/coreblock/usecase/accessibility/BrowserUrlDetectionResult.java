package cz.mobilesoft.coreblock.usecase.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BrowserUrlDetectionResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UrlDto f127519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AccessibilityNodeInfo f127520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BrowserViewId f127521c;

    public BrowserUrlDetectionResult(UrlDto url, AccessibilityNodeInfo nodeInfo, BrowserViewId browserConfig) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(nodeInfo, "nodeInfo");
        Intrinsics.checkNotNullParameter(browserConfig, "browserConfig");
        this.f127519a = url;
        this.f127520b = nodeInfo;
        this.f127521c = browserConfig;
    }

    public final BrowserViewId a() {
        return this.f127521c;
    }

    public final AccessibilityNodeInfo b() {
        return this.f127520b;
    }

    public final UrlDto c() {
        return this.f127519a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrowserUrlDetectionResult)) {
            return false;
        }
        BrowserUrlDetectionResult browserUrlDetectionResult = (BrowserUrlDetectionResult) obj;
        return Intrinsics.areEqual(this.f127519a, browserUrlDetectionResult.f127519a) && Intrinsics.areEqual(this.f127520b, browserUrlDetectionResult.f127520b) && Intrinsics.areEqual(this.f127521c, browserUrlDetectionResult.f127521c);
    }

    public int hashCode() {
        return (((this.f127519a.hashCode() * 31) + this.f127520b.hashCode()) * 31) + this.f127521c.hashCode();
    }

    public String toString() {
        return "BrowserUrlDetectionResult(url=" + this.f127519a + ", nodeInfo=" + this.f127520b + ", browserConfig=" + this.f127521c + ")";
    }
}
