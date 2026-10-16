package androidx.compose.ui.semantics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CustomAccessibilityAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f28446b;

    public CustomAccessibilityAction(String str, Function0 function0) {
        this.f28445a = str;
        this.f28446b = function0;
    }

    public final Function0 a() {
        return this.f28446b;
    }

    public final String b() {
        return this.f28445a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomAccessibilityAction)) {
            return false;
        }
        CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) obj;
        return Intrinsics.areEqual(this.f28445a, customAccessibilityAction.f28445a) && this.f28446b == customAccessibilityAction.f28446b;
    }

    public int hashCode() {
        return (this.f28445a.hashCode() * 31) + this.f28446b.hashCode();
    }

    public String toString() {
        return "CustomAccessibilityAction(label=" + this.f28445a + ", action=" + this.f28446b + ')';
    }
}
