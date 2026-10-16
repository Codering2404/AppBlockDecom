package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AndroidWindowInsets f7210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f7211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SideCalculator f7212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Density f7213d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WindowInsetsAnimationController f7214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CancellationSignal f7216h = new CancellationSignal();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f7217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Job f7218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CancellableContinuation f7219k;

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets androidWindowInsets, View view, SideCalculator sideCalculator, Density density) {
        this.f7210a = androidWindowInsets;
        this.f7211b = view;
        this.f7212c = sideCalculator;
        this.f7213d = density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(float f3) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.f7214f;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.setInsetsAndAlpha(this.f7212c.c(windowInsetsAnimationController.getCurrentInsets(), Math.round(f3)), 1.0f, 0.0f);
        }
    }

    private final void i() {
        WindowInsetsAnimationController windowInsetsAnimationController;
        WindowInsetsAnimationController windowInsetsAnimationController2 = this.f7214f;
        if (windowInsetsAnimationController2 != null && windowInsetsAnimationController2.isReady() && (windowInsetsAnimationController = this.f7214f) != null) {
            windowInsetsAnimationController.finish(this.f7210a.g());
        }
        this.f7214f = null;
        CancellableContinuation cancellableContinuation = this.f7219k;
        if (cancellableContinuation != null) {
            cancellableContinuation.x(null, new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1
                public final void invoke(Throwable th) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.f139807a;
                }
            });
        }
        this.f7219k = null;
        Job job = this.f7218j;
        if (job != null) {
            job.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
        }
        this.f7218j = null;
        this.f7217i = 0.0f;
        this.f7215g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(long r26, float r28, boolean r29, kotlin.coroutines.Continuation r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.k(long, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object l(Continuation continuation) {
        Object objV = this.f7214f;
        if (objV == null) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
            cancellableContinuationImpl.C();
            this.f7219k = cancellableContinuationImpl;
            m();
            objV = cancellableContinuationImpl.v();
            if (objV == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
        }
        return objV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        if (this.f7215g) {
            return;
        }
        this.f7215g = true;
        WindowInsetsController windowInsetsController = this.f7211b.getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.controlWindowInsetsAnimation(this.f7210a.f(), -1L, null, this.f7216h, j.a(this));
        }
    }

    private final long n(long j3, float f3) {
        Job job = this.f7218j;
        if (job != null) {
            job.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
            this.f7218j = null;
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.f7214f;
        if (f3 != 0.0f) {
            if (this.f7210a.g() != (f3 > 0.0f) || windowInsetsAnimationController != null) {
                if (windowInsetsAnimationController == null) {
                    this.f7217i = 0.0f;
                    m();
                    return this.f7212c.f(j3);
                }
                int iE = this.f7212c.e(windowInsetsAnimationController.getHiddenStateInsets());
                int iE2 = this.f7212c.e(windowInsetsAnimationController.getShownStateInsets());
                Insets currentInsets = windowInsetsAnimationController.getCurrentInsets();
                int iE3 = this.f7212c.e(currentInsets);
                if (iE3 == (f3 > 0.0f ? iE2 : iE)) {
                    this.f7217i = 0.0f;
                    return Offset.f25596b.c();
                }
                float f4 = iE3 + f3 + this.f7217i;
                int iP = RangesKt.p(Math.round(f4), iE, iE2);
                this.f7217i = f4 - Math.round(f4);
                if (iP != iE3) {
                    windowInsetsAnimationController.setInsetsAndAlpha(this.f7212c.c(currentInsets, iP), 1.0f, 0.0f);
                }
                return this.f7212c.f(j3);
            }
        }
        return Offset.f25596b.c();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long H0(long j3, long j4, int i3) {
        return n(j4, this.f7212c.a(Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (4294967295L & j4))));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long J1(long j3, int i3) {
        return n(j3, this.f7212c.d(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (4294967295L & j3))));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public Object R1(long j3, Continuation continuation) {
        return k(j3, this.f7212c.d(Velocity.h(j3), Velocity.i(j3)), false, continuation);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public Object Y(long j3, long j4, Continuation continuation) {
        return k(j4, this.f7212c.a(Velocity.h(j4), Velocity.i(j4)), true, continuation);
    }

    public final void j() {
        CancellableContinuation cancellableContinuation = this.f7219k;
        if (cancellableContinuation != null) {
            cancellableContinuation.x(null, new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$dispose$1
                public final void invoke(Throwable th) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.f139807a;
                }
            });
        }
        Job job = this.f7218j;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.f7214f;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.finish(!Intrinsics.areEqual(windowInsetsAnimationController.getCurrentInsets(), windowInsetsAnimationController.getHiddenStateInsets()));
        }
    }

    public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
        i();
    }

    public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
        i();
    }

    public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i3) {
        this.f7214f = windowInsetsAnimationController;
        this.f7215g = false;
        CancellableContinuation cancellableContinuation = this.f7219k;
        if (cancellableContinuation != null) {
            cancellableContinuation.x(windowInsetsAnimationController, new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.onReady.1
                public final void invoke(Throwable th) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.f139807a;
                }
            });
        }
        this.f7219k = null;
    }
}
