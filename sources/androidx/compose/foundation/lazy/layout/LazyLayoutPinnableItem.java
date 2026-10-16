package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.PinnableContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
final class LazyLayoutPinnableItem implements PinnableContainer, PinnableContainer.PinnedHandle, LazyLayoutPinnedItemList.PinnedItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyLayoutPinnedItemList f8154b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PinnableContainer.PinnedHandle f8157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8158f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8155c = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f8159g = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    public LazyLayoutPinnableItem(Object obj, LazyLayoutPinnedItemList lazyLayoutPinnedItemList) {
        this.f8153a = obj;
        this.f8154b = lazyLayoutPinnedItemList;
    }

    private final PinnableContainer c() {
        return (PinnableContainer) this.f8159g.getValue();
    }

    private final void g(PinnableContainer pinnableContainer) {
        this.f8159g.setValue(pinnableContainer);
    }

    @Override // androidx.compose.ui.layout.PinnableContainer
    public PinnableContainer.PinnedHandle a() {
        if (this.f8158f) {
            InlineClassHelperKt.c("Pin should not be called on an already disposed item ");
        }
        if (this.f8156d == 0) {
            this.f8154b.g(this);
            PinnableContainer pinnableContainerB = b();
            this.f8157e = pinnableContainerB != null ? pinnableContainerB.a() : null;
        }
        this.f8156d++;
        return this;
    }

    public final PinnableContainer b() {
        return c();
    }

    public final void d() {
        this.f8158f = true;
    }

    public void e(int i3) {
        this.f8155c = i3;
    }

    public final void f(PinnableContainer pinnableContainer) {
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            if (pinnableContainer != c()) {
                g(pinnableContainer);
                if (this.f8156d > 0) {
                    PinnableContainer.PinnedHandle pinnedHandle = this.f8157e;
                    if (pinnedHandle != null) {
                        pinnedHandle.release();
                    }
                    this.f8157e = pinnableContainer != null ? pinnableContainer.a() : null;
                }
            }
            Unit unit = Unit.f139807a;
            companion.m(snapshotD, snapshotE, function1G);
        } catch (Throwable th) {
            companion.m(snapshotD, snapshotE, function1G);
            throw th;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem
    public int getIndex() {
        return this.f8155c;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem
    public Object getKey() {
        return this.f8153a;
    }

    @Override // androidx.compose.ui.layout.PinnableContainer.PinnedHandle
    public void release() {
        if (this.f8158f) {
            return;
        }
        if (!(this.f8156d > 0)) {
            InlineClassHelperKt.c("Release should only be called once");
        }
        int i3 = this.f8156d - 1;
        this.f8156d = i3;
        if (i3 == 0) {
            this.f8154b.h(this);
            PinnableContainer.PinnedHandle pinnedHandle = this.f8157e;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            this.f8157e = null;
        }
    }
}
