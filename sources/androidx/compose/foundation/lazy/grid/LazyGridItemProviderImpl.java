package androidx.compose.foundation.lazy.grid;

import androidx.collection.IntList;
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
final class LazyGridItemProviderImpl implements LazyGridItemProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyGridState f7757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyGridIntervalContent f7758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyLayoutKeyIndexMap f7759c;

    public LazyGridItemProviderImpl(LazyGridState lazyGridState, LazyGridIntervalContent lazyGridIntervalContent, LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap) {
        this.f7757a = lazyGridState;
        this.f7758b = lazyGridIntervalContent;
        this.f7759c = lazyLayoutKeyIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int a() {
        return this.f7758b.k();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public LazyLayoutKeyIndexMap b() {
        return this.f7759c;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int c(Object obj) {
        return b().c(obj);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object d(int i3) {
        Object objD = b().d(i3);
        return objD == null ? this.f7758b.l(i3) : objD;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public IntList e() {
        return this.f7758b.n();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazyGridItemProviderImpl) {
            return Intrinsics.areEqual(this.f7758b, ((LazyGridItemProviderImpl) obj).f7758b);
        }
        return false;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object f(int i3) {
        return this.f7758b.i(i3);
    }

    public int hashCode() {
        return this.f7758b.hashCode();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public void i(final int i3, Object obj, Composer composer, int i4) {
        composer.a0(1493551140);
        if (ComposerKt.M()) {
            ComposerKt.U(1493551140, i4, -1, "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl.Item (LazyGridItemProvider.kt:81)");
        }
        LazyLayoutPinnableItemKt.a(obj, i3, this.f7757a.A(), ComposableLambdaKt.e(726189336, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl$Item$1
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
                    ComposerKt.U(726189336, i5, -1, "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl.Item.<anonymous> (LazyGridItemProvider.kt:83)");
                }
                LazyGridIntervalContent lazyGridIntervalContent = this.f7760a.f7758b;
                int i6 = i3;
                IntervalList.Interval interval = lazyGridIntervalContent.j().get(i6);
                ((LazyGridInterval) interval.c()).a().invoke(LazyGridItemScopeImpl.f7765a, Integer.valueOf(i6 - interval.b()), composer2, 6);
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

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public LazyGridSpanLayoutProvider j() {
        return this.f7758b.p();
    }
}
