package androidx.compose.runtime;

import com.facebook.internal.AnalyticsEvents;
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
public final class PausedCompositionState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PausedCompositionState f23989a = new PausedCompositionState("Invalid", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PausedCompositionState f23990b = new PausedCompositionState(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED, 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PausedCompositionState f23991c = new PausedCompositionState("InitialPending", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PausedCompositionState f23992d = new PausedCompositionState("RecomposePending", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final PausedCompositionState f23993f = new PausedCompositionState("ApplyPending", 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PausedCompositionState f23994g = new PausedCompositionState("Applied", 5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ PausedCompositionState[] f23995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f23996i;

    static {
        PausedCompositionState[] pausedCompositionStateArrA = a();
        f23995h = pausedCompositionStateArrA;
        f23996i = EnumEntriesKt.a(pausedCompositionStateArrA);
    }

    private PausedCompositionState(String str, int i3) {
    }

    private static final /* synthetic */ PausedCompositionState[] a() {
        return new PausedCompositionState[]{f23989a, f23990b, f23991c, f23992d, f23993f, f23994g};
    }

    public static PausedCompositionState valueOf(String str) {
        return (PausedCompositionState) Enum.valueOf(PausedCompositionState.class, str);
    }

    public static PausedCompositionState[] values() {
        return (PausedCompositionState[]) f23995h.clone();
    }
}
