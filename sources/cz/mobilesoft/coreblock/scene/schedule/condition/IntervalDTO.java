package cz.mobilesoft.coreblock.scene.schedule.condition;

import cz.mobilesoft.coreblock.util.profile.IntervalHolder;
import java.io.Serializable;
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
public final class IntervalDTO implements IntervalHolder, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f115211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f115212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f115213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f115214d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f115215f;

    public IntervalDTO(long j3, long j4, Long l3, Long l4) {
        this.f115211a = j3;
        this.f115212b = j4;
        this.f115213c = l3;
        this.f115214d = l4;
        this.f115215f = b() == 0 && (a() == 1440 || a() == 1439);
    }

    public static /* synthetic */ IntervalDTO d(IntervalDTO intervalDTO, long j3, long j4, Long l3, Long l4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = intervalDTO.f115211a;
        }
        long j5 = j3;
        if ((i3 & 2) != 0) {
            j4 = intervalDTO.f115212b;
        }
        long j6 = j4;
        if ((i3 & 4) != 0) {
            l3 = intervalDTO.f115213c;
        }
        Long l5 = l3;
        if ((i3 & 8) != 0) {
            l4 = intervalDTO.f115214d;
        }
        return intervalDTO.c(j5, j6, l5, l4);
    }

    @Override // cz.mobilesoft.coreblock.util.profile.IntervalHolder
    public long a() {
        return this.f115212b;
    }

    @Override // cz.mobilesoft.coreblock.util.profile.IntervalHolder
    public long b() {
        return this.f115211a;
    }

    public final IntervalDTO c(long j3, long j4, Long l3, Long l4) {
        return new IntervalDTO(j3, j4, l3, l4);
    }

    public final Long e() {
        return this.f115213c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntervalDTO)) {
            return false;
        }
        IntervalDTO intervalDTO = (IntervalDTO) obj;
        return this.f115211a == intervalDTO.f115211a && this.f115212b == intervalDTO.f115212b && Intrinsics.areEqual(this.f115213c, intervalDTO.f115213c) && Intrinsics.areEqual(this.f115214d, intervalDTO.f115214d);
    }

    public final Long f() {
        return this.f115214d;
    }

    public final boolean g() {
        return this.f115215f;
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.f115211a) * 31) + Long.hashCode(this.f115212b)) * 31;
        Long l3 = this.f115213c;
        int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.f115214d;
        return iHashCode2 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        return "IntervalDTO(fromInMinutes=" + this.f115211a + ", toInMinutes=" + this.f115212b + ", originalFromInMinutes=" + this.f115213c + ", originalToInMinutes=" + this.f115214d + ")";
    }

    public /* synthetic */ IntervalDTO(long j3, long j4, Long l3, Long l4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 1440L : j4, (i3 & 4) != 0 ? null : l3, (i3 & 8) != 0 ? null : l4);
    }
}
