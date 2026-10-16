package androidx.window.layout;

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
public interface FoldingFeature extends DisplayFeature {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OcclusionType {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f54317b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final OcclusionType f54318c = new OcclusionType("NONE");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final OcclusionType f54319d = new OcclusionType("FULL");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f54320a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        private OcclusionType(String str) {
            this.f54320a = str;
        }

        public String toString() {
            return this.f54320a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Orientation {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f54321b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Orientation f54322c = new Orientation("VERTICAL");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Orientation f54323d = new Orientation("HORIZONTAL");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f54324a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        private Orientation(String str) {
            this.f54324a = str;
        }

        public String toString() {
            return this.f54324a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class State {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f54325b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final State f54326c = new State("FLAT");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final State f54327d = new State("HALF_OPENED");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f54328a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        private State(String str) {
            this.f54328a = str;
        }

        public String toString() {
            return this.f54328a;
        }
    }

    boolean a();

    OcclusionType b();

    Orientation getOrientation();

    State getState();
}
