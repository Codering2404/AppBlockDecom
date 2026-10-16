package cz.mobilesoft.statistics.model;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RecordType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RecordType f133740a = new RecordType("USAGE_TIME", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RecordType f133741b = new RecordType("LAUNCH_COUNT", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ RecordType[] f133742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f133743d;

    static {
        RecordType[] recordTypeArrA = a();
        f133742c = recordTypeArrA;
        f133743d = EnumEntriesKt.a(recordTypeArrA);
    }

    private RecordType(String str, int i3) {
    }

    private static final /* synthetic */ RecordType[] a() {
        return new RecordType[]{f133740a, f133741b};
    }

    public static RecordType valueOf(String str) {
        return (RecordType) Enum.valueOf(RecordType.class, str);
    }

    public static RecordType[] values() {
        return (RecordType[]) f133742c.clone();
    }
}
