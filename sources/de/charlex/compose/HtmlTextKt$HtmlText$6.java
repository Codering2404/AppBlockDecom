package de.charlex.compose;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "de.charlex.compose.HtmlTextKt$HtmlText$6", f = "HtmlText.kt", l = {228}, m = "invokeSuspend")
final class HtmlTextKt$HtmlText$6 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f134433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f134434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f134435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AnnotatedString f134436d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ UriHandler f134437f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HtmlTextKt$HtmlText$6(MutableState mutableState, AnnotatedString annotatedString, UriHandler uriHandler, Continuation continuation) {
        super(2, continuation);
        this.f134435c = mutableState;
        this.f134436d = annotatedString;
        this.f134437f = uriHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        HtmlTextKt$HtmlText$6 htmlTextKt$HtmlText$6 = new HtmlTextKt$HtmlText$6(this.f134435c, this.f134436d, this.f134437f, continuation);
        htmlTextKt$HtmlText$6.f134434b = obj;
        return htmlTextKt$HtmlText$6;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((HtmlTextKt$HtmlText$6) create(pointerInputScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f134433a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.f134434b;
            final MutableState mutableState = this.f134435c;
            final AnnotatedString annotatedString = this.f134436d;
            final UriHandler uriHandler = this.f134437f;
            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: de.charlex.compose.HtmlTextKt$HtmlText$6.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(long j3) {
                    TextLayoutResult textLayoutResult = (TextLayoutResult) mutableState.getValue();
                    if (textLayoutResult != null) {
                        AnnotatedString annotatedString2 = annotatedString;
                        UriHandler uriHandler2 = uriHandler;
                        int iX = textLayoutResult.x(j3);
                        AnnotatedString.Range range = (AnnotatedString.Range) CollectionsKt.firstOrNull(annotatedString2.i(iX, iX));
                        if (range == null || !Intrinsics.areEqual(range.i(), "url")) {
                            return;
                        }
                        uriHandler2.openUri((String) range.g());
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c(((Offset) obj2).u());
                    return Unit.f139807a;
                }
            };
            this.f134433a = 1;
            if (TapGestureDetectorKt.m(pointerInputScope, null, null, null, function1, this, 7, null) == objF) {
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
