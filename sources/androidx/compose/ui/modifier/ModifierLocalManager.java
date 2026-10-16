package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

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
public final class ModifierLocalManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Owner f27249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableVector f27250b = new MutableVector(new BackwardsCompatNode[16], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableVector f27251c = new MutableVector(new ModifierLocal[16], 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableVector f27252d = new MutableVector(new LayoutNode[16], 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableVector f27253e = new MutableVector(new ModifierLocal[16], 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f27254f;

    public ModifierLocalManager(Owner owner) {
        this.f27249a = owner;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v9 */
    private final void c(Modifier.Node node, ModifierLocal modifierLocal, Set set) {
        int iA = NodeKind.a(32);
        if (!node.getNode().isAttached()) {
            InlineClassHelperKt.c("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = node.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.c(mutableVector, node.getNode(), false);
        } else {
            mutableVector.b(child$ui_release);
        }
        while (mutableVector.o() != 0) {
            Modifier.Node node2 = (Modifier.Node) mutableVector.u(mutableVector.o() - 1);
            if ((node2.getAggregateChildKindSet$ui_release() & iA) != 0) {
                for (Modifier.Node child$ui_release2 = node2; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild$ui_release()) {
                    if ((child$ui_release2.getKindSet$ui_release() & iA) != 0) {
                        ?? H = child$ui_release2;
                        ?? mutableVector2 = 0;
                        while (H != 0) {
                            if (H instanceof ModifierLocalModifierNode) {
                                ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) H;
                                if (modifierLocalModifierNode instanceof BackwardsCompatNode) {
                                    BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) modifierLocalModifierNode;
                                    if ((backwardsCompatNode.n2() instanceof ModifierLocalConsumer) && backwardsCompatNode.o2().contains(modifierLocal)) {
                                        set.add(modifierLocalModifierNode);
                                    }
                                }
                                if (modifierLocalModifierNode.n0().a(modifierLocal)) {
                                    break;
                                }
                            } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                int i3 = 0;
                                H = H;
                                mutableVector2 = mutableVector2;
                                while (nodeN2 != null) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i3++;
                                        mutableVector2 = mutableVector2;
                                        if (i3 == 1) {
                                            H = nodeN2;
                                        } else {
                                            if (mutableVector2 == 0) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (H != 0) {
                                                mutableVector2.b(H);
                                                H = 0;
                                            }
                                            mutableVector2.b(nodeN2);
                                        }
                                    }
                                    nodeN2 = nodeN2.getChild$ui_release();
                                    H = H;
                                    mutableVector2 = mutableVector2;
                                }
                                if (i3 == 1) {
                                }
                            }
                            H = DelegatableNodeKt.h(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.c(mutableVector, node2, false);
        }
    }

    public final void a(BackwardsCompatNode backwardsCompatNode, ModifierLocal modifierLocal) {
        this.f27250b.b(backwardsCompatNode);
        this.f27251c.b(modifierLocal);
        b();
    }

    public final void b() {
        if (this.f27254f) {
            return;
        }
        this.f27254f = true;
        this.f27249a.D(new Function0<Unit>() { // from class: androidx.compose.ui.modifier.ModifierLocalManager$invalidate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m225invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m225invoke() {
                this.f27255a.e();
            }
        });
    }

    public final void d(BackwardsCompatNode backwardsCompatNode, ModifierLocal modifierLocal) {
        this.f27252d.b(DelegatableNodeKt.o(backwardsCompatNode));
        this.f27253e.b(modifierLocal);
        b();
    }

    public final void e() {
        this.f27254f = false;
        HashSet hashSet = new HashSet();
        MutableVector mutableVector = this.f27252d;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            ModifierLocal modifierLocal = (ModifierLocal) this.f27253e.f24389a[i3];
            if (layoutNode.u0().k().isAttached()) {
                c(layoutNode.u0().k(), modifierLocal, hashSet);
            }
        }
        this.f27252d.i();
        this.f27253e.i();
        MutableVector mutableVector2 = this.f27250b;
        Object[] objArr2 = mutableVector2.f24389a;
        int iO2 = mutableVector2.o();
        for (int i4 = 0; i4 < iO2; i4++) {
            BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) objArr2[i4];
            ModifierLocal modifierLocal2 = (ModifierLocal) this.f27251c.f24389a[i4];
            if (backwardsCompatNode.isAttached()) {
                c(backwardsCompatNode, modifierLocal2, hashSet);
            }
        }
        this.f27250b.i();
        this.f27251c.i();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((BackwardsCompatNode) it.next()).u2();
        }
    }

    public final void f(BackwardsCompatNode backwardsCompatNode, ModifierLocal modifierLocal) {
        this.f27250b.b(backwardsCompatNode);
        this.f27251c.b(modifierLocal);
        b();
    }
}
