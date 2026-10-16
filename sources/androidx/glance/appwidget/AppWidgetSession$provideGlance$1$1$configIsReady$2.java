package androidx.glance.appwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProduceStateScope;
import androidx.glance.state.ConfigManager;
import androidx.glance.state.GlanceStateDefinition;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.appwidget.AppWidgetSession$provideGlance$1$1$configIsReady$2", f = "AppWidgetSession.kt", l = {103}, m = "invokeSuspend")
final class AppWidgetSession$provideGlance$1$1$configIsReady$2 extends SuspendLambda implements Function2<ProduceStateScope<Boolean>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f37761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f37762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f37763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppWidgetSession f37764d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AppWidgetManager f37765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Context f37766g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppWidgetSession$provideGlance$1$1$configIsReady$2(AppWidgetSession appWidgetSession, AppWidgetManager appWidgetManager, Context context, Continuation continuation) {
        super(2, continuation);
        this.f37764d = appWidgetSession;
        this.f37765f = appWidgetManager;
        this.f37766g = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AppWidgetSession$provideGlance$1$1$configIsReady$2 appWidgetSession$provideGlance$1$1$configIsReady$2 = new AppWidgetSession$provideGlance$1$1$configIsReady$2(this.f37764d, this.f37765f, this.f37766g, continuation);
        appWidgetSession$provideGlance$1$1$configIsReady$2.f37763c = obj;
        return appWidgetSession$provideGlance$1$1$configIsReady$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProduceStateScope produceStateScope, Continuation continuation) {
        return ((AppWidgetSession$provideGlance$1$1$configIsReady$2) create(produceStateScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ProduceStateScope produceStateScope;
        MutableState mutableState;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f37762b;
        if (i3 == 0) {
            ResultKt.b(obj);
            produceStateScope = (ProduceStateScope) this.f37763c;
            MutableState mutableState2 = this.f37764d.f37739h;
            Bundle appWidgetOptions = this.f37764d.f37736e;
            if (appWidgetOptions == null) {
                appWidgetOptions = this.f37765f.getAppWidgetOptions(this.f37764d.f37735d.a());
            }
            mutableState2.setValue(appWidgetOptions);
            GlanceStateDefinition glanceStateDefinitionD = this.f37764d.f37734c.d();
            if (glanceStateDefinitionD != null) {
                AppWidgetSession appWidgetSession = this.f37764d;
                Context context = this.f37766g;
                MutableState mutableState3 = appWidgetSession.f37738g;
                ConfigManager configManager = appWidgetSession.f37737f;
                String strC = appWidgetSession.c();
                this.f37763c = produceStateScope;
                this.f37761a = mutableState3;
                this.f37762b = 1;
                obj = configManager.a(context, glanceStateDefinitionD, strC, this);
                if (obj == objF) {
                    return objF;
                }
                mutableState = mutableState3;
            }
            produceStateScope.setValue(Boxing.a(true));
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableState = (MutableState) this.f37761a;
        produceStateScope = (ProduceStateScope) this.f37763c;
        ResultKt.b(obj);
        mutableState.setValue(obj);
        produceStateScope.setValue(Boxing.a(true));
        return Unit.f139807a;
    }
}
