package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemElement;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.Modifier;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;

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
public final class LazyItemScopeImpl implements LazyItemScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MutableIntState f7425a = SnapshotIntStateKt.a(Api.BaseClientBuilder.API_PRIORITY_OTHER);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutableIntState f7426b = SnapshotIntStateKt.a(Api.BaseClientBuilder.API_PRIORITY_OTHER);

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public Modifier b(Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        return (finiteAnimationSpec == null && finiteAnimationSpec2 == null && finiteAnimationSpec3 == null) ? modifier : modifier.then(new LazyLayoutAnimateItemElement(finiteAnimationSpec, finiteAnimationSpec2, finiteAnimationSpec3));
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public Modifier d(Modifier modifier, float f3) {
        return modifier.then(new ParentSizeElement(f3, this.f7425a, null, "fillParentMaxWidth", 4, null));
    }

    public final void e(int i3, int i4) {
        this.f7425a.a(i3);
        this.f7426b.a(i4);
    }
}
