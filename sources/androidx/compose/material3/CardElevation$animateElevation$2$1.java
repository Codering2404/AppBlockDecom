package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.interaction.Interaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.compose.material3.CardElevation$animateElevation$2$1", f = "Card.kt", l = {731, 741}, m = "invokeSuspend")
final class CardElevation$animateElevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f16190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f16191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f16192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f16193d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ CardElevation f16194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Interaction f16195g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CardElevation$animateElevation$2$1(Animatable animatable, float f3, boolean z2, CardElevation cardElevation, Interaction interaction, Continuation continuation) {
        super(2, continuation);
        this.f16191b = animatable;
        this.f16192c = f3;
        this.f16193d = z2;
        this.f16194f = cardElevation;
        this.f16195g = interaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CardElevation$animateElevation$2$1(this.f16191b, this.f16192c, this.f16193d, this.f16194f, this.f16195g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if (r7.u(r1, r6) == r0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00af, code lost:
    
        if (androidx.compose.material3.internal.ElevationKt.d(r7, r1, r3, r4, r6) == r0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b1, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f16190a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L17:
            kotlin.ResultKt.b(r7)
            goto Lb2
        L1c:
            kotlin.ResultKt.b(r7)
            androidx.compose.animation.core.Animatable r7 = r6.f16191b
            java.lang.Object r7 = r7.l()
            androidx.compose.ui.unit.Dp r7 = (androidx.compose.ui.unit.Dp) r7
            float r7 = r7.l()
            float r1 = r6.f16192c
            boolean r7 = androidx.compose.ui.unit.Dp.i(r7, r1)
            if (r7 != 0) goto Lb2
            boolean r7 = r6.f16193d
            if (r7 != 0) goto L48
            androidx.compose.animation.core.Animatable r7 = r6.f16191b
            float r1 = r6.f16192c
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.d(r1)
            r6.f16190a = r3
            java.lang.Object r7 = r7.u(r1, r6)
            if (r7 != r0) goto Lb2
            goto Lb1
        L48:
            androidx.compose.animation.core.Animatable r7 = r6.f16191b
            java.lang.Object r7 = r7.l()
            androidx.compose.ui.unit.Dp r7 = (androidx.compose.ui.unit.Dp) r7
            float r7 = r7.l()
            androidx.compose.material3.CardElevation r1 = r6.f16194f
            float r1 = androidx.compose.material3.CardElevation.d(r1)
            boolean r1 = androidx.compose.ui.unit.Dp.i(r7, r1)
            r3 = 0
            if (r1 == 0) goto L6e
            androidx.compose.foundation.interaction.PressInteraction$Press r7 = new androidx.compose.foundation.interaction.PressInteraction$Press
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.f25596b
            long r4 = r1.c()
            r7.<init>(r4, r3)
            r3 = r7
            goto La3
        L6e:
            androidx.compose.material3.CardElevation r1 = r6.f16194f
            float r1 = androidx.compose.material3.CardElevation.c(r1)
            boolean r1 = androidx.compose.ui.unit.Dp.i(r7, r1)
            if (r1 == 0) goto L80
            androidx.compose.foundation.interaction.HoverInteraction$Enter r3 = new androidx.compose.foundation.interaction.HoverInteraction$Enter
            r3.<init>()
            goto La3
        L80:
            androidx.compose.material3.CardElevation r1 = r6.f16194f
            float r1 = androidx.compose.material3.CardElevation.b(r1)
            boolean r1 = androidx.compose.ui.unit.Dp.i(r7, r1)
            if (r1 == 0) goto L92
            androidx.compose.foundation.interaction.FocusInteraction$Focus r3 = new androidx.compose.foundation.interaction.FocusInteraction$Focus
            r3.<init>()
            goto La3
        L92:
            androidx.compose.material3.CardElevation r1 = r6.f16194f
            float r1 = androidx.compose.material3.CardElevation.a(r1)
            boolean r7 = androidx.compose.ui.unit.Dp.i(r7, r1)
            if (r7 == 0) goto La3
            androidx.compose.foundation.interaction.DragInteraction$Start r3 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r3.<init>()
        La3:
            androidx.compose.animation.core.Animatable r7 = r6.f16191b
            float r1 = r6.f16192c
            androidx.compose.foundation.interaction.Interaction r4 = r6.f16195g
            r6.f16190a = r2
            java.lang.Object r7 = androidx.compose.material3.internal.ElevationKt.d(r7, r1, r3, r4, r6)
            if (r7 != r0) goto Lb2
        Lb1:
            return r0
        Lb2:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardElevation$animateElevation$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CardElevation$animateElevation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
