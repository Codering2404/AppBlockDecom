package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1", f = "TextFieldSelectionState.kt", l = {502, 510}, m = "invokeSuspend")
final class TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f10875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f10876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PressGestureScope f10877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TextFieldSelectionState f10878d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f10879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f10880g;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1", f = "TextFieldSelectionState.kt", l = {494, 499}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextFieldSelectionState f10883c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f10884d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MutableInteractionSource f10885f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextFieldSelectionState textFieldSelectionState, long j3, MutableInteractionSource mutableInteractionSource, Continuation continuation) {
            super(2, continuation);
            this.f10883c = textFieldSelectionState;
            this.f10884d = j3;
            this.f10885f = mutableInteractionSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f10883c, this.f10884d, this.f10885f, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r7.f10882b
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L27
                if (r1 == r4) goto L1f
                if (r1 != r3) goto L17
                java.lang.Object r0 = r7.f10881a
                androidx.compose.foundation.interaction.PressInteraction$Press r0 = (androidx.compose.foundation.interaction.PressInteraction.Press) r0
                kotlin.ResultKt.b(r8)
                goto L5f
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1f:
                java.lang.Object r1 = r7.f10881a
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r1 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r1
                kotlin.ResultKt.b(r8)
                goto L47
            L27:
                kotlin.ResultKt.b(r8)
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r8 = r7.f10883c
                androidx.compose.foundation.interaction.PressInteraction$Press r8 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.i(r8)
                if (r8 == 0) goto L4a
                androidx.compose.foundation.interaction.MutableInteractionSource r1 = r7.f10885f
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r5 = r7.f10883c
                androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                r6.<init>(r8)
                r7.f10881a = r5
                r7.f10882b = r4
                java.lang.Object r8 = r1.a(r6, r7)
                if (r8 != r0) goto L46
                goto L5d
            L46:
                r1 = r5
            L47:
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.v(r1, r2)
            L4a:
                androidx.compose.foundation.interaction.PressInteraction$Press r8 = new androidx.compose.foundation.interaction.PressInteraction$Press
                long r4 = r7.f10884d
                r8.<init>(r4, r2)
                androidx.compose.foundation.interaction.MutableInteractionSource r1 = r7.f10885f
                r7.f10881a = r8
                r7.f10882b = r3
                java.lang.Object r1 = r1.a(r8, r7)
                if (r1 != r0) goto L5e
            L5d:
                return r0
            L5e:
                r0 = r8
            L5f:
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r8 = r7.f10883c
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.v(r8, r0)
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(PressGestureScope pressGestureScope, TextFieldSelectionState textFieldSelectionState, long j3, MutableInteractionSource mutableInteractionSource, Continuation continuation) {
        super(2, continuation);
        this.f10877c = pressGestureScope;
        this.f10878d = textFieldSelectionState;
        this.f10879f = j3;
        this.f10880g = mutableInteractionSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 textFieldSelectionState$detectTextFieldTapGestures$2$1$1 = new TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(this.f10877c, this.f10878d, this.f10879f, this.f10880g, continuation);
        textFieldSelectionState$detectTextFieldTapGestures$2$1$1.f10876b = obj;
        return textFieldSelectionState$detectTextFieldTapGestures$2$1$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
    
        if (r3.a(r12, r11) == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f10875a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r12)
            goto L6b
        L12:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1a:
            kotlin.ResultKt.b(r12)
            goto L45
        L1e:
            kotlin.ResultKt.b(r12)
            java.lang.Object r12 = r11.f10876b
            r4 = r12
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1 r5 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r11.f10878d
            long r7 = r11.f10879f
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r11.f10880g
            r10 = 0
            r5.<init>(r6, r7, r9, r10)
            r8 = 3
            r9 = 0
            r7 = r5
            r5 = 0
            r6 = 0
            kotlinx.coroutines.BuildersKt.d(r4, r5, r6, r7, r8, r9)
            androidx.compose.foundation.gestures.PressGestureScope r12 = r11.f10877c
            r11.f10875a = r3
            java.lang.Object r12 = r12.D0(r11)
            if (r12 != r0) goto L45
            goto L6a
        L45:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r1 = r11.f10878d
            androidx.compose.foundation.interaction.PressInteraction$Press r1 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.i(r1)
            if (r1 == 0) goto L6b
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r11.f10880g
            if (r12 == 0) goto L5d
            androidx.compose.foundation.interaction.PressInteraction$Release r12 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r12.<init>(r1)
            goto L62
        L5d:
            androidx.compose.foundation.interaction.PressInteraction$Cancel r12 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r12.<init>(r1)
        L62:
            r11.f10875a = r2
            java.lang.Object r12 = r3.a(r12, r11)
            if (r12 != r0) goto L6b
        L6a:
            return r0
        L6b:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r12 = r11.f10878d
            r0 = 0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.v(r12, r0)
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TextFieldSelectionState$detectTextFieldTapGestures$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
