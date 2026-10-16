package cz.mobilesoft.coreblock.scene.schedule.detail;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class LockState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f116578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f116579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f116580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f116581d;

    public LockState(boolean z2, boolean z3, Long l3, Long l4) {
        this.f116578a = z2;
        this.f116579b = z3;
        this.f116580c = l3;
        this.f116581d = l4;
    }

    public static /* synthetic */ LockState b(LockState lockState, boolean z2, boolean z3, Long l3, Long l4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = lockState.f116578a;
        }
        if ((i3 & 2) != 0) {
            z3 = lockState.f116579b;
        }
        if ((i3 & 4) != 0) {
            l3 = lockState.f116580c;
        }
        if ((i3 & 8) != 0) {
            l4 = lockState.f116581d;
        }
        return lockState.a(z2, z3, l3, l4);
    }

    public final LockState a(boolean z2, boolean z3, Long l3, Long l4) {
        return new LockState(z2, z3, l3, l4);
    }

    public final Long c() {
        return this.f116581d;
    }

    public final Long d() {
        return this.f116580c;
    }

    public final boolean e() {
        return this.f116579b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LockState)) {
            return false;
        }
        LockState lockState = (LockState) obj;
        return this.f116578a == lockState.f116578a && this.f116579b == lockState.f116579b && Intrinsics.areEqual(this.f116580c, lockState.f116580c) && Intrinsics.areEqual(this.f116581d, lockState.f116581d);
    }

    public final boolean f() {
        return this.f116578a;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.f116578a) * 31) + Boolean.hashCode(this.f116579b)) * 31;
        Long l3 = this.f116580c;
        int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.f116581d;
        return iHashCode2 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        return "LockState(isStrictModeOn=" + this.f116578a + ", isChargerConnected=" + this.f116579b + ", willBeLockedByStrictModeInMS=" + this.f116580c + ", lockRemainingTimeInMS=" + this.f116581d + ")";
    }

    public /* synthetic */ LockState(boolean z2, boolean z3, Long l3, Long l4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? null : l3, (i3 & 8) != 0 ? null : l4);
    }
}
