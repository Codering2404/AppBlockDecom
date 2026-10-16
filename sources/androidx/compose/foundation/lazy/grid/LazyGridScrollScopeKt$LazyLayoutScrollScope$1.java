package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
public final class LazyGridScrollScopeKt$LazyLayoutScrollScope$1 implements LazyLayoutScrollScope, ScrollScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ScrollScope f7884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LazyGridState f7885b;

    LazyGridScrollScopeKt$LazyLayoutScrollScope$1(ScrollScope scrollScope, LazyGridState lazyGridState) {
        this.f7885b = lazyGridState;
        this.f7884a = scrollScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int a() {
        return this.f7885b.w().e();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int b() {
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull(this.f7885b.w().h());
        if (lazyGridItemInfo != null) {
            return lazyGridItemInfo.getIndex();
        }
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public void c(int i3, int i4) {
        this.f7885b.N(i3, i4, true);
    }

    @Override // androidx.compose.foundation.gestures.ScrollScope
    public float d(float f3) {
        return this.f7884a.d(f3);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int f(int i3, int i4) {
        Integer numValueOf;
        Object obj;
        LazyGridLayoutInfo lazyGridLayoutInfoW = this.f7885b.w();
        if (lazyGridLayoutInfoW.h().isEmpty()) {
            return 0;
        }
        int iH = h();
        if (i3 > b() || iH > i3) {
            int iG = this.f7885b.G();
            iA = (LazyGridLayoutInfoKt.a(lazyGridLayoutInfoW) * (((i3 - h()) + ((iG - 1) * ((i3 < h() ? 1 : 0) != 0 ? -1 : 1))) / iG)) - g();
        } else {
            List listH = lazyGridLayoutInfoW.h();
            int size = listH.size();
            int i5 = 0;
            while (true) {
                numValueOf = null;
                if (i5 >= size) {
                    obj = null;
                    break;
                }
                obj = listH.get(i5);
                if (((LazyGridItemInfo) obj).getIndex() == i3) {
                    break;
                }
                i5++;
            }
            LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) obj;
            if (lazyGridLayoutInfoW.getOrientation() == Orientation.f6031a) {
                if (lazyGridItemInfo != null) {
                    numValueOf = Integer.valueOf(IntOffset.l(lazyGridItemInfo.f()));
                }
            } else if (lazyGridItemInfo != null) {
                numValueOf = Integer.valueOf(IntOffset.k(lazyGridItemInfo.f()));
            }
            if (numValueOf != null) {
                iA = numValueOf.intValue();
            }
        }
        return iA + i4;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int g() {
        return this.f7885b.s();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int h() {
        return this.f7885b.r();
    }
}
