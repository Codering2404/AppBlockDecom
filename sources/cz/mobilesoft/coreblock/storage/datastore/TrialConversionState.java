package cz.mobilesoft.coreblock.storage.datastore;

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
@Metadata
public final class TrialConversionState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f124680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f124681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f124682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f124683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f124684e;

    public TrialConversionState(String str, long j3, boolean z2, boolean z3, boolean z4) {
        this.f124680a = str;
        this.f124681b = j3;
        this.f124682c = z2;
        this.f124683d = z3;
        this.f124684e = z4;
    }

    public final boolean a() {
        return this.f124684e;
    }

    public final boolean b() {
        return this.f124683d;
    }

    public final long c() {
        return this.f124681b;
    }

    public final String d() {
        return this.f124680a;
    }

    public final boolean e() {
        return this.f124682c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrialConversionState)) {
            return false;
        }
        TrialConversionState trialConversionState = (TrialConversionState) obj;
        return Intrinsics.areEqual(this.f124680a, trialConversionState.f124680a) && this.f124681b == trialConversionState.f124681b && this.f124682c == trialConversionState.f124682c && this.f124683d == trialConversionState.f124683d && this.f124684e == trialConversionState.f124684e;
    }

    public int hashCode() {
        String str = this.f124680a;
        return ((((((((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.f124681b)) * 31) + Boolean.hashCode(this.f124682c)) * 31) + Boolean.hashCode(this.f124683d)) * 31) + Boolean.hashCode(this.f124684e);
    }

    public String toString() {
        return "TrialConversionState(trialProductId=" + this.f124680a + ", trialExpirationMillis=" + this.f124681b + ", unsubscribeDetected=" + this.f124682c + ", reminderNotified=" + this.f124683d + ", failureNotified=" + this.f124684e + ")";
    }
}
