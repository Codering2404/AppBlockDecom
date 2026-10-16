package androidx.glance.layout;

import androidx.compose.ui.unit.Dp;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class PaddingDimension {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f39478c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39479d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final PaddingDimension f39480e = new PaddingDimension(0.0f, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f39481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f39482b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ PaddingDimension(float f3, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, list);
    }

    public final float a() {
        return this.f39481a;
    }

    public final List b() {
        return this.f39482b;
    }

    public final PaddingDimension c(PaddingDimension paddingDimension) {
        return new PaddingDimension(Dp.g(this.f39481a + paddingDimension.f39481a), CollectionsKt.plus((Collection) this.f39482b, (Iterable) paddingDimension.f39482b), null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaddingDimension)) {
            return false;
        }
        PaddingDimension paddingDimension = (PaddingDimension) obj;
        return Dp.i(this.f39481a, paddingDimension.f39481a) && Intrinsics.areEqual(this.f39482b, paddingDimension.f39482b);
    }

    public int hashCode() {
        return (Dp.j(this.f39481a) * 31) + this.f39482b.hashCode();
    }

    public String toString() {
        return "PaddingDimension(dp=" + ((Object) Dp.k(this.f39481a)) + ", resourceIds=" + this.f39482b + ')';
    }

    private PaddingDimension(float f3, List list) {
        this.f39481a = f3;
        this.f39482b = list;
    }

    public /* synthetic */ PaddingDimension(float f3, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Dp.g(0) : f3, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, null);
    }
}
