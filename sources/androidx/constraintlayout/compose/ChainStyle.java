package androidx.constraintlayout.compose;

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
public final class ChainStyle {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f30372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ChainStyle f30373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ChainStyle f30374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ChainStyle f30375f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f30377b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChainStyle a(float f3) {
            return new ChainStyle("packed", Float.valueOf(f3));
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion companion = new Companion(null);
        f30372c = companion;
        int i3 = 2;
        f30373d = new ChainStyle("spread", 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        f30374e = new ChainStyle("spread_inside", 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        f30375f = companion.a(0.5f);
    }

    public ChainStyle(String str, Float f3) {
        this.f30376a = str;
        this.f30377b = f3;
    }

    public /* synthetic */ ChainStyle(String str, Float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : f3);
    }
}
