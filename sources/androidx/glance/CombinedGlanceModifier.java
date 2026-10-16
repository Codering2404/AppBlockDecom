package androidx.glance;

import androidx.glance.GlanceModifier;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CombinedGlanceModifier implements GlanceModifier {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GlanceModifier f37578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GlanceModifier f37579c;

    public CombinedGlanceModifier(GlanceModifier glanceModifier, GlanceModifier glanceModifier2) {
        this.f37578b = glanceModifier;
        this.f37579c = glanceModifier2;
    }

    @Override // androidx.glance.GlanceModifier
    public boolean all(Function1 function1) {
        return this.f37578b.all(function1) && this.f37579c.all(function1);
    }

    @Override // androidx.glance.GlanceModifier
    public boolean any(Function1 function1) {
        return this.f37578b.any(function1) || this.f37579c.any(function1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CombinedGlanceModifier)) {
            return false;
        }
        CombinedGlanceModifier combinedGlanceModifier = (CombinedGlanceModifier) obj;
        return Intrinsics.areEqual(this.f37578b, combinedGlanceModifier.f37578b) && Intrinsics.areEqual(this.f37579c, combinedGlanceModifier.f37579c);
    }

    @Override // androidx.glance.GlanceModifier
    public Object foldIn(Object obj, Function2 function2) {
        return this.f37579c.foldIn(this.f37578b.foldIn(obj, function2), function2);
    }

    public int hashCode() {
        return this.f37578b.hashCode() + (this.f37579c.hashCode() * 31);
    }

    public String toString() {
        return '[' + ((String) foldIn("", new Function2<String, GlanceModifier.Element, String>() { // from class: androidx.glance.CombinedGlanceModifier.toString.1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final String invoke(String str, GlanceModifier.Element element) {
                if (str.length() == 0) {
                    return element.toString();
                }
                return str + ", " + element;
            }
        })) + ']';
    }
}
