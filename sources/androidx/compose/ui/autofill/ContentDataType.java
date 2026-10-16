package androidx.compose.ui.autofill;

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
public interface ContentDataType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f25250a = Companion.f25251a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f25251a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final ContentDataType f25252b = ContentDataType_androidKt.a(0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final ContentDataType f25253c = ContentDataType_androidKt.a(1);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final ContentDataType f25254d = ContentDataType_androidKt.a(3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final ContentDataType f25255e = ContentDataType_androidKt.a(4);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final ContentDataType f25256f = ContentDataType_androidKt.a(2);

        private Companion() {
        }

        public final ContentDataType a() {
            return f25253c;
        }
    }
}
