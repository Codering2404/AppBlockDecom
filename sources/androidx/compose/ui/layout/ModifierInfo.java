package androidx.compose.ui.layout;

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
public final class ModifierInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Modifier f27176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LayoutCoordinates f27177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f27178c;

    public ModifierInfo(Modifier modifier, LayoutCoordinates layoutCoordinates, Object obj) {
        this.f27176a = modifier;
        this.f27177b = layoutCoordinates;
        this.f27178c = obj;
    }

    public final Modifier a() {
        return this.f27176a;
    }

    public String toString() {
        return "ModifierInfo(" + this.f27176a + ", " + this.f27177b + ", " + this.f27178c + ')';
    }
}
