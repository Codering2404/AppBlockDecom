package androidx.compose.ui.draganddrop;

import android.view.DragEvent;
import android.view.View;
import androidx.collection.ArraySet;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

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
public final class AndroidDragAndDropManager implements View.OnDragListener, DragAndDropManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function3 f25331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DragAndDropNode f25332b = new DragAndDropNode(null, null, 3, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArraySet f25333c = new ArraySet(0, 1, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Modifier f25334d = new ModifierNodeElement<DragAndDropNode>() { // from class: androidx.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1
        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DragAndDropNode create() {
            return this.f25335a.f25332b;
        }

        public boolean equals(Object obj) {
            return obj == this;
        }

        public int hashCode() {
            return this.f25335a.f25332b.hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.d("RootDragAndDropNode");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void update(DragAndDropNode dragAndDropNode) {
        }
    };

    public AndroidDragAndDropManager(Function3 function3) {
        this.f25331a = function3;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropManager
    public void A(DragAndDropTarget dragAndDropTarget) {
        this.f25333c.add(dragAndDropTarget);
    }

    public Modifier c() {
        return this.f25334d;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        DragAndDropEvent dragAndDropEvent = new DragAndDropEvent(dragEvent);
        switch (dragEvent.getAction()) {
            case 1:
                boolean zM2 = this.f25332b.m2(dragAndDropEvent);
                Iterator<E> it = this.f25333c.iterator();
                while (it.hasNext()) {
                    ((DragAndDropTarget) it.next()).S(dragAndDropEvent);
                }
                break;
            case 2:
                this.f25332b.T(dragAndDropEvent);
                break;
            case 4:
                this.f25332b.j2(dragAndDropEvent);
                this.f25333c.clear();
                break;
            case 5:
                this.f25332b.x0(dragAndDropEvent);
                break;
            case 6:
                this.f25332b.d0(dragAndDropEvent);
                break;
        }
        return false;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropManager
    public boolean x() {
        return true;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropManager
    public void y(DragAndDropNode dragAndDropNode, long j3) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        dragAndDropNode.v2(new DragAndDropStartTransferScope() { // from class: androidx.compose.ui.draganddrop.AndroidDragAndDropManager$requestDragAndDropTransfer$dragAndDropSourceScope$1
            @Override // androidx.compose.ui.draganddrop.DragAndDropStartTransferScope
            public boolean a(DragAndDropTransferData dragAndDropTransferData, long j4, Function1 function1) {
                booleanRef.f140137a = ((Boolean) this.f25331a.invoke(dragAndDropTransferData, Size.c(j4), function1)).booleanValue();
                return booleanRef.f140137a;
            }
        }, j3, new Function0<Boolean>() { // from class: androidx.compose.ui.draganddrop.AndroidDragAndDropManager$requestDragAndDropTransfer$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(booleanRef.f140137a);
            }
        });
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropManager
    public boolean z(DragAndDropTarget dragAndDropTarget) {
        return this.f25333c.contains(dragAndDropTarget);
    }
}
