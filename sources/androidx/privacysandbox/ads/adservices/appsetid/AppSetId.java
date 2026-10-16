package androidx.privacysandbox.ads.adservices.appsetid;

import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AppSetId {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f51179c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f51180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f51181b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AppSetId(String id, int i3) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.f51180a = id;
        this.f51181b = i3;
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("Scope undefined.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSetId)) {
            return false;
        }
        AppSetId appSetId = (AppSetId) obj;
        return Intrinsics.areEqual(this.f51180a, appSetId.f51180a) && this.f51181b == appSetId.f51181b;
    }

    public int hashCode() {
        return (this.f51180a.hashCode() * 31) + Integer.hashCode(this.f51181b);
    }

    public String toString() {
        return "AppSetId: id=" + this.f51180a + ", scope=" + (this.f51181b == 1 ? SbbqvQlxi.jUHq : "SCOPE_DEVELOPER");
    }
}
