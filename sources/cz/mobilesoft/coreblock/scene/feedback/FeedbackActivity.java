package cz.mobilesoft.coreblock.scene.feedback;

import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
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
public final class FeedbackActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f102045f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f102046g = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, ContactReason contactReason, Integer num, String str, String str2, String str3, boolean z2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                contactReason = null;
            }
            if ((i3 & 4) != 0) {
                num = null;
            }
            if ((i3 & 8) != 0) {
                str = null;
            }
            if ((i3 & 32) != 0) {
                str3 = null;
            }
            if ((i3 & 64) != 0) {
                z2 = false;
            }
            return companion.a(context, contactReason, num, str, str2, str3, z2);
        }

        public final Intent a(Context context, ContactReason contactReason, Integer num, String str, String entrances, String str2, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(entrances, "entrances");
            Intent intent = new Intent(context, (Class<?>) FeedbackActivity.class);
            intent.addFlags(67108864);
            intent.putExtra("SELECTED_CONTACT_REASON", contactReason);
            intent.putExtra("QUESTION_ID", num);
            intent.putExtra("QUESTION_SLUG", str);
            intent.putExtra("EVENT_ENTRANCES", entrances);
            intent.putExtra("CHATBOT_URL", str2);
            intent.putExtra("IS_FROM_RATING_DIALOG", z2);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(FeedbackActivity feedbackActivity) {
        AnswersHelper.f128199a.n5();
        feedbackActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(FeedbackActivity feedbackActivity) {
        feedbackActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(FeedbackActivity feedbackActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        feedbackActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-814684073);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-814684073, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.FeedbackActivity.RootCompose (FeedbackActivity.kt:38)");
            }
            ContactReason contactReason = (ContactReason) getIntent().getSerializableExtra("SELECTED_CONTACT_REASON");
            boolean booleanExtra = getIntent().getBooleanExtra("IS_FROM_SHORTCUT", false);
            boolean booleanExtra2 = getIntent().getBooleanExtra("IS_FROM_RATING_DIALOG", false);
            int intExtra = getIntent().getIntExtra("QUESTION_ID", -1);
            String stringExtra = getIntent().getStringExtra("QUESTION_SLUG");
            String stringExtra2 = getIntent().getStringExtra("EVENT_ENTRANCES");
            String stringExtra3 = getIntent().getStringExtra("CHATBOT_URL");
            Unit unit = Unit.f139807a;
            boolean zB = composerK.b(booleanExtra) | composerK.Z(stringExtra2) | composerK.Z(stringExtra) | composerK.e(intExtra);
            Object objG = composerK.G();
            if (zB || objG == Composer.f23746a.a()) {
                FeedbackActivity$RootCompose$1$1 feedbackActivity$RootCompose$1$1 = new FeedbackActivity$RootCompose$1$1(booleanExtra, stringExtra2, stringExtra, intExtra, null);
                composerK.w(feedbackActivity$RootCompose$1$1);
                objG = feedbackActivity$RootCompose$1$1;
            }
            EffectsKt.g(unit, (Function2) objG, composerK, 6);
            boolean zI = composerK.I(this);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FeedbackActivity.n0(this.f102299a);
                    }
                };
                composerK.w(objG2);
            }
            Function0 function0 = (Function0) objG2;
            boolean zI2 = composerK.I(this);
            Object objG3 = composerK.G();
            if (zI2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FeedbackActivity.o0(this.f102308a);
                    }
                };
                composerK.w(objG3);
            }
            FeedbackScreenKt.n0(contactReason, booleanExtra, booleanExtra2, function0, stringExtra3, stringExtra2, (Function0) objG3, composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackActivity.p0(this.f102316a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
