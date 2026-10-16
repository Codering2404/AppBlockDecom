package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.math.MathKt;
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
public final class PagerScrollScopeKt$LazyLayoutScrollScope$1 implements LazyLayoutScrollScope, ScrollScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ScrollScope f8836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PagerState f8837b;

    PagerScrollScopeKt$LazyLayoutScrollScope$1(ScrollScope scrollScope, PagerState pagerState) {
        this.f8837b = pagerState;
        this.f8836a = scrollScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int a() {
        return this.f8837b.H();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int b() {
        return ((PageInfo) CollectionsKt.last(this.f8837b.C().y())).getIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public void c(int i3, int i4) {
        this.f8837b.o0(i3, i4 / this.f8837b.J(), true);
    }

    @Override // androidx.compose.foundation.gestures.ScrollScope
    public float d(float f3) {
        return this.f8836a.d(f3);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int f(int i3, int i4) {
        return (int) (RangesKt.r(PagerScrollPositionKt.a(this.f8837b) + ((long) MathKt.d((((i3 - this.f8837b.v()) * this.f8837b.J()) - (this.f8837b.w() * this.f8837b.J())) + i4)), this.f8837b.F(), this.f8837b.D()) - PagerScrollPositionKt.a(this.f8837b));
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int g() {
        return this.f8837b.z();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int h() {
        return this.f8837b.y();
    }
}
