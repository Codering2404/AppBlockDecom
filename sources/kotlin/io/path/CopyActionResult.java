package kotlin.io.path;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class CopyActionResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyActionResult f140024a = new CopyActionResult("CONTINUE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyActionResult f140025b = new CopyActionResult("SKIP_SUBTREE", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyActionResult f140026c = new CopyActionResult("TERMINATE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ CopyActionResult[] f140027d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f140028f;

    static {
        CopyActionResult[] copyActionResultArrA = a();
        f140027d = copyActionResultArrA;
        f140028f = EnumEntriesKt.a(copyActionResultArrA);
    }

    private CopyActionResult(String str, int i3) {
    }

    private static final /* synthetic */ CopyActionResult[] a() {
        return new CopyActionResult[]{f140024a, f140025b, f140026c};
    }

    public static CopyActionResult valueOf(String str) {
        return (CopyActionResult) Enum.valueOf(CopyActionResult.class, str);
    }

    public static CopyActionResult[] values() {
        return (CopyActionResult[]) f140027d.clone();
    }
}
