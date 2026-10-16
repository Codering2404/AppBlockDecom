package androidx.window.embedding;

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
public final class SplitController {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f54268b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EmbeddingBackend f54269a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SplitSupportStatus {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f54270b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final SplitSupportStatus f54271c = new SplitSupportStatus(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final SplitSupportStatus f54272d = new SplitSupportStatus(1);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final SplitSupportStatus f54273e = new SplitSupportStatus(2);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f54274a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        private SplitSupportStatus(int i3) {
            this.f54274a = i3;
        }

        public String toString() {
            int i3 = this.f54274a;
            return i3 != 0 ? i3 != 1 ? i3 != 2 ? "UNKNOWN" : "SplitSupportStatus: ERROR_SPLIT_PROPERTY_NOT_DECLARED" : "SplitSupportStatus: UNAVAILABLE" : "SplitSupportStatus: AVAILABLE";
        }
    }
}
