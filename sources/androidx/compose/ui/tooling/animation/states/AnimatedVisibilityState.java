package androidx.compose.ui.tooling.animation.states;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@JvmInline
public final class AnimatedVisibilityState implements ComposeAnimationState {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29907b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f29908c = d("Enter");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f29909d = d("Exit");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29910a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return AnimatedVisibilityState.f29908c;
        }

        public final String b() {
            return AnimatedVisibilityState.f29909d;
        }

        private Companion() {
        }
    }

    private /* synthetic */ AnimatedVisibilityState(String str) {
        this.f29910a = str;
    }

    public static final /* synthetic */ AnimatedVisibilityState c(String str) {
        return new AnimatedVisibilityState(str);
    }

    public static boolean e(String str, Object obj) {
        return (obj instanceof AnimatedVisibilityState) && Intrinsics.areEqual(str, ((AnimatedVisibilityState) obj).i());
    }

    public static final boolean f(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    public static int g(String str) {
        return str.hashCode();
    }

    public boolean equals(Object obj) {
        return e(this.f29910a, obj);
    }

    public int hashCode() {
        return g(this.f29910a);
    }

    public final /* synthetic */ String i() {
        return this.f29910a;
    }

    public String toString() {
        return h(this.f29910a);
    }

    private static String d(String str) {
        return str;
    }

    public static String h(String str) {
        return str;
    }
}
