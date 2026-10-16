package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
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
public final class PagerLazyLayoutItemProvider implements LazyLayoutItemProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PagerState f8764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyLayoutIntervalContent f8765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyLayoutKeyIndexMap f8766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PagerScopeImpl f8767d = PagerScopeImpl.f8829a;

    public PagerLazyLayoutItemProvider(PagerState pagerState, LazyLayoutIntervalContent lazyLayoutIntervalContent, LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap) {
        this.f8764a = pagerState;
        this.f8765b = lazyLayoutIntervalContent;
        this.f8766c = lazyLayoutKeyIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int a() {
        return this.f8765b.k();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int c(Object obj) {
        return this.f8766c.c(obj);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object d(int i3) {
        Object objD = this.f8766c.d(i3);
        return objD == null ? this.f8765b.l(i3) : objD;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PagerLazyLayoutItemProvider) {
            return Intrinsics.areEqual(this.f8765b, ((PagerLazyLayoutItemProvider) obj).f8765b);
        }
        return false;
    }

    public int hashCode() {
        return this.f8765b.hashCode();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public void i(final int i3, Object obj, Composer composer, int i4) {
        composer.a0(-1201380429);
        if (ComposerKt.M()) {
            ComposerKt.U(-1201380429, i4, -1, "androidx.compose.foundation.pager.PagerLazyLayoutItemProvider.Item (LazyLayoutPager.kt:210)");
        }
        LazyLayoutPinnableItemKt.a(obj, i3, this.f8764a.L(), ComposableLambdaKt.e(1142237095, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerLazyLayoutItemProvider$Item$1
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
                    ComposerKt.U(1142237095, i5, -1, "androidx.compose.foundation.pager.PagerLazyLayoutItemProvider.Item.<anonymous> (LazyLayoutPager.kt:212)");
                }
                LazyLayoutIntervalContent lazyLayoutIntervalContent = this.f8768a.f8765b;
                int i6 = i3;
                PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider = this.f8768a;
                IntervalList.Interval interval = lazyLayoutIntervalContent.j().get(i6);
                ((PagerIntervalContent) interval.c()).a().invoke(pagerLazyLayoutItemProvider.f8767d, Integer.valueOf(i6 - interval.b()), composer2, 0);
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
