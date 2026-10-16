package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class ContextMenuPopupPositionProvider implements PopupPositionProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f5259a;

    public /* synthetic */ ContextMenuPopupPositionProvider(long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public long a(IntRect intRect, long j3, LayoutDirection layoutDirection, long j4) {
        return IntOffset.f((((long) ContextMenuPopupPositionProvider_androidKt.b(intRect.g() + IntOffset.k(this.f5259a), (int) (j4 >> 32), (int) (j3 >> 32), layoutDirection == LayoutDirection.f30001a)) << 32) | (((long) ContextMenuPopupPositionProvider_androidKt.c(intRect.j() + IntOffset.l(this.f5259a), (int) (j4 & 4294967295L), (int) (j3 & 4294967295L), false, 8, null)) & 4294967295L));
    }

    private ContextMenuPopupPositionProvider(long j3) {
        this.f5259a = j3;
    }
}
