package cz.mobilesoft.coreblock.storage.room.entity.core;

import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PomodoroHistory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f126574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f126576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f126577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f126578e;

    public PomodoroHistory(int i3, long j3, long j4, int i4, int i5) {
        this.f126574a = i3;
        this.f126575b = j3;
        this.f126576c = j4;
        this.f126577d = i4;
        this.f126578e = i5;
    }

    public static /* synthetic */ PomodoroHistory b(PomodoroHistory pomodoroHistory, int i3, long j3, long j4, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i3 = pomodoroHistory.f126574a;
        }
        if ((i6 & 2) != 0) {
            j3 = pomodoroHistory.f126575b;
        }
        if ((i6 & 4) != 0) {
            j4 = pomodoroHistory.f126576c;
        }
        if ((i6 & 8) != 0) {
            i4 = pomodoroHistory.f126577d;
        }
        if ((i6 & 16) != 0) {
            i5 = pomodoroHistory.f126578e;
        }
        long j5 = j4;
        return pomodoroHistory.a(i3, j3, j5, i4, i5);
    }

    public final PomodoroHistory a(int i3, long j3, long j4, int i4, int i5) {
        return new PomodoroHistory(i3, j3, j4, i4, i5);
    }

    public final long c() {
        return this.f126576c;
    }

    public final long d() {
        return this.f126575b;
    }

    public final int e() {
        return this.f126574a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PomodoroHistory)) {
            return false;
        }
        PomodoroHistory pomodoroHistory = (PomodoroHistory) obj;
        return this.f126574a == pomodoroHistory.f126574a && this.f126575b == pomodoroHistory.f126575b && this.f126576c == pomodoroHistory.f126576c && this.f126577d == pomodoroHistory.f126577d && this.f126578e == pomodoroHistory.f126578e;
    }

    public final int f() {
        return this.f126577d;
    }

    public final int g() {
        return this.f126578e;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.f126574a) * 31) + Long.hashCode(this.f126575b)) * 31) + Long.hashCode(this.f126576c)) * 31) + Integer.hashCode(this.f126577d)) * 31) + Integer.hashCode(this.f126578e);
    }

    public String toString() {
        return "PomodoroHistory(id=" + this.f126574a + ", focusTimeMillis=" + this.f126575b + ", breakTimeMillis=" + this.f126576c + ", sessionCount=" + this.f126577d + ", updatedAt=" + this.f126578e + ")";
    }

    public /* synthetic */ PomodoroHistory(int i3, long j3, long j4, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i3, j3, j4, i4, (i6 & 16) != 0 ? TimeHelperExt.f128663a.g() : i5);
    }
}
