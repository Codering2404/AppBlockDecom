package kotlin.annotation;

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
public final class AnnotationRetention {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnnotationRetention f139811a = new AnnotationRetention("SOURCE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AnnotationRetention f139812b = new AnnotationRetention("BINARY", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AnnotationRetention f139813c = new AnnotationRetention("RUNTIME", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AnnotationRetention[] f139814d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f139815f;

    static {
        AnnotationRetention[] annotationRetentionArrA = a();
        f139814d = annotationRetentionArrA;
        f139815f = EnumEntriesKt.a(annotationRetentionArrA);
    }

    private AnnotationRetention(String str, int i3) {
    }

    private static final /* synthetic */ AnnotationRetention[] a() {
        return new AnnotationRetention[]{f139811a, f139812b, f139813c};
    }

    public static AnnotationRetention valueOf(String str) {
        return (AnnotationRetention) Enum.valueOf(AnnotationRetention.class, str);
    }

    public static AnnotationRetention[] values() {
        return (AnnotationRetention[]) f139814d.clone();
    }
}
