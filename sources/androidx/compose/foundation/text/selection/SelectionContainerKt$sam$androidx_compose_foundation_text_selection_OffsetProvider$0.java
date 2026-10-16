package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
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
final class SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 implements OffsetProvider, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Function0 f11312a;

    SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(Function0 function0) {
        this.f11312a = function0;
    }

    @Override // androidx.compose.foundation.text.selection.OffsetProvider
    public final /* synthetic */ long a() {
        return ((Offset) this.f11312a.invoke()).u();
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function b() {
        return this.f11312a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof OffsetProvider) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(b(), ((FunctionAdapter) obj).b());
        }
        return false;
    }

    public final int hashCode() {
        return b().hashCode();
    }
}
