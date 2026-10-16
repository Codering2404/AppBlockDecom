package androidx.compose.material3.internal;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager$AccessibilityServicesStateChangeListener;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;

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
public final class Listener$switchAccessListener$1 implements AccessibilityManager$AccessibilityServicesStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f22080a = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Listener f22081b;

    Listener$switchAccessListener$1(Listener listener) {
        this.f22081b = listener;
    }

    public final boolean a() {
        return ((Boolean) this.f22080a.getValue()).booleanValue();
    }

    public final void b(boolean z2) {
        this.f22080a.setValue(Boolean.valueOf(z2));
    }

    public void onAccessibilityServicesStateChanged(AccessibilityManager accessibilityManager) {
        b(this.f22081b.n(accessibilityManager));
    }
}
