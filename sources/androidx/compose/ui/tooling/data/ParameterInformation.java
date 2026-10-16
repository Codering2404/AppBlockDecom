package androidx.compose.ui.tooling.data;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ParameterInformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f29930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f29931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f29932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f29933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f29934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f29935g;

    public ParameterInformation(String str, Object obj, boolean z2, boolean z3, boolean z4, String str2, boolean z5) {
        this.f29929a = str;
        this.f29930b = obj;
        this.f29931c = z2;
        this.f29932d = z3;
        this.f29933e = z4;
        this.f29934f = str2;
        this.f29935g = z5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParameterInformation)) {
            return false;
        }
        ParameterInformation parameterInformation = (ParameterInformation) obj;
        return Intrinsics.areEqual(this.f29929a, parameterInformation.f29929a) && Intrinsics.areEqual(this.f29930b, parameterInformation.f29930b) && this.f29931c == parameterInformation.f29931c && this.f29932d == parameterInformation.f29932d && this.f29933e == parameterInformation.f29933e && Intrinsics.areEqual(this.f29934f, parameterInformation.f29934f) && this.f29935g == parameterInformation.f29935g;
    }

    public int hashCode() {
        int iHashCode = this.f29929a.hashCode() * 31;
        Object obj = this.f29930b;
        int iHashCode2 = (((((((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31) + Boolean.hashCode(this.f29931c)) * 31) + Boolean.hashCode(this.f29932d)) * 31) + Boolean.hashCode(this.f29933e)) * 31;
        String str = this.f29934f;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.f29935g);
    }

    public String toString() {
        return "ParameterInformation(name=" + this.f29929a + ", value=" + this.f29930b + ", fromDefault=" + this.f29931c + ", static=" + this.f29932d + ", compared=" + this.f29933e + ", inlineClass=" + this.f29934f + ", stable=" + this.f29935g + ')';
    }
}
