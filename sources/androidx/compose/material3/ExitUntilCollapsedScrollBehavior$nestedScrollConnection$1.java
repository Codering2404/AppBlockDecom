package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;

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
public final class ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExitUntilCollapsedScrollBehavior f17549a;

    ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1(ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior) {
        this.f17549a = exitUntilCollapsedScrollBehavior;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long H0(long j3, long j4, int i3) {
        if (!((Boolean) this.f17549a.e().invoke()).booleanValue()) {
            return Offset.f25596b.c();
        }
        TopAppBarState state = this.f17549a.getState();
        state.g(state.c() + Offset.n(j3));
        if (Offset.n(j4) < 0.0f || Offset.n(j3) < 0.0f) {
            float fD = this.f17549a.getState().d();
            this.f17549a.getState().h(this.f17549a.getState().d() + Offset.n(j3));
            return OffsetKt.a(0.0f, this.f17549a.getState().d() - fD);
        }
        if (Offset.n(j3) == 0.0f && Offset.n(j4) > 0.0f) {
            this.f17549a.getState().g(0.0f);
        }
        if (Offset.n(j4) <= 0.0f) {
            return Offset.f25596b.c();
        }
        float fD2 = this.f17549a.getState().d();
        this.f17549a.getState().h(this.f17549a.getState().d() + Offset.n(j4));
        return OffsetKt.a(0.0f, this.f17549a.getState().d() - fD2);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long J1(long j3, int i3) {
        if (!((Boolean) this.f17549a.e().invoke()).booleanValue() || Offset.n(j3) > 0.0f) {
            return Offset.f25596b.c();
        }
        float fD = this.f17549a.getState().d();
        this.f17549a.getState().h(this.f17549a.getState().d() + Offset.n(j3));
        return fD == this.f17549a.getState().d() ? Offset.f25596b.c() : Offset.g(j3, 0.0f, 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object Y(long r9, long r11, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = (androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1) r0
            int r1 = r0.f17554f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f17554f = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = new androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1
            r0.<init>(r8, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.f17552c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f17554f
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L42
            if (r1 == r2) goto L38
            if (r1 != r7) goto L30
            long r9 = r6.f17551b
            kotlin.ResultKt.b(r13)
            goto L82
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            long r11 = r6.f17551b
            java.lang.Object r9 = r6.f17550a
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 r9 = (androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1) r9
            kotlin.ResultKt.b(r13)
            goto L57
        L42:
            kotlin.ResultKt.b(r13)
            r6.f17550a = r8
            r6.f17551b = r11
            r6.f17554f = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r13 = super.Y(r2, r4, r6)
            if (r13 != r0) goto L55
            goto L80
        L55:
            r9 = r8
            r11 = r4
        L57:
            androidx.compose.ui.unit.Velocity r13 = (androidx.compose.ui.unit.Velocity) r13
            long r1 = r13.o()
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r10 = r9.f17549a
            androidx.compose.material3.TopAppBarState r10 = r10.getState()
            float r11 = androidx.compose.ui.unit.Velocity.i(r11)
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r12 = r9.f17549a
            androidx.compose.animation.core.DecayAnimationSpec r12 = r12.b()
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r9 = r9.f17549a
            androidx.compose.animation.core.AnimationSpec r9 = r9.c()
            r13 = 0
            r6.f17550a = r13
            r6.f17551b = r1
            r6.f17554f = r7
            java.lang.Object r13 = androidx.compose.material3.AppBarKt.z(r10, r11, r12, r9, r6)
            if (r13 != r0) goto L81
        L80:
            return r0
        L81:
            r9 = r1
        L82:
            androidx.compose.ui.unit.Velocity r13 = (androidx.compose.ui.unit.Velocity) r13
            long r11 = r13.o()
            long r9 = androidx.compose.ui.unit.Velocity.l(r9, r11)
            androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.b(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1.Y(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
