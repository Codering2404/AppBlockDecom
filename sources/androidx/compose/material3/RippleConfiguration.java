package androidx.compose.material3;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.ui.graphics.Color;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RippleConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RippleAlpha f19378b;

    public /* synthetic */ RippleConfiguration(long j3, RippleAlpha rippleAlpha, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, rippleAlpha);
    }

    public final long a() {
        return this.f19377a;
    }

    public final RippleAlpha b() {
        return this.f19378b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleConfiguration)) {
            return false;
        }
        RippleConfiguration rippleConfiguration = (RippleConfiguration) obj;
        return Color.t(this.f19377a, rippleConfiguration.f19377a) && Intrinsics.areEqual(this.f19378b, rippleConfiguration.f19378b);
    }

    public int hashCode() {
        int iZ = Color.z(this.f19377a) * 31;
        RippleAlpha rippleAlpha = this.f19378b;
        return iZ + (rippleAlpha != null ? rippleAlpha.hashCode() : 0);
    }

    public String toString() {
        return "RippleConfiguration(color=" + ((Object) Color.A(this.f19377a)) + ", rippleAlpha=" + this.f19378b + ')';
    }

    private RippleConfiguration(long j3, RippleAlpha rippleAlpha) {
        this.f19377a = j3;
        this.f19378b = rippleAlpha;
    }

    public /* synthetic */ RippleConfiguration(long j3, RippleAlpha rippleAlpha, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Color.f25715b.k() : j3, (i3 & 2) != 0 ? null : rippleAlpha, null);
    }
}
