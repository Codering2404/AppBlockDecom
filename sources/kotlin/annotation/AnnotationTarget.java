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
public final class AnnotationTarget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnnotationTarget f139816a = new AnnotationTarget("CLASS", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AnnotationTarget f139817b = new AnnotationTarget("ANNOTATION_CLASS", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AnnotationTarget f139818c = new AnnotationTarget("TYPE_PARAMETER", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AnnotationTarget f139819d = new AnnotationTarget("PROPERTY", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AnnotationTarget f139820f = new AnnotationTarget("FIELD", 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AnnotationTarget f139821g = new AnnotationTarget("LOCAL_VARIABLE", 5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AnnotationTarget f139822h = new AnnotationTarget("VALUE_PARAMETER", 6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AnnotationTarget f139823i = new AnnotationTarget("CONSTRUCTOR", 7);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AnnotationTarget f139824j = new AnnotationTarget("FUNCTION", 8);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AnnotationTarget f139825k = new AnnotationTarget("PROPERTY_GETTER", 9);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AnnotationTarget f139826l = new AnnotationTarget("PROPERTY_SETTER", 10);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AnnotationTarget f139827m = new AnnotationTarget("TYPE", 11);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AnnotationTarget f139828n = new AnnotationTarget("EXPRESSION", 12);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AnnotationTarget f139829o = new AnnotationTarget("FILE", 13);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AnnotationTarget f139830p = new AnnotationTarget("TYPEALIAS", 14);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final /* synthetic */ AnnotationTarget[] f139831q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f139832r;

    static {
        AnnotationTarget[] annotationTargetArrA = a();
        f139831q = annotationTargetArrA;
        f139832r = EnumEntriesKt.a(annotationTargetArrA);
    }

    private AnnotationTarget(String str, int i3) {
    }

    private static final /* synthetic */ AnnotationTarget[] a() {
        return new AnnotationTarget[]{f139816a, f139817b, f139818c, f139819d, f139820f, f139821g, f139822h, f139823i, f139824j, f139825k, f139826l, f139827m, f139828n, f139829o, f139830p};
    }

    public static AnnotationTarget valueOf(String str) {
        return (AnnotationTarget) Enum.valueOf(AnnotationTarget.class, str);
    }

    public static AnnotationTarget[] values() {
        return (AnnotationTarget[]) f139831q.clone();
    }
}
