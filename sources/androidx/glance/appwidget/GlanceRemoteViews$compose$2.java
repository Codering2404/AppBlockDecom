package androidx.glance.appwidget;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.DpSize;
import androidx.glance.Applier;
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
@DebugMetadata(c = "androidx.glance.appwidget.GlanceRemoteViews$compose$2", f = "GlanceRemoteViews.kt", l = {85, 104}, m = "invokeSuspend")
final class GlanceRemoteViews$compose$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RemoteViewsCompositionResult>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f38048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f38049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f38050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ GlanceRemoteViews f38051d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f38052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ long f38053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Object f38054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Bundle f38055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function2 f38056j;

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceRemoteViews$compose$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.glance.appwidget.GlanceRemoteViews$compose$2$2", f = "GlanceRemoteViews.kt", l = {102}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f38062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Recomposer f38063b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Recomposer recomposer, Continuation continuation) {
            super(2, continuation);
            this.f38063b = recomposer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f38063b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f38062a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Recomposer recomposer = this.f38063b;
                this.f38062a = 1;
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlanceRemoteViews$compose$2(GlanceRemoteViews glanceRemoteViews, Context context, long j3, Object obj, Bundle bundle, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f38051d = glanceRemoteViews;
        this.f38052f = context;
        this.f38053g = j3;
        this.f38054h = obj;
        this.f38055i = bundle;
        this.f38056j = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        GlanceRemoteViews$compose$2 glanceRemoteViews$compose$2 = new GlanceRemoteViews$compose$2(this.f38051d, this.f38052f, this.f38053g, this.f38054h, this.f38055i, this.f38056j, continuation);
        glanceRemoteViews$compose$2.f38050c = obj;
        return glanceRemoteViews$compose$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        Object objB;
        LayoutConfiguration layoutConfiguration;
        RemoteViewsRoot remoteViewsRoot;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f38049b;
        if (i3 == 0) {
            ResultKt.b(obj);
            coroutineScope = (CoroutineScope) this.f38050c;
            GlanceRemoteViews glanceRemoteViews = this.f38051d;
            Context context = this.f38052f;
            this.f38050c = coroutineScope;
            this.f38049b = 1;
            objB = glanceRemoteViews.b(context, this);
            if (objB != objF) {
            }
            return objF;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            RemoteViewsRoot remoteViewsRoot2 = (RemoteViewsRoot) this.f38048a;
            layoutConfiguration = (LayoutConfiguration) this.f38050c;
            ResultKt.b(obj);
            remoteViewsRoot = remoteViewsRoot2;
            LayoutConfiguration layoutConfiguration2 = layoutConfiguration;
            NormalizeCompositionTreeKt.i(remoteViewsRoot);
            return new RemoteViewsCompositionResult(RemoteViewsTranslatorKt.n(this.f38052f, 0, remoteViewsRoot, layoutConfiguration2, layoutConfiguration2.c(remoteViewsRoot), this.f38053g, (64 & 64) != 0 ? null : null));
        }
        coroutineScope = (CoroutineScope) this.f38050c;
        ResultKt.b(obj);
        objB = obj;
        CoroutineScope coroutineScope2 = coroutineScope;
        layoutConfiguration = (LayoutConfiguration) objB;
        RemoteViewsRoot remoteViewsRoot3 = new RemoteViewsRoot(50);
        Applier applier = new Applier(remoteViewsRoot3);
        Recomposer recomposer = new Recomposer(coroutineScope2.getCoroutineContext());
        Composition compositionA = CompositionKt.a(applier, recomposer);
        final Context context2 = this.f38052f;
        final Object obj2 = this.f38054h;
        final Bundle bundle = this.f38055i;
        final long j3 = this.f38053g;
        final Function2 function2 = this.f38056j;
        compositionA.f(ComposableLambdaKt.c(676741397, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.GlanceRemoteViews$compose$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                invoke((Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer, int i4) {
                if ((i4 & 11) == 2 && composer.l()) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(676741397, i4, -1, "androidx.glance.appwidget.GlanceRemoteViews.compose.<anonymous>.<anonymous> (GlanceRemoteViews.kt:90)");
                }
                CompositionLocalKt.c(new ProvidedValue[]{androidx.glance.CompositionLocalsKt.b().d(context2), androidx.glance.CompositionLocalsKt.c().d(GlanceRemoteViewsKt.f38070a), androidx.glance.CompositionLocalsKt.e().d(obj2), CompositionLocalsKt.a().d(bundle), androidx.glance.CompositionLocalsKt.d().d(DpSize.c(j3))}, function2, composer, 8);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        BuildersKt__Builders_commonKt.d(coroutineScope2, null, null, new AnonymousClass2(recomposer, null), 3, null);
        recomposer.k0();
        this.f38050c = layoutConfiguration;
        this.f38048a = remoteViewsRoot3;
        this.f38049b = 2;
        if (recomposer.x0(this) != objF) {
            remoteViewsRoot = remoteViewsRoot3;
            LayoutConfiguration layoutConfiguration22 = layoutConfiguration;
            NormalizeCompositionTreeKt.i(remoteViewsRoot);
            return new RemoteViewsCompositionResult(RemoteViewsTranslatorKt.n(this.f38052f, 0, remoteViewsRoot, layoutConfiguration22, layoutConfiguration22.c(remoteViewsRoot), this.f38053g, (64 & 64) != 0 ? null : null));
        }
        return objF;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GlanceRemoteViews$compose$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
