package androidx.constraintlayout.compose;

import com.facebook.appevents.integrity.IntegrityManager;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class Arc {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f30334b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Arc f30335c = new Arc(IntegrityManager.INTEGRITY_TYPE_NONE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Arc f30336d = new Arc("startVertical");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Arc f30337e = new Arc("startHorizontal");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Arc f30338f = new Arc("flip");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Arc f30339g = new Arc("below");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Arc f30340h = new Arc("above");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30341a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Arc(String str) {
        this.f30341a = str;
    }
}
