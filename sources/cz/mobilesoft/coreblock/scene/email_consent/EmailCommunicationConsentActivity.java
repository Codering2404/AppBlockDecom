package cz.mobilesoft.coreblock.scene.email_consent;

import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.google.common.cache.LSNn.vfptEEmYY;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class EmailCommunicationConsentActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f101711g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f101712h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f101713f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent a(Context context, String consentSource) {
            Intrinsics.checkNotNullParameter(context, vfptEEmYY.pMbZdoKOQ);
            Intrinsics.checkNotNullParameter(consentSource, "consentSource");
            Intent intent = new Intent(context, (Class<?>) EmailCommunicationConsentActivity.class);
            intent.putExtra("email_consent_source", consentSource);
            return intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(EmailCommunicationConsentActivity emailCommunicationConsentActivity) {
        emailCommunicationConsentActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(EmailCommunicationConsentActivity emailCommunicationConsentActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        emailCommunicationConsentActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(1653144015);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1653144015, i4, -1, "cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivity.RootCompose (EmailCommunicationConsentActivity.kt:58)");
            }
            String stringExtra = getIntent().getStringExtra("email_consent_source");
            if (stringExtra == null) {
                stringExtra = "";
            }
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.email_consent.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EmailCommunicationConsentActivity.m0(this.f101730a);
                    }
                };
                composerK.w(objG);
            }
            EmailCommunicationConsentActivityKt.F(stringExtra, (Function0) objG, composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.email_consent.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EmailCommunicationConsentActivity.n0(this.f101731a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f101713f;
    }
}
