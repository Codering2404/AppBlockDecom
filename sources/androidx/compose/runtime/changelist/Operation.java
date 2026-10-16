package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.OffsetApplier;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RecomposeScopeOwner;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.Utils_jvmKt;
import com.facebook.share.HKJ.pnxuebdT;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

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
public abstract class Operation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24332b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AdvanceSlotsBy extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final AdvanceSlotsBy f24333c = new AdvanceSlotsBy();

        private AdvanceSlotsBy() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.C(operationArgContainer.getInt(0));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String e(int i3) {
            return i3 == 0 ? "distance" : super.e(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppendValue extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final AppendValue f24334c = new AppendValue();

        private AppendValue() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Anchor anchor = (Anchor) operationArgContainer.a(ObjectParameter.a(0));
            Object objA = operationArgContainer.a(ObjectParameter.a(1));
            if (objA instanceof RememberObserverHolder) {
                rememberManager.g((RememberObserverHolder) objA);
            }
            slotWriter.F(anchor, objA);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "anchor" : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "value" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ApplyChangeList extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final ApplyChangeList f24335c = new ApplyChangeList();

        private ApplyChangeList() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            IntRef intRef = (IntRef) operationArgContainer.a(ObjectParameter.a(1));
            int iA = intRef != null ? intRef.a() : 0;
            ChangeList changeList = (ChangeList) operationArgContainer.a(ObjectParameter.a(0));
            if (iA > 0) {
                applier = new OffsetApplier(applier, iA);
            }
            changeList.c(applier, slotWriter, rememberManager);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "changes" : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "effectiveNodeIndex" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CopyNodesToNewAnchorLocation extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final CopyNodesToNewAnchorLocation f24336c = new CopyNodesToNewAnchorLocation();

        private CopyNodesToNewAnchorLocation() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            int iA = ((IntRef) operationArgContainer.a(ObjectParameter.a(0))).a();
            List list = (List) operationArgContainer.a(ObjectParameter.a(1));
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = list.get(i3);
                Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
                int i4 = iA + i3;
                applier.g(i4, obj);
                applier.e(i4, obj);
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "effectiveNodeIndex" : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "nodes" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CopySlotTableToAnchorLocation extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final CopySlotTableToAnchorLocation f24337c = new CopySlotTableToAnchorLocation();

        private CopySlotTableToAnchorLocation() {
            super(0, 4, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            MovableContentStateReference movableContentStateReference = (MovableContentStateReference) operationArgContainer.a(ObjectParameter.a(2));
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) operationArgContainer.a(ObjectParameter.a(3));
            CompositionContext compositionContext = (CompositionContext) operationArgContainer.a(ObjectParameter.a(1));
            MovableContentState movableContentStateO = (MovableContentState) operationArgContainer.a(ObjectParameter.a(0));
            if (movableContentStateO == null && (movableContentStateO = compositionContext.o(movableContentStateReference)) == null) {
                ComposerKt.u("Could not resolve state for movable content");
                throw new KotlinNothingValueException();
            }
            List listB0 = slotWriter.B0(1, movableContentStateO.d(), 2);
            RecomposeScopeImpl.Companion companion = RecomposeScopeImpl.f24021i;
            ControlledComposition controlledCompositionB = movableContentStateReference2.b();
            Intrinsics.checkNotNull(controlledCompositionB, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeOwner");
            companion.a(slotWriter, listB0, (RecomposeScopeOwner) controlledCompositionB);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "resolvedState" : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "resolvedCompositionContext" : ObjectParameter.c(i3, ObjectParameter.a(2)) ? "from" : ObjectParameter.c(i3, ObjectParameter.a(3)) ? "to" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeactivateCurrentGroup extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final DeactivateCurrentGroup f24338c = new DeactivateCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private DeactivateCurrentGroup() {
            int i3 = 0;
            super(i3, i3, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            ComposerKt.v(slotWriter, rememberManager);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DetermineMovableContentNodeIndex extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final DetermineMovableContentNodeIndex f24339c = new DetermineMovableContentNodeIndex();

        private DetermineMovableContentNodeIndex() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            IntRef intRef = (IntRef) operationArgContainer.a(ObjectParameter.a(0));
            Anchor anchor = (Anchor) operationArgContainer.a(ObjectParameter.a(1));
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            intRef.b(OperationKt.d(slotWriter, anchor, applier));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "effectiveNodeIndexOut" : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "anchor" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Downs extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Downs f24340c = new Downs();

        /* JADX WARN: Illegal instructions before constructor call */
        private Downs() {
            int i3 = 1;
            super(0, i3, i3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            for (Object obj : (Object[]) operationArgContainer.a(ObjectParameter.a(0))) {
                applier.h(obj);
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "nodes" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EndCompositionScope extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EndCompositionScope f24341c = new EndCompositionScope();

        private EndCompositionScope() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            ((Function1) operationArgContainer.a(ObjectParameter.a(0))).invoke((Composition) operationArgContainer.a(ObjectParameter.a(1)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "anchor" : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "composition" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EndCurrentGroup extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EndCurrentGroup f24342c = new EndCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private EndCurrentGroup() {
            int i3 = 0;
            super(i3, i3, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.T();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EndMovableContentPlacement extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EndMovableContentPlacement f24343c = new EndMovableContentPlacement();

        /* JADX WARN: Illegal instructions before constructor call */
        private EndMovableContentPlacement() {
            int i3 = 0;
            super(i3, i3, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            OperationKt.e(slotWriter, applier, 0);
            slotWriter.T();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EndResumingScope extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EndResumingScope f24344c = new EndResumingScope();

        /* JADX WARN: Illegal instructions before constructor call */
        private EndResumingScope() {
            int i3 = 1;
            super(0, i3, i3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            rememberManager.d((RecomposeScopeImpl) operationArgContainer.a(ObjectParameter.a(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "scope" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EnsureGroupStarted extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnsureGroupStarted f24345c = new EnsureGroupStarted();

        /* JADX WARN: Illegal instructions before constructor call */
        private EnsureGroupStarted() {
            int i3 = 1;
            super(0, i3, i3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.W((Anchor) operationArgContainer.a(ObjectParameter.a(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "anchor" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EnsureRootGroupStarted extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnsureRootGroupStarted f24346c = new EnsureRootGroupStarted();

        /* JADX WARN: Illegal instructions before constructor call */
        private EnsureRootGroupStarted() {
            int i3 = 0;
            super(i3, i3, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.V(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InsertNodeFixup extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final InsertNodeFixup f24347c = new InsertNodeFixup();

        private InsertNodeFixup() {
            super(1, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Object objInvoke = ((Function0) operationArgContainer.a(ObjectParameter.a(0))).invoke();
            Anchor anchor = (Anchor) operationArgContainer.a(ObjectParameter.a(1));
            int i3 = operationArgContainer.getInt(0);
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            slotWriter.v1(anchor, objInvoke);
            applier.e(i3, objInvoke);
            applier.h(objInvoke);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String e(int i3) {
            return i3 == 0 ? "insertIndex" : super.e(i3);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "factory" : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "groupAnchor" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InsertSlots extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final InsertSlots f24348c = new InsertSlots();

        private InsertSlots() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            SlotTable slotTable = (SlotTable) operationArgContainer.a(ObjectParameter.a(1));
            Anchor anchor = (Anchor) operationArgContainer.a(ObjectParameter.a(0));
            slotWriter.H();
            slotWriter.y0(slotTable, anchor.d(slotTable), false);
            slotWriter.U();
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "anchor" : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "from" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InsertSlotsWithFixups extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final InsertSlotsWithFixups f24349c = new InsertSlotsWithFixups();

        private InsertSlotsWithFixups() {
            super(0, 3, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            SlotTable slotTable = (SlotTable) operationArgContainer.a(ObjectParameter.a(1));
            Anchor anchor = (Anchor) operationArgContainer.a(ObjectParameter.a(0));
            FixupList fixupList = (FixupList) operationArgContainer.a(ObjectParameter.a(2));
            SlotWriter slotWriterC = slotTable.C();
            try {
                fixupList.e(applier, slotWriterC, rememberManager);
                Unit unit = Unit.f139807a;
                slotWriterC.L(true);
                slotWriter.H();
                slotWriter.y0(slotTable, anchor.d(slotTable), false);
                slotWriter.U();
            } catch (Throwable th) {
                slotWriterC.L(false);
                throw th;
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "anchor" : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "from" : ObjectParameter.c(i3, ObjectParameter.a(2)) ? "fixups" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MoveCurrentGroup extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final MoveCurrentGroup f24350c = new MoveCurrentGroup();

        private MoveCurrentGroup() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.z0(operationArgContainer.getInt(0));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String e(int i3) {
            return i3 == 0 ? "offset" : super.e(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MoveNode extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final MoveNode f24351c = new MoveNode();

        private MoveNode() {
            super(3, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            applier.c(operationArgContainer.getInt(0), operationArgContainer.getInt(1), operationArgContainer.getInt(2));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String e(int i3) {
            return i3 == 0 ? "from" : i3 == 1 ? "to" : i3 == 2 ? "count" : super.e(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PostInsertNodeFixup extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final PostInsertNodeFixup f24353c = new PostInsertNodeFixup();

        /* JADX WARN: Illegal instructions before constructor call */
        private PostInsertNodeFixup() {
            int i3 = 1;
            super(i3, i3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Anchor anchor = (Anchor) operationArgContainer.a(ObjectParameter.a(0));
            int i3 = operationArgContainer.getInt(0);
            applier.k();
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            applier.g(i3, slotWriter.F0(anchor));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String e(int i3) {
            return i3 == 0 ? "insertIndex" : super.e(i3);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "groupAnchor" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ReleaseMovableGroupAtCurrent extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final ReleaseMovableGroupAtCurrent f24354c = new ReleaseMovableGroupAtCurrent();

        private ReleaseMovableGroupAtCurrent() {
            super(0, 3, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            ControlledComposition controlledComposition = (ControlledComposition) operationArgContainer.a(ObjectParameter.a(0));
            MovableContentStateReference movableContentStateReference = (MovableContentStateReference) operationArgContainer.a(ObjectParameter.a(2));
            ((CompositionContext) operationArgContainer.a(ObjectParameter.a(1))).n(movableContentStateReference, ComposerKt.x(controlledComposition, movableContentStateReference, slotWriter, null), applier);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "composition" : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "parentCompositionContext" : ObjectParameter.c(i3, ObjectParameter.a(2)) ? "reference" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Remember extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Remember f24355c = new Remember();

        /* JADX WARN: Illegal instructions before constructor call */
        private Remember() {
            int i3 = 1;
            super(0, i3, i3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            rememberManager.g((RememberObserverHolder) operationArgContainer.a(ObjectParameter.a(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "value" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RememberPausingScope extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final RememberPausingScope f24356c = new RememberPausingScope();

        /* JADX WARN: Illegal instructions before constructor call */
        private RememberPausingScope() {
            int i3 = 1;
            super(0, i3, i3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            rememberManager.c((RecomposeScopeImpl) operationArgContainer.a(ObjectParameter.a(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "scope" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RemoveCurrentGroup extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final RemoveCurrentGroup f24357c = new RemoveCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private RemoveCurrentGroup() {
            int i3 = 0;
            super(i3, i3, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            ComposerKt.P(slotWriter, rememberManager);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RemoveNode extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final RemoveNode f24358c = new RemoveNode();

        /* JADX WARN: Illegal instructions before constructor call */
        private RemoveNode() {
            int i3 = 2;
            super(i3, 0, i3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            applier.a(operationArgContainer.getInt(0), operationArgContainer.getInt(1));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String e(int i3) {
            return i3 == 0 ? "removeIndex" : i3 == 1 ? "count" : super.e(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ResetSlots extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final ResetSlots f24359c = new ResetSlots();

        /* JADX WARN: Illegal instructions before constructor call */
        private ResetSlots() {
            int i3 = 0;
            super(i3, i3, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.S0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SideEffect extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final SideEffect f24360c = new SideEffect();

        /* JADX WARN: Illegal instructions before constructor call */
        private SideEffect() {
            int i3 = 1;
            super(0, i3, i3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            rememberManager.a((Function0) operationArgContainer.a(ObjectParameter.a(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "effect" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SkipToEndOfCurrentGroup extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final SkipToEndOfCurrentGroup f24361c = new SkipToEndOfCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private SkipToEndOfCurrentGroup() {
            int i3 = 0;
            super(i3, i3, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.Z0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StartResumingScope extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final StartResumingScope f24362c = new StartResumingScope();

        /* JADX WARN: Illegal instructions before constructor call */
        private StartResumingScope() {
            int i3 = 1;
            super(0, i3, i3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            rememberManager.f((RecomposeScopeImpl) operationArgContainer.a(ObjectParameter.a(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "scope" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TrimParentValues extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final TrimParentValues f24365c = new TrimParentValues();

        private TrimParentValues() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            int iE;
            int iG0;
            int i3 = operationArgContainer.getInt(0);
            int iG02 = slotWriter.g0();
            int iE0 = slotWriter.e0();
            int iG1 = slotWriter.g1(iE0);
            int iF1 = slotWriter.f1(iE0);
            for (int iMax = Math.max(iG1, iF1 - i3); iMax < iF1; iMax++) {
                Object obj = slotWriter.f24201c[slotWriter.R(iMax)];
                if (obj instanceof RememberObserverHolder) {
                    int i4 = iG02 - iMax;
                    RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                    Anchor anchorA = rememberObserverHolder.a();
                    if (anchorA == null || !anchorA.b()) {
                        iE = -1;
                        iG0 = -1;
                    } else {
                        iE = slotWriter.E(anchorA);
                        iG0 = slotWriter.g0() - slotWriter.e1(iE);
                    }
                    rememberManager.e(rememberObserverHolder, i4, iE, iG0);
                } else if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).A();
                }
            }
            slotWriter.n1(i3);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String e(int i3) {
            return i3 == 0 ? "count" : super.e(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UpdateAnchoredValue extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final UpdateAnchoredValue f24366c = new UpdateAnchoredValue();

        private UpdateAnchoredValue() {
            super(1, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            int iE;
            int iG0;
            Object objA = operationArgContainer.a(ObjectParameter.a(0));
            Anchor anchor = (Anchor) operationArgContainer.a(ObjectParameter.a(1));
            int i3 = operationArgContainer.getInt(0);
            if (objA instanceof RememberObserverHolder) {
                rememberManager.g((RememberObserverHolder) objA);
            }
            int iE2 = slotWriter.E(anchor);
            Object objV0 = slotWriter.V0(iE2, i3, objA);
            if (!(objV0 instanceof RememberObserverHolder)) {
                if (objV0 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) objV0).A();
                    return;
                }
                return;
            }
            int iG02 = slotWriter.g0() - slotWriter.d1(iE2, i3);
            RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) objV0;
            Anchor anchorA = rememberObserverHolder.a();
            if (anchorA == null || !anchorA.b()) {
                iE = -1;
                iG0 = -1;
            } else {
                iE = slotWriter.E(anchorA);
                iG0 = slotWriter.g0() - slotWriter.e1(iE);
            }
            rememberManager.e(rememberObserverHolder, iG02, iE, iG0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String e(int i3) {
            return i3 == 0 ? "groupSlotIndex" : super.e(i3);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "value" : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "anchor" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UpdateAuxData extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final UpdateAuxData f24367c = new UpdateAuxData();

        /* JADX WARN: Illegal instructions before constructor call */
        private UpdateAuxData() {
            int i3 = 1;
            super(0, i3, i3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.r1(operationArgContainer.a(ObjectParameter.a(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "data" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class UpdateNode extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final UpdateNode f24368c = new UpdateNode();

        private UpdateNode() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            applier.d((Function2) operationArgContainer.a(ObjectParameter.a(1)), operationArgContainer.a(ObjectParameter.a(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? pnxuebdT.CtqFqOAOFftG : ObjectParameter.c(i3, ObjectParameter.a(1)) ? "block" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UpdateValue extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final UpdateValue f24369c = new UpdateValue();

        /* JADX WARN: Illegal instructions before constructor call */
        private UpdateValue() {
            int i3 = 1;
            super(i3, i3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Object objA = operationArgContainer.a(ObjectParameter.a(0));
            int i3 = operationArgContainer.getInt(0);
            if (objA instanceof RememberObserverHolder) {
                rememberManager.g((RememberObserverHolder) objA);
            }
            Object objV0 = slotWriter.V0(slotWriter.c0(), i3, objA);
            if (objV0 instanceof RememberObserverHolder) {
                rememberManager.e((RememberObserverHolder) objV0, slotWriter.g0() - slotWriter.d1(slotWriter.c0(), i3), -1, -1);
            } else if (objV0 instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) objV0).A();
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String e(int i3) {
            return i3 == 0 ? "groupSlotIndex" : super.e(i3);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String f(int i3) {
            return ObjectParameter.c(i3, ObjectParameter.a(0)) ? "value" : super.f(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Ups extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Ups f24370c = new Ups();

        private Ups() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            int i3 = operationArgContainer.getInt(0);
            for (int i4 = 0; i4 < i3; i4++) {
                applier.k();
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String e(int i3) {
            return i3 == 0 ? "count" : super.e(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UseCurrentNode extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final UseCurrentNode f24371c = new UseCurrentNode();

        /* JADX WARN: Illegal instructions before constructor call */
        private UseCurrentNode() {
            int i3 = 0;
            super(i3, i3, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            applier.i();
        }
    }

    public /* synthetic */ Operation(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4);
    }

    public abstract void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager);

    public final int b() {
        return this.f24331a;
    }

    public final String c() {
        String strM = Reflection.b(getClass()).m();
        return strM == null ? "" : strM;
    }

    public final int d() {
        return this.f24332b;
    }

    public String e(int i3) {
        return "IntParameter(" + i3 + ')';
    }

    public String f(int i3) {
        return "ObjectParameter(" + i3 + ')';
    }

    public String toString() {
        return c();
    }

    private Operation(int i3, int i4) {
        this.f24331a = i3;
        this.f24332b = i4;
    }

    public /* synthetic */ Operation(int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i3, (i5 & 2) != 0 ? 0 : i4, null);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class ObjectParameter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f24352a;

        public static boolean b(int i3, Object obj) {
            return (obj instanceof ObjectParameter) && i3 == ((ObjectParameter) obj).f();
        }

        public static final boolean c(int i3, int i4) {
            return i3 == i4;
        }

        public static int d(int i3) {
            return Integer.hashCode(i3);
        }

        public static String e(int i3) {
            return "ObjectParameter(offset=" + i3 + ')';
        }

        public boolean equals(Object obj) {
            return b(this.f24352a, obj);
        }

        public final /* synthetic */ int f() {
            return this.f24352a;
        }

        public int hashCode() {
            return d(this.f24352a);
        }

        public String toString() {
            return e(this.f24352a);
        }

        public static int a(int i3) {
            return i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TestOperation extends Operation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Function3 f24363c;

        @Override // androidx.compose.runtime.changelist.Operation
        public void a(OperationArgContainer operationArgContainer, Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            this.f24363c.invoke(applier, slotWriter, rememberManager);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String toString() {
            return "TestOperation(ints = " + b() + ", objects = " + d() + ")@" + Utils_jvmKt.a(this);
        }

        /* JADX INFO: renamed from: androidx.compose.runtime.changelist.Operation$TestOperation$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        final class AnonymousClass1 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final AnonymousClass1 f24364a = new AnonymousClass1();

            AnonymousClass1() {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                c((Applier) obj, (SlotWriter) obj2, (RememberManager) obj3);
                return Unit.f139807a;
            }

            public final void c(Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            }
        }
    }
}
