package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import androidx.compose.ui.tooling.animation.AnimationSearch;
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
public final class InfiniteTransitionComposeAnimation implements ComposeAnimation {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f29838f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f29839g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f29840h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ToolingState f29841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InfiniteTransition f29842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComposeAnimationType f29843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f29844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f29845e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return InfiniteTransitionComposeAnimation.f29840h;
        }

        public final InfiniteTransitionComposeAnimation b(AnimationSearch.InfiniteTransitionSearchInfo infiniteTransitionSearchInfo) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (a()) {
                return new InfiniteTransitionComposeAnimation(infiniteTransitionSearchInfo.b(), infiniteTransitionSearchInfo.a(), defaultConstructorMarker);
            }
            return null;
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
            if (Intrinsics.areEqual(composeAnimationTypeArrValues[i3].name(), "INFINITE_TRANSITION")) {
                z2 = true;
                break;
            }
            i3++;
        }
        f29840h = z2;
    }

    public /* synthetic */ InfiniteTransitionComposeAnimation(ToolingState toolingState, InfiniteTransition infiniteTransition, DefaultConstructorMarker defaultConstructorMarker) {
        this(toolingState, infiniteTransition);
    }

    public InfiniteTransition b() {
        return this.f29842b;
    }

    private InfiniteTransitionComposeAnimation(ToolingState toolingState, InfiniteTransition infiniteTransition) {
        this.f29841a = toolingState;
        this.f29842b = infiniteTransition;
        this.f29843c = ComposeAnimationType.INFINITE_TRANSITION;
        this.f29844d = SetsKt.setOf(0);
        this.f29845e = b().h();
    }
}
