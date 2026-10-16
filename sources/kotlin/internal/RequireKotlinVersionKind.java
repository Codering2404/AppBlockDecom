package kotlin.internal;

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
public final class RequireKotlinVersionKind {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RequireKotlinVersionKind f139929a = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RequireKotlinVersionKind f139930b = new RequireKotlinVersionKind("COMPILER_VERSION", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RequireKotlinVersionKind f139931c = new RequireKotlinVersionKind("API_VERSION", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ RequireKotlinVersionKind[] f139932d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f139933f;

    static {
        RequireKotlinVersionKind[] requireKotlinVersionKindArrA = a();
        f139932d = requireKotlinVersionKindArrA;
        f139933f = EnumEntriesKt.a(requireKotlinVersionKindArrA);
    }

    private RequireKotlinVersionKind(String str, int i3) {
    }

    private static final /* synthetic */ RequireKotlinVersionKind[] a() {
        return new RequireKotlinVersionKind[]{f139929a, f139930b, f139931c};
    }

    public static RequireKotlinVersionKind valueOf(String str) {
        return (RequireKotlinVersionKind) Enum.valueOf(RequireKotlinVersionKind.class, str);
    }

    public static RequireKotlinVersionKind[] values() {
        return (RequireKotlinVersionKind[]) f139932d.clone();
    }
}
