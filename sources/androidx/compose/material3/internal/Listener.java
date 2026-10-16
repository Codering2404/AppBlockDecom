package androidx.compose.material3.internal;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager$AccessibilityServicesStateChangeListener;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

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
final class Listener implements AccessibilityManager.AccessibilityStateChangeListener, State<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f22076a = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Listener$touchExplorationListener$1 f22077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Listener$switchAccessListener$1 f22078c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api33Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api33Impl f22079a = new Api33Impl();

        private Api33Impl() {
        }

        @JvmStatic
        public static final void a(AccessibilityManager accessibilityManager, AccessibilityManager$AccessibilityServicesStateChangeListener accessibilityManager$AccessibilityServicesStateChangeListener) {
            accessibilityManager.addAccessibilityServicesStateChangeListener(accessibilityManager$AccessibilityServicesStateChangeListener);
        }

        @JvmStatic
        public static final void b(AccessibilityManager accessibilityManager, AccessibilityManager$AccessibilityServicesStateChangeListener accessibilityManager$AccessibilityServicesStateChangeListener) {
            accessibilityManager.removeAccessibilityServicesStateChangeListener(accessibilityManager$AccessibilityServicesStateChangeListener);
        }
    }

    public Listener(boolean z2, boolean z3) {
        Listener$switchAccessListener$1 listener$switchAccessListener$1 = null;
        this.f22077b = z2 ? new Listener$touchExplorationListener$1() : null;
        if (z3 && Build.VERSION.SDK_INT >= 33) {
            listener$switchAccessListener$1 = new Listener$switchAccessListener$1(this);
        }
        this.f22078c = listener$switchAccessListener$1;
    }

    private final boolean i() {
        return ((Boolean) this.f22076a.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(AccessibilityManager accessibilityManager) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16);
        int size = enabledAccessibilityServiceList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String settingsActivityName = enabledAccessibilityServiceList.get(i3).getSettingsActivityName();
            if (settingsActivityName != null && StringsKt.a0(settingsActivityName, "SwitchAccess", false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    private final void r(boolean z2) {
        this.f22076a.setValue(Boolean.valueOf(z2));
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z2) {
        r(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001f  */
    @Override // androidx.compose.runtime.State
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean getValue() {
        /*
            r2 = this;
            boolean r0 = r2.i()
            r1 = 0
            if (r0 == 0) goto L20
            androidx.compose.material3.internal.Listener$touchExplorationListener$1 r0 = r2.f22077b
            if (r0 == 0) goto L10
            boolean r0 = r0.a()
            goto L11
        L10:
            r0 = r1
        L11:
            if (r0 != 0) goto L1f
            androidx.compose.material3.internal.Listener$switchAccessListener$1 r0 = r2.f22078c
            if (r0 == 0) goto L1c
            boolean r0 = r0.a()
            goto L1d
        L1c:
            r0 = r1
        L1d:
            if (r0 == 0) goto L20
        L1f:
            r1 = 1
        L20:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.Listener.getValue():java.lang.Boolean");
    }

    public final void q(AccessibilityManager accessibilityManager) {
        Listener$switchAccessListener$1 listener$switchAccessListener$1;
        r(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(this);
        Listener$touchExplorationListener$1 listener$touchExplorationListener$1 = this.f22077b;
        if (listener$touchExplorationListener$1 != null) {
            listener$touchExplorationListener$1.b(accessibilityManager.isTouchExplorationEnabled());
            accessibilityManager.addTouchExplorationStateChangeListener(listener$touchExplorationListener$1);
        }
        if (Build.VERSION.SDK_INT < 33 || (listener$switchAccessListener$1 = this.f22078c) == null) {
            return;
        }
        listener$switchAccessListener$1.b(n(accessibilityManager));
        Api33Impl.a(accessibilityManager, b.a(listener$switchAccessListener$1));
    }

    public final void v(AccessibilityManager accessibilityManager) {
        Listener$switchAccessListener$1 listener$switchAccessListener$1;
        accessibilityManager.removeAccessibilityStateChangeListener(this);
        Listener$touchExplorationListener$1 listener$touchExplorationListener$1 = this.f22077b;
        if (listener$touchExplorationListener$1 != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(listener$touchExplorationListener$1);
        }
        if (Build.VERSION.SDK_INT < 33 || (listener$switchAccessListener$1 = this.f22078c) == null) {
            return;
        }
        Api33Impl.b(accessibilityManager, b.a(listener$switchAccessListener$1));
    }
}
