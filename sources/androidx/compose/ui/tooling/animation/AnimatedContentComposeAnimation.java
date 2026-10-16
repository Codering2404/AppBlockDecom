package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public final class AnimatedContentComposeAnimation<T> implements ComposeAnimation, TransitionBasedAnimation<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f29797e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f29798f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f29799g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Transition f29800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f29801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ComposeAnimationType f29803d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return AnimatedContentComposeAnimation.f29799g;
        }

        public final AnimatedContentComposeAnimation b(Transition transition) {
            Object objI;
            Set of;
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (!a() || (objI = transition.i()) == null) {
                return null;
            }
            Object[] enumConstants = objI.getClass().getEnumConstants();
            if (enumConstants == null || (of = ArraysKt.toSet(enumConstants)) == null) {
                of = SetsKt.setOf(objI);
            }
            String strK = transition.k();
            if (strK == null) {
                strK = Reflection.b(objI.getClass()).m();
            }
            return new AnimatedContentComposeAnimation(transition, of, strK, defaultConstructorMarker);
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
            if (Intrinsics.areEqual(composeAnimationTypeArrValues[i3].name(), "ANIMATED_CONTENT")) {
                z2 = true;
                break;
            }
            i3++;
        }
        f29799g = z2;
    }

    public /* synthetic */ AnimatedContentComposeAnimation(Transition transition, Set set, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(transition, set, str);
    }

    @Override // androidx.compose.ui.tooling.animation.TransitionBasedAnimation
    public Transition a() {
        return this.f29800a;
    }

    private AnimatedContentComposeAnimation(Transition transition, Set set, String str) {
        this.f29800a = transition;
        this.f29801b = set;
        this.f29802c = str;
        this.f29803d = ComposeAnimationType.ANIMATED_CONTENT;
    }
}
