package androidx.glance.unit;

import android.content.Context;
import androidx.compose.ui.graphics.Color;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class FixedColorProvider implements ColorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f39791a;

    public /* synthetic */ FixedColorProvider(long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3);
    }

    @Override // androidx.glance.unit.ColorProvider
    public long a(Context context) {
        return this.f39791a;
    }

    public final long b() {
        return this.f39791a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FixedColorProvider) && Color.t(this.f39791a, ((FixedColorProvider) obj).f39791a);
    }

    public int hashCode() {
        return Color.z(this.f39791a);
    }

    public String toString() {
        return "FixedColorProvider(color=" + ((Object) Color.A(this.f39791a)) + ')';
    }

    private FixedColorProvider(long j3) {
        this.f39791a = j3;
    }
}
