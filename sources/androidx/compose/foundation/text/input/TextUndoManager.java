package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperationKt;
import androidx.compose.foundation.text.input.internal.undo.UndoManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class TextUndoManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f10168c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10169d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UndoManager f10170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f10171b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextUndoManager, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Saver f10172a = new Saver();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final androidx.compose.runtime.saveable.Saver f10173b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f10174c;

            static {
                UndoManager.Companion companion = UndoManager.f10991d;
                final androidx.compose.runtime.saveable.Saver saverA = TextUndoOperation.f10981i.a();
                f10173b = new androidx.compose.runtime.saveable.Saver<UndoManager<TextUndoOperation>, Object>() { // from class: androidx.compose.foundation.text.input.TextUndoManager$Companion$Saver$special$$inlined$createSaver$1
                    @Override // androidx.compose.runtime.saveable.Saver
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public UndoManager b(Object obj) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                        List list = (List) obj;
                        int iIntValue = ((Number) list.get(0)).intValue();
                        int iIntValue2 = ((Number) list.get(1)).intValue();
                        int iIntValue3 = ((Number) list.get(2)).intValue();
                        Saver saver = saverA;
                        List listCreateListBuilder = CollectionsKt.createListBuilder();
                        int i3 = 3;
                        while (i3 < iIntValue2 + 3) {
                            Object objB = saver.b(list.get(i3));
                            Intrinsics.checkNotNull(objB);
                            listCreateListBuilder.add(objB);
                            i3++;
                        }
                        List listBuild = CollectionsKt.build(listCreateListBuilder);
                        Saver saver2 = saverA;
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
                        Saver saver = saverA;
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
                };
                f10174c = 8;
            }

            private Saver() {
            }

            @Override // androidx.compose.runtime.saveable.Saver
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public TextUndoManager b(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
                List list = (List) obj;
                Object obj2 = list.get(0);
                Object obj3 = list.get(1);
                TextUndoOperation textUndoOperation = obj2 != null ? (TextUndoOperation) TextUndoOperation.f10981i.a().b(obj2) : null;
                androidx.compose.runtime.saveable.Saver saver = f10173b;
                Intrinsics.checkNotNull(obj3);
                UndoManager undoManager = (UndoManager) saver.b(obj3);
                Intrinsics.checkNotNull(undoManager);
                return new TextUndoManager(textUndoOperation, undoManager);
            }

            @Override // androidx.compose.runtime.saveable.Saver
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Object a(SaverScope saverScope, TextUndoManager textUndoManager) {
                TextUndoOperation textUndoOperationG = textUndoManager.g();
                return CollectionsKt.listOf(textUndoOperationG != null ? TextUndoOperation.f10981i.a().a(saverScope, textUndoOperationG) : null, f10173b.a(saverScope, textUndoManager.f10170a));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public TextUndoManager(TextUndoOperation textUndoOperation, UndoManager undoManager) {
        this.f10170a = undoManager;
        this.f10171b = SnapshotStateKt__SnapshotStateKt.e(textUndoOperation, null, 2, null);
    }

    private final void d() {
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            TextUndoOperation textUndoOperationG = g();
            if (textUndoOperationG != null) {
                this.f10170a.h(textUndoOperationG);
            }
            j(null);
        } finally {
            companion.m(snapshotD, snapshotE, function1G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextUndoOperation g() {
        return (TextUndoOperation) this.f10171b.getValue();
    }

    private final void j(TextUndoOperation textUndoOperation) {
        this.f10171b.setValue(textUndoOperation);
    }

    public final void c() {
        j(null);
        this.f10170a.d();
    }

    public final boolean e() {
        return this.f10170a.e() && g() == null;
    }

    public final boolean f() {
        return this.f10170a.f() || g() != null;
    }

    public final void h(TextUndoOperation textUndoOperation) {
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            TextUndoOperation textUndoOperationG = g();
            if (textUndoOperationG == null) {
                j(textUndoOperation);
                return;
            }
            TextUndoOperation textUndoOperationB = TextUndoManagerKt.b(textUndoOperationG, textUndoOperation);
            if (textUndoOperationB != null) {
                j(textUndoOperationB);
            } else {
                d();
                j(textUndoOperation);
            }
        } finally {
            companion.m(snapshotD, snapshotE, function1G);
        }
    }

    public final void i(TextFieldState textFieldState) {
        if (e()) {
            TextUndoOperationKt.a(textFieldState, (TextUndoOperation) this.f10170a.i());
        }
    }

    public final void k(TextFieldState textFieldState) {
        if (f()) {
            d();
            TextUndoOperationKt.b(textFieldState, (TextUndoOperation) this.f10170a.j());
        }
    }

    public /* synthetic */ TextUndoManager(TextUndoOperation textUndoOperation, UndoManager undoManager, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : textUndoOperation, (i3 & 2) != 0 ? new UndoManager(null, null, 100, 3, null) : undoManager);
    }
}
