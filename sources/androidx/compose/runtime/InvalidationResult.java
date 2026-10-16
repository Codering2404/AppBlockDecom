package androidx.compose.runtime;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class InvalidationResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InvalidationResult f23911a = new InvalidationResult("IGNORED", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InvalidationResult f23912b = new InvalidationResult("SCHEDULED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InvalidationResult f23913c = new InvalidationResult("DEFERRED", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final InvalidationResult f23914d = new InvalidationResult("IMMINENT", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ InvalidationResult[] f23915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f23916g;

    static {
        InvalidationResult[] invalidationResultArrA = a();
        f23915f = invalidationResultArrA;
        f23916g = EnumEntriesKt.a(invalidationResultArrA);
    }

    private InvalidationResult(String str, int i3) {
    }

    private static final /* synthetic */ InvalidationResult[] a() {
        return new InvalidationResult[]{f23911a, f23912b, f23913c, f23914d};
    }

    public static InvalidationResult valueOf(String str) {
        return (InvalidationResult) Enum.valueOf(InvalidationResult.class, str);
    }

    public static InvalidationResult[] values() {
        return (InvalidationResult[]) f23915f.clone();
    }
}
