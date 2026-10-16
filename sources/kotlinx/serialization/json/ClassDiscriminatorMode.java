package kotlinx.serialization.json;

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
public final class ClassDiscriminatorMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ClassDiscriminatorMode f142949a = new ClassDiscriminatorMode("NONE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ClassDiscriminatorMode f142950b = new ClassDiscriminatorMode("ALL_JSON_OBJECTS", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ClassDiscriminatorMode f142951c = new ClassDiscriminatorMode("POLYMORPHIC", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ ClassDiscriminatorMode[] f142952d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f142953f;

    static {
        ClassDiscriminatorMode[] classDiscriminatorModeArrA = a();
        f142952d = classDiscriminatorModeArrA;
        f142953f = EnumEntriesKt.a(classDiscriminatorModeArrA);
    }

    private ClassDiscriminatorMode(String str, int i3) {
    }

    private static final /* synthetic */ ClassDiscriminatorMode[] a() {
        return new ClassDiscriminatorMode[]{f142949a, f142950b, f142951c};
    }

    public static ClassDiscriminatorMode valueOf(String str) {
        return (ClassDiscriminatorMode) Enum.valueOf(ClassDiscriminatorMode.class, str);
    }

    public static ClassDiscriminatorMode[] values() {
        return (ClassDiscriminatorMode[]) f142952d.clone();
    }
}
