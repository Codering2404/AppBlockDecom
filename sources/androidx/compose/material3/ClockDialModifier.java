package androidx.compose.material3;

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
public final class ClockDialModifier extends ModifierNodeElement<ClockDialNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnalogTimePickerState f16582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16584c;

    public /* synthetic */ ClockDialModifier(AnalogTimePickerState analogTimePickerState, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(analogTimePickerState, z2, i3);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ClockDialNode create() {
        return new ClockDialNode(this.f16582a, this.f16583b, this.f16584c, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(ClockDialNode clockDialNode) {
        clockDialNode.B2(this.f16582a, this.f16583b, this.f16584c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClockDialModifier)) {
            return false;
        }
        ClockDialModifier clockDialModifier = (ClockDialModifier) obj;
        return Intrinsics.areEqual(this.f16582a, clockDialModifier.f16582a) && this.f16583b == clockDialModifier.f16583b && TimePickerSelectionMode.f(this.f16584c, clockDialModifier.f16584c);
    }

    public int hashCode() {
        return (((this.f16582a.hashCode() * 31) + Boolean.hashCode(this.f16583b)) * 31) + TimePickerSelectionMode.g(this.f16584c);
    }

    public String toString() {
        return "ClockDialModifier(state=" + this.f16582a + ", autoSwitchToMinute=" + this.f16583b + ", selection=" + ((Object) TimePickerSelectionMode.h(this.f16584c)) + ')';
    }

    private ClockDialModifier(AnalogTimePickerState analogTimePickerState, boolean z2, int i3) {
        this.f16582a = analogTimePickerState;
        this.f16583b = z2;
        this.f16584c = i3;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
