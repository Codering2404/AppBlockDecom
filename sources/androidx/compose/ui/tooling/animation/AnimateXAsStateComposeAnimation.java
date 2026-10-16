package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
public final class AnimateXAsStateComposeAnimation<T, V extends AnimationVector> implements ComposeAnimation {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f29788g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f29789h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f29790i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ToolingState f29791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimationSpec f29792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Animatable f29793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ComposeAnimationType f29794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f29795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f29796f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return AnimateXAsStateComposeAnimation.f29790i;
        }

        public final AnimateXAsStateComposeAnimation b(AnimationSearch.AnimateXAsStateSearchInfo animateXAsStateSearchInfo) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (a() && animateXAsStateSearchInfo.a().n() != null) {
                return new AnimateXAsStateComposeAnimation(animateXAsStateSearchInfo.c(), animateXAsStateSearchInfo.b(), animateXAsStateSearchInfo.a(), defaultConstructorMarker);
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
            if (Intrinsics.areEqual(composeAnimationTypeArrValues[i3].name(), "ANIMATE_X_AS_STATE")) {
                z2 = true;
                break;
            }
            i3++;
        }
        f29790i = z2;
    }

    public /* synthetic */ AnimateXAsStateComposeAnimation(ToolingState toolingState, AnimationSpec animationSpec, Animatable animatable, DefaultConstructorMarker defaultConstructorMarker) {
        this(toolingState, animationSpec, animatable);
    }

    public Animatable b() {
        return this.f29793c;
    }

    public final AnimationSpec c() {
        return this.f29792b;
    }

    public final ToolingState d() {
        return this.f29791a;
    }

    private AnimateXAsStateComposeAnimation(ToolingState toolingState, AnimationSpec animationSpec, Animatable animatable) {
        Set set;
        this.f29791a = toolingState;
        this.f29792b = animationSpec;
        this.f29793c = animatable;
        this.f29794d = ComposeAnimationType.ANIMATE_X_AS_STATE;
        Object objN = b().n();
        Intrinsics.checkNotNull(objN, "null cannot be cast to non-null type kotlin.Any");
        Object[] enumConstants = objN.getClass().getEnumConstants();
        this.f29795e = (enumConstants == null || (set = ArraysKt.toSet(enumConstants)) == null) ? SetsKt.setOf(objN) : set;
        this.f29796f = b().k();
    }
}
