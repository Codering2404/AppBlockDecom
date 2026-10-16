package androidx.window;

import androidx.window.core.ExtensionsUtil;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class WindowSdkExtensions {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f54022b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static WindowSdkExtensionsDecorator f54023c = EmptyDecoratorWindowSdk.f54012a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f54024a = ExtensionsUtil.f54127a.a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WindowSdkExtensions a() {
            return WindowSdkExtensions.f54023c.a(new WindowSdkExtensions() { // from class: androidx.window.WindowSdkExtensions$Companion$getInstance$1
            });
        }

        private Companion() {
        }
    }

    public int b() {
        return this.f54024a;
    }
}
