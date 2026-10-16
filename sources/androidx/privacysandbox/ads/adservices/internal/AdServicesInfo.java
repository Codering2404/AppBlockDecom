package androidx.privacysandbox.ads.adservices.internal;

import android.os.Build;
import android.os.ext.SdkExtensions;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AdServicesInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdServicesInfo f51231a = new AdServicesInfo();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Extensions30ExtImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Extensions30ExtImpl f51232a = new Extensions30ExtImpl();

        private Extensions30ExtImpl() {
        }

        public final int a() {
            return SdkExtensions.getExtensionVersion(31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Extensions30Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Extensions30Impl f51233a = new Extensions30Impl();

        private Extensions30Impl() {
        }

        public final int a() {
            return SdkExtensions.getExtensionVersion(1000000);
        }
    }

    private AdServicesInfo() {
    }

    public final int a() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Extensions30Impl.f51233a.a();
        }
        return 0;
    }

    public final int b() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 31 || i3 == 32) {
            return Extensions30ExtImpl.f51232a.a();
        }
        return 0;
    }
}
