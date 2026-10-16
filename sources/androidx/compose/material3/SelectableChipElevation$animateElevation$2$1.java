package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.MutableState;
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
@DebugMetadata(c = "androidx.compose.material3.SelectableChipElevation$animateElevation$2$1", f = "Chip.kt", l = {2380, 2382}, m = "invokeSuspend")
final class SelectableChipElevation$animateElevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f19819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f19820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f19821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f19822d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Interaction f19823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f19824g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectableChipElevation$animateElevation$2$1(Animatable animatable, float f3, boolean z2, Interaction interaction, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f19820b = animatable;
        this.f19821c = f3;
        this.f19822d = z2;
        this.f19823f = interaction;
        this.f19824g = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SelectableChipElevation$animateElevation$2$1(this.f19820b, this.f19821c, this.f19822d, this.f19823f, this.f19824g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        if (r6.u(r1, r5) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (androidx.compose.material3.internal.ElevationKt.d(r1, r3, r6, r4, r5) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f19819a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            kotlin.ResultKt.b(r6)
            goto L5c
        L1b:
            kotlin.ResultKt.b(r6)
            androidx.compose.animation.core.Animatable r6 = r5.f19820b
            java.lang.Object r6 = r6.l()
            androidx.compose.ui.unit.Dp r6 = (androidx.compose.ui.unit.Dp) r6
            float r6 = r6.l()
            float r1 = r5.f19821c
            boolean r6 = androidx.compose.ui.unit.Dp.i(r6, r1)
            if (r6 != 0) goto L63
            boolean r6 = r5.f19822d
            if (r6 != 0) goto L47
            androidx.compose.animation.core.Animatable r6 = r5.f19820b
            float r1 = r5.f19821c
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.d(r1)
            r5.f19819a = r3
            java.lang.Object r6 = r6.u(r1, r5)
            if (r6 != r0) goto L5c
            goto L5b
        L47:
            androidx.compose.runtime.MutableState r6 = r5.f19824g
            androidx.compose.foundation.interaction.Interaction r6 = androidx.compose.material3.SelectableChipElevation.a(r6)
            androidx.compose.animation.core.Animatable r1 = r5.f19820b
            float r3 = r5.f19821c
            androidx.compose.foundation.interaction.Interaction r4 = r5.f19823f
            r5.f19819a = r2
            java.lang.Object r6 = androidx.compose.material3.internal.ElevationKt.d(r1, r3, r6, r4, r5)
            if (r6 != r0) goto L5c
        L5b:
            return r0
        L5c:
            androidx.compose.runtime.MutableState r6 = r5.f19824g
            androidx.compose.foundation.interaction.Interaction r0 = r5.f19823f
            androidx.compose.material3.SelectableChipElevation.b(r6, r0)
        L63:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SelectableChipElevation$animateElevation$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SelectableChipElevation$animateElevation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
