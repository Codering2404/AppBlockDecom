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
abstract class TransformEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransformDelta extends TransformEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f6288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f6290c;

        public /* synthetic */ TransformDelta(float f3, long j3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
            this(f3, j3, f4);
        }

        public final long a() {
            return this.f6289b;
        }

        public final float b() {
            return this.f6290c;
        }

        public final float c() {
            return this.f6288a;
        }

        private TransformDelta(float f3, long j3, float f4) {
            super(null);
            this.f6288a = f3;
            this.f6289b = j3;
            this.f6290c = f4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransformStarted extends TransformEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TransformStarted f6291a = new TransformStarted();

        private TransformStarted() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransformStopped extends TransformEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TransformStopped f6292a = new TransformStopped();

        private TransformStopped() {
            super(null);
        }
    }

    public /* synthetic */ TransformEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TransformEvent() {
    }
}
