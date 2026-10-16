package androidx.glance.appwidget.action;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import androidx.compose.ui.unit.DpSize;
import androidx.glance.appwidget.TranslationContext;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

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
public final class ActionTrampolineKt {
    public static final void a(Function0 function0) {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(Build.VERSION.SDK_INT >= 31 ? StrictModeVmPolicyApi31Impl.f38572a.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build() : new StrictMode.VmPolicy.Builder().build());
        function0.invoke();
        StrictMode.setVmPolicy(vmPolicy);
    }

    public static final Intent b(Intent intent, TranslationContext translationContext, int i3, ActionTrampolineType actionTrampolineType, Bundle bundle) {
        Intent intent2 = new Intent(translationContext.n(), (Class<?>) (actionTrampolineType == ActionTrampolineType.ACTIVITY ? ActionTrampolineActivity.class : InvisibleActionTrampolineActivity.class));
        intent2.setData(e(translationContext, i3, actionTrampolineType, null, 8, null));
        intent2.putExtra(ShareConstants.ACTION_TYPE, actionTrampolineType.name());
        intent2.putExtra("ACTION_INTENT", intent);
        if (bundle != null) {
            intent2.putExtra("ACTIVITY_OPTIONS", bundle);
        }
        return intent2;
    }

    public static /* synthetic */ Intent c(Intent intent, TranslationContext translationContext, int i3, ActionTrampolineType actionTrampolineType, Bundle bundle, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            bundle = null;
        }
        return b(intent, translationContext, i3, actionTrampolineType, bundle);
    }

    public static final Uri d(TranslationContext translationContext, int i3, ActionTrampolineType actionTrampolineType, String str) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("glance-action");
        builder.path(actionTrampolineType.name());
        builder.appendQueryParameter("appWidgetId", String.valueOf(translationContext.l()));
        builder.appendQueryParameter("viewId", String.valueOf(i3));
        builder.appendQueryParameter("viewSize", DpSize.l(translationContext.s()));
        builder.appendQueryParameter("extraData", str);
        if (translationContext.v()) {
            builder.appendQueryParameter("lazyCollection", String.valueOf(translationContext.q()));
            builder.appendQueryParameter("lazeViewItem", String.valueOf(translationContext.p()));
        }
        return builder.build();
    }

    public static /* synthetic */ Uri e(TranslationContext translationContext, int i3, ActionTrampolineType actionTrampolineType, String str, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            str = "";
        }
        return d(translationContext, i3, actionTrampolineType, str);
    }

    public static final void f(final Activity activity, Intent intent) {
        Parcelable parcelableExtra = intent.getParcelableExtra("ACTION_INTENT");
        if (parcelableExtra == null) {
            throw new IllegalArgumentException("List adapter activity trampoline invoked without specifying target intent.");
        }
        final Intent intent2 = (Intent) parcelableExtra;
        if (intent.hasExtra("android.widget.extra.CHECKED")) {
            intent2.putExtra("android.widget.extra.CHECKED", intent.getBooleanExtra("android.widget.extra.CHECKED", false));
        }
        final String stringExtra = intent.getStringExtra(ShareConstants.ACTION_TYPE);
        if (stringExtra == null) {
            throw new IllegalArgumentException("List adapter activity trampoline invoked without trampoline type");
        }
        final Bundle bundleExtra = intent.getBundleExtra("ACTIVITY_OPTIONS");
        a(new Function0<Unit>() { // from class: androidx.glance.appwidget.action.ActionTrampolineKt$launchTrampolineAction$1

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f38538a;

                static {
                    int[] iArr = new int[ActionTrampolineType.values().length];
                    try {
                        iArr[ActionTrampolineType.ACTIVITY.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ActionTrampolineType.BROADCAST.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ActionTrampolineType.CALLBACK.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[ActionTrampolineType.SERVICE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[ActionTrampolineType.FOREGROUND_SERVICE.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f38538a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m346invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m346invoke() {
                int i3 = WhenMappings.f38538a[ActionTrampolineType.valueOf(stringExtra).ordinal()];
                if (i3 == 1) {
                    activity.startActivity(intent2, bundleExtra);
                    return;
                }
                if (i3 == 2 || i3 == 3) {
                    activity.sendBroadcast(intent2);
                } else if (i3 == 4) {
                    activity.startService(intent2);
                } else {
                    if (i3 != 5) {
                        return;
                    }
                    ListAdapterTrampolineApi26Impl.f38554a.a(activity, intent2);
                }
            }
        });
        activity.finish();
    }
}
