package androidx.compose.ui.input.pointer;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface PointerIcon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f26847a = Companion.f26848a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f26848a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final PointerIcon f26849b = PointerIcon_androidKt.c();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final PointerIcon f26850c = PointerIcon_androidKt.b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final PointerIcon f26851d = PointerIcon_androidKt.e();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final PointerIcon f26852e = PointerIcon_androidKt.d();

        private Companion() {
        }

        public final PointerIcon a() {
            return f26849b;
        }

        public final PointerIcon b() {
            return f26852e;
        }
    }
}
