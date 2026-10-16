package androidx.compose.material3.adaptive;

import androidx.window.core.layout.WindowSizeClass;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class WindowAdaptiveInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowSizeClass f21600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Posture f21601b;

    public WindowAdaptiveInfo(WindowSizeClass windowSizeClass, Posture posture) {
        this.f21600a = windowSizeClass;
        this.f21601b = posture;
    }

    public final WindowSizeClass a() {
        return this.f21600a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowAdaptiveInfo)) {
            return false;
        }
        WindowAdaptiveInfo windowAdaptiveInfo = (WindowAdaptiveInfo) obj;
        return Intrinsics.areEqual(this.f21600a, windowAdaptiveInfo.f21600a) && Intrinsics.areEqual(this.f21601b, windowAdaptiveInfo.f21601b);
    }

    public int hashCode() {
        return (this.f21600a.hashCode() * 31) + this.f21601b.hashCode();
    }

    public String toString() {
        return "WindowAdaptiveInfo(windowSizeClass=" + this.f21600a + ", windowPosture=" + this.f21601b + ')';
    }
}
