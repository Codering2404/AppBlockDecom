package androidx.constraintlayout.compose;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MotionDragState {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f30753d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f30754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f30755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f30756c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MotionDragState a(long j3) {
            return new MotionDragState(true, j3, Velocity.f30015b.a(), null);
        }

        public final MotionDragState b(long j3) {
            return new MotionDragState(false, Offset.f25596b.b(), j3, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ MotionDragState(boolean z2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, j3, j4);
    }

    public final long a() {
        return this.f30755b;
    }

    public final long b() {
        return this.f30756c;
    }

    public final boolean c() {
        return this.f30754a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionDragState)) {
            return false;
        }
        MotionDragState motionDragState = (MotionDragState) obj;
        return this.f30754a == motionDragState.f30754a && Offset.j(this.f30755b, motionDragState.f30755b) && Velocity.g(this.f30756c, motionDragState.f30756c);
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f30754a) * 31) + Offset.o(this.f30755b)) * 31) + Velocity.j(this.f30756c);
    }

    public String toString() {
        return "MotionDragState(isDragging=" + this.f30754a + ", dragAmount=" + ((Object) Offset.s(this.f30755b)) + ", velocity=" + ((Object) Velocity.n(this.f30756c)) + ')';
    }

    private MotionDragState(boolean z2, long j3, long j4) {
        this.f30754a = z2;
        this.f30755b = j3;
        this.f30756c = j4;
    }
}
