package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
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
public final class UnsupportedComposeAnimation implements ComposeAnimation {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f29878e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f29879f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f29880g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComposeAnimationType f29882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f29883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f29884d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UnsupportedComposeAnimation a(String str) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (b()) {
                return new UnsupportedComposeAnimation(str, defaultConstructorMarker);
            }
            return null;
        }

        public final boolean b() {
            return UnsupportedComposeAnimation.f29880g;
        }

        private Companion() {
        }
    }

    static {
        ComposeAnimationType[] composeAnimationTypeArrValues = ComposeAnimationType.values();
        int length = composeAnimationTypeArrValues.length;
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (Intrinsics.areEqual(composeAnimationTypeArrValues[i3].name(), "UNSUPPORTED")) {
                z2 = true;
                break;
            }
            i3++;
        }
        f29880g = z2;
    }

    public /* synthetic */ UnsupportedComposeAnimation(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private UnsupportedComposeAnimation(String str) {
        this.f29881a = str;
        this.f29882b = ComposeAnimationType.UNSUPPORTED;
        this.f29883c = 0;
        this.f29884d = SetsKt.emptySet();
    }
}
