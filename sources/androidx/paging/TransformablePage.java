package androidx.paging;

import androidx.paging.ViewportHint;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

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
public final class TransformablePage<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f50696e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final TransformablePage f50697f = new TransformablePage(0, CollectionsKt.emptyList());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f50698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f50699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f50700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f50701d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransformablePage a() {
            return TransformablePage.f50697f;
        }

        private Companion() {
        }
    }

    public TransformablePage(int[] originalPageOffsets, List data, int i3, List list) {
        Intrinsics.checkNotNullParameter(originalPageOffsets, "originalPageOffsets");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f50698a = originalPageOffsets;
        this.f50699b = data;
        this.f50700c = i3;
        this.f50701d = list;
        if (originalPageOffsets.length == 0) {
            throw new IllegalArgumentException("originalPageOffsets cannot be empty when constructing TransformablePage");
        }
        if (list == null || list.size() == data.size()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("If originalIndices (size = ");
        Intrinsics.checkNotNull(list);
        sb.append(list.size());
        sb.append(") is provided, it must be same length as data (size = ");
        sb.append(data.size());
        sb.append(')');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public final List b() {
        return this.f50699b;
    }

    public final List c() {
        return this.f50701d;
    }

    public final int d() {
        return this.f50700c;
    }

    public final int[] e() {
        return this.f50698a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TransformablePage.class != obj.getClass()) {
            return false;
        }
        TransformablePage transformablePage = (TransformablePage) obj;
        return Arrays.equals(this.f50698a, transformablePage.f50698a) && Intrinsics.areEqual(this.f50699b, transformablePage.f50699b) && this.f50700c == transformablePage.f50700c && Intrinsics.areEqual(this.f50701d, transformablePage.f50701d);
    }

    public final ViewportHint.Access f(int i3, int i4, int i5, int i6, int i7) {
        IntRange indices;
        int i8 = this.f50700c;
        List list = this.f50701d;
        if (list != null && (indices = CollectionsKt.getIndices(list)) != null && indices.p(i3)) {
            i3 = ((Number) this.f50701d.get(i3)).intValue();
        }
        return new ViewportHint.Access(i8, i3, i4, i5, i6, i7);
    }

    public int hashCode() {
        int iHashCode = ((((Arrays.hashCode(this.f50698a) * 31) + this.f50699b.hashCode()) * 31) + this.f50700c) * 31;
        List list = this.f50701d;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TransformablePage(originalPageOffsets=" + Arrays.toString(this.f50698a) + ", data=" + this.f50699b + ", hintOriginalPageOffset=" + this.f50700c + ", hintOriginalIndices=" + this.f50701d + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransformablePage(int i3, List data) {
        this(new int[]{i3}, data, i3, null);
        Intrinsics.checkNotNullParameter(data, "data");
    }
}
