package androidx.glance.appwidget;

import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.appwidget.AppWidgetComposerKt$compose$3", f = "AppWidgetComposer.kt", l = {87}, m = "invokeSuspend")
final class AppWidgetComposerKt$compose$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f37717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f37718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Recomposer f37719c;

    /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetComposerKt$compose$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.glance.appwidget.AppWidgetComposerKt$compose$3$1", f = "AppWidgetComposer.kt", l = {85}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f37720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Recomposer f37721b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Recomposer recomposer, Continuation continuation) {
            super(2, continuation);
            this.f37721b = recomposer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f37721b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f37720a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Recomposer recomposer = this.f37721b;
                this.f37720a = 1;
                if (recomposer.N0(this) == objF) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppWidgetComposerKt$compose$3(Recomposer recomposer, Continuation continuation) {
        super(2, continuation);
        this.f37719c = recomposer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AppWidgetComposerKt$compose$3 appWidgetComposerKt$compose$3 = new AppWidgetComposerKt$compose$3(this.f37719c, continuation);
        appWidgetComposerKt$compose$3.f37718b = obj;
        return appWidgetComposerKt$compose$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f37717a;
        if (i3 == 0) {
            ResultKt.b(obj);
            BuildersKt__Builders_commonKt.d((CoroutineScope) this.f37718b, null, null, new AnonymousClass1(this.f37719c, null), 3, null);
            this.f37719c.k0();
            Recomposer recomposer = this.f37719c;
            this.f37717a = 1;
            if (recomposer.x0(this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppWidgetComposerKt$compose$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
