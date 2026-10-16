package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
final class LazyStaggeredGridItemProviderImpl implements LazyStaggeredGridItemProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyStaggeredGridState f8400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyStaggeredGridIntervalContent f8401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyLayoutKeyIndexMap f8402c;

    public LazyStaggeredGridItemProviderImpl(LazyStaggeredGridState lazyStaggeredGridState, LazyStaggeredGridIntervalContent lazyStaggeredGridIntervalContent, LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap) {
        this.f8400a = lazyStaggeredGridState;
        this.f8401b = lazyStaggeredGridIntervalContent;
        this.f8402c = lazyLayoutKeyIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int a() {
        return this.f8401b.k();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider
    public LazyLayoutKeyIndexMap b() {
        return this.f8402c;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int c(Object obj) {
        return b().c(obj);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object d(int i3) {
        Object objD = b().d(i3);
        return objD == null ? this.f8401b.l(i3) : objD;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazyStaggeredGridItemProviderImpl) {
            return Intrinsics.areEqual(this.f8401b, ((LazyStaggeredGridItemProviderImpl) obj).f8401b);
        }
        return false;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object f(int i3) {
        return this.f8401b.i(i3);
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider
    public LazyStaggeredGridSpanProvider h() {
        return this.f8401b.n();
    }

    public int hashCode() {
        return this.f8401b.hashCode();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public void i(final int i3, Object obj, Composer composer, int i4) {
        composer.a0(89098518);
        if (ComposerKt.M()) {
            ComposerKt.U(89098518, i4, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderImpl.Item (LazyStaggeredGridItemProvider.kt:77)");
        }
        LazyLayoutPinnableItemKt.a(obj, i3, this.f8400a.C(), ComposableLambdaKt.e(608834466, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderImpl$Item$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i5) {
                if (!composer2.r((i5 & 3) != 2, i5 & 1)) {
                    composer2.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(608834466, i5, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderImpl.Item.<anonymous> (LazyStaggeredGridItemProvider.kt:79)");
                }
                LazyStaggeredGridIntervalContent lazyStaggeredGridIntervalContent = this.f8403a.f8401b;
                int i6 = i3;
                IntervalList.Interval interval = lazyStaggeredGridIntervalContent.j().get(i6);
                ((LazyStaggeredGridInterval) interval.c()).a().invoke(LazyStaggeredGridItemScopeImpl.f8408a, Integer.valueOf(i6 - interval.b()), composer2, 6);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }, composer, 54), composer, ((i4 >> 3) & 14) | 3072 | ((i4 << 3) & 112));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
    }
}
