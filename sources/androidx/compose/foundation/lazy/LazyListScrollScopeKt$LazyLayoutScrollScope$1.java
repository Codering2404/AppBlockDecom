package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
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
public final class LazyListScrollScopeKt$LazyLayoutScrollScope$1 implements LazyLayoutScrollScope, ScrollScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ScrollScope f7561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LazyListState f7562b;

    LazyListScrollScopeKt$LazyLayoutScrollScope$1(ScrollScope scrollScope, LazyListState lazyListState) {
        this.f7562b = lazyListState;
        this.f7561a = scrollScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int a() {
        return this.f7562b.y().e();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int b() {
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.lastOrNull(this.f7562b.y().h());
        if (lazyListItemInfo != null) {
            return lazyListItemInfo.getIndex();
        }
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public void c(int i3, int i4) {
        this.f7562b.N(i3, i4, true);
    }

    @Override // androidx.compose.foundation.gestures.ScrollScope
    public float d(float f3) {
        return this.f7561a.d(f3);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int f(int i3, int i4) {
        Object obj;
        LazyListLayoutInfo lazyListLayoutInfoY = this.f7562b.y();
        int iA = 0;
        if (lazyListLayoutInfoY.h().isEmpty()) {
            return 0;
        }
        int iH = h();
        if (i3 > b() || iH > i3) {
            iA = (LazyListLayoutInfoKt.a(lazyListLayoutInfoY) * (i3 - h())) - g();
        } else {
            List listH = lazyListLayoutInfoY.h();
            int size = listH.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    obj = null;
                    break;
                }
                obj = listH.get(i5);
                if (((LazyListItemInfo) obj).getIndex() == i3) {
                    break;
                }
                i5++;
            }
            LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) obj;
            if (lazyListItemInfo != null) {
                iA = lazyListItemInfo.getOffset();
            }
        }
        return iA + i4;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int g() {
        return this.f7562b.t();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int h() {
        return this.f7562b.s();
    }
}
