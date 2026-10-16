package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public final class PressGestureScopeImpl implements PressGestureScope, Density {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Density f6035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Mutex f6038d = MutexKt.a(false);

    public PressGestureScopeImpl(Density density) {
        this.f6035a = density;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object D0(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1 r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1) r0
            int r1 = r0.f6049d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6049d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1 r0 = new androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f6047b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6049d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r0 = r0.f6046a
            androidx.compose.foundation.gestures.PressGestureScopeImpl r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl) r0
            kotlin.ResultKt.b(r6)
            goto L4f
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.b(r6)
            boolean r6 = r5.f6036b
            if (r6 != 0) goto L55
            boolean r6 = r5.f6037c
            if (r6 != 0) goto L55
            kotlinx.coroutines.sync.Mutex r6 = r5.f6038d
            r0.f6046a = r5
            r0.f6049d = r4
            java.lang.Object r6 = kotlinx.coroutines.sync.Mutex.DefaultImpls.a(r6, r3, r0, r4, r3)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r0 = r5
        L4f:
            kotlinx.coroutines.sync.Mutex r6 = r0.f6038d
            kotlinx.coroutines.sync.Mutex.DefaultImpls.c(r6, r3, r4, r3)
            goto L56
        L55:
            r0 = r5
        L56:
            boolean r6 = r0.f6036b
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.PressGestureScopeImpl.D0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.unit.Density
    public float F(int i3) {
        return this.f6035a.F(i3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float G(float f3) {
        return this.f6035a.G(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float J0(long j3) {
        return this.f6035a.J0(j3);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return this.f6035a.K1();
    }

    @Override // androidx.compose.ui.unit.Density
    public long M(long j3) {
        return this.f6035a.M(j3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float M1(float f3) {
        return this.f6035a.M1(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public int T1(long j3) {
        return this.f6035a.T1(j3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f6035a.getDensity();
    }

    public final void m() {
        this.f6037c = true;
        if (this.f6038d.c()) {
            Mutex.DefaultImpls.c(this.f6038d, null, 1, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object m1(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1 r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1) r0
            int r1 = r0.f6041c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6041c = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1 r0 = new androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f6039a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6041c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            r0.f6041c = r3
            java.lang.Object r5 = r4.D0(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L48
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L48:
            androidx.compose.foundation.gestures.GestureCancellationException r5 = new androidx.compose.foundation.gestures.GestureCancellationException
            java.lang.String r0 = "The press gesture was canceled."
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.PressGestureScopeImpl.m1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public long n(float f3) {
        return this.f6035a.n(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public long o(long j3) {
        return this.f6035a.o(j3);
    }

    public final void p() {
        this.f6036b = true;
        if (this.f6038d.c()) {
            Mutex.DefaultImpls.c(this.f6038d, null, 1, null);
        }
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float q(long j3) {
        return this.f6035a.q(j3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1 r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1) r0
            int r1 = r0.f6045d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6045d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1 r0 = new androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f6043b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6045d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f6042a
            androidx.compose.foundation.gestures.PressGestureScopeImpl r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl) r0
            kotlin.ResultKt.b(r5)
            goto L47
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.sync.Mutex r5 = r4.f6038d
            r0.f6042a = r4
            r0.f6045d = r3
            r2 = 0
            java.lang.Object r5 = kotlinx.coroutines.sync.Mutex.DefaultImpls.a(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L46
            return r1
        L46:
            r0 = r4
        L47:
            r5 = 0
            r0.f6036b = r5
            r0.f6037c = r5
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.PressGestureScopeImpl.u(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.unit.Density
    public long v(float f3) {
        return this.f6035a.v(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public int z0(float f3) {
        return this.f6035a.z0(f3);
    }
}
