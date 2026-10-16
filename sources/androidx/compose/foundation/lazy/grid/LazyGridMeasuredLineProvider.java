package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

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
public abstract class LazyGridMeasuredLineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f7872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyGridSlots f7873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f7875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LazyGridMeasuredItemProvider f7876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LazyGridSpanLayoutProvider f7877f;

    public LazyGridMeasuredLineProvider(boolean z2, LazyGridSlots lazyGridSlots, int i3, int i4, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider) {
        this.f7872a = z2;
        this.f7873b = lazyGridSlots;
        this.f7874c = i3;
        this.f7875d = i4;
        this.f7876e = lazyGridMeasuredItemProvider;
        this.f7877f = lazyGridSpanLayoutProvider;
    }

    public final long a(int i3, int i4) {
        int i5;
        if (i4 == 1) {
            i5 = this.f7873b.b()[i3];
        } else {
            int i6 = (i4 + i3) - 1;
            i5 = (this.f7873b.a()[i6] + this.f7873b.b()[i6]) - this.f7873b.a()[i3];
        }
        int iF = RangesKt.f(i5, 0);
        return this.f7872a ? Constraints.f29963b.e(iF) : Constraints.f29963b.d(iF);
    }

    public abstract LazyGridMeasuredLine b(int i3, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List list, int i4);

    public final LazyGridMeasuredLine c(int i3) {
        LazyGridSpanLayoutProvider.LineConfiguration lineConfigurationC = this.f7877f.c(i3);
        int size = lineConfigurationC.b().size();
        int i4 = (size == 0 || lineConfigurationC.a() + size == this.f7874c) ? 0 : this.f7875d;
        LazyGridMeasuredItem[] lazyGridMeasuredItemArr = new LazyGridMeasuredItem[size];
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            int iD = GridItemSpan.d(((GridItemSpan) lineConfigurationC.b().get(i6)).g());
            LazyGridMeasuredItem lazyGridMeasuredItemD = this.f7876e.d(lineConfigurationC.a() + i6, a(i5, iD), i5, iD, i4);
            i5 += iD;
            Unit unit = Unit.f139807a;
            lazyGridMeasuredItemArr[i6] = lazyGridMeasuredItemD;
        }
        return b(i3, lazyGridMeasuredItemArr, lineConfigurationC.b(), i4);
    }

    public final int d(int i3) {
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = this.f7877f;
        return lazyGridSpanLayoutProvider.i(i3, lazyGridSpanLayoutProvider.e());
    }
}
