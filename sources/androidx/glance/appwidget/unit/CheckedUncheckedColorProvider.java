package androidx.glance.appwidget.unit;

import android.content.Context;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ResourceColorProvider;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CheckedUncheckedColorProvider implements CheckableColorProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f39380d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorProvider f39382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorProvider f39383c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckableColorProvider a(String str, ColorProvider colorProvider, ColorProvider colorProvider2) {
            return new CheckedUncheckedColorProvider(str, colorProvider, colorProvider2, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ CheckedUncheckedColorProvider(String str, ColorProvider colorProvider, ColorProvider colorProvider2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, colorProvider, colorProvider2);
    }

    private final long b(ColorProvider colorProvider, boolean z2, Context context) {
        return colorProvider instanceof DayNightColorProvider ? ((DayNightColorProvider) colorProvider).b(z2) : colorProvider.a(context);
    }

    public final long a(Context context, boolean z2, boolean z3) {
        return z3 ? b(this.f39382b, z2, context) : b(this.f39383c, z2, context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckedUncheckedColorProvider)) {
            return false;
        }
        CheckedUncheckedColorProvider checkedUncheckedColorProvider = (CheckedUncheckedColorProvider) obj;
        return Intrinsics.areEqual(this.f39381a, checkedUncheckedColorProvider.f39381a) && Intrinsics.areEqual(this.f39382b, checkedUncheckedColorProvider.f39382b) && Intrinsics.areEqual(this.f39383c, checkedUncheckedColorProvider.f39383c);
    }

    public int hashCode() {
        return (((this.f39381a.hashCode() * 31) + this.f39382b.hashCode()) * 31) + this.f39383c.hashCode();
    }

    public String toString() {
        return "CheckedUncheckedColorProvider(source=" + this.f39381a + ", checked=" + this.f39382b + ", unchecked=" + this.f39383c + ')';
    }

    private CheckedUncheckedColorProvider(String str, ColorProvider colorProvider, ColorProvider colorProvider2) {
        this.f39381a = str;
        this.f39382b = colorProvider;
        this.f39383c = colorProvider2;
        if ((colorProvider instanceof ResourceColorProvider) || (colorProvider2 instanceof ResourceColorProvider)) {
            throw new IllegalArgumentException(("Cannot provide resource-backed ColorProviders to " + str).toString());
        }
    }
}
