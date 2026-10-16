package androidx.glance.appwidget.action;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.glance.action.ActionParameters;
import androidx.glance.action.ActionParametersKt;
import androidx.glance.action.MutableActionParameters;
import androidx.glance.appwidget.AppWidgetId;
import androidx.glance.appwidget.AppWidgetUtilsKt;
import androidx.glance.appwidget.action.RunCallbackAction;
import com.pairip.VMRunner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ActionCallbackBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f38530a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Intent b(Intent intent, ActionParameters actionParameters) {
            Map mapA = actionParameters.a();
            ArrayList arrayList = new ArrayList(mapA.size());
            for (Map.Entry entry : mapA.entrySet()) {
                ActionParameters.Key key = (ActionParameters.Key) entry.getKey();
                arrayList.add(TuplesKt.a(key.a(), entry.getValue()));
            }
            Pair[] pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
            intent.putExtra("ActionCallbackBroadcastReceiver:parameters", BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
            return intent;
        }

        public final Intent a(Context context, Class cls, int i3, ActionParameters actionParameters) {
            return b(new Intent(context, (Class<?>) ActionCallbackBroadcastReceiver.class).setPackage(context.getPackageName()).putExtra("ActionCallbackBroadcastReceiver:callbackClass", cls.getCanonicalName()).putExtra("ActionCallbackBroadcastReceiver:appWidgetId", i3), actionParameters);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.action.ActionCallbackBroadcastReceiver$onReceive$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    @DebugMetadata(c = "androidx.glance.appwidget.action.ActionCallbackBroadcastReceiver$onReceive$1", f = "ActionCallbackBroadcastReceiver.kt", l = {64}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f38531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Intent f38532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f38533c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Intent intent, Context context, Continuation continuation) {
            super(2, continuation);
            this.f38532b = intent;
            this.f38533c = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f38532b, this.f38533c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f38531a;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Bundle extras = this.f38532b.getExtras();
                    if (extras == null) {
                        throw new IllegalArgumentException("The intent must have action parameters extras.");
                    }
                    Bundle bundle = extras.getBundle("ActionCallbackBroadcastReceiver:parameters");
                    if (bundle == null) {
                        throw new IllegalArgumentException("The intent must contain a parameters bundle using extra: ActionCallbackBroadcastReceiver:parameters");
                    }
                    MutableActionParameters mutableActionParametersB = ActionParametersKt.b(new ActionParameters.Pair[0]);
                    for (String str : bundle.keySet()) {
                        mutableActionParametersB.d(new ActionParameters.Key(str), bundle.get(str));
                    }
                    if (extras.containsKey("android.widget.extra.CHECKED")) {
                        mutableActionParametersB.d(ToggleableKt.a(), Boxing.a(extras.getBoolean("android.widget.extra.CHECKED")));
                    }
                    String string = extras.getString("ActionCallbackBroadcastReceiver:callbackClass");
                    if (string == null) {
                        throw new IllegalArgumentException("The intent must contain a work class name string using extra: ActionCallbackBroadcastReceiver:callbackClass");
                    }
                    if (!this.f38532b.hasExtra("ActionCallbackBroadcastReceiver:appWidgetId")) {
                        throw new IllegalArgumentException("To update the widget, the intent must contain the AppWidgetId integer using extra: ActionCallbackBroadcastReceiver:appWidgetId");
                    }
                    AppWidgetId appWidgetId = new AppWidgetId(extras.getInt("ActionCallbackBroadcastReceiver:appWidgetId"));
                    RunCallbackAction.Companion companion = RunCallbackAction.f38555c;
                    Context context = this.f38533c;
                    this.f38531a = 1;
                    if (companion.a(context, string, appWidgetId, mutableActionParametersB, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
            } catch (CancellationException e3) {
                throw e3;
            } catch (Throwable th) {
                AppWidgetUtilsKt.l(th);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VMRunner.invoke("k0VY3b1dY6yf3y6Y", new Object[]{this, context, intent});
    }
}
