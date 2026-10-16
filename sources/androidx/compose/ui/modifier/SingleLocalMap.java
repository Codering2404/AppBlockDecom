package androidx.compose.ui.modifier;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
public final class SingleLocalMap extends ModifierLocalMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ModifierLocal f27261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f27262b;

    public SingleLocalMap(ModifierLocal modifierLocal) {
        super(null);
        this.f27261a = modifierLocal;
        this.f27262b = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
    }

    private final Object d() {
        return this.f27262b.getValue();
    }

    private final void e(Object obj) {
        this.f27262b.setValue(obj);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean a(ModifierLocal modifierLocal) {
        return modifierLocal == this.f27261a;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public Object b(ModifierLocal modifierLocal) {
        if (!(modifierLocal == this.f27261a)) {
            InlineClassHelperKt.c("Check failed.");
        }
        Object objD = d();
        if (objD == null) {
            return null;
        }
        return objD;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public void c(ModifierLocal modifierLocal, Object obj) {
        if (!(modifierLocal == this.f27261a)) {
            InlineClassHelperKt.c("Check failed.");
        }
        e(obj);
    }
}
