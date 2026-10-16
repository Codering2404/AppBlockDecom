package androidx.compose.foundation;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Deprecated;
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
@Deprecated
@Metadata
public final class OverscrollConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f5099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PaddingValues f5100b;

    public /* synthetic */ OverscrollConfiguration(long j3, PaddingValues paddingValues, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, paddingValues);
    }

    public final PaddingValues a() {
        return this.f5100b;
    }

    public final long b() {
        return this.f5099a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(OverscrollConfiguration.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.foundation.OverscrollConfiguration");
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) obj;
        return Color.t(this.f5099a, overscrollConfiguration.f5099a) && Intrinsics.areEqual(this.f5100b, overscrollConfiguration.f5100b);
    }

    public int hashCode() {
        return (Color.z(this.f5099a) * 31) + this.f5100b.hashCode();
    }

    public String toString() {
        return "OverscrollConfiguration(glowColor=" + ((Object) Color.A(this.f5099a)) + ", drawPadding=" + this.f5100b + ')';
    }

    private OverscrollConfiguration(long j3, PaddingValues paddingValues) {
        this.f5099a = j3;
        this.f5100b = paddingValues;
    }

    public /* synthetic */ OverscrollConfiguration(long j3, PaddingValues paddingValues, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ColorKt.d(4284900966L) : j3, (i3 & 2) != 0 ? PaddingKt.c(0.0f, 0.0f, 3, null) : paddingValues, null);
    }
}
