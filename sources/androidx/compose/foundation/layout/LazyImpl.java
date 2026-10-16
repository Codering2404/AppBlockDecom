package androidx.compose.foundation.layout;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class LazyImpl implements Lazy<Integer> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f7004d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f7005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7007c = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LazyImpl(Function0 function0, String str) {
        this.f7005a = function0;
        this.f7006b = str;
    }

    @Override // kotlin.Lazy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        if (this.f7007c == -1) {
            this.f7007c = ((Number) this.f7005a.invoke()).intValue();
        }
        int i3 = this.f7007c;
        if (i3 != -1) {
            return Integer.valueOf(i3);
        }
        throw new IllegalStateException(this.f7006b);
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.f7007c != -1;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue().intValue()) : this.f7006b;
    }
}
