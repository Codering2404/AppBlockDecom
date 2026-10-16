package kotlinx.serialization.json.internal;

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
public final class WriteMode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WriteMode f143170c = new WriteMode("OBJ", 0, '{', '}');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WriteMode f143171d = new WriteMode("LIST", 1, '[', ']');

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final WriteMode f143172f = new WriteMode("MAP", 2, '{', '}');

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final WriteMode f143173g = new WriteMode("POLY_OBJ", 3, '[', ']');

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ WriteMode[] f143174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f143175i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f143176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f143177b;

    static {
        WriteMode[] writeModeArrA = a();
        f143174h = writeModeArrA;
        f143175i = EnumEntriesKt.a(writeModeArrA);
    }

    private WriteMode(String str, int i3, char c3, char c4) {
        this.f143176a = c3;
        this.f143177b = c4;
    }

    private static final /* synthetic */ WriteMode[] a() {
        return new WriteMode[]{f143170c, f143171d, f143172f, f143173g};
    }

    public static EnumEntries b() {
        return f143175i;
    }

    public static WriteMode valueOf(String str) {
        return (WriteMode) Enum.valueOf(WriteMode.class, str);
    }

    public static WriteMode[] values() {
        return (WriteMode[]) f143174h.clone();
    }
}
