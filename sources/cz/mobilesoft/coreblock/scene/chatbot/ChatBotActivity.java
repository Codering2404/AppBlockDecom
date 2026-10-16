package cz.mobilesoft.coreblock.scene.chatbot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.scene.chatbot.ChatBotActivity;
import cz.mobilesoft.coreblock.scene.chatbot.chatbot.ChatBotScreenKt;
import cz.mobilesoft.coreblock.scene.chatbot.intro.IntroChatBotScreenKt;
import cz.mobilesoft.coreblock.scene.chatbot.intro.IntroChatBotViewModel;
import cz.mobilesoft.coreblock.scene.chatbot.intro.IntroChatBotViewState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.scope.Scope;

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
public final class ChatBotActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f99024h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f99025i = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f99026f = LazyKt.b(new Function0() { // from class: s0.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ChatBotActivity.y0(this.f147408a);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f99027g = LazyKt.b(new Function0() { // from class: s0.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ChatBotActivity.x0(this.f147409a);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, String entrances, ContactReason contactReason) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(entrances, "entrances");
            Intrinsics.checkNotNullParameter(contactReason, "contactReason");
            Intent intent = new Intent(context, (Class<?>) ChatBotActivity.class);
            intent.putExtra("EVENT_ENTRANCES", entrances);
            intent.putExtra("SELECTED_CONTACT_REASON", contactReason);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(final NavHostController navHostController, final ChatBotActivity chatBotActivity, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(987706630, true, new Function4() { // from class: s0.e
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ChatBotActivity.t0(navHostController, chatBotActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavIntroChatBot.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(-871806033, true, new Function4() { // from class: s0.f
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ChatBotActivity.v0(navHostController, chatBotActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavChatBot.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(NavHostController navHostController, final ChatBotActivity chatBotActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(987706630, i3, -1, "cz.mobilesoft.coreblock.scene.chatbot.ChatBotActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (ChatBotActivity.kt:57)");
        }
        composer.F(-101221098);
        ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composer, 8);
        if (viewModelStoreOwnerC == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
        }
        CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composer, 8);
        Scope scopeD = GlobalContext.f145907a.get().j().d();
        composer.F(-1072256281);
        CreationExtras creationExtrasA2 = null;
        NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
        if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
            creationExtrasA2 = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
        }
        KClass kClassB = Reflection.b(IntroChatBotViewModel.class);
        ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
        ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
        composer.Y();
        composer.Y();
        IntroChatBotViewState introChatBotViewState = (IntroChatBotViewState) FlowExtKt.m((BaseStatefulViewModel) viewModelA, composer, 0);
        boolean zI = composer.I(chatBotActivity);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: s0.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ChatBotActivity.u0(this.f147419a);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        String strA0 = chatBotActivity.A0();
        ContactReason contactReasonZ0 = chatBotActivity.z0();
        if (contactReasonZ0 == null) {
            contactReasonZ0 = ContactReason.ProblemsWithBlocking;
        }
        IntroChatBotScreenKt.h(navHostController, introChatBotViewState, function0, strA0, contactReasonZ0, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(ChatBotActivity chatBotActivity) {
        AnswersHelper.f128199a.p1();
        chatBotActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(NavHostController navHostController, ChatBotActivity chatBotActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-871806033, i3, -1, "cz.mobilesoft.coreblock.scene.chatbot.ChatBotActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (ChatBotActivity.kt:69)");
        }
        String strA0 = chatBotActivity.A0();
        ContactReason contactReasonZ0 = chatBotActivity.z0();
        if (contactReasonZ0 == null) {
            contactReasonZ0 = ContactReason.ProblemsWithBlocking;
        }
        ChatBotScreenKt.h(navHostController, strA0, contactReasonZ0, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(ChatBotActivity chatBotActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        chatBotActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactReason x0(ChatBotActivity chatBotActivity) {
        return (ContactReason) chatBotActivity.getIntent().getSerializableExtra("SELECTED_CONTACT_REASON");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String y0(ChatBotActivity chatBotActivity) {
        String stringExtra = chatBotActivity.getIntent().getStringExtra("EVENT_ENTRANCES");
        return stringExtra == null ? "" : stringExtra;
    }

    public final String A0() {
        return (String) this.f99026f.getValue();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-1637721625);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1637721625, i4, -1, "cz.mobilesoft.coreblock.scene.chatbot.ChatBotActivity.RootCompose (ChatBotActivity.kt:50)");
            }
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            NavIntroChatBot navIntroChatBot = NavIntroChatBot.INSTANCE;
            boolean zI = composerK.I(navHostControllerB) | composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: s0.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatBotActivity.s0(navHostControllerB, this, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            NavHostKt.u(navHostControllerB, navIntroChatBot, null, null, null, null, null, null, null, null, null, (Function1) objG, composer2, 0, 0, 2044);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: s0.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatBotActivity.w0(this.f147412a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final ContactReason z0() {
        return (ContactReason) this.f99027g.getValue();
    }
}
