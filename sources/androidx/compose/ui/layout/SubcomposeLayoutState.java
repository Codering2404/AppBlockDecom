package androidx.compose.ui.layout;

import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class SubcomposeLayoutState {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f27228f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SubcomposeSlotReusePolicy f27229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutNodeSubcompositionsState f27230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2 f27231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function2 f27232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function2 f27233e;

    public SubcomposeLayoutState(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.f27229a = subcomposeSlotReusePolicy;
        this.f27231c = new Function2<LayoutNode, SubcomposeLayoutState, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1
            {
                super(2);
            }

            public final void c(LayoutNode layoutNode, SubcomposeLayoutState subcomposeLayoutState) {
                SubcomposeLayoutState subcomposeLayoutState2 = this.f27236a;
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsStateD0 = layoutNode.D0();
                if (layoutNodeSubcompositionsStateD0 == null) {
                    layoutNodeSubcompositionsStateD0 = new LayoutNodeSubcompositionsState(layoutNode, this.f27236a.f27229a);
                    layoutNode.Z1(layoutNodeSubcompositionsStateD0);
                }
                subcomposeLayoutState2.f27230b = layoutNodeSubcompositionsStateD0;
                this.f27236a.h().B();
                this.f27236a.h().I(this.f27236a.f27229a);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((LayoutNode) obj, (SubcomposeLayoutState) obj2);
                return Unit.f139807a;
            }
        };
        this.f27232d = new Function2<LayoutNode, CompositionContext, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setCompositionContext$1
            {
                super(2);
            }

            public final void c(LayoutNode layoutNode, CompositionContext compositionContext) {
                this.f27234a.h().H(compositionContext);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((LayoutNode) obj, (CompositionContext) obj2);
                return Unit.f139807a;
            }
        };
        this.f27233e = new Function2<LayoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setMeasurePolicy$1
            {
                super(2);
            }

            public final void c(LayoutNode layoutNode, Function2 function2) {
                layoutNode.k(this.f27235a.h().u(function2));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((LayoutNode) obj, (Function2) obj2);
                return Unit.f139807a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutNodeSubcompositionsState h() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.f27230b;
        if (layoutNodeSubcompositionsState != null) {
            return layoutNodeSubcompositionsState;
        }
        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout");
    }

    public final void d() {
        h().z();
    }

    public final Function2 e() {
        return this.f27232d;
    }

    public final Function2 f() {
        return this.f27233e;
    }

    public final Function2 g() {
        return this.f27231c;
    }

    public final PrecomposedSlotHandle i(Object obj, Function2 function2) {
        return h().F(obj, function2);
    }

    public SubcomposeLayoutState() {
        this(NoOpSubcomposeSlotReusePolicy.f27180a);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface PrecomposedSlotHandle {
        default int d() {
            return 0;
        }

        void dispose();

        default void a(Object obj, Function1 function1) {
        }

        default void b(int i3, long j3) {
        }
    }
}
