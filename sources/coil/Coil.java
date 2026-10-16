package coil;

import android.content.Context;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Coil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Coil f55407a = new Coil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ImageLoader f55408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ImageLoaderFactory f55409c;

    private Coil() {
    }

    public static final ImageLoader a(Context context) {
        ImageLoader imageLoader = f55408b;
        return imageLoader == null ? f55407a.b(context) : imageLoader;
    }

    private final synchronized ImageLoader b(Context context) {
        ImageLoader imageLoaderA;
        try {
            ImageLoader imageLoader = f55408b;
            if (imageLoader != null) {
                return imageLoader;
            }
            ImageLoaderFactory imageLoaderFactory = f55409c;
            if (imageLoaderFactory == null || (imageLoaderA = imageLoaderFactory.a()) == null) {
                Object applicationContext = context.getApplicationContext();
                ImageLoaderFactory imageLoaderFactory2 = applicationContext instanceof ImageLoaderFactory ? (ImageLoaderFactory) applicationContext : null;
                imageLoaderA = imageLoaderFactory2 != null ? imageLoaderFactory2.a() : ImageLoaders.a(context);
            }
            f55409c = null;
            f55408b = imageLoaderA;
            return imageLoaderA;
        } catch (Throwable th) {
            throw th;
        }
    }
}
