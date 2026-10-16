package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
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
final class MultiChoiceSegmentedButtonScopeWrapper implements MultiChoiceSegmentedButtonRowScope, RowScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ RowScope f18398a;

    public MultiChoiceSegmentedButtonScopeWrapper(RowScope rowScope) {
        this.f18398a = rowScope;
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier a(Modifier modifier, float f3, boolean z2) {
        return this.f18398a.a(modifier, f3, z2);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier b(Modifier modifier) {
        return this.f18398a.b(modifier);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier d(Modifier modifier, Alignment.Vertical vertical) {
        return this.f18398a.d(modifier, vertical);
    }
}
