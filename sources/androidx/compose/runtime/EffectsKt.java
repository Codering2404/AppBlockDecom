package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

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
public final class EffectsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DisposableEffectScope f23880a = new DisposableEffectScope();

    public static final void a(Object obj, Object obj2, Object obj3, Function1 function1, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1239538271, i3, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:223)");
        }
        boolean Z = composer.Z(obj) | composer.Z(obj2) | composer.Z(obj3);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new DisposableEffectImpl(function1);
            composer.w(objG);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void b(Object obj, Object obj2, Function1 function1, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1429097729, i3, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:185)");
        }
        boolean Z = composer.Z(obj) | composer.Z(obj2);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new DisposableEffectImpl(function1);
            composer.w(objG);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void c(Object obj, Function1 function1, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1371986847, i3, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:148)");
        }
        boolean Z = composer.Z(obj);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new DisposableEffectImpl(function1);
            composer.w(objG);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void d(Object[] objArr, Function1 function1, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1307627122, i3, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:259)");
        }
        boolean Z = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            Z |= composer.Z(obj);
        }
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            composer.w(new DisposableEffectImpl(function1));
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void e(Object obj, Object obj2, Object obj3, Function2 function2, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-54093371, i3, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:354)");
        }
        CoroutineContext coroutineContextT = composer.t();
        boolean Z = composer.Z(obj) | composer.Z(obj2) | composer.Z(obj3);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new LaunchedEffectImpl(coroutineContextT, function2);
            composer.w(objG);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void f(Object obj, Object obj2, Function2 function2, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(590241125, i3, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:335)");
        }
        CoroutineContext coroutineContextT = composer.t();
        boolean Z = composer.Z(obj) | composer.Z(obj2);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new LaunchedEffectImpl(coroutineContextT, function2);
            composer.w(objG);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void g(Object obj, Function2 function2, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1179185413, i3, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:316)");
        }
        CoroutineContext coroutineContextT = composer.t();
        boolean Z = composer.Z(obj);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new LaunchedEffectImpl(coroutineContextT, function2);
            composer.w(objG);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void h(final Function2 function2, Composer composer, final int i3) {
        Composer composerK = composer.k(-805415771);
        int i4 = i3 & 1;
        if (composerK.r(i4 != 0, i4)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-805415771, i3, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:300)");
            }
            throw new IllegalStateException("LaunchedEffect must provide one or more 'key' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.");
        }
        composerK.Q();
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.EffectsKt$LaunchedEffect$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    EffectsKt.h(function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void i(Object[] objArr, Function2 function2, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-139560008, i3, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:377)");
        }
        CoroutineContext coroutineContextT = composer.t();
        boolean Z = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            Z |= composer.Z(obj);
        }
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            composer.w(new LaunchedEffectImpl(coroutineContextT, function2));
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void j(Function0 function0, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1288466761, i3, -1, "androidx.compose.runtime.SideEffect (Effects.kt:49)");
        }
        composer.B(function0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final CoroutineScope l(CoroutineContext coroutineContext, Composer composer) {
        if (coroutineContext.get(Job.v8) == null) {
            return new RememberedCoroutineScope(composer.t(), coroutineContext);
        }
        CompletableJob completableJobB = JobKt__JobKt.b(null, 1, null);
        completableJobB.a(new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job"));
        return CoroutineScopeKt.a(completableJobB);
    }
}
