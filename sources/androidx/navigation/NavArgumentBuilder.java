package androidx.navigation;

import androidx.navigation.NavArgument;
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
/* JADX INFO: loaded from: classes3.dex */
@NavDestinationDsl
@Metadata
public final class NavArgumentBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavArgument.Builder f48782a = new NavArgument.Builder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NavType f48783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f48784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f48785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f48786e;

    public final NavArgument a() {
        return this.f48782a.a();
    }

    public final void b(Object obj) {
        this.f48785d = obj;
        this.f48782a.b(obj);
    }

    public final void c(boolean z2) {
        this.f48784c = z2;
        this.f48782a.c(z2);
    }

    public final void d(NavType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f48783b = value;
        this.f48782a.d(value);
    }

    public final void e(boolean z2) {
        this.f48786e = z2;
        this.f48782a.e(z2);
    }
}
