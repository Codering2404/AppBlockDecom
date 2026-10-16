package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.MutableFloatState;
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
@DebugMetadata(c = "androidx.compose.material3.SearchBar_androidKt$SearchBar$1$1", f = "SearchBar.android.kt", l = {191}, m = "invokeSuspend")
final class SearchBar_androidKt$SearchBar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f19574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f19575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f19576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableFloatState f19577d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f19578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f19579g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBar$1$1(Animatable animatable, boolean z2, MutableFloatState mutableFloatState, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.f19575b = animatable;
        this.f19576c = z2;
        this.f19577d = mutableFloatState;
        this.f19578f = mutableState;
        this.f19579g = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SearchBar_androidKt$SearchBar$1$1(this.f19575b, this.f19576c, this.f19577d, this.f19578f, this.f19579g, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f19574a
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.b(r13)
            goto L66
        Lf:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L17:
            kotlin.ResultKt.b(r13)
            androidx.compose.animation.core.Animatable r13 = r12.f19575b
            java.lang.Object r13 = r13.n()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            r1 = 0
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r13 <= 0) goto L43
            androidx.compose.animation.core.Animatable r13 = r12.f19575b
            java.lang.Object r13 = r13.n()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 >= 0) goto L43
            androidx.compose.animation.core.FiniteAnimationSpec r13 = androidx.compose.material3.SearchBar_androidKt.o()
        L41:
            r6 = r13
            goto L51
        L43:
            boolean r13 = r12.f19576c
            if (r13 == 0) goto L4c
            androidx.compose.animation.core.FiniteAnimationSpec r13 = androidx.compose.material3.SearchBar_androidKt.m()
            goto L41
        L4c:
            androidx.compose.animation.core.FiniteAnimationSpec r13 = androidx.compose.material3.SearchBar_androidKt.n()
            goto L41
        L51:
            boolean r13 = r12.f19576c
            if (r13 == 0) goto L56
            r1 = r3
        L56:
            androidx.compose.animation.core.Animatable r13 = r12.f19575b
            java.lang.Object r13 = r13.n()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 != 0) goto L68
        L66:
            r9 = r12
            goto L7d
        L68:
            androidx.compose.animation.core.Animatable r4 = r12.f19575b
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.c(r1)
            r12.f19574a = r2
            r7 = 0
            r8 = 0
            r10 = 12
            r11 = 0
            r9 = r12
            java.lang.Object r13 = androidx.compose.animation.core.Animatable.f(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r13 != r0) goto L7d
            return r0
        L7d:
            boolean r13 = r9.f19576c
            if (r13 != 0) goto L93
            androidx.compose.runtime.MutableFloatState r13 = r9.f19577d
            r0 = 2143289344(0x7fc00000, float:NaN)
            r13.s(r0)
            androidx.compose.runtime.MutableState r13 = r9.f19578f
            r0 = 0
            r13.setValue(r0)
            androidx.compose.runtime.MutableState r13 = r9.f19579g
            r13.setValue(r0)
        L93:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt$SearchBar$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SearchBar_androidKt$SearchBar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
