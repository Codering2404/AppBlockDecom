package cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BrowserState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f109033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f109034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f109035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f109036d;

    public BrowserState(String packageName, String str, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.f109033a = packageName;
        this.f109034b = str;
        this.f109035c = z2;
        this.f109036d = z3;
    }

    public final String a() {
        return this.f109034b;
    }

    public final String b() {
        return this.f109033a;
    }

    public final boolean c() {
        return this.f109035c;
    }

    public final boolean d() {
        return this.f109036d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrowserState)) {
            return false;
        }
        BrowserState browserState = (BrowserState) obj;
        return Intrinsics.areEqual(this.f109033a, browserState.f109033a) && Intrinsics.areEqual(this.f109034b, browserState.f109034b) && this.f109035c == browserState.f109035c && this.f109036d == browserState.f109036d;
    }

    public int hashCode() {
        int iHashCode = this.f109033a.hashCode() * 31;
        String str = this.f109034b;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.f109035c)) * 31) + Boolean.hashCode(this.f109036d);
    }

    public String toString() {
        return "BrowserState(packageName=" + this.f109033a + ", name=" + this.f109034b + ", isInstalled=" + this.f109035c + ", isSupported=" + this.f109036d + ")";
    }

    public /* synthetic */ BrowserState(String str, String str2, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? false : z3);
    }
}
