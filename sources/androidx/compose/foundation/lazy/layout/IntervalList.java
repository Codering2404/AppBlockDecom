package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public interface IntervalList<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Interval<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f7990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f7991c;

        public Interval(int i3, int i4, Object obj) {
            this.f7989a = i3;
            this.f7990b = i4;
            this.f7991c = obj;
            if (!(i3 >= 0)) {
                InlineClassHelperKt.a("startIndex should be >= 0");
            }
            if (i4 > 0) {
                return;
            }
            InlineClassHelperKt.a("size should be > 0");
        }

        public final int a() {
            return this.f7990b;
        }

        public final int b() {
            return this.f7989a;
        }

        public final Object c() {
            return this.f7991c;
        }
    }

    void a(int i3, int i4, Function1 function1);

    Interval get(int i3);

    int getSize();
}
