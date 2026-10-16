package cz.mobilesoft.coreblock.storage.room.premium;

import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import kotlin.Deprecated;
import kotlin.Metadata;
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
@Deprecated
@Metadata
public final class PricingPhaseEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f126812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PricingPhaseType f126813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f126814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final double f126815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f126816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f126817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f126818i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RecurrenceMode f126819j;

    public final int a() {
        return this.f126818i;
    }

    public final String b() {
        return this.f126817h;
    }

    public final String c() {
        return this.f126814e;
    }

    public final long d() {
        return this.f126810a;
    }

    public final long e() {
        return this.f126811b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PricingPhaseEntity)) {
            return false;
        }
        PricingPhaseEntity pricingPhaseEntity = (PricingPhaseEntity) obj;
        return this.f126810a == pricingPhaseEntity.f126810a && this.f126811b == pricingPhaseEntity.f126811b && this.f126812c == pricingPhaseEntity.f126812c && this.f126813d == pricingPhaseEntity.f126813d && Intrinsics.areEqual(this.f126814e, pricingPhaseEntity.f126814e) && Double.compare(this.f126815f, pricingPhaseEntity.f126815f) == 0 && Intrinsics.areEqual(this.f126816g, pricingPhaseEntity.f126816g) && Intrinsics.areEqual(this.f126817h, pricingPhaseEntity.f126817h) && this.f126818i == pricingPhaseEntity.f126818i && this.f126819j == pricingPhaseEntity.f126819j;
    }

    public final int f() {
        return this.f126812c;
    }

    public final PricingPhaseType g() {
        return this.f126813d;
    }

    public final double h() {
        return this.f126815f;
    }

    public int hashCode() {
        return (((((((((((((((((Long.hashCode(this.f126810a) * 31) + Long.hashCode(this.f126811b)) * 31) + Integer.hashCode(this.f126812c)) * 31) + this.f126813d.hashCode()) * 31) + this.f126814e.hashCode()) * 31) + Double.hashCode(this.f126815f)) * 31) + this.f126816g.hashCode()) * 31) + this.f126817h.hashCode()) * 31) + Integer.hashCode(this.f126818i)) * 31) + this.f126819j.hashCode();
    }

    public final String i() {
        return this.f126816g;
    }

    public final RecurrenceMode j() {
        return this.f126819j;
    }

    public String toString() {
        return "PricingPhaseEntity(id=" + this.f126810a + ", optionId=" + this.f126811b + ", phaseIndex=" + this.f126812c + ", phaseType=" + this.f126813d + ", formattedPrice=" + this.f126814e + ", priceAmount=" + this.f126815f + ", priceCurrencyCode=" + this.f126816g + ", billingPeriod=" + this.f126817h + YgVrd.GapGtVnGUXX + this.f126818i + ", recurrenceMode=" + this.f126819j + ")";
    }
}
