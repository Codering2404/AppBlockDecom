package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ParentSizeElement extends ModifierNodeElement<ParentSizeNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f7624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final State f7625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final State f7626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f7627d;

    public /* synthetic */ ParentSizeElement(float f3, State state, State state2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, (i3 & 2) != 0 ? null : state, (i3 & 4) != 0 ? null : state2, str);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ParentSizeNode create() {
        return new ParentSizeNode(this.f7624a, this.f7625b, this.f7626c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(ParentSizeNode parentSizeNode) {
        parentSizeNode.m2(this.f7624a);
        parentSizeNode.o2(this.f7625b);
        parentSizeNode.n2(this.f7626c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParentSizeElement)) {
            return false;
        }
        ParentSizeElement parentSizeElement = (ParentSizeElement) obj;
        return this.f7624a == parentSizeElement.f7624a && Intrinsics.areEqual(this.f7625b, parentSizeElement.f7625b) && Intrinsics.areEqual(this.f7626c, parentSizeElement.f7626c);
    }

    public int hashCode() {
        State state = this.f7625b;
        int iHashCode = (state != null ? state.hashCode() : 0) * 31;
        State state2 = this.f7626c;
        return ((iHashCode + (state2 != null ? state2.hashCode() : 0)) * 31) + Float.hashCode(this.f7624a);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d(this.f7627d);
        inspectorInfo.e(Float.valueOf(this.f7624a));
    }

    public ParentSizeElement(float f3, State state, State state2, String str) {
        this.f7624a = f3;
        this.f7625b = state;
        this.f7626c = state2;
        this.f7627d = str;
    }
}
