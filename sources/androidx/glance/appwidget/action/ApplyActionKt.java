package androidx.glance.appwidget.action;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.os.BundleKt;
import androidx.glance.action.Action;
import androidx.glance.action.ActionParameters;
import androidx.glance.action.ActionParametersKt;
import androidx.glance.action.LambdaAction;
import androidx.glance.action.MutableActionParameters;
import androidx.glance.action.StartActivityAction;
import androidx.glance.action.StartActivityClassAction;
import androidx.glance.action.StartActivityComponentAction;
import androidx.glance.appwidget.TranslationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class ApplyActionKt {
    public static final void a(TranslationContext translationContext, RemoteViews remoteViews, Action action, int i3) {
        Integer numK = translationContext.k();
        if (numK != null) {
            i3 = numK.intValue();
        }
        int i4 = i3;
        try {
            try {
                if (translationContext.v()) {
                    Intent intentE = e(action, translationContext, i4, null, 8, null);
                    if (!(action instanceof CompoundButtonAction) || Build.VERSION.SDK_INT < 31) {
                        remoteViews.setOnClickFillInIntent(i4, intentE);
                        return;
                    } else {
                        ApplyActionApi31Impl.f38547a.b(remoteViews, i4, intentE);
                        return;
                    }
                }
                PendingIntent pendingIntentG = g(action, translationContext, i4, null, 8, null);
                if (!(action instanceof CompoundButtonAction) || Build.VERSION.SDK_INT < 31) {
                    remoteViews.setOnClickPendingIntent(i4, pendingIntentG);
                } else {
                    ApplyActionApi31Impl.f38547a.a(remoteViews, i4, pendingIntentG);
                }
            } catch (Throwable th) {
                th = th;
                Log.e("GlanceAppWidget", "Unrecognized Action: " + action, th);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static final Function1 b(final CompoundButtonAction compoundButtonAction) {
        return new Function1<ActionParameters, ActionParameters>() { // from class: androidx.glance.appwidget.action.ApplyActionKt$getActionParameters$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ActionParameters invoke(ActionParameters actionParameters) {
                if (Build.VERSION.SDK_INT >= 31) {
                    return actionParameters;
                }
                MutableActionParameters mutableActionParametersC = ActionParametersKt.c(actionParameters);
                mutableActionParametersC.d(ToggleableKt.a(), Boolean.valueOf(!compoundButtonAction.c()));
                return mutableActionParametersC;
            }
        };
    }

    private static final Intent c(SendBroadcastAction sendBroadcastAction, TranslationContext translationContext) {
        if (sendBroadcastAction instanceof SendBroadcastComponentAction) {
            return new Intent().setComponent(((SendBroadcastComponentAction) sendBroadcastAction).c());
        }
        if (sendBroadcastAction instanceof SendBroadcastClassAction) {
            return new Intent(translationContext.n(), (Class<?>) ((SendBroadcastClassAction) sendBroadcastAction).c());
        }
        if (sendBroadcastAction instanceof SendBroadcastIntentAction) {
            return ((SendBroadcastIntentAction) sendBroadcastAction).c();
        }
        if (!(sendBroadcastAction instanceof SendBroadcastActionAction)) {
            throw new NoWhenBranchMatchedException();
        }
        SendBroadcastActionAction sendBroadcastActionAction = (SendBroadcastActionAction) sendBroadcastAction;
        return new Intent(sendBroadcastActionAction.c()).setComponent(sendBroadcastActionAction.d());
    }

    private static final Intent d(Action action, TranslationContext translationContext, int i3, Function1 function1) {
        if (action instanceof StartActivityAction) {
            StartActivityAction startActivityAction = (StartActivityAction) action;
            return ActionTrampolineKt.b(i(startActivityAction, translationContext, (ActionParameters) function1.invoke(startActivityAction.getParameters())), translationContext, i3, ActionTrampolineType.ACTIVITY, startActivityAction.a());
        }
        if (action instanceof StartServiceAction) {
            StartServiceAction startServiceAction = (StartServiceAction) action;
            return ActionTrampolineKt.c(h(startServiceAction, translationContext), translationContext, i3, startServiceAction.b() ? ActionTrampolineType.FOREGROUND_SERVICE : ActionTrampolineType.SERVICE, null, 8, null);
        }
        if (action instanceof SendBroadcastAction) {
            return ActionTrampolineKt.c(c((SendBroadcastAction) action, translationContext), translationContext, i3, ActionTrampolineType.BROADCAST, null, 8, null);
        }
        if (action instanceof RunCallbackAction) {
            RunCallbackAction runCallbackAction = (RunCallbackAction) action;
            return ActionTrampolineKt.c(ActionCallbackBroadcastReceiver.f38530a.a(translationContext.n(), runCallbackAction.c(), translationContext.l(), (ActionParameters) function1.invoke(runCallbackAction.getParameters())), translationContext, i3, ActionTrampolineType.BROADCAST, null, 8, null);
        }
        if (action instanceof LambdaAction) {
            if (translationContext.j() != null) {
                return ActionTrampolineKt.c(LambdaActionBroadcasts.f38553a.a(translationContext.j(), ((LambdaAction) action).d(), translationContext.l()), translationContext, i3, ActionTrampolineType.BROADCAST, null, 8, null);
            }
            throw new IllegalArgumentException("In order to use LambdaAction, actionBroadcastReceiver must be provided");
        }
        if (action instanceof CompoundButtonAction) {
            CompoundButtonAction compoundButtonAction = (CompoundButtonAction) action;
            return d(compoundButtonAction.d(), translationContext, i3, b(compoundButtonAction));
        }
        throw new IllegalStateException(("Cannot create fill-in Intent for action type: " + action).toString());
    }

    static /* synthetic */ Intent e(Action action, TranslationContext translationContext, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            function1 = new Function1<ActionParameters, ActionParameters>() { // from class: androidx.glance.appwidget.action.ApplyActionKt$getFillInIntentForAction$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ActionParameters invoke(ActionParameters actionParameters) {
                    return actionParameters;
                }
            };
        }
        return d(action, translationContext, i3, function1);
    }

    private static final PendingIntent f(Action action, TranslationContext translationContext, int i3, Function1 function1) {
        if (action instanceof StartActivityAction) {
            StartActivityAction startActivityAction = (StartActivityAction) action;
            ActionParameters actionParameters = (ActionParameters) function1.invoke(startActivityAction.getParameters());
            Context contextN = translationContext.n();
            Intent intentI = i(startActivityAction, translationContext, actionParameters);
            if (intentI.getData() == null) {
                intentI.setData(ActionTrampolineKt.e(translationContext, i3, ActionTrampolineType.CALLBACK, null, 8, null));
            }
            Unit unit = Unit.f139807a;
            return PendingIntent.getActivity(contextN, 0, intentI, 167772160, startActivityAction.a());
        }
        if (action instanceof StartServiceAction) {
            StartServiceAction startServiceAction = (StartServiceAction) action;
            Intent intentH = h(startServiceAction, translationContext);
            if (intentH.getData() == null) {
                intentH.setData(ActionTrampolineKt.e(translationContext, i3, ActionTrampolineType.CALLBACK, null, 8, null));
            }
            return startServiceAction.b() ? ApplyActionApi26Impl.f38545a.a(translationContext.n(), intentH) : PendingIntent.getService(translationContext.n(), 0, intentH, 167772160);
        }
        if (action instanceof SendBroadcastAction) {
            Context contextN2 = translationContext.n();
            Intent intentC = c((SendBroadcastAction) action, translationContext);
            if (intentC.getData() == null) {
                intentC.setData(ActionTrampolineKt.e(translationContext, i3, ActionTrampolineType.CALLBACK, null, 8, null));
            }
            Unit unit2 = Unit.f139807a;
            return PendingIntent.getBroadcast(contextN2, 0, intentC, 167772160);
        }
        if (action instanceof RunCallbackAction) {
            Context contextN3 = translationContext.n();
            RunCallbackAction runCallbackAction = (RunCallbackAction) action;
            Intent intentA = ActionCallbackBroadcastReceiver.f38530a.a(translationContext.n(), runCallbackAction.c(), translationContext.l(), (ActionParameters) function1.invoke(runCallbackAction.getParameters()));
            intentA.setData(ActionTrampolineKt.e(translationContext, i3, ActionTrampolineType.CALLBACK, null, 8, null));
            Unit unit3 = Unit.f139807a;
            return PendingIntent.getBroadcast(contextN3, 0, intentA, 167772160);
        }
        if (!(action instanceof LambdaAction)) {
            if (action instanceof CompoundButtonAction) {
                CompoundButtonAction compoundButtonAction = (CompoundButtonAction) action;
                return f(compoundButtonAction.d(), translationContext, i3, b(compoundButtonAction));
            }
            throw new IllegalStateException(("Cannot create PendingIntent for action type: " + action).toString());
        }
        if (translationContext.j() == null) {
            throw new IllegalArgumentException("In order to use LambdaAction, actionBroadcastReceiver must be provided");
        }
        Context contextN4 = translationContext.n();
        LambdaAction lambdaAction = (LambdaAction) action;
        Intent intentA2 = LambdaActionBroadcasts.f38553a.a(translationContext.j(), lambdaAction.d(), translationContext.l());
        intentA2.setData(ActionTrampolineKt.d(translationContext, i3, ActionTrampolineType.CALLBACK, lambdaAction.d()));
        Unit unit4 = Unit.f139807a;
        return PendingIntent.getBroadcast(contextN4, 0, intentA2, 167772160);
    }

    static /* synthetic */ PendingIntent g(Action action, TranslationContext translationContext, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            function1 = new Function1<ActionParameters, ActionParameters>() { // from class: androidx.glance.appwidget.action.ApplyActionKt$getPendingIntentForAction$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ActionParameters invoke(ActionParameters actionParameters) {
                    return actionParameters;
                }
            };
        }
        return f(action, translationContext, i3, function1);
    }

    private static final Intent h(StartServiceAction startServiceAction, TranslationContext translationContext) {
        if (startServiceAction instanceof StartServiceComponentAction) {
            return new Intent().setComponent(((StartServiceComponentAction) startServiceAction).c());
        }
        if (startServiceAction instanceof StartServiceClassAction) {
            return new Intent(translationContext.n(), (Class<?>) ((StartServiceClassAction) startServiceAction).c());
        }
        if (startServiceAction instanceof StartServiceIntentAction) {
            return ((StartServiceIntentAction) startServiceAction).c();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Intent i(StartActivityAction startActivityAction, TranslationContext translationContext, ActionParameters actionParameters) {
        Intent intentC;
        if (startActivityAction instanceof StartActivityComponentAction) {
            intentC = new Intent().setComponent(((StartActivityComponentAction) startActivityAction).c());
        } else if (startActivityAction instanceof StartActivityClassAction) {
            intentC = new Intent(translationContext.n(), (Class<?>) ((StartActivityClassAction) startActivityAction).c());
        } else {
            if (!(startActivityAction instanceof StartActivityIntentAction)) {
                throw new IllegalStateException(("Action type not defined in app widget package: " + startActivityAction).toString());
            }
            intentC = ((StartActivityIntentAction) startActivityAction).c();
        }
        Map mapA = actionParameters.a();
        ArrayList arrayList = new ArrayList(mapA.size());
        for (Map.Entry entry : mapA.entrySet()) {
            arrayList.add(TuplesKt.a(((ActionParameters.Key) entry.getKey()).a(), entry.getValue()));
        }
        Pair[] pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        intentC.putExtras(BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        return intentC;
    }
}
