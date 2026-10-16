package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
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
public final class TabIndicatorModifier extends ModifierNodeElement<TabIndicatorOffsetNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final State f20473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f20475c;

    public TabIndicatorModifier(State state, int i3, boolean z2) {
        this.f20473a = state;
        this.f20474b = i3;
        this.f20475c = z2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TabIndicatorOffsetNode create() {
        return new TabIndicatorOffsetNode(this.f20473a, this.f20474b, this.f20475c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(TabIndicatorOffsetNode tabIndicatorOffsetNode) {
        tabIndicatorOffsetNode.o2(this.f20473a);
        tabIndicatorOffsetNode.n2(this.f20474b);
        tabIndicatorOffsetNode.m2(this.f20475c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabIndicatorModifier)) {
            return false;
        }
        TabIndicatorModifier tabIndicatorModifier = (TabIndicatorModifier) obj;
        return Intrinsics.areEqual(this.f20473a, tabIndicatorModifier.f20473a) && this.f20474b == tabIndicatorModifier.f20474b && this.f20475c == tabIndicatorModifier.f20475c;
    }

    public int hashCode() {
        return (((this.f20473a.hashCode() * 31) + Integer.hashCode(this.f20474b)) * 31) + Boolean.hashCode(this.f20475c);
    }

    public String toString() {
        return "TabIndicatorModifier(tabPositionsState=" + this.f20473a + ", selectedTabIndex=" + this.f20474b + ", followContentSize=" + this.f20475c + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
