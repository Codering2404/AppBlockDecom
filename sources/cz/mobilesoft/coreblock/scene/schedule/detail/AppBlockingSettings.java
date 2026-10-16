package cz.mobilesoft.coreblock.scene.schedule.detail;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AppBlockingSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f116488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f116489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f116490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f116491d;

    public AppBlockingSettings(boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f116488a = z2;
        this.f116489b = z3;
        this.f116490c = z4;
        this.f116491d = z5;
    }

    public final boolean a() {
        return this.f116488a;
    }

    public final boolean b() {
        return this.f116489b;
    }

    public final boolean c() {
        return this.f116491d;
    }

    public final boolean d() {
        return this.f116490c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppBlockingSettings)) {
            return false;
        }
        AppBlockingSettings appBlockingSettings = (AppBlockingSettings) obj;
        return this.f116488a == appBlockingSettings.f116488a && this.f116489b == appBlockingSettings.f116489b && this.f116490c == appBlockingSettings.f116490c && this.f116491d == appBlockingSettings.f116491d;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f116488a) * 31) + Boolean.hashCode(this.f116489b)) * 31) + Boolean.hashCode(this.f116490c)) * 31) + Boolean.hashCode(this.f116491d);
    }

    public String toString() {
        return "AppBlockingSettings(isBlockingLaunch=" + this.f116488a + ", isBlockingNotifications=" + this.f116489b + ", isLockedForEasing=" + this.f116490c + ", isLockedCompletely=" + this.f116491d + ")";
    }

    public /* synthetic */ AppBlockingSettings(boolean z2, boolean z3, boolean z4, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? false : z4, (i3 & 8) != 0 ? false : z5);
    }
}
