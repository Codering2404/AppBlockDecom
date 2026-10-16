package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

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
public interface SnapshotContextElement extends CoroutineContext.Element {
    public static final Key a8 = Key.f24923a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static Object a(SnapshotContextElement snapshotContextElement, Object obj, Function2 function2) {
            return CoroutineContext.Element.DefaultImpls.a(snapshotContextElement, obj, function2);
        }

        public static CoroutineContext.Element b(SnapshotContextElement snapshotContextElement, CoroutineContext.Key key) {
            return CoroutineContext.Element.DefaultImpls.b(snapshotContextElement, key);
        }

        public static CoroutineContext c(SnapshotContextElement snapshotContextElement, CoroutineContext.Key key) {
            return CoroutineContext.Element.DefaultImpls.c(snapshotContextElement, key);
        }

        public static CoroutineContext d(SnapshotContextElement snapshotContextElement, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(snapshotContextElement, coroutineContext);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Key implements CoroutineContext.Key<SnapshotContextElement> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Key f24923a = new Key();

        private Key() {
        }
    }
}
