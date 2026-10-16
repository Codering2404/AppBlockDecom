package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.SdkConfigurationStateKt;
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
public final class CustomerCenterActivity extends ComponentActivity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_WAS_LAUNCHED_THROUGH_SDK = "was_launched_through_sdk";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent createIntent$revenuecatui_defaultsBc8Release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) CustomerCenterActivity.class);
            intent.putExtra(CustomerCenterActivity.EXTRA_WAS_LAUNCHED_THROUGH_SDK, true);
            return intent;
        }

        private Companion() {
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SdkConfigurationStateKt.restoreSdkConfigurationIfNeeded(this, bundle);
        if (getIntent().getBooleanExtra(EXTRA_WAS_LAUNCHED_THROUGH_SDK, false) || Purchases.Companion.isConfigured()) {
            ComponentActivityKt.b(this, null, ComposableLambdaKt.c(2072096008, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterActivity.onCreate.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer, int i3) {
                    if ((i3 & 3) == 2 && composer.l()) {
                        composer.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(2072096008, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterActivity.onCreate.<anonymous> (CustomerCenterActivity.kt:46)");
                    }
                    ColorScheme colorSchemeE = DarkThemeKt.a(composer, 0) ? ColorSchemeKt.e(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null) : ColorSchemeKt.k(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
                    final CustomerCenterActivity customerCenterActivity = CustomerCenterActivity.this;
                    MaterialThemeKt.b(colorSchemeE, null, null, ComposableLambdaKt.e(1428363188, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterActivity.onCreate.1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer2, int i4) {
                            if ((i4 & 3) == 2 && composer2.l()) {
                                composer2.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(1428363188, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterActivity.onCreate.<anonymous>.<anonymous> (CustomerCenterActivity.kt:52)");
                            }
                            Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
                            composer2.a0(1948489528);
                            boolean Z = composer2.Z(customerCenterActivity);
                            final CustomerCenterActivity customerCenterActivity2 = customerCenterActivity;
                            Object objG = composer2.G();
                            if (Z || objG == Composer.f23746a.a()) {
                                objG = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterActivity$onCreate$1$1$1$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m951invoke();
                                        return Unit.f139807a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m951invoke() {
                                        customerCenterActivity2.setResult(-1);
                                        customerCenterActivity2.finish();
                                    }
                                };
                                composer2.w(objG);
                            }
                            composer2.U();
                            CustomerCenterKt.CustomerCenter(modifierF, null, (Function0) objG, composer2, 6, 2);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer, 54), composer, 3072, 6);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }), 1, null);
        } else {
            Logger.INSTANCE.e("CustomerCenterActivity was launched incorrectly. Please use ShowCustomerCenter activity result contract, CustomerCenter composable, or CustomerCenterView to display the Customer Center.");
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        SdkConfigurationStateKt.saveSdkConfiguration(outState);
        super.onSaveInstanceState(outState);
    }
}
