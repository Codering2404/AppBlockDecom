package androidx.compose.ui.focus;

import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.legacy.content.Werj.QgXempTBEfV;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmInline
public final class Focusability {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25566b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f25567c = e(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f25568d = e(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f25569e = e(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25570a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return Focusability.f25567c;
        }

        public final int b() {
            return Focusability.f25569e;
        }

        public final int c() {
            return Focusability.f25568d;
        }

        private Companion() {
        }
    }

    public static final boolean d(int i3, CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode) {
        if (g(i3, f25567c)) {
            return true;
        }
        if (g(i3, f25568d)) {
            return !InputMode.f(((InputModeManager) CompositionLocalConsumerModifierNodeKt.a(compositionLocalConsumerModifierNode, CompositionLocalsKt.l())).a(), InputMode.f26627b.b());
        }
        if (g(i3, f25569e)) {
            return false;
        }
        throw new IllegalStateException("Unknown Focusability");
    }

    private static int e(int i3) {
        return i3;
    }

    public static boolean f(int i3, Object obj) {
        return (obj instanceof Focusability) && i3 == ((Focusability) obj).j();
    }

    public static final boolean g(int i3, int i4) {
        return i3 == i4;
    }

    public static int h(int i3) {
        return Integer.hashCode(i3);
    }

    public boolean equals(Object obj) {
        return f(this.f25570a, obj);
    }

    public int hashCode() {
        return h(this.f25570a);
    }

    public final /* synthetic */ int j() {
        return this.f25570a;
    }

    public String toString() {
        return i(this.f25570a);
    }

    public static String i(int i3) {
        if (g(i3, f25567c)) {
            return "Always";
        }
        if (g(i3, f25568d)) {
            return "SystemDefined";
        }
        if (g(i3, f25569e)) {
            return QgXempTBEfV.BijEAiQirOmAu;
        }
        throw new IllegalStateException("Unknown Focusability");
    }
}
