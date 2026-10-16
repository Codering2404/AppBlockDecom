package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.input.PlatformTextInputService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;

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
public abstract class LegacyPlatformTextInputServiceAdapter implements PlatformTextInputService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LegacyPlatformTextInputNode f10387a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface LegacyPlatformTextInputNode {
        LegacyTextFieldState c2();

        Job g1(Function2 function2);

        SoftwareKeyboardController getSoftwareKeyboardController();

        ViewConfiguration getViewConfiguration();

        TextFieldSelectionManager t1();

        LayoutCoordinates z();
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void c() {
        SoftwareKeyboardController softwareKeyboardController;
        LegacyPlatformTextInputNode legacyPlatformTextInputNode = this.f10387a;
        if (legacyPlatformTextInputNode == null || (softwareKeyboardController = legacyPlatformTextInputNode.getSoftwareKeyboardController()) == null) {
            return;
        }
        softwareKeyboardController.a();
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void e() {
        SoftwareKeyboardController softwareKeyboardController;
        LegacyPlatformTextInputNode legacyPlatformTextInputNode = this.f10387a;
        if (legacyPlatformTextInputNode == null || (softwareKeyboardController = legacyPlatformTextInputNode.getSoftwareKeyboardController()) == null) {
            return;
        }
        softwareKeyboardController.show();
    }

    protected final LegacyPlatformTextInputNode i() {
        return this.f10387a;
    }

    public final void j(LegacyPlatformTextInputNode legacyPlatformTextInputNode) {
        if (!(this.f10387a == null)) {
            InlineClassHelperKt.c("Expected textInputModifierNode to be null");
        }
        this.f10387a = legacyPlatformTextInputNode;
    }

    public abstract void k();

    public final void l(LegacyPlatformTextInputNode legacyPlatformTextInputNode) {
        if (!(this.f10387a == legacyPlatformTextInputNode)) {
            InlineClassHelperKt.c("Expected textInputModifierNode to be " + legacyPlatformTextInputNode + " but was " + this.f10387a);
        }
        this.f10387a = null;
    }
}
