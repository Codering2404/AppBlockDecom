package androidx.compose.material3.pulltorefresh;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class PullToRefreshElement extends ModifierNodeElement<PullToRefreshModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f22219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f22220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f22221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PullToRefreshState f22222d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f22223f;

    public /* synthetic */ PullToRefreshElement(boolean z2, Function0 function0, boolean z3, PullToRefreshState pullToRefreshState, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, function0, z3, pullToRefreshState, f3);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PullToRefreshModifierNode create() {
        return new PullToRefreshModifierNode(this.f22219a, this.f22220b, this.f22221c, this.f22222d, this.f22223f, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(PullToRefreshModifierNode pullToRefreshModifierNode) {
        pullToRefreshModifierNode.L2(this.f22220b);
        pullToRefreshModifierNode.K2(this.f22221c);
        pullToRefreshModifierNode.N2(this.f22222d);
        pullToRefreshModifierNode.O2(this.f22223f);
        boolean zH2 = pullToRefreshModifierNode.H2();
        boolean z2 = this.f22219a;
        if (zH2 != z2) {
            pullToRefreshModifierNode.M2(z2);
            pullToRefreshModifierNode.update();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PullToRefreshElement)) {
            return false;
        }
        PullToRefreshElement pullToRefreshElement = (PullToRefreshElement) obj;
        return this.f22219a == pullToRefreshElement.f22219a && Intrinsics.areEqual(this.f22220b, pullToRefreshElement.f22220b) && this.f22221c == pullToRefreshElement.f22221c && Intrinsics.areEqual(this.f22222d, pullToRefreshElement.f22222d) && Dp.i(this.f22223f, pullToRefreshElement.f22223f);
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.f22219a) * 31) + this.f22220b.hashCode()) * 31) + Boolean.hashCode(this.f22221c)) * 31) + this.f22222d.hashCode()) * 31) + Dp.j(this.f22223f);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("PullToRefreshModifierNode");
        inspectorInfo.b().c("isRefreshing", Boolean.valueOf(this.f22219a));
        inspectorInfo.b().c("onRefresh", this.f22220b);
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f22221c));
        inspectorInfo.b().c(ServerProtocol.DIALOG_PARAM_STATE, this.f22222d);
        inspectorInfo.b().c("threshold", Dp.d(this.f22223f));
    }

    public String toString() {
        return "PullToRefreshElement(isRefreshing=" + this.f22219a + ", onRefresh=" + this.f22220b + ", enabled=" + this.f22221c + ", state=" + this.f22222d + ", threshold=" + ((Object) Dp.k(this.f22223f)) + ')';
    }

    private PullToRefreshElement(boolean z2, Function0 function0, boolean z3, PullToRefreshState pullToRefreshState, float f3) {
        this.f22219a = z2;
        this.f22220b = function0;
        this.f22221c = z3;
        this.f22222d = pullToRefreshState;
        this.f22223f = f3;
    }
}
