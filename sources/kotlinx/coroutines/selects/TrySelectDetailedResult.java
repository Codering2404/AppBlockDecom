package kotlinx.coroutines.selects;

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
public final class TrySelectDetailedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TrySelectDetailedResult f142612a = new TrySelectDetailedResult("SUCCESSFUL", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TrySelectDetailedResult f142613b = new TrySelectDetailedResult("REREGISTER", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TrySelectDetailedResult f142614c = new TrySelectDetailedResult("CANCELLED", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TrySelectDetailedResult f142615d = new TrySelectDetailedResult("ALREADY_SELECTED", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ TrySelectDetailedResult[] f142616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f142617g;

    static {
        TrySelectDetailedResult[] trySelectDetailedResultArrA = a();
        f142616f = trySelectDetailedResultArrA;
        f142617g = EnumEntriesKt.a(trySelectDetailedResultArrA);
    }

    private TrySelectDetailedResult(String str, int i3) {
    }

    private static final /* synthetic */ TrySelectDetailedResult[] a() {
        return new TrySelectDetailedResult[]{f142612a, f142613b, f142614c, f142615d};
    }

    public static TrySelectDetailedResult valueOf(String str) {
        return (TrySelectDetailedResult) Enum.valueOf(TrySelectDetailedResult.class, str);
    }

    public static TrySelectDetailedResult[] values() {
        return (TrySelectDetailedResult[]) f142616f.clone();
    }
}
