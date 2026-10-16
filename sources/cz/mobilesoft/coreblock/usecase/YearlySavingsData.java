package cz.mobilesoft.coreblock.usecase;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

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
public final class YearlySavingsData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f127513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f127514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f127515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f127516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f127517e;

    public YearlySavingsData(String savingsText, int i3, int i4, String yearlyPriceText, String monthlyEquivalentText) {
        Intrinsics.checkNotNullParameter(savingsText, "savingsText");
        Intrinsics.checkNotNullParameter(yearlyPriceText, "yearlyPriceText");
        Intrinsics.checkNotNullParameter(monthlyEquivalentText, "monthlyEquivalentText");
        this.f127513a = savingsText;
        this.f127514b = i3;
        this.f127515c = i4;
        this.f127516d = yearlyPriceText;
        this.f127517e = monthlyEquivalentText;
    }

    public final String a() {
        return this.f127517e;
    }

    public final int b() {
        return this.f127514b;
    }

    public final int c() {
        return this.f127515c;
    }

    public final String d() {
        return this.f127513a;
    }

    public final String e() {
        return this.f127516d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YearlySavingsData)) {
            return false;
        }
        YearlySavingsData yearlySavingsData = (YearlySavingsData) obj;
        return Intrinsics.areEqual(this.f127513a, yearlySavingsData.f127513a) && this.f127514b == yearlySavingsData.f127514b && this.f127515c == yearlySavingsData.f127515c && Intrinsics.areEqual(this.f127516d, yearlySavingsData.f127516d) && Intrinsics.areEqual(this.f127517e, yearlySavingsData.f127517e);
    }

    public int hashCode() {
        return (((((((this.f127513a.hashCode() * 31) + Integer.hashCode(this.f127514b)) * 31) + Integer.hashCode(this.f127515c)) * 31) + this.f127516d.hashCode()) * 31) + this.f127517e.hashCode();
    }

    public String toString() {
        return "YearlySavingsData(savingsText=" + this.f127513a + ", savingsPercent=" + this.f127514b + ", savingsPercentRounded=" + this.f127515c + ", yearlyPriceText=" + this.f127516d + vgWWUoTKYyuC.wTHiBfvNiOF + this.f127517e + ")";
    }
}
