package cz.mobilesoft.coreblock.scene.premium.trial_upsell;

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
public final class TrialUpsellSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f113983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f113984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f113985c;

    public TrialUpsellSettings(boolean z2, int i3, int i4) {
        this.f113983a = z2;
        this.f113984b = i3;
        this.f113985c = i4;
    }

    public final boolean a() {
        return this.f113983a;
    }

    public final int b() {
        return this.f113984b;
    }

    public final int c() {
        return this.f113985c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrialUpsellSettings)) {
            return false;
        }
        TrialUpsellSettings trialUpsellSettings = (TrialUpsellSettings) obj;
        return this.f113983a == trialUpsellSettings.f113983a && this.f113984b == trialUpsellSettings.f113984b && this.f113985c == trialUpsellSettings.f113985c;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f113983a) * 31) + Integer.hashCode(this.f113984b)) * 31) + Integer.hashCode(this.f113985c);
    }

    public String toString() {
        return "TrialUpsellSettings(enabled=" + this.f113983a + ", frequency=" + this.f113984b + ", timeout=" + this.f113985c + ")";
    }

    public /* synthetic */ TrialUpsellSettings(boolean z2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z2, (i5 & 2) != 0 ? 3 : i3, (i5 & 4) != 0 ? 24 : i4);
    }
}
