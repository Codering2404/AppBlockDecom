package androidx.compose.foundation.text.selection;

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
final class DownResolution {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownResolution f11222a = new DownResolution("Up", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DownResolution f11223b = new DownResolution("Drag", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DownResolution f11224c = new DownResolution("Timeout", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DownResolution f11225d = new DownResolution("Cancel", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ DownResolution[] f11226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f11227g;

    static {
        DownResolution[] downResolutionArrA = a();
        f11226f = downResolutionArrA;
        f11227g = EnumEntriesKt.a(downResolutionArrA);
    }

    private DownResolution(String str, int i3) {
    }

    private static final /* synthetic */ DownResolution[] a() {
        return new DownResolution[]{f11222a, f11223b, f11224c, f11225d};
    }

    public static DownResolution valueOf(String str) {
        return (DownResolution) Enum.valueOf(DownResolution.class, str);
    }

    public static DownResolution[] values() {
        return (DownResolution[]) f11226f.clone();
    }
}
