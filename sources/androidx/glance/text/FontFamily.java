package androidx.glance.text;

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
public final class FontFamily {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f39736b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final FontFamily f39737c = new FontFamily("serif");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final FontFamily f39738d = new FontFamily("sans-serif");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final FontFamily f39739e = new FontFamily("monospace");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final FontFamily f39740f = new FontFamily("cursive");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39741a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FontFamily(String str) {
        this.f39741a = str;
    }

    public final String a() {
        return this.f39741a;
    }

    public String toString() {
        return this.f39741a;
    }
}
