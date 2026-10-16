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
public final class RelativePosition implements NamedPropertyOrValue {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f30927b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final RelativePosition f30928c = new RelativePosition("deltaRelative");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final RelativePosition f30929d = new RelativePosition("pathRelative");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final RelativePosition f30930e = new RelativePosition("parentRelative");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30931a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RelativePosition(String str) {
        this.f30931a = str;
    }

    @Override // androidx.constraintlayout.compose.NamedPropertyOrValue
    public String getName() {
        return this.f30931a;
    }
}
