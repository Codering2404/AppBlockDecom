package cz.mobilesoft.coreblock.scene.dashboard;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PauseTimerState {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f99463e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f99464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f99465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f99466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f99467d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PauseTimerState(long j3, long j4, float f3, boolean z2) {
        this.f99464a = j3;
        this.f99465b = j4;
        this.f99466c = f3;
        this.f99467d = z2;
    }

    public static /* synthetic */ PauseTimerState b(PauseTimerState pauseTimerState, long j3, long j4, float f3, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = pauseTimerState.f99464a;
        }
        long j5 = j3;
        if ((i3 & 2) != 0) {
            j4 = pauseTimerState.f99465b;
        }
        long j6 = j4;
        if ((i3 & 4) != 0) {
            f3 = pauseTimerState.f99466c;
        }
        float f4 = f3;
        if ((i3 & 8) != 0) {
            z2 = pauseTimerState.f99467d;
        }
        return pauseTimerState.a(j5, j6, f4, z2);
    }

    public final PauseTimerState a(long j3, long j4, float f3, boolean z2) {
        return new PauseTimerState(j3, j4, f3, z2);
    }

    public final float c() {
        return this.f99466c;
    }

    public final long d() {
        return this.f99464a;
    }

    public final long e() {
        return this.f99465b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PauseTimerState)) {
            return false;
        }
        PauseTimerState pauseTimerState = (PauseTimerState) obj;
        return this.f99464a == pauseTimerState.f99464a && this.f99465b == pauseTimerState.f99465b && Float.compare(this.f99466c, pauseTimerState.f99466c) == 0 && this.f99467d == pauseTimerState.f99467d;
    }

    public final boolean f() {
        return this.f99467d;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f99464a) * 31) + Long.hashCode(this.f99465b)) * 31) + Float.hashCode(this.f99466c)) * 31) + Boolean.hashCode(this.f99467d);
    }

    public String toString() {
        return "PauseTimerState(pauseTimer=" + this.f99464a + ", pauseTimerDelta=" + this.f99465b + ", pauseProgress=" + this.f99466c + ", visible=" + this.f99467d + ")";
    }

    public /* synthetic */ PauseTimerState(long j3, long j4, float f3, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j4, (i3 & 4) != 0 ? 0.1f : f3, (i3 & 8) != 0 ? false : z2);
    }
}
