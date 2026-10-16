package androidx.compose.foundation.lazy;

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
final class LazyListItemProviderImpl implements LazyListItemProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyListState f7441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyListIntervalContent f7442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyItemScopeImpl f7443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LazyLayoutKeyIndexMap f7444d;

    public LazyListItemProviderImpl(LazyListState lazyListState, LazyListIntervalContent lazyListIntervalContent, LazyItemScopeImpl lazyItemScopeImpl, LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap) {
        this.f7441a = lazyListState;
        this.f7442b = lazyListIntervalContent;
        this.f7443c = lazyItemScopeImpl;
        this.f7444d = lazyLayoutKeyIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int a() {
        return this.f7442b.k();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public LazyLayoutKeyIndexMap b() {
        return this.f7444d;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int c(Object obj) {
        return b().c(obj);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object d(int i3) {
        Object objD = b().d(i3);
        return objD == null ? this.f7442b.l(i3) : objD;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public IntList e() {
        return this.f7442b.m();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazyListItemProviderImpl) {
            return Intrinsics.areEqual(this.f7442b, ((LazyListItemProviderImpl) obj).f7442b);
        }
        return false;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object f(int i3) {
        return this.f7442b.i(i3);
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public LazyItemScopeImpl g() {
        return this.f7443c;
    }

    public int hashCode() {
        return this.f7442b.hashCode();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public void i(final int i3, Object obj, Composer composer, int i4) {
        composer.a0(-462424778);
        if (ComposerKt.M()) {
            ComposerKt.U(-462424778, i4, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:80)");
        }
        LazyLayoutPinnableItemKt.a(obj, i3, this.f7441a.B(), ComposableLambdaKt.e(-824725566, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl$Item$1
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
                    ComposerKt.U(-824725566, i5, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item.<anonymous> (LazyListItemProvider.kt:82)");
                }
                LazyListIntervalContent lazyListIntervalContent = this.f7445a.f7442b;
                int i6 = i3;
                LazyListItemProviderImpl lazyListItemProviderImpl = this.f7445a;
                IntervalList.Interval interval = lazyListIntervalContent.j().get(i6);
                ((LazyListInterval) interval.c()).a().invoke(lazyListItemProviderImpl.g(), Integer.valueOf(i6 - interval.b()), composer2, 0);
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
