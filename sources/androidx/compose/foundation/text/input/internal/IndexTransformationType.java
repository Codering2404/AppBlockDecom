package androidx.compose.foundation.text.input.internal;

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
public final class IndexTransformationType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IndexTransformationType f10350a = new IndexTransformationType("Untransformed", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IndexTransformationType f10351b = new IndexTransformationType("Insertion", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final IndexTransformationType f10352c = new IndexTransformationType("Replacement", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final IndexTransformationType f10353d = new IndexTransformationType("Deletion", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ IndexTransformationType[] f10354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f10355g;

    static {
        IndexTransformationType[] indexTransformationTypeArrA = a();
        f10354f = indexTransformationTypeArrA;
        f10355g = EnumEntriesKt.a(indexTransformationTypeArrA);
    }

    private IndexTransformationType(String str, int i3) {
    }

    private static final /* synthetic */ IndexTransformationType[] a() {
        return new IndexTransformationType[]{f10350a, f10351b, f10352c, f10353d};
    }

    public static IndexTransformationType valueOf(String str) {
        return (IndexTransformationType) Enum.valueOf(IndexTransformationType.class, str);
    }

    public static IndexTransformationType[] values() {
        return (IndexTransformationType[]) f10354f.clone();
    }
}
