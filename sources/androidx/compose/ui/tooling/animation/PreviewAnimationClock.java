package androidx.compose.ui.tooling.animation;

import android.util.Log;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.compose.ui.tooling.animation.clock.AnimateXAsStateClock;
import androidx.compose.ui.tooling.animation.clock.AnimatedVisibilityClock;
import androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock;
import androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock;
import androidx.compose.ui.tooling.animation.clock.TransitionClock;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
public class PreviewAnimationClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f29846a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f29848c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29847b = "PreviewAnimationClock";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f29849d = new LinkedHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f29850e = new LinkedHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f29851f = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f29852g = new LinkedHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f29853h = new LinkedHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LinkedHashSet f29854i = new LinkedHashSet();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinkedHashSet f29855j = new LinkedHashSet();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f29856k = new Object();

    /* JADX INFO: renamed from: androidx.compose.ui.tooling.animation.PreviewAnimationClock$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f29857a = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m268invoke() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m268invoke();
            return Unit.f139807a;
        }
    }

    public PreviewAnimationClock(Function0 function0) {
        this.f29846a = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str) {
        UnsupportedComposeAnimation unsupportedComposeAnimationA = UnsupportedComposeAnimation.f29878e.a(str);
        if (unsupportedComposeAnimationA != null) {
            this.f29854i.add(unsupportedComposeAnimationA);
            j(unsupportedComposeAnimationA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List d() {
        return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) CollectionsKt.plus(this.f29849d.values(), (Iterable) this.f29850e.values()), (Iterable) this.f29851f.values()), (Iterable) this.f29853h.values());
    }

    private final boolean o(Object obj, Function1 function1) {
        synchronized (this.f29856k) {
            if (this.f29855j.contains(obj)) {
                if (this.f29848c) {
                    Log.d(this.f29847b, "Animation " + obj + " is already being tracked");
                }
                return false;
            }
            this.f29855j.add(obj);
            function1.invoke(obj);
            if (!this.f29848c) {
                return true;
            }
            Log.d(this.f29847b, "Animation " + obj + " is now tracked");
            return true;
        }
    }

    private final void t(Object obj, final String str) {
        o(obj, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackUnsupported$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Object obj2) {
                this.f29871a.c(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                c(obj2);
                return Unit.f139807a;
            }
        });
    }

    public final Map e() {
        return this.f29851f;
    }

    public final Map f() {
        return this.f29853h;
    }

    public final Map g() {
        return this.f29850e;
    }

    public final Map h() {
        return this.f29852g;
    }

    public final Map i() {
        return this.f29849d;
    }

    public final void k(Object obj) {
        t(obj, "animateContentSize");
    }

    public final void l(final AnimationSearch.AnimateXAsStateSearchInfo animateXAsStateSearchInfo) {
        o(animateXAsStateSearchInfo.a(), new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackAnimateXAsState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Object obj) {
                AnimateXAsStateComposeAnimation animateXAsStateComposeAnimationB = AnimateXAsStateComposeAnimation.f29788g.b(animateXAsStateSearchInfo);
                if (animateXAsStateComposeAnimationB == null) {
                    this.c(animateXAsStateSearchInfo.a().k());
                    return;
                }
                PreviewAnimationClock previewAnimationClock = this;
                previewAnimationClock.e().put(animateXAsStateComposeAnimationB, new AnimateXAsStateClock(animateXAsStateComposeAnimationB));
                previewAnimationClock.j(animateXAsStateComposeAnimationB);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(obj);
                return Unit.f139807a;
            }
        });
    }

    public final void m(final Transition transition) {
        o(transition, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackAnimatedContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Object obj) {
                AnimatedContentComposeAnimation animatedContentComposeAnimationB = AnimatedContentComposeAnimation.f29797e.b(transition);
                if (animatedContentComposeAnimationB == null) {
                    this.c(transition.k());
                    return;
                }
                PreviewAnimationClock previewAnimationClock = this;
                previewAnimationClock.f().put(animatedContentComposeAnimationB, new TransitionClock(animatedContentComposeAnimationB));
                previewAnimationClock.j(animatedContentComposeAnimationB);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(obj);
                return Unit.f139807a;
            }
        });
    }

    public final void n(final Transition transition, final Function0 function0) {
        if (transition.i() instanceof Boolean) {
            o(transition, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackAnimatedVisibility$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(Object obj) {
                    Intrinsics.checkNotNull(transition, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Boolean>");
                    AnimatedVisibilityComposeAnimation animatedVisibilityComposeAnimationA = AnimatedVisibilityComposeAnimation_androidKt.a(transition);
                    function0.invoke();
                    Map mapG = this.g();
                    AnimatedVisibilityClock animatedVisibilityClock = new AnimatedVisibilityClock(animatedVisibilityComposeAnimationA);
                    animatedVisibilityClock.d(0L);
                    mapG.put(animatedVisibilityComposeAnimationA, animatedVisibilityClock);
                    this.j(animatedVisibilityComposeAnimationA);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c(obj);
                    return Unit.f139807a;
                }
            });
        }
    }

    public final void p(DecayAnimation decayAnimation) {
        t(decayAnimation, "DecayAnimation");
    }

    public final void q(final AnimationSearch.InfiniteTransitionSearchInfo infiniteTransitionSearchInfo) {
        o(infiniteTransitionSearchInfo.a(), new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackInfiniteTransition$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Object obj) {
                InfiniteTransitionComposeAnimation infiniteTransitionComposeAnimationB = InfiniteTransitionComposeAnimation.f29838f.b(infiniteTransitionSearchInfo);
                if (infiniteTransitionComposeAnimationB != null) {
                    final PreviewAnimationClock previewAnimationClock = this;
                    previewAnimationClock.h().put(infiniteTransitionComposeAnimationB, new InfiniteTransitionClock(infiniteTransitionComposeAnimationB, new Function0<Long>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackInfiniteTransition$1$1$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            Long lValueOf;
                            Iterator it = previewAnimationClock.d().iterator();
                            Long lValueOf2 = null;
                            if (it.hasNext()) {
                                lValueOf = Long.valueOf(((ComposeAnimationClock) it.next()).a());
                                while (it.hasNext()) {
                                    Long lValueOf3 = Long.valueOf(((ComposeAnimationClock) it.next()).a());
                                    if (lValueOf.compareTo(lValueOf3) < 0) {
                                        lValueOf = lValueOf3;
                                    }
                                }
                            } else {
                                lValueOf = null;
                            }
                            long jLongValue = lValueOf != null ? lValueOf.longValue() : 0L;
                            Iterator it2 = previewAnimationClock.h().values().iterator();
                            if (it2.hasNext()) {
                                lValueOf2 = Long.valueOf(((InfiniteTransitionClock) it2.next()).d());
                                while (it2.hasNext()) {
                                    Long lValueOf4 = Long.valueOf(((InfiniteTransitionClock) it2.next()).d());
                                    if (lValueOf2.compareTo(lValueOf4) < 0) {
                                        lValueOf2 = lValueOf4;
                                    }
                                }
                            }
                            return Long.valueOf(Math.max(jLongValue, lValueOf2 != null ? lValueOf2.longValue() : 0L));
                        }
                    }));
                    previewAnimationClock.j(infiniteTransitionComposeAnimationB);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(obj);
                return Unit.f139807a;
            }
        });
    }

    public final void r(TargetBasedAnimation targetBasedAnimation) {
        t(targetBasedAnimation, "TargetBasedAnimation");
    }

    public final void s(final Transition transition) {
        o(transition, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackTransition$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Object obj) {
                TransitionComposeAnimation transitionComposeAnimationA = TransitionComposeAnimation_androidKt.a(transition);
                if (transitionComposeAnimationA == null) {
                    this.c(transition.k());
                    return;
                }
                PreviewAnimationClock previewAnimationClock = this;
                previewAnimationClock.i().put(transitionComposeAnimationA, new TransitionClock(transitionComposeAnimationA));
                previewAnimationClock.j(transitionComposeAnimationA);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(obj);
                return Unit.f139807a;
            }
        });
    }

    protected void j(ComposeAnimation composeAnimation) {
    }
}
