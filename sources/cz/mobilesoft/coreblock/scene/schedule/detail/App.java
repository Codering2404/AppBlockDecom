package cz.mobilesoft.coreblock.scene.schedule.detail;

import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

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
public final class App {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f116485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f116486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableList f116487c;

    public final ImmutableList a() {
        return this.f116487c;
    }

    public final String b() {
        return this.f116486b;
    }

    public final String c() {
        return this.f116485a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof App)) {
            return false;
        }
        App app = (App) obj;
        return Intrinsics.areEqual(this.f116485a, app.f116485a) && Intrinsics.areEqual(this.f116486b, app.f116486b) && Intrinsics.areEqual(this.f116487c, app.f116487c);
    }

    public int hashCode() {
        return (((this.f116485a.hashCode() * 31) + this.f116486b.hashCode()) * 31) + this.f116487c.hashCode();
    }

    public String toString() {
        return "App(packageName=" + this.f116485a + ", label=" + this.f116486b + ", categories=" + this.f116487c + ")";
    }

    public App(String str, String label, ImmutableList categories) {
        Intrinsics.checkNotNullParameter(str, qRMDmh.GcRYBnaAPuTCaa);
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(categories, "categories");
        this.f116485a = str;
        this.f116486b = label;
        this.f116487c = categories;
    }
}
