package androidx.compose.ui;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CombinedModifier implements Modifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Modifier f25098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Modifier f25099b;

    public CombinedModifier(Modifier modifier, Modifier modifier2) {
        this.f25098a = modifier;
        this.f25099b = modifier2;
    }

    public final Modifier a() {
        return this.f25099b;
    }

    @Override // androidx.compose.ui.Modifier
    public boolean all(Function1 function1) {
        return this.f25098a.all(function1) && this.f25099b.all(function1);
    }

    @Override // androidx.compose.ui.Modifier
    public boolean any(Function1 function1) {
        return this.f25098a.any(function1) || this.f25099b.any(function1);
    }

    public final Modifier b() {
        return this.f25098a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CombinedModifier)) {
            return false;
        }
        CombinedModifier combinedModifier = (CombinedModifier) obj;
        return Intrinsics.areEqual(this.f25098a, combinedModifier.f25098a) && Intrinsics.areEqual(this.f25099b, combinedModifier.f25099b);
    }

    @Override // androidx.compose.ui.Modifier
    public Object foldIn(Object obj, Function2 function2) {
        return this.f25099b.foldIn(this.f25098a.foldIn(obj, function2), function2);
    }

    public int hashCode() {
        return this.f25098a.hashCode() + (this.f25099b.hashCode() * 31);
    }

    public String toString() {
        return '[' + ((String) foldIn("", new Function2<String, Modifier.Element, String>() { // from class: androidx.compose.ui.CombinedModifier.toString.1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final String invoke(String str, Modifier.Element element) {
                if (str.length() == 0) {
                    return element.toString();
                }
                return str + ", " + element;
            }
        })) + ']';
    }
}
