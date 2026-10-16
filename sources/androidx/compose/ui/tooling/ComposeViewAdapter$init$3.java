package androidx.compose.ui.tooling;

import android.view.KeyEvent;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewRootForTest;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ComposeViewAdapter$init$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f29715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComposeViewAdapter f29716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f29717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f29718d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Class f29719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f29720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f29721h;

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
            ComposerKt.U(-2046245106, i3, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous> (ComposeViewAdapter.android.kt:466)");
        }
        EffectsKt.j(this.f29715a, composer, 0);
        final ComposeViewAdapter composeViewAdapter = this.f29716b;
        final String str = this.f29717c;
        final String str2 = this.f29718d;
        final Class cls = this.f29719f;
        final int i4 = this.f29720g;
        final long j3 = this.f29721h;
        composeViewAdapter.a(ComposableLambdaKt.e(320194433, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$3.1
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
                final Composer composer3;
                if (!composer2.r((i5 & 3) != 2, i5 & 1)) {
                    composer2.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(320194433, i5, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous>.<anonymous> (ComposeViewAdapter.android.kt:469)");
                }
                boolean Z = composer2.Z(str) | composer2.Z(str2) | composer2.I(composer2) | composer2.I(cls) | composer2.e(i4) | composer2.I(composeViewAdapter);
                final String str3 = str;
                final String str4 = str2;
                final Class cls2 = cls;
                final int i6 = i4;
                final ComposeViewAdapter composeViewAdapter2 = composeViewAdapter;
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    composer3 = composer2;
                    objG = new Function0<Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$3$1$composable$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m265invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m265invoke() {
                            Throwable cause;
                            try {
                                ComposableInvoker composableInvoker = ComposableInvoker.f29668a;
                                String str5 = str3;
                                String str6 = str4;
                                Composer composer4 = composer3;
                                Object[] objArrF = PreviewUtils_androidKt.f(cls2, i6);
                                composableInvoker.g(str5, str6, composer4, Arrays.copyOf(objArrF, objArrF.length));
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                while ((th2 instanceof ReflectiveOperationException) && (cause = th2.getCause()) != null) {
                                    th2 = cause;
                                }
                                composeViewAdapter2.f29688k.a(th2);
                                throw th;
                            }
                        }
                    };
                    composer3.w(objG);
                } else {
                    composer3 = composer2;
                }
                Function0 function0 = (Function0) objG;
                if (j3 >= 0) {
                    composer3.a0(-967474306);
                    ComposeViewAdapter composeViewAdapter3 = composeViewAdapter;
                    boolean zI = composer3.I(composeViewAdapter3);
                    final ComposeViewAdapter composeViewAdapter4 = composeViewAdapter;
                    Object objG2 = composer3.G();
                    if (zI || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function0<Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$3$1$1$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m264invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m264invoke() {
                                View childAt = composeViewAdapter4.getChildAt(0);
                                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
                                KeyEvent.Callback childAt2 = ((ComposeView) childAt).getChildAt(0);
                                ViewRootForTest viewRootForTest = childAt2 instanceof ViewRootForTest ? (ViewRootForTest) childAt2 : null;
                                if (viewRootForTest != null) {
                                    viewRootForTest.C();
                                }
                                Snapshot.f24914e.n();
                            }
                        };
                        composer3.w(objG2);
                    }
                    composeViewAdapter3.setClock$ui_tooling_release(new PreviewAnimationClock((Function0) objG2));
                    composer3.U();
                } else {
                    composer3.a0(-966247109);
                    composer3.U();
                }
                function0.invoke();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }, composer, 54), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
