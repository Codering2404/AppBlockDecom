package androidx.compose.material3;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$1", f = "ExposedDropdownMenu.android.kt", l = {1426}, m = "invokeSuspend")
final class ExposedDropdownMenu_androidKt$expandable$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f17679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f17680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f17681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f17682d;

    /* JADX INFO: renamed from: androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$1$1", f = "ExposedDropdownMenu.android.kt", l = {1430, 1434}, m = "invokeSuspend")
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f17684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0 f17686d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.f17685c = str;
            this.f17686d = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f17685c, this.f17686d, continuation);
            anonymousClass1.f17684b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
        
            if (r11 == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r10.f17683a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.ResultKt.b(r11)
                r7 = r10
                goto L5f
            L13:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1b:
                java.lang.Object r1 = r10.f17684b
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.b(r11)
                r7 = r10
                goto L3e
            L24:
                kotlin.ResultKt.b(r11)
                java.lang.Object r11 = r10.f17684b
                r4 = r11
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                androidx.compose.ui.input.pointer.PointerEventPass r6 = androidx.compose.ui.input.pointer.PointerEventPass.f26830a
                r10.f17684b = r4
                r10.f17683a = r3
                r5 = 0
                r8 = 1
                r9 = 0
                r7 = r10
                java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.f(r4, r5, r6, r7, r8, r9)
                if (r11 != r0) goto L3d
                goto L5e
            L3d:
                r1 = r4
            L3e:
                androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                java.lang.String r3 = r7.f17685c
                androidx.compose.material3.MenuAnchorType$Companion r4 = androidx.compose.material3.MenuAnchorType.f18132b
                java.lang.String r4 = r4.c()
                boolean r3 = androidx.compose.material3.MenuAnchorType.g(r3, r4)
                if (r3 == 0) goto L51
                r11.a()
            L51:
                androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.f26830a
                r3 = 0
                r7.f17684b = r3
                r7.f17683a = r2
                java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.u(r1, r11, r10)
                if (r11 != r0) goto L5f
            L5e:
                return r0
            L5f:
                androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                if (r11 == 0) goto L68
                kotlin.jvm.functions.Function0 r11 = r7.f17686d
                r11.invoke()
            L68:
                kotlin.Unit r11 = kotlin.Unit.f139807a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenu_androidKt$expandable$1(String str, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f17681c = str;
        this.f17682d = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ExposedDropdownMenu_androidKt$expandable$1 exposedDropdownMenu_androidKt$expandable$1 = new ExposedDropdownMenu_androidKt$expandable$1(this.f17681c, this.f17682d, continuation);
        exposedDropdownMenu_androidKt$expandable$1.f17680b = obj;
        return exposedDropdownMenu_androidKt$expandable$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((ExposedDropdownMenu_androidKt$expandable$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f17679a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.f17680b;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f17681c, this.f17682d, null);
            this.f17679a = 1;
            if (ForEachGestureKt.e(pointerInputScope, anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}
