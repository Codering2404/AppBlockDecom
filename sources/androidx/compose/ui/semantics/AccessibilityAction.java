package androidx.compose.ui.semantics;

import kotlin.Function;
import kotlin.Metadata;
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
public final class AccessibilityAction<T extends Function<? extends Boolean>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function f28432b;

    public AccessibilityAction(String str, Function function) {
        this.f28431a = str;
        this.f28432b = function;
    }

    public final Function a() {
        return this.f28432b;
    }

    public final String b() {
        return this.f28431a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityAction)) {
            return false;
        }
        AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
        return Intrinsics.areEqual(this.f28431a, accessibilityAction.f28431a) && Intrinsics.areEqual(this.f28432b, accessibilityAction.f28432b);
    }

    public int hashCode() {
        String str = this.f28431a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Function function = this.f28432b;
        return iHashCode + (function != null ? function.hashCode() : 0);
    }

    public String toString() {
        return "AccessibilityAction(label=" + this.f28431a + ", action=" + this.f28432b + ')';
    }
}
