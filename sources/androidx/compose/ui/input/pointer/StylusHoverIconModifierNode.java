package androidx.compose.ui.input.pointer;

import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
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
public final class StylusHoverIconModifierNode extends HoverIconModifierNode {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f26934f;

    public StylusHoverIconModifierNode(PointerIcon pointerIcon, boolean z2, DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        super(pointerIcon, z2, dpTouchBoundsExpansion);
        this.f26934f = "androidx.compose.ui.input.pointer.StylusHoverIcon";
    }

    @Override // androidx.compose.ui.node.TraversableNode
    /* JADX INFO: renamed from: C2, reason: merged with bridge method [inline-methods] */
    public String U() {
        return this.f26934f;
    }

    @Override // androidx.compose.ui.input.pointer.HoverIconModifierNode
    public void o2(PointerIcon pointerIcon) {
        PointerIconService pointerIconServiceV2 = v2();
        if (pointerIconServiceV2 != null) {
            pointerIconServiceV2.c(pointerIcon);
        }
    }

    @Override // androidx.compose.ui.input.pointer.HoverIconModifierNode
    public boolean w2(int i3) {
        PointerType.Companion companion = PointerType.f26922b;
        return PointerType.h(i3, companion.c()) || PointerType.h(i3, companion.a());
    }
}
