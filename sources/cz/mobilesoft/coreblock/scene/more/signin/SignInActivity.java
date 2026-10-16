package cz.mobilesoft.coreblock.scene.more.signin;

import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.facebook.CallbackManager;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SignInActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f110366h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f110367i = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f110368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f110369g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.l0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SignInActivity.p0();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, SignInConfig signInConfig) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(signInConfig, "signInConfig");
            Intent intent = new Intent(context, (Class<?>) SignInActivity.class);
            intent.putExtra("SIGN_IN_CONFIG", signInConfig);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(SignInActivity signInActivity, boolean z2) {
        if (z2) {
            signInActivity.setResult(-1);
        }
        signInActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(SignInActivity signInActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        signInActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallbackManager p0() {
        return CallbackManager.Factory.create();
    }

    private final CallbackManager q0() {
        return (CallbackManager) this.f110369g.getValue();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(1616870321);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1616870321, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.SignInActivity.RootCompose (SignInActivity.kt:33)");
            }
            Serializable serializableExtra = getIntent().getSerializableExtra("SIGN_IN_CONFIG");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.more.signin.SignInConfig");
            SignInConfig signInConfig = (SignInConfig) serializableExtra;
            CallbackManager callbackManagerQ0 = q0();
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.m0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SignInActivity.n0(this.f110713a, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG);
            }
            SignInContentKt.R(null, signInConfig, callbackManagerQ0, (Function1) objG, null, composerK, 0, 17);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SignInActivity.o0(this.f110725a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f110368f;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        q0().onActivityResult(i3, i4, intent);
        super.onActivityResult(i3, i4, intent);
    }
}
