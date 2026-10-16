package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

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
public final class LegacyAdaptingPlatformTextInputModifierNode extends Modifier.Node implements PlatformTextInputModifierNode, CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LegacyPlatformTextInputServiceAdapter f10363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LegacyTextFieldState f10364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextFieldSelectionManager f10365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f10366d = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    public LegacyAdaptingPlatformTextInputModifierNode(LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        this.f10363a = legacyPlatformTextInputServiceAdapter;
        this.f10364b = legacyTextFieldState;
        this.f10365c = textFieldSelectionManager;
    }

    private void m2(LayoutCoordinates layoutCoordinates) {
        this.f10366d.setValue(layoutCoordinates);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void I(LayoutCoordinates layoutCoordinates) {
        m2(layoutCoordinates);
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode
    public LegacyTextFieldState c2() {
        return this.f10364b;
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode
    public Job g1(Function2 function2) {
        if (isAttached()) {
            return BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, CoroutineStart.f140919d, new LegacyAdaptingPlatformTextInputModifierNode$launchTextInputSession$1(this, function2, null), 1, null);
        }
        return null;
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode
    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return (SoftwareKeyboardController) CompositionLocalConsumerModifierNodeKt.a(this, CompositionLocalsKt.q());
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode
    public ViewConfiguration getViewConfiguration() {
        return (ViewConfiguration) CompositionLocalConsumerModifierNodeKt.a(this, CompositionLocalsKt.t());
    }

    public void n2(LegacyTextFieldState legacyTextFieldState) {
        this.f10364b = legacyTextFieldState;
    }

    public final void o2(LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter) {
        if (isAttached()) {
            this.f10363a.b();
            this.f10363a.l(this);
        }
        this.f10363a = legacyPlatformTextInputServiceAdapter;
        if (isAttached()) {
            this.f10363a.j(this);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.f10363a.j(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.f10363a.l(this);
    }

    public void p2(TextFieldSelectionManager textFieldSelectionManager) {
        this.f10365c = textFieldSelectionManager;
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode
    public TextFieldSelectionManager t1() {
        return this.f10365c;
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode
    public LayoutCoordinates z() {
        return (LayoutCoordinates) this.f10366d.getValue();
    }
}
