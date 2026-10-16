package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class UndoManager$Companion$createSaver$1 implements Saver<UndoManager<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Saver f10996a;

    @Override // androidx.compose.runtime.saveable.Saver
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public UndoManager b(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        int iIntValue = ((Number) list.get(0)).intValue();
        int iIntValue2 = ((Number) list.get(1)).intValue();
        int iIntValue3 = ((Number) list.get(2)).intValue();
        Saver saver = this.f10996a;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        int i3 = 3;
        while (i3 < iIntValue2 + 3) {
            Object objB = saver.b(list.get(i3));
            Intrinsics.checkNotNull(objB);
            listCreateListBuilder.add(objB);
            i3++;
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        Saver saver2 = this.f10996a;
        List listCreateListBuilder2 = CollectionsKt.createListBuilder();
        while (i3 < iIntValue2 + iIntValue3 + 3) {
            Object objB2 = saver2.b(list.get(i3));
            Intrinsics.checkNotNull(objB2);
            listCreateListBuilder2.add(objB2);
            i3++;
        }
        return new UndoManager(listBuild, CollectionsKt.build(listCreateListBuilder2), iIntValue);
    }

    @Override // androidx.compose.runtime.saveable.Saver
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Object a(SaverScope saverScope, UndoManager undoManager) {
        Saver saver = this.f10996a;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(Integer.valueOf(undoManager.f10993a));
        listCreateListBuilder.add(Integer.valueOf(undoManager.f10994b.size()));
        listCreateListBuilder.add(Integer.valueOf(undoManager.f10995c.size()));
        SnapshotStateList snapshotStateList = undoManager.f10994b;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            listCreateListBuilder.add(saver.a(saverScope, snapshotStateList.get(i3)));
        }
        SnapshotStateList snapshotStateList2 = undoManager.f10995c;
        int size2 = snapshotStateList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            listCreateListBuilder.add(saver.a(saverScope, snapshotStateList2.get(i4)));
        }
        return CollectionsKt.build(listCreateListBuilder);
    }
}
