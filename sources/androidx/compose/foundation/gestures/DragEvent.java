package androidx.compose.foundation.gestures;

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
public abstract class DragEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DragCancelled extends DragEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DragCancelled f5654a = new DragCancelled();

        private DragCancelled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DragDelta extends DragEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f5655a;

        public /* synthetic */ DragDelta(long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3);
        }

        public final long a() {
            return this.f5655a;
        }

        private DragDelta(long j3) {
            super(null);
            this.f5655a = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DragStarted extends DragEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f5656a;

        public /* synthetic */ DragStarted(long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3);
        }

        public final long a() {
            return this.f5656a;
        }

        private DragStarted(long j3) {
            super(null);
            this.f5656a = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DragStopped extends DragEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f5657a;

        public /* synthetic */ DragStopped(long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3);
        }

        public final long a() {
            return this.f5657a;
        }

        private DragStopped(long j3) {
            super(null);
            this.f5657a = j3;
        }
    }

    public /* synthetic */ DragEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DragEvent() {
    }
}
