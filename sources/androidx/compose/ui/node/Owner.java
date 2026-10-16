package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillManager;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
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
public interface Owner extends PositionCalculator {
    public static final Companion g8 = Companion.f27612a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f27612a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static boolean f27613b;

        private Companion() {
        }

        public final boolean a() {
            return f27613b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnLayoutCompletedListener {
        void j();
    }

    static /* synthetic */ void J(Owner owner, LayoutNode layoutNode, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestMeasure");
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        if ((i3 & 8) != 0) {
            z4 = true;
        }
        owner.z(layoutNode, z2, z3, z4);
    }

    static /* synthetic */ void c(Owner owner, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: measureAndLayout");
        }
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        owner.a(z2);
    }

    static /* synthetic */ void e(Owner owner, LayoutNode layoutNode, boolean z2, boolean z3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestRelayout");
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        owner.d(layoutNode, z2, z3);
    }

    static /* synthetic */ OwnedLayer n(Owner owner, Function2 function2, Function0 function0, GraphicsLayer graphicsLayer, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLayer");
        }
        if ((i3 & 4) != 0) {
            graphicsLayer = null;
        }
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        return owner.t(function2, function0, graphicsLayer, z2);
    }

    static /* synthetic */ void o(Owner owner, LayoutNode layoutNode, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forceMeasureTheSubtree");
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        owner.m(layoutNode, z2);
    }

    void B(LayoutNode layoutNode);

    void D(Function0 function0);

    void E();

    void F();

    void G(LayoutNode layoutNode);

    void a(boolean z2);

    void d(LayoutNode layoutNode, boolean z2, boolean z3);

    long f(long j3);

    void g(LayoutNode layoutNode);

    AccessibilityManager getAccessibilityManager();

    Autofill getAutofill();

    AutofillManager getAutofillManager();

    AutofillTree getAutofillTree();

    Clipboard getClipboard();

    ClipboardManager getClipboardManager();

    CoroutineContext getCoroutineContext();

    Density getDensity();

    DragAndDropManager getDragAndDropManager();

    FocusOwner getFocusOwner();

    FontFamily.Resolver getFontFamilyResolver();

    Font.ResourceLoader getFontLoader();

    GraphicsContext getGraphicsContext();

    HapticFeedback getHapticFeedBack();

    InputModeManager getInputModeManager();

    LayoutDirection getLayoutDirection();

    ModifierLocalManager getModifierLocalManager();

    default Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.b(this);
    }

    PointerIconService getPointerIconService();

    RectManager getRectManager();

    LayoutNode getRoot();

    SemanticsOwner getSemanticsOwner();

    LayoutNodeDrawScope getSharedDrawScope();

    boolean getShowLayoutBounds();

    OwnerSnapshotObserver getSnapshotObserver();

    SoftwareKeyboardController getSoftwareKeyboardController();

    TextInputService getTextInputService();

    TextToolbar getTextToolbar();

    ViewConfiguration getViewConfiguration();

    WindowInfo getWindowInfo();

    void k(LayoutNode layoutNode);

    void l(View view);

    void m(LayoutNode layoutNode, boolean z2);

    void p(LayoutNode layoutNode);

    void r(LayoutNode layoutNode);

    void s(OnLayoutCompletedListener onLayoutCompletedListener);

    void setShowLayoutBounds(boolean z2);

    OwnedLayer t(Function2 function2, Function0 function0, GraphicsLayer graphicsLayer, boolean z2);

    void u(LayoutNode layoutNode);

    Object v(Function2 function2, Continuation continuation);

    void w(LayoutNode layoutNode, long j3);

    long y(long j3);

    void z(LayoutNode layoutNode, boolean z2, boolean z3, boolean z4);

    default void A() {
    }

    default void I() {
    }

    default void h(LayoutNode layoutNode, int i3) {
    }

    default void i(LayoutNode layoutNode, int i3) {
    }
}
