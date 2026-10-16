package androidx.glance.appwidget;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.appwidget.GlanceAppWidgetReceiver$onReceive$1$1", f = "GlanceAppWidgetReceiver.kt", l = {169}, m = "invokeSuspend")
final class GlanceAppWidgetReceiver$onReceive$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f38028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f38029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GlanceAppWidgetReceiver f38030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f38031d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f38032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f38033g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlanceAppWidgetReceiver$onReceive$1$1(GlanceAppWidgetReceiver glanceAppWidgetReceiver, Context context, int i3, String str, Continuation continuation) {
        super(2, continuation);
        this.f38030c = glanceAppWidgetReceiver;
        this.f38031d = context;
        this.f38032f = i3;
        this.f38033g = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        GlanceAppWidgetReceiver$onReceive$1$1 glanceAppWidgetReceiver$onReceive$1$1 = new GlanceAppWidgetReceiver$onReceive$1$1(this.f38030c, this.f38031d, this.f38032f, this.f38033g, continuation);
        glanceAppWidgetReceiver$onReceive$1$1.f38029b = obj;
        return glanceAppWidgetReceiver$onReceive$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f38028a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f38030c.d((CoroutineScope) this.f38029b, this.f38031d);
            GlanceAppWidget glanceAppWidgetC = this.f38030c.c();
            Context context = this.f38031d;
            int i4 = this.f38032f;
            String str = this.f38033g;
            this.f38028a = 1;
            if (GlanceAppWidget.j(glanceAppWidgetC, context, i4, str, null, this, 8, null) == objF) {
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
        return ((GlanceAppWidgetReceiver$onReceive$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
