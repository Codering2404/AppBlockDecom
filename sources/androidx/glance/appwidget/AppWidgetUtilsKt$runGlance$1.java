package androidx.glance.appwidget;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.glance.GlanceId;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;

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
@DebugMetadata(c = "androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1", f = "AppWidgetUtils.kt", l = {252}, m = "invokeSuspend")
final class AppWidgetUtilsKt$runGlance$1 extends SuspendLambda implements Function2<ProducerScope<? super Function2<? super Composer, ? super Integer, ? extends Unit>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f37771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f37772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GlanceAppWidget f37773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f37774d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ GlanceId f37775f;

    /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$1", f = "AppWidgetUtils.kt", l = {252}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f37776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GlanceAppWidget f37777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f37778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ GlanceId f37779d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GlanceAppWidget glanceAppWidget, Context context, GlanceId glanceId, Continuation continuation) {
            super(2, continuation);
            this.f37777b = glanceAppWidget;
            this.f37778c = context;
            this.f37779d = glanceId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f37777b, this.f37778c, this.f37779d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f37776a;
            if (i3 == 0) {
                ResultKt.b(obj);
                GlanceAppWidget glanceAppWidget = this.f37777b;
                Context context = this.f37778c;
                GlanceId glanceId = this.f37779d;
                this.f37776a = 1;
                if (glanceAppWidget.g(context, glanceId, this) == objF) {
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
    AppWidgetUtilsKt$runGlance$1(GlanceAppWidget glanceAppWidget, Context context, GlanceId glanceId, Continuation continuation) {
        super(2, continuation);
        this.f37773c = glanceAppWidget;
        this.f37774d = context;
        this.f37775f = glanceId;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AppWidgetUtilsKt$runGlance$1 appWidgetUtilsKt$runGlance$1 = new AppWidgetUtilsKt$runGlance$1(this.f37773c, this.f37774d, this.f37775f, continuation);
        appWidgetUtilsKt$runGlance$1.f37772b = obj;
        return appWidgetUtilsKt$runGlance$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((AppWidgetUtilsKt$runGlance$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f37771a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AppWidgetUtilsKt$runGlance$1$receiver$1 appWidgetUtilsKt$runGlance$1$receiver$1 = new AppWidgetUtilsKt$runGlance$1$receiver$1(new AtomicReference(null), (ProducerScope) this.f37772b);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f37773c, this.f37774d, this.f37775f, null);
            this.f37771a = 1;
            if (BuildersKt.g(appWidgetUtilsKt$runGlance$1$receiver$1, anonymousClass1, this) == objF) {
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
