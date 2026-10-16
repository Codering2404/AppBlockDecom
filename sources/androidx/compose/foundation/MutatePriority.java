package androidx.compose.foundation;

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
public final class MutatePriority {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutatePriority f5071a = new MutatePriority("Default", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutatePriority f5072b = new MutatePriority("UserInput", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutatePriority f5073c = new MutatePriority("PreventUserInput", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ MutatePriority[] f5074d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f5075f;

    static {
        MutatePriority[] mutatePriorityArrA = a();
        f5074d = mutatePriorityArrA;
        f5075f = EnumEntriesKt.a(mutatePriorityArrA);
    }

    private MutatePriority(String str, int i3) {
    }

    private static final /* synthetic */ MutatePriority[] a() {
        return new MutatePriority[]{f5071a, f5072b, f5073c};
    }

    public static MutatePriority valueOf(String str) {
        return (MutatePriority) Enum.valueOf(MutatePriority.class, str);
    }

    public static MutatePriority[] values() {
        return (MutatePriority[]) f5074d.clone();
    }
}
