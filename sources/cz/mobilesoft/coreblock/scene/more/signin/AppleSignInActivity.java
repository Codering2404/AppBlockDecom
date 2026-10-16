package cz.mobilesoft.coreblock.scene.more.signin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.internal.ServerProtocol;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class AppleSignInActivity extends BaseComposeActivity {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FormInterceptorInterface {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f110353b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f110354c = 8;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f110355d = "function parseForm(form){\n    var values = '';\n    for(var i=0 ; i< form.elements.length; i++){\n        values += \n            form.elements[i].name + \n            '=' + \n            form.elements[i].value + \n            '|'\n    }\n    window.FormInterceptorInterface.processFormData(values);\n}\n\nfor(var i=0 ; i< document.forms.length ; i++){\n    parseForm(document.forms[i]);\n}";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppleSignInActivity f110356a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final String a() {
                return FormInterceptorInterface.f110355d;
            }

            private Companion() {
            }
        }

        public FormInterceptorInterface(AppleSignInActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f110356a = activity;
        }

        @JavascriptInterface
        public final void processFormData(String formData) {
            Object next;
            Intrinsics.checkNotNullParameter(formData, "formData");
            Iterator it = StringsKt.V0(formData, new String[]{"|"}, false, 0, 6, null).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (StringsKt.U((String) next, "code", false, 2, null)) {
                        break;
                    }
                }
            }
            String str = (String) next;
            if (str == null) {
                this.f110356a.o0(null);
            } else {
                this.f110356a.o0(StringsKt.f1(str, "=", null, 2, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView m0(FormInterceptorInterface formInterceptorInterface, Uri uri, AppleSignInActivity appleSignInActivity, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WebView webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(formInterceptorInterface, "FormInterceptorInterface");
        webView.setWebViewClient(new AppleSignInActivity$RootCompose$1$1$1$1(appleSignInActivity));
        webView.loadUrl(uri.toString());
        return webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(AppleSignInActivity appleSignInActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        appleSignInActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(428362227);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(428362227, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.AppleSignInActivity.RootCompose (AppleSignInActivity.kt:24)");
            }
            final Uri uriBuild = Uri.parse("https://appleid.apple.com/auth/authorize").buildUpon().appendQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "code").appendQueryParameter("client_id", "eu.mobilesoft.AppBlockAndroid").appendQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "https://appblock.app/user/success/").appendQueryParameter("scope", AuthenticationTokenClaims.JSON_KEY_EMAIL).appendQueryParameter("response_mode", "form_post").build();
            final FormInterceptorInterface formInterceptorInterface = new FormInterceptorInterface(this);
            boolean zI = composerK.I(formInterceptorInterface) | composerK.I(this) | composerK.I(uriBuild);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AppleSignInActivity.m0(formInterceptorInterface, uriBuild, this, (Context) obj);
                    }
                };
                composerK.w(objG);
            }
            AndroidView_androidKt.a((Function1) objG, SizeKt.f(Modifier.b8, 0.0f, 1, null), null, composerK, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppleSignInActivity.n0(this.f110612a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void o0(String str) {
        Intent intentPutExtra = new Intent().putExtra("APPLE_AUTHORIZATION_CODE", str);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        setResult(-1, intentPutExtra);
        finish();
    }
}
