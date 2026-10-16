package androidx.compose.ui.state;

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
public final class ToggleableState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ToggleableState f28618a = new ToggleableState("On", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ToggleableState f28619b = new ToggleableState("Off", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ToggleableState f28620c = new ToggleableState("Indeterminate", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ ToggleableState[] f28621d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f28622f;

    static {
        ToggleableState[] toggleableStateArrA = a();
        f28621d = toggleableStateArrA;
        f28622f = EnumEntriesKt.a(toggleableStateArrA);
    }

    private ToggleableState(String str, int i3) {
    }

    private static final /* synthetic */ ToggleableState[] a() {
        return new ToggleableState[]{f28618a, f28619b, f28620c};
    }

    public static ToggleableState valueOf(String str) {
        return (ToggleableState) Enum.valueOf(ToggleableState.class, str);
    }

    public static ToggleableState[] values() {
        return (ToggleableState[]) f28621d.clone();
    }
}
