package androidx.compose.ui.modifier;

import androidx.compose.ui.internal.InlineClassHelperKt;
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
public final class BackwardsCompatLocalMap extends ModifierLocalMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ModifierLocalProvider f27244a;

    public BackwardsCompatLocalMap(ModifierLocalProvider modifierLocalProvider) {
        super(null);
        this.f27244a = modifierLocalProvider;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean a(ModifierLocal modifierLocal) {
        return modifierLocal == this.f27244a.getKey();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public Object b(ModifierLocal modifierLocal) {
        if (!(modifierLocal == this.f27244a.getKey())) {
            InlineClassHelperKt.c("Check failed.");
        }
        return this.f27244a.getValue();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public void c(ModifierLocal modifierLocal, Object obj) {
        throw new IllegalStateException("Set is not allowed on a backwards compat provider");
    }

    public final void d(ModifierLocalProvider modifierLocalProvider) {
        this.f27244a = modifierLocalProvider;
    }
}
