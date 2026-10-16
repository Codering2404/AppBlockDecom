package kotlinx.coroutines.flow;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public interface SharingStarted {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f142210a = Companion.f142211a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f142211a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final SharingStarted f142212b = new StartedEagerly();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final SharingStarted f142213c = new StartedLazily();

        private Companion() {
        }

        public static /* synthetic */ SharingStarted b(Companion companion, long j3, long j4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = 0;
            }
            if ((i3 & 2) != 0) {
                j4 = Long.MAX_VALUE;
            }
            return companion.a(j3, j4);
        }

        public final SharingStarted a(long j3, long j4) {
            return new StartedWhileSubscribed(j3, j4);
        }

        public final SharingStarted c() {
            return f142212b;
        }

        public final SharingStarted d() {
            return f142213c;
        }
    }

    Flow a(StateFlow stateFlow);
}
