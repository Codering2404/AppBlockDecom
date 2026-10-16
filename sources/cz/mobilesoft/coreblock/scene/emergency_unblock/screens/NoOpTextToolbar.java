package cz.mobilesoft.coreblock.scene.emergency_unblock.screens;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NoOpTextToolbar implements TextToolbar {
    @Override // androidx.compose.ui.platform.TextToolbar
    public void b(Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04) {
        Intrinsics.checkNotNullParameter(rect, "rect");
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public /* bridge */ void d(Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05) {
        super.d(rect, function0, function02, function03, function04, function05);
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public TextToolbarStatus getStatus() {
        return TextToolbarStatus.f28213b;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void a() {
    }
}
