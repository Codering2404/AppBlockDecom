package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

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
@ExperimentalSerializationApi
public final class DecodeSequenceMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DecodeSequenceMode f142954a = new DecodeSequenceMode("WHITESPACE_SEPARATED", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DecodeSequenceMode f142955b = new DecodeSequenceMode("ARRAY_WRAPPED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DecodeSequenceMode f142956c = new DecodeSequenceMode("AUTO_DETECT", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ DecodeSequenceMode[] f142957d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f142958f;

    static {
        DecodeSequenceMode[] decodeSequenceModeArrA = a();
        f142957d = decodeSequenceModeArrA;
        f142958f = EnumEntriesKt.a(decodeSequenceModeArrA);
    }

    private DecodeSequenceMode(String str, int i3) {
    }

    private static final /* synthetic */ DecodeSequenceMode[] a() {
        return new DecodeSequenceMode[]{f142954a, f142955b, f142956c};
    }

    public static DecodeSequenceMode valueOf(String str) {
        return (DecodeSequenceMode) Enum.valueOf(DecodeSequenceMode.class, str);
    }

    public static DecodeSequenceMode[] values() {
        return (DecodeSequenceMode[]) f142957d.clone();
    }
}
