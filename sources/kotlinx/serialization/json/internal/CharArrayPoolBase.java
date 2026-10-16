package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class CharArrayPoolBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque f143061a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f143062b;

    protected final void a(char[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        synchronized (this) {
            try {
                if (this.f143062b + array.length < ArrayPoolsKt.f143056a) {
                    this.f143062b += array.length;
                    this.f143061a.addLast(array);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final char[] b(int i3) {
        char[] cArr;
        synchronized (this) {
            cArr = (char[]) this.f143061a.removeLastOrNull();
            if (cArr != null) {
                this.f143062b -= cArr.length;
            } else {
                cArr = null;
            }
        }
        return cArr == null ? new char[i3] : cArr;
    }
}
