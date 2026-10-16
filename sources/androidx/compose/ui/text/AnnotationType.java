package androidx.compose.ui.text;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class AnnotationType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnnotationType f28665a = new AnnotationType("Paragraph", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AnnotationType f28666b = new AnnotationType("Span", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AnnotationType f28667c = new AnnotationType("VerbatimTts", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AnnotationType f28668d = new AnnotationType("Url", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AnnotationType f28669f = new AnnotationType("Link", 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AnnotationType f28670g = new AnnotationType("Clickable", 5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AnnotationType f28671h = new AnnotationType("String", 6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AnnotationType[] f28672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f28673j;

    static {
        AnnotationType[] annotationTypeArrA = a();
        f28672i = annotationTypeArrA;
        f28673j = EnumEntriesKt.a(annotationTypeArrA);
    }

    private AnnotationType(String str, int i3) {
    }

    private static final /* synthetic */ AnnotationType[] a() {
        return new AnnotationType[]{f28665a, f28666b, f28667c, f28668d, f28669f, f28670g, f28671h};
    }

    public static AnnotationType valueOf(String str) {
        return (AnnotationType) Enum.valueOf(AnnotationType.class, str);
    }

    public static AnnotationType[] values() {
        return (AnnotationType[]) f28672i.clone();
    }
}
