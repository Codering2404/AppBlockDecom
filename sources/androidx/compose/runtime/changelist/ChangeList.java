package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.changelist.Operation;
import androidx.compose.runtime.changelist.Operations;
import androidx.compose.runtime.internal.IntRef;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class ChangeList extends OperationsDebugStringFormattable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Operations f24314a = new Operations();

    public final void A(RecomposeScopeImpl recomposeScopeImpl) {
        Operations operations = this.f24314a;
        Operation.RememberPausingScope rememberPausingScope = Operation.RememberPausingScope.f24356c;
        operations.o(rememberPausingScope);
        Operations.WriteScope.d(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), recomposeScopeImpl);
        operations.f(rememberPausingScope);
    }

    public final void B() {
        this.f24314a.n(Operation.RemoveCurrentGroup.f24357c);
    }

    public final void C(int i3, int i4) {
        Operations operations = this.f24314a;
        Operation.RemoveNode removeNode = Operation.RemoveNode.f24358c;
        operations.o(removeNode);
        Operations operationsA = Operations.WriteScope.a(operations);
        int iB = operationsA.f24375d - operationsA.f24372a[operationsA.f24373b - 1].b();
        int[] iArr = operationsA.f24374c;
        iArr[iB] = i3;
        iArr[iB + 1] = i4;
        operations.f(removeNode);
    }

    public final void D() {
        this.f24314a.n(Operation.ResetSlots.f24359c);
    }

    public final void E(Function0 function0) {
        Operations operations = this.f24314a;
        Operation.SideEffect sideEffect = Operation.SideEffect.f24360c;
        operations.o(sideEffect);
        Operations.WriteScope.d(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), function0);
        operations.f(sideEffect);
    }

    public final void F() {
        this.f24314a.n(Operation.SkipToEndOfCurrentGroup.f24361c);
    }

    public final void G(RecomposeScopeImpl recomposeScopeImpl) {
        Operations operations = this.f24314a;
        Operation.StartResumingScope startResumingScope = Operation.StartResumingScope.f24362c;
        operations.o(startResumingScope);
        Operations.WriteScope.d(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), recomposeScopeImpl);
        operations.f(startResumingScope);
    }

    public final void H(int i3) {
        Operations operations = this.f24314a;
        Operation.TrimParentValues trimParentValues = Operation.TrimParentValues.f24365c;
        operations.o(trimParentValues);
        Operations operationsA = Operations.WriteScope.a(operations);
        operationsA.f24374c[operationsA.f24375d - operationsA.f24372a[operationsA.f24373b - 1].b()] = i3;
        operations.f(trimParentValues);
    }

    public final void I(Object obj, Anchor anchor, int i3) {
        Operations operations = this.f24314a;
        Operation.UpdateAnchoredValue updateAnchoredValue = Operation.UpdateAnchoredValue.f24366c;
        operations.o(updateAnchoredValue);
        Operations operationsA = Operations.WriteScope.a(operations);
        Operations.WriteScope.e(operationsA, Operation.ObjectParameter.a(0), obj, Operation.ObjectParameter.a(1), anchor);
        operationsA.f24374c[operationsA.f24375d - operationsA.f24372a[operationsA.f24373b - 1].b()] = i3;
        operations.f(updateAnchoredValue);
    }

    public final void J(Object obj) {
        Operations operations = this.f24314a;
        Operation.UpdateAuxData updateAuxData = Operation.UpdateAuxData.f24367c;
        operations.o(updateAuxData);
        Operations.WriteScope.d(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), obj);
        operations.f(updateAuxData);
    }

    public final void K(Object obj, Function2 function2) {
        Operations operations = this.f24314a;
        Operation.UpdateNode updateNode = Operation.UpdateNode.f24368c;
        operations.o(updateNode);
        Operations operationsA = Operations.WriteScope.a(operations);
        int iA = Operation.ObjectParameter.a(0);
        int iA2 = Operation.ObjectParameter.a(1);
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        Operations.WriteScope.e(operationsA, iA, obj, iA2, (Function2) TypeIntrinsics.f(function2, 2));
        operations.f(updateNode);
    }

    public final void L(Object obj, int i3) {
        Operations operations = this.f24314a;
        Operation.UpdateValue updateValue = Operation.UpdateValue.f24369c;
        operations.o(updateValue);
        Operations operationsA = Operations.WriteScope.a(operations);
        Operations.WriteScope.d(operationsA, Operation.ObjectParameter.a(0), obj);
        operationsA.f24374c[operationsA.f24375d - operationsA.f24372a[operationsA.f24373b - 1].b()] = i3;
        operations.f(updateValue);
    }

    public final void M(int i3) {
        Operations operations = this.f24314a;
        Operation.Ups ups = Operation.Ups.f24370c;
        operations.o(ups);
        Operations operationsA = Operations.WriteScope.a(operations);
        operationsA.f24374c[operationsA.f24375d - operationsA.f24372a[operationsA.f24373b - 1].b()] = i3;
        operations.f(ups);
    }

    public final void N(Object obj) {
        if (obj instanceof ComposeNodeLifecycleCallback) {
            this.f24314a.n(Operation.UseCurrentNode.f24371c);
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("ChangeList instance containing ");
        sb.append(d());
        sb.append(" operations");
        if (sb.length() > 0) {
            sb.append(":\n");
            sb.append(this.f24314a.a(str));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void b() {
        this.f24314a.c();
    }

    public final void c(Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
        this.f24314a.g(applier, slotWriter, rememberManager);
    }

    public final int d() {
        return this.f24314a.i();
    }

    public final boolean e() {
        return this.f24314a.k();
    }

    public final boolean f() {
        return this.f24314a.l();
    }

    public final void g(int i3) {
        Operations operations = this.f24314a;
        Operation.AdvanceSlotsBy advanceSlotsBy = Operation.AdvanceSlotsBy.f24333c;
        operations.o(advanceSlotsBy);
        Operations operationsA = Operations.WriteScope.a(operations);
        operationsA.f24374c[operationsA.f24375d - operationsA.f24372a[operationsA.f24373b - 1].b()] = i3;
        operations.f(advanceSlotsBy);
    }

    public final void h(Anchor anchor, Object obj) {
        Operations operations = this.f24314a;
        Operation.AppendValue appendValue = Operation.AppendValue.f24334c;
        operations.o(appendValue);
        Operations.WriteScope.e(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), anchor, Operation.ObjectParameter.a(1), obj);
        operations.f(appendValue);
    }

    public final void i(List list, IntRef intRef) {
        if (list.isEmpty()) {
            return;
        }
        Operations operations = this.f24314a;
        Operation.CopyNodesToNewAnchorLocation copyNodesToNewAnchorLocation = Operation.CopyNodesToNewAnchorLocation.f24336c;
        operations.o(copyNodesToNewAnchorLocation);
        Operations.WriteScope.e(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(1), list, Operation.ObjectParameter.a(0), intRef);
        operations.f(copyNodesToNewAnchorLocation);
    }

    public final void j(MovableContentState movableContentState, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        Operations operations = this.f24314a;
        Operation.CopySlotTableToAnchorLocation copySlotTableToAnchorLocation = Operation.CopySlotTableToAnchorLocation.f24337c;
        operations.o(copySlotTableToAnchorLocation);
        Operations.WriteScope.f(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), movableContentState, Operation.ObjectParameter.a(1), compositionContext, Operation.ObjectParameter.a(3), movableContentStateReference2, Operation.ObjectParameter.a(2), movableContentStateReference);
        operations.f(copySlotTableToAnchorLocation);
    }

    public final void k() {
        this.f24314a.n(Operation.DeactivateCurrentGroup.f24338c);
    }

    public final void l(IntRef intRef, Anchor anchor) {
        Operations operations = this.f24314a;
        Operation.DetermineMovableContentNodeIndex determineMovableContentNodeIndex = Operation.DetermineMovableContentNodeIndex.f24339c;
        operations.o(determineMovableContentNodeIndex);
        Operations.WriteScope.e(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), intRef, Operation.ObjectParameter.a(1), anchor);
        operations.f(determineMovableContentNodeIndex);
    }

    public final void m(Object[] objArr) {
        if (objArr.length == 0) {
            return;
        }
        Operations operations = this.f24314a;
        Operation.Downs downs = Operation.Downs.f24340c;
        operations.o(downs);
        Operations.WriteScope.d(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), objArr);
        operations.f(downs);
    }

    public final void n(Function1 function1, Composition composition) {
        Operations operations = this.f24314a;
        Operation.EndCompositionScope endCompositionScope = Operation.EndCompositionScope.f24341c;
        operations.o(endCompositionScope);
        Operations.WriteScope.e(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), function1, Operation.ObjectParameter.a(1), composition);
        operations.f(endCompositionScope);
    }

    public final void o() {
        this.f24314a.n(Operation.EndCurrentGroup.f24342c);
    }

    public final void p() {
        this.f24314a.n(Operation.EndMovableContentPlacement.f24343c);
    }

    public final void q(RecomposeScopeImpl recomposeScopeImpl) {
        Operations operations = this.f24314a;
        Operation.EndResumingScope endResumingScope = Operation.EndResumingScope.f24344c;
        operations.o(endResumingScope);
        Operations.WriteScope.d(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), recomposeScopeImpl);
        operations.f(endResumingScope);
    }

    public final void r(Anchor anchor) {
        Operations operations = this.f24314a;
        Operation.EnsureGroupStarted ensureGroupStarted = Operation.EnsureGroupStarted.f24345c;
        operations.o(ensureGroupStarted);
        Operations.WriteScope.d(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), anchor);
        operations.f(ensureGroupStarted);
    }

    public final void s() {
        this.f24314a.n(Operation.EnsureRootGroupStarted.f24346c);
    }

    public final void t(ChangeList changeList, IntRef intRef) {
        if (changeList.f()) {
            Operations operations = this.f24314a;
            Operation.ApplyChangeList applyChangeList = Operation.ApplyChangeList.f24335c;
            operations.o(applyChangeList);
            Operations.WriteScope.e(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), changeList, Operation.ObjectParameter.a(1), intRef);
            operations.f(applyChangeList);
        }
    }

    public final void u(Anchor anchor, SlotTable slotTable) {
        Operations operations = this.f24314a;
        Operation.InsertSlots insertSlots = Operation.InsertSlots.f24348c;
        operations.o(insertSlots);
        Operations.WriteScope.e(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), anchor, Operation.ObjectParameter.a(1), slotTable);
        operations.f(insertSlots);
    }

    public final void v(Anchor anchor, SlotTable slotTable, FixupList fixupList) {
        Operations operations = this.f24314a;
        Operation.InsertSlotsWithFixups insertSlotsWithFixups = Operation.InsertSlotsWithFixups.f24349c;
        operations.o(insertSlotsWithFixups);
        Operations.WriteScope.g(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), anchor, Operation.ObjectParameter.a(1), slotTable, Operation.ObjectParameter.a(2), fixupList);
        operations.f(insertSlotsWithFixups);
    }

    public final void w(int i3) {
        Operations operations = this.f24314a;
        Operation.MoveCurrentGroup moveCurrentGroup = Operation.MoveCurrentGroup.f24350c;
        operations.o(moveCurrentGroup);
        Operations operationsA = Operations.WriteScope.a(operations);
        operationsA.f24374c[operationsA.f24375d - operationsA.f24372a[operationsA.f24373b - 1].b()] = i3;
        operations.f(moveCurrentGroup);
    }

    public final void x(int i3, int i4, int i5) {
        Operations operations = this.f24314a;
        Operation.MoveNode moveNode = Operation.MoveNode.f24351c;
        operations.o(moveNode);
        Operations operationsA = Operations.WriteScope.a(operations);
        int iB = operationsA.f24375d - operationsA.f24372a[operationsA.f24373b - 1].b();
        int[] iArr = operationsA.f24374c;
        iArr[iB + 1] = i3;
        iArr[iB] = i4;
        iArr[iB + 2] = i5;
        operations.f(moveNode);
    }

    public final void y(ControlledComposition controlledComposition, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference) {
        Operations operations = this.f24314a;
        Operation.ReleaseMovableGroupAtCurrent releaseMovableGroupAtCurrent = Operation.ReleaseMovableGroupAtCurrent.f24354c;
        operations.o(releaseMovableGroupAtCurrent);
        Operations.WriteScope.g(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), controlledComposition, Operation.ObjectParameter.a(1), compositionContext, Operation.ObjectParameter.a(2), movableContentStateReference);
        operations.f(releaseMovableGroupAtCurrent);
    }

    public final void z(RememberObserverHolder rememberObserverHolder) {
        Operations operations = this.f24314a;
        Operation.Remember remember = Operation.Remember.f24355c;
        operations.o(remember);
        Operations.WriteScope.d(Operations.WriteScope.a(operations), Operation.ObjectParameter.a(0), rememberObserverHolder);
        operations.f(remember);
    }
}
