package androidx.glance.color;

import android.content.Context;
import androidx.compose.ui.graphics.Color;
import androidx.glance.unit.ColorProvider;
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
public final class DayNightColorProvider implements ColorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f39413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f39414b;

    public /* synthetic */ DayNightColorProvider(long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4);
    }

    @Override // androidx.glance.unit.ColorProvider
    public long a(Context context) {
        return b(DayNightColorProvidersKt.b(context));
    }

    public final long b(boolean z2) {
        return z2 ? this.f39414b : this.f39413a;
    }

    public final long c() {
        return this.f39413a;
    }

    public final long d() {
        return this.f39414b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DayNightColorProvider)) {
            return false;
        }
        DayNightColorProvider dayNightColorProvider = (DayNightColorProvider) obj;
        return Color.t(this.f39413a, dayNightColorProvider.f39413a) && Color.t(this.f39414b, dayNightColorProvider.f39414b);
    }

    public int hashCode() {
        return (Color.z(this.f39413a) * 31) + Color.z(this.f39414b);
    }

    public String toString() {
        return "DayNightColorProvider(day=" + ((Object) Color.A(this.f39413a)) + ", night=" + ((Object) Color.A(this.f39414b)) + ')';
    }

    private DayNightColorProvider(long j3, long j4) {
        this.f39413a = j3;
        this.f39414b = j4;
    }
}
