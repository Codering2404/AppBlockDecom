package androidx.compose.foundation.lazy.grid;

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
public final class LazyGridMeasuredLine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyGridMeasuredItem[] f7865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyGridSlots f7866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f7867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f7868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f7869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f7870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f7871h;

    public LazyGridMeasuredLine(int i3, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, LazyGridSlots lazyGridSlots, List list, boolean z2, int i4) {
        this.f7864a = i3;
        this.f7865b = lazyGridMeasuredItemArr;
        this.f7866c = lazyGridSlots;
        this.f7867d = list;
        this.f7868e = z2;
        this.f7869f = i4;
        int iMax = 0;
        for (LazyGridMeasuredItem lazyGridMeasuredItem : lazyGridMeasuredItemArr) {
            iMax = Math.max(iMax, lazyGridMeasuredItem.r());
        }
        this.f7870g = iMax;
        this.f7871h = RangesKt.f(iMax + this.f7869f, 0);
    }

    public final int a() {
        return this.f7864a;
    }

    public final LazyGridMeasuredItem[] b() {
        return this.f7865b;
    }

    public final int c() {
        return this.f7870g;
    }

    public final int d() {
        return this.f7871h;
    }

    public final boolean e() {
        return this.f7865b.length == 0;
    }

    public final LazyGridMeasuredItem[] f(int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        LazyGridMeasuredItem[] lazyGridMeasuredItemArr = this.f7865b;
        int length = lazyGridMeasuredItemArr.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            LazyGridMeasuredItem lazyGridMeasuredItem = lazyGridMeasuredItemArr[i10];
            int i13 = i11 + 1;
            int iD = GridItemSpan.d(((GridItemSpan) this.f7867d.get(i11)).g());
            int i14 = this.f7866c.a()[i12];
            boolean z2 = this.f7868e;
            int i15 = z2 ? this.f7864a : i12;
            if (z2) {
                i6 = i12;
                i9 = i3;
                i7 = i4;
                i8 = i5;
            } else {
                i6 = this.f7864a;
                i7 = i4;
                i8 = i5;
                i9 = i3;
            }
            lazyGridMeasuredItem.u(i9, i14, i7, i8, i15, i6);
            Unit unit = Unit.f139807a;
            i12 += iD;
            i10++;
            i11 = i13;
        }
        return this.f7865b;
    }
}
