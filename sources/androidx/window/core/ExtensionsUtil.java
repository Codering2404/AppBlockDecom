package androidx.window.core;

import android.util.Log;
import androidx.window.extensions.WindowExtensionsProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

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
public final class ExtensionsUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtensionsUtil f54127a = new ExtensionsUtil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f54128b = Reflection.b(ExtensionsUtil.class).m();

    private ExtensionsUtil() {
    }

    public final int a() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError unused) {
            if (BuildConfig.f54113a.a() != VerificationMode.LOG) {
                return 0;
            }
            Log.d(f54128b, "Embedding extension version not found");
            return 0;
        } catch (UnsupportedOperationException unused2) {
            if (BuildConfig.f54113a.a() != VerificationMode.LOG) {
                return 0;
            }
            Log.d(f54128b, "Stub Extension");
            return 0;
        }
    }
}
