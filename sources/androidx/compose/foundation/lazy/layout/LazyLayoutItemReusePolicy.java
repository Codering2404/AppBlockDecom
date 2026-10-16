package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import kotlin.Metadata;
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
final class LazyLayoutItemReusePolicy implements SubcomposeSlotReusePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyLayoutItemContentFactory f8122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableObjectIntMap f8123b = ObjectIntMapKt.b();

    public LazyLayoutItemReusePolicy(LazyLayoutItemContentFactory lazyLayoutItemContentFactory) {
        this.f8122a = lazyLayoutItemContentFactory;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public void a(SubcomposeSlotReusePolicy.SlotIdsSet slotIdsSet) {
        this.f8123b.j();
        for (Object obj : slotIdsSet) {
            Object objC = this.f8122a.c(obj);
            int iE = this.f8123b.e(objC, 0);
            if (iE == 7) {
                slotIdsSet.remove(obj);
            } else {
                this.f8123b.u(objC, iE + 1);
            }
        }
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public boolean b(Object obj, Object obj2) {
        return Intrinsics.areEqual(this.f8122a.c(obj), this.f8122a.c(obj2));
    }
}
