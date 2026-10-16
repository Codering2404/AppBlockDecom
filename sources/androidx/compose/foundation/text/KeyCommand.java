package androidx.compose.foundation.text;

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
public final class KeyCommand {
    private static final /* synthetic */ KeyCommand[] Y;
    private static final /* synthetic */ EnumEntries Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KeyCommand f9723b = new KeyCommand("LEFT_CHAR", 0, false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KeyCommand f9724c = new KeyCommand("RIGHT_CHAR", 1, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final KeyCommand f9725d = new KeyCommand("RIGHT_WORD", 2, false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final KeyCommand f9726f = new KeyCommand("LEFT_WORD", 3, false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final KeyCommand f9727g = new KeyCommand("NEXT_PARAGRAPH", 4, false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final KeyCommand f9728h = new KeyCommand("PREV_PARAGRAPH", 5, false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final KeyCommand f9729i = new KeyCommand("LINE_START", 6, false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final KeyCommand f9730j = new KeyCommand("LINE_END", 7, false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final KeyCommand f9731k = new KeyCommand("LINE_LEFT", 8, false);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final KeyCommand f9732l = new KeyCommand("LINE_RIGHT", 9, false);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final KeyCommand f9733m = new KeyCommand("UP", 10, false);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final KeyCommand f9734n = new KeyCommand("DOWN", 11, false);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final KeyCommand f9735o = new KeyCommand("PAGE_UP", 12, false);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final KeyCommand f9736p = new KeyCommand("PAGE_DOWN", 13, false);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final KeyCommand f9737q = new KeyCommand("HOME", 14, false);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final KeyCommand f9738r = new KeyCommand("END", 15, false);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final KeyCommand f9739s = new KeyCommand("COPY", 16, false);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final KeyCommand f9740t = new KeyCommand("PASTE", 17, true);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final KeyCommand f9741u = new KeyCommand("CUT", 18, true);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final KeyCommand f9742v = new KeyCommand("DELETE_PREV_CHAR", 19, true);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final KeyCommand f9743w = new KeyCommand("DELETE_NEXT_CHAR", 20, true);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final KeyCommand f9744x = new KeyCommand("DELETE_PREV_WORD", 21, true);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final KeyCommand f9745y = new KeyCommand("DELETE_NEXT_WORD", 22, true);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final KeyCommand f9746z = new KeyCommand("DELETE_FROM_LINE_START", 23, true);
    public static final KeyCommand A = new KeyCommand("DELETE_TO_LINE_END", 24, true);
    public static final KeyCommand B = new KeyCommand("SELECT_ALL", 25, false);
    public static final KeyCommand C = new KeyCommand("SELECT_LEFT_CHAR", 26, false);
    public static final KeyCommand D = new KeyCommand("SELECT_RIGHT_CHAR", 27, false);
    public static final KeyCommand E = new KeyCommand("SELECT_UP", 28, false);
    public static final KeyCommand F = new KeyCommand("SELECT_DOWN", 29, false);
    public static final KeyCommand G = new KeyCommand("SELECT_PAGE_UP", 30, false);
    public static final KeyCommand H = new KeyCommand("SELECT_PAGE_DOWN", 31, false);
    public static final KeyCommand I = new KeyCommand("SELECT_HOME", 32, false);
    public static final KeyCommand J = new KeyCommand("SELECT_END", 33, false);
    public static final KeyCommand K = new KeyCommand("SELECT_LEFT_WORD", 34, false);
    public static final KeyCommand L = new KeyCommand("SELECT_RIGHT_WORD", 35, false);
    public static final KeyCommand M = new KeyCommand("SELECT_NEXT_PARAGRAPH", 36, false);
    public static final KeyCommand N = new KeyCommand("SELECT_PREV_PARAGRAPH", 37, false);
    public static final KeyCommand O = new KeyCommand("SELECT_LINE_START", 38, false);
    public static final KeyCommand P = new KeyCommand("SELECT_LINE_END", 39, false);
    public static final KeyCommand Q = new KeyCommand("SELECT_LINE_LEFT", 40, false);
    public static final KeyCommand R = new KeyCommand("SELECT_LINE_RIGHT", 41, false);
    public static final KeyCommand S = new KeyCommand("DESELECT", 42, false);
    public static final KeyCommand T = new KeyCommand("NEW_LINE", 43, true);
    public static final KeyCommand U = new KeyCommand("TAB", 44, true);
    public static final KeyCommand V = new KeyCommand("UNDO", 45, true);
    public static final KeyCommand W = new KeyCommand("REDO", 46, true);
    public static final KeyCommand X = new KeyCommand("CHARACTER_PALETTE", 47, true);

    static {
        KeyCommand[] keyCommandArrA = a();
        Y = keyCommandArrA;
        Z = EnumEntriesKt.a(keyCommandArrA);
    }

    private KeyCommand(String str, int i3, boolean z2) {
        this.f9747a = z2;
    }

    private static final /* synthetic */ KeyCommand[] a() {
        return new KeyCommand[]{f9723b, f9724c, f9725d, f9726f, f9727g, f9728h, f9729i, f9730j, f9731k, f9732l, f9733m, f9734n, f9735o, f9736p, f9737q, f9738r, f9739s, f9740t, f9741u, f9742v, f9743w, f9744x, f9745y, f9746z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X};
    }

    public static KeyCommand valueOf(String str) {
        return (KeyCommand) Enum.valueOf(KeyCommand.class, str);
    }

    public static KeyCommand[] values() {
        return (KeyCommand[]) Y.clone();
    }

    public final boolean b() {
        return this.f9747a;
    }
}
