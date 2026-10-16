package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class UndoManager<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f10991d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10992e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SnapshotStateList f10994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SnapshotStateList f10995c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public UndoManager(List list, List list2, int i3) {
        this.f10993a = i3;
        SnapshotStateList snapshotStateList = new SnapshotStateList();
        snapshotStateList.addAll(list);
        this.f10994b = snapshotStateList;
        SnapshotStateList snapshotStateList2 = new SnapshotStateList();
        snapshotStateList2.addAll(list2);
        this.f10995c = snapshotStateList2;
        if (!(i3 >= 0)) {
            InlineClassHelperKt.a("Capacity must be a positive integer");
        }
        if (g() <= i3) {
            return;
        }
        InlineClassHelperKt.a("Initial list of undo and redo operations have a size greater than the given capacity.");
    }

    public final void d() {
        this.f10994b.clear();
        this.f10995c.clear();
    }

    public final boolean e() {
        return !this.f10995c.isEmpty();
    }

    public final boolean f() {
        return !this.f10994b.isEmpty();
    }

    public final int g() {
        return this.f10994b.size() + this.f10995c.size();
    }

    public final void h(Object obj) {
        this.f10995c.clear();
        while (g() > this.f10993a - 1) {
            CollectionsKt.removeFirst(this.f10994b);
        }
        this.f10994b.add(obj);
    }

    public final Object i() {
        if (!e()) {
            InlineClassHelperKt.c("It's an error to call redo while there is nothing to redo. Please first check `canRedo` value before calling the `redo` function.");
        }
        Object objRemoveLast = CollectionsKt.removeLast(this.f10995c);
        this.f10994b.add(objRemoveLast);
        return objRemoveLast;
    }

    public final Object j() {
        if (!f()) {
            InlineClassHelperKt.c("It's an error to call undo while there is nothing to undo. Please first check `canUndo` value before calling the `undo` function.");
        }
        Object objRemoveLast = CollectionsKt.removeLast(this.f10994b);
        this.f10995c.add(objRemoveLast);
        return objRemoveLast;
    }

    public /* synthetic */ UndoManager(List list, List list2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? CollectionsKt.emptyList() : list, (i4 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i4 & 4) != 0 ? 100 : i3);
    }
}
