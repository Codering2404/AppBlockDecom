package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.changelist.Operation;
import androidx.compose.runtime.changelist.Operations;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

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
public final class FixupList extends OperationsDebugStringFormattable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Operations f24329a = new Operations();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Operations f24330b = new Operations();

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("FixupList instance containing " + f() + " operations");
        if (sb.length() > 0) {
            sb.append(":\n" + this.f24329a.a(str));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void b() {
        this.f24330b.c();
        this.f24329a.c();
    }

    public final void c(Function0 function0, int i3, Anchor anchor) {
        Operations operations = this.f24329a;
        Operation.InsertNodeFixup insertNodeFixup = Operation.InsertNodeFixup.f24347c;
        operations.o(insertNodeFixup);
        Operations operationsA = Operations.WriteScope.a(operations);
        Operations.WriteScope.d(operationsA, Operation.ObjectParameter.a(0), function0);
        operationsA.f24374c[operationsA.f24375d - operationsA.f24372a[operationsA.f24373b - 1].b()] = i3;
        Operations.WriteScope.d(operationsA, Operation.ObjectParameter.a(1), anchor);
        operations.f(insertNodeFixup);
        Operations operations2 = this.f24330b;
        Operation.PostInsertNodeFixup postInsertNodeFixup = Operation.PostInsertNodeFixup.f24353c;
        operations2.o(postInsertNodeFixup);
        Operations operationsA2 = Operations.WriteScope.a(operations2);
        operationsA2.f24374c[operationsA2.f24375d - operationsA2.f24372a[operationsA2.f24373b - 1].b()] = i3;
        Operations.WriteScope.d(operationsA2, Operation.ObjectParameter.a(0), anchor);
        operations2.f(postInsertNodeFixup);
    }

    public final void d() {
        if (!this.f24330b.l()) {
            ComposerKt.t("Cannot end node insertion, there are no pending operations that can be realized.");
        }
        this.f24330b.m(this.f24329a);
    }

    public final void e(Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
        if (!this.f24330b.k()) {
            ComposerKt.t("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        this.f24329a.g(applier, slotWriter, rememberManager);
    }

    public final int f() {
        return this.f24329a.i();
    }

    public final boolean g() {
        return this.f24329a.k();
    }

    public final void h(Object obj, Function2 function2) {
        Operations operations = this.f24329a;
        Operation.UpdateNode updateNode = Operation.UpdateNode.f24368c;
        operations.o(updateNode);
        Operations operationsA = Operations.WriteScope.a(operations);
        Operations.WriteScope.d(operationsA, Operation.ObjectParameter.a(0), obj);
        int iA = Operation.ObjectParameter.a(1);
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        Operations.WriteScope.d(operationsA, iA, (Function2) TypeIntrinsics.f(function2, 2));
        operations.f(updateNode);
    }
}
