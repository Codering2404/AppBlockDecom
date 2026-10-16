package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class FloatingActionButtonElevationAnimatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f17778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f17779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f17780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f17781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Animatable f17782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Interaction f17783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Interaction f17784g;

    public /* synthetic */ FloatingActionButtonElevationAnimatable(float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6);
    }

    private final float d(Interaction interaction) {
        return interaction instanceof PressInteraction.Press ? this.f17779b : interaction instanceof HoverInteraction.Enter ? this.f17780c : interaction instanceof FocusInteraction.Focus ? this.f17781d : this.f17778a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.material3.FloatingActionButtonElevationAnimatable$snapElevation$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.material3.FloatingActionButtonElevationAnimatable$snapElevation$1 r0 = (androidx.compose.material3.FloatingActionButtonElevationAnimatable$snapElevation$1) r0
            int r1 = r0.f17793d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17793d = r1
            goto L18
        L13:
            androidx.compose.material3.FloatingActionButtonElevationAnimatable$snapElevation$1 r0 = new androidx.compose.material3.FloatingActionButtonElevationAnimatable$snapElevation$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f17791b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f17793d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.f17790a
            androidx.compose.material3.FloatingActionButtonElevationAnimatable r0 = (androidx.compose.material3.FloatingActionButtonElevationAnimatable) r0
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L2d
            goto L64
        L2d:
            r5 = move-exception
            goto L6b
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            kotlin.ResultKt.b(r5)
            androidx.compose.foundation.interaction.Interaction r5 = r4.f17784g
            float r5 = r4.d(r5)
            androidx.compose.animation.core.Animatable r2 = r4.f17782e
            java.lang.Object r2 = r2.l()
            androidx.compose.ui.unit.Dp r2 = (androidx.compose.ui.unit.Dp) r2
            float r2 = r2.l()
            boolean r2 = androidx.compose.ui.unit.Dp.i(r2, r5)
            if (r2 != 0) goto L70
            androidx.compose.animation.core.Animatable r2 = r4.f17782e     // Catch: java.lang.Throwable -> L69
            androidx.compose.ui.unit.Dp r5 = androidx.compose.ui.unit.Dp.d(r5)     // Catch: java.lang.Throwable -> L69
            r0.f17790a = r4     // Catch: java.lang.Throwable -> L69
            r0.f17793d = r3     // Catch: java.lang.Throwable -> L69
            java.lang.Object r5 = r2.u(r5, r0)     // Catch: java.lang.Throwable -> L69
            if (r5 != r1) goto L63
            return r1
        L63:
            r0 = r4
        L64:
            androidx.compose.foundation.interaction.Interaction r5 = r0.f17784g
            r0.f17783f = r5
            goto L70
        L69:
            r5 = move-exception
            r0 = r4
        L6b:
            androidx.compose.foundation.interaction.Interaction r1 = r0.f17784g
            r0.f17783f = r1
            throw r5
        L70:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonElevationAnimatable.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(androidx.compose.foundation.interaction.Interaction r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.material3.FloatingActionButtonElevationAnimatable$animateElevation$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.material3.FloatingActionButtonElevationAnimatable$animateElevation$1 r0 = (androidx.compose.material3.FloatingActionButtonElevationAnimatable$animateElevation$1) r0
            int r1 = r0.f17789f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17789f = r1
            goto L18
        L13:
            androidx.compose.material3.FloatingActionButtonElevationAnimatable$animateElevation$1 r0 = new androidx.compose.material3.FloatingActionButtonElevationAnimatable$animateElevation$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f17787c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f17789f
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.f17786b
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            java.lang.Object r0 = r0.f17785a
            androidx.compose.material3.FloatingActionButtonElevationAnimatable r0 = (androidx.compose.material3.FloatingActionButtonElevationAnimatable) r0
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L6b
        L31:
            r7 = move-exception
            goto L70
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.b(r7)
            float r7 = r5.d(r6)
            r5.f17784g = r6
            androidx.compose.animation.core.Animatable r2 = r5.f17782e     // Catch: java.lang.Throwable -> L67
            java.lang.Object r2 = r2.l()     // Catch: java.lang.Throwable -> L67
            androidx.compose.ui.unit.Dp r2 = (androidx.compose.ui.unit.Dp) r2     // Catch: java.lang.Throwable -> L67
            float r2 = r2.l()     // Catch: java.lang.Throwable -> L67
            boolean r2 = androidx.compose.ui.unit.Dp.i(r2, r7)     // Catch: java.lang.Throwable -> L67
            if (r2 != 0) goto L6a
            androidx.compose.animation.core.Animatable r2 = r5.f17782e     // Catch: java.lang.Throwable -> L67
            androidx.compose.foundation.interaction.Interaction r4 = r5.f17783f     // Catch: java.lang.Throwable -> L67
            r0.f17785a = r5     // Catch: java.lang.Throwable -> L67
            r0.f17786b = r6     // Catch: java.lang.Throwable -> L67
            r0.f17789f = r3     // Catch: java.lang.Throwable -> L67
            java.lang.Object r7 = androidx.compose.material3.internal.ElevationKt.d(r2, r7, r4, r6, r0)     // Catch: java.lang.Throwable -> L67
            if (r7 != r1) goto L6a
            return r1
        L67:
            r7 = move-exception
            r0 = r5
            goto L70
        L6a:
            r0 = r5
        L6b:
            r0.f17783f = r6
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L70:
            r0.f17783f = r6
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonElevationAnimatable.b(androidx.compose.foundation.interaction.Interaction, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final State c() {
        return this.f17782e.g();
    }

    public final Object f(float f3, float f4, float f5, float f6, Continuation continuation) throws Throwable {
        this.f17778a = f3;
        this.f17779b = f4;
        this.f17780c = f5;
        this.f17781d = f6;
        Object objE = e(continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    private FloatingActionButtonElevationAnimatable(float f3, float f4, float f5, float f6) {
        this.f17778a = f3;
        this.f17779b = f4;
        this.f17780c = f5;
        this.f17781d = f6;
        this.f17782e = new Animatable(Dp.d(this.f17778a), VectorConvertersKt.e(Dp.f29970b), null, null, 12, null);
    }
}
