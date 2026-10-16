package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionServices;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class WrappedComposition implements Composition, LifecycleEventObserver, CompositionServices {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f28321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Composition f28322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Lifecycle f28324d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function2 f28325f = ComposableSingletons$Wrapper_androidKt.f27960a.a();

    public WrappedComposition(AndroidComposeView androidComposeView, Composition composition) {
        this.f28321a = androidComposeView;
        this.f28322b = composition;
    }

    public final Composition A() {
        return this.f28322b;
    }

    public final AndroidComposeView B() {
        return this.f28321a;
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        if (!this.f28323c) {
            this.f28323c = true;
            this.f28321a.getView().setTag(R.id.L, null);
            Lifecycle lifecycle = this.f28324d;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
            }
        }
        this.f28322b.dispose();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean e() {
        return this.f28322b.e();
    }

    @Override // androidx.compose.runtime.Composition
    public void f(final Function2 function2) {
        this.f28321a.setOnViewTreeOwnersAvailable(new Function1<AndroidComposeView.ViewTreeOwners, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(AndroidComposeView.ViewTreeOwners viewTreeOwners) {
                if (this.f28326a.f28323c) {
                    return;
                }
                Lifecycle lifecycle = viewTreeOwners.a().getLifecycle();
                this.f28326a.f28325f = function2;
                if (this.f28326a.f28324d == null) {
                    this.f28326a.f28324d = lifecycle;
                    lifecycle.addObserver(this.f28326a);
                } else if (lifecycle.getCurrentState().b(Lifecycle.State.f39949c)) {
                    Composition compositionA = this.f28326a.A();
                    final WrappedComposition wrappedComposition = this.f28326a;
                    final Function2 function22 = function2;
                    compositionA.f(ComposableLambdaKt.c(-2000640158, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer, int i3) {
                            if (!composer.r((i3 & 3) != 2, i3 & 1)) {
                                composer.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(-2000640158, i3, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:123)");
                            }
                            AndroidComposeView androidComposeViewB = wrappedComposition.B();
                            int i4 = R.id.K;
                            Object tag = androidComposeViewB.getTag(i4);
                            Set set = TypeIntrinsics.p(tag) ? (Set) tag : null;
                            if (set == null) {
                                Object parent = wrappedComposition.B().getParent();
                                View view = parent instanceof View ? (View) parent : null;
                                Object tag2 = view != null ? view.getTag(i4) : null;
                                set = TypeIntrinsics.p(tag2) ? (Set) tag2 : null;
                            }
                            if (set != null) {
                                set.add(composer.H());
                                composer.C();
                            }
                            AndroidComposeView androidComposeViewB2 = wrappedComposition.B();
                            boolean zI = composer.I(wrappedComposition);
                            WrappedComposition wrappedComposition2 = wrappedComposition;
                            Object objG = composer.G();
                            if (zI || objG == Composer.f23746a.a()) {
                                objG = new WrappedComposition$setContent$1$1$1$1(wrappedComposition2, null);
                                composer.w(objG);
                            }
                            EffectsKt.g(androidComposeViewB2, (Function2) objG, composer, 0);
                            AndroidComposeView androidComposeViewB3 = wrappedComposition.B();
                            boolean zI2 = composer.I(wrappedComposition);
                            WrappedComposition wrappedComposition3 = wrappedComposition;
                            Object objG2 = composer.G();
                            if (zI2 || objG2 == Composer.f23746a.a()) {
                                objG2 = new WrappedComposition$setContent$1$1$2$1(wrappedComposition3, null);
                                composer.w(objG2);
                            }
                            EffectsKt.g(androidComposeViewB3, (Function2) objG2, composer, 0);
                            ProvidedValue providedValueD = InspectionTablesKt.a().d(set);
                            final WrappedComposition wrappedComposition4 = wrappedComposition;
                            final Function2 function23 = function22;
                            CompositionLocalKt.b(providedValueD, ComposableLambdaKt.e(-1193460702, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition.setContent.1.1.3
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
                                    if (!composer2.r((i5 & 3) != 2, i5 & 1)) {
                                        composer2.Q();
                                        return;
                                    }
                                    if (ComposerKt.M()) {
                                        ComposerKt.U(-1193460702, i5, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:139)");
                                    }
                                    AndroidCompositionLocals_androidKt.a(wrappedComposition4.B(), function23, composer2, 0);
                                    if (ComposerKt.M()) {
                                        ComposerKt.T();
                                    }
                                }
                            }, composer, 54), composer, ProvidedValue.f24012i | 48);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AndroidComposeView.ViewTreeOwners) obj);
                return Unit.f139807a;
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else {
            if (event != Lifecycle.Event.ON_CREATE || this.f28323c) {
                return;
            }
            f(this.f28325f);
        }
    }
}
