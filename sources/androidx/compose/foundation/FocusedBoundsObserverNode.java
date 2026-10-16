package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class FocusedBoundsObserverNode extends Modifier.Node implements TraversableNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TraverseKey f4942c = new TraverseKey(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4943d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function1 f4944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f4945b = f4942c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TraverseKey {
        public /* synthetic */ TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TraverseKey() {
        }
    }

    public FocusedBoundsObserverNode(Function1 function1) {
        this.f4944a = function1;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object U() {
        return this.f4945b;
    }

    public final void m2(LayoutCoordinates layoutCoordinates) {
        this.f4944a.invoke(layoutCoordinates);
        FocusedBoundsObserverNode focusedBoundsObserverNode = (FocusedBoundsObserverNode) TraversableNodeKt.b(this);
        if (focusedBoundsObserverNode != null) {
            focusedBoundsObserverNode.m2(layoutCoordinates);
        }
    }

    public final void n2(Function1 function1) {
        this.f4944a = function1;
    }
}
